package com.chic.qh.service.settle.impl;

import com.chic.qh.repository.GoodsRepository;
import com.chic.qh.repository.SettleOrderDetailRepository;
import com.chic.qh.repository.SettleOrderInfoRepository;
import com.chic.qh.repository.SkuRelationRepository;
import com.chic.qh.repository.mapper.LogisticChannelMapper;
import com.chic.qh.repository.model.*;
import com.chic.qh.service.logistic.LogisticService;
import com.chic.qh.service.quote.QuoteService;
import com.chic.qh.service.settle.SettleOrderService;
import com.chic.qh.service.settle.dto.SettleOrderDetailExcelVO;
import com.chic.qh.service.settle.dto.SettleOrderQueryDTO;
import com.chic.qh.service.settle.vo.SettleOrderListVO;
import com.chic.qh.support.utils.DateUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 结算单
 * @author: Carney
 * @date: 2023-09-17 15:55
 */
@Slf4j
@Service
@Transactional
public class SettleOrderServiceImpl implements SettleOrderService {

    @Autowired
    private SettleOrderInfoRepository settleOrderInfoRepository;
    @Autowired
    private SettleOrderDetailRepository settleOrderDetailRepository;
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private SkuRelationRepository skuRelationRepository;
    @Autowired
    private QuoteService quoteService;
    @Autowired
    private LogisticService logisticService;

    @Override
    public void createSettleOrder(List<OrderInfo> orderInfoList) {
        Integer currentSecond = DateUtils.getCurrentSecond();
        List<SettleOrderDetail> settleOrderDetailList = new ArrayList<>();
        BigDecimal totalAmount = BigDecimal.ZERO;
        orderInfoList.forEach(orderInfo -> {
            GoodsQuoteDetail quoteDetail = getQuoteDetail(orderInfo);

            SettleOrderDetail settleOrderDetail = new SettleOrderDetail();
            settleOrderDetail.setOrderId(orderInfo.getOrderId());
            settleOrderDetail.setOrderSn(orderInfo.getOrderSn());
            settleOrderDetail.setQuantity(orderInfo.getQuantity());
            settleOrderDetail.setSku(orderInfo.getSku());
            //匹配不到sku时，价格为空
            settleOrderDetail.setSkuId(0);
            settleOrderDetail.setAmount(BigDecimal.ZERO);
            settleOrderDetail.setQuoteId(0);
            if(quoteDetail != null) {
                settleOrderDetail.setSkuId(quoteDetail.getSkuId());
                settleOrderDetail.setAmount(quoteDetail.getAmount());
                settleOrderDetail.setQuoteId(quoteDetail.getQuoteId());
            }
            settleOrderDetail.setGmtCreated(currentSecond);
            settleOrderDetailList.add(settleOrderDetail);
        });

        SettleOrderInfo settleOrderInfo = new SettleOrderInfo();
        settleOrderInfo.setSettleOrderSn(SettleOrderSnGenerator.get());
        settleOrderInfo.setTotalAmount(totalAmount);
        settleOrderInfo.setGmtCreated(currentSecond);
        settleOrderInfo.setGmtModify(currentSecond);
        settleOrderInfoRepository.insertSelective(settleOrderInfo);

        settleOrderDetailList.forEach(x->x.setSettleOrderId(settleOrderInfo.getSettleOrderId()));
        Lists.partition(settleOrderDetailList, 500).forEach(x->settleOrderDetailRepository.insertMultiple(x));
    }

    /**
     * 获取订单报价
     * @param orderInfo
     * @return
     */
    private GoodsQuoteDetail getQuoteDetail(OrderInfo orderInfo){
        SkuRelation skuRelation = skuRelationRepository.getSkuByDxmSkuId(orderInfo.getDxmProductCode());
        if(skuRelation == null){
            log.error("找不到该店小蜜sku！orderSn:{}, 店小蜜sku:{}", orderInfo.getOrderSn(), orderInfo.getDxmProductCode());
            return null;
        }
        if(skuRelation.getParentId() > 0){
            skuRelation = skuRelationRepository.getSku(skuRelation.getParentId());
            if(skuRelation == null) {
                throw new RuntimeException("找不到父SKU！orderSn:" + orderInfo.getOrderSn() + ", skuId: " + skuRelation.getSkuId() + ", 店小蜜sku:" + orderInfo.getDxmProductCode());
            }
        }
        Goods goods = goodsRepository.getGoods(skuRelation.getGoodsId());
        if(goods == null){
            throw new RuntimeException("找不到商品！orderSn:" + orderInfo.getOrderSn() + ", goodsId: " + skuRelation.getGoodsId() + ", 店小蜜sku:" + orderInfo.getDxmProductCode());
        }
        GoodsQuote goodsQuote = quoteService.getQuoteVersion(goods.getGoodsId(), orderInfo.getOrderTime());
        if(goodsQuote == null){
            throw new RuntimeException("找不到商品可用报价！orderSn:" + orderInfo.getOrderSn() + ", goodsId: " + skuRelation.getGoodsId() + ", 店小蜜sku:" + orderInfo.getDxmProductCode());
        }
        String shippingMethod = orderInfo.getShippingMethod();
        LogisticChannel channel = logisticService.getByName(shippingMethod);
        if(channel == null){
            throw new RuntimeException("找不到商品渠道配置！orderSn:" + orderInfo.getOrderSn()
                    + ", goodsId: " + skuRelation.getGoodsId()
                    + ", 店小蜜sku:" + orderInfo.getDxmProductCode()
                    + ", shippingMethod:" + shippingMethod);
        }
        return quoteService.getQuoteDetails(skuRelation.getSkuId(),
                orderInfo.getCountryCode(),
                orderInfo.getQuantity(),
                channel.getCode(),
                goodsQuote.getRecId());
    }

    @Override
    public SettleOrderListVO queryPagedList(SettleOrderQueryDTO dto) {
        dto.setSettleOrderSn(StringUtils.isBlank(dto.getSettleOrderSn()) ? null : dto.getSettleOrderSn());
        PageInfo<SettleOrderInfo> settleOrderInfoPageInfo = settleOrderInfoRepository.queryPagedList(dto);
        return new SettleOrderListVO(settleOrderInfoPageInfo.getTotal(), settleOrderInfoPageInfo.getList());
    }

    @Override
    public List<SettleOrderDetailExcelVO> exportSettleOrderDetailList(Integer settleOrderId) {
        SettleOrderInfo settleOrderInfo = settleOrderInfoRepository.queryBySettleOrderId(settleOrderId);
        if(settleOrderInfo == null){
            throw new RuntimeException("结算单找不到! settleOrderId:" +settleOrderId);
        }
        List<SettleOrderDetail> settleOrderDetailList = settleOrderDetailRepository.queryListBySettleOrderId(settleOrderId);
        return settleOrderDetailList.stream().map(settleOrderDetail->{
            SettleOrderDetailExcelVO excelVO = new SettleOrderDetailExcelVO();
            BeanUtils.copyProperties(settleOrderDetail, excelVO);
            excelVO.setSettleOrderSn(settleOrderInfo.getSettleOrderSn());
            excelVO.setGmtCreatedStr(DateUtils.getFormatTime(settleOrderDetail.getGmtCreated(), DateUtils.DATE_SMALL_STR));
            return excelVO;
        }).collect(Collectors.toList());
    }
}
