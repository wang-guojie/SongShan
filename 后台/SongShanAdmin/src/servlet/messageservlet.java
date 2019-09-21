package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.messagesimpl;
import entity.Page;
import entity.message;

public class messageservlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String op=request.getParameter("op");
		messagesimpl  me=new messagesimpl();
		
		
		if(op==null||op.equals("search")){
			//獲取查詢名稱
			String name=request.getParameter("searchname");
			name=name==null?"":name;
			name=new String(name.getBytes("iso-8859-1"),"utf-8");
			request.setAttribute("name", name);

			
			Page p=new Page();
			p.setPageSize(6);
			p.setDataCount(me.getAllCount(name));
			//獲取查詢下標
			String pageindex=request.getParameter("index");
			int index=pageindex==null?1:Integer.parseInt(pageindex);
			p.setPageIndex(index);
			
			
			me.getPage(p,name);
			
			request.setAttribute("page",p);
			request.getRequestDispatcher("liuyanShow.jsp").forward(request, response);
			
			
			//request.getSession().setAttribute("list", list);
			//response.sendRedirect("admin-add.jsp");
		}else if(op.equals("toadd")){
			request.getRequestDispatcher("liuyanadd.jsp").forward(request, response);
		}
		else if(op.equals("add")){
			String titlename=request.getParameter("titlename");
			String context=request.getParameter("context");
			String messagetime=request.getParameter("messagetime");
			message mes=new message();
			mes.setTitlename(titlename);
			mes.setContext(context);
			mes.setMessagetime(messagetime);
			int result=me.add(mes);
			if(result>0){
				out.print("<script>alert('新增成功')</script>");
			}else {
				
				out.print("<script>alert('新增失败')</script>");
			}
		}else if(op.equals("del")){
			int id=Integer.parseInt(request.getParameter("id"));
			int result=me.delete(id);
			if(result>0){
				out.print("<script>alert('删除成功');location.href='liuyanShow.jsp'</script>");
			}else {
				
				out.print("<script>alert('删除失败');location.href='liuyanShow.jsp'</script>");
			}
		}else if(op.equals("toupdate")){
			int id=Integer.parseInt(request.getParameter("messageid"));
			message p=me.checkname(id);
			request.setAttribute("p", p);
			request.getRequestDispatcher("liuyanupdate.jsp").forward(request, response);
			
		}else if(op.equals("update")){
			int id=Integer.parseInt(request.getParameter("messageid"));
			String titlename=request.getParameter("titlename");
			String context=request.getParameter("context");
			String messagetime=request.getParameter("messagetime");
			
			message mes=new message();
			mes.setMessageid(id);
			mes.setTitlename(titlename);
			mes.setContext(context);
			mes.setMessagetime(messagetime);
			int result=me.update(mes);
			if(result>0){
				out.print("<script>alert('修改成功');location.href='liuyanShow.jsp'</script>");
			}else {
				
				out.print("<script>alert('修改失败');location.href='liuyanShow.jsp'</script>");
			}
		}
		out.flush();
		out.close();
	}

}
