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
<script src="./lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

<style>
</style>
</head>

<body>
	<c:if test="${empty page}">
		<script>
			location.href = "AdminServlet?op=search";
		</script>
	</c:if>
	<div class="x-nav">
		</span> <a class="layui-btn layui-btn-small"
			style="line-height:1.6em;margin-top:3px;float:right"
			onclick="location.reload()" title="刷新"> <i
			class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
	</div>
	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md12">
				<div class="layui-card">
					<div class="layui-card-body ">
						<form class="layui-form layui-col-space5"
							action="AdminServlet?op=search" method="get">
							<div class="layui-inline layui-show-xs-block">
								<input type="text" name="titlename" id="titlename"
									placeholder="查询标题名" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-inline layui-show-xs-block">
								<select name="city" lay-verify="required" id="city">
									<option value="-1">请选择</option>
									<c:forEach items="${sList}" var="s">
										<option value="${s.scenicid}">${s.scenicname}</option>
									</c:forEach>
								</select>
							</div>
							<input type="submit" value="查询" class="layui-btn" />
						</form>

						<button type="button" class="layui-btn" id="back_btn"
							onclick="xadmin.open('添加资讯','AdminServlet?op=toAdd',1200,700)">添加资讯</button>
					</div>
				</div>
				<div class="layui-card-body layui-table-body layui-table-main">
					<table class="layui-table layui-form">
						<thead>
							<tr>

								<th>新闻标题</th>
								<th>资讯内容</th>
								<th>新闻类型</th>
								<th>资讯日期</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.list}" var="f">
								<tr>
									<td>${f.inforname}</td>
									<td>${f.inforcontent}</td>
									<td>${f.scenic.scenicname}</td>
									<td>${f.infortime}</td>
									<td class="td-manage"><a title="编辑"
										class="layui-btn layui-btn-sm" lay-event="upd"
										onclick="xadmin.open('更新资讯','AdminServlet?op=toUpdate&id=${f.inforid}',1200,700)">
											<i class="layui-icon">&#xe642;</i>
									</a> <a title="删除" class="layui-btn layui-btn-sm" lay-event="del"
										onclick="member_del(this,${f.inforid})" href="javascript:;">
											<i class="layui-icon">&#xe640;</i>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- 分页展示 -->
					<div id="fenye">

						<c:if test="${ page.pageIndex!=1 }">
							<a
								href="AdminServlet?op=search&index=1&titlename=${name}&city=${typeid}"
								class="layui-btn">首页</a>
						</c:if>
						<a
							href="AdminServlet?op=search&index=${ page.pageIndex-1 }&titlename=${name}&city=${typeid}"
							class="layui-btn">上一页</a> <a
							href="AdminServlet?op=search&index=${ page.pageIndex+1 }&titlename=${name}&city=${typeid}"
							class="layui-btn">下一页</a>
						<c:if test="${ page.pageIndex!=page.dataCount }">
							<a
								href="AdminServlet?op=search&index=${ page.dataCount }&titlename=${name}&city=${typeid}"
								class="layui-btn">末页</a>
						</c:if>
						<span>共${ page.dataCount }条记录</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
<script>
	/*用户-删除*/
	function member_del(obj, id) {
		layer.confirm('确认要删除此条资讯吗？', function(index) {
			$.post("AdminServlet", "op=del&id=" + id, function() {

				//发异步删除数据
				$(obj).parents("tr").remove();
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
			});

		})
	}

	layui.use([ 'laydate', 'form' ], function() {
		var laydate = layui.laydate;
		var form = layui.form;
		// 监听全选
		form.on('checkbox(checkall)', function(data) {

			if (data.elem.checked) {
				$('tbody input').prop('checked', true);
			} else {
				$('tbody input').prop('checked', false);
			}
			form.render('checkbox');
		});

		//执行一个laydate实例
		laydate.render({
			elem : '#start' //指定元素
		});

		//执行一个laydate实例
		laydate.render({
			elem : '#end' //指定元素
		});

	});
</script>