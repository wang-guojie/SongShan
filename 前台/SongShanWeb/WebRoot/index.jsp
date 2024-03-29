<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>中国嵩山景区官网 - 少林景区 中岳景区 嵩阳景区</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery_sys.js"></script>
</head>
<body id="main">
	
	<c:if test="${arrOne eq null}">
		<c:redirect url="IndexServlet?op=serach"></c:redirect>
	</c:if>
	
	<div class="notice">欢迎您来到中国嵩山景区，景区日游客量 ${dayCount}人，景区停车位 7600 个。</div>
	
	<div class="header">
		<div class="block">
			<a href="./" title="嵩山景区" class="logo"><img
				src="picture/logo.gif" alt="嵩山景区"></a>
			<ul class="menu">
				<li><a href="index.jsp" class="hover">首页</a></li>
				<li><a href="sj.jsp">嵩山景区</a></li>
				<li><a href="songshanwenhua.jsp">文化嵩山</a></li>
				<li><a href="goods.jsp">在线预订</a></li>
				<li><a href="zixun.jsp">嵩山资讯</a></li>
				<li><a href="liuyana.jsp">留言</a></li>
			</ul>
		</div>
	</div>

	<ul class="banner block">
		<c:forEach items="${arrOne}" var="a">
			<li><img src="${a.imageSrc}" alt="${a.indexTitle}"></li>
		</c:forEach>
		<span class="banner_link">
			<c:forEach items="${arrOne}" var="a" varStatus="index">
				<a href="${a.indexUrl}" <c:if test="${index.count == 1}">class="hover"</c:if>>
					<h2>${a.indexTitle}</h2>
					<p>${a.indexDesc}</p>
				</a>
			</c:forEach>
		</span>
	</ul>
	
	<c:if test="${arrTwo eq null}">
		<c:redirect url="IndexServlet?op=serach"></c:redirect>
	</c:if>
	
	<div class="index_link">
		<ul class="ani block">
			<c:set var="num" value="0"></c:set>
			<c:forEach items="${arrTwo}" var="a" varStatus="index">
				
				
				<c:choose>
					<c:when test="${num < 1}">
						<li class="img_01">
							<a href="${a.indexUrl}" title="${a.indexTitle}"><img src="${a.imageSrc}" alt="${a.indexTitle}"></a>
						</li>
						<li class="link_01">
							<h2>${a.indexTitle}</h2>
							<p>${a.indexDesc}</p>
						</li>
						<c:set var="num" value="${num+1}"></c:set>
				  	</c:when>
				  	
				  	<c:when test="${num < 2}">
						<li class="img_02">
							<a href="${a.indexUrl}" title="${a.indexTitle}"><img src="${a.imageSrc}" alt="${a.indexTitle}"></a>
						</li>
						<li class="link_02">
							<h2>${a.indexTitle}</h2>
							<p>${a.indexDesc}</p>
						</li>
						<c:set var="num" value="${num+1}"></c:set>
				  	</c:when>
				  	
				  	<c:when test="${num < 3}">
						<li class="link_03">
							<h2>${a.indexTitle}</h2>
							<p>${a.indexDesc}</p>
						</li>
						<li class="img_03">
							<a href="${a.indexUrl}" title="${a.indexTitle}"><img src="${a.imageSrc}" alt="${a.indexTitle}"></a>
						</li>
						<c:set var="num" value="${num+1}"></c:set>
				  	</c:when>
				  	
				  	<c:when test="${num < 4}">
						<li class="link_04">
							<h2>${a.indexTitle}</h2>
							<p>${a.indexDesc}</p>
						</li>
						<li class="img_04">
							<a href="${a.indexUrl}" title="${a.indexTitle}"><img src="${a.imageSrc}" alt="${a.indexTitle}"></a>
						</li>
						<c:set var="num" value="0"></c:set>
				  	</c:when>
				</c:choose> 
				
			</c:forEach>
		</ul>
	</div>

	<!-- FOOTER -->
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
					<li><a target="_blank" href="about.php?softid=220">联系方式</a></li><li><a target="_blank" href="about_questionnaire.php">调查问卷</a></li><li><a target="_blank" href="about.php?softid=221">版权声明</a></li>
				</ul>
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

</body>

</html>
