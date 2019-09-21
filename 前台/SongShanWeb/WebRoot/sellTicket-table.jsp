<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" href="./css/style.css" />
<link rel="stylesheet" href="./lib/layui/css/layui.css">
<title>门票 在线预定 - 中国嵩山景区官网</title>
<script src="./js/jquery.js" type="text/javascript"></script>
<script src="./lib/layui/layui.js" charset="utf-8"></script>
</head>

<body>
	
	<c:if test="${arr eq null}">
		<c:redirect url="TicketServlet?op=userSerach"></c:redirect>
	</c:if>
	
	<button class="layui-btn" type="butten" onclick="goodsM()">查看套票信息</button>
	
	<table>
		<tr>
			<th>商品名称</th>
			<th>购买日期</th>
			<th>金额</th>
			<th>数量</th>
			<th>到期日期</th>
			<th>查看订购码</th>
		</tr>
		
		<c:forEach items="${arr}" var="t">
			<c:if test="${t.imgSrc ne null}">
				<tr>
					<td>${t.goods.goodName}</td>
					<td>${t.beginTime}</td>
					<td>￥${t.money}</td>
					<td>${t.buyCount}</td>
					<td>${t.endTime}</td>
					<td>
						<button class="layui-btn layui-btn-sm" type="butten" i="${t.imgSrc}" onclick="sel(this)">查看预定码</button>
					</td>
				</tr>
			</c:if>
		</c:forEach>
		<c:remove var="arr"/>
	</table>
	
	<div id="html"></div>

</body>
</html>

<script>
	layui.use('layer', function() {
		var layer = layui.layer;
	});

	function sel(This) {
		var user = $("#user").val();
		var imgSrc = $(This).attr("i");
		// 二维码提示框
		var _html = "";
		_html += '<div id="back" style="background-color: #808080;z-index:2;top:0%;width:100%;height:100%;position:fixed;opacity:0.4;"></div>';
		_html += '<div class="layui-card layui-anim layui-anim-up" style="position:fixed;z-index:3;box-shadow:0px 0px 20px #555;left:40%;top:20%;">';
		_html += '<div style="text-align: center;">';
		_html += '<div class="layui-card-header" style="text-align: center;">嵩山旅游景区预定</div>';
		_html += '<div class="layui-card-body">';
		_html += '<img src="'+imgSrc+'" id="imgSrc" style="max-height:300px;">';
		_html += '<div style="line-height:40px;text-align:center;">请妥善保存二维码</div>';
		_html += '<button type="button" class="layui-btn layui-btn-fluid" id="btn">确定</button>';
		_html += '</div>';
		_html += '</div>';
		_html += '</div>';
		// 填充
		$("#html").html(_html);
	}
	
	//  新增
	$(document).on("click","#btn",function(){
		$("#html").html("");
	});
	
	// 套票
	function goodsM() {
		$(".news_info").load("sellTicketM-table.jsp");
	}
</script>
