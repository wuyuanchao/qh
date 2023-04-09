package com.chic.qh.domain.core.service.enquiry.impl;

import com.chic.qh.domain.core.domain.enquiry.EnquiryOrderGoods;
import com.chic.qh.domain.core.domain.enquiry.EnquiryOrderInfo;
import com.chic.qh.domain.core.repository.EnquiryRepository;
import com.chic.qh.domain.core.service.enquiry.EnquiryService;
import com.chic.qh.domain.core.service.enquiry.dto.*;
import com.chic.qh.domain.core.service.enquiry.vo.EnquiryOrderGoodsVO;
import com.chic.qh.domain.core.service.enquiry.vo.EnquiryOrderListVO;
import com.chic.qh.domain.core.service.enquiry.vo.EnquiryOrderVO;
import com.chic.qh.domain.core.utils.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 询价
 * @author: xumingwei
 * @date: 2023—04—07 14:49
 */
@Service
public class EnquiryServiceImpl implements EnquiryService {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @Override
    public EnquiryOrderListVO queryList(EnquiryOrderQueryDTO dto) {
        Integer count = enquiryRepository.queryCount(dto);
        List<EnquiryOrderInfo> orderInfoList = enquiryRepository.queryList(dto);
        //build vo
        List<EnquiryOrderVO> orderVOList = buildVO(orderInfoList);
        return new EnquiryOrderListVO(count, orderVOList);
    }

    private List<EnquiryOrderVO> buildVO(List<EnquiryOrderInfo> orderInfoList){
        List<EnquiryOrderVO> orderVOList = new ArrayList<>();
        for (EnquiryOrderInfo orderInfo : orderInfoList) {
            EnquiryOrderVO orderVO = new EnquiryOrderVO();
            BeanUtils.copyProperties(orderInfo, orderVO);

            List<EnquiryOrderGoods> orderGoodsList = enquiryRepository.queryOrderGoodsList(orderInfo.getEnquiryOrderId());
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
        orderInfo.setEnquiryOrderId(DateUtils.getCurrentSecond() + (int)(Math.random() * 1000));
        orderInfo.setAddTime(DateUtils.getCurrentSecond());

        List<EnquiryOrderAddDTO.EnquiryOrderGoodsDTO> goodsList = dto.getGoodsList();
        if(CollectionUtils.isEmpty(goodsList)){
            throw new RuntimeException("询价单至少需要包含一款商品");
        }
        List<EnquiryOrderGoods> orderGoodsList = new ArrayList<>(goodsList.size());
        goodsList.forEach(x->{
            EnquiryOrderGoods orderGoods = new EnquiryOrderGoods();
            BeanUtils.copyProperties(x, orderGoods);
            orderGoods.setEnquiryOrderId(orderInfo.getEnquiryOrderId());
            
            orderGoods.setEnquiryOrderGoodsId(DateUtils.getCurrentSecond() + (int)(Math.random() * 1000));

            orderGoodsList.add(orderGoods);
        });
        enquiryRepository.addEnquiryOrder(orderInfo, orderGoodsList);
    }

    @Override
    public void addEnquiryOrderGoods(EnquiryOrderGoodsAddDTO dto) {
        EnquiryOrderGoods orderGoods = new EnquiryOrderGoods();
        BeanUtils.copyProperties(dto, orderGoods);
        orderGoods.setEnquiryOrderGoodsId(DateUtils.getCurrentSecond());
        enquiryRepository.addEnquiryOrderGoods(orderGoods);
    }

    @Override
    public void deleteEnquiryOrderGoods(EnquiryOrderGoodsDeleteDTO dto) {
        enquiryRepository.deleteEnquiryOrderGoods(dto);
    }

    @Override
    public void updateGoodsSn(EnquiryOrderUpdateDTO dto) {
        enquiryRepository.updateGoodsSn(dto);
    }
}
