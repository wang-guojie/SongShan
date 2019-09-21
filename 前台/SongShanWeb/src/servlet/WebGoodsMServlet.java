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
		
		// ��ת��ҳ
		if (op == null || op.equals("serach")) {
			// �����Ʊ����
			List arr = gdmi.arrSell(1);
			// �洢
			request.setAttribute("arr", arr);
			// ת��
			request.getRequestDispatcher("goodsM.jsp").forward(request, response);
			
		} else if (op.equals("desc")) {
			// ����ҳ��
			String id = request.getParameter("id");
			GoodsM goodsM = gdmi.getGoodsM(Integer.parseInt(id));
			GetDate date = new GetDate();
			request.setAttribute("goodsM", goodsM);
			request.setAttribute("date", date);
			request.getRequestDispatcher("goodsMDesc.jsp").forward(request, response);
			
		} else if (op.equals("tobuy")) {
			// ��������
			int id = Integer.parseInt(request.getParameter("id"));
			int count = Integer.parseInt(request.getParameter("count"));
			int state = 1;
			if (gdmi.getGoodsCount(id, count, state) == -1) {
				out.print("-1");
			} else {
				String beginTime = request.getParameter("beginTime");
				String endTime = request.getParameter("endTime");
				// �ϳ�����
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
			// ��ȡTicket����
			TicketM t = (TicketM)request.getSession().getAttribute("t");
			
			// ѭ�������Ϣ
			String ticketId = "";
			for (String ids : t.getGoodsM().getGoodsId().split(",")) {
				// ������������
				Ticket ticket = new Ticket();
				ticket.setGoodsId(Integer.parseInt(ids));
				ticket.setUser(request.getParameter("user"));
				ticket.setBuyCount(t.getBuyCount());
				ticket.setBeginTime(t.getBeginTime());
				ticket.setEndTime(t.getEndTime());
				ticket.setGoods(gdi.getGoods(ticket.getGoodsId()));
				ticket.setMoney(ticket.getGoods().getMoney()*ticket.getBuyCount());
				// �༭
				ticketId += tdi.getAddId(ticket) + ",";
			}
			ticketId = ticketId.substring(0,ticketId.lastIndexOf(","));
			// TicketId
			t.setTicketId(ticketId);
			
			// ��ȡ�û���Ϣ
			t.setUser(request.getParameter("user"));
			// �ж���Ʒ�����Ƿ��㹻
			if (gdmi.updGoods(t.getGoodsM().getId(), t.getBuyCount()) == 1) {
				// ��ʼ����ά������
				t.setImgSrc(getServletConfig().getServletContext().getInitParameter("url"));
				// �����Ϣ
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
			Mail.emailTitle = "��ɽ�������ι���Ԥ����֤��";
			Mail.emailText = "������֤�룺" + yzm;
			Mail.sender();
			out.print(yzm);
		}
		
		out.flush();
		out.close();
	}

}
