package com.chic.qh.controller.logistic;

import com.chic.qh.repository.model.LogisticChannel;
import com.chic.qh.service.logistic.LogisticService;
import com.chic.qh.support.web.RespWrap;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.List;

@RestController
@RequestMapping("logistic")
public class LogisticController {

    @Autowired
    private LogisticService logisticService;

    @RespWrap
    @GetMapping("getChannelList")
    public Page<LogisticChannel> getChannelList(@RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestParam(defaultValue = "20") Integer pageSize) {
        return logisticService.getChannelList(pageNum, pageSize);
    }

    @RespWrap
    @PostMapping("addChannel")
    public void addChannel(@RequestBody LogisticChannel logisticChannel) {
        logisticService.addChannel(logisticChannel);
    }

    @RespWrap
    @GetMapping("getChannelDetail/{channelId}")
    public List<LogisticConfigDTO> getChannelDetail(@PathVariable("channelId") Integer channelId){
        return logisticService.getChannelDetail(channelId);
    }
}
