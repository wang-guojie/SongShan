package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.InFormAtion;
import entity.Page;
import service.impl.InFormAtionServiceImpl;

public class AdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String op = request.getParameter("op");

		InFormAtionServiceImpl ifnos = new InFormAtionServiceImpl();
		InFormAtion at = new InFormAtion();

		if (op.equals("search") || op == null) {
			List<InFormAtion> list = ifnos.search();
			request.setAttribute("list", list);
			request.getRequestDispatcher("zixun.jsp")
					.forward(request, response);
		} else if (op.equals("fenye")) {
			Page page = new Page();
			// 每页显示5条
			page.setPageSize(5);
			page.setDataCount(ifnos.getAllCount());
			int index = Integer.parseInt(request.getParameter("index"));
			page.setPageIndex(index);
			page.setList(ifnos.list(page));
			request.setAttribute("page", page);
			request.getRequestDispatcher("zixun.jsp").forward(request, response);
		} else if (op.equals("All")) {
			int id = Integer.parseInt(request.getParameter("id"));
			InFormAtion list = ifnos.getById(id);

			request.setAttribute("list", list);
			request.getRequestDispatcher("All.jsp").forward(request, response);
		}

		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
