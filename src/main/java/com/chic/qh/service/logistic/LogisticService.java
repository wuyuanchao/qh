package com.chic.qh.service.logistic;

import com.chic.qh.repository.model.LogisticChannel;
import com.chic.qh.service.logistic.dto.ChannelDetailExcelVO;
import com.chic.qh.service.logistic.dto.LogisticConfigDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface LogisticService {
    PageInfo<LogisticChannel> getChannelList(String company, String code, Integer pageNum, Integer pageSize);

    void addChannel(LogisticChannel logisticChannel);

    List<LogisticConfigDTO> getChannelDetail(String channelCode);

    int deleteChannel(Integer channelId);

    int updateChannel(LogisticChannel logisticChannel);

    void processImportChannelDetail(Integer channelId, List<ChannelDetailExcelVO> dataList);

    List<ChannelDetailExcelVO> exportChannelDetail(Integer channelId);

    LogisticChannel getChannelInfo(String _channelCode);

    ChannelConfig getChannelConfig(String channelCode);

    List<LogisticChannel> getCompanyChannels(String companyCode);

}
