/*
Navicat MySQL Data Transfer

Source Server         : 10.168.16.116
Source Server Version : 50628
Source Host           : 10.168.16.116:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2017-01-15 11:14:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `usertype` varchar(2) DEFAULT NULL COMMENT '用户类型',
  `enabled` int(2) DEFAULT NULL COMMENT '是否可用',
  `realname` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `qq` varchar(14) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '$2a$10$rzJ8Ps9dZq5j6MnIpENVXeOjlddEI7ugFBjQpcS2Yrcn4w6Fb9GAm', null, null, null, '1040078821', '1040078821@qq.com', '18910116121', '2017-01-15 10:41:08', '2017-01-15 10:41:08');
