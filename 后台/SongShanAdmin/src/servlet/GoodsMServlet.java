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
		
		// 跳转首页
		if (op == null || op.equals("serach")) {
			// 获取分页数据量
			int state = Integer.parseInt(request.getParameter("state"));
			List<GoodsM> arr = gdmi.arrSell(state);
			// 返回参数对象
			TableCode tc = new TableCode(0, gdi.sum(state), "", arr);

			out.print(JSON.toJSON(tc));
			
			// 新增
		} else if (op.equals("insert")) {
			// 获取数据内容
			String goodsId = request.getParameter("goodsId");
			goodsId = goodsId.substring(0, goodsId.lastIndexOf(","));
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			String inventory = request.getParameter("inventory");
			String imgSrc = request.getParameter("imgSrc");
			String money = request.getParameter("money");
			// 创建对象
			GoodsM g = new GoodsM();
			g.setGoodsId(goodsId);
			g.setGoodName(name);
			g.setGoodDesc(desc);
			g.setInventory(Integer.parseInt(inventory));
			g.setImgSrc(imgSrc);
			g.setMoney(Integer.parseInt(money));
			// 新增操作
			out.print(gdmi.add(g));
			
			// 获取新增页面
		} else if (op.equals("toInsert")) {
			// 获取商品集合
			List arr = gdi.arrSell(1, gdi.sum(1), 1);
			// 返回对象
			request.getSession().setAttribute("arr", arr);
			
			out.print("ok");
			
			// 获取修改页面
		} else if (op.equals("toUpdate")) {
			// 获取ID
			int id = Integer.parseInt(request.getParameter("id"));
			// 获取需要修改的对象
			GoodsM goodsM = gdmi.getGoodsM(id);
			// 获取商品集合
			List arr = gdi.arrSell(1, gdi.sum(1), 1);
			// 返回对象
			request.getSession().setAttribute("arr", arr);
			request.getSession().setAttribute("AorB", new AorB());
			request.getSession().setAttribute("goodsM", goodsM);
			
			out.print("ok");
			
			// 修改
		} else if (op.equals("update")) {
			// 获取数据内容
			int id = Integer.parseInt(request.getParameter("id"));
			String goodsId = request.getParameter("goodsId");
			goodsId = goodsId.substring(0, goodsId.lastIndexOf(","));
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			String inventory = request.getParameter("inventory");
			String imgSrc = request.getParameter("imgSrc");
			String money = request.getParameter("money");
			// 创建对象
			GoodsM g = new GoodsM();
			g.setId(id);
			g.setGoodsId(goodsId);
			g.setGoodName(name);
			g.setGoodDesc(desc);
			g.setInventory(Integer.parseInt(inventory));
			g.setImgSrc(imgSrc);
			g.setMoney(Integer.parseInt(money));
			// 新增操作
			out.print(gdmi.upd(g));
			
			// 添加信息
		} else if (op.equals("updState")) {
			// 获取提交的数据
			String state = request.getParameter("state");
			String id = request.getParameter("id");
			// 禁用
			out.print(gdmi.state(Integer.parseInt(id), Integer.parseInt(state)));
			
			// 查重
		} else if (op.equals("nameCount")) {
			// 获取商品名
			String name = request.getParameter("name");
			out.print(gdmi.nameCount(name));
			
		}
		
		out.flush();
		out.close();
	}

}
