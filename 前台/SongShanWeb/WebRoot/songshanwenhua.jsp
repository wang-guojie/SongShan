<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" href="css/style_2.css" type="text/css" />
<title>宗教 文化嵩山 - 中国嵩山景区官网</title>
<script type="text/javascript" src="js/jquery_2.js"></script>
<script type="text/javascript" src="js/jquery_sys_2.js"></script>
</head>
<body id="culture">
<div class="header" data-menu="ajax_menu_sub.php">
<div class="block">
<a href="./" title="嵩山景区" class="logo"><img src="picture/logo_2.gif" alt="嵩山景区"></a>
<ul class="menu">
<li><a href="index.jsp">首页</a></li>
<li><a href="sj.jsp">嵩山景区</a></li>
<li><a href="songshanwenhua.jsp" class="hover">文化嵩山</a></li>
<li><a href="goods.jsp">在线预订</a></li>
<li><a href="zixun.jsp">嵩山资讯</a></li>
<li><a href="liuyana.jsp">留言</a></li>
</ul>
</div>
</div>
<div class="par ani_cloud block"><img src="picture/2-1499592195725.jpg" alt=""></div>

<div class="nav">

</div>

<div class="shortcut">

</div>

<div class="main">
<div class="block">

<c:if test="${ list eq null }" >
	<c:redirect url="wenhuaservlet?op=search"></c:redirect>
</c:if>

<c:set var="num" value="0"></c:set>
<ul class="list_pic_vert list_pic_vert_white culture_list ani block">
<c:forEach items="${list}" var="a" varStatus="index">
				<c:choose>
					<c:when test="${num < 1}">
						<li class="culture_list_01 mirror">
						<a href="culture_info.php?softid=240" title="嵩山66丰富的佛教文化"><img src="picture/2-1497169989871.jpg" alt="嵩山丰富的佛教文化" style="opacity: 1;"></a>
						 <p>${a.cultureexplanation}</p>
					
						<a href="wenhuaservlet?op=xiangxi" title="了解更多" class="more">了解更多</a>
						</li>
						<c:set var="num" value="${num+1}"></c:set>
				  	</c:when>
				  	
				  	<c:when test="${num < 2}">
						<li class="culture_list_02">
						<a href="culture_info.php?softid=241" title="嵩山丰富的道教文化"><img src="picture/2-1497170011427.jpg" alt="嵩山丰富的道教文化"></a>
						<p>${a.cultureexplanation}</p>
						<a href="wenhuaservlet?op=daojiao" title="了解更多" class="more">了解更多</a>
						</li>
						
						<c:set var="num" value="${num+1}"></c:set>
				  	</c:when>
				  	
				  	<c:when test="${num < 3}">
						<li class="culture_list_03 mirror">
						<a href="culture_info.php?softid=242" title="嵩山丰富的儒家文化"><img src="picture/2-1497170028552.jpg" alt="嵩山丰富的儒家文化"></a>	
							<p>${a.cultureexplanation}</p>
						<a href="wenhuaservlet?op=daowen" title="了解更多" class="more">了解更多</a>
						</li>
						<c:set var="num" value="${num+1}"></c:set>
				  	</c:when>
				</c:choose> 
			</c:forEach>
</ul>
</div>
</div>

