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
-- Table structure for table `qh_sku_relation`
--

DROP TABLE IF EXISTS `qh_sku_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qh_sku_relation` (
  `sku_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'skuId',
  `goods_id` int NOT NULL DEFAULT '0' COMMENT '商品ID',
  `sku_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'sku名称',
  `sku_name_en` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'sku名称（英文）',
  `supp_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '供应商名称',
  `supp_sku_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '供方skuId',
  `link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '供方链接',
  `length` int NOT NULL DEFAULT '0' COMMENT '长度(cm)',
  `width` int NOT NULL DEFAULT '0' COMMENT '宽度(cm)',
  `height` int NOT NULL DEFAULT '0' COMMENT '高度(cm)',
  `area` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '面积',
  `weight` decimal(10,3) NOT NULL DEFAULT '0.000' COMMENT '重量',
  `volume_weight` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '体积重',
  `pur_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '采购价',
  `color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '颜色',
  `size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '尺码',
  `gmt_created` int NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modify` int NOT NULL DEFAULT '0' COMMENT '修改时间',
  `remark` varchar(45) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `sku_image` varchar(1024) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'sku图片',
  `parent_id` int NOT NULL DEFAULT '0' COMMENT '父skuId',
  `dxm_sku_id` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '店小蜜skuId',
  PRIMARY KEY (`sku_id`) USING BTREE,
  KEY `idx_goods_id` (`goods_id`) USING BTREE,
  KEY `idx_parent_id` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='sku表';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-14 20:08:45
