package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.Carousel;
import service.impl.CarouselServiceImpl;

public class IndexServlet extends HttpServlet {

	/**
	 * Get请求
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * Post请求
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 核心对象
		CarouselServiceImpl isi = new CarouselServiceImpl();
		// 获取前台的操作项
		String op = request.getParameter("op");
		// 分配操作项
		if (op == null || op.equals("serach")) {
			// 显示全部轮播内容
			// 获取全部内容，存储到List中
			List<Carousel> arrOne = isi.arrSell(1);
			List<Carousel> arrTwo = isi.arrSell(2);
			request.getSession().setAttribute("arrOne", arrOne);
			request.getSession().setAttribute("arrTwo", arrTwo);
			// 配合Ajax
			out.print("ok");
		} else if (op.equals("toupd")) {
			// 获取需要修改的对象
			String id = request.getParameter("id");
			Carousel c = isi.carousel(Integer.parseInt(id));
			request.getSession().setAttribute("c", c);
			// 配合Ajax
			out.print("ok");
		} else if (op.equals("upd")) {
			// 修改数据
			Carousel c = new Carousel();
			c.setIndexId(Integer.parseInt(request.getParameter("id")));
			c.setImageSrc(request.getParameter("img"));
			c.setIndexTitle(request.getParameter("title"));
			c.setIndexUrl(request.getParameter("url"));
			c.setIndexDesc(request.getParameter("desc"));
			if (isi.upd(c) > 0) {
				System.out.println("数据修改成功！");
				out.print("ok");
			} else {
				System.out.println("数据修改失败！");
				out.print("no");
			}
		} else if (op.equals("add")) {
			// 新增数据
			Carousel c = new Carousel();
			c.setImageSrc(request.getParameter("img"));
			c.setIndexTitle(request.getParameter("title"));
			c.setIndexUrl(request.getParameter("url"));
			c.setIndexDesc(request.getParameter("desc"));
			if (isi.add(c) > 0) {
				System.out.println("数据新增成功！");
				out.print("ok");
			} else {
				System.out.println("数据新增失败！");
				out.print("no");
			}
		} else if (op.equals("del")) {
			// 删除数据
			out.print(isi.del(Integer.parseInt(request.getParameter("id"))));
		}
		out.flush();
		out.close();
	}

}
