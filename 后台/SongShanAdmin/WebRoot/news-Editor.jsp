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
			<form class="layui-form">
				<div class="layui-form-item">
					<label for="L_email" class="layui-form-label"> <span
						class="x-red">*</span>新闻标题
					</label>
					<div class="layui-input-inline">
						<input type="text" id="titlename" required="输入标题" lay-verify=""
							autocomplete="off" class="layui-input" value="${list.inforname}"
							style="width:1500px"> <input type="hidden"
							value="${list.inforid}" id="id">
					</div>

				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">资讯类型</label>
					<div class="layui-input-block">
						<select name="city" id="city" lay-verify="required">
							<option value="-1">请选择</option>
							<c:forEach items="${sList}" var="s">
								<c:if test="${s.scenicid!=list.typeid}">
									<option value="${s.scenicid}">${s.scenicname}</option>
								</c:if>
								<c:if test="${s.scenicid==list.typeid}">
									<option value="${s.scenicid}" selected>${s.scenicname}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				</div>
				<textarea id="demo" style="display: none;">${list.inforcontent}</textarea>

				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"></label>
					<button class="layui-btn" lay-filter="add" id="res"
						style="width:30%; height:40px">修改</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
<script src="jquery-1.12.4.js"></script>
<script>
	layui.use('layedit', function() {
		var layedit = layui.layedit;

		// 加载图片上传事务
		layedit.set({
			uploadImage : {
				url : 'UploadTest', // 接口url
				type : 'post' // 默认post
			}
		});

		try {

		} catch (e) {
			// TODO: handle exception
		}

		// 生成编辑器
		var editIndex = layedit.build('demo', {
			height : 500
		// 设置编辑器高度
		});

		/*$("#btn").click(function(){
			alert(layedit.getContent(editIndex));// 取整个值
		});*/
		$(document).on(
				"click",
				"#res",
				function() {
					var id = $("#id").val();
					var contents = layedit.getContent(editIndex);
					var titlename = $("#titlename").val();
					var city = $("#city").val();
					
					var titlename = $("#titlename").val();
					var city = $("#city").val();

					if (titlename == "") {
						$("#titlename").css("border", "1px solid red");
						layer.msg('新闻标题不能为空');
						return false;
					}
					if (city == "-1") {
						$("#city").css("border", "1px solid red");
						layer.msg('请选择景区类型');
						return false;
					}
					
					
					$.post("AdminServlet", "op=update&contents=" + contents
							+ "&titlename=" + titlename + "&id=" + id
							+ "&city=" + city, function(r) {
						if (r.count == "1") {
							alert("成功");
							xadmin.close();
						} else {
							alert("失败");
							xadmin.close();
						}
					}, "json")
				});

	});
</script>
<script>
	/*layui.use([ 'form', 'layer' ], function() {
		$ = layui.jquery;
		var form = layui.form, layer = layui.layer;

		//监听提交
		form.on('submit(add)', function(data) {
			console.log(data);
			//发异步，把数据提交给php
			layer.alert("修改成功", {
				icon : 6
			}, function() {
				// 获得frame索引
				var index = parent.layer.getFrameIndex(window.name);
				//关闭当前frame
				parent.layer.close(index);
			});
			return false;
		});

	});*/
</script>

<script>
//验证标题重复时间
/*$("#titlename").blur(
		function() {
			$.post(
					"AdminServlet", 
					"op=titleCk&titlename=" + $(this).val(),
					function(r) {
						if (r.result == "1") {
							layer.msg('资讯标题重复');
							$("#titlename").css("border", "1px solid red");
							$("#titlename").val("");
						} else {
							layer.msg('资讯标题通过');
							$("#titlename").css("border", "1px solid #E6E6E6");
						}
					}, "json")
		})*/
</script>
