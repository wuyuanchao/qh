--liquibase formatted sql

--changeset wuyuanchao:1695302470802-1
CREATE TABLE `qh_settle_order_info` (
                                        `settle_order_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                        `settle_order_sn` varchar(255) NOT NULL DEFAULT '' COMMENT '结算单sn',
                                        `total_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '总金额',
                                        `operator_id` int(11) NOT NULL DEFAULT '0' COMMENT '操作人ID',
                                        `gmt_created` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
                                        `gmt_modify` int(11) NOT NULL DEFAULT '0' COMMENT '修改时间',
                                        PRIMARY KEY (`settle_order_id`),
                                        UNIQUE KEY `uniq_settle_order_sn` (`settle_order_sn`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='结算账单';
--changeset wuyuanchao:1695302470802-2
CREATE TABLE `qh_settle_order_detail` (
                                          `rec_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                          `settle_order_id` int(11) NOT NULL DEFAULT '0' COMMENT '结算单ID',
                                          `order_id` int(11) NOT NULL DEFAULT '0' COMMENT '订单ID',
                                          `order_sn` varchar(255) NOT NULL DEFAULT '' COMMENT '订单SN',
                                          `quantity` int(10) NOT NULL DEFAULT '0' COMMENT '商品数量',
                                          `sku` varchar(255) NOT NULL DEFAULT '' COMMENT '订单sku',
                                          `sku_id` int(11) NOT NULL DEFAULT '0' COMMENT 'skuId',
                                          `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '金额',
                                          `quote_id` int(11) NOT NULL DEFAULT '0' COMMENT '报价ID',
                                          `gmt_created` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
                                          PRIMARY KEY (`rec_id`),
                                          KEY `idx_settle_order_id` (`settle_order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='结算单明细';