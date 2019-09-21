package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upload extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		try {
			// 得到上传文件的保存目录。 将上传的文件存放于服务器目录下
			String realPath = this.getServletContext().getRealPath("../upload");

			System.out.println("文件存放位置:" + realPath);
			// 设置临时目录。 上传文件大于缓冲区则先放于临时目录中
			String tempPath = "E:\\tempPath";
			System.out.println("临时文件存放位置:" + tempPath);

			// 判断存放上传文件的目录是否存在（不存在则创建）
			File f = new File(realPath);
			if (!f.exists() && !f.isDirectory()) {
				System.out.println("目录或文件不存在! 创建目标目录。");
				f.mkdir();
			}
			// 判断临时目录是否存在（不存在则创建）
			File f1 = new File(tempPath);
			if (!f1.isDirectory()) {
				System.out.println("临时文件目录不存在! 创建临时文件目录");
				f1.mkdir();
			}

			/**
			 * 使用文件上传组件处理文件上传：
			 * 
			 * */
			// 创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// 设置上传文件的临时目录
			factory.setRepository(f1);

			// 创建一个文件上传解析器。
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 统一文件编码
			upload.setHeaderEncoding("UTF-8");

			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				System.out.println("不是上传文件，终止");
				return;
			}

			// 限制总上传文件大小(10M)
			// upload.setSizeMax(1024*1024*6);

			// 使用ServletFileUpload解析器解析上传数据
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {

				if (!item.isFormField()) {
					// 上传文件的名
					String fileName = item.getName();

					// 如果上传的文件是不存在或者是空的则获取下一个文件
					if (fileName == null || "".equals(fileName.trim())) { // 去空格是否为空
						continue;
					}

					// 处理上传文件的文件名的路径，截取字符串只保留文件名部分
					fileName = fileName
							.substring(fileName.lastIndexOf(".") + 1);
					// 将当前系统时间的年月日拼成上传的文件名
					Date dNow = new Date();
					SimpleDateFormat ft = new SimpleDateFormat(
							"yyyyMMdd_hhmmss");
					fileName = ft.format(dNow) + "." + fileName;
					System.out.println("文件名:" + fileName);
					// 拼接上传路径。存放路径+上传的文件名
					String filePath = realPath + "\\" + fileName;
					// 构建输入输出流
					InputStream in = item.getInputStream(); // 获取item中的上传文件的输入流
					OutputStream o = new FileOutputStream(filePath); // 创建一个文件输出流

					// 创建一个缓冲区
					byte b[] = new byte[1024];
					// 判断输入流中的数据是否已经读完的标识
					int len = -1;
					// 循环将输入流读入到缓冲区当中
					while ((len = in.read(b)) != -1) { // 没数据了返回-1
						// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录当中
						o.write(b, 0, len);
					}
					// 关闭流
					o.close();
					in.close();
					// 删除临时文件
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					item.delete(); // 删除处理文件上传时生成的临时文件
					System.out.println("文件上传成功");

					out.print("/upload/" + fileName);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			out.print("erro");
		} finally {
			out.flush();
			out.close();
		}

	}

}
