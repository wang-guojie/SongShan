<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC -//W3C//DTD HTML 4.01 Transitional//EN>
<html>
<head></head>
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<link rel="stylesheet" href="css/index-carousel.css">
<script type="text/javascript" src="js/xadmin.js"></script>
<script src="js/jquery-1.12.4.js"></script>
<script src="./lib/layui/layui.js"></script>

<body>

	<c:if test="${arrTwo ne null}">
		<h1><hr></h1>
		<div class="layui-card-body">
			<table class="layui-table layui-form">
				<thead>
					<tr>
						<th><input type="checkbox" lay-filter="checkall" name="" lay-skin="primary"></th>
						<th>首页标题</th>
						<th>首页内容</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach items="${arrTwo}" var="a">
						<tr>
							<td></td>
							<td>${a.indexTitle}</td>
							<td>${a.indexDesc}</td>
							<td>
								<div class="layui-btn-group">
								 	<button type="button" class="layui-btn layui-btn-sm btnToAdd">增加</button>
								 	<button type="button" class="layui-btn layui-btn-sm btnToUpd" i="${a.indexId}">编辑</button>
								  	<button type="button" class="layui-btn layui-btn-sm btnToDel" i="${a.indexId}">删除</button>
								</div>
							</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
		<!-- 销毁会话中的数据 -->
		<c:remove var="arrTwo"/>
	</c:if>

</body>
</html>
