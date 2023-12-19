/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : xiaomishop

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2022-12-28 09:55:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auditlog
-- ----------------------------
DROP TABLE IF EXISTS `auditlog`;
CREATE TABLE `auditlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL COMMENT '员工编号',
  `state` int(255) DEFAULT NULL COMMENT '审核状态',
  `reason` varchar(255) DEFAULT NULL COMMENT '原因',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '审核时间',
  `pid` int(11) DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of auditlog
-- ----------------------------
INSERT INTO `auditlog` VALUES ('50', '1', '2', null, '2019-10-26 10:16:24', '5');
INSERT INTO `auditlog` VALUES ('51', '1', '1', 'ok\n', '2019-10-26 11:54:47', '76');
INSERT INTO `auditlog` VALUES ('52', '1', '2', 'no', '2019-10-26 11:54:58', '77');
INSERT INTO `auditlog` VALUES ('53', '1', '1', null, '2019-10-26 11:56:27', '76');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `oid` int(20) NOT NULL AUTO_INCREMENT,
  `uid` varchar(200) DEFAULT NULL,
  `pid` varchar(200) DEFAULT NULL,
  `pname` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `pimage` varchar(200) DEFAULT NULL,
  `price` varchar(200) DEFAULT NULL,
  `num` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('95', '14', '21', '小米笔记本6代', 'products/12.jpg', '8999', '2');
INSERT INTO `car` VALUES ('152', '22', '1', '小米6x', 'products/mi6x.png', '1799', '10');
INSERT INTO `car` VALUES ('153', '22', '2', '小米9', 'products/mi9.png', '2899', '10');
INSERT INTO `car` VALUES ('159', '23', '21', '小米笔记本6代', 'products/12.jpg', '8999', '5');
INSERT INTO `car` VALUES ('161', '23', '12', '小米电视f5', 'products/2.png', '4555', '9');
INSERT INTO `car` VALUES ('176', '1', '33', '小米空调', 'products/23.jpg', '1596', '2');
INSERT INTO `car` VALUES ('177', '24', '1', '小米6x', 'products/mi6x.png', '1799', '5');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` varchar(32) NOT NULL,
  `cname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '手机/电话卡');
INSERT INTO `category` VALUES ('2', '电视/盒子');
INSERT INTO `category` VALUES ('3', '笔记本/路由器');
INSERT INTO `category` VALUES ('4', '路由器/智能硬件');
INSERT INTO `category` VALUES ('5', '家电/插线板');
INSERT INTO `category` VALUES ('6', '出行/穿戴');
INSERT INTO `category` VALUES ('7', '健康/儿童');
INSERT INTO `category` VALUES ('8', '电源/配件');
INSERT INTO `category` VALUES ('9', '箱包、服饰');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `uid` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('1', '1', '1');
INSERT INTO `collect` VALUES ('2', '2', '1');
INSERT INTO `collect` VALUES ('3', '3', '1');
INSERT INTO `collect` VALUES ('4', '4', '1');
INSERT INTO `collect` VALUES ('5', '5', '1');
INSERT INTO `collect` VALUES ('18', '27', '6');
INSERT INTO `collect` VALUES ('34', '2', '6');
INSERT INTO `collect` VALUES ('41', '24', '6');
INSERT INTO `collect` VALUES ('42', '23', '6');
INSERT INTO `collect` VALUES ('43', '21', '6');
INSERT INTO `collect` VALUES ('46', '33', '14');
INSERT INTO `collect` VALUES ('48', '56', '6');
INSERT INTO `collect` VALUES ('49', '1', '6');
INSERT INTO `collect` VALUES ('50', '1', '19');
INSERT INTO `collect` VALUES ('51', '64', '19');
INSERT INTO `collect` VALUES ('52', '33', '19');
INSERT INTO `collect` VALUES ('54', '4', '6');
INSERT INTO `collect` VALUES ('57', '44', '6');
INSERT INTO `collect` VALUES ('58', '58', '6');
INSERT INTO `collect` VALUES ('59', '32', '6');
INSERT INTO `collect` VALUES ('60', '61', '6');
INSERT INTO `collect` VALUES ('61', '30', '6');
INSERT INTO `collect` VALUES ('62', '21', '22');
INSERT INTO `collect` VALUES ('63', '1', '22');
INSERT INTO `collect` VALUES ('64', '44', '1');
INSERT INTO `collect` VALUES ('66', '68', '1');
INSERT INTO `collect` VALUES ('67', '21', '1');
INSERT INTO `collect` VALUES ('68', '20', '1');
INSERT INTO `collect` VALUES ('70', '16', '24');
INSERT INTO `collect` VALUES ('72', '33', '1');
INSERT INTO `collect` VALUES ('73', '20', '25');
INSERT INTO `collect` VALUES ('74', '9', '25');
INSERT INTO `collect` VALUES ('75', '76', '25');
INSERT INTO `collect` VALUES ('76', '1', '24');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `desc` varchar(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '总经办', '4', '1');
INSERT INTO `department` VALUES ('2', '人事部', '5', '1');
INSERT INTO `department` VALUES ('3', '业务部', '', '1');
INSERT INTO `department` VALUES ('16', '技术部', '管理', '0');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `hiredate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入职时间',
  `state` int(11) DEFAULT NULL COMMENT '状态 离职-在职-',
  `deptID` int(11) DEFAULT NULL COMMENT '部门ID',
  `roleID` int(11) DEFAULT NULL COMMENT '角色ID',
  `admin` bit(1) DEFAULT b'0',
  `loginID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '花少雷', '18999998888', '2018-09-16 00:00:00', '1', '1', '1', '', '1');
INSERT INTO `employee` VALUES ('2', '李爱国', '18988889999', '2018-09-15 00:00:00', '1', '2', '2', '\0', '2');
INSERT INTO `employee` VALUES ('3', '宋美丽', '18977776666', '2018-09-16 00:00:00', '1', '3', '3', '\0', '3');
INSERT INTO `employee` VALUES ('68', '费文博', '18739777471', '2019-10-25 20:10:31', '1', '2', '2', '', '26');
INSERT INTO `employee` VALUES ('70', '·孔维晨', '17630036763', '2019-10-26 11:48:31', '1', '3', '3', '', '28');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1', '17630036763', '123456');
INSERT INTO `login` VALUES ('2', '456', '456');
INSERT INTO `login` VALUES ('3', '789', '789');
INSERT INTO `login` VALUES ('26', '123456', '123456');
INSERT INTO `login` VALUES ('28', '17630036764', '666666');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `itemid` varchar(32) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `pid` varchar(32) DEFAULT NULL,
  `oid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`itemid`) USING BTREE,
  KEY `fk_0001` (`pid`) USING BTREE,
  KEY `fk_0002` (`oid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` varchar(32) NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `uid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '0', null, '人事管理', '人事权限');
INSERT INTO `permission` VALUES ('2', '1', 'employee.html', '员工管理', '管理员工');
INSERT INTO `permission` VALUES ('5', '0', null, '商品管理', '业务管理');
INSERT INTO `permission` VALUES ('6', '5', 'message.html', '全部商品', '上架商品');
INSERT INTO `permission` VALUES ('7', '5', 'audit.html', '商品审核', '审核审批');
INSERT INTO `permission` VALUES ('10', '0', null, '经营管理', null);
INSERT INTO `permission` VALUES ('11', '10', 'collect.html', '统计收藏量', '经营状况');
INSERT INTO `permission` VALUES ('12', '5', 'auditlog.html', '审核日志', '审核日志');
INSERT INTO `permission` VALUES ('14', '1', 'addemployee.html', '添加员工', null);
INSERT INTO `permission` VALUES ('15', '10', 'purchase.html', '统计购买量', null);
INSERT INTO `permission` VALUES ('16', '5', 'addProduct.html', '添加商品', null);
INSERT INTO `permission` VALUES ('17', '0', '', '部门管理', '');
INSERT INTO `permission` VALUES ('18', '17', 'department.html', '部门信息', null);
INSERT INTO `permission` VALUES ('20', '0', null, '密码管理', null);
INSERT INTO `permission` VALUES ('21', '20', 'updatepassword.html', '修改密码', null);
INSERT INTO `permission` VALUES ('22', '10', 'order.html', '订单中心', '经营状况');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(10) NOT NULL AUTO_INCREMENT,
  `pname` varchar(100) DEFAULT NULL,
  `pimage` varchar(250) DEFAULT NULL,
  `shopPrice` int(255) DEFAULT NULL,
  `marketPrice` int(255) DEFAULT NULL,
  `isHot` int(10) DEFAULT NULL,
  `pdesc` varchar(255) DEFAULT NULL,
  `pflag` int(255) DEFAULT NULL,
  `cid` varchar(10) DEFAULT NULL,
  `collect` int(10) DEFAULT NULL,
  `state` int(255) NOT NULL,
  `quantity` int(255) DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '小米6x', 'products/mi6x.png', '1799', '1888', '0', '官方正品小米6x前置2000万/AI双摄', '0', '1', '489', '1', '192');
INSERT INTO `product` VALUES ('2', '小米9', 'products/mi9.png', '2899', '1899', '0', '官方正品  三摄像头  前后4800万像素', '0', '1', '4545', '1', '971');
INSERT INTO `product` VALUES ('3', '小米9se', 'products/mi9se.png', '2599', '1999', '0', '官方正品 价格实惠 5G网速', '0', '1', '455', '1', '1413');
INSERT INTO `product` VALUES ('4', '小米mix3', 'products/mix3.png', '3000', '2866', '0', '磁动力滑盖全面屏/四曲面陶瓷机身/晓龙845', '0', '1', '556', '1', '1970');
INSERT INTO `product` VALUES ('5', '红米7a', 'products/redmi7a.png', '1599', '1099', '0', '官方正品4000mAh/超长续航/晓龙8处理器/标配10w快充', '0', '1', '565', '1', '1619');
INSERT INTO `product` VALUES ('6', '红米7aPro', 'products/redmi7a.png', '999', '999', '0', '官方正品  三摄像头  前后4800万像素', '0', '1', '55', '1', '139');
INSERT INTO `product` VALUES ('7', '红米note7', 'products/redminot7pro.png', '1499', '1300', '0', '轻薄美观的拍照手机 / 前置2000万“治愈系”自拍 / 后置2000万', '0', '1', '456', '1', '315');
INSERT INTO `product` VALUES ('8', '红米k20', 'products/redmik20pro.png', '3600', '1500', '0', '4000mAh大电量 / 骁龙632八核处理器 / 6.26\"水滴全面屏，德国莱茵 TÜV 认证护眼屏 / 18个月超长质保，', '0', '1', '555', '1', '648');
INSERT INTO `product` VALUES ('9', '小米电视e43a', 'products/e43a.png', '7999', '6900', '0', '70英寸震撼巨屏 / 4K画质 细腻如真 / 杜比音效 身临其境', '0', '2', '131', '1', '749');
INSERT INTO `product` VALUES ('10', '小米电视xm4a', 'products/xm4a.png', '4999', '3999', '0', '时尚金属全面屏设计 / 搭载Amlogic T972超强悍处理器 / 4K超高清画质 细腻如真 / 支持8K视频解码', '0', '2', '101', '1', '617');
INSERT INTO `product` VALUES ('11', '小米电视fd', 'products/1.png', '5999', '4999', '0', '70英寸震撼巨屏 / 4K画质 细腻如真 / 杜比音效 身临其境 / PatchWall智能系统 内置小爱同学 / 海量好内容', '0', '2', '499', '1', '196');
INSERT INTO `product` VALUES ('12', '小米电视f5', 'products/2.png', '4555', '4333', '0', '时尚全面屏设计 超高屏占比 / 全高清分辨率 展示更多画面细节 / 内置小爱同学 语音操控更便捷 / 智能PatchWall系统 / 智能家居控制中心', '0', '2', '266', '1', '136');
INSERT INTO `product` VALUES ('13', '小米电视afd', 'products/3.png', '5699', '4569', '0', '4K超高清屏 / 四核64位高性能处理器，支持HDR10 / 2GB+8GB大存储 / 人工智能语音 / 支持壁挂', '0', '2', '455', '1', '168');
INSERT INTO `product` VALUES ('14', '小米电视k2', 'products/4.png', '6999', '6666', '0', '全面屏设计 / 4K超高清 HDR / 纤薄机身 / 2GB+8GB大内存 / 64位四核处理器 / 内置小爱同学', '0', '2', '455', '1', '494');
INSERT INTO `product` VALUES ('15', '小米电视5', 'products/5.png', '4555', '2999', '0', '包含小米电视4A 50英寸 *1 、小米电视音响 *1', '0', '2', '899', '1', '216');
INSERT INTO `product` VALUES ('16', '小米电视5a', 'products/6.png', '9999', '8999', '0', '本套装包含小米电视4 55英寸*1、小米电视音响*1', '0', '2', '700', '1', '198');
INSERT INTO `product` VALUES ('17', '小米电视4', 'products/7.png', '4000', '3600', '0', '本套装包含小米电视4 65英寸全面屏旗舰版 *1 、小米电视音响 *1', '0', '2', '54', '1', '984');
INSERT INTO `product` VALUES ('18', '小米壁挂电视', 'products/8.png', '2999', '1699', '0', '超高清屏 / 2GB+8GB / 真四核64位高性能处理器 / 超窄边框 / 智能语音 / 杜比解码 / 海量高清片源 / 支持壁挂', '0', '2', '351', '1', '846');
INSERT INTO `product` VALUES ('19', '小米电视45', 'products/9.jpg', '1999', '1599', '0', '4K HDR / 语音搜片 / 海量片源 / 震撼音效 / 高性能 / 大储存', '0', '2', '852', '1', '1920');
INSERT INTO `product` VALUES ('20', '小米笔记本5代', 'products/10.png', '6999', '5999', '0', '轻薄全金属机身 / MX250独立显卡 / 9.5小时超长续航 / FHD全高清屏幕 / 指纹解锁 / 兼顾办公娱乐与轻薄的高性能笔记本', '0', '3', '556', '1', '191');
INSERT INTO `product` VALUES ('21', '小米笔记本6代', 'products/12.jpg', '8999', '7999', '0', '全高清屏幕 / 长续航全金属 / 超窄边框 / 像杂志一样随身携带 / 哈曼高品质扬声器 / 升级至第八代Intel m3处理器', '0', '3', '7866', '1', '354');
INSERT INTO `product` VALUES ('22', '小米笔记本7代', 'products/13.jpg', '5999', '4699', '0', 'NVIDIA MX250 2G独显 / 第八代Intel处理器 / PCIe 高速固态硬盘 / 72%NTSC高色域全高清屏 / 更强悍的专业笔记本', '0', '3', '45', '1', '654');
INSERT INTO `product` VALUES ('23', '小米笔记本8代', 'products/14.jpg', '3969', '2999', '0', '全新第八代英特尔酷睿处理器 ／ 升级金属双风扇 ／ 带宽提升80% ／ 15.6\"全高清大屏超窄边大视野', '0', '3', '575', '1', '138');
INSERT INTO `product` VALUES ('24', '小米鼠标', 'products/15.jpg', '199', '99', '0', '有线 / 无线双模切换 / 7200DPI 光学传感器 / 6 个可编程按键 / RGB 炫彩灯光', '0', '4', '545', '1', '191');
INSERT INTO `product` VALUES ('25', '小米蓝牙鼠标', 'products/16.jpg', '199', '169', '0', '阳极氧化铝合金外壳+ABS材质 / 蓝牙或2.4G双模式 / 轻薄便携', '0', '4', '2457', '1', '941');
INSERT INTO `product` VALUES ('27', '小米红轴键盘', 'products/17.jpg', '599', '399', '0', 'CNC全铝机身，精致由内到外 ／ TTC静音红轴，享受静谧好手感 ／ 细腻触感，经久耐用', '0', '4', '45', '1', '654');
INSERT INTO `product` VALUES ('28', '小米耳机', 'products/18.jpg', '299', '99', '0', '7.1 虚拟环绕立体声引擎 ／ LED 炫彩游戏光效 ／ 40mm创新喇叭单元设计 ／ 双麦克风 ENC 环境降噪技术 ／ 双接口可拆换技术', '0', '4', '546', '1', '321');
INSERT INTO `product` VALUES ('29', '小米转接头', 'products/19.jpg', '69', '59', '0', '以一敌四 / 高效办公好搭档', '0', '4', '686', '1', '213');
INSERT INTO `product` VALUES ('30', '数据线', 'products/20.jpg', '29', '29', '0', 'PD2.0 协议 / 精致小巧 / 可为 QC3.0 设备充电 / 附赠USB-C to USB-C数据线', '0', '4', '7979', '1', '313');
INSERT INTO `product` VALUES ('31', '游戏键盘', 'products/21.jpg', '199', '99', '0', 'RGB 幻彩背光 / 铝合金上盖 / 定制游戏轴体', '0', '3', '99', '1', '645');
INSERT INTO `product` VALUES ('32', '数据线 ', 'products/22.jpg', '59', '59', '0', '4K/60Hz 超高清输出，USB-C PD3.0 智能充电，数据传输', '0', '8', '6657', '1', '324');
INSERT INTO `product` VALUES ('33', '小米空调', 'products/23.jpg', '1596', '1496', '0', '大1匹 / 快速制冷热 / 除湿功能 / 降噪静音 / 广角送风 / 高密度过滤网 / 典雅外观 / 售后无忧 / 官网购买，免预约安装，签收后服务人员主动联系', '0', '5', '7577', '1', '656');
INSERT INTO `product` VALUES ('34', '小米5代空调', 'products/24.jpg', '1599', '1699', '0', '国标最高A+级洗净能力 / 21种洗烘模式 / 智能空气洗 / 烘干除菌率达99.9%+ / 高温筒自洁 / 一级能效，省水省电', '0', '5', '5441', '1', '456');
INSERT INTO `product` VALUES ('35', '小米门锁', 'products/25.jpg', '699', '599', '0', '含上门安装服务费 / 400加仑大流量 / RO反渗透直出纯净水 / 隐藏安装 / 健康家庭必备 / RO膜寿命因地区、水质、季节及用量有所差异', '0', '5', '753', '1', '546');
INSERT INTO `product` VALUES ('36', '小米橱柜一代', 'products/26.jpg', '1099', '899', '0', 'RO反渗透技术 / 深层净水 / 400加仑大流量 / 满足家庭日常使用 / 3合1复合强化滤芯 / RO膜寿命因地区、水质、季节及用量有所差异', '0', '5', '552', '1', '1210');
INSERT INTO `product` VALUES ('37', '二代橱柜', 'products/27.jpg', '1999', '1699', '0', '1.5 匹 / 变频 / 高效制冷热 / 强大静音能力 / 售后无忧 / 官网购买，免预约安装，签收后服务人员主动联系', '0', '5', '454', '1', '645');
INSERT INTO `product` VALUES ('38', '家庭打印机', 'products/28.jpg', '589', '499', '0', '6寸高清照片 / 细腻还原真实色彩 / 自动覆膜长久保存 / 多尺寸证件照打印 / 多种无线快连 / 可远程打印', '0', '5', '555', '1', '1320');
INSERT INTO `product` VALUES ('39', '相片打印机', 'products/29.jpg', '699', '699', '0', '1080P高清画质 ／ 360度云台全景视角 ／ 红外夜视 ／ 双向语音 / AI 增强移动侦测 / H.265 编码 / 倒置安装', '0', '5', '6409', '1', '354');
INSERT INTO `product` VALUES ('40', '小米门锁', 'products/30.jpg', '299', '259', '0', '直插式C级智能锁芯 / 6大开锁方式 / 超16项安全黑科技 / 7大安全监测 / 抵御小黑盒攻击 / 丰富的智能联动', '0', '5', '899', '1', '651');
INSERT INTO `product` VALUES ('41', '小米音响', 'products/31.jpg', '1966', '1699', '0', '「荣获2019红点设计奖」1080P 分辨率 / 均值 500 ANSI 流明 / 一体式大音腔全密封光学系统', '0', '5', '13', '1', '332');
INSERT INTO `product` VALUES ('42', '小米车', 'products/32.jpg', '1999', '1999', '0', '极简几何设计，1分钟轻松上手 / 30公里超长续航 / 双重刹车系统 / 便携折叠', '0', '6', '55', '1', '113');
INSERT INTO `product` VALUES ('43', '小米代步车1', 'products/33.jpg', '2599', '1699', '0', '多功能控制面板 / 45 公里续航 / 6倍步行速度', '0', '6', '66', '1', '335');
INSERT INTO `product` VALUES ('44', '小米密码锁', 'products/34.jpg', '59', '49', '0', '数字胎压检测 / 预设压力充到即停 / 内置锂电池 / 一机多用', '0', '6', '7483', '1', '673');
INSERT INTO `product` VALUES ('45', '小米手环', 'products/35.jpg', '599', '599', '0', '支持公交地铁刷卡 / 微信、QQ、来电等内容显示 / 多种运动数据实时可见 / 睡眠、计步自动检测 / 50 米游泳防水 / 24 个汉字一屏显示', '0', '6', '54', '1', '339');
INSERT INTO `product` VALUES ('46', '小米手环', 'products/36.jpg', '699', '699', '0', '微信、QQ来电等消息内容直接显示 / 50米游泳防水 / 运动数据抬腕可见 / 心率、睡眠、记步，健康管理 / 长达20天续航能力', '0', '6', '594', '1', '331');
INSERT INTO `product` VALUES ('47', '小米玩具', 'products/37.jpg', '1999', '1899', '0', '年轻人的酷玩具 / 骑行遥控两种玩法 / 22公里超长续航 / 轻、小、便携 / 重心驱动 / 15重安全保障', '0', '6', '92', '1', '116');
INSERT INTO `product` VALUES ('48', '小米路由器一代', 'products/38.jpg', '588', '499', '0', '双核CPU千兆网口 ／ 双频AC1200 ／ 高增益4天线 ／ 128MB大内存 ／ 安全防蹭网 ／ 儿童安全上网 ／ 专为小米智能家居优化', '0', '4', '100', '1', '168');
INSERT INTO `product` VALUES ('49', '小米路由器二代', 'products/39.jpg', '999', '899', '0', '覆盖广，信号强 ／ 智能设备，轻松入网 ／ 802.11n+ac双频并发 ／ 超大Flash，支持丰富功能 ／ 双核处理器，更快更稳定', '0', '4', '900', '1', '138');
INSERT INTO `product` VALUES ('50', '小米扫地机', 'products/40.jpg', '1699', '1499', '0', '高精度激光测距，智能规划路径 / 1800Pa 大风压澎湃吸力 / 远程智能控制 ，定时清扫 / 大电池持久清扫', '0', '5', '100', '1', '346');
INSERT INTO `product` VALUES ('51', '小米行李箱', 'products/41.jpg', '349', '299', '0', '坚固小巧 / 创新收纳分区 / 顺滑静音万向轮 / 赠 DIY 贴纸', '0', '7', '498', '1', '365');
INSERT INTO `product` VALUES ('52', '小米儿童吹风机', 'products/42.jpg', '299', '199', '0', '大风量 / 水离子护发 / NTC 智能温控 / 冷热风循环 / 磁吸式造型风嘴 / 360度自由旋转', '0', '7', '255', '1', '161');
INSERT INTO `product` VALUES ('53', '小米电动牙刷', 'products/43.jpg', '119', '99', '0', '磁悬浮声波马达 / 双效双刷头 / IPX7防水 / 感应式充电 / 专利刷毛布局 / 两档模式', '0', '7', '78', '1', '325');
INSERT INTO `product` VALUES ('54', '小米玩具', 'products/44.jpg', '189', '179', '0', '海量优质内容，讲故事更专业 / 微信远程互动 / 智能语音交互 / 材质安全耐用', '0', '7', '54', '1', '681');
INSERT INTO `product` VALUES ('55', '小米儿童理发机', 'products/45.jpg', '99', '89', '0', '陶瓷刀头 / 低音电机 / 5 种理发长度可选 / 支持全身水洗', '0', '8', '78', '1', '1135');
INSERT INTO `product` VALUES ('56', '小米充电宝', 'products/46.jpg', '199', '99', '0', '大容量 / 双USB输出 / 高品质锂聚合物电池 / 双向快充', '0', '8', '455', '1', '1167');
INSERT INTO `product` VALUES ('57', '小米哈哈', 'products/47.jpg', '99', '99', '0', '快速无线闪充 / 独立静音风扇 / Qi充电标准', '0', '8', '444', '1', '1356');
INSERT INTO `product` VALUES ('58', '充电宝', 'products/48.jpg', '299', '299', '0', 'USB-C 45W 双向快充 / 三口输出 / 大容量 / 支持笔记本电脑充电 / 高品质锂聚合物电芯', '0', '8', '786', '1', '453');
INSERT INTO `product` VALUES ('59', '白充电宝', 'products/49.jpg', '109', '99', '0', '大容量 / 双USB输出 / 高品质锂聚合物电池 / 双向快充', '0', '8', '455', '1', '654');
INSERT INTO `product` VALUES ('60', '配件', 'products/50.jpg', '199', '99', '0', '标准USB接口，可随意搭配数码设备 / 轻巧便携可拆卸，能放在口袋的小风扇', '0', '8', '454', '1', '372');
INSERT INTO `product` VALUES ('61', '收纳箱', 'products/51.jpg', '199', '189', '0', '防尘、绝缘 / 顶部开盖设计，操作方便 / 合理人性的排线口设计 / 良好的散热 / 高品质阻燃ABS材料，使用放心 / 外观简洁家居百搭 / 插线板专用', '0', '8', '576', '1', '444');
INSERT INTO `product` VALUES ('62', '小米枕头', 'products/52.jpg', '99', '89', '0', '泰国天然乳胶 / 立体大颗粒造型 / 杜邦环保枕套 / 升级版礼品包装', '0', '9', '86', '1', '460');
INSERT INTO `product` VALUES ('63', '小米钱包', 'products/53.jpg', '99', '89', '0', '进口头层牛皮 / 精致油边工艺', '0', '9', '755', '1', '456');
INSERT INTO `product` VALUES ('64', '小米单肩包', 'products/54.jpg', '199', '89', '0', '主袋内隔层丰富，分类收纳利用率高 / 后幅棉质内衬隔层，可放入7寸平板电脑', '0', '9', '4575', '1', '354');
INSERT INTO `product` VALUES ('65', '小米行李箱', 'products/55.jpg', '189', '189', '0', '箱体100%铝镁合金 / 坚固轻盈 / 万向静音轮 / 灵活收纳', '0', '9', '76', '1', '354');
INSERT INTO `product` VALUES ('66', '小米高级行李箱', 'products/56.jpg', '599', '599', '0', '旅行箱 青春款 20英寸 蓝色 20寸+手环3 NFC版', '0', '9', '8', '1', '1670');
INSERT INTO `product` VALUES ('76', 'xiu2', '/image/e65f53dc-04d4-4095-8358-62ea44b3c983.png', '444', '555', '0', '测试测试', '0', '2', '1', '1', '10');
INSERT INTO `product` VALUES ('77', 'test2', '/image/a3a65c70-2219-455f-9a32-57fd559d61ee.jpg', '555', '666', '0', 'test2', '0', '1', '0', '2', '0');

-- ----------------------------
-- Table structure for p_color
-- ----------------------------
DROP TABLE IF EXISTS `p_color`;
CREATE TABLE `p_color` (
  `colorID` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`colorID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of p_color
-- ----------------------------
INSERT INTO `p_color` VALUES ('1', '1', '亮白色');
INSERT INTO `p_color` VALUES ('2', '1', '亮黑色');
INSERT INTO `p_color` VALUES ('3', '1', '亮金色');
INSERT INTO `p_color` VALUES ('4', '2', '亮白色');
INSERT INTO `p_color` VALUES ('5', '2', '炫红色');
INSERT INTO `p_color` VALUES ('6', '3', '深蓝色');
INSERT INTO `p_color` VALUES ('7', '3', '炫红色');
INSERT INTO `p_color` VALUES ('8', '4', '深蓝色');
INSERT INTO `p_color` VALUES ('9', '4', '亮黑色');
INSERT INTO `p_color` VALUES ('10', '5', '亮黑色');
INSERT INTO `p_color` VALUES ('11', '5', '深蓝色');
INSERT INTO `p_color` VALUES ('12', '6', '炫红色');
INSERT INTO `p_color` VALUES ('13', '6', '亮白色');
INSERT INTO `p_color` VALUES ('14', '7', '亮白色');
INSERT INTO `p_color` VALUES ('15', '7', '亮金色');
INSERT INTO `p_color` VALUES ('16', '8', '炫红色');
INSERT INTO `p_color` VALUES ('17', '8', '亮金色');
INSERT INTO `p_color` VALUES ('18', '9', '黑色');
INSERT INTO `p_color` VALUES ('19', '10', '白色');
INSERT INTO `p_color` VALUES ('20', '11', '白色');
INSERT INTO `p_color` VALUES ('21', '12', '白色');
INSERT INTO `p_color` VALUES ('22', '13', '黑色');
INSERT INTO `p_color` VALUES ('23', '14', '白色');
INSERT INTO `p_color` VALUES ('24', '15', '黑色');
INSERT INTO `p_color` VALUES ('25', '16', '白色');
INSERT INTO `p_color` VALUES ('26', '17', '黑色');
INSERT INTO `p_color` VALUES ('27', '18', '红色');
INSERT INTO `p_color` VALUES ('28', '19', '黑色');
INSERT INTO `p_color` VALUES ('29', '20', '黑色');
INSERT INTO `p_color` VALUES ('30', '21', '黑色');
INSERT INTO `p_color` VALUES ('31', '22', '黑色');
INSERT INTO `p_color` VALUES ('32', '22', '白色');

-- ----------------------------
-- Table structure for p_configure
-- ----------------------------
DROP TABLE IF EXISTS `p_configure`;
CREATE TABLE `p_configure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `configure` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of p_configure
-- ----------------------------
INSERT INTO `p_configure` VALUES ('1', '1', '6G+64G');
INSERT INTO `p_configure` VALUES ('2', '1', '6G+128G');
INSERT INTO `p_configure` VALUES ('3', '1', '8G+128G');
INSERT INTO `p_configure` VALUES ('4', '2', '6G+64G');
INSERT INTO `p_configure` VALUES ('5', '2', '8G+128G');
INSERT INTO `p_configure` VALUES ('6', '3', '6G+64G');
INSERT INTO `p_configure` VALUES ('7', '3', '6G+128G');
INSERT INTO `p_configure` VALUES ('8', '3', '8G+128G');
INSERT INTO `p_configure` VALUES ('9', '4', '6G+64G');
INSERT INTO `p_configure` VALUES ('10', '4', '8G+128G');
INSERT INTO `p_configure` VALUES ('11', '5', '6G+64G');
INSERT INTO `p_configure` VALUES ('12', '5', '8G+128G');
INSERT INTO `p_configure` VALUES ('13', '6', '6G+64G');
INSERT INTO `p_configure` VALUES ('14', '6', '6G+128G');
INSERT INTO `p_configure` VALUES ('15', '7', '6G+128G');
INSERT INTO `p_configure` VALUES ('16', '7', '8G+128G');
INSERT INTO `p_configure` VALUES ('17', '8', '8G+64G');
INSERT INTO `p_configure` VALUES ('18', '8', '8G+128G');
INSERT INTO `p_configure` VALUES ('19', '9', '小米壁画电视 65英寸');
INSERT INTO `p_configure` VALUES ('20', '9', '小米壁画电视 60英寸');
INSERT INTO `p_configure` VALUES ('21', '10', '70英寸震撼巨屏 / 4K');
INSERT INTO `p_configure` VALUES ('22', '10', '65英寸震撼巨屏 / 4K');
INSERT INTO `p_configure` VALUES ('23', '11', '70英寸震撼巨屏 / 4K');
INSERT INTO `p_configure` VALUES ('24', '11', '65英寸震撼巨屏 / 4K');
INSERT INTO `p_configure` VALUES ('25', '12', '70英寸震撼巨屏 / 4K');
INSERT INTO `p_configure` VALUES ('26', '12', '65英寸震撼巨屏 / 4K');
INSERT INTO `p_configure` VALUES ('27', '13', '70英寸震撼巨屏 / 4K');
INSERT INTO `p_configure` VALUES ('28', '13', '65英寸震撼巨屏 / 4K');
INSERT INTO `p_configure` VALUES ('29', '14', '全面屏电视E65A');
INSERT INTO `p_configure` VALUES ('30', '14', '70英寸全面屏电视E65A');
INSERT INTO `p_configure` VALUES ('31', '15', '50英寸影院版');
INSERT INTO `p_configure` VALUES ('32', '16', '55英寸影院版');
INSERT INTO `p_configure` VALUES ('33', '16', '60英寸影院版');
INSERT INTO `p_configure` VALUES ('34', '17', '小米电视4 65英寸影院版');
INSERT INTO `p_configure` VALUES ('35', '17', '小米电视4 70英寸影院版');
INSERT INTO `p_configure` VALUES ('36', '18', '小米电视4A 55英寸');
INSERT INTO `p_configure` VALUES ('37', '18', '小米电视4A 60英寸');
INSERT INTO `p_configure` VALUES ('38', '20', null);
INSERT INTO `p_configure` VALUES ('39', '19', '55英寸');
INSERT INTO `p_configure` VALUES ('40', '19', '小米电视 65英寸');
INSERT INTO `p_configure` VALUES ('41', '20', 'i5 8G 256G PCIe');
INSERT INTO `p_configure` VALUES ('42', '20', 'i7 8G 512G PCIe');
INSERT INTO `p_configure` VALUES ('43', '21', 'i5 8G 256G PCIe');
INSERT INTO `p_configure` VALUES ('44', '21', 'i7 8G 256G PCIe');
INSERT INTO `p_configure` VALUES ('45', '22', 'i5 8G 256G PCIe');
INSERT INTO `p_configure` VALUES ('46', '22', 'i7 8G 256G PCIe');
INSERT INTO `p_configure` VALUES ('47', '22', 'i7 8G 256G PCIe');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `desc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '系统所有的操作都行');
INSERT INTO `role` VALUES ('2', '人事管理', '管理公司员工');
INSERT INTO `role` VALUES ('3', '业务管理员', '公司业务操作');

