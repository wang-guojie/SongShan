<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

</head>

<body id="about">

		<div class="main_right">
			<h1>文化修改</h1>
			<form action="messageservlet?op=update" method="post">
				<table id="ta" border="1" width="600" px>
					<tr>
					<td>标题：</td>
					<td><input type="text" name="titlename" value="${p.titlename}"></td>
					<td><input type="hidden" name="messageid" value="${p.messageid}"></td>
					</tr>
					
					
					<tr>
					<td>内容：</td>
					<td><input type="text" name="context" value="${p.context}"></td>
					</tr>
					
					<tr>
					<td>时间：</td>
					<td><input type="text" name="messagetime" value="${p.messagetime}"></td>
					</tr>
					
					
					<tr>
					
					<td colspan="2" ><input type="submit"  value="提交"></td>
					</tr>
				</table>
				
			</form>
		
		</div>

		
</body>

</html>
<script src="jquery-1.12.4.js"></script>
<script>

$("#xz").css("color","red");
$("#xz").css("font-size","30px");
$("#ta").css("font-size","15px");
</script>