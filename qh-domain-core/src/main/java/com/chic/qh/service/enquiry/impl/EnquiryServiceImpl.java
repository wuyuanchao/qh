package com.chic.qh.service.enquiry.impl;

import com.chic.qh.domain.dal.model.EnquiryOrderGoods;
import com.chic.qh.domain.dal.model.EnquiryOrderInfo;
import com.chic.qh.repository.EnquiryOrderGoodsRepository;
import com.chic.qh.repository.EnquiryOrderInfoRepository;
import com.chic.qh.service.enquiry.EnquiryService;
import com.chic.qh.service.enquiry.dto.*;
import com.chic.qh.service.enquiry.vo.EnquiryOrderGoodsVO;
import com.chic.qh.service.enquiry.vo.EnquiryOrderListVO;
import com.chic.qh.service.enquiry.vo.EnquiryOrderVO;
import com.chic.qh.utils.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 询价
 * @author: xumingwei
 * @date: 2023—04—07 14:49
 */
@Service
@Transactional
public class EnquiryServiceImpl implements EnquiryService {

    @Autowired
    private EnquiryOrderInfoRepository enquiryOrderInfoRepository;
    @Autowired
    private EnquiryOrderGoodsRepository enquiryOrderGoodsRepository;

    @Override
    public EnquiryOrderListVO queryList(EnquiryOrderQueryDTO dto) {
        PageInfo<EnquiryOrderInfo> enquiryOrderInfoPage = enquiryOrderInfoRepository.queryPagedList(dto);
        //build vo
        List<EnquiryOrderVO> orderVOList = buildVO(enquiryOrderInfoPage.getList());
        return new EnquiryOrderListVO(enquiryOrderInfoPage.getTotal(), orderVOList);
    }

    private List<EnquiryOrderVO> buildVO(List<EnquiryOrderInfo> orderInfoList){
        List<EnquiryOrderVO> orderVOList = new ArrayList<>();
        for (EnquiryOrderInfo orderInfo : orderInfoList) {
            EnquiryOrderVO orderVO = new EnquiryOrderVO();
            BeanUtils.copyProperties(orderInfo, orderVO);

            List<EnquiryOrderGoods> orderGoodsList = enquiryOrderGoodsRepository.queryOrderGoodsList(orderInfo.getEnquiryOrderId());
            List<EnquiryOrderGoodsVO> orderGoodsVOList = new ArrayList<>(orderGoodsList.size());
            orderGoodsList.forEach(x->{
                EnquiryOrderGoodsVO orderGoodsVO = new EnquiryOrderGoodsVO();
                BeanUtils.copyProperties(x, orderGoodsVO);
                orderGoodsVOList.add(orderGoodsVO);
            });
            orderVO.setOrderGoodsList(orderGoodsVOList);

            orderVOList.add(orderVO);
        }
        return orderVOList;
    }

    @Override
    public void addEnquiryOrder(EnquiryOrderAddDTO dto) {
        EnquiryOrderInfo orderInfo = new EnquiryOrderInfo();
        BeanUtils.copyProperties(dto, orderInfo);
        orderInfo.setGmtCreated(DateUtils.getCurrentSecond());

        List<EnquiryOrderAddDTO.EnquiryOrderGoodsDTO> goodsList = dto.getGoodsList();
        if(CollectionUtils.isEmpty(goodsList)){
            throw new RuntimeException("询价单至少需要包含一款商品");
        }
        List<EnquiryOrderGoods> orderGoodsList = new ArrayList<>(goodsList.size());
        goodsList.forEach(x->{
            EnquiryOrderGoods orderGoods = new EnquiryOrderGoods();
            BeanUtils.copyProperties(x, orderGoods);
            orderGoods.setGmtCreated(DateUtils.getCurrentSecond());
            orderGoodsList.add(orderGoods);
        });
        enquiryOrderInfoRepository.saveEnquiryOrder(orderInfo);
        orderGoodsList.forEach(x->{
            x.setEnquiryOrderId(orderInfo.getEnquiryOrderId());
            enquiryOrderGoodsRepository.saveEnquiryOrderGoods(x);
        });
    }

    @Override
    public void addEnquiryOrderGoods(EnquiryOrderGoodsAddDTO dto) {
        EnquiryOrderGoods orderGoods = new EnquiryOrderGoods();
        BeanUtils.copyProperties(dto, orderGoods);
        enquiryOrderGoodsRepository.saveEnquiryOrderGoods(orderGoods);
    }

    @Override
    public void deleteEnquiryOrderGoods(EnquiryOrderGoodsDeleteDTO dto) {
        enquiryOrderGoodsRepository.deleteByPrimaryKey(dto.getRecId());
    }

    @Override
    public void updateGoodsSn(EnquiryOrderUpdateDTO dto) {
        EnquiryOrderGoods orderGoods = new EnquiryOrderGoods();
        orderGoods.setRecId(dto.getRecId());
        orderGoods.setGoodsSn(dto.getGoodsSn());
        orderGoods.setRelationType(dto.getRelationType());
        orderGoods.setGmtModify(DateUtils.getCurrentSecond());
        enquiryOrderGoodsRepository.updateSelectiveByPrimaryKey(orderGoods);
    }
}
