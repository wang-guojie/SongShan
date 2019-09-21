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
			
			//��ȡ�±�
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
			
			String name="";//�ϴ����ļ�·�� 
	        //�ϴ����ļ���
	        String  uploadFileName="";
	        //���ֶ�Ԫ�ص�name����ֵ
	        String filedName="";
	        //��ȡ��������Ŀ·��
	        String savePath=request.getServletContext().getRealPath("images/");
	        //�ж������е������Ƿ�Ϊmultipart
	        boolean   isMulty=ServletFileUpload.isMultipartContent(request);
	        //���Ϊtrue�����Ǳ��к����ϴ���ǩ
	        if(isMulty)
	        {
	         //������������д���
	         FileItemFactory factory=new DiskFileItemFactory();
	         ServletFileUpload upload=new ServletFileUpload(factory);
	         upload.setSizeMax(100*1024);
	         try{
	           //parseRequest�����������󣬻�ȡ������ı��ֶ�
	           List<FileItem>items=upload.parseRequest(request);
	           for(FileItem item:items)
	           {
	            //�ж�ÿ��Ԫ�� ����ͨ�����ļ�
	            if(item.isFormField()){//true��ͨfalse���ļ�
	            //��ȡԪ��name����ֵ
	            filedName=item.getFieldName();
	            if(filedName.equals("name"))
	            {
	             String value=item.getString("utf-8");
	             out.print(value+"�ϴ����ļ�");
	            }
	            }else{
	            //�����ļ��ϴ� 
	            //1.��ȡ�û��ϴ����ļ���
	            String fileName=item.getName();
	            //�ж��û��Ƿ��ϴ����ļ�
	            if(fileName!=null && !fileName.equals(""))
	            {
	             //�ж��ļ������Ƿ�Ϸ�
	           /*  List<String>typelist=Arrays.asList("jpg","bmp");
	             //���ļ����н�ȡ�ļ�����
	            String type=fileName.substring(filedName.lastIndexOf(".")+1);
	             if(!typelist.contains(type))
	             {
	             out.print("���Ϸ��ļ�");
	             return;
	             }*/
	             //2.����һ���ļ����󣬷�����һ�������ļ�д��
	             File   file=new File(savePath,fileName);
	             //3.���ļ�д�뵽��Ӧ·����
	             item.write(file);
	             out.print("�ļ��ϴ��ɹ��������ǣ�"+"images/"+fileName);
	            }
	            }
	           }
	         }catch(FileUploadBase.SizeLimitExceededException e)
	         {
	          out.print("�ļ�����");
	         }catch(Exception e)
	         {
	        	 e.printStackTrace();
	         }
	        }
			String spotname=request.getParameter("spotname");
			String spotcontext=request.getParameter("spotcontext");
			//�ļ��ϴ�����

			spot s=new spot();
			s.setSpotname(spotname);			
			s.setSpotcontext(spotcontext);
			int result=sl.add(s);
			out.print("{\"result\":\""+result+"\"}");
			/*if(result>0){
				request.getSession().setAttribute("result", "��ӳɹ�");
				request.getRequestDispatcher("index3.jsp").forward(request, response);
			}else{
				request.getSession().setAttribute("result", "���ʧ��");
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
				out.print("<script>alert('�޸ĳɹ�');</script>");
			}else{
				out.print("<script>alert('�޸�ʧ��');</script>");
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
