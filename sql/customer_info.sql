/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : xiaomi

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-01-17 11:59:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `card_type` varchar(255) DEFAULT NULL COMMENT '证件类型',
  `card_number` varchar(255) DEFAULT NULL COMMENT '身份证号码',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `wechat` varchar(255) DEFAULT NULL COMMENT '微信',
  `qq` varchar(255) DEFAULT NULL COMMENT 'qq',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `mobile_f` varchar(255) DEFAULT NULL COMMENT '手机1',
  `mobile_s` varchar(255) DEFAULT NULL COMMENT '手机2',
  `birth` varchar(255) DEFAULT NULL COMMENT '生日',
  `address` varchar(255) DEFAULT NULL COMMENT '住址',
  `marriage` varchar(255) DEFAULT NULL COMMENT '婚姻',
  `relationship_level` varchar(255) DEFAULT NULL COMMENT '关系登记',
  `risk_trend` varchar(255) DEFAULT NULL COMMENT '风险偏好',
  `principal` varchar(255) DEFAULT NULL COMMENT '负责人',
  `customer_property` varchar(255) DEFAULT NULL COMMENT '客户资产',
  `buy_amount` varchar(255) DEFAULT NULL COMMENT '累计购买',
  `add_time` varchar(255) DEFAULT NULL COMMENT '增加时间',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  `department` varchar(255) DEFAULT NULL COMMENT '部门',
  `return_visit` varchar(255) DEFAULT NULL COMMENT '最近回访',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
