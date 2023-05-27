package com.chic.qh.service.logistic;

import com.chic.qh.repository.model.LogisticChannel;
import com.github.pagehelper.Page;

public interface LogisticService {
    Page<LogisticChannel> getChannelList(Integer pageNum, Integer pageSize);
}
