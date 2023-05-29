package com.chic.qh.service.enquiry.impl;

import com.chic.qh.repository.model.EnquiryOrderGoods;
import com.chic.qh.repository.model.EnquiryOrderInfo;
import com.chic.qh.repository.EnquiryOrderGoodsRepository;
import com.chic.qh.repository.EnquiryOrderInfoRepository;
import com.chic.qh.service.enquiry.EnquiryService;
import com.chic.qh.service.enquiry.dto.*;
import com.chic.qh.service.enquiry.vo.EnquiryOrderGoodsVO;
import com.chic.qh.service.enquiry.vo.EnquiryOrderListVO;
import com.chic.qh.service.enquiry.vo.EnquiryOrderVO;
import com.chic.qh.service.goods.GoodsService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
    @Autowired
    private GoodsService goodsService;

    @Override
    public EnquiryOrderListVO queryList(EnquiryOrderQueryDTO dto) {
        dto.setEnquiryOrderName(StringUtils.isBlank(dto.getEnquiryOrderName()) ? null : "%" + dto.getEnquiryOrderName().trim() + "%");
        dto.setCustomerInfo(StringUtils.isBlank(dto.getCustomerInfo()) ? null : "%" + dto.getCustomerInfo().trim() + "%");
        PageInfo<EnquiryOrderInfo> enquiryOrderInfoPage = enquiryOrderInfoRepository.queryPagedList(dto);
        //build vo
        List<EnquiryOrderVO> orderVOList = buildListVO(enquiryOrderInfoPage.getList());
        return new EnquiryOrderListVO(enquiryOrderInfoPage.getTotal(), orderVOList);
    }

    private List<EnquiryOrderVO> buildListVO(List<EnquiryOrderInfo> orderInfoList){
        List<EnquiryOrderVO> orderVOList = new ArrayList<>();
        for (EnquiryOrderInfo orderInfo : orderInfoList) {
            EnquiryOrderVO orderVO = buildVO(orderInfo);
            orderVOList.add(orderVO);
        }
        return orderVOList;
    }

    private EnquiryOrderVO buildVO(EnquiryOrderInfo orderInfo) {
        EnquiryOrderVO orderVO = new EnquiryOrderVO();
        BeanUtils.copyProperties(orderInfo, orderVO);
        List<EnquiryOrderGoods> orderGoodsList = enquiryOrderGoodsRepository.queryOrderGoodsList(orderInfo.getEnquiryOrderId());
        List<EnquiryOrderGoods> enquiryOrderGoodsList = new ArrayList<>(orderGoodsList.size());
        //确保未关联的商品在前面
        //未关联的
        List<EnquiryOrderGoods> unRelationOrderGoodsList = orderGoodsList.stream().filter(x -> x.getRelationType().equals((byte) 0)).collect(Collectors.toList());
        enquiryOrderGoodsList.addAll(unRelationOrderGoodsList);
        //已关联的
        enquiryOrderGoodsList.addAll(orderGoodsList.stream().filter(x -> !x.getRelationType().equals((byte) 0)).collect(Collectors.toList()));
        List<EnquiryOrderGoodsVO> orderGoodsVOList = new ArrayList<>(enquiryOrderGoodsList.size());
        enquiryOrderGoodsList.forEach(x -> {
            EnquiryOrderGoodsVO orderGoodsVO = new EnquiryOrderGoodsVO();
            BeanUtils.copyProperties(x, orderGoodsVO);
            orderGoodsVOList.add(orderGoodsVO);
        });
        orderVO.setOrderGoodsList(orderGoodsVOList);
        orderVO.setUnRelationGoodsNum(unRelationOrderGoodsList.size());
        return orderVO;
    }

    @Override
    public EnquiryOrderVO queryDetailById(Integer enquiryOrderId) {
        EnquiryOrderInfo enquiryOrderInfo = enquiryOrderInfoRepository.queryById(enquiryOrderId);
        if(enquiryOrderInfo == null){
            throw new RuntimeException("询价单找不到！id:" + enquiryOrderId);
        }
        EnquiryOrderVO orderVO = buildVO(enquiryOrderInfo);
        return orderVO;
    }

    @Override
    public int deleteEnquiryOrders(List<Integer> ids) {
        return enquiryOrderInfoRepository.deleteEnquiryOrders(ids);
    }

    private OrderSnGenerator enquiryOrderSnGen = new OrderSnGenerator();
    @Override
    public void addEnquiryOrder(EnquiryOrderAddDTO dto) {
        EnquiryOrderInfo orderInfo = new EnquiryOrderInfo();
        BeanUtils.copyProperties(dto, orderInfo);
        orderInfo.setEnquiryOrderSn(enquiryOrderSnGen.get());
        orderInfo.setGmtCreated((int)Instant.now().getEpochSecond());
        enquiryOrderInfoRepository.saveEnquiryOrder(orderInfo);

        List<EnquiryOrderAddDTO.EnquiryOrderGoodsDTO> goodsList = dto.getGoodsList();
        //添加询价单的时候，商品列表可以为空，后续慢慢添加商品
        if(!CollectionUtils.isEmpty(goodsList)){
            List<EnquiryOrderGoods> orderGoodsList = new ArrayList<>(goodsList.size());
            goodsList.forEach(x->{
                EnquiryOrderGoods orderGoods = new EnquiryOrderGoods();
                BeanUtils.copyProperties(x, orderGoods);
                orderGoods.setGmtCreated((int)Instant.now().getEpochSecond());
                orderGoods.setEnquiryOrderId(orderInfo.getEnquiryOrderId());
                orderGoodsList.add(orderGoods);
            });
            enquiryOrderGoodsRepository.saveBatch(orderGoodsList);
        }
    }

    @Override
    public void addEnquiryOrderGoods(EnquiryOrderGoodsAddDTO dto) {
        EnquiryOrderGoods orderGoods = new EnquiryOrderGoods();
        BeanUtils.copyProperties(dto, orderGoods);
        orderGoods.setGmtCreated((int)Instant.now().getEpochSecond());
        enquiryOrderGoodsRepository.saveEnquiryOrderGoods(orderGoods);
    }

    @Override
    public void deleteEnquiryOrderGoods(EnquiryOrderGoodsDeleteDTO dto) {
        enquiryOrderGoodsRepository.deleteByPrimaryKey(dto.getRecId());
    }

    @Override
    public void updateGoodsSn(EnquiryOrderUpdateDTO dto) {
        String goodsSn = dto.getGoodsSn();
        Assert.hasText(goodsSn,"商品sn不能为空");
        if(goodsService.getGoodsPOBySn(goodsSn) == null){
            throw new NoSuchElementException("无效的goodsSn:" + goodsSn);
        }

        EnquiryOrderGoods orderGoods = new EnquiryOrderGoods();
        orderGoods.setRecId(dto.getRecId());
        orderGoods.setGoodsSn(dto.getGoodsSn());
        orderGoods.setRelationType(dto.getRelationType());
        orderGoods.setGmtModify((int)Instant.now().getEpochSecond());
        enquiryOrderGoodsRepository.updateSelectiveByPrimaryKey(orderGoods);
    }
}
