-- MySQL dump 10.13  Distrib 8.0.26, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: qh
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `qh_order_info`
--

DROP TABLE IF EXISTS `qh_order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qh_order_info` (
  `order_id` int unsigned NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(50) NOT NULL DEFAULT '' COMMENT '订单编号',
  `tracking_number` varchar(50) NOT NULL DEFAULT '' COMMENT '物流单号',
  `tracking_number2` varchar(50) NOT NULL DEFAULT '' COMMENT '物流单号2',
  `quantity` int NOT NULL DEFAULT '0' COMMENT '商品数量',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
  `sku` varchar(255) NOT NULL DEFAULT '' COMMENT 'sku',
  `product_id` varchar(50) NOT NULL DEFAULT '' COMMENT '商品ID',
  `country` varchar(50) NOT NULL DEFAULT '' COMMENT '国家',
  `country_code` varchar(5) NOT NULL DEFAULT '' COMMENT '国家码',
  `province` varchar(50) NOT NULL DEFAULT '' COMMENT '省',
  `city` varchar(50) NOT NULL DEFAULT '' COMMENT '市',
  `address` varchar(500) NOT NULL DEFAULT '' COMMENT '详细地址',
  `zip_code` varchar(50) NOT NULL DEFAULT '' COMMENT '邮编',
  `shipping_name` varchar(255) NOT NULL DEFAULT '' COMMENT '收件人',
  `phone_number` varchar(50) NOT NULL DEFAULT '' COMMENT '手机号',
  `order_time` int NOT NULL DEFAULT '0' COMMENT '下单时间',
  `pay_time` int NOT NULL DEFAULT '0' COMMENT '支付时间',
  `shipping_time` int NOT NULL DEFAULT '0' COMMENT '发货时间',
  `shipping_method` varchar(255) NOT NULL DEFAULT '' COMMENT '发货方式',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态 1-有效;2-无效;',
  `gmt_created` int NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modify` int NOT NULL DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_order_sn` (`order_sn`),
  KEY `idx_tracking_number` (`tracking_number`),
  KEY `idx_tracking_number2` (`tracking_number2`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-14 20:08:44
