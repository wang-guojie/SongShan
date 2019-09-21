package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unit.AorB;

import com.alibaba.fastjson.JSON;

import dao.impl.GoodsDaoImpl;
import dao.impl.GoodsMDaoImpl;
import entity.Goods;
import entity.GoodsM;
import entity.GoodsType;
import entity.TableCode;

public class GoodsMServlet extends HttpServlet {

	
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
		GoodsDaoImpl gdi = new GoodsDaoImpl();
		String op = request.getParameter("op");
		
		// ��ת��ҳ
		if (op == null || op.equals("serach")) {
			// ��ȡ��ҳ������
			int state = Integer.parseInt(request.getParameter("state"));
			List<GoodsM> arr = gdmi.arrSell(state);
			// ���ز�������
			TableCode tc = new TableCode(0, gdi.sum(state), "", arr);

			out.print(JSON.toJSON(tc));
			
			// ����
		} else if (op.equals("insert")) {
			// ��ȡ��������
			String goodsId = request.getParameter("goodsId");
			goodsId = goodsId.substring(0, goodsId.lastIndexOf(","));
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			String inventory = request.getParameter("inventory");
			String imgSrc = request.getParameter("imgSrc");
			String money = request.getParameter("money");
			// ��������
			GoodsM g = new GoodsM();
			g.setGoodsId(goodsId);
			g.setGoodName(name);
			g.setGoodDesc(desc);
			g.setInventory(Integer.parseInt(inventory));
			g.setImgSrc(imgSrc);
			g.setMoney(Integer.parseInt(money));
			// ��������
			out.print(gdmi.add(g));
			
			// ��ȡ����ҳ��
		} else if (op.equals("toInsert")) {
			// ��ȡ��Ʒ����
			List arr = gdi.arrSell(1, gdi.sum(1), 1);
			// ���ض���
			request.getSession().setAttribute("arr", arr);
			
			out.print("ok");
			
			// ��ȡ�޸�ҳ��
		} else if (op.equals("toUpdate")) {
			// ��ȡID
			int id = Integer.parseInt(request.getParameter("id"));
			// ��ȡ��Ҫ�޸ĵĶ���
			GoodsM goodsM = gdmi.getGoodsM(id);
			// ��ȡ��Ʒ����
			List arr = gdi.arrSell(1, gdi.sum(1), 1);
			// ���ض���
			request.getSession().setAttribute("arr", arr);
			request.getSession().setAttribute("AorB", new AorB());
			request.getSession().setAttribute("goodsM", goodsM);
			
			out.print("ok");
			
			// �޸�
		} else if (op.equals("update")) {
			// ��ȡ��������
			int id = Integer.parseInt(request.getParameter("id"));
			String goodsId = request.getParameter("goodsId");
			goodsId = goodsId.substring(0, goodsId.lastIndexOf(","));
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			String inventory = request.getParameter("inventory");
			String imgSrc = request.getParameter("imgSrc");
			String money = request.getParameter("money");
			// ��������
			GoodsM g = new GoodsM();
			g.setId(id);
			g.setGoodsId(goodsId);
			g.setGoodName(name);
			g.setGoodDesc(desc);
			g.setInventory(Integer.parseInt(inventory));
			g.setImgSrc(imgSrc);
			g.setMoney(Integer.parseInt(money));
			// ��������
			out.print(gdmi.upd(g));
			
			// �����Ϣ
		} else if (op.equals("updState")) {
			// ��ȡ�ύ������
			String state = request.getParameter("state");
			String id = request.getParameter("id");
			// ����
			out.print(gdmi.state(Integer.parseInt(id), Integer.parseInt(state)));
			
			// ����
		} else if (op.equals("nameCount")) {
			// ��ȡ��Ʒ��
			String name = request.getParameter("name");
			out.print(gdmi.nameCount(name));
			
		}
		
		out.flush();
		out.close();
	}

}
