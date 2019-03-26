/*
Navicat MySQL Data Transfer

Source Server         : im
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : im

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2018-12-10 09:14:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for android
-- ----------------------------
DROP TABLE IF EXISTS `android`;
CREATE TABLE `android` (
  `phoneNumber` varchar(30) NOT NULL,
  `name` varchar(20) NOT NULL,
  `country` varchar(20) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`phoneNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of android
-- ----------------------------
INSERT INTO `android` VALUES ('123456', 'caddo', 'China', '123456');
INSERT INTO `android` VALUES ('1234', 'elina', 'China', '1234');
INSERT INTO `android` VALUES ('1800799', 'sea', 'Usa', '1111');
INSERT INTO `android` VALUES ('1397998', 'jenny', 'Japan', '2222');
INSERT INTO `android` VALUES ('1517990', 'solar', 'America', '3333');
