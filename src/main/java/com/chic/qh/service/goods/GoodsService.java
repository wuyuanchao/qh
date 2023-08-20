package com.chic.qh.service.goods;

import com.chic.qh.repository.model.Goods;
import com.chic.qh.repository.model.GoodsChannel;
import com.chic.qh.service.goods.dto.*;
import com.chic.qh.service.goods.vo.GoodsListVO;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;

import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 12:25
 */
public interface GoodsService {

    boolean exist(Integer goodsId);
    GoodsVO getGoods(Integer goodsId);

    GoodsVO getGoodsBySn(String goodsSn);

    GoodsListVO queryList(GoodsQueryDTO dto);

    List<GoodsVO> selectBySnList(List<String> snList);

    Goods getGoodsPOBySn(String goodsSn);

    void addGoods(GoodsAddUpdateDTO dto);

    void updateGoods(GoodsAddUpdateDTO dto);

    void deleteGoods(GoodsAddUpdateDTO dto);

    List<SkuVO> querySkuList(SkuQueryDTO dto);

    void addSku(SkuAddUpdateDTO dto);

    void updateSku(SkuAddUpdateDTO dto);

    void deleteSku(SkuAddUpdateDTO dto);

    List<GoodsCommentDTO> getGoodsComments(Integer goodsId, String name);

    void addComment(GoodsCommentDTO comment);

    void deleteComment(Integer commentId, String name);

    List<SkuListExcelVO> exportSkuList(Integer goodsId);

    GoodsChannel getGoodsChannel(Integer goodsId, String countryCode);
    int editOrUpdateGoodsChannel(Integer goodsId, String countryCode,  String channelCode);
    int batchUpdateGoodsChannel(List<GoodsChannelConfigUpdateDTO> channelConfigs);
    List<GoodsChannelRespDTO> getGoodsChannelList(Integer goodsId);
    int deleteGoodsChannel(Integer goodsId, String countryCode);

    void saveQuote(Integer goodsId, String quoteName, String version);
}
