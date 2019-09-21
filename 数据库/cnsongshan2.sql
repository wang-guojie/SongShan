/*
Navicat MySQL Data Transfer

Source Server         : GoodBoy
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : cnsongshan2

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-09-17 16:10:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `adminpwd` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123');
INSERT INTO `admin` VALUES ('2', '679912', '123');

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel` (
  `indexId` int(11) NOT NULL AUTO_INCREMENT,
  `indexTitle` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `imagesrc` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `indexurl` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `indexdesc` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `typeid` int(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`indexId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of carousel
-- ----------------------------
INSERT INTO `carousel` VALUES ('1', '在线预订服务', '/upload/20190824_093318.jpg', 'goods.jsp', '购票成功后，少林景区凭身份证或手机到售票窗口换票入园；嵩阳和中岳景区直接凭身份证入园。', '1');
INSERT INTO `carousel` VALUES ('2', '全景虚拟旅游', '../upload/2-1499494921618.jpg', 'http://brgoooo.oicp.io/SongShanWeb/WebGoodsServlet?op=desc&typeid=1&id=11', '在线游览嵩山大美胜景。戴上VR眼镜观看，感受壮丽嵩山景色带来的心灵震撼！', '1');
INSERT INTO `carousel` VALUES ('3', '嵩山旅游攻略', '/upload/20190824_093335.jpg', '..', '获知旅游攻略，提前做好交通规划，以获得最佳的旅游体验。', '1');
INSERT INTO `carousel` VALUES ('5', '嵩山景区', '../upload/2-1498753973832.jpg', '..', '嵩山，东西起伏，鲜有奇峰，好像巨龙横卧，犹如天然屏障，雄浑高大，气势巍峨，故有“华山如立，中岳如卧”之说。', '2');
INSERT INTO `carousel` VALUES ('6', '文化嵩山', '../upload/2-1498752364137.jpg', '..', '中岳嵩山相继产生了嵩阳书院、大法王寺和少林寺、中岳庙，从而使嵩山成为儒释道三教共处的圣地之一。', '2');
INSERT INTO `carousel` VALUES ('7', '世界遗产', '../upload/2-1498752282576.jpg', 'http://brgoooo.oicp.io/SongShanWeb/WebGoodsMServlet?op=desc', '嵩山群山耸立，层峦叠嶂，风光秀丽，景色宜人。列入“申报世界文化遗产”的嵩山历史建筑群有八处十一项。', '2');
INSERT INTO `carousel` VALUES ('8', 'NB', 'NB', 'http://brgoooo.oicp.io/SongShanWeb/WebGoodsServlet?op=desc&typeid=1&id=11', 'NB', '2');
INSERT INTO `carousel` VALUES ('9', 'hehe', '/upload/2-1504099430804.jpg', 'http://brgoooo.oicp.io/SongShanWeb/WebGoodsServlet?op=desc&typeid=1&id=11', '123', '2');
INSERT INTO `carousel` VALUES ('10', '123', '/upload/2-1504099430804.jpg', 'http://brgoooo.oicp.io/SongShanWeb/WebGoodsServlet?op=desc', '123', '2');

-- ----------------------------
-- Table structure for culture
-- ----------------------------
DROP TABLE IF EXISTS `culture`;
CREATE TABLE `culture` (
  `cultureid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主名ID',
  `culturename` varchar(50) COLLATE utf8_turkish_ci DEFAULT '' COMMENT '主名称',
  `cultureexplanation` varchar(200) COLLATE utf8_turkish_ci DEFAULT '' COMMENT '说明',
  `culImage` varchar(20000) COLLATE utf8_turkish_ci DEFAULT '' COMMENT '文化嵩山图片',
  PRIMARY KEY (`cultureid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of culture
-- ----------------------------
INSERT INTO `culture` VALUES ('1', '1', '3', '2');
INSERT INTO `culture` VALUES ('4', '23', '33', '333');
INSERT INTO `culture` VALUES ('5', 'sda', 'sdasd ', '');
INSERT INTO `culture` VALUES ('6', '测试123', '测试123', '');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeId` int(11) NOT NULL,
  `goodName` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `goodDesc` varchar(500) COLLATE utf8_turkish_ci NOT NULL,
  `inventory` int(11) NOT NULL,
  `imgSrc` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `money` int(11) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('2', '3', '格林大酒店', '格林大酒店总统套房\n							\n							\n							\n							\n							\n							', '83', '../upload/2-1498753973832.jpg', '980', '1');
INSERT INTO `goods` VALUES ('3', '3', '素斋四人套餐', '素斋四人套餐\n							\n							\n							', '5', '/upload/20190823_100300.jpg', '368', '1');
INSERT INTO `goods` VALUES ('4', '1', '嵩山景区', '嵩山\n							\n							', '74', '/upload/20190827_100557.jpg', '68', '1');
INSERT INTO `goods` VALUES ('5', '4', '功夫和尚礼盒装', '单个规格：宽3cm*高5cm\n							', '100', '/upload/20190827_095339.jpg', '98', '1');
INSERT INTO `goods` VALUES ('6', '2', '格林大酒店', '大床房', '6', '/upload/20190827_100302.jpg', '468', '1');
INSERT INTO `goods` VALUES ('7', '4', '嵩山纪念品', '好玩的\n							\n							\n							', '100', '/upload/20190912_094225.jpg', '11', '2');
INSERT INTO `goods` VALUES ('8', '3', '俗家子弟套餐', '好吃不贵', '10', '/upload/20190916_031013.jpg', '188', '2');
INSERT INTO `goods` VALUES ('9', '3', '俗家子弟套餐', '好吃不贵', '10', '/upload/20190916_031015.jpg', '188', '2');
INSERT INTO `goods` VALUES ('10', '3', '俗家子弟套餐', '好吃不贵', '10', '/upload/20190916_031016.jpg', '188', '1');
INSERT INTO `goods` VALUES ('11', '1', '尼姑村', '都是尼姑', '10', '/upload/20190916_031059.jpg', '68', '1');
INSERT INTO `goods` VALUES ('12', '2', '五星级酒店', '富贵', '10', '/upload/20190916_031330.jpg', '999', '1');
INSERT INTO `goods` VALUES ('13', '1', 'xb', '1', '1', '../upload/2-1504099430804.jpg', '1', '2');
INSERT INTO `goods` VALUES ('14', '1', 'cc', '123', '1', '../upload/2-1504099430804.jpg', '1', '2');
INSERT INTO `goods` VALUES ('15', '1', '123321', '123\n							', '123', '../upload/2-1504099430804.jpg', '123', '2');
INSERT INTO `goods` VALUES ('16', '1', '123321', '12', '12', '../upload/2-1504099430804.jpg', '12', '2');
INSERT INTO `goods` VALUES ('17', '1', '321123', '123213', '12', '../upload/2-1504099430804.jpg', '12', '2');
INSERT INTO `goods` VALUES ('18', '1', '123', '12', '12', '../upload/2-1504099430804.jpg', '12', '2');
INSERT INTO `goods` VALUES ('19', '1', '123', '12\n							\n							\n							\n							\n							\n							\n							\n							\n							\n							', '12', '../upload/2-1504099430804.jpg', '12', '2');
INSERT INTO `goods` VALUES ('20', '1', '321', '12321321', '12', '../upload/2-1504099430804.jpg', '12', '2');
INSERT INTO `goods` VALUES ('21', '1', '1233213123', '123123213\n							', '123', '../upload/2-1504099430804.jpg', '123', '2');
INSERT INTO `goods` VALUES ('22', '1', '123321', '12', '12', '../upload/2-1504099430804.jpg', '12', '2');
INSERT INTO `goods` VALUES ('23', '1', '尼姑村12', '12\n							', '10', '../upload/2-1504099430804.jpg', '68', '1');

-- ----------------------------
-- Table structure for goodsm
-- ----------------------------
DROP TABLE IF EXISTS `goodsm`;
CREATE TABLE `goodsm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsId` varchar(50) COLLATE utf8_turkish_ci DEFAULT NULL,
  `goodName` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
  `goodDesc` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `imgSrc` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of goodsm
-- ----------------------------
INSERT INTO `goodsm` VALUES ('1', '6,5,4', '无敌套票', '格林大酒店 x1\n功夫和尚礼盒装 x1\n嵩山景区 x1\n', '60', '/upload/20190911_045221.jpg', '1002', '1');
INSERT INTO `goodsm` VALUES ('2', '2,3,4,5,7', '帝王套票', '格林大酒店 x1\n素斋四人套餐 x1\n嵩山景区 x1\n功夫和尚礼盒装 x1\n嵩山纪念品 x1\n', '12', '/upload/20190912_094255.jpg', '1525', '1');
INSERT INTO `goodsm` VALUES ('3', '5,4,3', '无敌套票2', '素斋四人套餐 x1\n嵩山景区 x1\n功夫和尚礼盒装 x1\n', '6', '/upload/20190911_045221.jpg', '534', '2');
INSERT INTO `goodsm` VALUES ('4', '7,6,5,4', '儒雅随和', '嵩山纪念品 x1\n格林大酒店 x1\n功夫和尚礼盒装 x1\n嵩山景区 x1\n', '9', '/upload/20190916_093040.jpg', '645', '1');
INSERT INTO `goodsm` VALUES ('5', '12,6,3', '牛13套票', '五星级酒店 x1\n格林大酒店 x1\n素斋四人套餐 x1\n', '11', '../upload/2-1504099430804.jpg', '1835', '1');

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型ID ',
  `typename` varchar(50) COLLATE utf8_turkish_ci NOT NULL COMMENT '类型名称',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES ('1', '门票');
INSERT INTO `goodstype` VALUES ('2', '酒店');
INSERT INTO `goodstype` VALUES ('3', '美食');
INSERT INTO `goodstype` VALUES ('4', '商品');

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `informationid` int(11) NOT NULL AUTO_INCREMENT COMMENT '资讯ID',
  `informationname` varchar(50) COLLATE utf8_turkish_ci DEFAULT NULL COMMENT '资讯名称',
  `informationcontent` text COLLATE utf8_turkish_ci COMMENT '资讯内容',
  `informationtime` date DEFAULT NULL COMMENT '资讯日期',
  `typeid` int(100) DEFAULT NULL COMMENT '景区类型',
  PRIMARY KEY (`informationid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES ('4', '2019嵩山少林武术大会徒步星空露营节即将开幕', '<p style=\"text-align: center;\">人非生而不同</p><p style=\"text-align: center;\">一样的起点，一样的终点</p><p style=\"text-align: center;\">却有着不一样的旅途</p><p style=\"text-align: center;\">回头看看你驻足停靠的地方</p><p style=\"text-align: center;\">是不是有着别样的精彩</p><p style=\"text-align: center;\">谁，都有一份关于露营天地的浪漫憧憬!</p><p style=\"text-align: center;\">欢声笑语，</p><p style=\"text-align: center;\">一起陶醉户外，</p><p style=\"text-align: center;\">享受惬意时光!</p><p style=\"text-align: center;\">如果，这个地方在嵩山，在少林寺，</p><p style=\"text-align: center;\">除了绚丽的星空美景，</p><p style=\"text-align: center;\">你还可以感受中国武术的博大精深，</p><p style=\"text-align: center;\">嵩山美景的壮观绮丽!</p><p style=\"text-align: center;\"><img src=\"/upload/20190917_031909.jpg\" alt=\"ok.png\"><br></p><p style=\"text-align: center;\">嵩山景区，拥有古代五岳之一、世界文化遗产之一、世界地质公园之一、国家5A级景区之一、中国功夫发源地之一等声誉。下辖有少林景区、嵩阳景区和中岳景区。有中国现存最古老的礼制建筑—汉三阙、佛教禅宗祖庭—少林寺、道教策源地—第六小洞天中岳庙、中国古代四大书院之一—嵩阳</p><p style=\"text-align: center;\"><img src=\"/upload/20190917_031950.jpg\" alt=\"ok.png\"><br></p><p style=\"text-align: center;\"><img src=\"/upload/20190917_032004.jpg\" alt=\"ok.png\"><br></p><p style=\"text-align: center;\">书院、中国现存最早的砖塔—嵩岳寺塔、中国现存最古老、最完好的天文建筑—观星台等。</p><p style=\"text-align: center;\">嵩山少林景区结合文旅融合思路，让游客们可以继续体验嵩山夜景的独特美景，感叹少林武术文化的神奇和博大精深，特别推出2019嵩山少林武术大会徒步星空露营节。在这里，你可以在帐篷里体验嵩山夜景的独特美景，也可以享受徒步、登山运动带来的快乐，还可以感叹少林武术文化的神奇和博大。</p><p style=\"text-align: center;\"></p>', '2015-05-05', '3');
INSERT INTO `information` VALUES ('5', '“天地之中，老家河南” 嵩山少林景区参加第二届中原文化旅游产业博览会', '<p>9月13日-15日，由河南省文化和旅游厅、洛阳市人民政府主办的第二届中原文化旅游产业博览会在洛阳会展中心隆重举行。</p><p style=\"text-align: left;\">本次博览会以“文旅河南出彩中原”为主题，致力搭建中原文化旅游产品展示、研发、交流、交易的平台，实现由旅游产品会向旅游产业展会转变。博览会现场设置了出彩中原、隋唐大运河、博物馆之都等展区，吸引来自马来西亚、泰国、德国等37个国家和地区，及省内外1000多家文化旅游企业参展。</p><p style=\"text-align: left;\"><br></p><p style=\"text-align: left;\"><br></p><p style=\"text-align: center;\"><img src=\"/upload/20190917_031313.jpg\" alt=\"ok.png\"><br></p><p style=\"text-align: center;\"><img src=\"/upload/20190917_031347.jpg\" alt=\"ok.png\"><br></p><p style=\"text-align: center;\"><img src=\"/upload/20190917_031408.jpg\" alt=\"ok.png\"><br></p><p style=\"text-align: center;\">会展其间，还将举办“新时代新机遇”中原文旅融合发展论坛等专项活动。2019嵩山少林武术徒步星空露营节结合嵩山少林的武术文化和自然美景，给前来游玩的国内外户外登山爱好者一个全新的少林印象，放松身心，在大自然中放下疲惫，享受嵩山的美景，看一看璀璨的星空，</p><p style=\"text-align: center;\"><img src=\"/upload/20190917_031433.png\" alt=\"ok.png\"><br></p><p style=\"text-align: center;\">感受自然的美好和嵩山的魅力。此次主题活动的成功举办，集中展示了嵩山景区武术文化与厚重的历史文化，同时露营节与推出众多的武林大会子活动，为打造嵩山少林武林大会旅游品牌起到了重要的作用。。</p>', '2019-08-19', '2');
INSERT INTO `information` VALUES ('6', '明天，登封这些路段将实行交通管制！', '<p style=\"text-align: center;\">第十一届全国少数民族传统体育运动会</p><p style=\"text-align: center;\">登封活动将于2019年8月23日举行预演</p><p style=\"text-align: center;\"><br></p><p style=\"text-align: center;\">具体地点为少林景区停车场至少林寺山门，全程1600米，参演人数3525人，共分为三个区域节目展演，展演内容有舞狮、八段锦、少林铜人、集体少林拳及十六年来参加春晚节目的精彩串联等多项。少林武术讲究内外合一、朴实无华，全程节目充分展示全国武术之乡、天地之中、世界功夫之都的风采，彰显少林武术文化的深邃奥妙和博大精深。</p><p style=\"text-align: center;\"><img src=\"/upload/20190917_031135.jpg\" alt=\"ok.png\"></p><p style=\"text-align: center;\">为保障活动的顺利进行</p><p style=\"text-align: center;\">确保交通安全畅通</p><p style=\"text-align: center;\">根据《中华人民共和国道路交通安全法》</p><p style=\"text-align: center;\">有关规定</p><p style=\"text-align: center;\">活动当天将对部分路段采取临时交通管制措施</p><p style=\"text-align: center;\">具体通告如下</p><p>一、自当日上午8时45分开始至10时05分，10时35分至11时50分，下午13时40分至15时50分，除参加活动车辆外，G207国道自耿庄桥至登偃交界禁止其它各种车辆通行，途径G207国道禁行路段的过境机动车请绕行其它道路通行。</p><p><br></p><p>二、活动期间，少室路与南环二路、南环一路、颍河路、洧河路、少林大道、中岳大街、崇高路、大禹路交叉口以西、及少林大道会善路以东路段的车辆和行人，请自觉服从交通民警和工作人员指挥。</p><p><br></p><p>三、交通管制路段恢复社会交通时间由公安机关交通管理部门根据活动情况决定，交通管制路段沿线单位和广大市民，请提前安排好出行路线，以免影响工作和生活。</p><p><br></p><p>请社会各单位和广大群众给予理解和支持，自觉遵照执行。</p><p>特此通告。</p><p><br></p><p>', '2019-09-17', '1');
INSERT INTO `information` VALUES ('7', '嵩山景区参加2018中国国际旅游交易会 现场人气火爆！', '<p>2018年11月16日-18日，由中华人民共和国文化和旅游部、中国民用航空局、上海市政府共同主办的2018中国国际旅游交易会在上海新国际博览中心盛大召开。中国国际旅游交易会是目前亚洲地区最大规模的专业旅游展，每年举办一次，从2001年起，分别在上海和昆明交替举办。</p><p><br></p><p><img src=\"/upload/20190917_030701.png\" alt=\"ok.png\"><br></p><p>本届旅交会吸引了来自世界各地107个国家及地区的旅游机构、旅行社、饭店、航空公司以及同旅游业有关的企业参加，展览面积达5.75万平方米，展位总数2245个，是旅游产业向国内外推广的一场盛会。嵩山景区作为国际知名旅游景区，分别参加了中国旅游集团和河南省旅游局展区。嵩山景区是世界文化遗产、世界地质公园，国家森林公园，以古老灿烂的文化和优美的自然风光，备受海内外游客的青睐。展会期间，中国旅游集团董事长万敏，巡展港中旅景区，并对嵩山景区做出的成绩表</p><p><img src=\"/upload/20190917_030724.png\" alt=\"ok.png\"><br></p><p>示肯定。河南省参展团团长、省旅游局副局长周耀霞伸出大拇指夸奖到，少林功夫不仅是河南优秀的传统文化，更是中国对外的一张亮丽名片。少林功夫作为中国文化的一张烫金名片享誉海内外。展会上，少林小子的武术表演成为了现场最大的焦点，虎虎生风的少林功夫吸引了大量游客驻足观看，并响起了阵阵热烈的掌声，更有崇拜中国功夫的国外游客争相合影留念，现场舒展身姿拜师学功夫。</p><div><img src=\"/upload/20190917_030807.png\" alt=\"ok.png\"><br></div>', '2019-09-17', '1');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `messageid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主名ID',
  `titlename` varchar(50) COLLATE utf8_turkish_ci NOT NULL COMMENT '标题主名称',
  `context` varchar(100) COLLATE utf8_turkish_ci NOT NULL COMMENT '正文',
  `messagetime` datetime NOT NULL COMMENT '留言时间',
  PRIMARY KEY (`messageid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '啊啊啊啊啊', '23432234', '2016-09-09 00:00:00');
INSERT INTO `message` VALUES ('2', '2', '2', '2016-09-09 00:00:00');
INSERT INTO `message` VALUES ('3', '3', '3', '2016-09-09 00:00:00');
INSERT INTO `message` VALUES ('4', '4', '4', '2016-09-09 00:00:00');
INSERT INTO `message` VALUES ('5', '5', '5', '2016-09-09 00:00:00');
INSERT INTO `message` VALUES ('6', '6', '6', '2016-09-09 00:00:00');
INSERT INTO `message` VALUES ('8', 'sdasdas', 'sdad', '2015-05-05 00:00:00');
INSERT INTO `message` VALUES ('9', '测试132333', '测试132333', '2019-09-14 00:00:00');
INSERT INTO `message` VALUES ('10', 'fd', 'fs', '2019-09-15 00:00:00');

-- ----------------------------
-- Table structure for scenic
-- ----------------------------
DROP TABLE IF EXISTS `scenic`;
CREATE TABLE `scenic` (
  `Scenicid` int(11) NOT NULL AUTO_INCREMENT COMMENT '景区类型ID',
  `Scenicname` varchar(100) COLLATE utf8_turkish_ci NOT NULL COMMENT '景区类型名称',
  PRIMARY KEY (`Scenicid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of scenic
-- ----------------------------
INSERT INTO `scenic` VALUES ('1', '嵩山景区');
INSERT INTO `scenic` VALUES ('2', '少林景区');
INSERT INTO `scenic` VALUES ('3', '崇阳景区');

-- ----------------------------
-- Table structure for spot
-- ----------------------------
DROP TABLE IF EXISTS `spot`;
CREATE TABLE `spot` (
  `spotid` int(11) NOT NULL AUTO_INCREMENT COMMENT '景区ID',
  `spotname` varchar(50) COLLATE utf8_turkish_ci NOT NULL COMMENT '景区名称',
  `spottype` int(11) DEFAULT NULL COMMENT '景区类型 -主键(景区类型表)',
  `spotcontext` varchar(200) COLLATE utf8_turkish_ci NOT NULL COMMENT '景区信息',
  `spotnames` varchar(50) COLLATE utf8_turkish_ci DEFAULT NULL COMMENT '景区别名',
  `imagesrc` varchar(200) COLLATE utf8_turkish_ci DEFAULT NULL COMMENT '景区图片',
  PRIMARY KEY (`spotid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of spot
-- ----------------------------
INSERT INTO `spot` VALUES ('1', '2453435', '1', '24353', '1', '343534');
INSERT INTO `spot` VALUES ('2', '测试', '2', '测试', '2', '2');
INSERT INTO `spot` VALUES ('3', '1', null, '1', null, null);
INSERT INTO `spot` VALUES ('4', '3324242', null, '432423423', null, null);

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsId` int(11) DEFAULT NULL,
  `user` varchar(50) COLLATE utf8_turkish_ci DEFAULT NULL,
  `buyCount` int(11) DEFAULT NULL,
  `beginTime` date DEFAULT NULL,
  `endTime` date DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `imgSrc` varchar(200) COLLATE utf8_turkish_ci DEFAULT NULL,
  `state` int(11) DEFAULT '1',
  `okTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES ('34', '3', '16605113960', '1', '2019-08-23', '2019-08-28', '368', null, '2', null);
INSERT INTO `ticket` VALUES ('46', '2', '16605113960', '1', '2019-08-24', '2019-08-29', '980', null, '2', null);
INSERT INTO `ticket` VALUES ('49', '1', '12345678911', '1', '2019-08-25', '2019-08-30', '70', '/upload/20190825_071348.png', '2', null);
INSERT INTO `ticket` VALUES ('50', '2', '16611212144', '3', '2019-08-28', '2019-09-02', '2940', '/upload/20190826_102323.png', '2', null);
INSERT INTO `ticket` VALUES ('51', '3', '18362487755', '5', '2019-08-27', '2019-09-01', '1840', '/upload/20190827_090033.png', '1', null);
INSERT INTO `ticket` VALUES ('52', '3', '18362487755', '1', '2019-08-27', '2019-09-01', '368', '/upload/20190827_090217.png', '1', null);
INSERT INTO `ticket` VALUES ('53', '1', '18362487755', '1', '2019-08-27', '2019-09-01', '70', '/upload/20190827_090346.png', '2', null);
INSERT INTO `ticket` VALUES ('54', '4', '18362487755', '1', '2019-08-27', '2019-09-01', '68', '/upload/20190827_090437.png', '1', null);
INSERT INTO `ticket` VALUES ('55', '4', '18362487755', '1', '2019-08-27', '2019-09-01', '68', '/upload/20190827_090645.png', '1', null);
INSERT INTO `ticket` VALUES ('56', '4', '1213555831@qq.com', '1', '2019-09-07', '2019-09-12', '68', '/upload/20190906_041631.png', '1', null);
INSERT INTO `ticket` VALUES ('57', '4', '6620061@qq.com', '1', '2019-09-06', '2019-09-11', '68', '/upload/20190906_041855.png', '1', null);
INSERT INTO `ticket` VALUES ('58', '6', '1213555831@qq.com', '1', '2019-09-07', '2019-09-12', '468', '/upload/20190907_091254.png', '2', null);
INSERT INTO `ticket` VALUES ('59', '6', '1213555831@qq.com', '1', '2019-09-07', '2019-09-12', '468', '/upload/20190907_091254.png', '1', null);
INSERT INTO `ticket` VALUES ('60', '2', '1213555831@qq.com', '1', '2019-09-07', '2019-09-12', '980', '/upload/20190907_091751.png', '1', null);
INSERT INTO `ticket` VALUES ('61', '4', 'Jerrycai2019@outlook.com', '5', '2019-09-08', '2019-09-13', '340', '/upload/20190907_093031.png', '1', null);
INSERT INTO `ticket` VALUES ('62', '4', '1213555831@qq.com', '1', '2019-09-09', '2019-09-14', '68', '', '1', null);
INSERT INTO `ticket` VALUES ('63', '2', '1213555831@qq.com', '1', '2019-09-09', '2019-09-14', '980', '', '1', null);
INSERT INTO `ticket` VALUES ('64', '4', '1213555831@qq.com', '1', '2019-09-09', '2019-09-14', '68', '123', '1', null);
INSERT INTO `ticket` VALUES ('65', '3', '1213555831@qq.com', '1', '2019-09-09', '2019-09-14', '368', '', '1', null);
INSERT INTO `ticket` VALUES ('66', '3', '1213555831@qq.com', '1', '2019-09-09', '2019-09-14', '368', 'http://api.qrserver.com/v1/create-qr-code/?data=http://127.0.0.1:8080/SongShanAdmin/TicketServlet?op=user&id=66', '1', null);
INSERT INTO `ticket` VALUES ('67', '3', '1213555831@qq.com', '1', '2019-09-09', '2019-09-14', '368', 'http://api.qrserver.com/v1/create-qr-code/?data=http://127.0.0.1:8080/SongShanAdmin/TicketServlet?op=user&id=67', '1', null);
INSERT INTO `ticket` VALUES ('68', '3', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '368', 'http://qr.topscan.com/api.php?text=http://127.0.0.1:8080/SongShanAdmin/TicketServlet?op=user&id=68', '1', null);
INSERT INTO `ticket` VALUES ('69', '4', '1213555831@qq.com', '1', '2019-09-09', '2019-09-14', '68', 'http://qr.topscan.com/api.php?text=http://brgoooo.oicp.io:55714/SongShanWeb/TicketServlet?op=user&id=69', '1', null);
INSERT INTO `ticket` VALUES ('70', '3', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '368', 'http://qr.topscan.com/api.php?text=http://2001.nat123.cc:1111/SongShanWeb/TicketServlet?op=user&id=70', '1', null);
INSERT INTO `ticket` VALUES ('71', '3', '1213555831@qq.com', '1', '2019-09-09', '2019-09-14', '368', 'http://qr.topscan.com/api.php?text=http://2001.nat123.cc:1111/SongShanWeb/TicketServlet?op=user_71', '1', null);
INSERT INTO `ticket` VALUES ('72', '4', '1213555831@qq.com', '1', '2019-09-10', '2019-09-15', '68', 'http://qr.topscan.com/api.php?text=http://2663i6t759.zicp.vip/TicketServlet?op=user_72', '1', null);
INSERT INTO `ticket` VALUES ('73', '4', '1213555831@qq.com', '1', '2019-09-10', '2019-09-15', '68', 'http://qr.topscan.com/api.php?text=http://2663i6t759.zicp.vip/SongShanWeb/TicketServlet?op=user_73', '2', null);
INSERT INTO `ticket` VALUES ('74', '3', '1213555831@qq.com', '1', '2019-09-10', '2019-09-15', '368', 'http://qr.topscan.com/api.php?text=http://2663i6t759.zicp.vip/SongShanWeb/TicketServlet?op=user_74', '1', null);
INSERT INTO `ticket` VALUES ('75', '6', '1213555831@qq.com', '1', '2019-09-10', '2019-09-15', '468', 'http://qr.topscan.com/api.php?text=http://2663i6t759.zicp.vip/SongShanWeb/TicketServlet?op=user_75', '2', null);
INSERT INTO `ticket` VALUES ('76', '2', '1213555831@qq.com', '6', '2019-09-13', '2019-09-18', '5880', 'http://qr.topscan.com/api.php?text=http://brgoooo.oicp.io//SongShanWeb/TicketServlet?op=user_76', '1', null);
INSERT INTO `ticket` VALUES ('77', '4', '1213555831@qq.com', '1', '2019-09-10', '2019-09-15', '68', 'http://qr.topscan.com/api.php?text=http://brgoooo.oicp.io/SongShanWeb/TicketServlet?op=user_77', '2', '2019-09-10');
INSERT INTO `ticket` VALUES ('78', '2', '1213555831@qq.com', '1', '2019-09-10', '2019-09-15', '980', 'http://qr.topscan.com/api.php?text=http://brgoooo.oicp.io/SongShanWeb/TicketServlet?op=user_78', '2', '2019-09-10');
INSERT INTO `ticket` VALUES ('79', '3', '1213555831@qq.com', '3', '2019-09-10', '2019-09-15', '1104', 'http://qr.topscan.com/api.php?text=http://brgoooo.oicp.io/SongShanWeb/TicketServlet?op=user_79', '1', '2019-09-10');
INSERT INTO `ticket` VALUES ('80', '3', '1213555831@qq.com', '1', '2019-09-14', '2019-09-19', '368', 'http://qr.topscan.com/api.php?text=http://brgoooo.oicp.io/SongShanWeb/TicketServlet?op=user_80', '1', null);
INSERT INTO `ticket` VALUES ('81', '3', '1213555831@qq.com', '1', '2019-09-11', '2019-09-16', '368', 'http://qr.topscan.com/api.php?text=http://brgoooo.oicp.io/SongShanWeb/TicketServlet?op=user_81', '1', null);
INSERT INTO `ticket` VALUES ('82', '3', '1213555831@qq.com', '1', '2019-09-11', '2019-09-16', '368', 'http://qr.topscan.com/api.php?text=http://brgoooo.oicp.io/SongShanWeb/TicketServlet?op=user_82', '1', null);
INSERT INTO `ticket` VALUES ('83', '3', '1213555831@qq.com', '1', '2019-09-11', '2019-09-16', '368', 'http://qr.topscan.com/api.php?text=http://brgoooo.oicp.io/SongShanWeb/TicketServlet?op=user_83', '1', null);
INSERT INTO `ticket` VALUES ('84', '3', '1213555831@qq.com', '1', '2019-09-11', '2019-09-16', '368', 'http://qr.topscan.com/api.php?text=http://brgoooo.oicp.io/SongShanWeb/TicketServlet?op=user_84', '1', null);
INSERT INTO `ticket` VALUES ('85', '3', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '368', null, '1', null);
INSERT INTO `ticket` VALUES ('86', '4', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '68', null, '1', null);
INSERT INTO `ticket` VALUES ('87', '5', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '98', null, '1', null);
INSERT INTO `ticket` VALUES ('88', '3', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '368', null, '1', null);
INSERT INTO `ticket` VALUES ('89', '4', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '68', null, '2', null);
INSERT INTO `ticket` VALUES ('90', '5', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '98', null, '2', null);
INSERT INTO `ticket` VALUES ('91', '3', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '368', null, '2', '2019-09-12');
INSERT INTO `ticket` VALUES ('92', '4', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '68', null, '2', '2019-09-12');
INSERT INTO `ticket` VALUES ('93', '5', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '98', null, '2', '2019-09-12');
INSERT INTO `ticket` VALUES ('94', '3', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '368', null, '2', '2019-09-12');
INSERT INTO `ticket` VALUES ('95', '4', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '68', null, '2', '2019-09-12');
INSERT INTO `ticket` VALUES ('96', '5', '1213555831@qq.com', '1', '2019-09-12', '2019-09-17', '98', null, '2', '2019-09-12');
INSERT INTO `ticket` VALUES ('97', '6', '1213555831@qq.com', '1', '2019-09-19', '2019-09-24', '468', 'http://qr.topscan.com/api.php?text=http://brgoooo.oicp.io/SongShanWeb/TicketServlet?op=user_97', '1', null);
INSERT INTO `ticket` VALUES ('98', '7', '1213555831@qq.com', '1', '2019-09-16', '2019-09-21', '11', null, '2', '2019-09-17');
INSERT INTO `ticket` VALUES ('99', '6', '1213555831@qq.com', '1', '2019-09-16', '2019-09-21', '468', null, '2', '2019-09-17');
INSERT INTO `ticket` VALUES ('100', '5', '1213555831@qq.com', '1', '2019-09-16', '2019-09-21', '98', null, '2', '2019-09-17');
INSERT INTO `ticket` VALUES ('101', '4', '1213555831@qq.com', '1', '2019-09-16', '2019-09-21', '68', null, '1', null);
INSERT INTO `ticket` VALUES ('102', '12', '1213555831@qq.com', '1', '2019-09-18', '2019-09-23', '999', null, '2', '2019-09-17');
INSERT INTO `ticket` VALUES ('103', '6', '1213555831@qq.com', '1', '2019-09-18', '2019-09-23', '468', null, '1', null);
INSERT INTO `ticket` VALUES ('104', '3', '1213555831@qq.com', '1', '2019-09-18', '2019-09-23', '368', null, '1', null);

-- ----------------------------
-- Table structure for ticketm
-- ----------------------------
DROP TABLE IF EXISTS `ticketm`;
CREATE TABLE `ticketm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsId` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
  `buyCount` int(11) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `imgSrc` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
  `beginTime` date DEFAULT NULL,
  `endTime` date DEFAULT NULL,
  `okTime` date DEFAULT NULL,
  `user` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
  `state` int(11) DEFAULT '1',
  `ticketId` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of ticketm
-- ----------------------------
INSERT INTO `ticketm` VALUES ('5', '4', '1', '645', 'http://qr.topscan.com/api.php?text=http://brgoooo.oicp.io/SongShanWeb/TicketMServlet?op=user_5', '2019-09-16', '2019-09-21', null, '1213555831@qq.com', '1', '98,99,100,101');
INSERT INTO `ticketm` VALUES ('6', '5', '1', '1835', 'http://qr.topscan.com/api.php?text=http://brgoooo.oicp.io/SongShanWeb/TicketMServlet?op=user_6', '2019-09-18', '2019-09-23', null, '1213555831@qq.com', '1', '102,103,104');
