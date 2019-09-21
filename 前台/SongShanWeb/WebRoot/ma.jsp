<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>门票 在线预定 - 中国嵩山景区官网</title>
<link rel="stylesheet" href="./css/layui.css">
<script src="js/jquery-1.12.4.js"></script>
<script src="./js/layui.all.js"></script>
</head>

<body>
	
	<div id="back" style="background-color: #808080;z-index:2;top:0%;width:100%;height:100%;position:fixed;opacity:0.4;"></div>
	<div class="layui-card" style="position:fixed;z-index:3;box-shadow:0px 0px 20px #555;left:40%;top:20%;">
		<div style="text-align: center;">
			<!-- 头部 -->
			<div class="layui-card-header" style="text-align: center;">嵩山旅游景区预定</div>
			<!-- 主体 -->
			<div class="layui-card-body">
				<!-- 二维码 -->
				<img src="../upload/QRCode.png" id="imgSrc" style="max-height:300px;">
				<div style="line-height: 40px;text-align: center;">请妥善保存二维码</div>
				<button type="button" class="layui-btn layui-btn-fluid" id="btnImg">确定</button>
			</div>
		</div>
	</div>

</body>
</html>
