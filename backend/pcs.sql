/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : pcs

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2022-07-18 20:14:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for board
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `board_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(40) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `time` varchar(40) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`board_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board` VALUES ('1', '李松宸大傻逼', '李松宸真是大傻波', '2022-07-17 19:21:44 下午', 'asdsadsadasd');

-- ----------------------------
-- Table structure for enpity
-- ----------------------------
DROP TABLE IF EXISTS `enpity`;
CREATE TABLE `enpity` (
  `enpity_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` varchar(20) DEFAULT NULL,
  `teacher_name` varchar(20) DEFAULT NULL,
  `teacher_type` int(11) DEFAULT NULL,
  `mon_m` int(11) DEFAULT NULL,
  `mon_a` int(11) DEFAULT NULL,
  `tue_m` int(11) DEFAULT NULL,
  `tue_a` int(11) DEFAULT NULL,
  `wed_m` int(11) DEFAULT NULL,
  `wed_a` int(11) DEFAULT NULL,
  `thu_m` int(11) DEFAULT NULL,
  `thu_a` int(11) DEFAULT NULL,
  `fri_m` int(11) DEFAULT NULL,
  `fri_a` int(11) DEFAULT NULL,
  `sat_m` int(11) DEFAULT NULL,
  `sat_a` int(11) DEFAULT NULL,
  `sun_m` int(11) DEFAULT NULL,
  `sun_a` int(11) DEFAULT NULL,
  PRIMARY KEY (`enpity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='空闲时间表';

