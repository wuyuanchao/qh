package com.chic.qh.service.order;

import com.chic.qh.service.order.dto.OrderEditDTO;
import com.chic.qh.service.order.dto.OrderQueryDTO;
import com.chic.qh.service.order.vo.OrderListVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—08—17 15:58
 */
public interface OrderService {

    OrderListVO queryPagedList(OrderQueryDTO dto);

    void processOrderImport(MultipartFile file);

    void updateStatus(OrderEditDTO dto);

}
