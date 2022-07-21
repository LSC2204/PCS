/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : 127.0.0.1:3306
Source Database       : pcs

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2022-07-20 10:55:11
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
INSERT INTO `board` VALUES ('1', '李松宸', '李松宸真是', '2022-07-17 19:21:44 下午', 'asdsadsadasd');

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
INSERT INTO `enpity` VALUES ('7', 't1', '张', '3', '2', '3', '0', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='评价表';

-- ----------------------------
-- Records of evaluation
-- ----------------------------
INSERT INTO `evaluation` VALUES ('1', 'st1', '陈奥博', 'mon_a', '我不想紫砂呀', '1', '2022-07-16 17:07:01 下午', '2022-07-16 16:57:38 下午');
INSERT INTO `evaluation` VALUES ('2', 'st1', '李松宸', 'mon_m', '确实不想紫砂了', '95', '2022-07-16 17:36:08 下午', '2022-07-16 17:25:08 下午');
INSERT INTO `evaluation` VALUES ('3', 'st1', '张', 'mon_m', 'sadfsadgfadsgagasdf', '100', '2022-07-17 18:16:59 下午', '2022-07-17 15:13:47 下午');

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='个人信息表';

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 't1', '张', '2000-01-01', '男', '15582066414', '1-109', '0');
INSERT INTO `person` VALUES ('2', 't2', '陆', '1999-02-06', '女', '16580287333', '1-102', '0');
INSERT INTO `person` VALUES ('4', 'admin', '陆博遥', '1989-08-09', '女', '15213318526', '1-109', '0');
INSERT INTO `person` VALUES ('5', 'cfy2', '陈奥博', '1995-09-12', '男', '13328644358', '1-109', '0');
INSERT INTO `person` VALUES ('6', 't3', '李松宸', '1998-07-23', '男', '18578483885', '1-102', '0');
INSERT INTO `person` VALUES ('7', 'cfy', '彭于晏', '1989-06-05', '男', '18870481311', '1-118', '0');
INSERT INTO `person` VALUES ('8', 'st1', '测试学生', 'st1', 'st1', '456789', 'st1', '0');
INSERT INTO `person` VALUES ('9', 'ct1', 'ct1', 'ct1', 'ct1', 'ct1', 'ct1', '0');
INSERT INTO `person` VALUES ('10', 'zx1', 'zx1', 'zx1', 'zx1', 'zx1', 'zx1', '0');
INSERT INTO `person` VALUES ('11', 'c', 'c', 'c', 'c', 'c', 'c', '0');
INSERT INTO `person` VALUES ('12', 'ct2', 'ct2', 'ct2', 'ct2', 'ct2', 'ct2', '0');
INSERT INTO `person` VALUES ('13', 'st2', '测试学生2', '1111', '男', '134679', '1-102', '0');
INSERT INTO `person` VALUES ('15', 'st4', '测试用户4', '2022-07-13', '男', '123456789', '水水水水水', '0');
INSERT INTO `person` VALUES ('16', 'st3', '测试用户3', '2022-07-28', '男', '13806851237', '未设置地址', '0');
INSERT INTO `person` VALUES ('17', 'cfy10086', '初访员测试10086', '2022-07-27', '男', '123456', '少时诵诗书色色色色色色色色色色色色', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='报告表';

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('9', 'st1', 'st1', null, '', '星期一下午;星期二上午', '0', '你好', '0', '2022-07-17 09:34:48 上午');
INSERT INTO `report` VALUES ('10', 'st1', 'st1', 't1', '张', '星期一上午', '0', '阿斯顿发射点', '0', '2022-07-17 09:54:32 上午');
INSERT INTO `report` VALUES ('11', 'st1', 'st1', 't1', '张', '', '0', '进行通过测试', '0', '2022-07-17 14:55:02 下午');
INSERT INTO `report` VALUES ('12', 'st1', 'st1', 't1', '张', '星期一上午;星期一下午;星期二上午', '0', '123456', '0', '2022-07-17 15:05:57 下午');
INSERT INTO `report` VALUES ('16', 'st2', '测试学生2', 't1', '张', '星期一下午;星期二上午;星期五上午', '0', '1111', '0', '2022-07-17 20:53:22 下午');
INSERT INTO `report` VALUES ('17', 'st1', '测试学生', 't1', '张', '星期天上午;星期天下午', '0', '测试删除分数后是否成功', '0', '2022-07-18 11:35:15 上午');
INSERT INTO `report` VALUES ('18', 'st1', '测试学生', 't2', '陆', '星期天上午;星期天下午', '0', '第二次测试', '0', '2022-07-18 11:42:07 上午');

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='预约结果表';

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('1', '2022-07-16 16:57:38 下午', 'st1', 'mon_a', '69', 'cfy2', '0', '', '1', '测试学生', '陈奥博', '1');
INSERT INTO `result` VALUES ('2', '2022-07-16 17:08:16 下午', 'st1', 'mon_m', '87', 't3', '1', '', '1', '测试学生', '李松宸', '0');
INSERT INTO `result` VALUES ('3', '2022-07-16 17:25:08 下午', 'st1', 'mon_m', '0', 't3', '1', '我有点想紫砂', '1', '测试学生', '李松宸', '1');
INSERT INTO `result` VALUES ('4', '2022-07-16 20:41:07 下午', 'st1', null, '0', null, '1', '我有点想紫砂', '0', '测试学生', null, '0');
INSERT INTO `result` VALUES ('5', '2022-07-16 21:12:46 下午', 'st1', 'mon_m', '9', 'cfy', '0', '', '1', '测试学生', '彭于晏', '0');
INSERT INTO `result` VALUES ('6', '2022-07-16 22:02:39 下午', 'st1', 'mon_m', '12', 'cfy', '0', '', '1', '测试学生', '彭于晏', '0');
INSERT INTO `result` VALUES ('7', '2022-07-17 15:13:47 下午', 'st1', 'mon_m', '3', 't1', '0', '', '1', '测试学生', '张', '1');
INSERT INTO `result` VALUES ('8', '2022-07-17 15:44:26 下午', 'st1', 'mon_m', '6', 't1', '0', '', '1', '测试学生', '张', '0');
INSERT INTO `result` VALUES ('9', '2022-07-17 20:43:53 下午', 'st2', 'tue_a', '3', 'cfy2', '1', '你好我好', '1', '测试学生2', '陈奥博', '1');
INSERT INTO `result` VALUES ('10', '2022-07-17 20:50:49 下午', 'st2', 'wed_m', '0', 'cfy2', '1', '1111', '1', '测试学生2', '陈奥博', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='预约审核表';

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES ('1', 'st1', '测试学生', 'mon_a', '1', 'cfy2', '陈奥博', '他想紫砂', '38', '2022-07-16 17:04:17 下午', '2022-07-16 16:57:38 下午');
INSERT INTO `review` VALUES ('2', 'st1', '测试学生', 'mon_m', '0', 't3', '李松宸', '他不想紫砂了', '95', '2022-07-16 17:27:47 下午', '2022-07-16 17:25:08 下午');
INSERT INTO `review` VALUES ('3', 'st1', '测试学生', 'mon_m', '0', 't1', '张', '非常好', '90', '2022-07-17 15:41:31 下午', '2022-07-17 15:13:47 下午');
INSERT INTO `review` VALUES ('4', 'st2', '测试学生2', 'tue_a', '1', 'cfy2', '陈奥博', '病得不轻', '60', '2022-07-17 20:48:42 下午', '2022-07-17 20:43:53 下午');
INSERT INTO `review` VALUES ('5', 'st2', '测试学生2', 'wed_m', '0', 'cfy2', '陈奥博', '123456', '90', '2022-07-17 20:51:07 下午', '2022-07-17 20:50:49 下午');

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='用户表';

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
INSERT INTO `user` VALUES ('13', 'st2', '123456', '123456789', '2');
INSERT INTO `user` VALUES ('17', 'st4', '123456', '123456789', '2');
INSERT INTO `user` VALUES ('18', 'st3', '123456', '666@qq.com', '2');
INSERT INTO `user` VALUES ('19', 'cfy10086', '123456', '123456789', '4');