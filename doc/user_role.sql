/*
Navicat MySQL Data Transfer

Source Server         : 10.168.16.116
Source Server Version : 50628
Source Host           : 10.168.16.116:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2017-01-15 11:14:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', 'admin', '1', '2017-01-15 09:38:40', '2017-01-15 09:38:46');
