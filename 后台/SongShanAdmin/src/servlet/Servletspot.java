package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.impl.spotServerImpl;
import entity.Page;
import entity.spot;

public class Servletspot extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		spotServerImpl sl=new spotServerImpl();
		
		String op=request.getParameter("op");
		if(op.equals("seach")){
			String name=request.getParameter("seachname");
			name=name==null?"":name;
			
			request.setAttribute("name",name);
			
			//获取下标
			String indexs=request.getParameter("index");
			int index=indexs==null?1:Integer.parseInt(indexs);
			Page p=new Page();
			p.setPageSize(2);
			p.setDataCount(sl.getAllCount(name));
			p.setPageIndex(index);
		
			
			sl.getPage(p, name);
			
			request.setAttribute("page",p);
			request.getRequestDispatcher("index3.jsp").forward(request, response);		
		}else if(op.equals("toupdate")){
			int id=Integer.parseInt(request.getParameter("id"));
			spot s=sl.GetById(id);
			request.setAttribute("s", s);
			request.getRequestDispatcher("update2.jsp").forward(request, response);
		}else if(op.equals("add")){
			
			String name="";//上传的文件路径 
	        //上传的文件名
	        String  uploadFileName="";
	        //表单字段元素的name属性值
	        String filedName="";
	        //获取服务器项目路径
	        String savePath=request.getServletContext().getRealPath("images/");
	        //判断请求中的内容是否为multipart
	        boolean   isMulty=ServletFileUpload.isMultipartContent(request);
	        //如果为true，就是表单中含有上传标签
	        if(isMulty)
	        {
	         //对来的请求进行处理
	         FileItemFactory factory=new DiskFileItemFactory();
	         ServletFileUpload upload=new ServletFileUpload(factory);
	         upload.setSizeMax(100*1024);
	         try{
	           //parseRequest方法解析请求，获取请求里的表单字段
	           List<FileItem>items=upload.parseRequest(request);
	           for(FileItem item:items)
	           {
	            //判断每个元素 是普通还是文件
	            if(item.isFormField()){//true普通false是文件
	            //获取元素name属性值
	            filedName=item.getFieldName();
	            if(filedName.equals("name"))
	            {
	             String value=item.getString("utf-8");
	             out.print(value+"上传了文件");
	            }
	            }else{
	            //处理文件上传 
	            //1.获取用户上传的文件名
	            String fileName=item.getName();
	            //判断用户是否上传了文件
	            if(fileName!=null && !fileName.equals(""))
	            {
	             //判断文件类型是否合法
	           /*  List<String>typelist=Arrays.asList("jpg","bmp");
	             //从文件名中截取文件类型
	            String type=fileName.substring(filedName.lastIndexOf(".")+1);
	             if(!typelist.contains(type))
	             {
	             out.print("不合法文件");
	             return;
	             }*/
	             //2.创建一个文件对象，方便下一步进行文件写入
	             File   file=new File(savePath,fileName);
	             //3.把文件写入到对应路径下
	             item.write(file);
	             out.print("文件上传成功！名字是："+"images/"+fileName);
	            }
	            }
	           }
	         }catch(FileUploadBase.SizeLimitExceededException e)
	         {
	          out.print("文件过大");
	         }catch(Exception e)
	         {
	        	 e.printStackTrace();
	         }
	        }
			String spotname=request.getParameter("spotname");
			String spotcontext=request.getParameter("spotcontext");
			//文件上传属性

			spot s=new spot();
			s.setSpotname(spotname);			
			s.setSpotcontext(spotcontext);
			int result=sl.add(s);
			out.print("{\"result\":\""+result+"\"}");
			/*if(result>0){
				request.getSession().setAttribute("result", "添加成功");
				request.getRequestDispatcher("index3.jsp").forward(request, response);
			}else{
				request.getSession().setAttribute("result", "添加失败");
				request.getRequestDispatcher("index3.jsp").forward(request, response);
			}*/
		}else if(op.equals("del")){
			int id=Integer.parseInt(request.getParameter("id"));
			int count=sl.delete(id);
			out.print("{\"count\":\""+count+"\"}");
		}else if(op.equals("update2")){
			int spotid=Integer.parseInt(request.getParameter("spotid"));
			String spotname=request.getParameter("spotname");
			String spotcontext=request.getParameter("spotcontext");
			String imagesrc=request.getParameter("imagesrc");
			spot s=new spot();
			s.setSpotid(spotid);
			s.setSpotname(spotname);
			s.setSpotcontext(spotcontext);
			
			int result=sl.update(s);
			if(result>0){
				out.print("<script>alert('修改成功');</script>");
			}else{
				out.print("<script>alert('修改失败');</script>");
			}
		}else if(op.equals("fenye")){
			Page p=new Page();
			p.setPageSize(2);
			p.setDataCount(sl.GetByAll());
			int PageIndex=Integer.parseInt(request.getParameter("index"));
			p.setPageIndex(PageIndex);
			p.setList(sl.list(p));
			request.setAttribute("Page", p);
			request.getRequestDispatcher("fen.jsp").forward(request, response);
		}else if(op.equals("chname")){
			String name=request.getParameter("name");
			int c=sl.chname(name);
			out.print("{\"c\":\""+c+"\"}");
		}
		
		out.flush();
		out.close();
	}

}
