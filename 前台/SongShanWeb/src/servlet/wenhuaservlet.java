package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.wenhuascrviceimpl;
import entity.wenhua;

public class wenhuaservlet extends HttpServlet {

	
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
		wenhuascrviceimpl wh=new wenhuascrviceimpl();
		if(op==null||op.equals("search")){
			List<wenhua> list=wh.getAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("songshanwenhua.jsp").forward(request, response);
		}else if(op.equals("toadd")){
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
		else if(op.equals("add")){
			String culturename=request.getParameter("culturename");
			String cultureexplanation=request.getParameter("cultureexplanation");
			String imagesrc=request.getParameter("imagesrc");
			wenhua w=new wenhua();
			w.setCulturename(culturename);
			w.setCultureexplanation(cultureexplanation);
		
			int result=wh.add(w);
			if(result>0){
				out.print("<script>alert('新增成功');location.href='songshanwenhua.jsp'</script>");
			}else {
				
				out.print("<script>alert('新增失败');location.href='songshanwenhua.jsp'</script>");
			}
		}else if(op==null||op.equals("searchgl")){
			List<wenhua> list=wh.getAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("index2.jsp").forward(request, response);
		}/*else if(op.equals("toupdate")){
			Integer id=Integer.parseInt(request.getParameter("cultureid"));
			wenhua p=wh.checkname(id);
			request.setAttribute("p", p);
			request.getRequestDispatcher("wenhuaupdatete.jsp").forward(request, response);
		}else if(op.equals("update")){
			Integer cultureid=Integer.parseInt(request.getParameter("cultureid"));
			String culturename=request.getParameter("culturename");
			String cultureexplanation=request.getParameter("cultureexplanation");
	
			
			wenhua w=new wenhua();
			w.setCultureid(cultureid);
			w.setCulturename(culturename);
			w.setCultureexplanation(cultureexplanation);
			int result=wh.update(w);
			
			if(result>0){
				out.print("<script>alert('修改成功');location.href='songshanwenhua.jsp'</script>");
			}else {
				
				out.print("<script>alert('修改失败');location.href='songshanwenhua.jsp'</script>");
			}	
			
		}*/if(op.equals("del")){
			Integer cultureid=Integer.parseInt(request.getParameter("cultureid"));
			int result=wh.delete(cultureid);
			
			if(result>0){
				out.print("<script>alert('删除成功');location.href='songshanwenhua.jsp'</script>");
			}else {
				
				out.print("<script>alert('删除失败');location.href='songshanwenhua.jsp'</script>");
			}	
		}else if(op.equals("xiangxi")){
			request.getRequestDispatcher("wenhuafojiao.jsp").forward(request, response);
		}else if(op.equals("daojiao")){
			request.getRequestDispatcher("wenhuadao.jsp").forward(request, response);
		}
		else if(op.equals("daowen")){
			request.getRequestDispatcher("wenhuaru.jsp").forward(request, response);
		}
		out.flush();
		out.close();
	}

}
