<%@ page import="javax.swing.text.Document"%>
<%@ page import="entity.Carousel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- css -->
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<link rel="stylesheet" href="css/index-carousel.css">
<!-- js -->
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="js/xadmin.js"></script>
<script src="js/jquery-1.12.4.js"></script>
</head>

<body>
	
	<!-- 数据 -->
	<div id="arrOne"></div>
	
	<!-- 修改 -->
	<div id="upd"></div>
	
	<!-- 数据 -->
	<div id="arrTwo"></div>
	
</body>
</html>

<!-- script -->
<script>
	
	//数据初始化
	function load(){
		$.post(
			"IndexServlet",
			"op=serach",
			function(data){
				if(data == "ok"){
					$("#arrOne").load("son-carousel.jsp");
					$("#arrTwo").load("son-index-table.jsp");
				}
			},
			"TEXT"
		);		
	}
	load();
	
	// 隐藏
	$(document).on("click","#btnHidden",function(){
		$("#fixed").remove();
		$("#back").remove();
	});
	
	// 显示
	$(document).on("click",".btnToUpd",function(){
		var i = $(this).attr("i");
		// 数据初始化
		$.post(
			"IndexServlet",
			"op=toupd&id="+i,
			function(data){
				if(data == "ok"){
					$("#upd").load("index-update.jsp");
				} else {
					alert("No");
				}
			},
			"TEXT"
		);
	});
	
	//  新增
	$(document).on("click",".btnToAdd",function(){
		$("#upd").load("son-insert.jsp");
	});
	
	// 修改
	$(document).on("click","#btnUpd",function(){
		// 验证管理员是否输入内容
		// 标题
		var title = $("#title").val();
		if (title == "") {
			layer.msg('标题不能为空');
			return false;
		}
		// 定向页面
		var url = $("#url").val();
		if (url == "") {
			layer.msg('定向页面不能为空');
			return false;
		}
		// 内容
		var desc = $("#desc").val();
		if (desc == "") {
			layer.msg('内容不能为空');
			return false;
		}
		//  上传图片
		uploadImg();
		// 图片信息		
		var img = $("#imgSrc").attr("src");
		// 主键
		var id = $(this).attr("i");
		// 上传数据
		$.post(
			"IndexServlet",
			"op=upd&id="+id+"&img="+img+"&title="+title+"&url="+encodeURIComponent(url)+"&desc="+desc,
			function(data){
				if(data == "ok"){
					layer.msg('成功...');
					// 修改成功
					load();
					$("#fixed").remove();
					$("#back").remove();
				}else{
					layer.msg('失败...');
				}
			},
			"TEXT"
		);
	});
	
	// 删除
	$(document).on("click",".btnToDel",function(){
		// 主键
		var id = $(this).attr("i");
		// 上传
		$.post(
			"IndexServlet",
			"op=del&id="+id,
			function(data){
				if(data != "0"){
					layer.msg('删除成功...');
					// 修改成功
					load();
				}else{
					layer.msg('删除失败...');
				}
			},
			"TEXT"
		);
	});
	
	// 新增
	$(document).on("click","#btnAdd",function(){
		// 验证管理员是否输入内容
		// 标题
		var title = $("#title").val();
		if (title == "") {
			layer.msg('标题不能为空');
			return false;
		}
		// 定向页面
		var url = $("#url").val();
		if (url == "") {
			layer.msg('定向页面不能为空');
			return false;
		}
		// 内容
		var desc = $("#desc").val();
		if (desc == "") {
			layer.msg('内容不能为空');
			return false;
		}
		// 上传图片
		uploadImg();
		// 图片信息		
		var img = $("#imgSrc").attr("src");
		// 上传数据
		$.post(
			"IndexServlet",
			"op=add&img="+img+"&title="+title+"&url="+encodeURIComponent(url)+"&desc="+desc,
			function(data){
				if(data == "ok"){
					layer.msg('成功...');
					// 修改成功
					load();
					$("#fixed").remove();
					$("#back").remove();
				}else{
					layer.msg('失败...');
				}
			},
			"TEXT"
		);
	});
	
	//获取数据的URL地址
	function createObjectURL(blob) {
		if (window.URL) {
			return window.URL.createObjectURL(blob);
		} else if (window.webkitURL) {
			return window.webkitURL.createObjectURL(blob);
		} else {
			return null;
		}
	}
	
	// 预览
	$(document).on("click",".btnLook",function(){
		look(this);
	});
	
	// 图片预览
	function look(){
		//获取文件
		var file = document.getElementById("fileField").files[0];
		
		//文件为空判断
		if (file === null || file === undefined) {
			return false;
		}

		//检测文件类型
		if (file.type.indexOf('image') === -1) {
			layer.alert("请选择图片文件！");
			return false;
		}

		//计算文件大小
		var size = Math.floor(file.size / 1024);
		if (size > 5000) {
			layer.alert("上传文件不得超过5M!");
			return false;
		}
		
		// 显示
		$("#imgSrc").attr("src",createObjectURL(file));
		return true;
	}
	
	// 图片上传至服务器
	function uploadImg(){
		// 更新
		if(!look()){
			return false;
		}
		// 表单数据
		var fd = new FormData();
		fd.append("myPhoto",document.getElementById("fileField").files[0]);
		// 执行上传操作
		var xhr = new XMLHttpRequest();
		xhr.open("post", "Upload", false);
		// 设置 HTTP 头，数据指定为 JSON 格式
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				var flag = xhr.responseText;
       			if(flag != null){
       				$("#imgSrc").attr("src",flag);
       			}
			}
		}
		// 执行发送        
		xhr.send(fd);
	}
	
</script>
