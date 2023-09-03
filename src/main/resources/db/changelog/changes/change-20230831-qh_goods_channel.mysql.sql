--liquibase formatted sql

--changeset wuyuanchao:1693492760802-3
ALTER TABLE `qh`.`qh_goods_channel`
    ADD COLUMN `channel_type` TINYINT(4) NOT NULL DEFAULT 1 COMMENT '渠道类型：1-普线， 2-快线';
--changeset wuyuanchao:1693492760802-4
ALTER TABLE `qh`.`qh_goods_quote_detail`
    ADD COLUMN `channel_type` TINYINT(4) NOT NULL DEFAULT 1 AFTER `created_at`;
--changeset wuyuanchao:1693492760802-5
ALTER TABLE `qh`.`qh_sku_relation`
    ADD COLUMN `parent_id` int(10) NOT NULL DEFAULT 0 COMMENT '父skuId' ,
    ADD COLUMN `dxm_sku_id` varchar(50) NOT NULL DEFAULT '' COMMENT '店小蜜skuId' ,
    ADD INDEX `idx_parent_id`(`parent_id`) USING BTREE;