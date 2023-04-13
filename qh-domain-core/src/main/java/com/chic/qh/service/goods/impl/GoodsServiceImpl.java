package com.chic.qh.service.goods.impl;

import com.chic.qh.domain.dal.model.Goods;
import com.chic.qh.domain.dal.model.SkuRelation;
import com.chic.qh.repository.GoodsRepository;
import com.chic.qh.repository.SkuRelationRepository;
import com.chic.qh.service.goods.GoodsService;
import com.chic.qh.service.goods.dto.GoodsAddUpdateDTO;
import com.chic.qh.service.goods.dto.GoodsQueryDTO;
import com.chic.qh.service.goods.dto.SkuAddUpdateDTO;
import com.chic.qh.service.goods.dto.SkuQueryDTO;
import com.chic.qh.service.goods.vo.GoodsListVO;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;
import com.chic.qh.utils.DateUtils;
import com.github.pagehelper.Page;
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

    @Autowired
    private SkuRelationRepository skuRelationRepository;


    @Override
    public GoodsListVO queryList(GoodsQueryDTO dto) {
        Page<Goods> goodsPage = goodsRepository.queryPagedList(dto);
        //build vo
        List<GoodsVO> goodsVOList = buildVO(goodsPage.getResult());
        return new GoodsListVO(goodsPage.getTotal(), goodsVOList);
    }

    private List<GoodsVO> buildVO(List<Goods> goodsList) {
        List<GoodsVO> goodsVOList = new ArrayList<>(goodsList.size());
        goodsList.forEach(x->{
            GoodsVO goodsVO = new GoodsVO();
            BeanUtils.copyProperties(x, goodsVO);

            List<SkuRelation> skuRelationList = skuRelationRepository.querySkuList(x.getGoodsId());
            List<SkuVO> skuVOList = new ArrayList<>(skuRelationList.size());
            skuRelationList.forEach(s->{
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
        Goods goods = new Goods();
        BeanUtils.copyProperties(dto, goods);
        goods.setGmtCreated(DateUtils.getCurrentSecond());

        List<SkuAddUpdateDTO> skuDTOList = dto.getSkuList();
        if(CollectionUtils.isEmpty(skuDTOList)){
            throw new RuntimeException("商品至少需要包含一个sku");
        }

        List<SkuRelation> skuRelationList = new ArrayList<>(skuDTOList.size());
        skuDTOList.forEach(x->{
            SkuRelation skuRelation = new SkuRelation();
            BeanUtils.copyProperties(x, skuRelation);
            skuRelation.setGmtCreated(DateUtils.getCurrentSecond());
            skuRelationList.add(skuRelation);
        });
        goodsRepository.saveGoods(goods);
        skuRelationList.forEach(x->{
            x.setGoodsId(goods.getGoodsId());
            skuRelationRepository.saveSkuRelation(x);
        });
    }

    @Override
    public void updateGoods(GoodsAddUpdateDTO dto) {
        Goods goods = goodsRepository.getGoods(dto.getGoodsId());
        if(goods == null){
            throw new RuntimeException("商品找不到!goodsId:" + dto.getGoodsId());
        }

        Goods updateGoods = new Goods();
        BeanUtils.copyProperties(dto, updateGoods);
        updateGoods.setGmtModify(DateUtils.getCurrentSecond());


        List<SkuAddUpdateDTO> skuDTOList = dto.getSkuList();
        if(CollectionUtils.isEmpty(skuDTOList)){
            throw new RuntimeException("商品至少需要包含一个sku");
        }

        List<SkuRelation> skuRelationList = new ArrayList<>(skuDTOList.size());
        skuDTOList.forEach(x->{
            SkuRelation skuInfo = new SkuRelation();
            BeanUtils.copyProperties(x, skuInfo);
            skuInfo.setGoodsId(updateGoods.getGoodsId());
            skuInfo.setGmtCreated(DateUtils.getCurrentSecond());
            skuRelationList.add(skuInfo);
        });
        goodsRepository.updateGoods(updateGoods);
        skuRelationRepository.deleteSkuByGoodsId(updateGoods.getGoodsId());
        skuRelationList.forEach(x->{
            skuRelationRepository.saveSkuRelation(x);
        });
    }

    @Override
    public void deleteGoods(GoodsAddUpdateDTO dto) {
        goodsRepository.deleteGoods(dto.getGoodsId());
    }

    @Override
    public List<SkuVO> querySkuList(SkuQueryDTO dto) {
        List<SkuRelation> skuRelationList = skuRelationRepository.querySkuList(dto.getGoodsId());
        List<SkuVO> skuVOList = new ArrayList<>(skuRelationList.size());
        skuRelationList.forEach(x->{
            SkuVO skuVO = new SkuVO();
            BeanUtils.copyProperties(x, skuVO);
            skuVOList.add(skuVO);
        });
        return skuVOList;
    }

    @Override
    public void addSku(SkuAddUpdateDTO dto) {
        SkuRelation skuInfo = new SkuRelation();
        BeanUtils.copyProperties(dto, skuInfo);
        skuInfo.setGmtCreated(DateUtils.getCurrentSecond());
        skuRelationRepository.saveSkuRelation(skuInfo);
    }

    @Override
    public void updateSku(SkuAddUpdateDTO dto) {
        SkuRelation skuRelation = skuRelationRepository.getSku(dto.getSkuId());
        if(skuRelation == null){
            throw new RuntimeException("sku找不到!skuId:" + dto.getSkuId());
        }
        SkuRelation updateSku = new SkuRelation();
        BeanUtils.copyProperties(dto, updateSku);
        skuRelationRepository.updateSkuRelation(updateSku);
    }

    @Override
    public void deleteSku(SkuAddUpdateDTO dto) {
        skuRelationRepository.deleteSkuBySkuId(dto.getSkuId());
    }
}