<div class="footer">
<ul class="menu block">
<li><a href="shop.php" class="menu_03">门票<em class="en">Tickets</em></a></li>
<!--<li><a href="shop_hotel.php" class="menu_02">酒店<em class="en">Hotel</em></a></li>-->
<li><a href="service_traffic.php" class="menu_01">交通指南<em class="en">Traffic</em></a></li>
<li><a href="service_faq.php" class="menu_04">常见问题<em class="en">FAQ</em></a></li>
<li><a href="service_safe.php" class="menu_03">旅游安全<em class="en">Safe</em></a></li>
<li><a href="about_message.php" class="menu_05">咨询&amp;投诉<em class="en">Message</em></a></li>
</ul>
<div class="link">
<div class="block">
<ul>
<li><a href="news.php" class="link_title">嵩山资讯</a></li>
<li><a href="news.php?cid=1">景区新闻</a></li><li><a href="news.php?cid=2">景区文化</a></li><li><a href="news.php?cid=4">大事记</a></li></ul>
<ul>
<li><a href="intro.php" class="link_title">嵩山景区</a></li>
<li><a href="intro_shaolin.php">少林景区</a></li><li><a href="intro_zhongyue.php">中岳景区</a></li><li><a href="intro_songyang.php">嵩阳景区</a></li></ul>
<ul>
<li><a href="app.php" class="link_title">新媒体</a></li>
<li><a href="app.php">官方微信</a></li>
<li><a target="_blank" href="https://weibo.com/u/1988440023">官方微博</a></li><li><a target="_blank" href="app.php">下载APP</a></li></ul>
<ul>
<li><a href="about.php" class="link_title">关于我们</a></li>
<li><a target="_blank" href="about.php">企业简介</a></li><li><a target="_blank" href="about.php?softid=218">荣誉</a></li><li><a target="_blank" href="about.php?softid=219">人才招聘</a></li></ul>
<ul>
<li><a href="about.php" class="link_title">联系我们</a></li>
<li><a target="_blank" href="about.php?softid=220">联系方式</a></li><li><a target="_blank" href="about_questionnaire.php">调查问卷</a></li><li><a target="_blank" href="about.php?softid=221">版权声明</a></li></ul>
</div>
</div>
<div class="blogroll">
<div class="block">
<select>
<option selected="selected">政府链接</option>
<option value="https://www.mct.gov.cn/">国家文化和旅游部</option>
<option value="http://www.hnta.cn/">河南省旅游局</option>
<option value="http://www.zhengzhouta.gov.cn/">郑州市旅游局</option>
<option value="http://www.dengfeng.gov.cn/">登封市人民政府网</option>
</select>
<select>
<option selected="selected">行业链接</option>
<option value="http://www.cnta.gov.cn/">中国旅游网</option>
<option value="http://ctsho.com/">中国旅行社总社</option>
<option value="http://www.ctshk.com/">香港中国旅行社</option>
<option value="http://www.mangocity.com/">芒果网有限公司</option>
<option value="http://ctsbus.hkcts.com/">香港中旅旅运发展有限公司</option>
<option value="http://www.hkctshotels.com/">港中旅酒店有限公司</option>
<option value="http://www.wdgs.com.cn/">陕西渭河发电有限公司</option>
<option value="http://www.cn5000.com.cn/">深圳锦绣中华民俗村</option>
<option value="http://www.szwwco.com/">深圳世界之窗</option>
<option value="http://www.ctsfreight.com/">港中旅华贸国际物流股份有限公司</option>
<option value="http://www.ctseb.com/">香港中旅科技电脑有限公司</option>
<option value="http://www.traveler.com.cn/">旅行家网站</option>
<option value="http://www.yuntaishan.net/">云台山</option>
<option value="http://www.qingmings.com/">清明上河园</option>
<option value="http://www.lmsk.cn/">龙门石窟</option>
<option value="http://www.hhscenic.com/">郑州黄河风景名胜区</option>
</select>
<select>
<option selected="selected">相关链接</option>
<option value="http://www.shaolin.org.cn/">少林寺官方网站</option>
<option value="http://www.17u.cn/">同程网</option>
<option value="http://www.lvmama.com/">驴妈妈</option>
<option value="http://www.lotour.com/">乐途旅游网</option>
<option value="http://www.mangocity.com/">芒果网</option>
<option value="http://www.dahe.cn/">大河网</option>
</select>
</div>
</div>
<span class="block">
<p>CopyRight© 2006-2017 Songshan Scenic Area</p>
<p>嵩山少林文化旅游有限公司 版权所有 <a href="http://www.miibeian.gov.cn" target="_blank">豫公网安备41018502000213号</a></p>
<p>地址：河南省登封市嵩山少林景区 电话：0371-62745000</p>
</span>
</div>

<div class="h"><script src="js/z_stat_2.js" language="JavaScript"></script></div>

</body>


