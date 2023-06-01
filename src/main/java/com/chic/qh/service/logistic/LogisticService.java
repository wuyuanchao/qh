package com.chic.qh.service.logistic;

import com.chic.qh.controller.logistic.LogisticConfigDTO;
import com.chic.qh.repository.model.LogisticChannel;
import com.github.pagehelper.Page;

import java.util.List;

public interface LogisticService {
    Page<LogisticChannel> getChannelList(String company, String code, Integer pageNum, Integer pageSize);

    void addChannel(LogisticChannel logisticChannel);

    List<LogisticConfigDTO> getChannelDetail(Integer channelId);

    int deleteChannel(Integer channelId);

    int updateChannel(LogisticChannel logisticChannel);
}
