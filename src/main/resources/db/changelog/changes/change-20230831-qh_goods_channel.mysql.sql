--liquibase formatted sql

--changeset wuyuanchao:1693492760802-3
ALTER TABLE `qh`.`qh_goods_channel`
    ADD COLUMN `channel_type` TINYINT(4) NOT NULL DEFAULT 1 COMMENT '渠道类型：1-普线， 2-快线';
--changeset wuyuanchao:1693492760802-4
ALTER TABLE `qh`.`qh_goods_quote_detail`
    ADD COLUMN `channel_type` TINYINT(4) NOT NULL DEFAULT 1 AFTER `created_at`;