<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>后台登录-X-admin2.2</title>
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<!-- <link rel="stylesheet" href="./css/theme5.css"> -->
<script src="./lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
<script>
	// 是否开启刷新记忆tab功能
	// var is_remember = false;
</script>
</head>
<c:if test="${admin eq null}">
<script>
	location.href="admin-Login.jsp";
</script>
</c:if>


<body class="index">
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="./index.jsp">${admin.adminname}</a>
		</div>
		<div class="left_open">
			<a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
		</div>
		<ul class="layui-nav right" lay-filter="">
			<li class="layui-nav-item"><a href="javascript:;">${admin.adminname}</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
					    <a href="AdminServlet?op=tab&number=1">切换帐号</a>
					</dd>
					<dd>
						  <a href="AdminServlet?op=tab&number=2">退出</a>
					</dd>
				</dl></li>
			<li class="layui-nav-item to-index"><a href="http://localhost:8080/SongShanWeb/">前台首页</a></li>
		</ul>
	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav">
		<div id="side-nav">
			<ul id="nav">
				<li><a href="javascript:;"> <i class="iconfont left-nav-li"
						lay-tips="其它页面">&#xe6b4;</i> <cite>后台管理</cite> <i
						class="iconfont nav_right">&#xe839;</i></a>
					<ul class="sub-menu">
						<li><a id="carousel" onclick="xadmin.add_tab('首页内容','index-carousel.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>首页内容</cite>
						</a></li>
						<li><a id="carousel" onclick="xadmin.add_tab('商品内容','goods.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>商品内容</cite>
						</a></li>
						<li><a id="carousel" onclick="xadmin.add_tab('商品记录','ticket.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>商品记录</cite>
						</a></li>
						<li><a id="carousel" onclick="xadmin.add_tab('套票内容','goodsM.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>套票内容</cite>
						</a></li>
						<li><a id="carousel" onclick="xadmin.add_tab('套票记录','ticketM.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>套票记录</cite>
						</a></li>
						<li><a id="carousel" onclick="xadmin.add_tab('新闻资讯','news-Show.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>嵩山资讯</cite>
						</a></li>
						<li><a id="carousel" onclick="xadmin.add_tab('嵩山景区','index3.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>嵩山景区</cite>
						</a></li>
						<li><a id="carousel" onclick="xadmin.add_tab('留言管理','liuyanShow.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>留言管理</cite>
						</a></li>
						<li><a id="carousel" onclick="xadmin.add_tab('嵩山文化','wenhuaa.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>嵩山文化</cite>
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- <div class="x-slide_left"></div> -->
	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
			</ul>
			<div class="layui-unselect layui-form-select layui-form-selected"
				id="tab_right">
				<dl>
					<dd data-type="this">关闭当前</dd>
					<dd data-type="other">关闭其它</dd>
					<dd data-type="all">关闭全部</dd>
				</dl>
			</div>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src='index-carousel.jsp' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
				</div>
			</div>
			<div id="tab_show"></div>
		</div>
	</div>
	<div class="page-content-bg"></div>
	<style id="theme_style"></style>
	<!-- 右侧主体结束 -->
	<!-- 中部结束 -->
</body>
</html>
