package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.CarouselServiceImpl;

import com.alibaba.fastjson.JSON;

import dao.impl.TicketDaoImpl;
import entity.Carousel;

public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 核心对象
		CarouselServiceImpl isi = new CarouselServiceImpl();
		TicketDaoImpl tdi = new TicketDaoImpl();
		
		request.getSession().setAttribute("dayCount", tdi.dayCount());
		
		// 获取前台的操作项
		String op = request.getParameter("op");
		// 分配操作项
		if (op == null || op.equals("serach")) {
			// 显示全部轮播内容
			// 获取全部内容，存储到List中
			List<Carousel> arrOne = isi.arrSell(1);
			List<Carousel> arrTwo = isi.arrSell(2);
			request.setAttribute("arrOne", arrOne);
			request.setAttribute("arrTwo", arrTwo);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (op.equals("upd")) {
			// ....
			
		} else {
			
		}
		out.flush();
		out.close();
	}

}
