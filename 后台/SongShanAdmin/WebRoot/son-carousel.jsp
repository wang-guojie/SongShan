<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC -//W3C//DTD HTML 4.01 Transitional//EN>
<html>
<head>
</head>

<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<link rel="stylesheet" href="css/index-carousel.css">
<script type="text/javascript" src="js/xadmin.js"></script>
<script src="js/jquery-1.12.4.js"></script>
<script src="./lib/layui/layui.js"></script>	
<body>

	<div class="layui-fluid layui-col-space15" id="father">
		
		<c:if test="${arrOne ne null}">
			<c:forEach items="${arrOne}" var="a">
				<!-- 循环代码 -->
				<div class="layui-col-sm4" style="z-index:0">
					<div class="layui-card">
						<!-- 轮播内容头部 -->
						<div class="layui-card-header">
							轮播内容 <span class="layui-badge layui-bg-cyan layuiadmin-badge">${a.indexId}</span>
						</div>
						<!-- 轮播内容主体 -->
						<div class="layui-card-body">
							<!-- 轮播主图 -->
							<img src="../${a.imageSrc}" height="100%"
								width="100%" style="max-height:200px;min-height:100px;">
							<div class="layui-card-body layui-form layui-form-pane">
								<!-- 轮播标题 -->
								<div class="layui-form-item" style="margin:21px 0px 0px 0px">
									<label class="layui-form-label">标题</label>
									<div class="layui-input-block">
										<input type="text" value="${a.indexTitle}" name="title" required="" lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" disabled>
									</div>
								</div>
								<!-- 定向页面 -->
								<div class="layui-form-item" style="margin:21px 0px 0px 0px">
									<label class="layui-form-label">网页</label>
									<div class="layui-input-block">
										<input type="text" value="${a.indexUrl}" name="title" required="" lay-verify="required" placeholder="请输入定向网页" autocomplete="off" class="layui-input" disabled>
									</div>
								</div>
								<!-- 上传图片 -->
								<div class="layui-form-item" style="margin:21px 0px 0px 0px">
									<label class="layui-form-label">图片</label>
									<div class="layui-input-block">
										<input type="text" value="${a.imageSrc}" class="layui-input" placeholder="单击选择要上传的照片" disabled>
									</div>
								</div>
								<!-- 轮播内容 -->
								<div class="layui-form-item layui-form-text"
									style="margin:21px 0px">
									<label class="layui-form-label">描述</label>
									<div class="layui-input-block">
										<textarea name="desc" value="${a.indexDesc}" placeholder="请输入内容" class="layui-textarea" disabled>${a.indexDesc}</textarea>
									</div>
								</div>
								<!-- 上传数据 -->
								<div class="layui-form-item" style="margin:10px 0px 0px 0px">
									<button class="layui-btn layui-btn-fluid btnToUpd" lay-filter="add" lay-submit="" i="${a.indexId}">修改</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 循环一组代码结束 -->
			</c:forEach>
			<!-- 销毁会话中的数据 -->
			<c:remove var="arrOne"/>
		</c:if>
	</div>

</body>
</html>
