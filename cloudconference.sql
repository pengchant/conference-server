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

 Date: 27/10/2019 16:08:56
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
-- Table structure for depchildrens
-- ----------------------------
DROP TABLE IF EXISTS `depchildrens`;
CREATE TABLE `depchildrens`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `depname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '子部门的名称',
  `departid` int(11) DEFAULT NULL COMMENT '与部门表关联',
  `parentid` int(11) DEFAULT NULL COMMENT '父部门编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
-- Table structure for usrsecdep
-- ----------------------------
DROP TABLE IF EXISTS `usrsecdep`;
CREATE TABLE `usrsecdep`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `secdepid` int(11) DEFAULT NULL COMMENT '用户二级部门编号与用户表关联',
  `usrid` int(11) DEFAULT NULL COMMENT '用户表编号与用户表关联',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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

SET FOREIGN_KEY_CHECKS = 1;
