package com.chic.qh.domain.core.repository;

import com.chic.qh.domain.core.domain.enquiry.EnquiryOrderGoods;
import com.chic.qh.domain.core.domain.enquiry.EnquiryOrderInfo;
import com.chic.qh.domain.core.service.enquiry.dto.EnquiryOrderGoodsDeleteDTO;
import com.chic.qh.domain.core.service.enquiry.dto.EnquiryOrderQueryDTO;
import com.chic.qh.domain.core.service.enquiry.dto.EnquiryOrderUpdateDTO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 14:53
 */
@Repository
public class EnquiryRepository {

    //模拟数据库询价单表
    private static ConcurrentMap<Integer, EnquiryOrderInfo> ORDER_INFO_MAP = new ConcurrentHashMap();
    private static ConcurrentMap<Integer, List<EnquiryOrderGoods>> ORDER_GOODS_MAP = new ConcurrentHashMap();

    public Integer queryCount(EnquiryOrderQueryDTO dto) {
        return ORDER_INFO_MAP.size();
    }

    public List<EnquiryOrderInfo> queryList(EnquiryOrderQueryDTO dto) {
        return new ArrayList<>(ORDER_INFO_MAP.values());
    }

    public void addEnquiryOrder(EnquiryOrderInfo orderInfo, List<EnquiryOrderGoods> orderGoodsList) {
        ORDER_INFO_MAP.put(orderInfo.getEnquiryOrderId(), orderInfo);
        ORDER_GOODS_MAP.put(orderInfo.getEnquiryOrderId(), orderGoodsList);
    }

    public void addEnquiryOrderGoods(EnquiryOrderGoods orderGoods) {
        List<EnquiryOrderGoods> orderGoodsList = ORDER_GOODS_MAP.get(orderGoods.getEnquiryOrderId());
        if(CollectionUtils.isEmpty(orderGoodsList)){
            orderGoodsList = new ArrayList<>();
        }
        orderGoodsList.add(orderGoods);
        ORDER_GOODS_MAP.put(orderGoods.getEnquiryOrderId(), orderGoodsList);
    }

    public void deleteEnquiryOrderGoods(EnquiryOrderGoodsDeleteDTO dto) {
        List<EnquiryOrderGoods> orderGoodsList = ORDER_GOODS_MAP.get(dto.getEnquiryOrderId());
        if(CollectionUtils.isEmpty(orderGoodsList)){
            return;
        }
        orderGoodsList = orderGoodsList.stream()
                .filter(x->!x.getEnquiryOrderGoodsId().equals(dto.getEnquiryOrderGoodsId()))
                .collect(Collectors.toList());
        ORDER_GOODS_MAP.put(dto.getEnquiryOrderId(), orderGoodsList);
    }

    public void updateGoodsSn(EnquiryOrderUpdateDTO dto) {
        List<EnquiryOrderGoods> orderGoodsList = ORDER_GOODS_MAP.get(dto.getEnquiryOrderId());
        if(CollectionUtils.isEmpty(orderGoodsList)){
            return;
        }
        for (EnquiryOrderGoods orderGoods : orderGoodsList) {
            if(orderGoods.getEnquiryOrderGoodsId().equals(dto.getEnquiryOrderGoodsId())){
                orderGoods.setGoodsSn(dto.getGoodsSn());
            }
        }
    }

    public List<EnquiryOrderGoods> queryOrderGoodsList(Integer enquiryOrderId) {
        List<EnquiryOrderGoods> orderGoodsList = ORDER_GOODS_MAP.get(enquiryOrderId);
        if(CollectionUtils.isEmpty(orderGoodsList)){
            return new ArrayList<>();
        }
        return orderGoodsList;
    }

}
