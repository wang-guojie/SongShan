<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html class="x-admin-sm">

<head>
<meta charset="UTF-8">
<title>欢迎页面-X-admin2.2</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript" src="./lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>

<body>
	<div class="layui-fluid">
		<div class="layui-row">
			<form class="layui-form" method="post" action="Servletspot?op=adds">


				<div class="layui-form-item">
					<label for="spotname" class="layui-form-label"> <span
						class="x-red">*</span>景区名称
					</label>
					<div class="layui-input-inline">
						<input type="text" id="spotname" name="spotname"
							lay-verify="required" autocomplete="off" class="layui-input">
							
					</div>
						<span id="msg"></span>
				</div>


				<div class="layui-form-item">
					<label for="spotcontext" class="layui-form-label"> <span
						class="x-red">*</span>景区信息
					</label>
					<div class="layui-input-inline">
						<input type="text" id="spotcontext" name="spotcontext" required=""
							lay-verify="spotcontext" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"> </label>
					<button class="layui-btn" lay-filter="add" lay-submit="submit">
						增加</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
<script>
	layui.use([ 'form', 'layer' ], function() {
		$ = layui.jquery;
		var form = layui.form, layer = layui.layer;

		//监听提交
		form.on('submit(add)', function(data) {
			console.log(data);
			//发异步，把数据提交给php
			var name=$("#spotname").val();
			var spotcontext=$("#spotcontext").val();
			
			$.post(
					"Servletspot",
					"op=add&spotname=" + name + 
					"&spotcontext="+ spotcontext,
					function(r) {
					if (r.result == "1") {
					layer.alert("增加成功", {
						icon : 6
					}, function() {
						//关闭当前frame
						xadmin.close();
						// 可以对父窗口进行刷新 
						xadmin.father_reload();
					});
				} else {
					layer.alert("增加失败", {
						icon : 6
					}, function() {
						//关闭当前frame
						xadmin.close();
						// 可以对父窗口进行刷新 
						xadmin.father_reload();
					});
				}
			}, "json");

			return false;
		});
	});
</script>
<script src="jquery-1.12.4.js"></script>
<script>
	$("#spotname").blur(function(){
   	 	$.post(
   	 		"Servletspot",
   	 		"op=chname&name="+$(this).val(),
   	 		function(r){
   	 			if(r.c=="0"){
   	 				$("#msg").html("可用");
   	 			}else{
   	 				$("#msg").html("重复不可用");
   	 			}
   	 		},"json"
   	 	);
   	 });
</script>
