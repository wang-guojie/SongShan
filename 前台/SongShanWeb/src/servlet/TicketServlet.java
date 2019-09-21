package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.TicketDaoImpl;
import entity.Ticket;

public class TicketServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		TicketDaoImpl tdi = new TicketDaoImpl();
		String op = request.getParameter("op");
		
		request.getSession().setAttribute("dayCount", tdi.dayCount());
		
		// ��ȡ������Ϣ
		if (op.split("_")[0].equals("user")) {
			// ��ȡ����ID
			int id = Integer.parseInt(op.split("_")[1]);
			// ��ȡ������Ϣ
			Ticket t = tdi.getTicket(id);
			// ת����Ϣ
			request.setAttribute("t", t);
			request.getRequestDispatcher("ticket.jsp").forward(request, response);
		} else if(op.equals("upd")) {
			// ��ȡ����ID
			int id = Integer.parseInt(request.getParameter("id"));
			// ����
			tdi.upd(id, 2);
			// ��ȡ������Ϣ
			Ticket t = tdi.getTicket(id);
			// ת����Ϣ
			request.setAttribute("t", t);
			request.getRequestDispatcher("ticket.jsp").forward(request, response);
		} else if (op.equals("userSerach")) {
			// ��ȡ�û�
			String user = (String)request.getSession().getAttribute("user");
			request.getSession().setAttribute("arr", tdi.arrSell(user));
			request.getRequestDispatcher("sellTicket-table.jsp").forward(request, response);
		}
		
		out.flush();
		out.close();
	}

}
