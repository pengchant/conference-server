/*
 Navicat Premium Data Transfer

 Source Server         : mysqldb
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : cloudconference

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 22/09/2019 17:09:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workerid` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工号',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `wxopenid` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信openid',
  `wxflag` smallint(6) DEFAULT NULL COMMENT '是否已经绑定微信',
  `registtime` datetime(0) DEFAULT NULL COMMENT '注册时间',
  `phonenum` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  `pwd` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账户密码',
  `userstatus` smallint(6) DEFAULT NULL COMMENT '账户的状态',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `workerid`(`workerid`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE,
  UNIQUE INDEX `wxopenid`(`wxopenid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (9, '001', 'dntchenpeng@163.com', NULL, NULL, '2019-05-12 22:11:03', '13961826751', '11111', 1);
INSERT INTO `account` VALUES (10, '212121', '232543@13234.com', NULL, NULL, '2019-05-12 22:19:01', '123432154325432', '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (11, '1234555', 'wuqing@xzit.edu.cn', NULL, NULL, '2019-05-13 09:58:29', '12334243215432', '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (12, '11111', 'fdsafdsa@', NULL, NULL, '2019-05-13 10:02:55', 'fsdafsdaf', '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (13, '1111', 'chenfugui@just.edu.cn', NULL, NULL, '2019-05-13 10:06:15', '123453245432', '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (14, 'admin', 'rte3rtewq', NULL, NULL, '2019-05-13 11:07:59', 'trewtrew', '96e79218965eb72c92a549dd5a330112', 999);
INSERT INTO `account` VALUES (23, '20019201', NULL, NULL, NULL, '2019-05-19 13:08:02', NULL, '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (24, '123456', NULL, NULL, NULL, '2019-08-16 15:00:28', NULL, '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (25, '111234', NULL, NULL, NULL, '2019-08-16 16:13:54', NULL, '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (26, '201901', NULL, NULL, NULL, '2019-08-16 16:41:23', NULL, '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (27, '888', NULL, NULL, NULL, '2019-08-16 16:43:13', NULL, '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (28, '5555', NULL, NULL, NULL, '2019-08-17 10:04:42', NULL, '5b1b68a9abf4d2cd155c81a9225fd158', 1);
INSERT INTO `account` VALUES (29, '189070018', NULL, NULL, NULL, '2019-08-20 23:36:22', NULL, '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (30, 'A0001', NULL, NULL, NULL, '2019-08-23 09:00:18', NULL, 'ac028ca59d4d69d71f856d9477fe700a', 1);
INSERT INTO `account` VALUES (34, 'B001', NULL, NULL, NULL, '2019-08-23 09:55:10', NULL, 'ac028ca59d4d69d71f856d9477fe700a', 1);
INSERT INTO `account` VALUES (36, '20130501140', NULL, NULL, NULL, '2019-08-23 16:47:37', NULL, '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (38, '20130501141', NULL, NULL, NULL, '2019-08-23 16:49:08', NULL, '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (39, '20130501144', NULL, NULL, NULL, '2019-08-23 21:47:54', NULL, '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (41, '189070020', NULL, NULL, NULL, '2019-08-23 21:50:02', NULL, '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (42, '119', NULL, NULL, NULL, '2019-08-23 22:13:05', NULL, '76cd438bd0e8899a61aff632ace54dbb', 1);
INSERT INTO `account` VALUES (43, '189070099', NULL, NULL, NULL, '2019-08-25 17:41:28', NULL, '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (44, '13961826751', NULL, NULL, NULL, '2019-09-02 11:51:40', NULL, '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO `account` VALUES (45, '123', NULL, NULL, NULL, '2019-09-09 15:13:58', NULL, '827ccb0eea8a706c4c34a16891f84e7b', 1);
INSERT INTO `account` VALUES (46, '19950301', NULL, NULL, NULL, '2019-09-22 17:05:58', NULL, '96e79218965eb72c92a549dd5a330112', 1);

-- ----------------------------
-- Table structure for attendes
-- ----------------------------
DROP TABLE IF EXISTS `attendes`;
CREATE TABLE `attendes`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workerid` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参会人员工号',
  `wokername` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参会人员',
  `hasattend` smallint(6) DEFAULT 0 COMMENT '是否到场:0不到场,1:到场',
  `confid` int(11) DEFAULT NULL COMMENT '会议编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_attendes_confid`(`confid`) USING BTREE,
  CONSTRAINT `fk_attendes_confid` FOREIGN KEY (`confid`) REFERENCES `conference` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 335 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of attendes
-- ----------------------------
INSERT INTO `attendes` VALUES (30, '9', NULL, 0, 19);
INSERT INTO `attendes` VALUES (31, '10', NULL, 0, 19);
INSERT INTO `attendes` VALUES (32, '11', NULL, 0, 19);
INSERT INTO `attendes` VALUES (33, '9', NULL, 0, 20);
INSERT INTO `attendes` VALUES (34, '10', NULL, 0, 20);
INSERT INTO `attendes` VALUES (35, '11', NULL, 0, 20);
INSERT INTO `attendes` VALUES (36, '12', NULL, 0, 20);
INSERT INTO `attendes` VALUES (37, '9', NULL, 0, 21);
INSERT INTO `attendes` VALUES (38, '10', NULL, 0, 21);
INSERT INTO `attendes` VALUES (39, '11', NULL, 0, 21);
INSERT INTO `attendes` VALUES (40, '9', NULL, 0, 22);
INSERT INTO `attendes` VALUES (41, '10', NULL, 0, 22);
INSERT INTO `attendes` VALUES (42, '11', NULL, 0, 22);
INSERT INTO `attendes` VALUES (43, '9', NULL, 0, 23);
INSERT INTO `attendes` VALUES (44, '10', NULL, 0, 23);
INSERT INTO `attendes` VALUES (45, '10', NULL, 0, 24);
INSERT INTO `attendes` VALUES (46, '11', NULL, 0, 24);
INSERT INTO `attendes` VALUES (47, '13', NULL, 0, 24);
INSERT INTO `attendes` VALUES (48, '14', NULL, 0, 24);
INSERT INTO `attendes` VALUES (49, '15', NULL, 0, 24);
INSERT INTO `attendes` VALUES (50, '9', NULL, 1, 25);
INSERT INTO `attendes` VALUES (51, '10', NULL, 1, 25);
INSERT INTO `attendes` VALUES (52, '11', NULL, 1, 25);
INSERT INTO `attendes` VALUES (53, '13', NULL, 1, 25);
INSERT INTO `attendes` VALUES (54, '9', NULL, 1, 26);
INSERT INTO `attendes` VALUES (55, '10', NULL, 1, 26);
INSERT INTO `attendes` VALUES (56, '11', NULL, 1, 26);
INSERT INTO `attendes` VALUES (57, '12', NULL, 1, 26);
INSERT INTO `attendes` VALUES (58, '13', NULL, 1, 26);
INSERT INTO `attendes` VALUES (59, '9', NULL, 1, 27);
INSERT INTO `attendes` VALUES (60, '10', NULL, 1, 27);
INSERT INTO `attendes` VALUES (61, '11', NULL, 1, 27);
INSERT INTO `attendes` VALUES (62, '12', NULL, 1, 27);
INSERT INTO `attendes` VALUES (63, '13', NULL, 1, 27);
INSERT INTO `attendes` VALUES (64, '14', NULL, 1, 27);
INSERT INTO `attendes` VALUES (65, '15', NULL, 1, 27);
INSERT INTO `attendes` VALUES (66, '16', NULL, 1, 27);
INSERT INTO `attendes` VALUES (67, '17', NULL, 1, 27);
INSERT INTO `attendes` VALUES (68, '18', NULL, 1, 27);
INSERT INTO `attendes` VALUES (69, '19', NULL, 1, 27);
INSERT INTO `attendes` VALUES (70, '20', NULL, 1, 27);
INSERT INTO `attendes` VALUES (71, '23', NULL, 1, 27);
INSERT INTO `attendes` VALUES (72, '9', NULL, 1, 28);
INSERT INTO `attendes` VALUES (73, '10', NULL, 1, 28);
INSERT INTO `attendes` VALUES (74, '11', NULL, 1, 28);
INSERT INTO `attendes` VALUES (75, '12', NULL, 1, 28);
INSERT INTO `attendes` VALUES (76, '13', NULL, 1, 28);
INSERT INTO `attendes` VALUES (77, '9', NULL, 1, 29);
INSERT INTO `attendes` VALUES (78, '10', NULL, 1, 29);
INSERT INTO `attendes` VALUES (79, '11', NULL, 1, 29);
INSERT INTO `attendes` VALUES (80, '12', NULL, 1, 29);
INSERT INTO `attendes` VALUES (81, '9', NULL, 1, 30);
INSERT INTO `attendes` VALUES (82, '13', NULL, 1, 30);
INSERT INTO `attendes` VALUES (83, '15', NULL, 1, 30);
INSERT INTO `attendes` VALUES (84, '16', NULL, 1, 30);
INSERT INTO `attendes` VALUES (85, '17', NULL, 1, 30);
INSERT INTO `attendes` VALUES (86, '9', NULL, 1, 31);
INSERT INTO `attendes` VALUES (87, '10', NULL, 1, 31);
INSERT INTO `attendes` VALUES (88, '11', NULL, 1, 31);
INSERT INTO `attendes` VALUES (89, '9', NULL, 1, 32);
INSERT INTO `attendes` VALUES (90, '10', NULL, 1, 32);
INSERT INTO `attendes` VALUES (91, '11', NULL, 1, 32);
INSERT INTO `attendes` VALUES (92, '12', NULL, 1, 32);
INSERT INTO `attendes` VALUES (93, '9', NULL, 1, 33);
INSERT INTO `attendes` VALUES (94, '10', NULL, 1, 33);
INSERT INTO `attendes` VALUES (95, '11', NULL, 1, 33);
INSERT INTO `attendes` VALUES (96, '12', NULL, 1, 33);
INSERT INTO `attendes` VALUES (97, '13', NULL, 1, 33);
INSERT INTO `attendes` VALUES (98, '9', NULL, 1, 34);
INSERT INTO `attendes` VALUES (99, '10', NULL, 1, 34);
INSERT INTO `attendes` VALUES (100, '11', NULL, 1, 34);
INSERT INTO `attendes` VALUES (101, '12', NULL, 1, 34);
INSERT INTO `attendes` VALUES (102, '13', NULL, 1, 34);
INSERT INTO `attendes` VALUES (103, '14', NULL, 1, 34);
INSERT INTO `attendes` VALUES (104, '9', NULL, 1, 35);
INSERT INTO `attendes` VALUES (105, '10', NULL, 1, 35);
INSERT INTO `attendes` VALUES (106, '11', NULL, 1, 35);
INSERT INTO `attendes` VALUES (107, '11', NULL, 0, 36);
INSERT INTO `attendes` VALUES (108, '13', NULL, 0, 36);
INSERT INTO `attendes` VALUES (109, '12', NULL, 0, 36);
INSERT INTO `attendes` VALUES (110, '10', NULL, 0, 36);
INSERT INTO `attendes` VALUES (111, '15', NULL, 0, 36);
INSERT INTO `attendes` VALUES (112, '13', NULL, 0, 37);
INSERT INTO `attendes` VALUES (113, '11', NULL, 1, 37);
INSERT INTO `attendes` VALUES (114, '9', NULL, 1, 37);
INSERT INTO `attendes` VALUES (115, '9', NULL, 1, 38);
INSERT INTO `attendes` VALUES (116, '10', NULL, 1, 38);
INSERT INTO `attendes` VALUES (117, '11', NULL, 1, 38);
INSERT INTO `attendes` VALUES (118, '9', NULL, 1, 39);
INSERT INTO `attendes` VALUES (119, '11', NULL, 1, 39);
INSERT INTO `attendes` VALUES (120, '12', NULL, 1, 39);
INSERT INTO `attendes` VALUES (121, '10', NULL, 1, 39);
INSERT INTO `attendes` VALUES (122, '9', NULL, 1, 40);
INSERT INTO `attendes` VALUES (123, '10', NULL, 1, 40);
INSERT INTO `attendes` VALUES (124, '11', NULL, 1, 40);
INSERT INTO `attendes` VALUES (125, '9', NULL, 1, 41);
INSERT INTO `attendes` VALUES (126, '10', NULL, 1, 41);
INSERT INTO `attendes` VALUES (127, '11', NULL, 1, 41);
INSERT INTO `attendes` VALUES (135, '10', NULL, 0, 43);
INSERT INTO `attendes` VALUES (136, '11', NULL, 0, 43);
INSERT INTO `attendes` VALUES (137, '12', NULL, 0, 43);
INSERT INTO `attendes` VALUES (138, '9', NULL, 1, 44);
INSERT INTO `attendes` VALUES (139, '10', NULL, 1, 44);
INSERT INTO `attendes` VALUES (140, '11', NULL, 1, 44);
INSERT INTO `attendes` VALUES (141, '9', NULL, 1, 45);
INSERT INTO `attendes` VALUES (142, '15', NULL, 1, 45);
INSERT INTO `attendes` VALUES (143, '16', NULL, 1, 45);
INSERT INTO `attendes` VALUES (144, '9', NULL, 1, 46);
INSERT INTO `attendes` VALUES (145, '10', NULL, 1, 46);
INSERT INTO `attendes` VALUES (146, '11', NULL, 1, 46);
INSERT INTO `attendes` VALUES (147, '14', NULL, 1, 46);
INSERT INTO `attendes` VALUES (148, '9', NULL, 1, 47);
INSERT INTO `attendes` VALUES (149, '10', NULL, 1, 47);
INSERT INTO `attendes` VALUES (150, '11', NULL, 1, 47);
INSERT INTO `attendes` VALUES (151, '12', NULL, 1, 47);
INSERT INTO `attendes` VALUES (152, '13', NULL, 1, 47);
INSERT INTO `attendes` VALUES (153, '9', NULL, 1, 48);
INSERT INTO `attendes` VALUES (154, '10', NULL, 1, 48);
INSERT INTO `attendes` VALUES (155, '11', NULL, 1, 48);
INSERT INTO `attendes` VALUES (156, '12', NULL, 1, 48);
INSERT INTO `attendes` VALUES (157, '13', NULL, 1, 48);
INSERT INTO `attendes` VALUES (158, '14', NULL, 1, 48);
INSERT INTO `attendes` VALUES (159, '15', NULL, 1, 48);
INSERT INTO `attendes` VALUES (160, '9', NULL, 1, 49);
INSERT INTO `attendes` VALUES (161, '11', NULL, 1, 49);
INSERT INTO `attendes` VALUES (162, '10', NULL, 1, 49);
INSERT INTO `attendes` VALUES (163, '12', NULL, 1, 49);
INSERT INTO `attendes` VALUES (169, '9', NULL, 1, 51);
INSERT INTO `attendes` VALUES (170, '10', NULL, 1, 51);
INSERT INTO `attendes` VALUES (171, '11', NULL, 1, 51);
INSERT INTO `attendes` VALUES (172, '9', NULL, 1, 52);
INSERT INTO `attendes` VALUES (173, '10', NULL, 1, 52);
INSERT INTO `attendes` VALUES (174, '11', NULL, 1, 52);
INSERT INTO `attendes` VALUES (175, '12', NULL, 0, 52);
INSERT INTO `attendes` VALUES (176, '13', NULL, 0, 52);
INSERT INTO `attendes` VALUES (177, '14', NULL, 0, 52);
INSERT INTO `attendes` VALUES (178, '9', NULL, 0, 53);
INSERT INTO `attendes` VALUES (179, '10', NULL, 0, 53);
INSERT INTO `attendes` VALUES (180, '11', NULL, 0, 53);
INSERT INTO `attendes` VALUES (181, '12', NULL, 0, 53);
INSERT INTO `attendes` VALUES (182, '13', NULL, 0, 53);
INSERT INTO `attendes` VALUES (183, '9', NULL, 1, 54);
INSERT INTO `attendes` VALUES (184, '10', NULL, 1, 54);
INSERT INTO `attendes` VALUES (185, '11', NULL, 1, 54);
INSERT INTO `attendes` VALUES (186, '12', NULL, 1, 54);
INSERT INTO `attendes` VALUES (187, '13', NULL, 1, 54);
INSERT INTO `attendes` VALUES (188, '12', NULL, 1, 55);
INSERT INTO `attendes` VALUES (189, '9', NULL, 1, 55);
INSERT INTO `attendes` VALUES (190, '10', NULL, 1, 55);
INSERT INTO `attendes` VALUES (191, '11', NULL, 1, 55);
INSERT INTO `attendes` VALUES (192, '13', NULL, 1, 55);
INSERT INTO `attendes` VALUES (193, '14', NULL, 1, 55);
INSERT INTO `attendes` VALUES (194, '19', NULL, 1, 55);
INSERT INTO `attendes` VALUES (195, '9', NULL, 1, 56);
INSERT INTO `attendes` VALUES (196, '10', NULL, 1, 56);
INSERT INTO `attendes` VALUES (197, '27', NULL, 1, 56);
INSERT INTO `attendes` VALUES (198, '9', NULL, 1, 57);
INSERT INTO `attendes` VALUES (199, '10', NULL, 1, 57);
INSERT INTO `attendes` VALUES (200, '11', NULL, 1, 57);
INSERT INTO `attendes` VALUES (201, '12', NULL, 1, 57);
INSERT INTO `attendes` VALUES (202, '28', NULL, 1, 57);
INSERT INTO `attendes` VALUES (203, '27', NULL, 1, 57);
INSERT INTO `attendes` VALUES (204, '9', NULL, 1, 58);
INSERT INTO `attendes` VALUES (205, '10', NULL, 1, 58);
INSERT INTO `attendes` VALUES (210, '9', NULL, 1, 60);
INSERT INTO `attendes` VALUES (211, '10', NULL, 1, 60);
INSERT INTO `attendes` VALUES (212, '11', NULL, 1, 60);
INSERT INTO `attendes` VALUES (213, '14', NULL, 1, 60);
INSERT INTO `attendes` VALUES (214, '15', NULL, 1, 60);
INSERT INTO `attendes` VALUES (215, '16', NULL, 1, 60);
INSERT INTO `attendes` VALUES (216, '17', NULL, 1, 60);
INSERT INTO `attendes` VALUES (217, '36', NULL, 1, 60);
INSERT INTO `attendes` VALUES (218, '9', NULL, 1, 61);
INSERT INTO `attendes` VALUES (219, '10', NULL, 1, 61);
INSERT INTO `attendes` VALUES (220, '11', NULL, 1, 61);
INSERT INTO `attendes` VALUES (221, '12', NULL, 1, 61);
INSERT INTO `attendes` VALUES (222, '13', NULL, 1, 61);
INSERT INTO `attendes` VALUES (223, '9', NULL, 1, 62);
INSERT INTO `attendes` VALUES (224, '10', NULL, 1, 62);
INSERT INTO `attendes` VALUES (225, '11', NULL, 1, 62);
INSERT INTO `attendes` VALUES (226, '12', NULL, 1, 62);
INSERT INTO `attendes` VALUES (227, '13', NULL, 1, 62);
INSERT INTO `attendes` VALUES (228, '14', NULL, 1, 62);
INSERT INTO `attendes` VALUES (229, '9', NULL, 1, 63);
INSERT INTO `attendes` VALUES (230, '10', NULL, 1, 63);
INSERT INTO `attendes` VALUES (231, '11', NULL, 1, 63);
INSERT INTO `attendes` VALUES (232, '12', NULL, 0, 63);
INSERT INTO `attendes` VALUES (233, '13', NULL, 0, 63);
INSERT INTO `attendes` VALUES (234, '14', NULL, 0, 63);
INSERT INTO `attendes` VALUES (235, '44', NULL, 0, 63);
INSERT INTO `attendes` VALUES (236, '9', NULL, 1, 64);
INSERT INTO `attendes` VALUES (237, '10', NULL, 1, 64);
INSERT INTO `attendes` VALUES (238, '11', NULL, 1, 64);
INSERT INTO `attendes` VALUES (239, '16', NULL, 1, 64);
INSERT INTO `attendes` VALUES (240, '44', NULL, 1, 64);
INSERT INTO `attendes` VALUES (241, '29', NULL, 1, 64);
INSERT INTO `attendes` VALUES (242, '9', NULL, 1, 65);
INSERT INTO `attendes` VALUES (243, '10', NULL, 1, 65);
INSERT INTO `attendes` VALUES (244, '11', NULL, 1, 65);
INSERT INTO `attendes` VALUES (245, '12', NULL, 1, 65);
INSERT INTO `attendes` VALUES (246, '13', NULL, 0, 65);
INSERT INTO `attendes` VALUES (247, '14', NULL, 0, 65);
INSERT INTO `attendes` VALUES (248, '15', NULL, 0, 65);
INSERT INTO `attendes` VALUES (249, '16', NULL, 0, 65);
INSERT INTO `attendes` VALUES (250, '17', NULL, 0, 65);
INSERT INTO `attendes` VALUES (251, '18', NULL, 0, 65);
INSERT INTO `attendes` VALUES (265, '9', NULL, 0, 68);
INSERT INTO `attendes` VALUES (266, '10', NULL, 0, 68);
INSERT INTO `attendes` VALUES (267, '11', NULL, 0, 68);
INSERT INTO `attendes` VALUES (268, '12', NULL, 0, 68);
INSERT INTO `attendes` VALUES (269, '13', NULL, 0, 68);
INSERT INTO `attendes` VALUES (270, '14', NULL, 0, 68);
INSERT INTO `attendes` VALUES (271, '15', NULL, 0, 68);
INSERT INTO `attendes` VALUES (272, '16', NULL, 0, 68);
INSERT INTO `attendes` VALUES (273, '17', NULL, 0, 68);
INSERT INTO `attendes` VALUES (274, '18', NULL, 0, 68);
INSERT INTO `attendes` VALUES (275, '10', NULL, 1, 69);
INSERT INTO `attendes` VALUES (276, '9', NULL, 1, 69);
INSERT INTO `attendes` VALUES (277, '11', NULL, 1, 69);
INSERT INTO `attendes` VALUES (278, '12', NULL, 1, 69);
INSERT INTO `attendes` VALUES (279, '13', NULL, 1, 69);
INSERT INTO `attendes` VALUES (280, '14', NULL, 1, 69);
INSERT INTO `attendes` VALUES (281, '15', NULL, 1, 69);
INSERT INTO `attendes` VALUES (282, '44', NULL, 1, 69);
INSERT INTO `attendes` VALUES (283, '43', NULL, 1, 69);
INSERT INTO `attendes` VALUES (284, '29', NULL, 1, 70);
INSERT INTO `attendes` VALUES (285, '27', NULL, 1, 70);
INSERT INTO `attendes` VALUES (286, '26', NULL, 1, 70);
INSERT INTO `attendes` VALUES (287, '9', NULL, 1, 70);
INSERT INTO `attendes` VALUES (288, '29', NULL, 1, 71);
INSERT INTO `attendes` VALUES (289, '9', NULL, 1, 71);
INSERT INTO `attendes` VALUES (290, '10', NULL, 1, 71);
INSERT INTO `attendes` VALUES (291, '11', NULL, 1, 71);
INSERT INTO `attendes` VALUES (292, '12', NULL, 1, 71);
INSERT INTO `attendes` VALUES (293, '29', NULL, 1, 72);
INSERT INTO `attendes` VALUES (294, '9', NULL, 1, 72);
INSERT INTO `attendes` VALUES (295, '10', NULL, 1, 72);
INSERT INTO `attendes` VALUES (296, '11', NULL, 1, 72);
INSERT INTO `attendes` VALUES (297, '12', NULL, 1, 72);
INSERT INTO `attendes` VALUES (298, '36', NULL, 1, 73);
INSERT INTO `attendes` VALUES (299, '9', NULL, 1, 73);
INSERT INTO `attendes` VALUES (300, '10', NULL, 1, 73);
INSERT INTO `attendes` VALUES (301, '11', NULL, 1, 73);
INSERT INTO `attendes` VALUES (302, '12', NULL, 1, 73);
INSERT INTO `attendes` VALUES (303, '13', NULL, 1, 73);
INSERT INTO `attendes` VALUES (304, '14', NULL, 1, 73);
INSERT INTO `attendes` VALUES (305, '15', NULL, 1, 73);
INSERT INTO `attendes` VALUES (306, '29', NULL, 1, 74);
INSERT INTO `attendes` VALUES (307, '9', NULL, 1, 74);
INSERT INTO `attendes` VALUES (308, '10', NULL, 1, 74);
INSERT INTO `attendes` VALUES (309, '11', NULL, 1, 74);
INSERT INTO `attendes` VALUES (310, '12', NULL, 1, 74);
INSERT INTO `attendes` VALUES (311, '13', NULL, 0, 74);
INSERT INTO `attendes` VALUES (312, '14', NULL, 0, 74);
INSERT INTO `attendes` VALUES (313, '15', NULL, 0, 74);
INSERT INTO `attendes` VALUES (314, '16', NULL, 0, 74);
INSERT INTO `attendes` VALUES (315, '36', NULL, 0, 74);
INSERT INTO `attendes` VALUES (316, '29', NULL, 1, 75);
INSERT INTO `attendes` VALUES (317, '9', NULL, 1, 75);
INSERT INTO `attendes` VALUES (318, '10', NULL, 1, 75);
INSERT INTO `attendes` VALUES (319, '11', NULL, 1, 75);
INSERT INTO `attendes` VALUES (320, '12', NULL, 1, 75);
INSERT INTO `attendes` VALUES (321, '13', NULL, 1, 75);
INSERT INTO `attendes` VALUES (322, '14', NULL, 1, 75);
INSERT INTO `attendes` VALUES (323, '29', NULL, 0, 76);
INSERT INTO `attendes` VALUES (324, '10', NULL, 0, 76);
INSERT INTO `attendes` VALUES (325, '9', NULL, 0, 76);
INSERT INTO `attendes` VALUES (326, '11', NULL, 0, 76);
INSERT INTO `attendes` VALUES (327, '12', NULL, 0, 76);
INSERT INTO `attendes` VALUES (328, '13', NULL, 0, 76);
INSERT INTO `attendes` VALUES (329, '14', NULL, 0, 76);
INSERT INTO `attendes` VALUES (330, '44', NULL, 0, 77);
INSERT INTO `attendes` VALUES (331, '11', NULL, 0, 77);
INSERT INTO `attendes` VALUES (332, '10', NULL, 0, 77);
INSERT INTO `attendes` VALUES (333, '9', NULL, 0, 77);
INSERT INTO `attendes` VALUES (334, '29', NULL, 0, 77);

-- ----------------------------
-- Table structure for confattr
-- ----------------------------
DROP TABLE IF EXISTS `confattr`;
CREATE TABLE `confattr`  (
  `confid` int(11) NOT NULL COMMENT '会议编号',
  `confattrid` int(11) NOT NULL COMMENT '会议属性编号',
  PRIMARY KEY (`confid`, `confattrid`) USING BTREE,
  INDEX `fk_confattr_confattrid`(`confattrid`) USING BTREE,
  CONSTRAINT `fk_confattr_confattrid` FOREIGN KEY (`confattrid`) REFERENCES `confattributes` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fk_confattr_confid` FOREIGN KEY (`confid`) REFERENCES `conference` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of confattr
-- ----------------------------
INSERT INTO `confattr` VALUES (20, 20);
INSERT INTO `confattr` VALUES (22, 20);
INSERT INTO `confattr` VALUES (25, 20);
INSERT INTO `confattr` VALUES (28, 20);
INSERT INTO `confattr` VALUES (29, 20);
INSERT INTO `confattr` VALUES (30, 20);
INSERT INTO `confattr` VALUES (31, 20);
INSERT INTO `confattr` VALUES (33, 20);
INSERT INTO `confattr` VALUES (34, 20);
INSERT INTO `confattr` VALUES (36, 20);
INSERT INTO `confattr` VALUES (38, 20);
INSERT INTO `confattr` VALUES (40, 20);
INSERT INTO `confattr` VALUES (43, 20);
INSERT INTO `confattr` VALUES (45, 20);
INSERT INTO `confattr` VALUES (48, 20);
INSERT INTO `confattr` VALUES (57, 20);
INSERT INTO `confattr` VALUES (61, 20);
INSERT INTO `confattr` VALUES (70, 20);
INSERT INTO `confattr` VALUES (73, 20);
INSERT INTO `confattr` VALUES (75, 20);
INSERT INTO `confattr` VALUES (77, 20);
INSERT INTO `confattr` VALUES (19, 21);
INSERT INTO `confattr` VALUES (20, 21);
INSERT INTO `confattr` VALUES (23, 21);
INSERT INTO `confattr` VALUES (24, 21);
INSERT INTO `confattr` VALUES (25, 21);
INSERT INTO `confattr` VALUES (27, 21);
INSERT INTO `confattr` VALUES (28, 21);
INSERT INTO `confattr` VALUES (30, 21);
INSERT INTO `confattr` VALUES (31, 21);
INSERT INTO `confattr` VALUES (33, 21);
INSERT INTO `confattr` VALUES (34, 21);
INSERT INTO `confattr` VALUES (38, 21);
INSERT INTO `confattr` VALUES (39, 21);
INSERT INTO `confattr` VALUES (40, 21);
INSERT INTO `confattr` VALUES (43, 21);
INSERT INTO `confattr` VALUES (46, 21);
INSERT INTO `confattr` VALUES (48, 21);
INSERT INTO `confattr` VALUES (57, 21);
INSERT INTO `confattr` VALUES (61, 21);
INSERT INTO `confattr` VALUES (65, 21);
INSERT INTO `confattr` VALUES (70, 21);
INSERT INTO `confattr` VALUES (71, 21);
INSERT INTO `confattr` VALUES (72, 21);
INSERT INTO `confattr` VALUES (73, 21);
INSERT INTO `confattr` VALUES (74, 21);
INSERT INTO `confattr` VALUES (75, 21);
INSERT INTO `confattr` VALUES (77, 21);
INSERT INTO `confattr` VALUES (19, 22);
INSERT INTO `confattr` VALUES (20, 22);
INSERT INTO `confattr` VALUES (26, 22);
INSERT INTO `confattr` VALUES (27, 22);
INSERT INTO `confattr` VALUES (36, 22);
INSERT INTO `confattr` VALUES (39, 22);
INSERT INTO `confattr` VALUES (56, 22);
INSERT INTO `confattr` VALUES (61, 22);
INSERT INTO `confattr` VALUES (62, 22);
INSERT INTO `confattr` VALUES (65, 22);
INSERT INTO `confattr` VALUES (68, 22);
INSERT INTO `confattr` VALUES (73, 22);
INSERT INTO `confattr` VALUES (74, 22);
INSERT INTO `confattr` VALUES (77, 22);
INSERT INTO `confattr` VALUES (21, 23);
INSERT INTO `confattr` VALUES (26, 23);
INSERT INTO `confattr` VALUES (35, 23);
INSERT INTO `confattr` VALUES (37, 23);
INSERT INTO `confattr` VALUES (41, 23);
INSERT INTO `confattr` VALUES (45, 23);
INSERT INTO `confattr` VALUES (46, 23);
INSERT INTO `confattr` VALUES (51, 23);
INSERT INTO `confattr` VALUES (52, 23);
INSERT INTO `confattr` VALUES (53, 23);
INSERT INTO `confattr` VALUES (55, 23);
INSERT INTO `confattr` VALUES (56, 23);
INSERT INTO `confattr` VALUES (62, 23);
INSERT INTO `confattr` VALUES (64, 23);
INSERT INTO `confattr` VALUES (68, 23);
INSERT INTO `confattr` VALUES (71, 23);
INSERT INTO `confattr` VALUES (74, 23);
INSERT INTO `confattr` VALUES (75, 23);
INSERT INTO `confattr` VALUES (76, 23);
INSERT INTO `confattr` VALUES (26, 24);
INSERT INTO `confattr` VALUES (29, 24);
INSERT INTO `confattr` VALUES (32, 24);
INSERT INTO `confattr` VALUES (41, 24);
INSERT INTO `confattr` VALUES (44, 24);
INSERT INTO `confattr` VALUES (45, 24);
INSERT INTO `confattr` VALUES (47, 24);
INSERT INTO `confattr` VALUES (52, 24);
INSERT INTO `confattr` VALUES (53, 24);
INSERT INTO `confattr` VALUES (58, 24);
INSERT INTO `confattr` VALUES (60, 24);
INSERT INTO `confattr` VALUES (63, 24);
INSERT INTO `confattr` VALUES (64, 24);
INSERT INTO `confattr` VALUES (69, 24);
INSERT INTO `confattr` VALUES (75, 24);
INSERT INTO `confattr` VALUES (76, 24);
INSERT INTO `confattr` VALUES (21, 25);
INSERT INTO `confattr` VALUES (29, 25);
INSERT INTO `confattr` VALUES (37, 25);
INSERT INTO `confattr` VALUES (44, 25);
INSERT INTO `confattr` VALUES (47, 25);
INSERT INTO `confattr` VALUES (51, 25);
INSERT INTO `confattr` VALUES (52, 25);
INSERT INTO `confattr` VALUES (54, 25);
INSERT INTO `confattr` VALUES (55, 25);
INSERT INTO `confattr` VALUES (58, 25);
INSERT INTO `confattr` VALUES (60, 25);
INSERT INTO `confattr` VALUES (63, 25);
INSERT INTO `confattr` VALUES (69, 25);
INSERT INTO `confattr` VALUES (76, 25);
INSERT INTO `confattr` VALUES (49, 26);
INSERT INTO `confattr` VALUES (54, 26);

-- ----------------------------
-- Table structure for confattributes
-- ----------------------------
DROP TABLE IF EXISTS `confattributes`;
CREATE TABLE `confattributes`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attrname` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '属性名称',
  `attrdes` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '属性描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of confattributes
-- ----------------------------
INSERT INTO `confattributes` VALUES (20, '01', '支部党员大会');
INSERT INTO `confattributes` VALUES (21, '02', '党支部委员会');
INSERT INTO `confattributes` VALUES (22, '03', '党小组会');
INSERT INTO `confattributes` VALUES (23, '04', '党日活动');
INSERT INTO `confattributes` VALUES (24, '05', '党课');
INSERT INTO `confattributes` VALUES (25, '06', '组织生活会');
INSERT INTO `confattributes` VALUES (26, '07', '发展党员');
INSERT INTO `confattributes` VALUES (27, '08', '民主评议党员');
INSERT INTO `confattributes` VALUES (28, '09', '其他');

-- ----------------------------
-- Table structure for conference
-- ----------------------------
DROP TABLE IF EXISTS `conference`;
CREATE TABLE `conference`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `confname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会议名称',
  `semesterid` int(11) DEFAULT NULL COMMENT '学期编号',
  `conflevelid` int(11) DEFAULT NULL COMMENT '会议级别编号->会议类别编号',
  `confstatusid` int(11) DEFAULT NULL COMMENT '会议状态编号',
  `hosterid` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主持人工号',
  `hoster` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主持人姓名',
  `recorderid` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '记录人工号',
  `recorder` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '记录人姓名',
  `conclusion` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '形成的决议，决议内容',
  `abstractcont` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '会议摘要',
  `confqrcodeurl` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会议二维码地址',
  `meetcollectid` int(11) DEFAULT NULL COMMENT '会议议题采集编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_conference_meetcollectid`(`meetcollectid`) USING BTREE,
  INDEX `fk_conference_conflevelid`(`conflevelid`) USING BTREE,
  INDEX `fk_conference_confstatusid`(`confstatusid`) USING BTREE,
  INDEX `fk_conference_semesterid`(`semesterid`) USING BTREE,
  CONSTRAINT `fk_conference_conflevelid` FOREIGN KEY (`conflevelid`) REFERENCES `conflevel` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT,
  CONSTRAINT `fk_conference_confstatusid` FOREIGN KEY (`confstatusid`) REFERENCES `confstatus` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT,
  CONSTRAINT `fk_conference_meetcollectid` FOREIGN KEY (`meetcollectid`) REFERENCES `meetingcollect` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fk_conference_semesterid` FOREIGN KEY (`semesterid`) REFERENCES `semester` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of conference
-- ----------------------------
INSERT INTO `conference` VALUES (19, '关于选拔优秀学生干部的决定', 40, 13, 2, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 22);
INSERT INTO `conference` VALUES (20, '关于研究生选修课程计划的讨论', 40, 14, 101, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 23);
INSERT INTO `conference` VALUES (21, '关于开展学生综合素质发展讨论', 40, 13, 1, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 24);
INSERT INTO `conference` VALUES (22, 'hello world python 代码大赛', 40, 13, 2, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 25);
INSERT INTO `conference` VALUES (23, 'java web开发大赛', 40, 14, 1, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 26);
INSERT INTO `conference` VALUES (24, '关于开展c#编程算法大赛', 55, 13, 1, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 27);
INSERT INTO `conference` VALUES (25, '房间卡的撒积分卡洛斯', 40, 13, 2, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 28);
INSERT INTO `conference` VALUES (26, '关于开展全国大学生机器学习算法大赛的安排', 55, 14, 2, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 29);
INSERT INTO `conference` VALUES (27, '研究生计算机编程大赛的安排', 56, 14, 2, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 30);
INSERT INTO `conference` VALUES (28, 'fjsdklafjskdljfaklsd;', 40, 13, 2, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 31);
INSERT INTO `conference` VALUES (29, '富士达范德萨发士大夫撒旦', 40, 13, 2, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 32);
INSERT INTO `conference` VALUES (30, '12121212', 40, 13, 2, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 33);
INSERT INTO `conference` VALUES (31, '关于江苏科技大学更名为华东科技大学的通知', 40, 13, 2, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 34);
INSERT INTO `conference` VALUES (32, '关于组织计算机学院的期末考试', 40, 14, 2, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 35);
INSERT INTO `conference` VALUES (33, '212', 40, 13, 2, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 36);
INSERT INTO `conference` VALUES (34, '房间卡的撒积分看电视剧啊', 40, 13, 2, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 37);
INSERT INTO `conference` VALUES (35, '2121212', 40, 13, 2, '29', NULL, '9', '陈鹏', NULL, NULL, NULL, 38);
INSERT INTO `conference` VALUES (36, '姜思达附近开始啦', 40, 13, 2, '29', NULL, '9', '陈鹏', NULL, NULL, NULL, 39);
INSERT INTO `conference` VALUES (37, '及防水款了', 40, 14, 1, '29', NULL, '9', '陈鹏', NULL, NULL, NULL, 40);
INSERT INTO `conference` VALUES (38, '313', 40, 13, 1, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 41);
INSERT INTO `conference` VALUES (39, '房间卡萨的拉分', 40, 13, 2, '29', NULL, '9', '陈鹏', NULL, NULL, NULL, 42);
INSERT INTO `conference` VALUES (40, '1212121212', 40, 14, 2, '29', NULL, '9', '陈鹏', NULL, NULL, NULL, 43);
INSERT INTO `conference` VALUES (41, '21212', 40, 13, 2, '29', NULL, '9', '陈鹏', '<p style=\"text-align: center;\"><span style=\"font-size: 18pt; color: #e74c3c;\">JiangSu University of Science &amp; Technology</span></p>\n<p style=\"text-align: center;\"><span style=\"color: #e74c3c; font-size: 18pt;\">江苏科技大学</span></p>\n<p style=\"text-align: center;\">&nbsp;</p>\n<table style=\"border-collapse: collapse; width: 100%; height: 60px;\" border=\"1\">\n<tbody>\n<tr style=\"height: 20px;\">\n<td style=\"width: 14.2857%; height: 20px;\">附近的萨卡</td>\n<td style=\"width: 14.2857%; height: 20px;\">福建师大看</td>\n<td style=\"width: 14.2857%; height: 20px;\">福建省考虑</td>\n<td style=\"width: 14.2857%; height: 20px;\">福建师大卡了</td>\n<td style=\"width: 14.2857%; height: 20px;\">福建师大看</td>\n<td style=\"width: 14.2857%; height: 20px;\">飞机上看</td>\n<td style=\"width: 14.2857%; height: 20px;\">&nbsp;</td>\n</tr>\n<tr style=\"height: 20px;\">\n<td style=\"width: 14.2857%; height: 20px;\">&nbsp;</td>\n<td style=\"width: 14.2857%; height: 20px;\">房间卡是&nbsp;&nbsp;</td>\n<td style=\"width: 14.2857%; height: 20px;\">飞机上看</td>\n<td style=\"width: 14.2857%; height: 20px;\">富士康的</td>\n<td style=\"width: 14.2857%; height: 20px;\">福建省科技</td>\n<td style=\"width: 14.2857%; height: 20px;\">福建师范大学</td>\n<td style=\"width: 14.2857%; height: 20px;\">江苏师范大学</td>\n</tr>\n<tr style=\"height: 20px;\">\n<td style=\"width: 14.2857%; height: 20px;\">河南师范大学</td>\n<td style=\"width: 14.2857%; height: 20px;\">中国石油大学</td>\n<td style=\"width: 14.2857%; height: 20px;\">中国矿业大学</td>\n<td style=\"width: 14.2857%; height: 20px;\">中国药科大学</td>\n<td style=\"width: 14.2857%; height: 20px;\">中国农业大学</td>\n<td style=\"width: 14.2857%; height: 20px;\">中央财经大学</td>\n<td style=\"width: 14.2857%; height: 20px;\">&nbsp;</td>\n</tr>\n</tbody>\n</table>\n<p style=\"text-align: justify;\">&nbsp;</p>', NULL, NULL, 44);
INSERT INTO `conference` VALUES (43, '1212', 40, 14, 5, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 46);
INSERT INTO `conference` VALUES (44, '关与推进江苏科技大学推进一流大学的工作部署', 40, 14, 4, '9', NULL, '9', '陈鹏', NULL, NULL, NULL, 47);
INSERT INTO `conference` VALUES (45, '21212', 40, 13, 5, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 48);
INSERT INTO `conference` VALUES (46, '2121212', 58, 13, 102, '10', NULL, '9', '陈鹏', '<p>12222222222222222222222222222222222222</p>\n<p>fdsafdsssssssssssssssssssssssssssssssssssssssssss</p>\n<p>&nbsp;</p>\n<p>&nbsp;</p>\n<p>fsdddddddddddddddddddddddddddddddddgrewg</p>', NULL, NULL, 49);
INSERT INTO `conference` VALUES (47, '212121212', 40, 13, 4, '11', NULL, '9', '陈鹏', '<p>房贷卡撒附近的卡萨房间卡萨</p>\n<p>飞机上看f房贷卡</p>\n<p>飞机上看</p>\n<p>房贷卡</p>\n<p>房贷卡啦</p>\n<p>富士达</p>\n<p>房贷卡</p>\n<p>房间卡萨</p>\n<p>积分卡萨</p>\n<p>房贷卡啦三房间卡拉是房间卡案发</p>', NULL, NULL, 50);
INSERT INTO `conference` VALUES (48, '华中科技大学东南的健身卡', 58, 13, 5, '14', NULL, '9', '陈鹏', '<p>jfkldsajfdsklafjdslafjdklsaf;sdjfdkla</p>\n<p>fjsdklafjdksla</p>\n<p>fjdsklafjjsdkla</p>\n<p>fjsdklafjdskla</p>\n<p>fsdjklfjksdllll</p>', NULL, NULL, 51);
INSERT INTO `conference` VALUES (49, '范德萨范德萨发三', 57, 13, 5, '29', NULL, '10', '张萌萌', '<p>附近的萨卡发dsa范德萨a今飞凯达三</p>\n<p>发的手机卡啦</p>\n<p>反倒是看见啊了</p>\n<p>发的撒娇KL</p>\n<p>发的撒娇KL</p>\n<p>发生的金卡</p>\n<p>富士达金坷垃f圣诞节看了</p>\n<p>发的手机卡啦</p>\n<p>发的手机卡啦</p>', NULL, NULL, 52);
INSERT INTO `conference` VALUES (51, '1212', 58, 13, 4, '9', NULL, '10', '张萌萌', '<p>及罚款了房间卡萨见覅看老家啊发大水啦荆防颗粒三a放暑假卡</p>\n<p>放暑假卡 放暑假卡</p>\n<p>飞机上看发静安寺</p>\n<p>放暑假卡f是金坷垃发仨贱客</p>\n<p>付刷卡费的夹杂f啥积分卡萨</p>\n<p>副书记啊放暑假卡</p>\n<p>放暑假卡富士达会计法大</p>', NULL, NULL, 54);
INSERT INTO `conference` VALUES (52, '3243254325432543', 58, 13, 4, NULL, NULL, '9', '陈鹏', '<p style=\"margin: 3px 0px 20px; padding: 0px; color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px; background-color: #ffffff;\"><span style=\"font-size: 18pt;\"><strong><span style=\"background-color: #f1c40f; color: #000000;\">1、标题</span></strong></span></p>\n<p style=\"margin: 20px 0px; padding: 0px; color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px; background-color: #ffffff;\">文件式标题　一般由单位名称、时限、内容、文种名称构成。例：《局 XX年度拥军拥属工作总结》。</p>\n<p style=\"margin: 20px 0px; padding: 0px; color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px; background-color: #ffffff;\">文章式标题　以单行标题概括主要内容或基本观点，不出现总结字样，但对总结内容有提示作用。例某高校的专题总结《我们是如何实行教学与科研相结合的》。</p>\n<p style=\"margin: 20px 0px; padding: 0px; color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px; background-color: #ffffff;\">双行式标题　即分别以文章式标题和文件式标题为正副标题，正标题揭示观点或概括内容，副标题点明单位、时限、性质和总结种类。例：《知名教授上讲台　教书育人放异彩&mdash;&mdash; 大学德育工作总结》。</p>\n<p style=\"margin: 20px 0px; padding: 0px; color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px; background-color: #ffffff;\"><span style=\"text-decoration: underline;\"><strong><span style=\"background-color: #f1c40f; font-size: 14pt;\">2、正文</span></strong></span></p>\n<p style=\"margin: 20px 0px; padding: 0px; color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px; background-color: #ffffff;\">前言　一般介绍工作背景、基本概况等，也可交待总结主旨并作出基本评价。开头力求简洁，开宗明义。</p>\n<p style=\"margin: 20px 0px; padding: 0px; color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px; background-color: #ffffff;\">主体 应包括主要工作内容、成绩及评价、经验和体会、问题或教训等。这些内容是总结的核心部分，可按纵式或横式结构形式撰写。所谓纵式结构，即按主体内容纵向所做的工作、方法、成绩、经验、教训等逐层展开。所谓横式结构即按材料的逻辑关系将其分成若干部分， 标序加题，逐一写来。</p>\n<p style=\"margin: 20px 0px; padding: 0px; color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px; background-color: #ffffff;\">结尾 作为结的结束语可以归纳呼应主题、指出努力方向、提出改进意见或表示决心信心等语作结，要求简短精练。</p>\n<p style=\"margin: 20px 0px; padding: 0px; color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px; background-color: #ffffff;\"><span style=\"font-size: 14pt;\"><strong><span style=\"background-color: #f1c40f;\">3、落款 一般在正文右下方署名署时。如是报刊杂志或简报刊用的交流经验的专题总结，应在标题下方居中署名。</span></strong></span></p>\n<p style=\"margin: 26px 0px; padding: 0px; color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px; background-color: #ffffff;\"><img src=\"https://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D600%2C800/sign=cf0a0cec7e0e0cf3a0a246fd3a76de27/eac4b74543a9822690a48ad98682b9014b90ebe3.jpg\" alt=\"开会\" width=\"170\" height=\"240\" /></p>\n<p style=\"margin: 26px 0px; padding: 0px; color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px; background-color: #ffffff;\">&nbsp;</p>', NULL, NULL, 55);
INSERT INTO `conference` VALUES (53, 'jfklajfksa', 58, 15, 1, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 56);
INSERT INTO `conference` VALUES (54, '测试会议预约', 58, 14, 1, NULL, NULL, '9', '陈鹏', NULL, NULL, NULL, 57);
INSERT INTO `conference` VALUES (55, '关于开展硕士生毕业论文答辩工作事宜', 58, 16, 5, '10', NULL, '9', '陈鹏', '<p><span style=\"font-size: 14pt;\">会议加了路飞的穆斯卡拉</span></p>\n<p><span style=\"font-size: 14pt;\">1.复健科到拉萨反馈sd</span></p>\n<p><span style=\"font-size: 14pt;\">2.反馈说多了afjksdl</span></p>\n<p><span style=\"font-size: 14pt;\">家。反倒是卡啦fds&nbsp;</span></p>\n<p><span style=\"color: #e67e23;\">发生的金卡啦发大<a title=\"东南大学\" href=\"http://www.baidu.com\" target=\"_blank\" rel=\"noopener\">东南的那可是</a></span></p>\n<p><span style=\"color: #e67e23;\">发动机开始啦fs房间卡萨的了</span></p>\n<p>&nbsp;</p>\n<p>放暑假卡的</p>', NULL, NULL, 58);
INSERT INTO `conference` VALUES (56, '关于江苏江苏科技大学更名为江苏信息工程大学的决议', 58, 13, 1, '9', NULL, '27', '河海大学', NULL, NULL, NULL, 59);
INSERT INTO `conference` VALUES (57, '关于开展研究生工作事宜', 58, 13, 4, '9', NULL, '27', '河海大学', '<p><span style=\"font-size: 18pt;\"><strong>放假咖啡较卡福晶科技案发</strong></span></p>\n<p><span style=\"font-size: 18pt;\"><strong>房间卡拉发</strong></span></p>\n<p><span style=\"font-size: 18pt;\"><strong>房间卡拉ffj</strong></span></p>\n<p><span style=\"font-size: 18pt;\"><strong>房间卡拉福建省看到</strong></span></p>\n<p><span style=\"font-size: 18pt;\"><strong>减肥的扣三分第三方j</strong></span></p>\n<p><span style=\"font-size: 18pt;\"><strong>非建安路房间卡发大水发动机a</strong></span></p>\n<p><span style=\"font-size: 18pt;\"><strong>房间卡拉发是</strong></span></p>', NULL, NULL, 60);
INSERT INTO `conference` VALUES (58, '2121212', 58, 13, 4, '10', NULL, '27', '河海大学', NULL, NULL, NULL, 61);
INSERT INTO `conference` VALUES (60, '212121', 58, 13, 1, '29', NULL, '41', 'chenpeng', '<p>dsDSadsaDSADSAFDSAFDSAFDS</p>\n<p>FDSAFDSAFDSAFDSAFDS</p>\n<p>FD</p>\n<p>SAF</p>\n<p>DS</p>\n<p>AF</p>\n<p>D</p>\n<p>SAF</p>\n<p>DS</p>\n<p>AF</p>\n<p>DSA</p>', NULL, NULL, 63);
INSERT INTO `conference` VALUES (61, '办公会议', 57, 14, 5, '29', NULL, '30', '测试', NULL, NULL, NULL, 64);
INSERT INTO `conference` VALUES (62, '发进度款酸辣粉发的手机卡了', 58, 15, 1, '10', NULL, '29', 'demo', NULL, NULL, NULL, 65);
INSERT INTO `conference` VALUES (63, '而台湾其他人', 58, 13, 1, NULL, NULL, '44', 'thompson', NULL, NULL, NULL, 66);
INSERT INTO `conference` VALUES (64, '人生几何，。。。。。', 58, 14, 1, '27', NULL, '29', 'demo', '<p>dsafdsafdsafdsafdsafdsafsdafsda</p>', NULL, NULL, 67);
INSERT INTO `conference` VALUES (65, 'fjdkslafjdskalfjdsklafjkl', 58, 14, 2, '44', NULL, '44', 'thompson', NULL, NULL, NULL, 68);
INSERT INTO `conference` VALUES (68, '1212', 58, 13, 1, '27', NULL, '29', 'demo', NULL, NULL, NULL, 71);
INSERT INTO `conference` VALUES (69, 'fdffffffffffffff', 58, 13, 1, '44', NULL, '29', 'demo', '<p><span style=\"color: #e67e23;\">附近的斯卡拉积分第三款啦就狂蜂浪蝶三jf</span></p>\n<p><span style=\"color: #e67e23;\">发动机斯科拉附近的斯卡拉</span></p>\n<p><span style=\"color: #e67e23;\">发电视机卡立方是的</span></p>\n<p>&nbsp;</p>\n<p><span style=\"color: #e67e23;\">发电视机卡立方的思考了</span></p>\n<p><span style=\"color: #e67e23;\">发的手机卡啦浪费大健康了房间卡拉第三</span></p>\n<p><span style=\"color: #e67e23;\">发动机斯科拉发角度看了撒</span></p>\n<p><span style=\"color: #e67e23;\">发的手机卡啦了附近的斯卡拉</span></p>\n<p><span style=\"color: #e67e23;\">发的手机卡了房间卡拉第三</span></p>\n<p><span style=\"color: #e67e23;\">发的手机卡了发角度看死啦</span></p>', NULL, NULL, 72);
INSERT INTO `conference` VALUES (70, '附近的斯卡拉附近的卡萨', 57, 14, 1, '29', NULL, '29', 'demo', NULL, NULL, NULL, 73);
INSERT INTO `conference` VALUES (71, '关于开展2018届硕士论文开题的工作通知', 58, 14, 1, '9', NULL, '29', 'demo', NULL, NULL, NULL, 74);
INSERT INTO `conference` VALUES (72, '放得开三江安付款了第三积分卡拉斯大进口量发送端口了', 58, 14, 4, '9', NULL, '29', 'demo', NULL, NULL, NULL, 75);
INSERT INTO `conference` VALUES (73, '关于发动机声卡附近的卡萨房间卡拉第三', 58, 15, 1, '36', NULL, '36', '清华大学', NULL, NULL, NULL, 76);
INSERT INTO `conference` VALUES (74, '453254325432', 58, 13, 1, '36', NULL, '29', 'demo', NULL, NULL, NULL, 77);
INSERT INTO `conference` VALUES (75, '功夫大使馆范德萨高德', 56, 14, 5, '29', NULL, '29', 'demo', NULL, NULL, NULL, 78);
INSERT INTO `conference` VALUES (76, '关于开展研究生开题答辩的工作组织会议', 58, 14, 3, '29', NULL, '29', 'demo', NULL, NULL, NULL, 79);
INSERT INTO `conference` VALUES (77, '江苏科技大附近的萨卡九分裤数据库', 58, 14, 3, '44', NULL, '44', 'thompson', NULL, NULL, NULL, 80);

-- ----------------------------
-- Table structure for conflevel
-- ----------------------------
DROP TABLE IF EXISTS `conflevel`;
CREATE TABLE `conflevel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `levelname` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会议名称',
  `leveldes` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '级别描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of conflevel
-- ----------------------------
INSERT INTO `conflevel` VALUES (13, '学术会议', '学术会议');
INSERT INTO `conflevel` VALUES (14, '办公会议', '办公会议');
INSERT INTO `conflevel` VALUES (15, '党委会议', '党委会议');
INSERT INTO `conflevel` VALUES (16, '其他', '其他');

-- ----------------------------
-- Table structure for confmeetingroom
-- ----------------------------
DROP TABLE IF EXISTS `confmeetingroom`;
CREATE TABLE `confmeetingroom`  (
  `confid` int(11) NOT NULL COMMENT '会议室编号',
  `meetroomid` int(11) NOT NULL COMMENT '会议编号',
  `starttime` datetime(0) DEFAULT NULL,
  `endtime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`confid`, `meetroomid`) USING BTREE,
  INDEX `fk_confmeetingroom_meetroomid`(`meetroomid`) USING BTREE,
  CONSTRAINT `fk_confmeetingroom_confid` FOREIGN KEY (`confid`) REFERENCES `conference` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fk_confmeetingroom_meetroomid` FOREIGN KEY (`meetroomid`) REFERENCES `meetingroom` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of confmeetingroom
-- ----------------------------
INSERT INTO `confmeetingroom` VALUES (19, 1, '2019-05-21 13:30:00', '2019-05-21 15:30:00');
INSERT INTO `confmeetingroom` VALUES (20, 1, '2019-05-20 07:00:00', '2019-05-20 09:00:00');
INSERT INTO `confmeetingroom` VALUES (21, 1, '2019-05-22 07:30:00', '2019-05-22 09:30:00');
INSERT INTO `confmeetingroom` VALUES (22, 1, '2019-05-22 11:00:00', '2019-05-22 13:00:00');
INSERT INTO `confmeetingroom` VALUES (23, 1, '2019-05-22 14:30:00', '2019-05-22 16:30:00');
INSERT INTO `confmeetingroom` VALUES (24, 1, '2019-05-23 07:00:00', '2019-05-23 11:00:00');
INSERT INTO `confmeetingroom` VALUES (25, 1, '2019-05-23 12:30:00', '2019-05-23 15:00:00');
INSERT INTO `confmeetingroom` VALUES (26, 1, '2019-05-23 15:30:00', '2019-05-23 18:00:00');
INSERT INTO `confmeetingroom` VALUES (27, 2, '2019-05-23 07:00:00', '2019-05-23 10:00:00');
INSERT INTO `confmeetingroom` VALUES (28, 1, '2019-05-24 15:30:00', '2019-05-24 17:30:00');
INSERT INTO `confmeetingroom` VALUES (29, 1, '2019-05-25 12:30:00', '2019-05-25 15:30:00');
INSERT INTO `confmeetingroom` VALUES (30, 1, '2019-05-26 08:00:00', '2019-05-26 11:00:00');
INSERT INTO `confmeetingroom` VALUES (31, 1, '2019-05-27 10:30:00', '2019-05-27 13:00:00');
INSERT INTO `confmeetingroom` VALUES (32, 1, '2019-05-29 08:30:00', '2019-05-29 10:30:00');
INSERT INTO `confmeetingroom` VALUES (33, 1, '2019-05-30 10:30:00', '2019-05-30 13:00:00');
INSERT INTO `confmeetingroom` VALUES (34, 1, '2019-05-31 09:00:00', '2019-05-31 12:30:00');
INSERT INTO `confmeetingroom` VALUES (35, 1, '2019-06-11 09:00:00', '2019-06-11 11:00:00');
INSERT INTO `confmeetingroom` VALUES (36, 20, '2019-06-04 12:00:00', '2019-06-18 12:00:00');
INSERT INTO `confmeetingroom` VALUES (37, 1, '2019-06-20 08:30:00', '2019-06-20 10:30:00');
INSERT INTO `confmeetingroom` VALUES (38, 1, '2019-06-27 11:30:00', '2019-06-27 13:30:00');
INSERT INTO `confmeetingroom` VALUES (39, 1, '2019-06-28 08:00:00', '2019-06-28 10:30:00');
INSERT INTO `confmeetingroom` VALUES (40, 1, '2019-06-29 09:30:00', '2019-06-29 12:30:00');
INSERT INTO `confmeetingroom` VALUES (41, 1, '2019-07-03 09:00:00', '2019-07-03 11:30:00');
INSERT INTO `confmeetingroom` VALUES (43, 1, '2019-07-05 11:30:00', '2019-07-05 13:30:00');
INSERT INTO `confmeetingroom` VALUES (44, 1, '2019-07-06 10:00:00', '2019-07-06 11:30:00');
INSERT INTO `confmeetingroom` VALUES (45, 2, '2019-07-11 08:30:00', '2019-07-11 11:30:00');
INSERT INTO `confmeetingroom` VALUES (46, 1, '2019-07-26 09:30:00', '2019-07-26 11:30:00');
INSERT INTO `confmeetingroom` VALUES (47, 15, '2019-07-29 08:00:00', '2019-07-29 10:30:00');
INSERT INTO `confmeetingroom` VALUES (48, 1, '2019-08-01 08:30:00', '2019-08-01 11:00:00');
INSERT INTO `confmeetingroom` VALUES (49, 14, '2019-08-03 11:00:00', '2019-08-03 13:00:00');
INSERT INTO `confmeetingroom` VALUES (51, 1, '2019-08-06 14:30:00', '2019-08-06 16:00:00');
INSERT INTO `confmeetingroom` VALUES (52, 1, '2019-08-08 14:00:00', '2019-08-08 16:00:00');
INSERT INTO `confmeetingroom` VALUES (53, 1, '2019-08-14 09:00:00', '2019-08-14 10:30:00');
INSERT INTO `confmeetingroom` VALUES (54, 1, '2019-08-15 11:00:00', '2019-08-15 12:30:00');
INSERT INTO `confmeetingroom` VALUES (55, 1, '2019-08-17 08:00:00', '2019-08-17 10:00:00');
INSERT INTO `confmeetingroom` VALUES (56, 1, '2019-08-21 09:00:00', '2019-08-21 11:00:00');
INSERT INTO `confmeetingroom` VALUES (57, 1, '2019-08-19 10:00:00', '2019-08-19 12:00:00');
INSERT INTO `confmeetingroom` VALUES (58, 1, '2019-08-23 10:00:00', '2019-08-23 11:30:00');
INSERT INTO `confmeetingroom` VALUES (60, 1, '2019-08-29 09:00:00', '2019-08-29 10:30:00');
INSERT INTO `confmeetingroom` VALUES (61, 1, '2019-08-24 14:00:00', '2019-08-24 19:00:00');
INSERT INTO `confmeetingroom` VALUES (62, 21, '2019-09-03 09:00:00', '2019-09-03 09:30:00');
INSERT INTO `confmeetingroom` VALUES (63, 21, '2019-09-05 09:15:00', '2019-09-05 11:15:00');
INSERT INTO `confmeetingroom` VALUES (64, 21, '2019-09-11 09:00:00', '2019-09-11 10:15:00');
INSERT INTO `confmeetingroom` VALUES (65, 21, '2019-09-10 08:45:00', '2019-09-10 09:45:00');
INSERT INTO `confmeetingroom` VALUES (68, 21, '2019-09-03 09:15:00', '2019-09-03 09:45:00');
INSERT INTO `confmeetingroom` VALUES (69, 21, '2019-09-03 09:00:00', '2019-09-03 10:15:00');
INSERT INTO `confmeetingroom` VALUES (70, 21, '2019-09-12 08:45:00', '2019-09-12 10:15:00');
INSERT INTO `confmeetingroom` VALUES (71, 21, '2019-09-13 08:45:00', '2019-09-13 09:30:00');
INSERT INTO `confmeetingroom` VALUES (72, 15, '2019-09-12 08:45:00', '2019-09-12 09:15:00');
INSERT INTO `confmeetingroom` VALUES (73, 21, '2019-09-15 08:45:00', '2019-09-15 09:30:00');
INSERT INTO `confmeetingroom` VALUES (74, 21, '2019-09-14 18:00:00', '2019-09-14 18:30:00');
INSERT INTO `confmeetingroom` VALUES (75, 21, '2019-09-20 08:45:00', '2019-09-20 09:30:00');
INSERT INTO `confmeetingroom` VALUES (76, 21, '2019-09-24 11:30:00', '2019-09-24 12:15:00');
INSERT INTO `confmeetingroom` VALUES (77, 21, '2019-09-28 18:00:00', '2019-09-28 18:30:00');

-- ----------------------------
-- Table structure for confstatus
-- ----------------------------
DROP TABLE IF EXISTS `confstatus`;
CREATE TABLE `confstatus`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `confstatus` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会议状态名称',
  `confdes` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会议状态描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of confstatus
-- ----------------------------
INSERT INTO `confstatus` VALUES (1, '已申请', '会议预约人员申请会议');
INSERT INTO `confstatus` VALUES (2, '待开始', '会议预约通过审核后的状态，准备后续会议开始工作，也可以不用通过审核直接开始会议');
INSERT INTO `confstatus` VALUES (3, '进行中', '会议正在进行');
INSERT INTO `confstatus` VALUES (4, '已结束', '会议结束，录入人员提交过程材料');
INSERT INTO `confstatus` VALUES (5, '材料已经归档', '记录员提交材料后经过部门管理员审核');
INSERT INTO `confstatus` VALUES (101, '预约审核不通过', '异常：会议预约审核不通过');
INSERT INTO `confstatus` VALUES (102, '归档不通过', '异常：会议材料归档不通过');

-- ----------------------------
-- Table structure for conftitle
-- ----------------------------
DROP TABLE IF EXISTS `conftitle`;
CREATE TABLE `conftitle`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `conftitlecnt` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '议题内容',
  `conclusion` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '议题结论',
  `confid` int(11) DEFAULT NULL COMMENT '会议编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_conftitle_confid`(`confid`) USING BTREE,
  CONSTRAINT `fk_conftitle_confid` FOREIGN KEY (`confid`) REFERENCES `conference` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of conftitle
-- ----------------------------
INSERT INTO `conftitle` VALUES (8, 'fdsafd', NULL, 41);
INSERT INTO `conftitle` VALUES (9, '关于退静房间卡拉是大积分卡拉斯', NULL, 41);
INSERT INTO `conftitle` VALUES (10, '江苏大学', NULL, 41);
INSERT INTO `conftitle` VALUES (11, '福建省考虑', NULL, 44);
INSERT INTO `conftitle` VALUES (12, 'fjdskalfjk', NULL, 45);
INSERT INTO `conftitle` VALUES (13, '1212222', NULL, 46);
INSERT INTO `conftitle` VALUES (14, '43425432', NULL, 46);
INSERT INTO `conftitle` VALUES (15, '1212', NULL, 47);
INSERT INTO `conftitle` VALUES (16, '江苏科技大学更名为华东科技大学', NULL, 48);
INSERT INTO `conftitle` VALUES (17, '飞机西安交通大学', NULL, 48);
INSERT INTO `conftitle` VALUES (18, '东南大学', NULL, 48);
INSERT INTO `conftitle` VALUES (19, '范德萨', NULL, 49);
INSERT INTO `conftitle` VALUES (20, '九分裤都是垃圾发肯定是a', NULL, 49);
INSERT INTO `conftitle` VALUES (23, '232', NULL, 51);
INSERT INTO `conftitle` VALUES (24, '43254325', NULL, 52);
INSERT INTO `conftitle` VALUES (25, '附近的萨卡将卡罗拉', NULL, 55);
INSERT INTO `conftitle` VALUES (26, '钟安娜大嫁风尚‘’', NULL, 57);
INSERT INTO `conftitle` VALUES (27, '福建省大开发垃圾毒素', NULL, 57);
INSERT INTO `conftitle` VALUES (29, '飞机上看打了发快递三', NULL, 56);
INSERT INTO `conftitle` VALUES (30, '飞机上看啦发上课', NULL, 58);
INSERT INTO `conftitle` VALUES (31, '12121', NULL, 60);
INSERT INTO `conftitle` VALUES (32, '完善系统', NULL, 61);
INSERT INTO `conftitle` VALUES (33, '甜蜜的梦想', NULL, 64);
INSERT INTO `conftitle` VALUES (34, 'fdsafdsafdsa', NULL, 69);
INSERT INTO `conftitle` VALUES (35, 'guanyufjdksalfjfdsfkl', NULL, 64);
INSERT INTO `conftitle` VALUES (36, '风刀霜剑啊卡浪费大福建省打开啦', '1212123342423154325432', 70);
INSERT INTO `conftitle` VALUES (37, '房间卡萨大了附近的斯卡拉发角度看了撒放暑假卡的', NULL, 64);
INSERT INTO `conftitle` VALUES (38, '测试的议题', NULL, 64);
INSERT INTO `conftitle` VALUES (39, '福建省卡乐芙上点击阿卡丽发角度看撒啦复健科到拉萨fds', '1321321321321312312', 71);
INSERT INTO `conftitle` VALUES (40, '45354325436', '南京大学\n计算机科学与工程学院', 72);
INSERT INTO `conftitle` VALUES (41, '江苏最牛逼的高校--南京大学，最差的一本-坑大', '范德萨范德萨范德萨范德萨大', 72);
INSERT INTO `conftitle` VALUES (42, '新增议题哈哈哈哈哈', '34312432543254365436534', 72);
INSERT INTO `conftitle` VALUES (43, '13235432就房贷卡撒了福建省打开啦', '附近的斯卡拉附近的斯卡拉发的是金坷垃发\n就的开始拉分都是看见案发京东数科啦复健科到拉萨\n案件开发了点击萨克雷附近的卡萨了福建师大看父\n级SD卡房间卡萨的啦', 72);
INSERT INTO `conftitle` VALUES (44, '东的健身卡了发就但萨克拉法基第三款啦', '的撒范德萨范德萨范德萨范德萨范德萨范德萨范德萨高大\n上割发代首割发代首割发代首割发代首割发代首国防生的\n割发代首高富帅的国防生的个发送到割发代首割发代首国\n防生的割发代首割发代首割发代首', 72);
INSERT INTO `conftitle` VALUES (45, '清华大学', 'dongsdjakfgjdsklag\njdskalgsdajgkldsa jkl jk\nlfdjsaklf dskl', 72);
INSERT INTO `conftitle` VALUES (46, '河海大学附近的卡萨垃圾反馈到拉萨', '·12213213', 70);
INSERT INTO `conftitle` VALUES (47, '福建师大卡了发苏大积分卡死了的否都是看见阿里否', '附近的卡萨了积分卡萨大金坷垃附近的斯卡拉今飞凯达是附近的卡萨了今飞凯达离散今飞凯达离散阿今飞凯达离散就', 70);
INSERT INTO `conftitle` VALUES (48, '8888888888888', '2345325432543254325342', 70);
INSERT INTO `conftitle` VALUES (49, '7874564864865', '22222222222222222222222222222222222222222222222222222222222222222\n2222222222222222222222222222222222222222222222222222222222222\n222222222222222222222222222222222222222222222222222222222222\n222222222222222222222222222222222222222222222222222222222222\n22222222222222222222222222222222222222222222222222222222222222\n22222222222222223333333333333333333333333333333333333333\n', 70);
INSERT INTO `conftitle` VALUES (50, '11558525852', '还要通过就一套房话大概菜鸟', 70);
INSERT INTO `conftitle` VALUES (51, '555555555555555', '功夫大使馆功夫大使馆范德萨花港饭店花港饭店花港饭店\n花港饭店花港饭店很过分规划法单身公害发送多个的方式割发代首 过水\n热官方的时光飞逝功夫大使馆发功夫大使馆单方事\n故范德萨割发代首国\n防生的反攻倒算割发代首反\n攻倒算给惹根深蒂固 割发代首分公司割发代首高富帅\n发送个人卫生热提供商个发送给范德萨国防生的公司格式为国防大学国防生的高富帅\n国防生的个 割发代\n首发光时代归属感是割发代首国防生的发大水官方的花港饭店好几个发动机\n盖和代发货加工费换个\n方式的花港饭店花港饭店好施工方的施工方花港饭店好', 70);
INSERT INTO `conftitle` VALUES (52, '666666666', '发功盖三分国功夫大使馆范德\n萨个功夫大使馆发\n的后台热特花港饭店花港\n饭店花港饭店', 70);
INSERT INTO `conftitle` VALUES (53, '附近的斯卡拉附近的斯卡拉 付款到拉萨附近的卡萨了', 'gfdsgfdsgfdgfdsgfdsg', 71);
INSERT INTO `conftitle` VALUES (54, 'ggggggggggggggg', 'gfdsgfdsgfdsgfdsgfds\ngresgfdsgfds\ngfdsgfdshgfsdgr\nesgfdsgf\ndsgdfsg', 71);
INSERT INTO `conftitle` VALUES (57, '福建师大卡了就发快递三啦，飞机上看啦发江苏快', '发的手机卡接口附近的斯卡拉附近的斯卡拉就付款了第三了发角度看死啦', 73);
INSERT INTO `conftitle` VALUES (58, '发的手机卡福建省打开啦房间卡萨', '放声大哭就开发牢骚的就看了放假快乐撒家里ff\n副书记大卡拉\n放暑假卡拉分就开始\n副书记啊卡方上课\n法解开发思路考、、、\n', 73);
INSERT INTO `conftitle` VALUES (59, '关于端口打分时间卡两节课', '东南打算发动机是卡了k附近开始啦\n放暑假卡啦积分卡萨\n飞机上看啦及f放暑假卡金坷垃\n发生的金卡啦发江苏快\n附近开始啦发就开始', 73);
INSERT INTO `conftitle` VALUES (60, '中秋节放假的安排', '否打开\n法第三方sfsdafjskd \nfdsaklfdjsaklf dsajklf sd\nfjksdjfksd 减肥的刷卡拉拉肥\n福建师大卡了福建省看到附近开始啦\n放暑假卡啦积分卡萨\n飞机上看福建省考虑', 73);
INSERT INTO `conftitle` VALUES (61, '654365436', '6546施工方的示意图', 74);
INSERT INTO `conftitle` VALUES (62, '5432543254325', '23432145325', 74);
INSERT INTO `conftitle` VALUES (63, '合法的是割发代首', '功夫大使馆范德萨\nfdsafsd\ngsgfdsgdf\n退高热问题仍\n范德萨发生大', 75);
INSERT INTO `conftitle` VALUES (64, '东南大学合并江坑大的通知', '江苏规范数据库贵金属的咖啡馆ds规范的撒个接口放到\n功夫到家快乐时光积分打瞌睡\n官方的快乐时光加快递费\n个附近的萨卡更健康的份上g放电视机高考放电视机\n古代佛经开始改讲课大赛l个发到空间撒啦个房贷卡说课稿加工费角度看撒个放得开三啦\n功夫到家昆山干吊及防水款过节费看电视gdf个尽快发的撒了感觉东方时空\n更加可读法律司', 75);

-- ----------------------------
-- Table structure for conftitlerecord
-- ----------------------------
DROP TABLE IF EXISTS `conftitlerecord`;
CREATE TABLE `conftitlerecord`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `speakerid` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发言人工号',
  `speakername` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发言人',
  `speaking` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '发言内容',
  `speaktime` datetime(0) DEFAULT NULL COMMENT '发言时间',
  `conftitleid` int(11) DEFAULT NULL COMMENT '会议议题编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_conftitlerecord_conftitleid`(`conftitleid`) USING BTREE,
  CONSTRAINT `fk_conftitlerecord_conftitleid` FOREIGN KEY (`conftitleid`) REFERENCES `conftitle` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 200 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of conftitlerecord
-- ----------------------------
INSERT INTO `conftitlerecord` VALUES (78, NULL, NULL, '陈鹏：附近的斯卡拉发角度看了撒房间卡拉第三啊白金卡了不就开始了房间卡的撒啦附近的斯卡拉房间卡萨的啦积分卡拉斯的房间卡萨的了房间卡萨的了', '2019-07-02 14:37:13', NULL);
INSERT INTO `conftitlerecord` VALUES (79, NULL, NULL, '张萌萌：附近的斯卡拉积分是见覅看四大皆空浪费数据库费几十块的浪费数据库费就水利局开发时代峻峰开始懂了房间卡的撒房间卡的撒了发江苏打开了房几十块的浪费四大皆空附近的斯卡拉福建省看到发福建省看到富家大室房间卡萨的拉分极速快递房间卡萨的拉分节点上卡乐芙就斯科拉法四大皆空浪费江科大是发就开始代理费金坷垃', '2019-07-02 15:12:30', NULL);
INSERT INTO `conftitlerecord` VALUES (83, NULL, NULL, '江苏科技大学\n东南大学\n清华大学\n北京大学', '2019-07-02 15:12:29', NULL);
INSERT INTO `conftitlerecord` VALUES (90, '9', '陈鹏', '陈鹏：附近的斯卡拉房间卡萨的啦', '2019-07-02 15:34:38', 8);
INSERT INTO `conftitlerecord` VALUES (93, '10', '张萌萌', '江苏大学-张萌萌2-说话', '2019-07-02 15:43:56', 10);
INSERT INTO `conftitlerecord` VALUES (95, '9', '陈鹏', 'vcxzgggggggggggggggggggggggggggggggggggggggggggggg', '2019-07-02 21:15:36', 10);
INSERT INTO `conftitlerecord` VALUES (96, '9', '陈鹏', '加粉口三打两建按付款了盛大', '2019-07-05 22:26:42', 11);
INSERT INTO `conftitlerecord` VALUES (97, '9', '陈鹏', '121212121', '2019-07-08 18:31:06', 12);
INSERT INTO `conftitlerecord` VALUES (98, '9', '陈鹏', '1212121212121', '2019-07-22 08:35:03', 13);
INSERT INTO `conftitlerecord` VALUES (99, '10', '张萌萌', '121212132132132131231', '2019-07-22 08:35:21', 13);
INSERT INTO `conftitlerecord` VALUES (100, '9', '陈鹏', '富士达范德萨范德萨范德萨', '2019-07-22 12:47:59', 14);
INSERT INTO `conftitlerecord` VALUES (101, '10', '张萌萌', '12333333333333333333333333333333333333', '2019-07-22 12:48:05', 14);
INSERT INTO `conftitlerecord` VALUES (102, '14', '吴健康', '图5跃跃欲试fdgggggggggggggggggg', '2019-07-22 12:48:18', 14);
INSERT INTO `conftitlerecord` VALUES (103, '9', '陈鹏', '年轻人，不要暴躁！！要宁静致远', '2019-07-27 21:44:45', 15);
INSERT INTO `conftitlerecord` VALUES (104, '10', '张萌萌', '不可能！', '2019-07-28 13:17:00', 16);
INSERT INTO `conftitlerecord` VALUES (105, '10', '张萌萌', 'fjdkslajfjdkslafjjdsklafjdsklafjklsd', '2019-07-29 08:46:02', 17);
INSERT INTO `conftitlerecord` VALUES (106, '12', '李想', 'fdsafkjdskalfjdsklafjdskla', '2019-07-29 08:46:12', 18);
INSERT INTO `conftitlerecord` VALUES (107, '14', '吴健康', 'fjsdaklfjdsklafjdsklafdsa', '2019-07-29 08:46:16', 18);
INSERT INTO `conftitlerecord` VALUES (108, '13', '陈富贵', 'fjdskalfjdkslafjdsiagdjskalgjkdlsa', '2019-07-29 08:46:25', 18);
INSERT INTO `conftitlerecord` VALUES (109, '9', '陈鹏', '今飞凯达拉萨积分抵抗力散发打开了附近的斯卡拉\n副书记大卡拉发dsa \n东南大学\n附近的斯卡拉发就看电视的', '2019-07-29 09:09:20', 19);
INSERT INTO `conftitlerecord` VALUES (110, '11', '吴庆', '房间卡萨的啦积分第三方垃圾毒素看，；f大就狂蜂浪蝶\n发的数据奥卡福打开了\n发的手机卡了fdsa 借款方了盛大\n附近开始啦发送到\n附近开始啦', '2019-07-29 09:09:41', 20);
INSERT INTO `conftitlerecord` VALUES (116, '9', '陈鹏', '范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨地方阿凡达', '2019-08-03 16:41:00', 23);
INSERT INTO `conftitlerecord` VALUES (117, '10', '张萌萌', '范德萨范德萨范德萨发范德萨范德萨范德萨发大范德萨范德萨', '2019-08-03 16:41:08', 23);
INSERT INTO `conftitlerecord` VALUES (118, '10', '张萌萌', '4532543254325432543254325432', '2019-08-03 23:57:12', 24);
INSERT INTO `conftitlerecord` VALUES (119, '9', '陈鹏', '543264326543265', '2019-08-03 23:57:20', 24);
INSERT INTO `conftitlerecord` VALUES (120, '9', '陈鹏', '附近的斯卡拉发进度款酸辣粉考虑附近的斯卡拉发动机斯科拉', '2019-08-16 14:22:56', 25);
INSERT INTO `conftitlerecord` VALUES (121, '9', '陈鹏', '溶解看完了清热往前看兼容五五开链球菌人家看了我区入库金陵科技访客单沙发客都是看见结案率', '2019-08-16 14:22:58', 25);
INSERT INTO `conftitlerecord` VALUES (122, '11', '吴庆', '发角度看死啦发动机斯科拉发但萨克拉法基抵抗力散发动机斯科拉法解决考虑到三付款代理商啊', '2019-08-16 14:23:09', 25);
INSERT INTO `conftitlerecord` VALUES (123, '13', '陈富贵', '1212121222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222', '2019-08-16 16:58:19', 25);
INSERT INTO `conftitlerecord` VALUES (124, '11', '吴庆', '32423143145325432534', '2019-08-16 16:59:05', 25);
INSERT INTO `conftitlerecord` VALUES (125, '9', '陈鹏', '房间萨迪克发静安寺积分卡萨就弗兰克斯啊', '2019-08-17 10:25:22', 26);
INSERT INTO `conftitlerecord` VALUES (126, '12', '李想', '房间卡拉积分卡拉房间卡拉', '2019-08-17 10:25:38', 26);
INSERT INTO `conftitlerecord` VALUES (127, '12', '李想', '房间卡拉积分看来见覅看老家啊范德萨在否但是', '2019-08-17 10:25:39', 26);
INSERT INTO `conftitlerecord` VALUES (128, '10', '张萌萌', '发的卡拉夫金坷垃房间大放假咋法律的数据这地方觉得撒旦法级大师法圣诞节在打飞机的数量富家大室砸防静电索拉卡减肥的刷卡发静安寺', '2019-08-17 10:25:54', 27);
INSERT INTO `conftitlerecord` VALUES (129, '10', '张萌萌', '发见覅看老家啊付款了反倒是咖啡机三 就付款啦', '2019-08-17 10:27:25', 26);
INSERT INTO `conftitlerecord` VALUES (130, '9', '陈鹏', '12121212121', '2019-08-20 23:39:33', 29);
INSERT INTO `conftitlerecord` VALUES (131, '9', '陈鹏', 'fdsafdsafdsafdsaf', '2019-08-20 23:50:03', 30);
INSERT INTO `conftitlerecord` VALUES (132, '10', '张萌萌', 'fdsafdsaffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff', '2019-08-20 23:50:13', 30);
INSERT INTO `conftitlerecord` VALUES (133, '9', '陈鹏', '121212121212121', '2019-08-23 22:10:25', 31);
INSERT INTO `conftitlerecord` VALUES (134, '10', '张萌萌', 'dsafdsafdsfads', '2019-08-23 22:10:29', 31);
INSERT INTO `conftitlerecord` VALUES (135, NULL, NULL, 'fdsagdsagfdas', '2019-08-23 22:16:40', NULL);
INSERT INTO `conftitlerecord` VALUES (136, NULL, NULL, 'GHJDHJ D', '2019-08-24 10:30:21', NULL);
INSERT INTO `conftitlerecord` VALUES (137, NULL, NULL, 'FGHJJKLGLKGLGKLGKJLFHJFJKGFHJKLHJKLGHKJLKJ', '2019-08-24 10:30:09', NULL);
INSERT INTO `conftitlerecord` VALUES (138, NULL, NULL, '房间卡都是垃圾反馈乐山大佛就抵抗力散发的就斯科拉法电视机卡立方节点上卡乐芙的是金坷垃发京东数科啦发角度看死啦发角度看死啦附近的卡萨了发角度看了撒安家费考虑到三方的抗衰老', '2019-09-10 15:31:31', NULL);
INSERT INTO `conftitlerecord` VALUES (139, NULL, NULL, '房间卡的撒啦发的接口撒了发进度款酸辣粉角度看撒啦发角度看了撒房间卡拉第三阿就付款了第三', '2019-09-10 18:39:58', NULL);
INSERT INTO `conftitlerecord` VALUES (140, NULL, NULL, '附近的斯卡拉房间卡的撒附近的斯卡拉附近的斯卡拉发打开记录房间的啥开了房', '2019-09-10 18:43:26', NULL);
INSERT INTO `conftitlerecord` VALUES (141, NULL, NULL, '关于就发快递三啦就付款了第三发角度看了撒发角度看了撒发角度看了撒发 发动机斯科拉发京东数科拉分dsjkalfdsa河海附近的斯卡拉。附近的斯卡拉\n发电视机卡立方就的沙口路富家大室阿卡丽\n发动机是卡了附近的萨卡了\n发动机撒开了房角度看撒 \n范德萨就付款了第三江安开发\n发动机斯科拉房间卡拉第三a发角度看了撒发角度看s发角度看死啦\n\n发动机是卡了发就打开今飞凯达三案件来看\n\n发的手机卡啦发打开了', '2019-09-10 14:46:47', NULL);
INSERT INTO `conftitlerecord` VALUES (142, '9', '陈鹏', '法第三，范德萨吗，否的是哪门，否的撒谎接口放到啥房间卡拉第三阿复健科到拉萨否', '2019-09-09 19:17:38', 34);
INSERT INTO `conftitlerecord` VALUES (143, NULL, NULL, '范德萨吗，阿发动机是卡了飞机颠覆了看电视剧按付款了大发角度看死啦发动机是卡了发否就抵抗力散发角度看死啦附近的斯卡拉否\n防静电斯卡房间卡拉第三f发动机是卡了发加速度\n\n发的手机卡了发角度看了撒\n发电视机卡立方就打开了房电视机卡立方dsafdsa\n\n发动机撒开了房节点上看否f大就狂蜂浪蝶是a\n\n发的撒娇KL发的撒娇付款了第三安防监控了', '2019-09-09 19:18:21', NULL);
INSERT INTO `conftitlerecord` VALUES (144, '11', '吴庆', '附近的斯卡拉附近的卡萨啦发角度看死啦发进度款酸辣粉京东数科拉分京东数科拉分京东数科啦否\n发角度看撒浪费的数据阿卡丽发的s\n\n兼顾\n附近的斯卡拉发的手机卡\n将是宿舍科技大学今飞凯达离散安居客立方点击萨克雷', '2019-09-09 20:22:26', 35);
INSERT INTO `conftitlerecord` VALUES (145, '10', '张萌萌', '附近的斯卡拉附近的斯卡拉，\n东南的阿雪\n河海大学\n中国石油大学\n中国矿业大学', '2019-09-10 14:42:41', 35);
INSERT INTO `conftitlerecord` VALUES (146, '10', '张萌萌', '发动机是卡了附近的萨卡', '2019-09-10 15:30:11', 33);
INSERT INTO `conftitlerecord` VALUES (147, '11', '吴庆', '东南大学就狂蜂浪蝶是金坷垃发撒娇KL就开发牢骚', '2019-09-10 15:40:41', 33);
INSERT INTO `conftitlerecord` VALUES (148, '10', '张萌萌', '对不起，我司只要985/211高校的毕业生', '2019-09-10 15:46:00', 33);
INSERT INTO `conftitlerecord` VALUES (149, NULL, NULL, '对不起，我们只要双一流高校的额毕业生。。。。。', '2019-09-10 16:01:14', NULL);
INSERT INTO `conftitlerecord` VALUES (150, '29', 'demo', '冬娜姐房贷卡啦撒酒疯考虑到撒酒疯圣诞快乐', '2019-09-10 16:03:52', 36);
INSERT INTO `conftitlerecord` VALUES (151, '11', '吴庆', '哦豁', '2019-09-10 18:38:48', 37);
INSERT INTO `conftitlerecord` VALUES (152, '9', '陈鹏', '1212121212121', '2019-09-10 18:49:25', 37);
INSERT INTO `conftitlerecord` VALUES (153, NULL, NULL, '附近的斯卡拉积分第三款啦发角度看死啦附近的斯卡拉发考虑就付款了第三啊', '2019-09-10 20:08:44', NULL);
INSERT INTO `conftitlerecord` VALUES (154, '10', '张萌萌', '35hgfdhgfdhgfhfgdhfgd', '2019-09-10 20:16:20', 38);
INSERT INTO `conftitlerecord` VALUES (155, '29', 'demo', '房间卡拉的撒房间卡拉第三房间电视机卡立方的数据阿卡丽发点击萨克雷发电视机卡立方点就开始啦附近的斯卡拉附近的斯卡拉积分', '2019-09-11 11:52:32', 39);
INSERT INTO `conftitlerecord` VALUES (156, '29', 'demo', '附近的卡萨就付款了盛大附近的斯卡拉发大，江苏科技大学呵呵呵\n非985 非211 非双一流 非双一流学科\n呵呵呵呵呵\n擦\n擦\n八格牙路', '2019-09-11 13:36:48', 40);
INSERT INTO `conftitlerecord` VALUES (157, NULL, NULL, '京卡仕达积分卡萨大附\n近的斯卡拉发搭建开发\n了的数据阿卡丽发就发\n快递三啦接发大水房间卡\n的撒', '2019-09-11 17:03:16', NULL);
INSERT INTO `conftitlerecord` VALUES (158, '9', '陈鹏', '热武器热无群', '2019-09-11 15:46:01', 42);
INSERT INTO `conftitlerecord` VALUES (159, NULL, NULL, '附近的萨卡了附近的萨卡房间对抗赛拉发角度看死啦附近的斯卡拉发就但萨克拉法基借鸡生蛋卡乐芙圣诞节看了就发快递三啦福建省打开啦', '2019-09-11 15:57:11', NULL);
INSERT INTO `conftitlerecord` VALUES (160, NULL, NULL, '附近的斯卡拉附近的斯卡拉发角度看死啦房间都是看复健科到拉萨发角度看死啦就付款了第三发角度看了撒附近的斯卡拉就付款了第三阿胶颗粒发进度款酸辣粉搭建了开发点击萨克雷发动机斯科拉 发角度看死啦发角度看死啦fjdkslafjdkls案发的九分裤了的数据阿卡丽发动机萨克发附近的斯卡拉发的手机卡了附近的斯卡拉房间卡萨的啦否荆防颗粒电视机卡立方就开始啦否荆防颗粒三的阿积分卡萨大京东数科啦fjdkslaj', '2019-09-11 15:57:12', NULL);
INSERT INTO `conftitlerecord` VALUES (161, '29', 'demo', '1212122222222222222222222222222222', '2019-09-11 16:00:44', 43);
INSERT INTO `conftitlerecord` VALUES (162, '9', '陈鹏', '43243215435432654365436', '2019-09-11 16:00:54', 44);
INSERT INTO `conftitlerecord` VALUES (163, NULL, NULL, '4564564564564\n56456456123456\n4561256456', '2019-09-11 17:05:10', NULL);
INSERT INTO `conftitlerecord` VALUES (164, '27', '河海大学', '111121212121', '2019-09-11 16:08:34', 46);
INSERT INTO `conftitlerecord` VALUES (165, '27', '河海大学', '可结合国防科技规划法巨化股份就好几个放假也天赋有土豆粉具有天然的集合', '2019-09-11 16:08:47', 47);
INSERT INTO `conftitlerecord` VALUES (166, '27', '河海大学', '范德萨功夫大使馆发第三个范德萨', '2019-09-11 16:11:23', 48);
INSERT INTO `conftitlerecord` VALUES (167, '27', '河海大学', '3424321432143254325432', '2019-09-11 16:13:55', 49);
INSERT INTO `conftitlerecord` VALUES (168, '27', '河海大学', '花港饭店花港饭店和规范化风格的会发哥', '2019-09-11 16:14:46', 50);
INSERT INTO `conftitlerecord` VALUES (169, '27', '河海大学', '2341243215432564和功夫大使馆发的', '2019-09-11 16:15:41', 51);
INSERT INTO `conftitlerecord` VALUES (170, '29', 'demo', '34532的范德萨范德萨功夫大使馆花港饭店花港饭店巨化股份的换机油听得见回复过加拿大', '2019-09-11 16:19:43', 47);
INSERT INTO `conftitlerecord` VALUES (171, '27', '河海大学', '规范化的花港饭店花港饭店和花\n港饭店花港饭店花港饭店花港饭店花港\n饭店很过分的挺好托管费的花港饭店花港饭店\n花港饭店花港饭店', '2019-09-11 16:20:48', 52);
INSERT INTO `conftitlerecord` VALUES (172, '26', '陈鹏', '房卡死了防静电三附近的斯卡拉发djsk\n发电视机卡立方ds\n发的手机卡发\n副书记大卡拉范德萨\n富士达金坷垃发送到', '2019-09-11 16:21:44', 51);
INSERT INTO `conftitlerecord` VALUES (173, '9', '陈鹏', 'Kao fjkdsalfjdkslafjkds\nfdjsaklfjdsklaf dsjaklf dsa\nfjdklsafjdkslajfkdsla', '2019-09-11 17:04:36', 41);
INSERT INTO `conftitlerecord` VALUES (174, '29', 'demo', 'gfdsgfdsgff\nfdsaklfjdska \nfdsajklfdjsaklf dsa\nfdjsklafjdskal fjdskalf\ndsajfkldsajfkdlsajfklsdf', '2019-09-11 17:05:37', 44);
INSERT INTO `conftitlerecord` VALUES (175, '9', '陈鹏', 'fgdsgfdsgfdsgfdsgfds', '2019-09-12 13:52:15', 53);
INSERT INTO `conftitlerecord` VALUES (176, '9', '陈鹏', 'gfdgdgdgdfsgsdgdfs', '2019-09-12 13:52:29', 54);
INSERT INTO `conftitlerecord` VALUES (180, '9', '陈鹏', '附近的斯卡拉房间卡的撒啦 房间卡萨的了\n发就快乐番薯角度看，福建师大卡了', '2019-09-13 21:19:40', 57);
INSERT INTO `conftitlerecord` VALUES (181, '9', '陈鹏', '反倒是卡了发的撒娇KL发\n风刀霜剑啊卡浪费即第三看来\n发电视机卡立方就看电视今飞凯达三金坷垃\n发的撒娇KL副书记大附近开始啦', '2019-09-13 21:19:41', 57);
INSERT INTO `conftitlerecord` VALUES (182, '9', '陈鹏', '范德萨范德萨发角度看死啦\n发动机是卡了发的数据库啦\n发电视机卡立方就但萨克\n副书记大卡拉发\n放暑假卡发送就开发牢骚', '2019-09-13 21:20:07', 58);
INSERT INTO `conftitlerecord` VALUES (183, '15', '李丹', '附近的卡萨了发的接口撒了房间卡的撒阿就付款了第三考虑福建师大看\n发生的金卡\n放暑假卡啦\n放暑假卡拉分沙口路\n发生的金卡啦福建省看到\n发生的金卡啦发', '2019-09-13 21:20:40', 58);
INSERT INTO `conftitlerecord` VALUES (184, '9', '陈鹏', '4321432143是当然热敷十大范德萨范德萨\n风刀霜剑啊卡房间卡萨的啦\n发生的金卡冷风机SD卡\n发上点击阿卡丽', '2019-09-13 21:21:49', 59);
INSERT INTO `conftitlerecord` VALUES (185, '36', '清华大学', '附近的斯卡拉发生的金卡啦机卡分离就开始啦\n福建省卡乐芙就开始\n放暑假卡啦\n福建省看到房间卡拉数据库了\n法时间阿卡丽房间卡附近开始啦附近开始啦', '2019-09-13 21:22:06', 59);
INSERT INTO `conftitlerecord` VALUES (186, '9', '陈鹏', '范德萨范德萨范德萨发 范德萨发点啥范德萨发快递三法第三方打了卡反倒是卡啦房间卡的撒啦积分卡萨大了', '2019-09-13 21:22:59', 60);
INSERT INTO `conftitlerecord` VALUES (187, '9', '陈鹏', '43214321432154325432', '2019-09-13 21:46:29', 61);
INSERT INTO `conftitlerecord` VALUES (188, '10', '张萌萌', '推入2条5任务挺热问题惹我挺热问题根深蒂固', '2019-09-13 21:46:41', 61);
INSERT INTO `conftitlerecord` VALUES (189, '9', '陈鹏', '5432543是东方大厦', '2019-09-13 21:46:56', 62);
INSERT INTO `conftitlerecord` VALUES (190, '11', '吴庆', '2345432543265436543765475647654876548丿', '2019-09-13 21:47:17', 62);
INSERT INTO `conftitlerecord` VALUES (191, '11', '吴庆', '5432天354325432', '2019-09-13 21:47:18', 62);
INSERT INTO `conftitlerecord` VALUES (192, '9', '陈鹏', '芙蓉王撒范德萨功夫大使馆范德萨吧挺热问题个任务', '2019-09-18 11:12:07', 63);
INSERT INTO `conftitlerecord` VALUES (193, '10', '张萌萌', '反倒是卡附近的萨卡否福建省打开啦\n发生的金卡父级SD卡\n发的手机卡了附近开始啦大\n发生的金卡啦房间卡萨大\n富家大室康角度看撒个京卡仕达发了更健康的份上', '2019-09-18 11:13:55', 64);
INSERT INTO `conftitlerecord` VALUES (194, '9', '陈鹏', '附近的卡萨附近的斯卡拉发\n结束当放电视机开关机放电视\n机高考发达拉斯鼓风机嗲了国\n际地方', '2019-09-18 11:14:27', 64);
INSERT INTO `conftitlerecord` VALUES (195, '10', '张萌萌', '房贷卡撒个尽快发的撒就个坑加快递费输卵管发动机开始啦个发角度看\n功夫到家开始改加快递费\n个放大镜看离散感觉到放开手\n个发动机声卡激活框给对方', '2019-09-18 11:14:41', 64);
INSERT INTO `conftitlerecord` VALUES (196, '29', 'demo', '认为群热无群范德萨割发\n代首广东佛山功夫大使馆\n范德萨', '2019-09-18 11:16:13', 63);
INSERT INTO `conftitlerecord` VALUES (197, '10', '张萌萌', '312432432154325432654', '2019-09-20 14:33:28', 45);
INSERT INTO `conftitlerecord` VALUES (198, '9', '陈鹏', 'gfdsgfdsgfdsgsdfgdsf', '2019-09-20 14:33:33', 45);
INSERT INTO `conftitlerecord` VALUES (199, '11', '吴庆', 'gfdsgfdshgfdsh\n范德萨尽快发的撒看\n发生的金卡冷风机SD卡\n风刀霜剑啊卡浪费是', '2019-09-20 14:33:42', 45);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departnum` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '部门编号',
  `departname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '001', '计算机科学与工程学院');
INSERT INTO `department` VALUES (2, '002', '电子信息学院');
INSERT INTO `department` VALUES (3, '003', '数学与物理科学学院');
INSERT INTO `department` VALUES (4, '004', '外国语学院');
INSERT INTO `department` VALUES (5, '005', '船舶与海洋工程学院');
INSERT INTO `department` VALUES (6, '007', '国防科技学院');

-- ----------------------------
-- Table structure for directconf
-- ----------------------------
DROP TABLE IF EXISTS `directconf`;
CREATE TABLE `directconf`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `confname` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会议名称',
  `semesterid` int(11) DEFAULT NULL COMMENT '学期编号',
  `semester` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学期名称',
  `confattrs` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会议属性',
  `conftypeid` int(11) DEFAULT NULL COMMENT '会议类别/级别编号',
  `conftypename` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会议类别名称',
  `hosterid` int(11) DEFAULT NULL COMMENT '主持人accid',
  `hoster` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主持人姓名',
  `recorderid` int(11) DEFAULT NULL COMMENT '录入人id',
  `recorder` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '记录人的姓名',
  `confaddress` varchar(350) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会议地点',
  `confstarttime` datetime(0) DEFAULT NULL COMMENT '会议开始时间',
  `confendtime` datetime(0) DEFAULT NULL COMMENT '会议结束时间',
  `attenders` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '与会人员',
  `maincontent` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '会议内容',
  `conclusion` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '会议结论',
  `confstatus` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会议状态标记',
  `subtime` datetime(0) DEFAULT NULL COMMENT '会议记录提交时间',
  `objtime` datetime(0) DEFAULT NULL COMMENT '会议记录归档时间',
  `other1` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备用字段1',
  `other2` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备用字段2',
  `other3` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of directconf
-- ----------------------------
INSERT INTO `directconf` VALUES (1, '1341243214', 58, NULL, '21,22', 13, NULL, 29, NULL, 29, NULL, '54325432543', '2019-09-14 09:00:00', '2019-09-14 09:30:00', '11,15,14,13,10,9', '挺热问题人我同人文\n功夫大使馆范德萨\n割发代首\n割发代首gfds\ngfdsgfds\ngfdsgfds\ngfdsgfsd\ngfdsgdfs', '江苏科技大学，非得借搜啊几个福建师大看\n发的手机卡\n和海带阿雪学积分卡萨', '5', '2019-09-14 14:10:49', NULL, NULL, NULL, NULL);
INSERT INTO `directconf` VALUES (3, '342143214手动阀发送的', 57, NULL, '21,20,22', 13, NULL, 23, NULL, 23, NULL, 'fewafdsafsdafsd', '2019-09-14 09:00:00', '2019-09-14 11:15:00', '9,14,13', '1fdsafgdsagdfsgdf\ndfsafgdsagsf\ngfsdagfd\ngfds\ngfds\ngfd\nsg\nfds\ng\nfdsh\ngfd\nsh\ngf\ndh\ngf\ndh\ngf\nd', 'fadsafdsafsdafsda', '4', '2019-09-14 14:40:15', NULL, NULL, NULL, NULL);
INSERT INTO `directconf` VALUES (4, 'fjdskalfjsdkl副书记大看', 56, NULL, '21,22,23', 14, NULL, 29, NULL, 29, NULL, '父级SD卡附近的萨卡', '2019-09-14 09:00:00', '2019-09-14 09:45:00', '11,13,14', '附近的萨卡f\n防守打法京卡仕达f圣诞节看了\n副书记开发\n放暑假卡啦发几十块\n放暑假卡拉分刷卡机\n发砂浆试块\n放暑假卡拉分是科技\n法时间考虑福建省考虑\n发就开始发几十块\n放暑假卡发送金坷垃\n个就开始了估计快了\n关键时刻了国剧盛典', '房间卡萨大了福建师大看福建省卡乐芙江苏快\n副书记开发数据库\n江苏快\n发送的就开发牢骚\n放暑假卡啦\n放暑假卡发送就\n副书记开发就开始\n副书记开发江苏快\n发件开发几十块\n副书记大快递费是', '102', '2019-09-14 14:44:07', NULL, NULL, NULL, NULL);
INSERT INTO `directconf` VALUES (5, '从是杰克逊阿反倒是卡开展', 58, NULL, '23,21,20', 13, NULL, 29, NULL, 29, NULL, '见覅昂书', '2019-09-16 09:15:00', '2019-09-16 11:00:00', '13,14,15', '发的撒开房间卡的撒 \n发的手机卡范德萨啊\n发的撒娇KL发送的啊福建省昆德拉发\n父级SD卡附近开始啦大否圣诞节看\n俯拾地芥卡方江苏快 房间卡萨大\nf上点击阿卡丽发是啊发生的金卡\n发的手机卡复健科到拉萨', '就付款第三方的数据爱发科s否\n阿F的数据奥卡福苏大附近的卡萨\n附近的斯卡拉福建省考虑大', '5', '2019-09-16 16:48:09', NULL, NULL, NULL, NULL);
INSERT INTO `directconf` VALUES (6, '成大事看附近的卡萨', 58, NULL, '20,21,22', 13, NULL, 29, NULL, 29, NULL, '将数据库', '2019-09-18 10:15:00', '2019-09-18 11:45:00', '14,15', '福建省咖啡了技术肯定\n附近的萨卡\n福建省咖啡看数据库\n飞机上看\n副书记开发江苏快\n江苏\n副书记开发就开始\n副书记开发就开始\n福建省开放接口手机发\n斤斤计较', '反攻倒算个地方施工方的功夫大使馆范德萨很过分', '4', '2019-09-18 11:08:48', NULL, NULL, NULL, NULL);
INSERT INTO `directconf` VALUES (7, '关于开展江科大更名为华东科技大学的工作讨论决议', 57, NULL, '23,24,22', 14, NULL, 18, NULL, 29, NULL, '13额', '2019-09-18 12:00:00', '2019-09-18 14:00:00', '15,13,11,10,18,29', '范德萨范德萨', '11111', '4', '2019-09-18 20:59:54', NULL, NULL, NULL, NULL);
INSERT INTO `directconf` VALUES (8, '关于开展第三课福建省', 58, NULL, '21,22,23', 13, NULL, 36, NULL, 36, NULL, '富士康积分卡萨', '2019-09-18 09:30:00', '2019-09-18 10:30:00', '15,14,13,36', '范德萨发范德萨范德萨范德萨\nrewqr为\nre我\n人\n\ne wr \n\n 热武器', '放散阀的方式\n424\n4324\n24\n\n23\n4\n2\n3\n4', '4', '2019-09-18 22:08:57', NULL, NULL, NULL, NULL);
INSERT INTO `directconf` VALUES (9, '就K房间卡的撒关键是对抗', 57, NULL, '22,24,23,21', 14, NULL, 29, NULL, 29, NULL, '房间卡的撒积分卡萨大', '2019-09-19 15:30:00', '2019-09-19 18:30:00', '11,10,9,13,14,15,29', '范德萨范德萨发】、、\n发发的撒\nfdsafdsafds\nfsdafsda发发送到\n范德萨发生大\nfdsafdsa f大丰收的\n范德萨发生大\n范德萨', '江苏科技大学\n东南大学\n江苏大学\n南京航空航天的阿雪\n南京理工大学\n南京师范大学\n南京信息工程大学\n南京相撞学院\n南京大学\n南京邮电大学', '4', '2019-09-19 19:51:31', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for duty
-- ----------------------------
DROP TABLE IF EXISTS `duty`;
CREATE TABLE `duty`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `duty` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位名称',
  `dutynum` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of duty
-- ----------------------------
INSERT INTO `duty` VALUES (1, '校长', '001');
INSERT INTO `duty` VALUES (2, '副校长', '002');
INSERT INTO `duty` VALUES (3, '校党委书记', '003');
INSERT INTO `duty` VALUES (4, '副校党委书记', '004');
INSERT INTO `duty` VALUES (5, '院长', '005');
INSERT INTO `duty` VALUES (6, '副院长', '006');
INSERT INTO `duty` VALUES (7, '党委书记', '007');
INSERT INTO `duty` VALUES (8, '副党委书记', '008');

-- ----------------------------
-- Table structure for issuecurmeet
-- ----------------------------
DROP TABLE IF EXISTS `issuecurmeet`;
CREATE TABLE `issuecurmeet`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mainconent` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主要内容',
  `meetcollid` int(11) DEFAULT NULL COMMENT '会议议题采集表编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_issuecurmeet_meetcollid`(`meetcollid`) USING BTREE,
  CONSTRAINT `fk_issuecurmeet_meetcollid` FOREIGN KEY (`meetcollid`) REFERENCES `meetingcollect` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 151 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of issuecurmeet
-- ----------------------------
INSERT INTO `issuecurmeet` VALUES (15, '321321312', 10);
INSERT INTO `issuecurmeet` VALUES (16, '43214321', 11);
INSERT INTO `issuecurmeet` VALUES (17, '15432543', 11);
INSERT INTO `issuecurmeet` VALUES (18, '432423432', NULL);
INSERT INTO `issuecurmeet` VALUES (19, '543254325', NULL);
INSERT INTO `issuecurmeet` VALUES (20, '432423432', 12);
INSERT INTO `issuecurmeet` VALUES (21, '543254325', 12);
INSERT INTO `issuecurmeet` VALUES (22, 'asfdsafsdafasd', 13);
INSERT INTO `issuecurmeet` VALUES (23, 'fdsafsdafsda', 13);
INSERT INTO `issuecurmeet` VALUES (24, '21', 14);
INSERT INTO `issuecurmeet` VALUES (25, '212', 15);
INSERT INTO `issuecurmeet` VALUES (26, '关于解除南京邮电大学双一流学科的通知', 16);
INSERT INTO `issuecurmeet` VALUES (27, '321321', 17);
INSERT INTO `issuecurmeet` VALUES (28, '12121', 18);
INSERT INTO `issuecurmeet` VALUES (29, '1212', 19);
INSERT INTO `issuecurmeet` VALUES (30, 'fdskla', 20);
INSERT INTO `issuecurmeet` VALUES (31, '附近的斯卡拉', 20);
INSERT INTO `issuecurmeet` VALUES (32, '123892389', 20);
INSERT INTO `issuecurmeet` VALUES (33, '2121', 21);
INSERT INTO `issuecurmeet` VALUES (34, '3123', 22);
INSERT INTO `issuecurmeet` VALUES (35, '范德萨发', 23);
INSERT INTO `issuecurmeet` VALUES (36, '32323', 24);
INSERT INTO `issuecurmeet` VALUES (37, '附近的斯卡拉发圣诞快乐', 25);
INSERT INTO `issuecurmeet` VALUES (38, '房间卡萨了', 25);
INSERT INTO `issuecurmeet` VALUES (39, '放暑假卡', 26);
INSERT INTO `issuecurmeet` VALUES (40, 'fsda范德萨范德萨发大范德萨发', 27);
INSERT INTO `issuecurmeet` VALUES (41, '房间卡的撒看', 28);
INSERT INTO `issuecurmeet` VALUES (42, '房间卡萨', 28);
INSERT INTO `issuecurmeet` VALUES (43, '飞机上看', 28);
INSERT INTO `issuecurmeet` VALUES (44, '13借款方了加速度快拉风', 29);
INSERT INTO `issuecurmeet` VALUES (45, '为奇偶附近开始啦的就阿弗莱克', 30);
INSERT INTO `issuecurmeet` VALUES (46, '附近的斯卡拉积分看电视', 30);
INSERT INTO `issuecurmeet` VALUES (47, '附近的斯卡拉', 30);
INSERT INTO `issuecurmeet` VALUES (48, '的放暑假卡拉分', 31);
INSERT INTO `issuecurmeet` VALUES (49, '福建省打开啦发', 31);
INSERT INTO `issuecurmeet` VALUES (50, '323', 32);
INSERT INTO `issuecurmeet` VALUES (51, '21212', 33);
INSERT INTO `issuecurmeet` VALUES (52, '关于修改更名流程的研究', 34);
INSERT INTO `issuecurmeet` VALUES (53, '232', 35);
INSERT INTO `issuecurmeet` VALUES (54, '21', 36);
INSERT INTO `issuecurmeet` VALUES (55, '房间卡萨发ds', 37);
INSERT INTO `issuecurmeet` VALUES (56, '福建省立刻', 37);
INSERT INTO `issuecurmeet` VALUES (57, '发角度看了撒', 37);
INSERT INTO `issuecurmeet` VALUES (58, '2121212', 38);
INSERT INTO `issuecurmeet` VALUES (59, '飞机上看啦发就', 39);
INSERT INTO `issuecurmeet` VALUES (60, '附近开始啦', 39);
INSERT INTO `issuecurmeet` VALUES (61, '飞机上看', 39);
INSERT INTO `issuecurmeet` VALUES (62, '1212', 40);
INSERT INTO `issuecurmeet` VALUES (63, '131', 41);
INSERT INTO `issuecurmeet` VALUES (64, '房间卡的撒发', 42);
INSERT INTO `issuecurmeet` VALUES (65, '福建省考虑', 42);
INSERT INTO `issuecurmeet` VALUES (66, '江苏', 43);
INSERT INTO `issuecurmeet` VALUES (67, 'fdsafd', 44);
INSERT INTO `issuecurmeet` VALUES (68, '荆防颗粒的撒娇付款了第三', 45);
INSERT INTO `issuecurmeet` VALUES (69, '江苏科技大学荆防颗粒的撒娇KL', 45);
INSERT INTO `issuecurmeet` VALUES (70, '123rfesdzfdsa', 46);
INSERT INTO `issuecurmeet` VALUES (71, 'fsaklfjsdkla;jfs', 46);
INSERT INTO `issuecurmeet` VALUES (72, 'fsdjkaljfkslda', 46);
INSERT INTO `issuecurmeet` VALUES (73, '大屏幕改密码', 45);
INSERT INTO `issuecurmeet` VALUES (74, '会议议题房间卡萨的了', 45);
INSERT INTO `issuecurmeet` VALUES (75, '河海大学', 45);
INSERT INTO `issuecurmeet` VALUES (76, '关于江苏科技大学更名为江苏科技学院的工作决定', 45);
INSERT INTO `issuecurmeet` VALUES (77, '关于徐州工程学院更名为清华大学(徐州分校)的工作决定', 45);
INSERT INTO `issuecurmeet` VALUES (78, '关于退静房间卡拉是大积分卡拉斯', 44);
INSERT INTO `issuecurmeet` VALUES (79, '江苏大学', 44);
INSERT INTO `issuecurmeet` VALUES (80, '福建省考虑', 47);
INSERT INTO `issuecurmeet` VALUES (81, 'fjdskalfjk', 48);
INSERT INTO `issuecurmeet` VALUES (82, 'fjskl', 48);
INSERT INTO `issuecurmeet` VALUES (83, '1212222', 49);
INSERT INTO `issuecurmeet` VALUES (84, '43425432', 49);
INSERT INTO `issuecurmeet` VALUES (85, '1212', 50);
INSERT INTO `issuecurmeet` VALUES (86, '东南大学', 51);
INSERT INTO `issuecurmeet` VALUES (87, '飞机西安交通大学', 51);
INSERT INTO `issuecurmeet` VALUES (88, '江苏科技大学更名为华东科技大学', 51);
INSERT INTO `issuecurmeet` VALUES (89, '范德萨', 52);
INSERT INTO `issuecurmeet` VALUES (90, '九分裤都是垃圾发肯定是a', 52);
INSERT INTO `issuecurmeet` VALUES (91, '东南打开老家啊', 53);
INSERT INTO `issuecurmeet` VALUES (92, '附近的卡萨冷风机安盛', 53);
INSERT INTO `issuecurmeet` VALUES (93, '232', 54);
INSERT INTO `issuecurmeet` VALUES (94, '43254325', 55);
INSERT INTO `issuecurmeet` VALUES (95, '见覅看老家啊富士达附近的卡萨', 56);
INSERT INTO `issuecurmeet` VALUES (96, '发静安寺看及放暑假了', 56);
INSERT INTO `issuecurmeet` VALUES (97, '房间卡拉接发大水', 57);
INSERT INTO `issuecurmeet` VALUES (98, '放假早饭龙角散', 57);
INSERT INTO `issuecurmeet` VALUES (99, '附近的萨卡将卡罗拉', 58);
INSERT INTO `issuecurmeet` VALUES (100, '见覅昂苏刻录机 了发生的金卡啦', 58);
INSERT INTO `issuecurmeet` VALUES (101, '发电视机卡立方是的', 58);
INSERT INTO `issuecurmeet` VALUES (102, '附近的萨卡发', 59);
INSERT INTO `issuecurmeet` VALUES (103, '飞机上看打了发快递三', 59);
INSERT INTO `issuecurmeet` VALUES (104, '钟安娜大嫁风尚‘’', 60);
INSERT INTO `issuecurmeet` VALUES (105, '福建省大开发垃圾毒素', 60);
INSERT INTO `issuecurmeet` VALUES (106, '飞机上看啦发上课', 61);
INSERT INTO `issuecurmeet` VALUES (107, 'fdsafdsafds', 62);
INSERT INTO `issuecurmeet` VALUES (108, '12121', 63);
INSERT INTO `issuecurmeet` VALUES (109, '完善系统', 64);
INSERT INTO `issuecurmeet` VALUES (110, '和海带发静安寺看了', 65);
INSERT INTO `issuecurmeet` VALUES (111, '发的手机卡啦附近的萨卡了', 65);
INSERT INTO `issuecurmeet` VALUES (112, 'fdsferwafdsafdsafsda', 66);
INSERT INTO `issuecurmeet` VALUES (113, '甜蜜的梦想', 67);
INSERT INTO `issuecurmeet` VALUES (114, 'dsafdsafds', 68);
INSERT INTO `issuecurmeet` VALUES (115, '543254326', 69);
INSERT INTO `issuecurmeet` VALUES (116, 'reqwr', 70);
INSERT INTO `issuecurmeet` VALUES (117, '211111111111111', 71);
INSERT INTO `issuecurmeet` VALUES (118, 'fdsafdsafdsa', 72);
INSERT INTO `issuecurmeet` VALUES (119, 'guanyufjdksalfjfdsfkl', 67);
INSERT INTO `issuecurmeet` VALUES (120, '风刀霜剑啊卡浪费大福建省打开啦', 73);
INSERT INTO `issuecurmeet` VALUES (121, '福建师大卡了发苏大积分卡死了的否都是看见阿里否', 73);
INSERT INTO `issuecurmeet` VALUES (122, '房间卡萨大了附近的斯卡拉发角度看了撒放暑假卡的', 67);
INSERT INTO `issuecurmeet` VALUES (123, '测试的议题', 67);
INSERT INTO `issuecurmeet` VALUES (124, '福建省卡乐芙上点击阿卡丽发角度看撒啦复健科到拉萨fds', 74);
INSERT INTO `issuecurmeet` VALUES (125, '附近的斯卡拉附近的斯卡拉 付款到拉萨附近的卡萨了', 74);
INSERT INTO `issuecurmeet` VALUES (126, '45354325436', 75);
INSERT INTO `issuecurmeet` VALUES (127, '江苏最牛逼的高校--南京大学，最差的一本-坑大', 75);
INSERT INTO `issuecurmeet` VALUES (128, '新增议题哈哈哈哈哈', 75);
INSERT INTO `issuecurmeet` VALUES (129, '13235432就房贷卡撒了福建省打开啦', 75);
INSERT INTO `issuecurmeet` VALUES (130, '东的健身卡了发就但萨克拉法基第三款啦', 75);
INSERT INTO `issuecurmeet` VALUES (131, '清华大学', 75);
INSERT INTO `issuecurmeet` VALUES (132, '河海大学附近的卡萨垃圾反馈到拉萨', 73);
INSERT INTO `issuecurmeet` VALUES (133, '8888888888888', 73);
INSERT INTO `issuecurmeet` VALUES (134, '11558525852', 73);
INSERT INTO `issuecurmeet` VALUES (135, '7874564864865', 73);
INSERT INTO `issuecurmeet` VALUES (136, '555555555555555', 73);
INSERT INTO `issuecurmeet` VALUES (137, '666666666', 73);
INSERT INTO `issuecurmeet` VALUES (138, 'ggggggggggggggg', 74);
INSERT INTO `issuecurmeet` VALUES (139, '附近的斯卡拉积分的开始阿附近的斯卡拉发的手机卡了', 70);
INSERT INTO `issuecurmeet` VALUES (140, '福建师大卡了就发快递三啦，飞机上看啦发江苏快', 76);
INSERT INTO `issuecurmeet` VALUES (141, '发的手机卡福建省打开啦房间卡萨', 76);
INSERT INTO `issuecurmeet` VALUES (142, '关于端口打分时间卡两节课', 76);
INSERT INTO `issuecurmeet` VALUES (143, '中秋节放假的安排', 76);
INSERT INTO `issuecurmeet` VALUES (144, '654365436', 77);
INSERT INTO `issuecurmeet` VALUES (145, '5432543254325', 77);
INSERT INTO `issuecurmeet` VALUES (146, '合法的是割发代首', 78);
INSERT INTO `issuecurmeet` VALUES (147, '东南大学合并江坑大的通知', 78);
INSERT INTO `issuecurmeet` VALUES (148, '本次房间卡萨的交罚款是讲课费圣诞节看了', 79);
INSERT INTO `issuecurmeet` VALUES (149, '福建省卡父级SD卡房间卡萨大', 80);
INSERT INTO `issuecurmeet` VALUES (150, '房贷卡撒今飞凯达撒发送到卡积分今飞凯达三就阿卡', 80);

-- ----------------------------
-- Table structure for issuelastmeet
-- ----------------------------
DROP TABLE IF EXISTS `issuelastmeet`;
CREATE TABLE `issuelastmeet`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maincontent` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主要内容',
  `meetcollid` int(11) DEFAULT NULL COMMENT '会议议题采集表编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_issuelastmeet_meetcollid`(`meetcollid`) USING BTREE,
  CONSTRAINT `fk_issuelastmeet_meetcollid` FOREIGN KEY (`meetcollid`) REFERENCES `meetingcollect` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 123 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of issuelastmeet
-- ----------------------------
INSERT INTO `issuelastmeet` VALUES (13, '2121212121212', 1);
INSERT INTO `issuelastmeet` VALUES (14, '312312312', 1);
INSERT INTO `issuelastmeet` VALUES (15, '12121', 10);
INSERT INTO `issuelastmeet` VALUES (16, '432423423', 11);
INSERT INTO `issuelastmeet` VALUES (17, '12121', 12);
INSERT INTO `issuelastmeet` VALUES (18, '432423423', 12);
INSERT INTO `issuelastmeet` VALUES (19, 'dfsafsdafasd', 13);
INSERT INTO `issuelastmeet` VALUES (20, 'dfsafadsf', 13);
INSERT INTO `issuelastmeet` VALUES (21, '211', 14);
INSERT INTO `issuelastmeet` VALUES (22, '2121', 15);
INSERT INTO `issuelastmeet` VALUES (23, '关于解除南京理工大学211工程的通知', 16);
INSERT INTO `issuelastmeet` VALUES (24, '21212121', 17);
INSERT INTO `issuelastmeet` VALUES (25, '21212121', 18);
INSERT INTO `issuelastmeet` VALUES (26, '1212', 19);
INSERT INTO `issuelastmeet` VALUES (27, '房间卡萨打蜡放假快乐撒', 20);
INSERT INTO `issuelastmeet` VALUES (28, '房间卡达萨罗九分裤说多了', 20);
INSERT INTO `issuelastmeet` VALUES (29, '212121', 21);
INSERT INTO `issuelastmeet` VALUES (30, '312312', 22);
INSERT INTO `issuelastmeet` VALUES (31, '321321312', 23);
INSERT INTO `issuelastmeet` VALUES (32, '范德萨发生', 23);
INSERT INTO `issuelastmeet` VALUES (33, '21212', 24);
INSERT INTO `issuelastmeet` VALUES (34, '今飞凯达拉萨九分裤', 25);
INSERT INTO `issuelastmeet` VALUES (35, '房间卡的撒', 25);
INSERT INTO `issuelastmeet` VALUES (36, '房间卡的撒发空间', 26);
INSERT INTO `issuelastmeet` VALUES (37, '发的', 27);
INSERT INTO `issuelastmeet` VALUES (38, '反倒是卡了房间卡', 28);
INSERT INTO `issuelastmeet` VALUES (39, '附近的斯卡拉', 28);
INSERT INTO `issuelastmeet` VALUES (40, '福建省考虑', 28);
INSERT INTO `issuelastmeet` VALUES (41, '房间卡都是垃圾反馈了的撒积分卡洛斯大姐夫', 29);
INSERT INTO `issuelastmeet` VALUES (42, '福建省看到了', 29);
INSERT INTO `issuelastmeet` VALUES (43, '福建省考虑', 29);
INSERT INTO `issuelastmeet` VALUES (44, '甘家口圣诞节快乐福建省打开啦福建省考虑的', 30);
INSERT INTO `issuelastmeet` VALUES (45, '福建省考虑飞机上看的', 30);
INSERT INTO `issuelastmeet` VALUES (46, '福建省考虑地方绝对是咖啡机克鲁赛德', 30);
INSERT INTO `issuelastmeet` VALUES (47, '福建省考虑房间卡萨倒垃圾付款了第三届', 30);
INSERT INTO `issuelastmeet` VALUES (48, '房间卡萨的辣椒粉开始懂了', 31);
INSERT INTO `issuelastmeet` VALUES (49, '福建省打开啦发', 31);
INSERT INTO `issuelastmeet` VALUES (50, '232323232', 32);
INSERT INTO `issuelastmeet` VALUES (51, '12121', 33);
INSERT INTO `issuelastmeet` VALUES (52, '关于更名工作的组织决定', 34);
INSERT INTO `issuelastmeet` VALUES (53, '323', 35);
INSERT INTO `issuelastmeet` VALUES (54, '21', 36);
INSERT INTO `issuelastmeet` VALUES (55, '积分卡拉斯', 37);
INSERT INTO `issuelastmeet` VALUES (56, '212121', 38);
INSERT INTO `issuelastmeet` VALUES (57, '飞机上看', 39);
INSERT INTO `issuelastmeet` VALUES (58, '飞机上看啦发', 39);
INSERT INTO `issuelastmeet` VALUES (59, '房间卡萨', 39);
INSERT INTO `issuelastmeet` VALUES (60, '附近的刷卡', 39);
INSERT INTO `issuelastmeet` VALUES (61, '1212', 40);
INSERT INTO `issuelastmeet` VALUES (62, '13213', 41);
INSERT INTO `issuelastmeet` VALUES (63, '房间卡萨的', 42);
INSERT INTO `issuelastmeet` VALUES (64, '福建师大看', 42);
INSERT INTO `issuelastmeet` VALUES (65, '飞机上看', 42);
INSERT INTO `issuelastmeet` VALUES (66, '1212', 43);
INSERT INTO `issuelastmeet` VALUES (67, 'fdsa fdsa', 44);
INSERT INTO `issuelastmeet` VALUES (68, '否金坷垃的撒积分卡拉斯的ajk', 45);
INSERT INTO `issuelastmeet` VALUES (69, '飞机上看啦发四大皆空拉发角度看了撒fjklsd', 45);
INSERT INTO `issuelastmeet` VALUES (70, '飞机上看啦发就是考虑到老师的', 45);
INSERT INTO `issuelastmeet` VALUES (71, '12121', 46);
INSERT INTO `issuelastmeet` VALUES (72, 'fsdafdsafdsafsda', 46);
INSERT INTO `issuelastmeet` VALUES (73, '23dfsafdsafsa', 46);
INSERT INTO `issuelastmeet` VALUES (74, '积分卡萨大', 47);
INSERT INTO `issuelastmeet` VALUES (75, '212121', 48);
INSERT INTO `issuelastmeet` VALUES (76, '23rjklrfds a`', 48);
INSERT INTO `issuelastmeet` VALUES (77, '121212', 49);
INSERT INTO `issuelastmeet` VALUES (78, 'fsdafdsafsd', 49);
INSERT INTO `issuelastmeet` VALUES (79, '1212', 50);
INSERT INTO `issuelastmeet` VALUES (80, '房间卡萨的', 51);
INSERT INTO `issuelastmeet` VALUES (81, '福建省考虑福建省看到发送', 51);
INSERT INTO `issuelastmeet` VALUES (82, '范德萨', 52);
INSERT INTO `issuelastmeet` VALUES (83, '父级SD卡父级SD卡', 53);
INSERT INTO `issuelastmeet` VALUES (84, '飞机上看啦', 53);
INSERT INTO `issuelastmeet` VALUES (85, '323', 54);
INSERT INTO `issuelastmeet` VALUES (86, '543254325', 55);
INSERT INTO `issuelastmeet` VALUES (87, '房间卡拉今飞凯达三 发静安寺', 56);
INSERT INTO `issuelastmeet` VALUES (88, '房间卡的撒今飞凯达安盛', 56);
INSERT INTO `issuelastmeet` VALUES (89, '房间打开啦就房贷卡撒', 57);
INSERT INTO `issuelastmeet` VALUES (90, '房间卡拉发s', 57);
INSERT INTO `issuelastmeet` VALUES (91, '发沙基拉发静安寺', 57);
INSERT INTO `issuelastmeet` VALUES (92, '房间卡萨积分卡萨大啦', 58);
INSERT INTO `issuelastmeet` VALUES (93, '副书记大卡方SD卡', 58);
INSERT INTO `issuelastmeet` VALUES (94, '发生的金卡啦发SD卡', 58);
INSERT INTO `issuelastmeet` VALUES (95, '飞机上看大今飞凯达三', 59);
INSERT INTO `issuelastmeet` VALUES (96, '福建师大卡了发sd', 59);
INSERT INTO `issuelastmeet` VALUES (97, '关于逢狼时刻建安费可视对讲阿卡  金坷垃‘’', 60);
INSERT INTO `issuelastmeet` VALUES (98, '放暑假卡拉分萨克 ‘’', 60);
INSERT INTO `issuelastmeet` VALUES (99, '附近的卡萨冷风机第三', 60);
INSERT INTO `issuelastmeet` VALUES (100, '风刀霜剑啊金坷垃发上点击', 61);
INSERT INTO `issuelastmeet` VALUES (101, 'dsfdsafdsa', 62);
INSERT INTO `issuelastmeet` VALUES (102, '21212', 63);
INSERT INTO `issuelastmeet` VALUES (103, '开发工作督查', 64);
INSERT INTO `issuelastmeet` VALUES (104, '福建师大卡了发', 65);
INSERT INTO `issuelastmeet` VALUES (105, '懂你的萨克记录范德萨', 65);
INSERT INTO `issuelastmeet` VALUES (106, '的撒范德萨范德萨', 66);
INSERT INTO `issuelastmeet` VALUES (107, '你就是我心中的棉花糖', 67);
INSERT INTO `issuelastmeet` VALUES (108, 'fdsafdsafdsaf', 68);
INSERT INTO `issuelastmeet` VALUES (109, '31312321432143', 69);
INSERT INTO `issuelastmeet` VALUES (110, 'rewqrewq', 70);
INSERT INTO `issuelastmeet` VALUES (111, '1212121', 71);
INSERT INTO `issuelastmeet` VALUES (112, '123432去范德萨', 72);
INSERT INTO `issuelastmeet` VALUES (113, '房间卡萨的拉分就开始福建省打开啦', 73);
INSERT INTO `issuelastmeet` VALUES (114, '福建省打开啦发圣诞节咖啡了四大皆空了', 73);
INSERT INTO `issuelastmeet` VALUES (115, '陈鹏', 74);
INSERT INTO `issuelastmeet` VALUES (116, '1234324321', 75);
INSERT INTO `issuelastmeet` VALUES (117, '范德萨发', 76);
INSERT INTO `issuelastmeet` VALUES (118, '发的撒娇KL阿复健科到拉萨发角度看死啦就付款了第三讲课费是', 76);
INSERT INTO `issuelastmeet` VALUES (119, '43254325432', 77);
INSERT INTO `issuelastmeet` VALUES (120, '规划法的四个很多粉丝', 78);
INSERT INTO `issuelastmeet` VALUES (121, '', 79);
INSERT INTO `issuelastmeet` VALUES (122, '', 80);

-- ----------------------------
-- Table structure for loginlog
-- ----------------------------
DROP TABLE IF EXISTS `loginlog`;
CREATE TABLE `loginlog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accoutnid` int(11) DEFAULT NULL COMMENT '账户名',
  `ip` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'ip地址',
  `devicename` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设备详情',
  `logintime` datetime(0) DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for mediaresource
-- ----------------------------
DROP TABLE IF EXISTS `mediaresource`;
CREATE TABLE `mediaresource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `mediaurl` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '附件url',
  `uploaderid` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传人员的工号',
  `uploader` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传人姓名',
  `uploadtime` datetime(0) DEFAULT NULL COMMENT '上传时间',
  `confid` int(11) DEFAULT NULL COMMENT '会议的编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_mediaresource_confid`(`confid`) USING BTREE,
  CONSTRAINT `fk_mediaresource_confid` FOREIGN KEY (`confid`) REFERENCES `conference` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for meetingcollect
-- ----------------------------
DROP TABLE IF EXISTS `meetingcollect`;
CREATE TABLE `meetingcollect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `collegeleader` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '院领导姓名->会议召集人',
  `colltime` datetime(0) DEFAULT NULL COMMENT '时间',
  `termyear` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学年',
  `meetsemesters` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学期',
  `meetweeks` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '周数->开会日期',
  `department` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发起部门',
  `meetcollectsts` smallint(6) DEFAULT 0 COMMENT '采集表状态:0-发起,1-通过审核',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of meetingcollect
-- ----------------------------
INSERT INTO `meetingcollect` VALUES (1, '陈鹏', '2019-05-17 20:08:30', '1', '111', '1', '1', 0);
INSERT INTO `meetingcollect` VALUES (10, '212121', '2019-05-19 08:47:19', '2019', '40', '23', NULL, 0);
INSERT INTO `meetingcollect` VALUES (11, '1212', '2019-05-19 09:38:30', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (12, '1212', '2019-05-19 09:45:23', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (13, 'fdsfsdafsda', '2019-05-19 09:56:14', '2019', '40', '14', NULL, 0);
INSERT INTO `meetingcollect` VALUES (14, '121', '2019-05-19 09:58:58', '2019', '40', '12121', NULL, 0);
INSERT INTO `meetingcollect` VALUES (15, '2121', '2019-05-19 10:03:43', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (16, '陈鹏', '2019-05-19 10:10:58', '2019', '40', '14', NULL, 0);
INSERT INTO `meetingcollect` VALUES (17, '12121212', '2019-05-19 10:19:37', '2019', '46', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (18, '12121', '2019-05-19 10:43:06', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (19, '2121', '2019-05-19 10:50:36', '2019', '40', '1212', NULL, 0);
INSERT INTO `meetingcollect` VALUES (20, '陈鹏', '2019-05-19 10:54:11', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (21, '121', '2019-05-19 10:55:57', '2019', '40', '23', NULL, 0);
INSERT INTO `meetingcollect` VALUES (22, '1313', '2019-05-19 13:01:33', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (23, '12121', '2019-05-19 15:15:44', '2019', '40', '122', NULL, 0);
INSERT INTO `meetingcollect` VALUES (24, '1212', '2019-05-19 16:31:55', '2019', '40', '26', NULL, 0);
INSERT INTO `meetingcollect` VALUES (25, '寒冰', '2019-05-19 16:42:00', '2019', '40', '20', NULL, 0);
INSERT INTO `meetingcollect` VALUES (26, '韩斌', '2019-05-19 16:43:07', '2019', '40', '23', NULL, 0);
INSERT INTO `meetingcollect` VALUES (27, '23', '2019-05-19 16:44:47', '2019', '55', '21', NULL, 0);
INSERT INTO `meetingcollect` VALUES (28, '附近的卡萨', '2019-05-21 16:21:20', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (29, '江科大', '2019-05-22 16:36:04', '2019', '55', '1', NULL, 0);
INSERT INTO `meetingcollect` VALUES (30, '张小龙', '2019-05-22 20:22:42', '2019', '56', '16', NULL, 0);
INSERT INTO `meetingcollect` VALUES (31, '孔磊', '2019-05-24 15:02:45', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (32, '23232', '2019-05-25 11:46:43', '2019', '40', '25', NULL, 0);
INSERT INTO `meetingcollect` VALUES (33, '21212', '2019-05-25 15:38:48', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (34, '陈鹏', '2019-05-26 10:32:06', '2019', '40', '14', NULL, 0);
INSERT INTO `meetingcollect` VALUES (35, '韩斌', '2019-05-27 13:44:40', '2019', '40', '14', NULL, 0);
INSERT INTO `meetingcollect` VALUES (36, '212', '2019-05-28 14:12:58', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (37, '积分速度快', '2019-05-28 14:30:00', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (38, '1212121', '2019-06-09 11:00:14', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (39, '及防水款', '2019-06-18 23:44:36', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (40, '1212', '2019-06-18 23:46:06', '2019', '40', '18', NULL, 0);
INSERT INTO `meetingcollect` VALUES (41, '313', '2019-06-24 21:46:47', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (42, '真敢', '2019-06-25 09:06:30', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (43, '陈鹏', '2019-06-28 20:54:20', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (44, 'dsa', '2019-06-29 09:51:24', '2019', '40', '1212', NULL, 0);
INSERT INTO `meetingcollect` VALUES (45, '江苏', '2019-06-29 15:26:31', '2019', '40', '23', NULL, 0);
INSERT INTO `meetingcollect` VALUES (46, '1212', '2019-06-29 16:24:14', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (47, '陈鹏', '2019-07-05 22:23:24', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (48, '2121', '2019-07-08 18:30:37', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (49, '12', '2019-07-22 08:34:22', '2019', '58', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (50, '1212', '2019-07-27 21:43:47', '2019', '40', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (51, '陈鹏', '2019-07-28 13:05:25', '2019', '58', '12121', NULL, 0);
INSERT INTO `meetingcollect` VALUES (52, '范德萨范德萨', '2019-07-28 23:03:25', '2019', '57', '23', NULL, 0);
INSERT INTO `meetingcollect` VALUES (53, '张少分', '2019-08-03 16:17:30', '2019', '58', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (54, '23232', '2019-08-03 16:40:41', '2019', '58', '2112', NULL, 0);
INSERT INTO `meetingcollect` VALUES (55, '54325432', '2019-08-03 23:56:49', '2019', '58', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (56, '找那个', '2019-08-11 20:15:40', '2019', '58', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (57, '党的数据库', '2019-08-11 20:20:14', '2019', '58', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (58, '张圣诞节福克斯', '2019-08-16 14:22:12', '2019', '58', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (59, '河海', '2019-08-16 17:24:28', '2019', '58', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (60, '张三', '2019-08-17 10:23:54', '2019', '58', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (61, '1221', '2019-08-19 09:46:25', '2019', '58', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (62, 'fdsafdsaf', '2019-08-20 23:41:18', '2019', '58', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (63, '12121', '2019-08-23 22:10:02', '2019', '58', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (64, '陈鹏', '2019-08-24 10:23:27', '2019', '57', '12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (65, '29', '2019-09-02 11:12:24', '2019', '58', '2019-09-03', NULL, 0);
INSERT INTO `meetingcollect` VALUES (66, '44', '2019-09-02 11:58:22', '2019', '58', '2019-09-05', NULL, 0);
INSERT INTO `meetingcollect` VALUES (67, '27', '2019-09-02 12:47:57', '2019', '58', '2019-09-11', NULL, 0);
INSERT INTO `meetingcollect` VALUES (68, '44', '2019-09-02 15:36:20', '2019', '58', '2019-09-10', NULL, 0);
INSERT INTO `meetingcollect` VALUES (69, '29', '2019-09-02 15:38:24', '2019', '58', '2019-09-12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (70, '44', '2019-09-02 15:45:01', '2019', '58', '2019-09-26', NULL, 0);
INSERT INTO `meetingcollect` VALUES (71, '27', '2019-09-02 15:47:09', '2019', '58', '2019-09-03', NULL, 0);
INSERT INTO `meetingcollect` VALUES (72, '44', '2019-09-02 16:14:49', '2019', '58', '2019-09-03', NULL, 0);
INSERT INTO `meetingcollect` VALUES (73, '29', '2019-09-09 19:10:47', '2019', '57', '2019-09-12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (74, '24', '2019-09-11 11:52:03', '2019', '58', '2019-09-13', NULL, 0);
INSERT INTO `meetingcollect` VALUES (75, '29', '2019-09-11 13:28:13', '2019', '58', '2019-09-12', NULL, 0);
INSERT INTO `meetingcollect` VALUES (76, '36', '2019-09-13 21:18:54', '2019', '58', '2019-09-15', NULL, 0);
INSERT INTO `meetingcollect` VALUES (77, '36', '2019-09-13 21:46:13', '2019', '58', '2019-09-14', NULL, 0);
INSERT INTO `meetingcollect` VALUES (78, '29', '2019-09-18 11:11:34', '2019', '56', '2019-09-20', NULL, 0);
INSERT INTO `meetingcollect` VALUES (79, '29', '2019-09-22 15:15:22', '2019', '58', '2019-09-24', NULL, 0);
INSERT INTO `meetingcollect` VALUES (80, '44', '2019-09-22 15:29:28', '2019', '58', '2019-09-28', NULL, 0);

-- ----------------------------
-- Table structure for meetingroom
-- ----------------------------
DROP TABLE IF EXISTS `meetingroom`;
CREATE TABLE `meetingroom`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department` int(11) DEFAULT NULL COMMENT '所属部门编号',
  `roomname` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会议名称',
  `maxcontain` int(11) DEFAULT NULL COMMENT '最大容量',
  `aircondition` smallint(6) DEFAULT 0 COMMENT '是否有空调:0-无空调,1-有',
  `projector` smallint(6) DEFAULT 0 COMMENT '是否有投影仪:0-无,1-有',
  `microphone` smallint(6) DEFAULT 0 COMMENT '是否有麦克风:0-无,1-有',
  `stereo` smallint(6) DEFAULT 0 COMMENT '是否有音响:0-无,1-有',
  `podium` smallint(6) DEFAULT 0 COMMENT '是否有演讲台:0-无,1-有',
  `lightequ` smallint(6) DEFAULT 0 COMMENT '是否有照明设备:0-无,1-有',
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会议室地址',
  `meetingroomurl` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会议室图片地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of meetingroom
-- ----------------------------
INSERT INTO `meetingroom` VALUES (1, 1, '计算机学院楼001', 80, 1, 1, 1, 0, 1, 0, '', '');
INSERT INTO `meetingroom` VALUES (2, 2, '计算机学院楼002', 100, 1, 0, 1, 0, 0, 1, '', '');
INSERT INTO `meetingroom` VALUES (3, 3, '综合楼C201', 121, 1, 0, 1, 0, 1, 1, '', '');
INSERT INTO `meetingroom` VALUES (4, 4, '综合楼C202', 90, 1, 1, 0, 1, 0, 1, '', '');
INSERT INTO `meetingroom` VALUES (5, 3, '综合楼C203', 90, 1, 1, 0, 1, 0, 1, '', '');
INSERT INTO `meetingroom` VALUES (6, 2, '综合楼C204', 12, 1, 1, 0, 0, 0, 0, '', '');
INSERT INTO `meetingroom` VALUES (7, 2, '综合楼C205', 43, 1, 1, 1, 0, 1, 1, '', '');
INSERT INTO `meetingroom` VALUES (8, 3, '综合楼C206', 43, 0, 1, 1, 0, 1, 1, '', '');
INSERT INTO `meetingroom` VALUES (9, 1, '综合楼C207', 33, 1, 1, 0, 1, 1, 0, '', '');
INSERT INTO `meetingroom` VALUES (10, 2, '综合楼C208', 22, 1, 0, 0, 0, 1, 0, '', '');
INSERT INTO `meetingroom` VALUES (11, 2, '综合楼C209', 322, 1, 1, 1, 1, 1, 1, '', NULL);
INSERT INTO `meetingroom` VALUES (12, 2, '综合楼C210', 11, 1, 0, 1, 1, 0, 1, '', '');
INSERT INTO `meetingroom` VALUES (14, 1, '积分卡拉斯积分卡萨', 10, 1, 0, 0, 0, 0, 0, NULL, NULL);
INSERT INTO `meetingroom` VALUES (15, 1, '徐州工程学院 东南大学', 12, 1, 1, 1, 1, 1, 1, NULL, NULL);
INSERT INTO `meetingroom` VALUES (16, 1, 'jfksdlajfklsd', 12, 1, 1, 1, 1, 1, 1, NULL, NULL);
INSERT INTO `meetingroom` VALUES (17, 3, 'fjsdkla', 1, 1, 1, 1, 0, 0, 0, NULL, NULL);
INSERT INTO `meetingroom` VALUES (18, 2, '123232344', 121, 1, 1, 1, 1, 1, 1, NULL, NULL);
INSERT INTO `meetingroom` VALUES (19, 2, '123123', 12, 0, 1, 0, 0, 1, 0, NULL, NULL);
INSERT INTO `meetingroom` VALUES (20, 1, '会议室a', 12, 0, 1, 1, 1, 0, 0, NULL, NULL);
INSERT INTO `meetingroom` VALUES (21, 1, '搞笑会议室', 400, 1, 1, 1, 1, 1, 1, NULL, NULL);
INSERT INTO `meetingroom` VALUES (22, 1, '清华大学-江科大人工智能联合实验室', 90, 1, 1, 1, 1, 1, 1, NULL, NULL);
INSERT INTO `meetingroom` VALUES (23, 2, '北京大学-江科大物联网联合实验室', 23, 1, 1, 1, 1, 0, 1, NULL, NULL);
INSERT INTO `meetingroom` VALUES (24, 2, '物联网国家重点实验室', 33, 1, 1, 1, 0, 0, 0, NULL, NULL);

-- ----------------------------
-- Table structure for mposition
-- ----------------------------
DROP TABLE IF EXISTS `mposition`;
CREATE TABLE `mposition`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职务名称',
  `positionnum` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职务编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mposition
-- ----------------------------
INSERT INTO `mposition` VALUES (15, '教授', '001');
INSERT INTO `mposition` VALUES (16, '副教授', '002');
INSERT INTO `mposition` VALUES (17, '讲师', '003');
INSERT INTO `mposition` VALUES (18, '实验研究员', '004');
INSERT INTO `mposition` VALUES (19, '辅导员', '005');

-- ----------------------------
-- Table structure for opconflog
-- ----------------------------
DROP TABLE IF EXISTS `opconflog`;
CREATE TABLE `opconflog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opworkerid` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人员工号',
  `opworker` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人员名称',
  `opdescription` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作说明',
  `operip` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人ip地址',
  `device` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设备详情',
  `confid` int(11) DEFAULT NULL COMMENT '会议编号',
  `optime` datetime(0) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for privilege
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `privilegename` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限名称',
  `keyname` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限关键字',
  `description` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `router` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '路由',
  `ismenu` smallint(6) DEFAULT NULL COMMENT '是否是菜单',
  `parentnodeid` int(11) DEFAULT -1 COMMENT '父节点编号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `privilegename`(`privilegename`) USING BTREE,
  UNIQUE INDEX `keyname`(`keyname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
  `keyname` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关键字',
  `description` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '校领导', '学校领导', '学校的最高级别的领导');
INSERT INTO `role` VALUES (2, '院领导', '学院领导', '学院领导');
INSERT INTO `role` VALUES (3, '普通教职员工', '普通教职员工', '教职员工');

-- ----------------------------
-- Table structure for semester
-- ----------------------------
DROP TABLE IF EXISTS `semester`;
CREATE TABLE `semester`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `semesterid` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学习编号',
  `semestername` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学期名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of semester
-- ----------------------------
INSERT INTO `semester` VALUES (40, '201901', '2018/2019学年,第一学期');
INSERT INTO `semester` VALUES (55, '201902', '2019/2020学年,第二学期');
INSERT INTO `semester` VALUES (56, '202001', '2020/2021学年,第一学期');
INSERT INTO `semester` VALUES (57, '202002', '2020/2021学年,第二学期');
INSERT INTO `semester` VALUES (58, '202101', '2021/2022学年,第一学期');

-- ----------------------------
-- Table structure for suggestion
-- ----------------------------
DROP TABLE IF EXISTS `suggestion`;
CREATE TABLE `suggestion`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maincontent` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '建议解决方案',
  `meetcollid` int(11) DEFAULT NULL COMMENT '会议议题采集表编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_suggestion_meetcollid`(`meetcollid`) USING BTREE,
  CONSTRAINT `fk_suggestion_meetcollid` FOREIGN KEY (`meetcollid`) REFERENCES `meetingcollect` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 117 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of suggestion
-- ----------------------------
INSERT INTO `suggestion` VALUES (7, '423143214312', 10);
INSERT INTO `suggestion` VALUES (8, '543254325432', 11);
INSERT INTO `suggestion` VALUES (9, '654326543654', 11);
INSERT INTO `suggestion` VALUES (10, '543254325432', 12);
INSERT INTO `suggestion` VALUES (11, '654326543654', 12);
INSERT INTO `suggestion` VALUES (12, 'asfdafsafsdafsda', 13);
INSERT INTO `suggestion` VALUES (13, 'dfsafdsafdsfafasd', 13);
INSERT INTO `suggestion` VALUES (14, '12', 14);
INSERT INTO `suggestion` VALUES (15, '212121', 15);
INSERT INTO `suggestion` VALUES (16, '关于解除南京理工大学985平台的解决方案', 16);
INSERT INTO `suggestion` VALUES (17, 'VCD施工方的', 17);
INSERT INTO `suggestion` VALUES (18, '21212121', 18);
INSERT INTO `suggestion` VALUES (19, '1212121', 19);
INSERT INTO `suggestion` VALUES (20, '房间卡第三课', 20);
INSERT INTO `suggestion` VALUES (21, '21', 21);
INSERT INTO `suggestion` VALUES (22, '福建师大卡了', 21);
INSERT INTO `suggestion` VALUES (23, '12312312', 22);
INSERT INTO `suggestion` VALUES (24, '服务费', 23);
INSERT INTO `suggestion` VALUES (25, '分为非', 23);
INSERT INTO `suggestion` VALUES (26, 'ew范德萨发生的', 23);
INSERT INTO `suggestion` VALUES (27, '3423423', 24);
INSERT INTO `suggestion` VALUES (28, '返回角度看撒尽快发的撒', 25);
INSERT INTO `suggestion` VALUES (29, '附近的斯卡拉', 25);
INSERT INTO `suggestion` VALUES (30, '富士康', 26);
INSERT INTO `suggestion` VALUES (31, '范德萨发地方萨芬大地方撒范德萨范德萨fdsa fdsafdsafdsaf', 27);
INSERT INTO `suggestion` VALUES (32, '胡椒粉可是大忌', 28);
INSERT INTO `suggestion` VALUES (33, '房间卡拉是大防静电三复健科到拉萨', 29);
INSERT INTO `suggestion` VALUES (34, '附近开始啦的', 29);
INSERT INTO `suggestion` VALUES (35, '福建省打开啦飞机上看的', 30);
INSERT INTO `suggestion` VALUES (36, '福建师大卡了积分看电视', 30);
INSERT INTO `suggestion` VALUES (37, '福建省打开啦九分裤代理商', 30);
INSERT INTO `suggestion` VALUES (38, '房间卡萨的垃圾福克斯d', 31);
INSERT INTO `suggestion` VALUES (39, '发动机是卡了否', 31);
INSERT INTO `suggestion` VALUES (40, '2323232', 32);
INSERT INTO `suggestion` VALUES (41, '2121', 33);
INSERT INTO `suggestion` VALUES (42, '1212121', 33);
INSERT INTO `suggestion` VALUES (43, '1212', 33);
INSERT INTO `suggestion` VALUES (44, '及防水款打蜡附近开始啦的放假快乐', 34);
INSERT INTO `suggestion` VALUES (45, '3232332', 35);
INSERT INTO `suggestion` VALUES (46, '2121', 36);
INSERT INTO `suggestion` VALUES (47, '房贷卡撒', 37);
INSERT INTO `suggestion` VALUES (48, '福建省', 37);
INSERT INTO `suggestion` VALUES (49, '福建省立刻', 37);
INSERT INTO `suggestion` VALUES (50, '2121212121212121', 38);
INSERT INTO `suggestion` VALUES (51, '飞机上看', 39);
INSERT INTO `suggestion` VALUES (52, '积分卡萨', 39);
INSERT INTO `suggestion` VALUES (53, '1212', 40);
INSERT INTO `suggestion` VALUES (54, '3131313', 41);
INSERT INTO `suggestion` VALUES (55, '福建省看看', 42);
INSERT INTO `suggestion` VALUES (56, '放暑假卡', 42);
INSERT INTO `suggestion` VALUES (57, '23即可3', 43);
INSERT INTO `suggestion` VALUES (58, '放暑假卡', 43);
INSERT INTO `suggestion` VALUES (59, 'safdsafdsafdsa', 44);
INSERT INTO `suggestion` VALUES (60, '飞机上看啦接口放假快乐撒', 45);
INSERT INTO `suggestion` VALUES (61, '福建省看到了金坷垃jkljfkl是否就开始啦考虑', 45);
INSERT INTO `suggestion` VALUES (62, 'fjsklafjskla;', 46);
INSERT INTO `suggestion` VALUES (63, 'fdsafdsafdsa', 46);
INSERT INTO `suggestion` VALUES (64, 'fdsafdsafdsafdsafdsafdsafsafsdafdsa', 46);
INSERT INTO `suggestion` VALUES (65, '福建省考虑', 47);
INSERT INTO `suggestion` VALUES (66, 'jaignsu kjfksdljafklsd', 48);
INSERT INTO `suggestion` VALUES (67, 'fskjlf sdjkl', 48);
INSERT INTO `suggestion` VALUES (68, '344444', 49);
INSERT INTO `suggestion` VALUES (69, '232323', 49);
INSERT INTO `suggestion` VALUES (70, '121212', 50);
INSERT INTO `suggestion` VALUES (71, '清华大学', 51);
INSERT INTO `suggestion` VALUES (72, '北京大学', 51);
INSERT INTO `suggestion` VALUES (73, '范德萨范德萨', 52);
INSERT INTO `suggestion` VALUES (74, '江苏科技大学', 53);
INSERT INTO `suggestion` VALUES (75, '东南大学', 53);
INSERT INTO `suggestion` VALUES (76, '32323', 54);
INSERT INTO `suggestion` VALUES (77, '43254326326', 55);
INSERT INTO `suggestion` VALUES (78, '豆粉就开始了', 56);
INSERT INTO `suggestion` VALUES (79, '房贷卡啦能加速卡', 56);
INSERT INTO `suggestion` VALUES (80, '东南大修理件发大水房间卡拉', 57);
INSERT INTO `suggestion` VALUES (81, '房间卡拉发蒋老师房间卡拉啊', 57);
INSERT INTO `suggestion` VALUES (82, '发电视机卡立方但是', 58);
INSERT INTO `suggestion` VALUES (83, '发生的金卡 发动机扩散', 58);
INSERT INTO `suggestion` VALUES (84, '范德萨接口放到零售价啊', 59);
INSERT INTO `suggestion` VALUES (85, '东南大学房间卡拉积分是', 60);
INSERT INTO `suggestion` VALUES (86, '反倒是卡将返回都是看见', 60);
INSERT INTO `suggestion` VALUES (87, '福建省打开啦发上课', 61);
INSERT INTO `suggestion` VALUES (88, 'afdsafdsad', 62);
INSERT INTO `suggestion` VALUES (89, 'fdsafdsafdsa', 62);
INSERT INTO `suggestion` VALUES (90, '212121', 63);
INSERT INTO `suggestion` VALUES (91, '', 64);
INSERT INTO `suggestion` VALUES (92, '都是的额发角度看死啦fsjk', 65);
INSERT INTO `suggestion` VALUES (93, '发动机撒开了房节点上卡发了多少啊', 65);
INSERT INTO `suggestion` VALUES (94, '都弄点击萨克雷', 65);
INSERT INTO `suggestion` VALUES (95, 'fretgrewwyhtrsgdfsgfds', 66);
INSERT INTO `suggestion` VALUES (96, '有你世界都变了', 67);
INSERT INTO `suggestion` VALUES (97, 'afdsaffffffffffffffffffffffffffffff', 68);
INSERT INTO `suggestion` VALUES (98, '543654666666666666666', 69);
INSERT INTO `suggestion` VALUES (99, 'ewqrewqrewqr', 70);
INSERT INTO `suggestion` VALUES (100, '11122222222222222', 71);
INSERT INTO `suggestion` VALUES (101, 'fdsafdfffffffffffffffffffffffffffff', 72);
INSERT INTO `suggestion` VALUES (102, '江苏附近的斯卡拉房间卡萨的啦', 73);
INSERT INTO `suggestion` VALUES (103, '发角度看撒浪费就但萨克浪费大', 74);
INSERT INTO `suggestion` VALUES (104, '附近的斯卡拉附近的斯卡拉今飞凯达离散房间卡的撒啦发动机开始啦附近的斯卡拉发角度看死啦', 74);
INSERT INTO `suggestion` VALUES (105, '发动机是咖啡电视机卡立方角度看撒啦积分江苏', 74);
INSERT INTO `suggestion` VALUES (106, '5436754376547654', 75);
INSERT INTO `suggestion` VALUES (107, '推入46台wtrewtrewtre', 75);
INSERT INTO `suggestion` VALUES (108, '放暑假卡放暑假卡九分裤', 76);
INSERT INTO `suggestion` VALUES (109, '发生的金卡冷风机开塞露房间卡萨的', 76);
INSERT INTO `suggestion` VALUES (110, '54364536754765476547654', 77);
INSERT INTO `suggestion` VALUES (111, '回复广东省花港饭店花港饭店很过分的巨化股份就后台分', 78);
INSERT INTO `suggestion` VALUES (112, '副书记大卡方就是点开福建省看到', 79);
INSERT INTO `suggestion` VALUES (113, '福建省咖啡开始的', 79);
INSERT INTO `suggestion` VALUES (114, '放暑假卡积分卡萨大', 79);
INSERT INTO `suggestion` VALUES (115, '附近的萨卡见风使舵卡拉房间卡的撒啦及', 80);
INSERT INTO `suggestion` VALUES (116, '附近的斯卡拉放假速度快了', 80);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accid` int(11) DEFAULT NULL COMMENT '账户编号',
  `usrname` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户姓名',
  `idcard` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号码',
  `gender` smallint(6) DEFAULT 1 COMMENT '性别 male:1,female:0',
  `national` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '汉族' COMMENT '民族',
  `recofschool` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '本科' COMMENT '学历',
  `entparttime` datetime(0) DEFAULT NULL COMMENT '入党时间',
  `formtime` datetime(0) DEFAULT NULL COMMENT '转正时间',
  `partstatus` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '党籍状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_userinfo_accid`(`accid`) USING BTREE,
  CONSTRAINT `fk_userinfo_accid` FOREIGN KEY (`accid`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (9, 9, '陈鹏+', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (10, 10, '张萌萌', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (11, 11, '吴庆', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (12, 12, '李想', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (13, 13, '陈富贵', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (14, 14, '吴健康', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (21, 23, '王世通', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (22, 24, '汪旭洋', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (23, 25, '小鹏', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (24, 26, '习近彧', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (25, 27, '河海大学', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (26, 28, 'test11', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (27, 29, 'demo', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (28, 30, '测试', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (29, 34, '远望', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (30, 36, '清华大学', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (31, 38, '陈起名', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (32, 39, 'demo111', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (33, 41, 'chenpeng', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (34, 42, 'XIAOPENG', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (35, 43, '东南大学', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (36, 44, 'thompson', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (37, 45, 'zhangsan', NULL, 1, '汉族', '本科', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (38, 46, '上官空成', NULL, 1, '汉族', '本科', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for userprivilege
-- ----------------------------
DROP TABLE IF EXISTS `userprivilege`;
CREATE TABLE `userprivilege`  (
  `roleid` int(11) NOT NULL COMMENT '角色编号',
  `priviid` int(11) NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`roleid`, `priviid`) USING BTREE,
  INDEX `fk_userprivilege_priviid`(`priviid`) USING BTREE,
  CONSTRAINT `fk_userprivilege_priviid` FOREIGN KEY (`priviid`) REFERENCES `privilege` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fk_userprivilege_roleid` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole`  (
  `accid` int(11) NOT NULL COMMENT '账户编号',
  `roleid` int(11) NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`accid`, `roleid`) USING BTREE,
  INDEX `fk_userole_roleid`(`roleid`) USING BTREE,
  CONSTRAINT `fk_userole_roleid` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fk_userrole_accid` FOREIGN KEY (`accid`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES (10, 1);
INSERT INTO `userrole` VALUES (23, 1);
INSERT INTO `userrole` VALUES (25, 1);
INSERT INTO `userrole` VALUES (9, 2);
INSERT INTO `userrole` VALUES (11, 2);
INSERT INTO `userrole` VALUES (13, 2);
INSERT INTO `userrole` VALUES (14, 2);
INSERT INTO `userrole` VALUES (24, 2);
INSERT INTO `userrole` VALUES (12, 3);
INSERT INTO `userrole` VALUES (26, 3);

-- ----------------------------
-- Table structure for usrdep
-- ----------------------------
DROP TABLE IF EXISTS `usrdep`;
CREATE TABLE `usrdep`  (
  `depid` int(11) NOT NULL COMMENT '部门的编号',
  `usrid` int(11) NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`depid`, `usrid`) USING BTREE,
  INDEX `fk_usrdep_usrid`(`usrid`) USING BTREE,
  CONSTRAINT `fk_usrdep_depid` FOREIGN KEY (`depid`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fk_usrdep_usrid` FOREIGN KEY (`usrid`) REFERENCES `userinfo` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of usrdep
-- ----------------------------
INSERT INTO `usrdep` VALUES (1, 9);
INSERT INTO `usrdep` VALUES (2, 9);
INSERT INTO `usrdep` VALUES (1, 10);
INSERT INTO `usrdep` VALUES (2, 10);
INSERT INTO `usrdep` VALUES (1, 11);
INSERT INTO `usrdep` VALUES (2, 11);
INSERT INTO `usrdep` VALUES (2, 12);
INSERT INTO `usrdep` VALUES (1, 13);
INSERT INTO `usrdep` VALUES (1, 14);
INSERT INTO `usrdep` VALUES (1, 21);
INSERT INTO `usrdep` VALUES (1, 22);
INSERT INTO `usrdep` VALUES (5, 23);
INSERT INTO `usrdep` VALUES (1, 24);
INSERT INTO `usrdep` VALUES (1, 25);
INSERT INTO `usrdep` VALUES (1, 26);
INSERT INTO `usrdep` VALUES (1, 27);
INSERT INTO `usrdep` VALUES (1, 28);
INSERT INTO `usrdep` VALUES (1, 29);
INSERT INTO `usrdep` VALUES (1, 30);
INSERT INTO `usrdep` VALUES (2, 30);
INSERT INTO `usrdep` VALUES (3, 31);
INSERT INTO `usrdep` VALUES (2, 32);
INSERT INTO `usrdep` VALUES (3, 32);
INSERT INTO `usrdep` VALUES (4, 33);
INSERT INTO `usrdep` VALUES (1, 34);
INSERT INTO `usrdep` VALUES (1, 35);
INSERT INTO `usrdep` VALUES (1, 36);
INSERT INTO `usrdep` VALUES (1, 37);
INSERT INTO `usrdep` VALUES (1, 38);

-- ----------------------------
-- Table structure for usrduty
-- ----------------------------
DROP TABLE IF EXISTS `usrduty`;
CREATE TABLE `usrduty`  (
  `usrid` int(11) NOT NULL COMMENT '用户编号',
  `dutyid` int(11) NOT NULL COMMENT '职位编号',
  PRIMARY KEY (`usrid`, `dutyid`) USING BTREE,
  INDEX `fk_usrduty_posid`(`dutyid`) USING BTREE,
  CONSTRAINT `fk_usrduty_posid` FOREIGN KEY (`dutyid`) REFERENCES `duty` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fk_usrduty_usrid` FOREIGN KEY (`usrid`) REFERENCES `userinfo` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of usrduty
-- ----------------------------
INSERT INTO `usrduty` VALUES (9, 1);
INSERT INTO `usrduty` VALUES (10, 2);
INSERT INTO `usrduty` VALUES (38, 2);
INSERT INTO `usrduty` VALUES (12, 5);
INSERT INTO `usrduty` VALUES (14, 5);
INSERT INTO `usrduty` VALUES (13, 6);
INSERT INTO `usrduty` VALUES (14, 6);
INSERT INTO `usrduty` VALUES (11, 7);
INSERT INTO `usrduty` VALUES (21, 8);

-- ----------------------------
-- Table structure for usrposition
-- ----------------------------
DROP TABLE IF EXISTS `usrposition`;
CREATE TABLE `usrposition`  (
  `usrid` int(11) NOT NULL COMMENT '用户编号',
  `posid` int(11) NOT NULL COMMENT '职位编号',
  PRIMARY KEY (`usrid`, `posid`) USING BTREE,
  INDEX `fk_usrposition_posid`(`posid`) USING BTREE,
  CONSTRAINT `fk_usrposition_posid` FOREIGN KEY (`posid`) REFERENCES `mposition` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fk_usrposition_usrid` FOREIGN KEY (`usrid`) REFERENCES `userinfo` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of usrposition
-- ----------------------------
INSERT INTO `usrposition` VALUES (9, 15);
INSERT INTO `usrposition` VALUES (10, 15);
INSERT INTO `usrposition` VALUES (13, 15);
INSERT INTO `usrposition` VALUES (21, 15);
INSERT INTO `usrposition` VALUES (22, 15);
INSERT INTO `usrposition` VALUES (24, 15);
INSERT INTO `usrposition` VALUES (25, 15);
INSERT INTO `usrposition` VALUES (26, 15);
INSERT INTO `usrposition` VALUES (27, 15);
INSERT INTO `usrposition` VALUES (28, 15);
INSERT INTO `usrposition` VALUES (29, 15);
INSERT INTO `usrposition` VALUES (30, 15);
INSERT INTO `usrposition` VALUES (32, 15);
INSERT INTO `usrposition` VALUES (35, 15);
INSERT INTO `usrposition` VALUES (36, 15);
INSERT INTO `usrposition` VALUES (37, 15);
INSERT INTO `usrposition` VALUES (38, 15);
INSERT INTO `usrposition` VALUES (11, 16);
INSERT INTO `usrposition` VALUES (24, 16);
INSERT INTO `usrposition` VALUES (25, 16);
INSERT INTO `usrposition` VALUES (26, 16);
INSERT INTO `usrposition` VALUES (27, 16);
INSERT INTO `usrposition` VALUES (31, 16);
INSERT INTO `usrposition` VALUES (32, 16);
INSERT INTO `usrposition` VALUES (34, 16);
INSERT INTO `usrposition` VALUES (35, 16);
INSERT INTO `usrposition` VALUES (36, 16);
INSERT INTO `usrposition` VALUES (14, 17);
INSERT INTO `usrposition` VALUES (22, 17);
INSERT INTO `usrposition` VALUES (24, 17);
INSERT INTO `usrposition` VALUES (27, 17);
INSERT INTO `usrposition` VALUES (30, 17);
INSERT INTO `usrposition` VALUES (12, 18);
INSERT INTO `usrposition` VALUES (14, 18);
INSERT INTO `usrposition` VALUES (23, 18);
INSERT INTO `usrposition` VALUES (33, 18);

-- ----------------------------
-- Table structure for voicerecord
-- ----------------------------
DROP TABLE IF EXISTS `voicerecord`;
CREATE TABLE `voicerecord`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `voicedes` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `voiceurl` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '录音的地址',
  `conftitlerecordid` int(11) DEFAULT NULL COMMENT '会议记录编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_voicerecord_conftitlerecordid`(`conftitlerecordid`) USING BTREE,
  CONSTRAINT `fk_voicerecord_conftitlerecordid` FOREIGN KEY (`conftitlerecordid`) REFERENCES `conftitlerecord` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of voicerecord
-- ----------------------------
INSERT INTO `voicerecord` VALUES (56, 'Tue Jul 02 15:43:15 CST 2019', '5d1b0b1328b0d52c18340e95', 90);
INSERT INTO `voicerecord` VALUES (57, 'Fri Jul 05 22:26:44 CST 2019', '5d1f5e2428b0d53b889649be', 96);
INSERT INTO `voicerecord` VALUES (58, 'Fri Jul 05 22:26:46 CST 2019', '5d1f5e2628b0d53b889649c7', 96);
INSERT INTO `voicerecord` VALUES (59, 'Mon Jul 08 18:31:08 CST 2019', '5d231b6c28b0d52c98153c89', 97);
INSERT INTO `voicerecord` VALUES (63, 'Sat Jul 27 21:44:48 CST 2019', '5d3c555098bd9dd2a050cd52', 103);
INSERT INTO `voicerecord` VALUES (66, 'Sat Aug 17 10:25:26 CST 2019', '5d5765962c18b0be6873292b', 125);
INSERT INTO `voicerecord` VALUES (67, 'Tue Aug 20 23:39:53 CST 2019', '5d5c144821fe2443235fa595', 130);

SET FOREIGN_KEY_CHECKS = 1;
