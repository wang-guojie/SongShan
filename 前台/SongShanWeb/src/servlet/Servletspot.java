package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.spotServerImpl;
import entity.Page;
import entity.spot;

public class Servletspot extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		spotServerImpl sl=new spotServerImpl();
		
		String op=request.getParameter("op");
		if(op.equals("seach")){
			String name=request.getParameter("seachname");
			name=name==null?"":name;
			List<spot> list=sl.list(name);
			request.setAttribute("list", list);
			request.getRequestDispatcher("sj.jsp").forward(request, response);		
		}else if(op.equals("toupdate")){
			int id=Integer.parseInt(request.getParameter("id"));
			spot s=sl.GetById(id);
			request.setAttribute("s", s);
			request.getRequestDispatcher("update2.jsp").forward(request, response);
		}else if(op.equals("add")){
			String spotname=request.getParameter("spotname");
			String spotcontext=request.getParameter("spotcontext");
			String imagesrc=request.getParameter("imagesrc");
			spot s=new spot();
			s.setSpotname(spotname);			
			s.setSpotcontext(spotcontext);
			s.setImagesrc(imagesrc);
			int result=sl.add(s);
			if(result>0){
				request.getSession().setAttribute("result", "添加成功");
				request.getRequestDispatcher("index2.jsp").forward(request, response);
			}else{
				request.getSession().setAttribute("result", "添加失败");
				request.getRequestDispatcher("index2.jsp").forward(request, response);
			}
		}else if(op.equals("del")){
			int id=Integer.parseInt(request.getParameter("id"));
			int count=sl.delete(id);
			out.print("{\"count\":\""+count+"\"}");
		}else if(op.equals("update2")){
			int spotid=Integer.parseInt(request.getParameter("spotid"));
			String spotname=request.getParameter("spotname");
			String spotcontext=request.getParameter("spotcontext");
			String imagesrc=request.getParameter("imagesrc");
			spot s=new spot();
			s.setSpotid(spotid);
			s.setSpotname(spotname);
			s.setSpotcontext(spotcontext);
			s.setImagesrc(imagesrc);
			int result=sl.update(s);
			if(result>0){
				out.print("<script>alert('修改成功');location.replace('index2.jsp');</script>");
			}else{
				out.print("<script>alert('修改失败');location.replace('index2.jsp');</script>");
			}
		}else if(op.equals("fenye")){
			Page p=new Page();
			p.setPageSize(2);
			p.setDataCount(sl.GetByAll());
			int pageIndex=Integer.parseInt(request.getParameter("index"));
			p.setPageIndex(pageIndex);
			p.setList(sl.list(p));
			request.setAttribute("page", p);
			request.getRequestDispatcher("fen.jsp").forward(request, response);
		}else if(op.equals("chname")){
			String name=request.getParameter("name");
			int c=sl.chname(name);
			out.print("{\"c\":\""+c+"\"}");
		}
		
		out.flush();
		out.close();
	}

}
