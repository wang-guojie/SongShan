<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html class="x-admin-sm">
    <head>
          <style>
        	#d1{
        		width:800px;
        		margin: opx auto;
        		
        	}
        </style>        
    </head>

    <body>
       <div id=d1>
       <div id="msg"></div>
       <c:if test="${ page eq null }">
       		<script>
       			location.href="Servletspot?op=fenye&index=1";
       		</script>
       		
       </c:if>
       <form action="Servletspot?op=seach" method="post">
       			<input type="text" name="seachname" />
       			<input type="submit" value="查询" />
       			<a href="Servletspot?op=toadd">增加</a>
       			<a href="index2.jsp">退出分页</a>
       		</form>
       <table width="600px" border="1">
       		<tr>
       			<td>景区ID</td>
       			<td>景区名称</td>
       			
       			<td>景区信息</td>
       			
       			<td>景区图片</td>
       			<td>操作</td>       			
       		</tr>
       		<c:forEach items="${page.list}" var="c">
       			<tr>
       				<td>${c.spotid}</td>
       				<td>${c.spotname}</td>
       				
       				<td>${c.spotcontext}</td>
       				
       				<td>${c.imagesrc}</td>
       				<td>
       					<a href="#" onclick="del(${ c.spotid },this)">删除</a>
       					<a href="Servletspot?op=toupdate&id=${ c.spotid }">修改</a>
       				</td>
       			</tr>
       		</c:forEach>
       		</div>
       </table>  
       <a href="Servletspot?op=fenye&index=1">首页</a> 
       <a href="Servletspot?op=fenye&index=${ page.pageIndex-1 }">上一页</a>  
       <a href="Servletspot?op=fenye&index=${ page.pageIndex+1 }">下一页</a>  
       <a href="Servletspot?op=fenye&index=${ page.pageCount }">尾页</a>                                         
</html>
<script src="jquery-1.12.4.js"></script>
       <script>
        $(function(){
        		$("tr:even").css("backgrand-colok","red");
        		$("tr:eq(0)").css("backgrand-colok","blue");
        });
        
        	function del(id,a){
        		if(confirm("是否删除")){
        			$.post(
        				"Servletspot",
        				"op=del&id="+id,
        				function(r){
        					if(r.count=="1"){
        						$("#msg").html("删除成功");
        						$(a).parent().parent().remove();
        						$("tr:eq(0)").css("backgrand-colok","white");
        						$("tr:even").css("backgrand-colok","red");
        						$("tr:eq(0)").css("backgrand-colok","blue");
        					}else{
        						$("#msg").html("删除成功");
        					}
        				},"json"
        			)
        		}
        	}
        	
        </script>