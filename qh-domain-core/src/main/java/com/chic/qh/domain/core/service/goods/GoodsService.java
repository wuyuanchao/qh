package com.chic.qh.domain.core.service.goods;

import com.chic.qh.domain.core.service.goods.dto.GoodsAddUpdateDTO;
import com.chic.qh.domain.core.service.goods.dto.GoodsQueryDTO;
import com.chic.qh.domain.core.service.goods.dto.SkuAddUpdateDTO;
import com.chic.qh.domain.core.service.goods.dto.SkuQueryDTO;
import com.chic.qh.domain.core.service.goods.vo.GoodsListVO;
import com.chic.qh.domain.core.service.goods.vo.SkuVO;

import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 12:25
 */
public interface GoodsService {

    GoodsListVO queryList(GoodsQueryDTO dto);

    void addGoods(GoodsAddUpdateDTO dto);

    void updateGoods(GoodsAddUpdateDTO dto);

    void deleteGoods(GoodsAddUpdateDTO dto);

    List<SkuVO> querySkuList(SkuQueryDTO dto);

    void addSku(SkuAddUpdateDTO dto);

    void updateSku(SkuAddUpdateDTO dto);

    void deleteSku(SkuAddUpdateDTO dto);
}
