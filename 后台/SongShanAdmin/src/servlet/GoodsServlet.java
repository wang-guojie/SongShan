package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import dao.impl.GoodsDaoImpl;
import dao.impl.GoodsTypeDaoImpl;
import entity.Goods;
import entity.GoodsType;
import entity.TableCode;
import entity.Ticket;

public class GoodsServlet extends HttpServlet {

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
		// ��Ʒ
		GoodsDaoImpl gdi = new GoodsDaoImpl();
		// ��Ʒ����
		GoodsTypeDaoImpl gtdi = new GoodsTypeDaoImpl();
		// ��ȡǰ̨��ѡ��
		String op = request.getParameter("op");

		// ��ҳ��Ϣչʾ
		if (op == null || op.equals("serach")) {
			// ��ȡ��ҳ������
			int state = Integer.parseInt(request.getParameter("state"));
			int page = Integer.parseInt(request.getParameter("page"));
			int limit = Integer.parseInt(request.getParameter("limit"));
			List<Goods> arr = gdi.arrSell(page, limit, state);
			// ���ز�������
			TableCode tc = new TableCode(0, gdi.sum(state), "", arr);

			out.print(JSON.toJSON(tc));

			// ��ȡ��Ҫ���µĶ���
		} else if (op.equals("toupd")) {
			// ��ȡID
			int id = Integer.parseInt(request.getParameter("id"));
			// ��ȡ��Ҫ�޸ĵĶ���
			Goods goods = gdi.getGoods(id);
			// ��ȡType����
			List<GoodsType> arr = gtdi.arrSell();
			// ���ض���
			request.getSession().setAttribute("goods", goods);
			request.getSession().setAttribute("arr", arr);

			out.print("ok");

			// ���µ�ǰ��Ϣ
		} else if (op.equals("upd")) {
			// ����Goods����
			Goods good = new Goods();
			// ��ȡ�ύ������
			String state = request.getParameter("state");
			String id = request.getParameter("id");
			String typeId = request.getParameter("typeId");
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			String inventory = request.getParameter("inventory");
			String imgSrc = request.getParameter("imgSrc");
			String money = request.getParameter("money");
			// �������
			good.setId(Integer.parseInt(id));
			good.setTypeId(Integer.parseInt(typeId));
			good.setGoodName(name);
			good.setGoodDesc(desc);
			good.setInventory(Integer.parseInt(inventory));
			good.setImgSrc(imgSrc);
			good.setMoney(Integer.parseInt(money));

			out.print(gdi.upd(good));
			
			// �����Ϣ
		} else if (op.equals("updState")) {
			// ����Goods����
			Goods good = new Goods();
			// ��ȡ�ύ������
			String state = request.getParameter("state");
			String id = request.getParameter("id");
			// ����
			out.print(gdi.state(Integer.parseInt(id), Integer.parseInt(state)));
			
			// �����Ϣ
		} else if (op.equals("add")) {
			// ����Goods����
			Goods good = new Goods();
			// ��ȡ�ύ������
			String typeId = request.getParameter("typeId");
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			String inventory = request.getParameter("inventory");
			String imgSrc = request.getParameter("imgSrc");
			String money = request.getParameter("money");
			// �������
			good.setTypeId(Integer.parseInt(typeId));
			good.setGoodName(name);
			good.setGoodDesc(desc);
			good.setInventory(Integer.parseInt(inventory));
			good.setImgSrc(imgSrc);
			good.setMoney(Integer.parseInt(money));

			out.print(gdi.add(good));

		} else if (op.equals("toadd")) {
			// ��ȡType����
			List<GoodsType> arr = gtdi.arrSell();
			// ���ض���
			request.getSession().setAttribute("arr", arr);
			
			out.print("ok");

			// ɾ����ǰ����
		} else if (op.equals("del")) {
			// ��ȡID
			String id = request.getParameter("id");
			out.print(gdi.del(Integer.parseInt(id)));
			
			// ����
		} else if (op.equals("nameCount")) {
			// ��ȡ��Ʒ��
			String name = request.getParameter("name");
			out.print(gdi.nameCount(name));
			
		}

		out.flush();
		out.close();
	}

}
