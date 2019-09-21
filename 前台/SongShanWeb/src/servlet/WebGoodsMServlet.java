package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unit.GetDate;
import unit.Mail;
import dao.impl.GoodsDaoImpl;
import dao.impl.GoodsMDaoImpl;
import dao.impl.TicketDaoImpl;
import dao.impl.TicketMDaoImpl;
import entity.Goods;
import entity.GoodsM;
import entity.Ticket;
import entity.TicketM;

public class WebGoodsMServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		GoodsMDaoImpl gdmi = new GoodsMDaoImpl();
		TicketMDaoImpl tmdi = new TicketMDaoImpl();
		String op = request.getParameter("op");
		TicketDaoImpl tdi = new TicketDaoImpl();
		GoodsDaoImpl gdi = new GoodsDaoImpl();
		
		// 跳转首页
		if (op == null || op.equals("serach")) {
			// 获得套票集合
			List arr = gdmi.arrSell(1);
			// 存储
			request.setAttribute("arr", arr);
			// 转发
			request.getRequestDispatcher("goodsM.jsp").forward(request, response);
			
		} else if (op.equals("desc")) {
			// 详情页面
			String id = request.getParameter("id");
			GoodsM goodsM = gdmi.getGoodsM(Integer.parseInt(id));
			GetDate date = new GetDate();
			request.setAttribute("goodsM", goodsM);
			request.setAttribute("date", date);
			request.getRequestDispatcher("goodsMDesc.jsp").forward(request, response);
			
		} else if (op.equals("tobuy")) {
			// 购买数据
			int id = Integer.parseInt(request.getParameter("id"));
			int count = Integer.parseInt(request.getParameter("count"));
			int state = 1;
			if (gdmi.getGoodsCount(id, count, state) == -1) {
				out.print("-1");
			} else {
				String beginTime = request.getParameter("beginTime");
				String endTime = request.getParameter("endTime");
				// 合成数据
				TicketM t = new TicketM();
				t.setGoodsM(gdmi.getGoodsM(id));
				t.setGoodsId(t.getGoodsM().getId());
				t.setUser("");
				t.setBuyCount(count);
				t.setBeginTime(beginTime);
				t.setEndTime(endTime);
				t.setMoney(t.getGoodsM().getMoney()*t.getBuyCount());
				request.getSession().setAttribute("t", t);
				out.print("1");
			}
			
		} else if (op.equals("buy")) {
			// 获取Ticket对象
			TicketM t = (TicketM)request.getSession().getAttribute("t");
			
			// 循环添加信息
			String ticketId = "";
			for (String ids : t.getGoodsM().getGoodsId().split(",")) {
				// 创建订单对象
				Ticket ticket = new Ticket();
				ticket.setGoodsId(Integer.parseInt(ids));
				ticket.setUser(request.getParameter("user"));
				ticket.setBuyCount(t.getBuyCount());
				ticket.setBeginTime(t.getBeginTime());
				ticket.setEndTime(t.getEndTime());
				ticket.setGoods(gdi.getGoods(ticket.getGoodsId()));
				ticket.setMoney(ticket.getGoods().getMoney()*ticket.getBuyCount());
				// 编辑
				ticketId += tdi.getAddId(ticket) + ",";
			}
			ticketId = ticketId.substring(0,ticketId.lastIndexOf(","));
			// TicketId
			t.setTicketId(ticketId);
			
			// 获取用户信息
			t.setUser(request.getParameter("user"));
			// 判断商品数量是否足够
			if (gdmi.updGoods(t.getGoodsM().getId(), t.getBuyCount()) == 1) {
				// 初始化二维码链接
				t.setImgSrc(getServletConfig().getServletContext().getInitParameter("url"));
				// 添加信息
				out.print(tmdi.add(t));
			} else {
				out.print(-1);
			}
			
		} else if (op.equals("userSearch")) {
			String user = request.getParameter("user");
			List<TicketM> arr = tmdi.arrSell(user);
			if (arr.size() != 0) {
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
