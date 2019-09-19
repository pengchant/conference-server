-- 1.账户表
drop table if exists account;
create table account (
	id int primary key auto_increment, 
	workerid char(30) UNIQUE comment "工号", 
	email varchar(100) UNIQUE comment "邮箱",
	wxopenid varchar(200) unique comment "微信openid",
	wxflag smallint comment "是否已经绑定微信",
	registtime datetime comment "注册时间",
	phonenum char(50) comment "手机号码",
	pwd char(200) comment "账户密码",
	userstatus smallint comment "账户的状态"
);

-- 2.用户角色表
drop table if exists role;
create table role (
	id int primary key auto_increment,
	rolename varchar(200) comment "角色名称",
	keyname char(200) comment "关键字",
	description varchar(400) comment "描述"
);

-- 3.权限表
drop table if exists privilege;
create table privilege (
	id int primary key auto_increment,
	privilegename char(200) unique comment "权限名称",
	keyname char(200) unique comment "权限关键字",
	description varchar(300) comment "描述",
	router varchar(400) comment "路由",
	ismenu smallint comment "是否是菜单",
	parentnodeid int default '-1' comment "父节点编号"
);

-- 4.账户角色表
drop table if exists userrole;
create table userrole (
	accid int comment "账户编号",
	roleid int comment "权限编号",
	constraint pk_userrole primary key (accid, roleid),
	constraint fk_userrole_accid foreign key (accid) references account(id) ON DELETE CASCADE ON UPDATE RESTRICT,
	constraint fk_userole_roleid foreign key (roleid) references role(id) ON DELETE CASCADE ON UPDATE RESTRICT
);

-- 5.角色权限表
drop table if exists userprivilege;
create table userprivilege (
	roleid int comment "角色编号",
	priviid int comment "权限编号",
	constraint pk_userprivilege primary key (roleid, priviid),
	constraint fk_userprivilege_roleid foreign key(roleid) references role(id) on delete cascade on update restrict,
	constraint fk_userprivilege_priviid foreign key(priviid) references privilege(id) on delete cascade on update restrict
);


-- 6.用户信息表
drop table if exists userinfo;
create table userinfo (
	id int primary key auto_increment,
	accid int comment "账户编号",
	idcard char(50) comment "身份证号码",
	gender smallint default '1' comment "性别 male:1,female:0",
  national char(200) default '汉族' comment "民族",
	recofschool char(100) default '本科' comment "学历",
	entparttime datetime comment "入党时间",
	formtime datetime comment "转正时间",
	partstatus char(200) comment "党籍状态",
	constraint fk_userinfo_accid foreign key (accid) references account(id) on delete cascade on update restrict
);

-- 7.职务表
drop table if exists mposition;
create table mposition (
	id int primary key auto_increment,
	position char(200) comment "职务名称",
	positionnum char(100) comment "职务编号"
);

-- 8.用户职务表
drop table if exists usrposition;
create table usrposition (
  usrid int comment "用户编号",
	posid int comment "职位编号",
	constraint pk_usrposition primary key (usrid, posid),
  constraint fk_usrposition_usrid foreign key(usrid) references userinfo(id) on delete cascade on update restrict,
	constraint fk_usrposition_posid foreign key(posid) references mposition(id) on delete cascade on update restrict
);

-- 9.部门表
drop table if exists department;
create table department (
	id int primary key auto_increment,
	departnum char(100) comment "部门编号",
	departname varchar(200) comment "部门名称"
);


-- 10.用户所属部门表
drop table if exists usrdep;
create table usrdep (
	depid int comment "部门的编号",
	usrid int comment "用户编号",
	constraint pk_usrdep primary key (depid, usrid),
	constraint fk_usrdep_depid foreign key (depid) references department(id) on delete cascade on update restrict,
	constraint fk_usrdep_usrid foreign key (usrid) references userinfo(id) on delete cascade on update restrict
);


