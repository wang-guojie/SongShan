package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.AdminServiceImpl;
import service.impl.InFormAtionServiceImpl;
import service.impl.ScenicServiceImpl;
import entity.Admin;
import entity.InFormAtion;
import entity.Page;
import entity.Scenic;

public class AdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		AdminServiceImpl as = new AdminServiceImpl();
		InFormAtionServiceImpl info = new InFormAtionServiceImpl();
		ScenicServiceImpl scs = new ScenicServiceImpl();

		InFormAtion ifa = new InFormAtion();
		Admin am = new Admin();
		Scenic sc = new Scenic();

		String op = request.getParameter("op");

		if (op == null || op.equals("search")) {
			// 获取标题名
			String name = request.getParameter("titlename");
			name = name == null ? "" : name;
			// 编码格式转换
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
			// 获取下拉列表名字
			String typeid = request.getParameter("city");
			int typeids = typeid == null ? -1 : Integer.parseInt(typeid);

			request.setAttribute("typeid", typeids);
			request.setAttribute("name", name);

			String pageindex = request.getParameter("index");
			int index = pageindex == null ? 1 : Integer.parseInt(pageindex);
			Page page = new Page();
			page.setPageSize(4);
			page.setDataCount(info.getAllCount(name, typeids));
			page.setPageIndex(index);

			info.get4Page(page, name, typeids);

			List<Scenic> sList = scs.getList();
			request.setAttribute("sList", sList);

			request.setAttribute("page", page);
			request.getRequestDispatcher("news-Show.jsp").forward(request,
					response);

		} else if (op.equals("toAdd")) {
			List<Scenic> sList = scs.getList();
			request.setAttribute("sList", sList);
			request.getRequestDispatcher("news-Add.jsp").forward(request,
					response);

		} else if (op.equals("add")) {
			String titlename = request.getParameter("titlename");
			// 取文本编辑内容存数据库
			String contents = request.getParameter("contents");
			int city = Integer.parseInt(request.getParameter("city"));

			ifa.setTypeid(city);
			ifa.setInforname(titlename);
			ifa.setInforcontent(contents);
			int result = info.inFormAtionAdd(ifa);
			out.print("{\"result\":\"" + result + "\"}");

		} else if (op.equals("toUpdate")) {
			int id = Integer.parseInt(request.getParameter("id"));
			// 根据ID查询信息
			InFormAtion list = info.getById(id);

			List<Scenic> sList = scs.getList();
			request.setAttribute("sList", sList);

			request.setAttribute("list", list);
			request.getRequestDispatcher("news-Editor.jsp").forward(request,
					response);
		} else if (op.equals("update")) {

			int id = Integer.parseInt(request.getParameter("id"));
			String titlename = request.getParameter("titlename");
			// 取文本编辑内容存数据库
			String contents = request.getParameter("contents");
			int city = Integer.parseInt(request.getParameter("city"));
			ifa.setInforid(id);
			ifa.setInforname(titlename);
			ifa.setInforcontent(contents);
			ifa.setTypeid(city);
			int count = info.inFormAtionUpdate(ifa);
			out.print("{\"count\":\"" + count + "\"}");

		} else if (op.equals("del")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int count = info.inFormAtionDelete(id);
			out.print("{\"count\":\"" + count + "\"}");
		} else if (op.equals("fenye")) {
			Page page = new Page();
			// 每页显示两条
			page.setPageSize(5);
			page.setDataCount(info.getAllCount());
			int index = Integer.parseInt(request.getParameter("index"));
			page.setPageIndex(index);
			page.setList(info.list(page));
			request.setAttribute("page", page);
			request.getRequestDispatcher("news-Show.jsp").forward(request,
					response);

		} else if (op.equals("ck")) {
			// 管理员查重
			String name = request.getParameter("username");
			String pwd = request.getParameter("password");
			am.setAdminname(name);
			am.setAdminpwd(pwd);
			int count = as.checkeName(am);
			request.getSession().setAttribute("admin", am);
			out.print("{\"count\":\"" + count + "\"}");
		} else if (op.equals("tab")) {
			String number = request.getParameter("number");
			// 清除会话
			request.getSession().removeAttribute("admin");
			if (number.equals("1")) {
				request.getRequestDispatcher("admin-Login.jsp").forward(
						request, response);
			} else if (number.equals("2")) {
				request.getRequestDispatcher("admin-Login.jsp").forward(
						request, response);
			}
		} else if (op.equals("zixunck")) {
			String inforname = request.getParameter("inforname");
			int result = info.checkeName(inforname);
			out.print("{\"result\":\"" + result + "\"}");

		} else if (op.equals("admins")) {
			String name = request.getParameter("username");
			String pwd = request.getParameter("password1");
			am.setAdminname(name);
			am.setAdminpwd(pwd);
			if (as.adminAdd(am) > 0) {
				out.print("<script>alert('注册成功');location.href='admin-Login.jsp'</script>");
			} else {
				out.print("<script>alert('注册失败');location.href='admin-RegisTered.jsp'</script>");
			}
			// out.print("{\"result\":\"" + result + "\"}");
		}else if(op.equals("titleCk")){
			String titlename = request.getParameter("titlename");
			int result=info.checkeName(titlename);
			out.print("{\"result\":\"" + result + "\"}");
		}
		
		
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
