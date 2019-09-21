package unit;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Mail {
	
	// ������
	private static String senderAddress = "1213555831@qq.com";
	// �ռ���
	public static String recipientAddress = "";
	// �������˻�
	private static String senderAccount = "1213555831@qq.com";
	// ����������
	private static String senderPassword = "wfikrmstlfmbijbe";
	// �ʼ�����
	public static String emailTitle = "";
	// �ʼ�����
	public static String emailText = "";
	
	public static void sender() {
		// �����ʼ��Ĳ�������
		Properties props = new Properties();
		// �����û�����֤��ʽ
		props.setProperty("mail.smtp.auth", "true");
		// ���ô���Э��
		props.setProperty("mail.transport.protocol", "smtp");
		// ���÷����˵ķ�������ַ
		props.setProperty("mail.smtp.host", "smtp.qq.com");
		
		// ������������Ӧ�ó�������Ҫ�Ļ�����Ϣ��Session����
		Session session = Session.getInstance(props);
		
		try {
			// �����ʼ���ʵ������
			Message msg = getMimeMessage(session);
			
			// ����session�����ȡ�ʼ��������
			Transport transport = session.getTransport();
			// ���÷����˵��˻�������
			transport.connect(senderAccount, senderPassword);
			// �����ʼ�
			transport.sendMessage(msg, msg.getAllRecipients());
			
			// �ر�
			transport.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static MimeMessage getMimeMessage(Session session) throws Exception {
		
		// ����һ���ʼ���ʵ������
		MimeMessage msg = new MimeMessage(session);
		// ���÷����˵�ַ
		msg.setFrom(new InternetAddress(senderAddress));
		
		// �����ռ��˵�ַ
		msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipientAddress));
		// �����ʼ�����
		msg.setSubject(emailTitle,"UTF-8");
		// �����ʼ�����
		msg.setContent(emailText,"text/html;charset=UTF-8");
		
		// ����
		msg.setSentDate(new Date());
		
		return msg;
		
	}
	
	
}
