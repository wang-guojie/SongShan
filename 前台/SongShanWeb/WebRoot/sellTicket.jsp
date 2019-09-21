<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" href="./css/style.css" />
<link rel="stylesheet" href="./lib/layui/css/layui.css">
<title>门票 在线预定 - 中国嵩山景区官网</title>
<script type="text/javascript" src="./js/jquery.js"></script>
<script src="./lib/layui/layui.js" charset="utf-8"></script>
</head>

<body id="shop_order">

	<p id="html"></p>

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
		<img src="picture/2-1499592737935.jpg" alt="">
	</div>

	<div class="nav">
		<ul>
			<li><a href="WebGoodsServlet?op=serach&typeid=1" >门票</a></li>
			<li><a href="WebGoodsServlet?op=serach&typeid=2" >酒店</a></li>
			<li><a href="WebGoodsServlet?op=serach&typeid=3" >美食</a></li>
			<li><a href="WebGoodsServlet?op=serach&typeid=4" >商品</a></li>
			<li><a href="WebGoodsMServlet?op=serach">套票</a></li>
			<li><a href="sellTicket.jsp" class="hover">我的订单</a></li>
		</ul>
	</div>

	<div class="main block">
		<div class="news_info">
			<table class="shop_checkmob">
				<tr>
					<th colspan="2">输入邮箱以查询订单记录</th>
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
					<td colspan="2" class="center"><small>邮箱是验证你的身份的唯一方式，请务必填写正确。</small></td>
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

	layui.use('layer', function() {
		var layer = layui.layer;
	});
	
	function buy(){
		// 获取用户邮箱地址
		var user = $("#user").val();
		// 验证邮箱是否正确
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
		
		var user = $("#user").val();
		$.post(
			"WebGoodsServlet",
			"op=userSearch&user="+user,
			function(data){
				if (data == "1") {
					$(".news_info").load("sellTicket-table.jsp");
				} else {
					layer.msg("未查到信息");
				}
			},
			"Text"
		);
	}
	
	var yan = null;
	var ds = null;
	var time = 60;
	
	// 获取验证码后的60秒锁定
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
	
	// 获取验证码
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
	
	// 验证邮箱是否正确
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
	
</script>