-- ----------------------------
-- Table structure for role_per
-- ----------------------------
DROP TABLE IF EXISTS `role_per`;
CREATE TABLE `role_per` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role_per
-- ----------------------------
INSERT INTO `role_per` VALUES ('1', '1', '2');
INSERT INTO `role_per` VALUES ('2', '1', '6');
INSERT INTO `role_per` VALUES ('3', '1', '7');
INSERT INTO `role_per` VALUES ('4', '1', '11');
INSERT INTO `role_per` VALUES ('5', '1', '12');
INSERT INTO `role_per` VALUES ('6', '1', '14');
INSERT INTO `role_per` VALUES ('7', '1', '15');
INSERT INTO `role_per` VALUES ('8', '2', '2');
INSERT INTO `role_per` VALUES ('15', '2', '14');
INSERT INTO `role_per` VALUES ('20', '3', '6');
INSERT INTO `role_per` VALUES ('21', '3', '12');
INSERT INTO `role_per` VALUES ('22', '3', '15');
INSERT INTO `role_per` VALUES ('23', '3', '11');
INSERT INTO `role_per` VALUES ('24', '3', '16');
INSERT INTO `role_per` VALUES ('25', '1', '16');
INSERT INTO `role_per` VALUES ('26', '1', '18');
INSERT INTO `role_per` VALUES ('27', '1', '19');
INSERT INTO `role_per` VALUES ('28', '1', '21');
INSERT INTO `role_per` VALUES ('29', '2', '21');
INSERT INTO `role_per` VALUES ('30', '3', '21');
INSERT INTO `role_per` VALUES ('31', '1', '22');
INSERT INTO `role_per` VALUES ('32', '3', '22');

