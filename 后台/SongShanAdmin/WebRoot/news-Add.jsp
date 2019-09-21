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
			<table class="layui-form" style="width:1500px">
				<tr>
					<td>
						<div class="layui-form-item">
							<label class="layui-form-label">新闻标题</label>
							<div class="layui-input-block">
								<input type="text" name="" required lay-verify="required"
									placeholder="请输入标题" autocomplete="off" class="layui-input"
									id="titlename" />
							</div>
						</div> <span id="msg"></span>
					</td>
				</tr>
				<tr>
					<td>
						<div class="layui-form-item">
							<label class="layui-form-label">景区类型</label>
							<div class="layui-input-block">
								<select name="city" lay-verify="required" id="city">
									<option value="-1">请选择</option>
									<c:forEach items="${sList}" var="s">
										<option value="${s.scenicid}">${s.scenicname}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td><textarea id="demo" style="display: none;"></textarea>
						<div class="layui-form-item">
							<div class="layui-input-block">
								<button id="btn" class="layui-btn"
									style="width:40%; height:40px">立即提交</button>
								<button type="reset" class="layui-btn layui-btn-primary"
									id="reset" style="width:40%; height:40px">重置</button>
							</div>
						</div></td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>
<script src="jquery-1.12.4.js"></script>
<script src="layer.js"></script>
<script>
	//富文本框
	layui.use('layedit', function() {
		var layedit = layui.layedit;

		// 加载图片上传事务
		layedit.set({
			uploadImage : {
				url : 'UploadTest', // 接口url
				type : 'post' // 默认post
			}
		});

		// 生成编辑器
		var editIndex = layedit.build('demo', {
			height : 500
		// 设置编辑器高度
		});

		$(document).on(
				"click",
				"#btn",
				function() {

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

					//新闻内容编辑
					var contents = layedit.getContent(editIndex);

					$.post("AdminServlet", "op=add&titlename=" + titlename
							+ "&contents=" + contents + "&city=" + city,
							function(r) {
								if (r.result == "1") {
									layer.msg('新闻添加成功');
									$("#titlename").val("");
									$("#content").val("");
								} else {
									layer.msg('新闻添加失败');
								}
							}, "json")

				});

	});
</script>
<script>
	layui.use('form', function() {
		var form = layui.form;
		//各种基于事件的操作，下面会有进一步介绍
	});
	/*新闻标题查重事件
	$("#titlename").blur(
			function() {
				$.post("AdminServlet", "op=zixunck&inforname=" + $(this).val(),
						function(r) {
							if (r.result == "0") {
								$("#msg").html("新闻标题通过").css(
										"background-color", "red");
							} else {
								$("#msg").html("新闻标题重复").css(
										"background-color", "red");
							}
						})
			})*/

	//表单重置事件
	$("#reset").click(function() {
		$("#titlename").val("");
	})

	layui.use('form', function() {
		var form = layui.form;
		//各种基于事件的操作，下面会有进一步介绍
	});

	/*文件上传
	var upload = layui.upload; //得到 upload 对象
	layui.use('upload', function() {
		var upload = layui.upload;
		//执行实例
		var uploadInst = upload.render({
			elem : '#test1' //绑定元素
			,
			url : 'UploadServlet' //上传接口
			,
			done : function(res) {
				//上传完毕回调
				if (res.start == "erro") {
					alert("失败");
				} else {
					alert(res.start);
				}
			},
			error : function() {
				//请求异常回调
			}
		});
	})*/
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
