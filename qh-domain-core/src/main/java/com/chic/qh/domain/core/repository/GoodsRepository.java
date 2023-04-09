package com.chic.qh.domain.core.repository;

import com.chic.qh.domain.core.domain.goods.GoodsInfo;
import com.chic.qh.domain.core.domain.goods.SkuInfo;
import com.chic.qh.domain.core.service.goods.dto.GoodsQueryDTO;
import com.chic.qh.domain.core.service.goods.dto.SkuAddUpdateDTO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 12:28
 */
@Repository
public class GoodsRepository {

    //模拟数据库商品表
    private static ConcurrentMap<Integer, GoodsInfo> GOODS_MAP = new ConcurrentHashMap();
    private static ConcurrentMap<Integer, List<SkuInfo>> SKU_MAP = new ConcurrentHashMap();

    public Integer queryCount(GoodsQueryDTO dto) {
        return GOODS_MAP.size();
    }

    public List<GoodsInfo> queryList(GoodsQueryDTO dto) {
        return new ArrayList<>(GOODS_MAP.values());
    }

    public List<SkuInfo> querySkuList(Integer goodsId) {
        List<SkuInfo> skuInfoList = SKU_MAP.get(goodsId);
        if(CollectionUtils.isEmpty(skuInfoList)){
            return new ArrayList<>();
        }
        return skuInfoList;
    }

    public GoodsInfo getGoods(Integer goodsId){
        return GOODS_MAP.get(goodsId);
    }

    public void addGoods(GoodsInfo goodsInfo, List<SkuInfo> skuInfoList) {
        GOODS_MAP.put(goodsInfo.getGoodsId(), goodsInfo);
        SKU_MAP.put(goodsInfo.getGoodsId(), skuInfoList);
    }

    public void deleteGoods(Integer goodsId) {
        GOODS_MAP.remove(goodsId);
    }

    public void addSku(SkuInfo skuInfo) {
        List<SkuInfo> skuInfoList = SKU_MAP.get(skuInfo.getGoodsId());
        if(CollectionUtils.isEmpty(skuInfoList)){
            skuInfoList = new ArrayList<>();
        }
        skuInfoList.add(skuInfo);
    }

    public void updateSku(SkuInfo skuInfo) {
        List<SkuInfo> skuInfoList = SKU_MAP.get(skuInfo.getGoodsId());
        if(CollectionUtils.isEmpty(skuInfoList)){
            return;
        }
        for (SkuInfo info : skuInfoList) {
            if(info.getSkuId().equals(skuInfo.getSkuId())){
                BeanUtils.copyProperties(skuInfo, info);
            }
        }
    }

    public void deleteSku(SkuAddUpdateDTO dto) {
        List<SkuInfo> skuInfoList = SKU_MAP.get(dto.getGoodsId());
        if(CollectionUtils.isEmpty(skuInfoList)){
            return;
        }
        skuInfoList = skuInfoList.stream()
                .filter(x->!x.getSkuId().equals(dto.getSkuId()))
                .collect(Collectors.toList());
        SKU_MAP.put(dto.getGoodsId(), skuInfoList);
    }
}
