<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<title>layui</title>
<!-- css -->
<link rel="stylesheet" href="css/layui.css">
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<!-- js -->
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="js/xadmin.js"></script>
<script src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="lib/layui/lay/modules/form.js"></script>
</head>

<body>

	<!-- 跳转按钮 -->
	<button type="button" class="layui-btn" id="back_btn" onclick="back_btn()">返回</button>
	<!-- 数据 -->
	<div id="ccc"></div>
	
	<table id="demo" lay-filter="test"></table>
	
	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-sm" lay-event="del" onclick="upd()"><i class="layui-icon">&#xe642;</i></a>
	</script>

	<script>
		layui.use('table', function(){
			var table = layui.table;
		  	// 动态加载
			table.render({
			    elem: '#demo' // 绑定控件
				,url: 'GoodsServlet?op=serach&state=2' // 数据接口
			    ,cols: [[ // 表头
			       {field: 'goodName', title: '商品名称'}
			      ,{field: 'typeName', title: '商品类型', templet: '<div>{{d.type.name}}</div>'}
			      ,{field: 'inventory', title: '库存'}
			      ,{field: 'money', title: '金额'}
			      ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
			    ]]
			  ,title: '用户预订信息'
			  ,autoSort: true // 自动排序
			  ,page: true // 开启分页
			  ,limit: 15 // 分页数据量
			  ,toolbar: true // 显示工具栏
			  ,defaultToolbar: ['exports' ,'print'] // 导出/打印
		  });
		});
	</script>
	
	<script>
		
		// 修改
		function upd(){
			layui.use('table', function(){
				// 创建table
				var table = layui.table;
				// 监听
				table.on('tool(test)', function(obj){ // test是table的属性 lay-filter="test"
					var data = obj.data; // 获得当前行数据
					var id = data['id'];  // 获取属性id的值
					$.post(
						"GoodsServlet",
						"op=updState&id="+id+"&state=1",
						function(data){
							if (data == "1") {
								layer.msg("恢复成功！");
								// 模拟点击
							    $(".layui-laypage-btn").click();
							} else {
								layer.msg("恢复失败！");
							}
						},
						"Text"
					);
				});
			});
		}
		
		// 返回页面
		function back_btn(){
			location.href = 'goods.jsp';
		}
		
	</script>

</body>
</html>