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
	
	// 发件人
	private static String senderAddress = "1213555831@qq.com";
	// 收件人
	public static String recipientAddress = "";
	// 发件人账户
	private static String senderAccount = "1213555831@qq.com";
	// 发件人密令
	private static String senderPassword = "wfikrmstlfmbijbe";
	// 邮件标题
	public static String emailTitle = "";
	// 邮件正文
	public static String emailText = "";
	
	public static void sender() {
		// 链接邮件的参数配置
		Properties props = new Properties();
		// 设置用户的认证方式
		props.setProperty("mail.smtp.auth", "true");
		// 设置传输协议
		props.setProperty("mail.transport.protocol", "smtp");
		// 设置发件人的服务器地址
		props.setProperty("mail.smtp.host", "smtp.qq.com");
		
		// 创建定义整个应用程序所需要的环境信息的Session对象
		Session session = Session.getInstance(props);
		
		try {
			// 创建邮件的实例对象
			Message msg = getMimeMessage(session);
			
			// 根据session对象获取邮件传输对象
			Transport transport = session.getTransport();
			// 设置发件人的账户和密码
			transport.connect(senderAccount, senderPassword);
			// 发送邮件
			transport.sendMessage(msg, msg.getAllRecipients());
			
			// 关闭
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
		
		// 创建一封邮件的实例对象
		MimeMessage msg = new MimeMessage(session);
		// 设置发件人地址
		msg.setFrom(new InternetAddress(senderAddress));
		
		// 设置收件人地址
		msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipientAddress));
		// 设置邮件主题
		msg.setSubject(emailTitle,"UTF-8");
		// 设置邮件正文
		msg.setContent(emailText,"text/html;charset=UTF-8");
		
		// 发送
		msg.setSentDate(new Date());
		
		return msg;
		
	}
	
	
}
