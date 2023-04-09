package com.chic.qh.domain.core.service.goods.impl;

import com.chic.qh.domain.core.domain.goods.GoodsInfo;
import com.chic.qh.domain.core.domain.goods.SkuInfo;
import com.chic.qh.domain.core.repository.GoodsRepository;
import com.chic.qh.domain.core.service.goods.GoodsService;
import com.chic.qh.domain.core.service.goods.dto.GoodsAddUpdateDTO;
import com.chic.qh.domain.core.service.goods.dto.GoodsQueryDTO;
import com.chic.qh.domain.core.service.goods.dto.SkuAddUpdateDTO;
import com.chic.qh.domain.core.service.goods.dto.SkuQueryDTO;
import com.chic.qh.domain.core.service.goods.vo.GoodsListVO;
import com.chic.qh.domain.core.service.goods.vo.GoodsVO;
import com.chic.qh.domain.core.service.goods.vo.SkuVO;
import com.chic.qh.domain.core.utils.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 商品
 * @author: xumingwei
 * @date: 2023—04—09 12:25
 */
@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsRepository goodsRepository;


    @Override
    public GoodsListVO queryList(GoodsQueryDTO dto) {
        Integer count = goodsRepository.queryCount(dto);
        List<GoodsInfo> goodsInfoList = goodsRepository.queryList(dto);
        //build vo
        List<GoodsVO> goodsVOList = buildVO(goodsInfoList);
        return new GoodsListVO(count, goodsVOList);
    }

    private List<GoodsVO> buildVO(List<GoodsInfo> goodsInfoList) {
        List<GoodsVO> goodsVOList = new ArrayList<>(goodsInfoList.size());
        goodsInfoList.forEach(x->{
            GoodsVO goodsVO = new GoodsVO();
            BeanUtils.copyProperties(x, goodsVO);

            List<SkuInfo> skuInfoList = goodsRepository.querySkuList(x.getGoodsId());
            List<SkuVO> skuVOList = new ArrayList<>(skuInfoList.size());
            skuInfoList.forEach(s->{
                SkuVO skuVO = new SkuVO();
                BeanUtils.copyProperties(s, skuVO);
                skuVOList.add(skuVO);
            });
            goodsVO.setSkuList(skuVOList);

            goodsVOList.add(goodsVO);
        });
        return goodsVOList;
    }

    @Override
    public void addGoods(GoodsAddUpdateDTO dto) {
        GoodsInfo goodsInfo = new GoodsInfo();
        BeanUtils.copyProperties(dto, goodsInfo);
        goodsInfo.setGoodsId(DateUtils.getCurrentSecond() + (int)(Math.random() * 1000));
        goodsInfo.setAddTime(DateUtils.getCurrentSecond());

        List<SkuAddUpdateDTO> skuDTOList = dto.getSkuList();
        if(CollectionUtils.isEmpty(skuDTOList)){
            throw new RuntimeException("商品至少需要包含一个sku");
        }

        List<SkuInfo> skuInfoList = new ArrayList<>(skuDTOList.size());
        skuDTOList.forEach(x->{
            SkuInfo skuInfo = new SkuInfo();
            BeanUtils.copyProperties(x, skuInfo);
            skuInfo.setGoodsId(goodsInfo.getGoodsId());
            skuInfo.setSkuId(DateUtils.getCurrentSecond() + (int)(Math.random() * 1000));

            skuInfoList.add(skuInfo);
        });
        goodsRepository.addGoods(goodsInfo, skuInfoList);
    }

    @Override
    public void updateGoods(GoodsAddUpdateDTO dto) {
        GoodsInfo goods = goodsRepository.getGoods(dto.getGoodsId());
        if(goods == null){
            throw new RuntimeException("商品找不到!goodsId:" + dto.getGoodsId());
        }

        GoodsInfo goodsInfo = new GoodsInfo();
        BeanUtils.copyProperties(dto, goodsInfo);

        List<SkuAddUpdateDTO> skuDTOList = dto.getSkuList();
        if(CollectionUtils.isEmpty(skuDTOList)){
            throw new RuntimeException("商品至少需要包含一个sku");
        }

        List<SkuInfo> skuInfoList = new ArrayList<>(skuDTOList.size());
        skuDTOList.forEach(x->{
            SkuInfo skuInfo = new SkuInfo();
            BeanUtils.copyProperties(x, skuInfo);
            skuInfo.setGoodsId(goodsInfo.getGoodsId());
            skuInfo.setSkuId(DateUtils.getCurrentSecond() + (int)(Math.random() * 1000));

            skuInfoList.add(skuInfo);
        });
        goodsRepository.addGoods(goodsInfo, skuInfoList);
    }

    @Override
    public void deleteGoods(GoodsAddUpdateDTO dto) {
        goodsRepository.deleteGoods(dto.getGoodsId());
    }

    @Override
    public List<SkuVO> querySkuList(SkuQueryDTO dto) {
        List<SkuInfo> skuInfoList = goodsRepository.querySkuList(dto.getGoodsId());
        List<SkuVO> skuVOList = new ArrayList<>(skuInfoList.size());
        skuInfoList.forEach(x->{
            SkuVO skuVO = new SkuVO();
            BeanUtils.copyProperties(x, skuVO);
            skuVOList.add(skuVO);
        });
        return skuVOList;
    }

    @Override
    public void addSku(SkuAddUpdateDTO dto) {
        SkuInfo skuInfo = new SkuInfo();
        BeanUtils.copyProperties(dto, skuInfo);
        skuInfo.setSkuId(DateUtils.getCurrentSecond() + (int)(Math.random() * 1000));
        goodsRepository.addSku(skuInfo);
    }

    @Override
    public void updateSku(SkuAddUpdateDTO dto) {
        SkuInfo skuInfo = new SkuInfo();
        BeanUtils.copyProperties(dto, skuInfo);
        goodsRepository.updateSku(skuInfo);
    }

    @Override
    public void deleteSku(SkuAddUpdateDTO dto) {
        goodsRepository.deleteSku(dto);
    }
}
