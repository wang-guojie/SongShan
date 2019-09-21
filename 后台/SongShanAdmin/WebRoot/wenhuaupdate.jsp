<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<meta name="viewport"
	content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta name="author" content="布鲁斯网络（mail@bulusi.com）" />
<meta name="keywords"
	content="中国嵩山,嵩山景区,少林寺,少林文化,少林功夫,少林寺塔林,中岳庙,太室阙,少室阙,启母阙,嵩岳寺塔,初祖庵,会善寺,嵩阳书院,观星台,释道儒" />
<meta name="description"
	content="嵩山景区地处中原，北依黄河、南近颍水，风光秀丽，景色宜人。景区内的世界文化遗产建筑群包括中岳庙、观星台、嵩阳书院、中岳庙、少林寺、塔林等8处11项历史建筑。电话:0371-62745000" />
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>企业简介 关于我们 - 中国嵩山景区官网</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery_sys.js"></script>
</head>

<body id="about">
	<div class="main block">
		<div class="main_right">
			<h1>修改</h1>
			<form action="wenhuaservlet?op=update" method="post">
			<table  width="600px">
			<tr>
			<td>标题:</td>
			<td><input type="text" name="culturename" value="${p.culturename}">
			<input type="hidden" name="cultureid" value="${p.cultureid}">
			</td>
			</tr>
			<tr>
			<td>内容:</td>
			<td><input type="text" name="cultureexplanation" value="${p.cultureexplanation}"></td>
			</tr>
				<tr>
			<td>文件上傳:</td>
			<td><input type="file" name="filedName" ></td>
			</tr>
			<tr>
			<td colspan="2">
			<input type="submit" value="修改" >
			</td>
			</tr>
			</table>
			</form>
		</div>
		</div>
		<div class="h">
			<script src="js/z_stat.js" language="JavaScript"></script>
		</div>
</body>

</html>
<script src="jquery-1.12.4.js"></script>
<script>

</script>