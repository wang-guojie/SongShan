package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import dao.impl.TicketDaoImpl;
import entity.TableCode;
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
		
		if (op == null || op.equals("serach")) {
			// ��ȡ��ҳ������
			int page = Integer.parseInt(request.getParameter("page"));
			int limit = Integer.parseInt(request.getParameter("limit"));
			// ��ȡ״̬
			int state = Integer.parseInt(request.getParameter("state"));
			List<Ticket> arr = tdi.arrSell(page, limit, state);
			// ���ز�������
			TableCode tc = new TableCode(0,tdi.sum(state),"",arr);
			// - Json -
			out.print(JSON.toJSON(tc));
			
		} else if (op.equals("state")) {
			// ��ȡҪɾ����ID
			int id = Integer.parseInt(request.getParameter("id"));
			int state = Integer.parseInt(request.getParameter("state"));
			// - Text -
			out.print(tdi.state(id, state));
			
		} else if (op.equals("serachYe")) {
			// ��ȡ��ҳ������
			int page = Integer.parseInt(request.getParameter("page"));
			int limit = Integer.parseInt(request.getParameter("limit"));
			// ��ȡ״̬
			int state = Integer.parseInt(request.getParameter("state"));
			// ��ȡ��Ʒ����
			
			String goodName = new String(request.getParameter("goodName").getBytes("ISO-8859-1"), "UTF-8");
			goodName = goodName == null ? "" : goodName;
			// ��ȡ�û�����
			String user = new String(request.getParameter("user").getBytes("ISO-8859-1"), "UTF-8");
			user = user == null ? "" : user;
			List<Ticket> arr = tdi.arrSell(page, limit, state, goodName, user);
			// ���ز�������
			TableCode tc = new TableCode(0,tdi.sum(state),"",arr);
			
			out.print(JSON.toJSON(tc));
			
		}
		
		out.flush();
		out.close();
	}

}
