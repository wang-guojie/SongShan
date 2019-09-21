<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
<!-- css -->
<link rel="stylesheet" href="css/gongyong.css">
<!-- js -->
<script src="js/jquery-1.12.4.js"></script>
</head>

<body>

	<!-- 判断是否第一次进入本网页 -->
	<c:if test="${t eq null}">
		<c:redirect url="404.html"></c:redirect>
	</c:if>
	
	<!-- 自适应 -->
	<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	
	<div class="head">
		用户预订票信息
	</div>

	<div class="zhuce">
		<div class="text">
			<span>用户信息</span> 
			<input type="text" disabled value="${t.goods.goodName}" class="input">
		</div>
		<div class="text">
			<span>购买数量</span> 
			<input type="text" disabled value="${t.buyCount}" class="input">
		</div>
		<div class="text">
			<span>预定日期</span> 
			<input type="text" disabled value="${t.beginTime}" class="input">
		</div>
		<div class="text">
			<span>到期日期</span> 
			<input type="text" disabled value="${t.endTime}" class="input">
		</div>
		<c:if test="${t.okTime ne null}">
			<div class="text">
				<span>使用日期</span> 
				<input type="text" disabled class="input" value="${t.okTime}">
			</div>
		</c:if>
		<div class="text">
			<span>商品金额</span> 
			<input type="text" disabled value="${t.money}" class="input">
		</div>
		<div class="text">
			<span>预定状态</span> 
			<input type="text" disabled class="input"
				   value="<c:if test="${t.state == 1}">可用</c:if><c:if test="${t.state == 2}">禁用</c:if>">
		</div>
		<div class="btndl">
			<c:if test="${t.state == 1}">
				<button class="layui-btn" id="btnUpd" onclick="upd(${t.id})">
					使用预定票
				</button>
			</c:if>
		</div>
	</div>


</body>
</html>

<script>
	layui.use('form', function() {
		var form = layui.form;
		form.render();
	});
	
	function upd(id){
		location.href = "TicketServlet?op=upd&id=" + id;
	}
</script>
