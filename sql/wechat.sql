/*
Navicat MySQL Data Transfer

Source Server         : aa
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : wechat

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-05-26 10:30:17
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of complain_message
-- ----------------------------
INSERT INTO `complain_message` VALUES ('1', '1', '暗示法', '啊短发啊速度发爱的发顺丰', null, '0', '2020-05-26 04:20:38', '2020-05-26 04:20:38');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of consult_message
-- ----------------------------
INSERT INTO `consult_message` VALUES ('1', '1', '微信怎么登录', '不知道怎么搞，谁能告诉我', null, '0', '2020-05-26 03:57:05', '2020-05-26 04:11:14');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of disability
-- ----------------------------
INSERT INTO `disability` VALUES ('1', '1', '湖南省', '长沙市', '雨花区', '华泰大厦321号', '残疾人士出门困难', '残疾人士出门困难  木的办法', null, '0', '2020-05-22 01:31:05', '2020-05-22 02:00:06');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of education
-- ----------------------------
INSERT INTO `education` VALUES ('7', '1', '湖南科技大学', '2020', '网络工程', '学校科研经费紧张', '小星星啊啊啊456', '暗示法', '0', '2020-05-18 01:34:34', '2020-05-24 20:29:35');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of graduate
-- ----------------------------
INSERT INTO `graduate` VALUES ('1', '1', 'qwe', '2020', '软件工程', '2020毕业即失业', '啊发生地方啊速度发', null, '0', '2020-05-22 00:50:59', '2020-05-22 00:52:01');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of guidance
-- ----------------------------
INSERT INTO `guidance` VALUES ('1', '2', '交通业务指南', '交通业务指南内容', null, '0', '2020-05-26 00:40:19', '2020-05-26 00:42:15');
INSERT INTO `guidance` VALUES ('2', '3', '社保业务指南', '社保业务指南', null, '0', '2020-05-26 00:42:33', '2020-05-26 00:42:33');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of insurance
-- ----------------------------
INSERT INTO `insurance` VALUES ('1', '1', '202005', '10', '4', null, '0', '2020-05-26 03:16:13', '2020-05-26 03:33:38');
INSERT INTO `insurance` VALUES ('2', '1', '202004', '200', '1', null, '0', '2020-05-26 03:30:05', '2020-05-26 03:30:05');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '桃源街道办事处', '桃源街道办事处内部整顿通知', '桃源街道办事处内部整顿桃源街道办事处内部整顿通知桃源街道办事处内部整顿通知', '2020-05-26 01:00:01', '2020-05-26 01:00:01');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of poor_family
-- ----------------------------
INSERT INTO `poor_family` VALUES ('1', '1', '湖南省', '湘潭市', '雨湖区', '桃源街道12号', '温饱问题解决不了', '温饱问题解决不了翠竹新村', '啊速度发', '1', '2020-05-22 01:22:26', '2020-05-24 22:02:46');
INSERT INTO `poor_family` VALUES ('2', '1', '接口', '家里', 'tk拿', '金履路口', '溜了溜了', '恐龙图', null, '0', '2020-05-22 02:27:50', '2020-05-22 02:27:50');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of traffic
-- ----------------------------
INSERT INTO `traffic` VALUES ('1', '1', '湘A12345', '汽车保险续保办理难', '汽车保险续保办理难aaa', '啊的萨芬', '1', '2020-05-22 01:04:02', '2020-05-24 22:00:11');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type` int(11) DEFAULT '0' COMMENT '用户类型 0 用户，1 管理员',
  `openid` varchar(255) DEFAULT NULL COMMENT '微信openid',
  `wechat_code` varchar(255) DEFAULT NULL COMMENT '微信code,获取用户信息的code',
  `head_img` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `token` varchar(255) DEFAULT NULL COMMENT '登录token',
  `token_expire_time` datetime DEFAULT NULL COMMENT 'token过期时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '0', 'oZyDKs2kO_hXs-dPAm4c7BS7UVYA', '061rgmUG0lTPHf24mvRG0zBiUG0rgmU5', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJXOe1iaxvelDsv9HJ2dJe6u2TP6KQxfhdibJ4IUu2aeibGlJ9q2d7f0hicw17NMtrgLOSvj1b5XQ247w/132', '634563456', '1233@qq.com', '落羽', null, 'eb33c0ae-d81c-4449-9f09-1112399e9ede', '2020-05-26 06:35:32', '2020-05-17 21:31:38', '2020-05-26 02:20:14');
INSERT INTO `user` VALUES ('3', '0', 'oZyDKs_x25zebzCxeP67oGsF_zuQ', '071RnvUR04JA852c4hTR0JWcUR0RnvUv', 'http://thirdwx.qlogo.cn/mmopen/vi_32/4zKLZ8AJ5h0ibShaOkDy2LQz3Bn9aNN7RssW7Ugo9z8TrODtnRuK2Skq3hMb1a4Py6nDk6o3ZxSfu3Tl2WLkctQ/132', '43656365463', '555@qq.com', '雅', null, '896cd34c-138f-4fb3-b3d1-7e117051c31b', '2020-05-23 00:56:13', '2020-05-22 22:54:25', '2020-05-26 02:20:06');
INSERT INTO `user` VALUES ('4', '1', null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/4zKLZ8AJ5h0ibShaOkDy2LQz3Bn9aNN7RssW7Ugo9z8TrODtnRuK2Skq3hMb1a4Py6nDk6o3ZxSfu3Tl2WLkctQ/132', '15211111111', 'email@qq.com', '超级管理员', '96e79218965eb72c92a549dd5a330112', '4d9a15cd-945d-4b90-ba70-ab18e82a6576', '2020-05-26 05:42:24', '2020-05-23 01:49:37', '2020-05-26 02:11:14');