-- 11.会议议题采集表
drop table if exists mettingcollect;
create table meetingcollect (
	id int primary key auto_increment,
	collegeleader char(100) comment "院领导姓名",
	colltime datetime comment "时间",
	termyear char(100) comment "学年",
	meetsemesters char(100) comment "学期",
	meetweeks char(100) comment "周数",
	department varchar(400) comment "发起部门",
	meetcollectsts smallint default '0' comment "采集表状态:0-发起,1-通过审核"
);


-- 12.上次会议所提议题
drop table if exists issuelastmeet;
create table issuelastmeet (
	id int primary key auto_increment,
	maincontent varchar(500) comment "主要内容",
	meetcollid int comment "会议议题采集表编号",
	constraint fk_issuelastmeet_meetcollid foreign key(meetcollid) references meetingcollect(id) on delete cascade on update restrict
);


-- 13.本次会议需解决的议题
drop table if exists issuecurmeet;
create table issuecurmeet (
	id int primary key auto_increment,
	mainconent varchar(500) comment "主要内容",
	meetcollid int comment "会议议题采集表编号",
	constraint fk_issuecurmeet_meetcollid foreign key(meetcollid) references meetingcollect(id) on delete cascade on update restrict
);


-- 14.建议解决方案
drop table if exists suggestion;
create table suggestion (
	id int primary key auto_increment,
	maincontent varchar(500) comment "建议解决方案",
	meetcollid int comment "会议议题采集表编号",
	constraint fk_suggestion_meetcollid foreign key(meetcollid) references meetingcollect(id) on delete cascade on update restrict
);

-- 15.学期表
drop table if exists semester;
create table semester (
	id int primary key auto_increment,
	semesterid char(200) comment "学习编号",
	semestername varchar(400) comment "学期名称"
);


-- 16.会议级别
drop table if exists conflevel;
create table conflevel (
	id int primary key auto_increment,
	levelname varchar(400) comment "会议名称",
	leveldes varchar(400) comment "级别描述"
);


-- 17.会议属性
drop table if exists confattributes;
create table confattributes (
	id int primary key auto_increment,
	attrname char(200) comment "属性名称",
	attrdes varchar(400) comment "属性描述"
);


-- 18.会议状态
drop table if exists confstatus;
create table confstatus(
	id int primary key auto_increment,
	confstatus char(200) comment "会议状态名称",
	confdes varchar(400) comment "会议状态描述"
);


-- 19.会议
drop table if exists conference;
create table conference (
	id int primary key auto_increment,
	confname varchar(200) comment "会议名称",
	semesterid int comment "学期编号",
	conflevelid int comment "会议级别编号",
	confstatusid int comment "会议状态编号",
	hosterid char(200) comment "主持人工号",
	hoster char(200) comment "主持人姓名",
	recorderid char(200) comment "记录人工号",
	recorder char(200) comment "记录人姓名",
	conclusion text comment "形成的决议，决议内容",
	abstract text comment "会议摘要",
	confqrcodeurl varchar(400) comment "会议二维码地址",
	meetcollectid int comment "会议议题采集编号",
	confstatus smallint comment "会议状态",
	constraint fk_conference_semesterid foreign key(semesterid) references semester(id) on delete cascade on update restrict,
	constraint fk_conference_conflevelid foreign key(conflevelid) references conflevel(id) on delete cascade on update restrict,
	constraint fk_conference_confstatusid foreign key(confstatusid) references confstatus(id) on delete cascade on update restrict,
	constraint fk_conference_meetcollectid foreign key(meetcollectid) references meetingcollect(id) on delete cascade on update restrict
);

-- 20.参会人员
drop table if exists attendes;
create table attendes (
	id int primary key auto_increment,
	workerid char(200) comment "参会人员工号",
	wokername char(200) comment "参会人员",
	hasattend smallint default '0' comment "是否到场:0不到场,1:到场",
	confid int comment "会议编号",
	constraint fk_attendes_confid foreign key(confid) references conference(id) on delete cascade on update restrict
);


