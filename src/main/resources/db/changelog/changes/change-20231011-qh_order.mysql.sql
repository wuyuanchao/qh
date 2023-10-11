--liquibase formatted sql

--changeset wuyuanchao:1697034271802-1
ALTER TABLE `qh`.`qh_order_info`
ADD COLUMN `dxm_sku` varchar(255) NOT NULL DEFAULT '' COMMENT '店小蜜SKU' AFTER `price`,
ADD COLUMN `dxm_product_code` varchar(255) NOT NULL DEFAULT '' COMMENT '店小蜜商品code' AFTER `dxm_sku`;