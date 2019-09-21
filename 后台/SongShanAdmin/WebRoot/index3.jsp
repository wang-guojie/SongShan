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
</head>

<c:if test="${page eq null}">
	<script>
		location.href = "Servletspot?op=seach";
	</script>
</c:if>
<body>
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
							<div class="layui-inline layui-show-xs-block">
								<form action="Servletspot?op=seach" method="post">
									<input type="text" name="seachname" placeholder="请输入要查询的景区名称">
									<input type="submit" value="查询" />
									<a href="adds.jsp">添加</a>
								</form>
							</div>
							
					</div>
				</div>
				<div class="layui-card-body ">
					<table class="layui-table layui-form">
						<thead>
							<tr>
								
								<th>名称</th>
								<th>景区信息</th>
							
								<th>操作</th>
						</thead>
						<tbody>
							<c:forEach items="${page.list}" var="c">
								<tr>
									
									<td>${c.spotname}</td>

									<td>${c.spotcontext}</td>

									
									<td class="td-manage"> <a title="编辑"
										class="layui-btn layui-btn-sm" lay-event="upd"
										onclick="xadmin.open('更新资讯', 'Servletspot?op=toupdate&id=${ c.spotid }',600,400)">
											<i class="layui-icon">&#xe642;</i>
									</a> <a title="删除" class="layui-btn layui-btn-sm" lay-event="del"
										onclick="del(${ c.spotid },this);" href="javascript:;">
											<i class="layui-icon">&#xe640;</i>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				 <div id="fenye">

					<c:if test="${ page.pageIndex!=1 }">
						<a
							href="Servletspot?op=seach&index=1&seachname=${name}"
							class="layui-btn">首页</a>
					</c:if>
					<a
						href="Servletspot?op=seach&index=${page.pageIndex-1}&seachname=${name}" class="layui-btn">上一页</a> 
						<a href="Servletspot?op=seach&index=${page.pageIndex+1}&seachname=${name}"
						class="layui-btn">下一页</a>
					<c:if test="${ page.pageIndex!=page.dataCount }">
						<a
							href="Servletspot?op=seach&index=${ page.dataCount }&seachname=${name}"
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
<script src="jquery-1.12.4.js"></script>
<script>


function del(id,a){
        		if(confirm("是否删除")){
        			$.post(
        				"Servletspot",
        				"op=del&id="+id,
        				function(r){
        					if(r.count=="1"){
        						alert("删除成功");
        						$(a).parent().parent().remove();
        						
        					}else{
        						alert("删除失败");
        					}
        				},"json"
        			)
        		}
        	}


	layui.use([ 'laydate', 'form' ], function() {
		var laydate = layui.laydate;
		var form = layui.form;

		//执行一个laydate实例
		laydate.render({
			elem : '#start' //指定元素
		});

		//执行一个laydate实例
		laydate.render({
			elem : '#end' //指定元素
		});
	});

	/*用户-停用*/
	function member_stop(obj, id) {
		layer.confirm('确认要停用吗？', function(index) {

			if ($(obj).attr('title') == '启用') {

				//发异步把用户状态进行更改
				$(obj).attr('title', '停用')
				$(obj).find('i').html('&#xe62f;');

				$(obj).parents("tr").find(".td-status").find('span').addClass(
						'layui-btn-disabled').html('已停用');
				layer.msg('已停用!', {
					icon : 5,
					time : 1000
				});

			} else {
				$(obj).attr('title', '启用')
				$(obj).find('i').html('&#xe601;');

				$(obj).parents("tr").find(".td-status").find('span')
						.removeClass('layui-btn-disabled').html('已启用');
				layer.msg('已启用!', {
					icon : 5,
					time : 1000
				});
			}

		});
	}

	
</script>
<script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script>
</html>