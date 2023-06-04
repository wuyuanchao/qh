package com.chic.qh.service.logistic;

import com.alibaba.fastjson.JSON;
import com.chic.qh.controller.logistic.LogisticConfigDTO;
import com.chic.qh.repository.mapper.LogisticChannelDynamicSqlSupport;
import com.chic.qh.repository.mapper.LogisticChannelMapper;
import com.chic.qh.repository.model.LogisticChannel;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogisticServiceImpl implements LogisticService{

    @Autowired
    private LogisticChannelMapper logisticChannelMapper;
    @Override
    public Page<LogisticChannel> getChannelList(String _company, String _code, Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() ->
                logisticChannelMapper.select(c -> c
                        .where(LogisticChannelDynamicSqlSupport.company, SqlBuilder.isEqualToWhenPresent(_company))
                        .and(LogisticChannelDynamicSqlSupport.code, SqlBuilder.isEqualToWhenPresent(_code))
                        .orderBy(LogisticChannelDynamicSqlSupport.recId.descending())));
    }

    @Override
    public void addChannel(LogisticChannel logisticChannel) {
        logisticChannelMapper.insert(logisticChannel);
    }

    @Override
    public List<LogisticConfigDTO> getChannelDetail(Integer channelId) {
        return JSON.parseArray(LogisticConfigDTO.JSON_MOCK_DATA, LogisticConfigDTO.class);
    }

    @Override
    public int deleteChannel(Integer channelId) {
        return logisticChannelMapper.deleteByPrimaryKey(channelId);
    }

    @Override
    public int updateChannel(LogisticChannel logisticChannel) {
        return logisticChannelMapper.updateByPrimaryKeySelective(logisticChannel);
    }
}
