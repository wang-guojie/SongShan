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
	
	<div style="margin-top: 10px">
		<!-- 跳转按钮 -->
		<button type="button" class="layui-btn" id="back_btn" onclick="back_btn()">
			恢复数据
		</button>
		<button type="button" class="layui-btn" id="back_btn" onclick="add()">
			新增数据
		</button>
	</div>
    
	
	
	<!-- 数据 -->
	<div id="ccc"></div>
	
	<table id="demo" lay-filter="test"></table>
	
	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-sm" lay-event="del" onclick="upd()"><i class="layui-icon">&#xe642;</i></a>
		<a class="layui-btn layui-btn-sm" lay-event="del" onclick="del(this)"><i class="layui-icon">&#xe640;</i></a>
	</script>

	<script>
		layui.use('table', function(){
			var table = layui.table;
		  	// 动态加载
			table.render({
			    elem: '#demo' // 绑定控件
				,url: 'GoodsMServlet?op=serach&state=1' // 数据接口
			    ,cols: [[ // 表头
			       {field: 'id', title: '商品ID', hide: 'true'}
			      ,{field: 'goodName', title: '商品名称'}
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
		
		// 删除
		function del(This){
			layui.use('table', function(){
				// 创建table
				var table = layui.table;
				// 监听
				table.on('tool(test)', function(obj){ // test是table的属性 lay-filter="test"
					var data = obj.data; // 获得当前行数据
					var id = data['id'];  // 获取属性id的值
					$.post(
						"GoodsMServlet",
						"op=updState&id="+id+"&state=2",
						function(data){
							if (data == "1") {
								layer.msg("删除成功！");
								// 模拟点击
							    $(".layui-laypage-btn").click();
							} else {
								layer.msg("删除失败！");
							}
						},
						"Text"
					);
				});
			});
		}
		
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
						"GoodsMServlet",
						"op=toUpdate&id="+id,
						function(data){
							if (data == "ok") {
								layer.open({
								  type: 2, 
								  shade:0.1, //遮罩层透明度
								  area:['610px','700px'], //弹出层宽高
								  title:'商品信息修改',//弹出层标题
								  content: 'goodsM-update.jsp',
								  cancel: function(index, layero){ 
									    layer.close(index);
									    // 模拟点击
									    $(".layui-laypage-btn").click();
								  },
								  end : function() {
										// 模拟点击
										$(".layui-laypage-btn").click();
										// 验证信号是否存在
										if (sessionStorage.getItem("goodsMUpd") == "1") {
											layer.msg("修改成功！");
											// 清除信号
											sessionStorage.removeItem("goodsMUpd");
										}
									}
								});
							} else {
								layer.msg("修改失败！");
							}
						},
						"Text"
					);
				});
			});
		}
		
		// 新增
		function add(){
			layui.use('table', function(){
				// 创建table
				var table = layui.table;
				// 监听
				$.post(
						"GoodsMServlet",
						"op=toInsert",
						function(data){
							if (data == "ok") {
								layer.open({
								  type: 2, // Layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
								  shade:0.1, // 遮罩层透明度
								  area:['610px','700px'], // 弹出层宽高
								  title:'商品信息修改',// 弹出层标题
								  content: 'goodsM-add.jsp',
								  cancel: function(index, layero){ 
									    layer.close(index);
									    // 模拟点击
									    $(".layui-laypage-btn").click();
								  },
								  end : function() {
										// 模拟点击
										$(".layui-laypage-btn").click();
										// 验证信号是否存在
										if (sessionStorage.getItem("goodsMAdd") == "1") {
											layer.msg("新增成功！");
											// 清除信号
											sessionStorage.removeItem("goodsMAdd");
										}
									}
								});
							} else {
								layer.msg("新增失败！");
							}
						},
						"Text"
					);
			});
		}
		
		// 显示恢复页面
		function back_btn(){
			location.href = 'erroGoodsM.jsp';
		}
		
	</script>

</body>
</html>