package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
			List<message> list=me.getAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("liuyana.jsp").forward(request, response);
		}else if(op.equals("toadd")){
			request.getRequestDispatcher("MeasAdd.jsp").forward(request, response);
		}
		else if(op.equals("add")){
			String titlename=request.getParameter("titlename");
			String context=request.getParameter("context");

			message mes=new message();
			mes.setTitlename(titlename);
			mes.setContext(context);
			int result=me.add(mes);
			if(result>0){
				out.print("<script>alert('新增成功');location.href='liuyana.jsp'</script>");
			}else {
				
				out.print("<script>alert('新增失败');location.href='liuyana.jsp'</script>");
			}
		}else if(op==null||op.equals("searchgl")){
			List<message> list=me.getAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("index2.jsp").forward(request, response);
		}else if(op.equals("del")){
			int id=Integer.parseInt(request.getParameter("id"));
			int result=me.delete(id);
			if(result>0){
				out.print("<script>alert('删除成功');location.href='liuyana.jsp'</script>");
			}else {
				
				out.print("<script>alert('删除失败');location.href='liuyana.jsp'</script>");
			}
		}else if(op.equals("fenye")){
			Page p=new Page();
			p.setPageCount(3);
			p.setDataCount(me.count());
			int index=Integer.parseInt(request.getParameter("index"));
			p.setPageIndex(index);
			p.setList(me.page(p));
			request.setAttribute("p", p);
			request.getRequestDispatcher("liuyana.jsp").forward(request, response);
		}
		out.flush();
		out.close();
	}

}
