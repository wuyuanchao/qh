package com.chic.qh.service.logistic;

import com.chic.qh.repository.mapper.LogisticChannelDetailDynamicSqlSupport;
import com.chic.qh.repository.mapper.LogisticChannelDetailMapper;
import com.chic.qh.repository.mapper.LogisticChannelDynamicSqlSupport;
import com.chic.qh.repository.mapper.LogisticChannelMapper;
import com.chic.qh.repository.model.LogisticChannel;
import com.chic.qh.repository.model.LogisticChannelDetail;
import com.chic.qh.service.logistic.dto.ChannelDetailExcelVO;
import com.chic.qh.service.logistic.dto.LogisticConfigDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.ArrayListMultimap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LogisticServiceImpl implements LogisticService{

    @Autowired
    private LogisticChannelMapper logisticChannelMapper;
    @Autowired
    private LogisticChannelDetailMapper logisticChannelDetailMapper;
    @Override
    public Page<LogisticChannel> getChannelList(Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() ->
                logisticChannelMapper.select(c -> c.orderBy(LogisticChannelDynamicSqlSupport.recId.descending())));
    }

    @Override
    public void addChannel(LogisticChannel logisticChannel) {
        logisticChannelMapper.insert(logisticChannel);
    }

    @Override
    public List<LogisticConfigDTO> getChannelDetail(Integer channelId) {
        List<LogisticChannelDetail> channelDetails = logisticChannelDetailMapper.select(c ->
                c.where(LogisticChannelDetailDynamicSqlSupport.channelId, SqlBuilder.isEqualTo(channelId))
                        .orderBy(LogisticChannelDetailDynamicSqlSupport.weightLeft,LogisticChannelDetailDynamicSqlSupport.recId)
        );

        ArrayListMultimap<LogisticChannelDetailUniKey, LogisticChannelDetail> channelDetailListMap = ArrayListMultimap.create();
        channelDetails.forEach(x->{
            channelDetailListMap.put(new LogisticChannelDetailUniKey(x.getCountry(), x.getShippingTime(), x.getVolWeightRate()), x);
        });

        List<LogisticConfigDTO> dtoList = new ArrayList<>(channelDetailListMap.keySet().size());
        Integer index = 1;
        for (LogisticChannelDetailUniKey uniKey : channelDetailListMap.keySet()) {
            List<LogisticChannelDetail> details = channelDetailListMap.get(uniKey);
            LogisticConfigDTO dto = new LogisticConfigDTO();
            dto.setId(index);
            dto.setCountry(uniKey.getCountry());
            dto.setShippingTime(uniKey.getShippingTime());
            dto.setVolWeightRate(uniKey.getVolWeightRate());

            List<LogisticConfigDTO.Item> itemList = new ArrayList<>(details.size());
            details.forEach(x->{
                LogisticConfigDTO.Item item = new LogisticConfigDTO.Item();
                item.setId(x.getRecId());
                item.setLeft(x.getWeightLeft());
                item.setRight(x.getWeightRight());
                item.setShippingFee(x.getShippingFee());
                item.setExtraFee(x.getExtraFee());
                itemList.add(item);
            });
            dto.setItems(itemList);

            dtoList.add(dto);
            index++;
        }

        return dtoList;
    }


    private static class LogisticChannelDetailUniKey{
        private String country;
        private String shippingTime;
        private BigDecimal volWeightRate;

        public String getCountry() {
            return country;
        }

        public String getShippingTime() {
            return shippingTime;
        }

        public BigDecimal getVolWeightRate() {
            return volWeightRate;
        }

        public LogisticChannelDetailUniKey(String country, String shippingTime, BigDecimal volWeightRate) {
            this.country = country;
            this.shippingTime = shippingTime;
            this.volWeightRate = volWeightRate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LogisticChannelDetailUniKey that = (LogisticChannelDetailUniKey) o;
            return country.equals(that.country) &&
                    shippingTime.equals(that.shippingTime) &&
                    volWeightRate.compareTo(that.volWeightRate) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(country, shippingTime, volWeightRate);
        }

    }

    @Override
    public void processImportChannelDetail(Integer channelId, List<ChannelDetailExcelVO> dataList) {
        if(CollectionUtils.isEmpty(dataList)){
            log.warn("没有导入有效的物流渠道详情数据!channelId:{}" , channelId);
            return;
        }
        List<LogisticChannelDetail> detailList = dataList.stream().map(x -> {
            LogisticChannelDetail detail = new LogisticChannelDetail();
            BeanUtils.copyProperties(x, detail);
            detail.setChannelId(channelId);
            return detail;
        }).collect(Collectors.toList());
        //删除原渠道详情
        logisticChannelDetailMapper.delete(c->c.where(LogisticChannelDetailDynamicSqlSupport.channelId, SqlBuilder.isEqualTo(channelId)));
        //插入新的渠道详情
        logisticChannelDetailMapper.insertMultiple(detailList);
    }

    @Override
    public List<ChannelDetailExcelVO> exportChannelDetail(Integer channelId) {
        List<LogisticChannelDetail> channelDetails = logisticChannelDetailMapper.select(c ->
                c.where(LogisticChannelDetailDynamicSqlSupport.channelId, SqlBuilder.isEqualTo(channelId))
                        .orderBy(LogisticChannelDetailDynamicSqlSupport.weightLeft,LogisticChannelDetailDynamicSqlSupport.recId)
        );
        return channelDetails.stream().map(x -> {
            ChannelDetailExcelVO vo = new ChannelDetailExcelVO();
            BeanUtils.copyProperties(x, vo);
            return vo;
        }).collect(Collectors.toList());
    }
}
