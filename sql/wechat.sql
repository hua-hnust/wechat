/*
Navicat MySQL Data Transfer

Source Server         : aa
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : wechat

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-05-17 20:25:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for complain_message
-- ----------------------------
DROP TABLE IF EXISTS `complain_message`;
CREATE TABLE `complain_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `title` varchar(255) DEFAULT NULL COMMENT '咨询问题标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '咨询问题内容',
  `reply` varchar(1000) DEFAULT NULL COMMENT '回复内容',
  `status` int(11) DEFAULT NULL COMMENT '状态：0 待处理，1 处理中，2 处理完成',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of complain_message
-- ----------------------------

-- ----------------------------
-- Table structure for consult_message
-- ----------------------------
DROP TABLE IF EXISTS `consult_message`;
CREATE TABLE `consult_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `title` varchar(255) DEFAULT NULL COMMENT '咨询问题标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '咨询问题内容',
  `reply` varchar(1000) DEFAULT NULL COMMENT '回复内容',
  `status` int(11) DEFAULT NULL COMMENT '状态：0 待处理，1 处理中，2 处理完成',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of consult_message
-- ----------------------------

-- ----------------------------
-- Table structure for disability
-- ----------------------------
DROP TABLE IF EXISTS `disability`;
CREATE TABLE `disability` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `province` varchar(255) DEFAULT NULL COMMENT '省',
  `city` varchar(255) DEFAULT NULL COMMENT '市',
  `county` varchar(255) DEFAULT NULL COMMENT '县、区',
  `detail_address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `reply` varchar(1000) DEFAULT NULL COMMENT '回复内容',
  `status` int(11) DEFAULT NULL COMMENT '状态：0 待处理，1 处理中，2 处理完成',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of disability
-- ----------------------------

-- ----------------------------
-- Table structure for education
-- ----------------------------
DROP TABLE IF EXISTS `education`;
CREATE TABLE `education` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `school` varchar(255) DEFAULT NULL COMMENT '学校',
  `school_year` int(11) DEFAULT NULL COMMENT '学年',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `reply` varchar(1000) DEFAULT NULL COMMENT '回复内容',
  `status` int(11) DEFAULT NULL COMMENT '状态：0 待处理，1 处理中，2 处理完成',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of education
-- ----------------------------

-- ----------------------------
-- Table structure for graduate
-- ----------------------------
DROP TABLE IF EXISTS `graduate`;
CREATE TABLE `graduate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `school` varchar(255) DEFAULT NULL COMMENT '学校',
  `school_year` int(11) DEFAULT NULL COMMENT '学年',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `reply` varchar(1000) DEFAULT NULL COMMENT '回复内容',
  `status` int(11) DEFAULT NULL COMMENT '状态：0 待处理，1 处理中，2 处理完成',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of graduate
-- ----------------------------

-- ----------------------------
-- Table structure for guidance
-- ----------------------------
DROP TABLE IF EXISTS `guidance`;
CREATE TABLE `guidance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '类型：1：教育，2交通，3 社保，4 困难家庭，5 毕业生，6 残疾人士',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `reply` varchar(1000) DEFAULT NULL COMMENT '回复内容',
  `status` int(11) DEFAULT NULL COMMENT '状态：0 待处理，1 处理中，2 处理完成',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of guidance
-- ----------------------------

-- ----------------------------
-- Table structure for insurance
-- ----------------------------
DROP TABLE IF EXISTS `insurance`;
CREATE TABLE `insurance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `imonth` int(11) DEFAULT NULL COMMENT '缴纳月份202004',
  `amount` double DEFAULT NULL COMMENT '缴纳金额',
  `type` int(11) DEFAULT NULL COMMENT '类型（1、医保，2、养老，3、生育，4、失业，5、工伤）,',
  `reply` varchar(1000) DEFAULT NULL COMMENT '回复内容',
  `status` int(11) DEFAULT NULL COMMENT '状态：0 待处理，1 处理中，2 处理完成',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of insurance
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department` varchar(255) DEFAULT NULL COMMENT '部门',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for poor_family
-- ----------------------------
DROP TABLE IF EXISTS `poor_family`;
CREATE TABLE `poor_family` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `province` varchar(255) DEFAULT NULL COMMENT '省',
  `city` varchar(255) DEFAULT NULL COMMENT '市',
  `county` varchar(255) DEFAULT NULL COMMENT '县、区',
  `detail_address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `reply` varchar(1000) DEFAULT NULL COMMENT '回复内容',
  `status` int(11) DEFAULT NULL COMMENT '状态：0 待处理，1 处理中，2 处理完成',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of poor_family
-- ----------------------------

-- ----------------------------
-- Table structure for traffic
-- ----------------------------
DROP TABLE IF EXISTS `traffic`;
CREATE TABLE `traffic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `car_number` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `reply` varchar(1000) DEFAULT NULL COMMENT '回复内容',
  `status` int(11) DEFAULT NULL COMMENT '状态：0 待处理，1 处理中，2 处理完成',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of traffic
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type` int(11) DEFAULT '0' COMMENT '用户类型 0 用户，1 管理员',
  `openid` varchar(255) DEFAULT NULL COMMENT '微信openid',
  `wechat_code` varchar(255) DEFAULT NULL COMMENT '微信code,获取用户信息的code',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `token` varchar(255) DEFAULT NULL COMMENT '登录token',
  `token_expire_time` datetime DEFAULT NULL COMMENT 'token过期时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
