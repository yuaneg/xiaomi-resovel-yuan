/*
Navicat MySQL Data Transfer

Source Server         : 60.205.30.19
Source Server Version : 50173
Source Host           : bdm257613210.my3w.com:3306
Source Database       : bdm257613210_db

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-01-17 09:55:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sales_info
-- ----------------------------
DROP TABLE IF EXISTS `sales_info`;
CREATE TABLE `sales_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contract_no` varchar(255) DEFAULT NULL COMMENT '合同编号',
  `ser_number` varchar(255) DEFAULT '' COMMENT '编号',
  `product_type` varchar(255) DEFAULT '' COMMENT '产品类型',
  `product` varchar(255) DEFAULT '' COMMENT '产品',
  `customer_type` varchar(255) DEFAULT '' COMMENT '客户类型',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `card_type` varchar(255) DEFAULT NULL COMMENT '证件类型',
  `card_number` varchar(255) DEFAULT NULL COMMENT '证件号码',
  `sales_status` varchar(255) DEFAULT NULL COMMENT '订单状态',
  `sales_amount` varchar(255) DEFAULT NULL COMMENT '订单金额',
  `income_type` varchar(255) DEFAULT NULL COMMENT '计息方式',
  `buy_time` varchar(255) DEFAULT NULL COMMENT '购买日期',
  `dead_time` varchar(255) DEFAULT NULL COMMENT '到期日期',
  `bank_address` varchar(255) DEFAULT NULL COMMENT '银行开户地址',
  `bank_user_name` varchar(255) DEFAULT NULL COMMENT '开户名',
  `bank_number` varchar(255) DEFAULT NULL COMMENT '打款账号',
  `term` varchar(255) DEFAULT NULL COMMENT '期限',
  `product_discount` varchar(255) DEFAULT NULL COMMENT '产品折后',
  `performance` varchar(255) DEFAULT NULL COMMENT '年化业绩',
  `save_time` varchar(255) DEFAULT NULL COMMENT '存续天数',
  `rate` varchar(255) DEFAULT NULL COMMENT '收益率',
  `income` varchar(255) DEFAULT NULL COMMENT '利息',
  `income_amount` varchar(255) DEFAULT NULL COMMENT '本息和',
  `department` varchar(255) DEFAULT NULL COMMENT '部门',
  `manager` varchar(255) DEFAULT NULL COMMENT '销售经理',
  `principal` varchar(255) DEFAULT NULL COMMENT '负责人',
  `customer_cell_phone` varchar(255) DEFAULT NULL,
  `retrun_number` varchar(255) DEFAULT NULL COMMENT '回访次数',
  `return_time` varchar(255) DEFAULT NULL COMMENT '回访时间',
  `retrun_result` varchar(255) DEFAULT NULL COMMENT '回访结果',
  `info_rev` varchar(255) DEFAULT NULL COMMENT '信息核实',
  `return_mark` varchar(255) DEFAULT NULL COMMENT '回访备注',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
