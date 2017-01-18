/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : xiaomi

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-01-18 17:03:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for combine_info
-- ----------------------------
DROP TABLE IF EXISTS `combine_info`;
CREATE TABLE `combine_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contract_no` varchar(255) DEFAULT NULL,
  `ser_number` varchar(255) DEFAULT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  `product` varchar(255) DEFAULT NULL,
  `customer_type` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `card_type` varchar(255) DEFAULT NULL,
  `card_number` varchar(255) DEFAULT NULL,
  `sales_status` varchar(255) DEFAULT NULL,
  `sales_amount` varchar(255) DEFAULT NULL,
  `income_type` varchar(255) DEFAULT NULL,
  `buy_time` varchar(255) DEFAULT NULL,
  `dead_time` varchar(255) DEFAULT NULL,
  `bank_address` varchar(255) DEFAULT NULL,
  `bank_user_name` varchar(255) DEFAULT NULL,
  `bank_number` varchar(255) DEFAULT NULL,
  `term` varchar(255) DEFAULT NULL,
  `product_discount` varchar(255) DEFAULT NULL,
  `performance` varchar(255) DEFAULT NULL,
  `save_time` varchar(255) DEFAULT NULL,
  `rate` varchar(255) DEFAULT NULL,
  `income` varchar(255) DEFAULT NULL,
  `income_amount` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `manager` varchar(255) DEFAULT NULL,
  `principal` varchar(255) DEFAULT NULL,
  `customer_cell_phone` varchar(255) DEFAULT NULL,
  `retrun_number` varchar(255) DEFAULT NULL,
  `return_time` varchar(255) DEFAULT NULL,
  `retrun_result` varchar(255) DEFAULT NULL,
  `info_rev` varchar(255) DEFAULT NULL,
  `return_mark` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `wechat` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `mobile_f` varchar(255) DEFAULT NULL,
  `mobile_s` varchar(255) DEFAULT NULL,
  `birth` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `marriage` varchar(255) DEFAULT NULL,
  `relationship_level` varchar(255) DEFAULT NULL,
  `risk_trend` varchar(255) DEFAULT NULL,
  `customer_property` varchar(255) DEFAULT NULL,
  `buy_amount` varchar(255) DEFAULT NULL,
  `add_time` varchar(255) DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `return_visit` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `buy_year` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7643 DEFAULT CHARSET=utf8;
