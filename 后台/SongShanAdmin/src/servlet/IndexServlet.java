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
	 * Get����
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * Post����
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ���Ķ���
		CarouselServiceImpl isi = new CarouselServiceImpl();
		// ��ȡǰ̨�Ĳ�����
		String op = request.getParameter("op");
		// ���������
		if (op == null || op.equals("serach")) {
			// ��ʾȫ���ֲ�����
			// ��ȡȫ�����ݣ��洢��List��
			List<Carousel> arrOne = isi.arrSell(1);
			List<Carousel> arrTwo = isi.arrSell(2);
			request.getSession().setAttribute("arrOne", arrOne);
			request.getSession().setAttribute("arrTwo", arrTwo);
			// ���Ajax
			out.print("ok");
		} else if (op.equals("toupd")) {
			// ��ȡ��Ҫ�޸ĵĶ���
			String id = request.getParameter("id");
			Carousel c = isi.carousel(Integer.parseInt(id));
			request.getSession().setAttribute("c", c);
			// ���Ajax
			out.print("ok");
		} else if (op.equals("upd")) {
			// �޸�����
			Carousel c = new Carousel();
			c.setIndexId(Integer.parseInt(request.getParameter("id")));
			c.setImageSrc(request.getParameter("img"));
			c.setIndexTitle(request.getParameter("title"));
			c.setIndexUrl(request.getParameter("url"));
			c.setIndexDesc(request.getParameter("desc"));
			if (isi.upd(c) > 0) {
				System.out.println("�����޸ĳɹ���");
				out.print("ok");
			} else {
				System.out.println("�����޸�ʧ�ܣ�");
				out.print("no");
			}
		} else if (op.equals("add")) {
			// ��������
			Carousel c = new Carousel();
			c.setImageSrc(request.getParameter("img"));
			c.setIndexTitle(request.getParameter("title"));
			c.setIndexUrl(request.getParameter("url"));
			c.setIndexDesc(request.getParameter("desc"));
			if (isi.add(c) > 0) {
				System.out.println("���������ɹ���");
				out.print("ok");
			} else {
				System.out.println("��������ʧ�ܣ�");
				out.print("no");
			}
		} else if (op.equals("del")) {
			// ɾ������
			out.print(isi.del(Integer.parseInt(request.getParameter("id"))));
		}
		out.flush();
		out.close();
	}

}
