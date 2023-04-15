package com.chic.qh.controller.enquiry;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class InquiryController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final String LIST_RESP_JSON = "[" +
            "{ name: 'Key-product', customer: '客户A 联系电话：13867623527', createdAt: '2023-04-03' }," +
            "{ name: 'Precheck', customer: '客户B QQ：456321', createdAt: '2023-04-01' }" +
            "]";

    @GetMapping("/api/inquiry")
    public ResponseEntity listInquiry(InquiryListReq req){
        logger.debug("========"+req.getPageSize());
        return ResponseEntity.ok(RespBuilder.builder()
                .put("total", 10)
                .put("success", true)
                .put("pageSize",10)
                .put("current", 1)
                .put("data", JSON.parseArray(LIST_RESP_JSON))
                .get());
    }

    public static class RespBuilder{

        public static RespBuilder builder(){
            return new RespBuilder();
        }

        Map<String,Object> map = new HashMap<>();

        public RespBuilder put(String key, Object value){
            map.put(key, value);
            return this;
        }

        public Map get(){
            return map;
        }
    }
}
