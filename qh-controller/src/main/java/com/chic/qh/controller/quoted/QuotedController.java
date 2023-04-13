package com.chic.qh.controller.quoted;

import com.chic.qh.result.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 报价
 * @author: xumingwei
 * @date: 2023—04—07 14:30
 */
@RestController
@RequestMapping("/quoted")
public class QuotedController {

    @PostMapping("/list")
    public ResponseEntity list() {


        return ResponseEntity.ok("quoted");
    }

}
