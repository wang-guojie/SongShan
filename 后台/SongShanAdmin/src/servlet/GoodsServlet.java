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
	 * Get请求
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * Post请求
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 商品
		GoodsDaoImpl gdi = new GoodsDaoImpl();
		// 商品分类
		GoodsTypeDaoImpl gtdi = new GoodsTypeDaoImpl();
		// 获取前台的选择
		String op = request.getParameter("op");

		// 首页信息展示
		if (op == null || op.equals("serach")) {
			// 获取分页数据量
			int state = Integer.parseInt(request.getParameter("state"));
			int page = Integer.parseInt(request.getParameter("page"));
			int limit = Integer.parseInt(request.getParameter("limit"));
			List<Goods> arr = gdi.arrSell(page, limit, state);
			// 返回参数对象
			TableCode tc = new TableCode(0, gdi.sum(state), "", arr);

			out.print(JSON.toJSON(tc));

			// 获取需要更新的对象
		} else if (op.equals("toupd")) {
			// 获取ID
			int id = Integer.parseInt(request.getParameter("id"));
			// 获取需要修改的对象
			Goods goods = gdi.getGoods(id);
			// 获取Type集合
			List<GoodsType> arr = gtdi.arrSell();
			// 返回对象
			request.getSession().setAttribute("goods", goods);
			request.getSession().setAttribute("arr", arr);

			out.print("ok");

			// 更新当前信息
		} else if (op.equals("upd")) {
			// 创建Goods对象
			Goods good = new Goods();
			// 获取提交的数据
			String state = request.getParameter("state");
			String id = request.getParameter("id");
			String typeId = request.getParameter("typeId");
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			String inventory = request.getParameter("inventory");
			String imgSrc = request.getParameter("imgSrc");
			String money = request.getParameter("money");
			// 填充数据
			good.setId(Integer.parseInt(id));
			good.setTypeId(Integer.parseInt(typeId));
			good.setGoodName(name);
			good.setGoodDesc(desc);
			good.setInventory(Integer.parseInt(inventory));
			good.setImgSrc(imgSrc);
			good.setMoney(Integer.parseInt(money));

			out.print(gdi.upd(good));
			
			// 添加信息
		} else if (op.equals("updState")) {
			// 创建Goods对象
			Goods good = new Goods();
			// 获取提交的数据
			String state = request.getParameter("state");
			String id = request.getParameter("id");
			// 禁用
			out.print(gdi.state(Integer.parseInt(id), Integer.parseInt(state)));
			
			// 添加信息
		} else if (op.equals("add")) {
			// 创建Goods对象
			Goods good = new Goods();
			// 获取提交的数据
			String typeId = request.getParameter("typeId");
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			String inventory = request.getParameter("inventory");
			String imgSrc = request.getParameter("imgSrc");
			String money = request.getParameter("money");
			// 填充数据
			good.setTypeId(Integer.parseInt(typeId));
			good.setGoodName(name);
			good.setGoodDesc(desc);
			good.setInventory(Integer.parseInt(inventory));
			good.setImgSrc(imgSrc);
			good.setMoney(Integer.parseInt(money));

			out.print(gdi.add(good));

		} else if (op.equals("toadd")) {
			// 获取Type集合
			List<GoodsType> arr = gtdi.arrSell();
			// 返回对象
			request.getSession().setAttribute("arr", arr);
			
			out.print("ok");

			// 删除当前对象
		} else if (op.equals("del")) {
			// 获取ID
			String id = request.getParameter("id");
			out.print(gdi.del(Integer.parseInt(id)));
			
			// 查重
		} else if (op.equals("nameCount")) {
			// 获取商品名
			String name = request.getParameter("name");
			out.print(gdi.nameCount(name));
			
		}

		out.flush();
		out.close();
	}

}
