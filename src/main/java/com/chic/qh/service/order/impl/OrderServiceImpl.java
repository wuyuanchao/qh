package com.chic.qh.service.order.impl;

import com.chic.qh.repository.OrderInfoRepository;
import com.chic.qh.repository.model.OrderInfo;
import com.chic.qh.service.order.OrderService;
import com.chic.qh.service.order.dto.OrderEditDTO;
import com.chic.qh.service.order.dto.OrderImportDTO;
import com.chic.qh.service.order.dto.OrderQueryDTO;
import com.chic.qh.service.order.vo.OrderListVO;
import com.chic.qh.support.utils.DateUtils;
import com.chic.qh.support.utils.ExcelUtils;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—08—17 15:59
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Override
    public OrderListVO queryPagedList(OrderQueryDTO dto) {
        dto.setOrderSn(StringUtils.isBlank(dto.getOrderSn()) ? null : dto.getOrderSn());
        dto.setTrackingNumber(StringUtils.isBlank(dto.getTrackingNumber()) ? null : dto.getTrackingNumber());
        dto.setTrackingNumber2(StringUtils.isBlank(dto.getTrackingNumber2()) ? null : dto.getTrackingNumber2());
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

        List<OrderInfo> orderInfoList = new ArrayList<>();
        excelList.forEach(orderImportDTO -> {
            OrderInfo orderInfo = new OrderInfo();
            BeanUtils.copyProperties(orderImportDTO, orderInfo);
            orderInfo.setStatus((byte)1);
            orderInfo.setGmtCreated((int) Instant.now().getEpochSecond());
            orderInfo.setGmtModify((int) Instant.now().getEpochSecond());
            orderInfoList.add(orderInfo);
        });

        List<List<OrderInfo>> orderLists = ListUtils.partition(orderInfoList, 200);
        orderLists.forEach(orderList->{
            orderInfoRepository.insertMultiple(orderList);
        });

    }

    @Override
    public void updateStatus(OrderEditDTO dto) {
        orderInfoRepository.updateStatus(dto.getOrderId(), dto.getStatus());
    }
}
