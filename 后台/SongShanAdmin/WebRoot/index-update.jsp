<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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
	
	<c:if test="${c ne null}">
		<div id="back" style="background-color: #808080;z-index:2;top:0%;width:100%;height:100%;position:fixed;opacity:0.4;"></div>
		<!-- 修改数据页 -->
		<div class="layui-col-sm4" id="fixed" style="left:33.3%;top:0%;z-index:3;position:fixed;">
			<div class="layui-card layui-anim layui-anim-scaleSpring" id="home" style="box-shadow:0px 0px 20px #555;">
				<!-- 轮播内容头部 -->
				<div class="layui-card-header">
					轮播内容
				</div>
				<!-- 轮播内容主体 -->
				<div class="layui-card-body" style="text-align: center; width: 95%;">
					<!-- 轮播主图 -->
					<img src="${c.imageSrc}" id="imgSrc" style="max-height:200px;min-height:100px;margin: 0 auto;">
					<div class="layui-card-body layui-form layui-form-pane">
						<!-- 轮播标题 -->
						<div class="layui-form-item" style="margin:21px 0px 0px 0px">
							<label class="layui-form-label">标题</label>
							<div class="layui-input-block">
								<input type="text" value="${c.indexTitle}" id="title" name="title"
									required="" lay-verify="required" placeholder="请输入标题"
									autocomplete="off" class="layui-input">
							</div>
						</div>
						<!-- 定向页面 -->
						<div class="layui-form-item" style="margin:21px 0px 0px 0px">
							<label class="layui-form-label">网页</label>
							<div class="layui-input-block">
								<input type="text" value="${c.indexUrl}" id="url" name="title" required=""
									lay-verify="required" placeholder="请输入定向网页" autocomplete="off"
									class="layui-input">
							</div>
						</div>
						<!-- 上传图片 -->
						<div class="layui-form-item" style="margin:21px 0px 0px 0px">
							<label class="layui-form-label">图片</label>
							<div class="layui-input-block">
								<input type="file" class="layui-input" name="file"  accept="image/*" style="position: absolute;filter: alpha(opacity : 0);opacity: 0;"
									id="fileField" onchange="document.getElementById('textfield').value=this.value;look()">
								<input type="text" value="${c.imageSrc}" id="textfield" class="layui-input">
							</div>
						</div>
						<!-- 轮播内容 -->
						<div class="layui-form-item layui-form-text"
							style="margin:21px 0px">
							<label class="layui-form-label">描述</label>
							<div class="layui-input-block">
								<textarea name="desc"
									value="${c.indexDesc}" id="desc"
									placeholder="请输入内容" class="layui-textarea">${c.indexDesc}</textarea>
							</div>
						</div>
						<!-- 上传数据 -->
						<div class="layui-form-item" style="margin:10px 0px 0px 0px">
							<button type="button" id="btnUpd" class="layui-btn layui-btn-fluid" i="${c.indexId}">
								<i class="layui-icon">&#xe605;</i>
							</button>
						</div>
						<div class="layui-form-item" style="margin:10px 0px 0px 0px">
							<button type="button" id="btnHidden" class="layui-btn layui-btn-fluid layui-btn-danger">
								<i class="layui-icon">&#x1006;</i>
							</button>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<!-- 销毁会话中的数据 -->
		<c:remove var="c"/>
	</c:if>
	
	
</body>
</html>