-- 21.附件表
drop table if exists mediaresource;
create table mediaresource (
	id int primary key auto_increment,
	description varchar(400) comment "描述",
	mediaurl varchar(300) comment "附件url",
	uploaderid char(200) comment "上传人员的工号",
	uploader char(200) comment "上传人姓名",
	uploadtime datetime comment "上传时间",
	confid int comment "会议的编号",
	constraint fk_mediaresource_confid foreign key(confid) references conference(id) on delete cascade on update restrict
);

-- 22.会议的属性
drop table if exists confattr;
create table confattr (
 confid int comment "会议编号",
 confattrid int comment "会议属性编号",
 constraint pk_confattr primary key(confid, confattrid),
 constraint fk_confattr_confid foreign key(confid) references conference(id) on delete cascade on update restrict,
 constraint fk_confattr_confattrid foreign key(confattrid) references confattributes(id) on delete cascade on update restrict
);

-- 23.会议议题表
drop table if exists conftitle;
create table conftitle (
	id int primary key auto_increment,
	conftitlecnt varchar(500) comment "议题内容",
	confid int comment "会议编号",
	constraint fk_conftitle_confid foreign key(confid) references conference(id) on delete cascade on update restrict
);


-- 24.会议议题记录表
drop table if exists conftitlerecord;
create table conftitlerecord (
	id int primary key auto_increment,
	speakerid char(200) comment "发言人工号",
	speakername char(200) comment "发言人",
	speaking text comment "发言内容",
	speaktime datetime comment "发言时间",
	conftitleid int comment "会议议题编号",
	constraint fk_conftitlerecord_conftitleid foreign key(conftitleid) references conftitle(id) on delete cascade on update restrict
);


-- 25.录音表
drop table if exists voicerecord;
create table voicerecord (
	id int primary key auto_increment,
	voicedes varchar(500) comment "描述",
	voiceurl varchar(500) comment "录音的地址",
	conftitlerecordid int comment "会议记录编号",
	constraint fk_voicerecord_conftitlerecordid foreign key(conftitlerecordid) references conftitlerecord(id) on delete cascade on update restrict
);

-- 26.会议室表
drop table if exists meetingroom;
create table meetingroom (
	id int primary key auto_increment,
	department int comment "所属部门编号",
	roomname char(200) comment "会议名称",
	maxcontain int comment "最大容量",
	aircondition smallint default '0' comment "是否有空调:0-无空调,1-有",
	projector smallint default '0' comment "是否有投影仪:0-无,1-有",
	microphone smallint default '0' comment "是否有麦克风:0-无,1-有",
	stereo smallint default '0' comment "是否有音响:0-无,1-有",
	podium smallint default '0' comment "是否有演讲台:0-无,1-有",
	lightequ smallint default '0' comment "是否有照明设备:0-无,1-有",
	address varchar(500) comment "会议室地址",
	meetingroomurl varchar(500) comment "会议室图片地址"
);


-- 27.会议室占用表
drop table if exists confmeetingroom;
create table confmeetingroom (
	confid int comment "会议编号",
	meetroomid int comment "会议编号",
	constraint pk_confmeetingroom primary key(confid, meetroomid),
	constraint fk_confmeetingroom_confid foreign key(confid) references conftitle(id) on delete cascade on update restrict,
	constraint fk_confmeetingroom_meetroomid foreign key(meetroomid) references meetingroom(id)  on delete cascade on update restrict
);


-- 28.会议操作日志表(主要记录添加，修改操作)
drop table if exists opconflog;
create table opconflog (
	id int primary key auto_increment,
	opworkerid char(200) comment "操作人员工号",
	opworker char(200) comment "操作人员名称",
	opdescription varchar(500) comment "操作说明",
	operip char(200) comment "操作人ip地址",
	device varchar(400) comment "设备详情",
	confid int comment "会议编号",
	optime datetime comment "操作时间"
);

-- 29.登录日志表
drop table if exists loginlog;
create table loginlog(
	id int primary key auto_increment,
	accoutnid int comment "账户名",
	ip char(200) comment "ip地址",
	devicename varchar(400) comment "设备详情",
	logintime datetime comment "登录时间"
);



