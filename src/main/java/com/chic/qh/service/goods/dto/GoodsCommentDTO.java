package com.chic.qh.service.goods.dto;

import com.chic.qh.repository.model.GoodsComment;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class GoodsCommentDTO {
    private Integer recId;
    private Integer goodsId;
    private String content;
    private String user;
    private String avatar;
    private Integer createdAt;
    private Boolean owner;

    public static GoodsCommentDTO build(GoodsComment commentPO, String name){
        GoodsCommentDTO dto = new GoodsCommentDTO();
        BeanUtils.copyProperties(commentPO, dto);
        dto.setAvatar("https://xsgames.co/randomusers/avatar.php?g=pixel&key=" + dto.user);
        dto.setOwner(commentPO.getUser().equals(name));
        return dto;
    }
}
