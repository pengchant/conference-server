/*
 Navicat Premium Data Transfer

 Source Server         : mysqldb
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : conferencem

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 22/04/2019 14:56:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for privilege
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `keyword` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ismenu` bit(1) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `parentid` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `privilege_self_fk`(`parentid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of privilege
-- ----------------------------
INSERT INTO `privilege` VALUES ('1', '预约会议', 'yuyue', '会议提前预约', '/yyhy', b'1', NULL, '0');
INSERT INTO `privilege` VALUES ('10', '表决会议', 'biaojue', '表决会议', '/biaojue', b'1', NULL, '2');
INSERT INTO `privilege` VALUES ('11', '与会人员签到', 'qiandao', '与会人员签到', '/qiandao ', b'1', NULL, '3');
INSERT INTO `privilege` VALUES ('12', '统计会议签到', 'tonjiqiandao', '统计会议参会情况', '/tongjiiandao', b'1', NULL, '3');
INSERT INTO `privilege` VALUES ('13', '记录会议内容', 'jiluneirong', '记录会议内容', '/jiluhuiyi', b'1', NULL, '4');
INSERT INTO `privilege` VALUES ('14', '修改会议内容', 'xiugaihuiyi ', '修改会议内容', '/fjsfjs', b'1', NULL, '4');
INSERT INTO `privilege` VALUES ('15', '上传存档', 'cundang', '存档', '/cundang', b'1', NULL, '5');
INSERT INTO `privilege` VALUES ('2', '会议互动', 'hudong', '会议互动', '/hyhd', b'1', NULL, '0');
INSERT INTO `privilege` VALUES ('3', '会议签到', 'qiandao', '会议签到', '/hyqd', b'1', NULL, '0');
INSERT INTO `privilege` VALUES ('4', '会议记录', 'jilu', '会议记录', '/hyjl', b'1', NULL, '0');
INSERT INTO `privilege` VALUES ('5', '存档调阅', 'diaoyue', '会议内容调阅', '/cddy', b'1', NULL, '0');
INSERT INTO `privilege` VALUES ('6', '申请会议预约', 'shenqingyuyue', '申请预约', '/shenqign', b'1', NULL, '1');
INSERT INTO `privilege` VALUES ('7', '修改会议预约', 'xiugaiyuyue', '修改会议预约', '/modify', b'1', NULL, '1');
INSERT INTO `privilege` VALUES ('8', '审核会议预约', 'shengheyuyue', '审核预约', '/shenghe', b'1', NULL, '1');
INSERT INTO `privilege` VALUES ('9', '发起互动', 'faqihudong', '发起会议互动', '/faqi', b'1', NULL, '2');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `keyword` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', 'admin', '管理员角色');
INSERT INTO `role` VALUES ('2', '校长', 'xiaozhang', '校长');
INSERT INTO `role` VALUES ('3', '院党委书记', 'yuandangwei', '院党委书记');
INSERT INTO `role` VALUES ('4', '院长', 'yuanzhang', '院长');
INSERT INTO `role` VALUES ('5', '部门党委书记', 'bumengdangewi', '部门党委书记');
INSERT INTO `role` VALUES ('6', '部长', 'buzhang', '部长');

-- ----------------------------
-- Table structure for role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `role_privilege`;
CREATE TABLE `role_privilege`  (
  `role_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `priv_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`role_id`, `priv_id`) USING BTREE,
  INDEX `role_privilege_privid_fk`(`priv_id`) USING BTREE,
  CONSTRAINT `role_privilege_privid_fk` FOREIGN KEY (`priv_id`) REFERENCES `privilege` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_privilege_roleid_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` smallint(6) DEFAULT NULL,
  `gender` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'cp', '陈鹏', 'e10adc3949ba59abbe56e057f20f883e', 12, '男');
INSERT INTO `user` VALUES ('2', 'dongna', '东南大学', 'e10adc3949ba59abbe56e057f20f883e', 21, '男');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `user_role_roleid_fk`(`role_id`) USING BTREE,
  CONSTRAINT `user_role_roleid_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_userid_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('1', '2');
INSERT INTO `user_role` VALUES ('1', '3');
INSERT INTO `user_role` VALUES ('2', '4');
INSERT INTO `user_role` VALUES ('2', '5');
INSERT INTO `user_role` VALUES ('2', '6');

SET FOREIGN_KEY_CHECKS = 1;
