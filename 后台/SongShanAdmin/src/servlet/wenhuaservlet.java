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

import service.impl.wenhuascrviceimpl;
import entity.wenhua;

public class wenhuaservlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String op=request.getParameter("op");
		wenhuascrviceimpl wh=new wenhuascrviceimpl();
		if(op==null||op.equals("search")){
			String name=request.getParameter("searchname");
			name=name==null?"":name;
			List<wenhua> list=wh.getAll(name);
			request.setAttribute("list", list);
			request.getRequestDispatcher("wenhuaa.jsp").forward(request, response);
		}else if(op.equals("toadd")){
			request.getRequestDispatcher("wenhuaadd.jsp").forward(request, response);
		}
		else if(op.equals("add")){
			
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
	       // filedName=request.getParameter("filedName");
			String culturename=request.getParameter("culturename");
			String cultureexplanation=request.getParameter("cultureexplanation");
			wenhua w=new wenhua();
			//w.setCulImage(filedName);
			w.setCulturename(culturename);
			w.setCultureexplanation(cultureexplanation);
			
		
			int result=wh.add(w);
			if(result>0){
				out.print("<script>alert('新增成功');location.href='wenhuaa.jsp'</script>");
			}else {
				
				out.print("<script>alert('新增失败');location.href='wenhuaa.jsp'</script>");
			}
		}else if(op.equals("toupdate")){
			Integer id=Integer.parseInt(request.getParameter("cultureid"));
			wenhua p=wh.checkname(id);
			request.setAttribute("p", p);
			request.getRequestDispatcher("wenhuaupdate.jsp").forward(request, response);
		}else if(op.equals("update")){
			Integer cultureid=Integer.parseInt(request.getParameter("cultureid"));
			String culturename=request.getParameter("culturename");
			String cultureexplanation=request.getParameter("cultureexplanation");
	
			
			wenhua w=new wenhua();
			w.setCultureid(cultureid);
			w.setCulturename(culturename);
			w.setCultureexplanation(cultureexplanation);
			int result=wh.update(w);
			
			if(result>0){
				out.print("<script>alert('修改成功')</script>");
			}else {
				
				out.print("<script>alert('修改失败')</script>");
			}	
			
		}else if(op.equals("del2")){
			Integer id=Integer.parseInt(request.getParameter("cultureid"));
			int result=wh.delete(id);
			
			if(result>0){
				out.print("<script>alert('删除成功');location.href='wenhuaa.jsp'</script>");
			}else {
				
				out.print("<script>alert('删除失败');location.href='wenhuaa.jsp'</script>");
			}	
		}
		out.flush();
		out.close();
	}

}
