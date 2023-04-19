package com.chic.qh.controller.enquiry;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@RestController
public class InquiryController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String LIST_RESP_JSON = "[" +
            "{ id: 1,  name: 'Key-product', customer: '客户A 联系电话：13867623527', createdAt: '2023-04-03' }," +
            "{ id: 2, name: 'Precheck', customer: '客户B QQ：456321', createdAt: '2023-04-01' }" +
            "]";

    private static Map<Integer, Inquiry> data = JSON.parseArray(LIST_RESP_JSON, Inquiry.class).stream()
            .collect(Collectors.toMap(Inquiry::getId, Function.identity()));

    @GetMapping("/api/inquiry")
    public ResponseEntity listInquiry(InquiryListReq req){
        logger.debug("========"+req.getPageSize());
        return ResponseEntity.ok(RespBuilder.builder()
                .put("total", 10)
                .put("success", true)
                .put("pageSize",10)
                .put("current", 1)
                .put("data", data.values())
                .get());
    }

    @PostMapping("/api/inquiry")
    public ResponseEntity createInquiry(@RequestBody Inquiry inquiry){
        inquiry.setId( data.keySet().stream().max(Integer::compareTo).get() + 1);
        inquiry.setCreatedAt(Instant.now().toString());
        data.put(inquiry.getId(), inquiry);
        return ResponseEntity.ok(RespBuilder.builder().put("success", true).get());
    }

    @GetMapping("/api/inquiry/{name}")
    public ResponseEntity getInquiry(@PathVariable String name){
        return ResponseEntity.ok(data.values().stream()
                .filter(x -> x.getName().equals(name)).findFirst()
                .orElse(null));
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
