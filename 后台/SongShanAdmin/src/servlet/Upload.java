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
			// �õ��ϴ��ļ��ı���Ŀ¼�� ���ϴ����ļ�����ڷ�����Ŀ¼��
			String realPath = this.getServletContext().getRealPath("../upload");

			System.out.println("�ļ����λ��:" + realPath);
			// ������ʱĿ¼�� �ϴ��ļ����ڻ��������ȷ�����ʱĿ¼��
			String tempPath = "E:\\tempPath";
			System.out.println("��ʱ�ļ����λ��:" + tempPath);

			// �жϴ���ϴ��ļ���Ŀ¼�Ƿ���ڣ��������򴴽���
			File f = new File(realPath);
			if (!f.exists() && !f.isDirectory()) {
				System.out.println("Ŀ¼���ļ�������! ����Ŀ��Ŀ¼��");
				f.mkdir();
			}
			// �ж���ʱĿ¼�Ƿ���ڣ��������򴴽���
			File f1 = new File(tempPath);
			if (!f1.isDirectory()) {
				System.out.println("��ʱ�ļ�Ŀ¼������! ������ʱ�ļ�Ŀ¼");
				f1.mkdir();
			}

			/**
			 * ʹ���ļ��ϴ���������ļ��ϴ���
			 * 
			 * */
			// ����һ��DiskFileItemFactory����
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// �����ϴ��ļ�����ʱĿ¼
			factory.setRepository(f1);

			// ����һ���ļ��ϴ���������
			ServletFileUpload upload = new ServletFileUpload(factory);
			// ͳһ�ļ�����
			upload.setHeaderEncoding("UTF-8");

			// 3���ж��ύ�����������Ƿ����ϴ���������
			if (!ServletFileUpload.isMultipartContent(request)) {
				System.out.println("�����ϴ��ļ�����ֹ");
				return;
			}

			// �������ϴ��ļ���С(10M)
			// upload.setSizeMax(1024*1024*6);

			// ʹ��ServletFileUpload�����������ϴ�����
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {

				if (!item.isFormField()) {
					// �ϴ��ļ�����
					String fileName = item.getName();

					// ����ϴ����ļ��ǲ����ڻ����ǿյ����ȡ��һ���ļ�
					if (fileName == null || "".equals(fileName.trim())) { // ȥ�ո��Ƿ�Ϊ��
						continue;
					}

					// �����ϴ��ļ����ļ�����·������ȡ�ַ���ֻ�����ļ�������
					fileName = fileName
							.substring(fileName.lastIndexOf(".") + 1);
					// ����ǰϵͳʱ���������ƴ���ϴ����ļ���
					Date dNow = new Date();
					SimpleDateFormat ft = new SimpleDateFormat(
							"yyyyMMdd_hhmmss");
					fileName = ft.format(dNow) + "." + fileName;
					System.out.println("�ļ���:" + fileName);
					// ƴ���ϴ�·�������·��+�ϴ����ļ���
					String filePath = realPath + "\\" + fileName;
					// �������������
					InputStream in = item.getInputStream(); // ��ȡitem�е��ϴ��ļ���������
					OutputStream o = new FileOutputStream(filePath); // ����һ���ļ������

					// ����һ��������
					byte b[] = new byte[1024];
					// �ж��������е������Ƿ��Ѿ�����ı�ʶ
					int len = -1;
					// ѭ�������������뵽����������
					while ((len = in.read(b)) != -1) { // û�����˷���-1
						// ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼����
						o.write(b, 0, len);
					}
					// �ر���
					o.close();
					in.close();
					// ɾ����ʱ�ļ�
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					item.delete(); // ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
					System.out.println("�ļ��ϴ��ɹ�");

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
