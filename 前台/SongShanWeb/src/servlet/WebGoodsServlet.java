package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.util.PropUtil;

import dao.impl.GoodsDaoImpl;
import dao.impl.TicketDaoImpl;
import entity.Carousel;
import entity.Goods;
import entity.Ticket;
import service.impl.CarouselServiceImpl;
import unit.ErWeiMa;
import unit.GetDate;
import unit.Mail;

public class WebGoodsServlet extends HttpServlet {

	
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
		GoodsDaoImpl gdi = new GoodsDaoImpl();
		TicketDaoImpl tdi = new TicketDaoImpl();
		// 获取前台的操作项
		String op = request.getParameter("op");
		
		request.getSession().setAttribute("dayCount", tdi.dayCount());
		
		// 分配操作项
		if (op == null || op.equals("serach")) {
			// 显示全部轮播内容
			// 获取全部内容，存储到List中
			String typeid = request.getParameter("typeid");
			typeid = typeid == null ? "1" : typeid;
			int state = 1;
			List<Goods> arr = gdi.arrSell(Integer.parseInt(typeid), state);
			request.setAttribute("arr", arr);
			request.setAttribute("typeid", typeid);
			request.getRequestDispatcher("goods.jsp").forward(request, response);
			
		} else if (op.equals("desc")) {
			// 详情页面
			String typeid = request.getParameter("typeid");
			String id = request.getParameter("id");
			typeid = typeid == null ? "1" : typeid;
			Goods goods = gdi.getGoods(Integer.parseInt(id));
			GetDate date = new GetDate();
			request.setAttribute("goods", goods);
			request.setAttribute("typeid", typeid);
			request.setAttribute("date", date);
			request.getRequestDispatcher("goodsDesc.jsp").forward(request, response);
			
		} else if (op.equals("tobuy")) {
			// 购买数据
			int id = Integer.parseInt(request.getParameter("id"));
			int count = Integer.parseInt(request.getParameter("count"));
			int state = 1;
			if (gdi.getGoodsCount(id, count, state) == -1) {
				out.print("-1");
			} else {
				String beginTime = request.getParameter("beginTime");
				String endTime = request.getParameter("endTime");
				// 合成数据
				Ticket t = new Ticket();
				t.setGoodsId(id);
				t.setUser("");
				t.setBuyCount(count);
				t.setBeginTime(beginTime);
				t.setEndTime(endTime);
				t.setGoods(gdi.getGoods(t.getGoodsId()));
				t.setMoney(t.getGoods().getMoney()*t.getBuyCount());
				request.getSession().setAttribute("t", t);
				out.print("1");
			}
			
		} else if (op.equals("buy")) {
			// 获取Ticket对象
			Ticket t = (Ticket)request.getSession().getAttribute("t");
			// 获取用户信息
			t.setUser(request.getParameter("user"));
			// 判断商品数量是否足够
			if (gdi.updGoods(t.getGoodsId(), t.getBuyCount()) == 1) {
				// 初始化二维码链接
				t.setImgSrc(getServletConfig().getServletContext().getInitParameter("url"));
				// 添加信息
				out.print(tdi.add(t));
			} else {
				out.print(-1);
			}
			
		} else if (op.equals("userSearch")) {
			String user = request.getParameter("user");
			List<Ticket> arr = tdi.arrSell(user);
			if (arr.size() != 0) {
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("arr", arr);
				out.print("1");
			} else {
				out.print("-1");
			}
			
		} else if (op.equals("yzm")) {
			String user = request.getParameter("user");
			int yzm = (int)(1000 + Math.random() * (9999 - 1000 + 1));
			Mail.recipientAddress = user;
			Mail.emailTitle = "嵩山少林旅游官网预定验证码";
			Mail.emailText = "本次验证码：" + yzm;
			Mail.sender();
			out.print(yzm);
		}
		
		
		out.flush();
		out.close();
	}

}
