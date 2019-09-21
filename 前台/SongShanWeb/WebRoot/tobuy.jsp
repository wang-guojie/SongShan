<%@ page import="unit.Mail"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" href="./css/style.css"/>
<link rel="stylesheet" href="./lib/layui/css/layui.css">
<title>门票 在线预定 - 中国嵩山景区官网</title>
<script type="text/javascript" src="./js/jquery.js"></script>
<script src="./lib/layui/layui.js" charset="utf-8"></script>
</head>

<body id="shop_order">
	
	<p id="html"></p>
	
	<c:if test="${t eq null}">
		<c:redirect url="404.htm"></c:redirect>
	</c:if>
	
	<div class="header">
		<div class="block">
			<a href="./" title="嵩山景区" class="logo"><img
				src="picture/logo_1.gif" alt="嵩山景区"></a>
			<ul class="menu">
				<li><a href="index.jsp">首页</a></li>
				<li><a href="sj.jsp">嵩山景区</a></li>
				<li><a href="songshanwenhua.jsp">文化嵩山</a></li>
				<li><a href="goods.jsp" class="hover">在线预订</a></li>
				<li><a href="zixun.jsp">嵩山资讯</a></li>
				<li><a href="liuyana.jsp">留言</a></li>
			</ul>
		</div>
	</div>

	<div class="par ani_bird block">
		<img src="picture/2-1499592767352.jpg" alt="">
	</div>

	<div class="nav">
		<ul>
			<li><a href="WebGoodsServlet?op=serach&typeid=1"
				<c:if test="${typeid == 1}">class="hover"</c:if>>门票</a></li>
			<li><a href="WebGoodsServlet?op=serach&typeid=2"
				<c:if test="${typeid == 2}">class="hover"</c:if>>酒店</a></li>
			<li><a href="WebGoodsServlet?op=serach&typeid=3"
				<c:if test="${typeid == 3}">class="hover"</c:if>>美食</a></li>
			<li><a href="WebGoodsServlet?op=serach&typeid=4"
				<c:if test="${typeid == 4}">class="hover"</c:if>>商品</a></li>
			<li><a href="WebGoodsMServlet?op=serach">套票</a></li>
			<li><a href="sellTicket.jsp">我的订单</a></li>
		</ul>
	</div>
	
	<div class="main block">
		<div class="intro_title block">
			<h1 title="在线预定" class="title title_11">请确认您的订单信息并继续订单</h1>
		</div>
		<div class="news_info">
			<table class="shop_checkmob">
				<tr>
					<th colspan="2">输入邮箱以购买商品</th>
				</tr>
				<tr>
					<td width="100">邮箱：</td>
					<td><input type="text" id="user" class="a"></td>
				</tr>
				<tr>
					<td width="100">验证码：</td>
					<td>
						<input type="text" id="yzm" class="a">
						<button type="button" class="layui-btn layui-btn-sm" id="yzm_btn">获取验证码</button>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="center"><small>邮箱请务必填写正确。</small></td>
				</tr>
			</table>
			<table>
				<tr>
					<th>商品名称</th>
					<th>购买日期</th>
					<th>金额</th>
					<th>数量</th>
					<th>到期日期</th>
				</tr>
				<tr>
					<td>${t.goods.goodName}</td>
					<td>${t.beginTime}</td>
					<td>￥${t.money}</td>
					<td>${t.buyCount}</td>
					<td>${t.endTime}</td>
				</tr>
				<tr>
					<td colspan="5" class="center"><small>商品总金额：<strong>￥${t.money}</strong> 元 </small></td>
				</tr>
			</table>
			
			<p style="text-align:center;">
				<button type="button" class="layui-btn layui-btn-lg" onclick="buy()">继续订单</button>
			</p>
			
		</div>
	</div>
	

</body>
</html>

<script>

	layui.use('layer', function(){
		var layer = layui.layer;
	}); 
	
	var yan = null;
	var ds = null;
	var time = 60;
	
	function dis() {
		if (--time != 0) {
			$("#yzm_btn").attr("disabled",true);
			$("#yzm_btn").text(time);
		} else {
			$("#yzm_btn").attr("disabled",false);
			$("#yzm_btn").text("获取验证码");
			time = 60;
			yan = null;
			window.clearInterval(ds);
		}
	}
	
	$("#yzm_btn").click(function(){
		if(email()) {
			// 获取用户邮箱地址
			var user = $("#user").val();
			layer.msg("验证码发送成功！");
			$.post(
				"WebGoodsServlet",
				"op=yzm&user="+user,
				function(yzm){
					yan = yzm;
				},
				"text"
			);
			ds = window.setInterval("dis()",1000);
		}
	});
	
	function email() {
		// 获取用户邮箱地址
		var user = $("#user").val();
		// 验证邮箱是否正确
		if (!(/[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/.test(user))) {
			layer.msg("邮箱有误！");
			return false;
		}
		return true;
	}
	
	function buy(){
		// 获取用户邮箱地址
		var user = $("#user").val();
		
		if(!email()) {
			return false;
		}
		
		// 获取用户的验证码
		var yzm = $("#yzm").val();
		// 验证用户的验证码是否正确
		if (yzm == null || yzm != yan) {
			layer.msg("验证码有误！");
			return false;
		}
		
		$("this").attr("disabled",true);
		layer.msg("预定中...", {time:5000});
		
		$.post(
			"WebGoodsServlet",
			"op=buy&user="+user,
			function(data){
				if(data != "0"){
					layer.msg("预定成功！");
					// 二维码提示框
					var _html = "";
					_html += '<div id="back" style="background-color: #808080;z-index:2;top:0%;width:100%;height:100%;position:fixed;opacity:0.4;"></div>';
					_html += '<div class="layui-card layui-anim layui-anim-up" style="position:fixed;z-index:3;box-shadow:0px 0px 20px #555;left:40%;top:20%;">';
					_html += '<div style="text-align: center;">';
					_html += '<div class="layui-card-header" style="text-align: center;">嵩山旅游景区预定</div>';
					_html += '<div class="layui-card-body">';
					_html += '<img src="'+data+'" id="imgSrc" style="max-height:300px;">';
					_html += '<div style="line-height:40px;text-align:center;">请妥善保存二维码</div>';
					_html += '<button type="button" class="layui-btn layui-btn-fluid" id="btnImg">确定</button>';
					_html += '</div>';
					_html += '</div>';
					_html += '</div>';
					// 填充
					$("#html").html(_html);
				} else {
					layer.msg("预定失败！");
					$("this").attr("disabled",false);
				}
			},
			"Text"
		);
	}
	
	//  新增
	$(document).on("click","#btnImg",function(){
		window.history.go(-2);
	});

</script>
