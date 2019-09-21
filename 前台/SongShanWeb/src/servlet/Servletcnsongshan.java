package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.guidebookServerImpl;
import service.impl.ticketstypeServerImpl;
import entity.Page;
import entity.guidebook;
import entity.ticketstype;

public class Servletcnsongshan extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		guidebookServerImpl gl=new guidebookServerImpl();
		ticketstypeServerImpl tl=new ticketstypeServerImpl();
		
		String op=request.getParameter("op");
		if(op.equals("serach")){
			
			String name=request.getParameter("serachname");
			name=name==null?"":name;
			List<guidebook> list=gl.list(name);
			request.setAttribute("list", list);
			request.getRequestDispatcher("select.jsp").forward(request, response);
		
		}else if(op.equals("toadd")){
			List<ticketstype> list=tl.GetByAll();
			request.setAttribute("clist", list);
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}else if(op.equals("toupdate")){
			int id=Integer.parseInt(request.getParameter("id"));
			guidebook g=gl.GetById(id);
			request.setAttribute("g", g);
			
			List<ticketstype> list=tl.GetByAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}else if(op.equals("add")){
			String ticketsname=request.getParameter("ticketsname");
			float ticketsprice=Float.parseFloat(request.getParameter("ticketsprice"));
			int ticketstype=Integer.parseInt(request.getParameter("ticketstype"));
			String remark=request.getParameter("remark");
			String transport=request.getParameter("transport");
			String imagesrc=request.getParameter("imagesrc");
			guidebook g=new guidebook();
			g.setTicketsname(ticketsname);
			g.setTicketsprice(ticketsprice);
			g.setTicketstype(ticketstype);
			g.setRemark(remark);
			g.setTransport(transport);
			g.setImagesrc(imagesrc);
			int result=gl.add(g);
			if(result>0){
				request.getSession().setAttribute("result", "添加成功");
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}else{
				request.getSession().setAttribute("result", "添加失败");
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}
		}else if(op.equals("update")){
			int ticketsid=Integer.parseInt(request.getParameter("ticketsid"));
			String ticketsname=request.getParameter("ticketsname");
			float ticketsprice=Float.parseFloat(request.getParameter("ticketsprice"));
			int ticketstype=Integer.parseInt(request.getParameter("ticketstype"));
			String remark=request.getParameter("remark");
			String transport=request.getParameter("transport");
			String imagesrc=request.getParameter("imagesrc");
			
			guidebook g=new guidebook();
			g.setTicketsid(ticketsid);
			g.setTicketsname(ticketsname);
			g.setTicketsprice(ticketsprice);
			g.setTicketstype(ticketstype);
			g.setRemark(remark);
			g.setTransport(transport);
			g.setImagesrc(imagesrc);
			
			int result=gl.update(g);
			if(result>0){
				out.print("<script>alert('修改成功');location.replace('select.jsp');</script>");
			}else{
				out.print("<script>alert('修改失败');location.replace('select.jsp');</script>");
			}
			
		}else if(op.equals("del")){
			int id=Integer.parseInt(request.getParameter("id"));
			int count=gl.delete(id);
			out.print("{\"count\":\""+count+"\"}");
		}else if(op.equals("fenye")){
			Page p=new Page();
			p.setPageSize(2);
			p.setDataCount(gl.GetByAll());
			int index=Integer.parseInt(request.getParameter("index"));
			p.setPageIndex(index);
			p.setList(gl.list(p));
			request.setAttribute("page", p);
			request.getRequestDispatcher("fenye.jsp").forward(request, response);
		}
		
		out.flush();
		out.close();
	}

}
