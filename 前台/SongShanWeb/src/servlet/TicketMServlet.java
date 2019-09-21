package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.TicketDaoImpl;
import dao.impl.TicketMDaoImpl;
import entity.TicketM;

public class TicketMServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		TicketMDaoImpl tmdi = new TicketMDaoImpl();
		TicketDaoImpl tdi = new TicketDaoImpl();
		String op = request.getParameter("op");
		
		request.getSession().setAttribute("dayCount", tmdi.dayCount());
		
		// ��ȡ������Ϣ
		if (op.split("_")[0].equals("user")) {
			// ��ȡ����ID
			int id = Integer.parseInt(op.split("_")[1]);
			// ��ȡ������Ϣ
			TicketM t = tmdi.getTicketM(id);
			// ת����Ϣ
			request.setAttribute("t", t);
			request.getRequestDispatcher("ticketM.jsp").forward(request, response);
		} else if(op.equals("upd")) {
			// ��ȡ����ID
			int tid = Integer.parseInt(request.getParameter("tid"));
			int mid = Integer.parseInt(request.getParameter("mid"));
			// ����
			tdi.upd(tid, 2);
			// ��ȡ������Ϣ
			TicketM t = tmdi.getTicketM(mid);
			// ת����Ϣ
			request.setAttribute("t", t);
			request.getRequestDispatcher("ticketM.jsp").forward(request, response);
		} else if (op.equals("userSerach")) {
			// ��ȡ�û�
			String user = (String)request.getSession().getAttribute("user");
			request.getSession().setAttribute("arr", tmdi.arrSell(user));
			request.getRequestDispatcher("sellTicketM-table.jsp").forward(request, response);
		}
		
		out.flush();
		out.close();
	}

}
