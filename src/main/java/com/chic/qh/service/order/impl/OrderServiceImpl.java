package com.chic.qh.service.order.impl;

import com.chic.qh.repository.OrderInfoRepository;
import com.chic.qh.repository.model.OrderInfo;
import com.chic.qh.service.order.OrderService;
import com.chic.qh.service.order.dto.OrderEditDTO;
import com.chic.qh.service.order.dto.OrderImportDTO;
import com.chic.qh.service.order.dto.OrderQueryDTO;
import com.chic.qh.service.order.vo.OrderListVO;
import com.chic.qh.service.settle.SettleOrderService;
import com.chic.qh.support.utils.DateUtils;
import com.chic.qh.support.utils.ExcelUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—08—17 15:59
 */
@Slf4j
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoRepository orderInfoRepository;
    @Autowired
    private SettleOrderService settleOrderService;

    @Override
    public OrderListVO queryPagedList(OrderQueryDTO dto) {
        dto.setOrderSn(StringUtils.isBlank(dto.getOrderSn()) ? null : dto.getOrderSn());
        dto.setTrackingNumber(StringUtils.isBlank(dto.getTrackingNumber()) ? null : dto.getTrackingNumber());
        dto.setPhoneNumber(StringUtils.isBlank(dto.getPhoneNumber()) ? null : "%" + dto.getPhoneNumber() + "%");
        PageInfo<OrderInfo> orderInfoPageInfo = orderInfoRepository.queryPagedList(dto);
        return new OrderListVO(orderInfoPageInfo.getTotal(), orderInfoPageInfo.getList());
    }

    @Override
    public void processOrderImport(MultipartFile file) {
        List<OrderImportDTO> excelList = ExcelUtils.importExcel(file, OrderImportDTO.class, null);
        if (CollectionUtils.isEmpty(excelList)) {
            throw new RuntimeException("excel模版数据为空");
        }
        if(excelList.size() > 5000){
            throw new RuntimeException("单次导入数据最多5000条");
        }

        Integer currentTime = DateUtils.getCurrentSecond();
        List<OrderInfo> orderInfoList = excelList.stream().map(orderImportDTO -> {
            OrderInfo orderInfo = new OrderInfo();
            BeanUtils.copyProperties(orderImportDTO, orderInfo);
            orderInfo.setStatus((byte)1);
            if(StringUtils.isBlank(orderInfo.getTrackingNumber2())) {
                orderInfo.setTrackingNumber2(StringUtils.EMPTY);
            }
            orderInfo.setGmtCreated(currentTime);
            orderInfo.setGmtModify(currentTime);
            return orderInfo;
        }).collect(Collectors.toList());
        //保存订单
        Lists.partition(orderInfoList, 500).forEach(x->orderInfoRepository.insertMultiple(x));

        //生成账单
        settleOrderService.createSettleOrder(orderInfoList);
    }

    @Override
    public void updateStatus(OrderEditDTO dto) {
        orderInfoRepository.updateStatus(dto.getOrderId(), dto.getStatus());
    }
}
