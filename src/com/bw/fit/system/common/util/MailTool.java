package com.bw.fit.system.common.util;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.alibaba.fastjson.*;

import com.sun.mail.util.MailSSLSocketFactory;

public class MailTool {

	public static JSONObject send(String subject, StringBuilder content,
			InternetAddress[] recievers) {
		JSONObject json = new JSONObject();
		json.put("res", "1");
		try {
			Properties props = new Properties();
			// 开启debug调试
			props.setProperty("mail.debug", "false");
			// 发送服务器需要身份验证
			props.setProperty("mail.smtp.auth", "true");
			// 设置邮件服务器主机名
			props.setProperty("mail.host", "smtp.qq.com");
			// 发送邮件协议名称
			props.setProperty("mail.transport.protocol", "smtp");
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.socketFactory", sf);
			Session session = Session.getInstance(props);
			Message msg = new MimeMessage(session);
			msg.setSubject(subject);
			msg.setText(content.toString());
			msg.setFrom(new InternetAddress(PropertiesUtil
					.getValueByKey("system.mail.server.id")));
			Transport transport = session.getTransport();
			transport.connect("smtp.qq.com",
					PropertiesUtil.getValueByKey("system.mail.server.id"),
					PropertiesUtil.getValueByKey("system.mail.server.passwd"));

			transport.sendMessage(msg, recievers);
			transport.close();
			json = new JSONObject();
			json.put("res", "2");
			json.put("msg", "发送成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.put("msg", e.getMessage());
		} finally {
			return json;
		}
	}

	public static void main(String[] args) throws MessagingException,
			GeneralSecurityException {
		Properties props = new Properties();
		// 开启debug调试
		props.setProperty("mail.debug", "false");
		// 发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", "true");
		// 设置邮件服务器主机名
		props.setProperty("mail.host", "smtp.qq.com");
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");

		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);

		Session session = Session.getInstance(props);

		Message msg = new MimeMessage(session);
		msg.setSubject("seenews 错误");
		StringBuilder builder = new StringBuilder();
		builder.append("url = "
				+ "http://blog.csdn.net/never_cxb/article/details/50524571");
		builder.append("\n页面爬虫错误");
		builder.append("\n时间 " + "2017-10-12");
		msg.setText(builder.toString());
		msg.setFrom(new InternetAddress(PropertiesUtil
				.getValueByKey("system.mail.server.id")));

		Transport transport = session.getTransport();
		transport.connect("smtp.qq.com",
				PropertiesUtil.getValueByKey("system.mail.server.id"),
				PropertiesUtil.getValueByKey("system.mail.server.passwd"));

		transport.sendMessage(msg, new InternetAddress[] { new InternetAddress(
				"75706075@qq.com") });
		transport.close();
	}

}
