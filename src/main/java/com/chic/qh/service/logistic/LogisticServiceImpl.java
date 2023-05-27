package com.chic.qh.service.logistic;

import com.chic.qh.repository.mapper.LogisticChannelDynamicSqlSupport;
import com.chic.qh.repository.mapper.LogisticChannelMapper;
import com.chic.qh.repository.model.LogisticChannel;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogisticServiceImpl implements LogisticService{

    @Autowired
    private LogisticChannelMapper logisticChannelMapper;
    @Override
    public Page<LogisticChannel> getChannelList(Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() ->
                logisticChannelMapper.select(c -> c.orderBy(LogisticChannelDynamicSqlSupport.recId.descending())));
    }
}
