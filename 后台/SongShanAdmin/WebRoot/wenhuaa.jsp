<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
   <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    
    		<c:if test="${list eq null}">
				<script type="text/javascript">
					location.href = "wenhuaservlet?op=search";
				</script>
			</c:if>
    <body>
        <div class="x-nav">
          
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <button type="button" class="layui-btn" id="back_btn"
							onclick="xadmin.open('添加资讯','wenhuaservlet?op=toadd',600,400)">添加文化</button>
                        </div>
                       <div class="main_right">
                        <div class="layui-card-body layui-table-body layui-table-main">
                        <form action="wenhuaservlet?op=search" method="post">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>標題</th>
                                    <th>内容</th>
                                    <th>操作</th></tr>
                                </thead>
                                <tbody>
                                  <tr>
                                    <c:forEach items="${list}" var="p">
						<tr>
							<td>${p.culturename}</td>
							<td>${p.cultureexplanation}</td>
						<td class="td-manage"> <a title="编辑"
										class="layui-btn layui-btn-sm" lay-event="upd"
										onclick="xadmin.open('更新资讯','wenhuaservlet?op=toupdate&cultureid=${p.cultureid}',600,400)">
											<i class="layui-icon">&#xe642;</i>
									</a> <a title="删除" class="layui-btn layui-btn-sm" lay-event="del"
										onclick="del2(${p.cultureid})" href="javascript:;">
											<i class="layui-icon">&#xe640;</i>
									</a></td>
					</c:forEach>
                                  </tr>
                                </tbody>
                            </table>
                            </form>
                            
                        </div>
                       
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script src="jquery-1.12.4.js"></script>
    <script>
      layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var  form = layui.form;
        


        // 监听全选
        form.on('checkbox(checkall)', function(data){

          if(data.elem.checked){
            $('tbody input').prop('checked',true);
          }else{
            $('tbody input').prop('checked',false);
          }
          form.render('checkbox');
        }); 
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });


      });

    
      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }



      function delAll (argument) {
        var ids = [];

        // 获取选中的id 
        $('tbody input').each(function(index, el) {
            if($(this).prop('checked')){
               ids.push($(this).val())
            }
        });
  
        layer.confirm('确认要删除吗？'+ids.toString(),function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
</html>
<script src="jquery-1.12.4.js"></script>
<script>
function del2(id) {
		if (confirm("是否删除")) {
			location.href = "wenhuaservlet?op=del2&cultureid=" + id;
		}
	}

</script>