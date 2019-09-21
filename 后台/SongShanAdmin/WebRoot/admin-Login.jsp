<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>后台登录-X-admin2.2</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/login.css">
<link rel="stylesheet" href="./css/xadmin.css">
<link rel="stylesheet" href="../src/css/layui.css">
<link rel="stylesheet" href="layui/css/layui.css" />
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="./lib/layui/layui.js" charset="utf-8"></script>
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="login-bg">
	<div class="login layui-anim layui-anim-up">
		<div class="message">x-admin2.0-管理登录</div>
		<div id="darkbannerwrap"></div>
		<form method="post" action="">
			<input name="username" id="username" placeholder="用户名" type="text">
			<hr class="hr15">
			<input name="password" id="password" placeholder="密码" type="password">
			<hr class="hr15">
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div style="width:100%;">
					<div id="slider"></div>
				</div>
			</div>
			<hr class="hr20">
			<button class="layui-btn" lay-submit lay-filter="formDemo"
				style="width:162px; height:40px">登录</button>
			<button type="reset" id="reset" class="layui-btn layui-btn-primary"
				style="width:162px; height:40px">重置</button>
		</form>
	</div>

</body>
</html>
<script src="jquery-3.4.1.min.js"></script>
<script src="jquery-1.12.4.js"></script>
<script src="layui_exts/sliderVerify/sliderVerify.js"></script>
<script src="layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
	//滑动滑块通过
	layui.config({
		base : 'layui_exts/'
	}).extend({
		sliderVerify : 'sliderVerify/sliderVerify'
	}).use(
			[ 'sliderVerify', 'jquery', 'form' ],
			function() {
				var sliderVerify = layui.sliderVerify, form = layui.form;
				var slider = sliderVerify.render({
					elem : '#slider',
					isAutoVerify : false,//关闭自动验证
					bg : 'layui-bg-green',//自定义背景样式名
					onOk : function() {//当验证通过回调
						layer.msg("滑块验证通过");
					}
				})

				//重置滑块
				$('#reset').on('click', function() {
					slider.reset();
					$("#username").css("border", "");
					$("#password").css("border", "");
				})

				//监听提交
				form.on('submit(formDemo)', function(data) {
					var username = $("#username").val();
					var password = $("#password").val();
					if (username == "") {
						$("#username").css("border", "1px solid red");
						layer.msg("用户名不能为空");
						return false;
					}
					if (password == "") {
						$("#password").css("border", "1px solid red");
						layer.msg("密码不能为空");
						return false;
					}
					//如果填值了 将文本框至空
					//$("#username").css("border","");
					//$("#password").css("border","");

					//通过就变true;
					if (slider.isOk()) {
						//通过滑块
						$.post("AdminServlet", "op=ck&username=" + username
								+ "&password=" + password, function(r) {
							if (r.count == "1") {
								layer.msg("登录成功!");
								//进行页面跳转
								location.href = 'index.jsp';
							} else {
								$("#username").css("border", "1px solid red");
								$("#password").css("border", "1px solid red");
								layer.msg("用户名&密码有误请重试");
							}
						}, "json")
						//layer.msg(JSON.stringify(data.field));
					} else {
						layer.msg("请通过滑块验证");
					}
					return false;
				});
			})

	//元素获取焦点事件
	$("#username").focus(function() {
		$("#username").css("border", "");

	})
	$("#password").focus(function() {
		$("#password").css("border", "");
	})
</script>