-- ----------------------------
-- Table structure for tordernumber
-- ----------------------------
DROP TABLE IF EXISTS `tordernumber`;
CREATE TABLE `tordernumber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `tradeNum` int(11) NOT NULL,
  `province` varchar(40) NOT NULL,
  `city` varchar(40) NOT NULL,
  `county` varchar(40) NOT NULL,
  `site` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `consigneeName` varchar(20) NOT NULL,
  `addTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `serial` int(11) DEFAULT NULL COMMENT '订单编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tordernumber
-- ----------------------------
INSERT INTO `tordernumber` VALUES ('12', '6', '60', '6', '天津市', '天津市市辖区', '河东区', '人民路', '15661948861', '孔维晨', '2019-10-26 09:28:57', '13156');
INSERT INTO `tordernumber` VALUES ('13', '6', '30', '1', '山西省', '朔州市', '山阴县', '人民路', '15661948864', '花少雷', '2019-10-26 09:29:00', '86880');
INSERT INTO `tordernumber` VALUES ('14', '6', '56', '1', '山西省', '朔州市', '山阴县', '人民路', '15661948865', '费文博', '2019-10-26 09:29:01', '86880');
INSERT INTO `tordernumber` VALUES ('15', '6', '3', '10', '天津市', '天津市市辖区', '津南区', '人民路', '15661948866', '马超', '2019-10-26 09:29:03', '29290');
INSERT INTO `tordernumber` VALUES ('16', '6', '3', '6', '天津市', '天津市市辖区', '河东区', '人民路', '15661948867', '韩信', '2019-10-26 09:29:04', '45478');
INSERT INTO `tordernumber` VALUES ('17', '6', '5', '9', '天津市', '天津市市辖区', '河东区', '人民路', '15661948869', '李白 ', '2019-10-26 09:28:54', '45478');
INSERT INTO `tordernumber` VALUES ('18', '6', '6', '1', '河北省', '邢台市', '巨鹿县', '人民路', '15661948865', '赵云', '2019-10-26 09:29:16', '36462');
INSERT INTO `tordernumber` VALUES ('19', '6', '1', '9', '吉林省', '通化市', '通化县', '人民路', '15661948868', '黄忠', '2019-10-26 09:28:51', '46790');
INSERT INTO `tordernumber` VALUES ('22', '24', '2', '4', '北京市', '北京市市辖区', '西城区', '杨晶路', '17630036763', '孔维晨', '2019-10-26 09:27:45', '17480');
INSERT INTO `tordernumber` VALUES ('23', '24', '1', '1', '北京市', '北京市市辖区', '西城区', '中州大道', '17630036763', '孔维晨', '2019-10-26 09:28:12', '17480');
INSERT INTO `tordernumber` VALUES ('24', '24', '44', '1', '河北省', '唐山市', '路北区', '中州大道', '17630036763', '撒旦法', '2019-10-26 09:28:15', '16936');
INSERT INTO `tordernumber` VALUES ('25', '24', '2', '1', '天津市', '天津市郊县', '', '中州大道', '17630036763', '曹操', '2019-10-26 09:28:19', '46737');
INSERT INTO `tordernumber` VALUES ('26', '24', '44', '6', '天津市', '天津市市辖区', '河东区', '中州大道', '15478986548', '刘备', '2019-10-26 09:28:23', '42347');
INSERT INTO `tordernumber` VALUES ('27', '24', '67', '10', '湖南省', '长沙市', '芙蓉区', '中州大道', '17630036763', '张三', '2019-10-26 09:28:26', '53029');
INSERT INTO `tordernumber` VALUES ('28', '1', '4', '9', '内蒙古自治区', '鄂尔多斯市', '鄂托克前旗', '中州大道', '18739777471', '费', '2019-10-26 09:28:30', '47043');
INSERT INTO `tordernumber` VALUES ('29', '1', '3', '11', '内蒙古自治区', '鄂尔多斯市', '鄂托克前旗', '中州大道', '18739777471', '费', '2019-10-26 09:28:34', '47043');
INSERT INTO `tordernumber` VALUES ('30', '1', '21', '3', '内蒙古自治区', '鄂尔多斯市', '鄂托克前旗', '中州大道', '18739777471', '费', '2019-10-26 09:28:37', '47043');
INSERT INTO `tordernumber` VALUES ('31', '1', '2', '1', '内蒙古自治区', '鄂尔多斯市', '鄂托克前旗', '中州大道', '18739777471', '费', '2019-10-26 09:28:39', '47043');
INSERT INTO `tordernumber` VALUES ('32', '1', '3', '1', '山东省', '潍坊市', '诸城市', '中州大道', '18739777471', '费', '2019-10-26 09:28:44', '88794');
INSERT INTO `tordernumber` VALUES ('33', '25', '10', '7', '内蒙古自治区', '乌海市', '海南区', '33号', '17630036763', '孔维晨', '2019-10-26 12:01:47', '68938');
INSERT INTO `tordernumber` VALUES ('34', '25', '76', '10', '江西省', '南昌市', '东湖区', '22号', '17630036763', '孔维晨', '2019-10-26 12:04:03', '35457');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(100) NOT NULL AUTO_INCREMENT,
  `telephone` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123', '123@qq.com', '水果放到');
INSERT INTO `user` VALUES ('23', '13522121066', '123456', '123456789@qq.com', '寇亚飞');
INSERT INTO `user` VALUES ('24', '456', '456', '113666698@qq.com', '李珊珊');
INSERT INTO `user` VALUES ('25', '17630036763', '666666', '1132260@qq.com', '孔维晨');
INSERT INTO `user` VALUES ('26', '16621053826', '228116', '18736923707@163.com', 'mj');