-- ----------------------------
-- Records of enpity
-- ----------------------------
INSERT INTO `enpity` VALUES ('5', 't2', '陆', '3', '0', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `enpity` VALUES ('6', 't3', '李松宸', '3', '2', '0', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `enpity` VALUES ('7', 't1', '张', '3', '3', '3', '0', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `enpity` VALUES ('8', 'cfy2', '陈奥博', '4', '0', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `enpity` VALUES ('9', 'cfy', '彭于晏', '4', '1', '0', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation` (
  `evaluation_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL,
  `teacher_name` varchar(20) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `fellings` varchar(100) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `evaluation_time` varchar(40) DEFAULT NULL,
  `result_time` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`evaluation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='评价表';

-- ----------------------------
-- Records of evaluation
-- ----------------------------
INSERT INTO `evaluation` VALUES ('1', 'st1', '陈奥博', 'mon_a', '我不想紫砂呀', '1', '2022-07-16 17:07:01 下午', '2022-07-16 16:57:38 下午');
INSERT INTO `evaluation` VALUES ('2', 'st1', '李松宸', 'mon_m', '确实不想紫砂了', '95', '2022-07-16 17:36:08 下午', '2022-07-16 17:25:08 下午');

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `note_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` varchar(20) DEFAULT NULL,
  `teacher_name` varchar(20) DEFAULT NULL,
  `note_time` varchar(100) DEFAULT NULL,
  `is_success` int(11) DEFAULT NULL COMMENT '为0代表未审核，1是通过，2是驳回',
  `is_finish` int(11) DEFAULT NULL COMMENT '为0代表未未进行销假，1是销假成功',
  `note_reason` varchar(100) DEFAULT NULL,
  `create_time` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`note_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('1', 'cfy', '彭于晏', 'fri_a', '2', '0', '我想紫砂了', '2022-07-16 21:13:45 下午');
INSERT INTO `note` VALUES ('2', 'cfy', '彭于晏', 'fri_a', '1', '1', null, '2022-07-16 21:16:14 下午');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `person_name` varchar(20) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `isfirst` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='个人信息表';

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 't1', '张', '2000-01-01', '男', '15582066414', '1-109', '0');
INSERT INTO `person` VALUES ('2', 't2', '陆', '1999-02-06', '女', '16580287333', '1-102', '0');
INSERT INTO `person` VALUES ('4', 'admin', '陆博遥', '1989-08-09', '女', '15213318526', '1-109', '0');
INSERT INTO `person` VALUES ('5', 'cfy2', '陈奥博', '1995-09-12', '男', '13328644358', '1-109', '0');
INSERT INTO `person` VALUES ('6', 't3', '李松宸', '1998-07-23', '男', '18578483885', '1-102', '0');
INSERT INTO `person` VALUES ('7', 'cfy', '彭于晏', '1989-06-05', '男', '18870481311', '1-118', '0');
INSERT INTO `person` VALUES ('8', 'st1', 'st1', 'st1', 'st1', 'st1', 'st1', '0');
INSERT INTO `person` VALUES ('9', 'ct1', 'ct1', 'ct1', 'ct1', 'ct1', 'ct1', '0');
INSERT INTO `person` VALUES ('10', 'zx1', 'zx1', 'zx1', 'zx1', 'zx1', 'zx1', '0');
INSERT INTO `person` VALUES ('11', 'c', 'c', 'c', 'c', 'c', 'c', '0');
INSERT INTO `person` VALUES ('12', 'ct2', 'ct2', 'ct2', 'ct2', 'ct2', 'ct2', '0');

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `a` varchar(20) DEFAULT NULL,
  `b` varchar(20) DEFAULT NULL,
  `c` varchar(20) DEFAULT NULL,
  `d` varchar(20) DEFAULT NULL,
  `e` varchar(20) DEFAULT NULL,
  `f` varchar(20) DEFAULT NULL,
  `g` varchar(20) DEFAULT NULL,
  `h` varchar(20) DEFAULT NULL,
  KEY `pro_id` (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of problem
-- ----------------------------

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `report_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `teacher_id` varchar(20) DEFAULT NULL,
  `teacher_name` varchar(20) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `is_first` tinyint(1) DEFAULT NULL,
  `review_remarks` varchar(100) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `report_time` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='报告表';

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('7', 'st1', 'st1', null, '', '', '0', '', '3', '2022-07-17 08:20:24 上午');
INSERT INTO `report` VALUES ('8', 'st1', 'st1', null, '', '', '0', '', '6', '2022-07-17 08:20:51 上午');

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `result_id` int(11) NOT NULL AUTO_INCREMENT,
  `result_time` varchar(40) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `time_result` varchar(20) DEFAULT NULL,
  `result_score` int(11) DEFAULT NULL,
  `teacher_id` varchar(20) DEFAULT NULL,
  `is_first` tinyint(1) DEFAULT NULL,
  `result_remarks` varchar(100) DEFAULT NULL,
  `is_success` tinyint(1) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `teacher_name` varchar(20) DEFAULT NULL,
  `is_ok` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`result_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='预约结果表';

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('1', '2022-07-16 16:57:38 下午', 'st1', 'mon_a', '69', 'cfy2', '0', '', '1', 'st1', '陈奥博', '1');
INSERT INTO `result` VALUES ('2', '2022-07-16 17:08:16 下午', 'st1', 'mon_m', '87', 't3', '1', '', '1', 'st1', '李松宸', '0');
INSERT INTO `result` VALUES ('3', '2022-07-16 17:25:08 下午', 'st1', 'mon_m', '0', 't3', '1', '我有点想紫砂', '1', 'st1', '李松宸', '1');
INSERT INTO `result` VALUES ('4', '2022-07-16 20:41:07 下午', 'st1', null, '0', null, '1', '我有点想紫砂', '0', 'st1', null, '0');
INSERT INTO `result` VALUES ('5', '2022-07-16 21:12:46 下午', 'st1', 'mon_m', '9', 'cfy', '0', '', '1', 'st1', '彭于晏', '0');
INSERT INTO `result` VALUES ('6', '2022-07-16 22:02:39 下午', 'st1', 'mon_m', '12', 'cfy', '0', '', '1', 'st1', '彭于晏', '0');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `is_first` tinyint(1) DEFAULT NULL,
  `teacher_id` varchar(20) DEFAULT NULL,
  `teacher_name` varchar(20) DEFAULT NULL,
  `review_remarks` varchar(100) DEFAULT NULL,
  `review_score` int(11) DEFAULT NULL,
  `review_time` varchar(40) DEFAULT NULL,
  `result_time` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`review_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='预约审核表';

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES ('1', 'st1', 'st1', 'mon_a', '1', 'cfy2', '陈奥博', '他想紫砂', '38', '2022-07-16 17:04:17 下午', '2022-07-16 16:57:38 下午');
INSERT INTO `review` VALUES ('2', 'st1', 'st1', 'mon_m', '0', 't3', '李松宸', '他不想紫砂了', '95', '2022-07-16 17:27:47 下午', '2022-07-16 17:25:08 下午');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `user_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', '2252667328@qq.com', '1');
INSERT INTO `user` VALUES ('3', 'cfy2', '123456', '1229682416@qq.com', '4');
INSERT INTO `user` VALUES ('4', 't1', '123456', '2147286369@qq.com', '3');
INSERT INTO `user` VALUES ('5', 't2', '123456', '1887045226@qq.com', '3');
INSERT INTO `user` VALUES ('6', 't3', '123456', '1657826484@qq.com', '3');
INSERT INTO `user` VALUES ('7', 'cfy', '123456', '2184667328@qq.com', '4');
INSERT INTO `user` VALUES ('8', 'st1', '123456', 'st1', '2');
INSERT INTO `user` VALUES ('9', 'ct1', '123456', 'ct1', '4');
INSERT INTO `user` VALUES ('10', 'zx1', 'zx1', 'zx1', '4');
INSERT INTO `user` VALUES ('11', 'c', 'c', 'c', '4');
INSERT INTO `user` VALUES ('12', 'ct2', 'ct2', 'ct2', '3');
