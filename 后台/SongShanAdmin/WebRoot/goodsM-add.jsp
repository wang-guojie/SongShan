<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
<!-- css -->
<link rel="stylesheet" href="css/layui.css">
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<!-- js -->
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="js/xadmin.js"></script>
<script src="js/jquery-1.12.4.js"></script>
</head>

<body>

	<!-- 修改数据页 -->
	<div class="layui-col-sm4" id="fixed" style="width: 600px">
		<div class="layui-card layui-anim layui-anim-scaleSpring" id="home">
			<!-- 内容头部 -->
			<div class="layui-card-header">
				增加套票
			</div>
			<!-- 内容主体 -->
			<div class="layui-card-body" style="text-align: center; width: 95%;">
				<div class="layui-card-body layui-form layui-form-pane"">
					<!-- 套票主图 -->
					<img src="../upload/2-1504099430804.jpg" id="imgSrc"
						style="max-height:200px;">
					<!-- 套票名称 -->
					<div class="layui-form-item" style="margin:21px 0px 0px 0px">
						<label class="layui-form-label">套票名称：</label>
						<div class="layui-input-block">
							<input type="text" value="" id="name" required=""
								lay-verify="required" placeholder="请输入套票名称" autocomplete="off"
								class="layui-input">
						</div>
					</div>

					<!-- 套票选项 -->
					<div class="layui-card" style="margin-top:15px">
						<div class="layui-card-body">
							<c:forEach items="${arr}" var="a">
								<input type="checkbox" name="goodsId" value="${a.id}"
									title="${a.goodName}" money="${a.money}">
							</c:forEach>
						</div>
					</div>

					<!-- 套票价格 -->
					<div class="layui-form-item" style="margin:21px 0px 0px 0px">
						<label class="layui-form-label">套票价格：</label>
						<div class="layui-input-block">
							<input type="number" min="0" value="" id="money" lay-verify="required"
								placeholder="请输入套票价格" class="layui-input">
						</div>
					</div>
					<!-- 库存数量 -->
					<div class="layui-form-item" style="margin:21px 0px 0px 0px">
						<label class="layui-form-label">库存数量：</label>
						<div class="layui-input-block">
							<input class="layui-input" value="" id="inventory" type="number"
								min="0" max="99999" step="1" data-prec="4"> </
						</div>
					</div>
					<!-- 上传图片 -->
					<div class="layui-form-item" style="margin:21px 0px 0px 0px">
						<label class="layui-form-label">套票图片</label>
						<div class="layui-input-block">
							<input type="file" class="layui-input" name="file"
								accept="image/*" id="fileField"
								style="position: absolute;filter: alpha(opacity : 0);opacity: 0;"
								onchange="document.getElementById('textfield').value=this.value;look()">
							<input type="text" value="" id="textfield" class="layui-input"
								disabled>
						</div>
					</div>
					<!-- 套票描述 -->
					<div class="layui-form-item layui-form-text"
						style="margin:21px 0px">
						<label class="layui-form-label">套票描述</label>
						<div class="layui-input-block">
							<textarea name="desc" value="" id="desc" placeholder="请输入套票描述"
								class="layui-textarea"></textarea>
						</div>
					</div>
					<!-- 上传数据 -->
					<div class="layui-form-item" style="margin:10px 0px 0px 0px">
						<button type="button" id="btnAdd"
							class="layui-btn layui-btn-fluid">
							<i class="layui-icon">&#xe605;</i>
						</button>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- 销毁会话中的数据 -->
	<c:remove var="arr" />


</body>
</html>

<script>
	layui.use('form', function() {
		var form = layui.form;
		form.render();
		
		// 计算价格
		form.on('checkbox', function(data){
			// 获取价格
			var goodMoney = parseInt($(data.elem).attr("money"));
			// 获取全部金额
			var money = $("#money").val();
			money = money == "" ? "0" : money;
			money = parseInt(money);
			//是否被选中，true或者false
			if (data.elem.checked) {
				money += goodMoney;
			} else {
				money -= goodMoney;
			}
			$("#money").val(money);
			
			// 获取名称
			var names = document.getElementsByName("goodsId");
			var text = "";
			// 判断是否选中
			for (var int = 0; int < names.length; int++) {
				if (names[int].checked) {
					text += $(names[int]).attr("title") + " x1\n";
				}
			}
			// 刷新数据
			$("#desc").val(text);
			
		});
	});
	
	// 查重
	var nameTF = false;
	$("#name").blur(function(){
		var name = $("#name").val();
		$.post(
			"GoodsMServlet",
			"op=nameCount&name="+name,
			function(data){
				if (data == 1) {
					nameTF = true;
				} else {
					nameTF = false;
				}
			},
			"text"
		);
	});

	// 更新
	$(document).on(
			"click",
			"#btnAdd",
			function() {
				// 获取数据
				// 验证数据
				// 商品名称
				var name = $("#name").val();
				if (name == "") {
					layer.msg('商品名称不能为空');
					return false;
				}
				// 查重
				if (nameTF) {
					layer.msg('商品名称不能重复');
					return false;
				}
				// 商品金额
				var money = $("#money").val();
				if (money == "") {
					layer.msg('商品金额不能为空');
					return false;
				}
				// 商品库存
				var inventory = $("#inventory").val();
				if (inventory == "") {
					layer.msg('商品数量不能为空');
					return false;
				}
				// 商品内容
				var desc = $("#desc").val();
				if (desc == "") {
					layer.msg('商品内容不能为空');
					return false;
				}
				
				var goodsId = "";
				// 套票集合
				var goods = document.getElementsByName("goodsId");
				for (var int = 0; int < goods.length; int++) {
					if (goods[int].checked) {
						goodsId += $(goods[int]).val() + ",";
					}
				}
				if (goodsId == "") {
					layer.msg('请为套票选择商品');
					return false;
				}
				
				layer.msg("保存中...");
				// 上传图片
				uploadImg();
				// 图片地址
				var imgSrc = $("#imgSrc").attr("src");
				// post
				$.post("GoodsMServlet", "op=insert&goodsId=" + goodsId + "&name=" + name + "&desc=" + desc
						+ "&inventory=" + inventory + "&imgSrc=" + imgSrc
						+ "&money=" + money, function(data) {
					if (data == "1") {
						// 设置信号
						sessionStorage.setItem("goodsMUpd", "1");
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index); //再执行关闭  
					} else {
						layer.msg("新增失败！");
					}
				}, "Text");

			});

	// 获取数据的URL地址
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
	$(document).on("click", ".btnLook", function() {
		look(this);
	});

	// 图片预览
	function look() {
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
		$("#imgSrc").attr("src", createObjectURL(file));
		return true;
	}

	// 图片上传至服务器
	function uploadImg() {
		// 更新
		if (!look()) {
			return false;
		}
		// 表单数据
		var fd = new FormData();
		fd.append("myPhoto", document.getElementById("fileField").files[0]);
		// 执行上传操作
		var xhr = new XMLHttpRequest();
		xhr.open("post", "Upload", false);
		// 设置 HTTP 头，数据指定为 JSON 格式
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				var flag = xhr.responseText;
				if (flag != null) {
					$("#imgSrc").attr("src", flag);
				}
			}
		}
		// 执行发送        
		xhr.send(fd);
	}

	// 新增套票页
</script>
