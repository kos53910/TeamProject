package com.gt.s.common.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GoogleMailSender {
	
	
	public void googleMailSender(String mailSubject, String resiveMail, String sendMsg, String writer) {
		
		System.out.println("googleMailSender mailSubject >>> : " 	+ mailSubject);
		System.out.println("googleMailSender resiveMail >>> "	 	+ resiveMail);
		System.out.println("googleMailSender sendMsg >>> : " 		+ sendMsg);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("kos5391025@gmail.com", "kfrgmbujoyrzvcyv");
			}
		});
		
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(resiveMail, writer, "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(resiveMail));
			message.setSubject(mailSubject);
			message.setContent(sendMsg, "text/html; charset=utf-8");

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		
		String mailSubject = "테스트 메일입니다.";
		String resiveMail = "kos53910@naver.com";
		String sendMsg = "<h2 style='color:blue'>안녕하세요 테스트 메일 입니다.</h2>";
		
		GoogleMailSender gms = new GoogleMailSender();
		gms.googleMailSender(mailSubject, resiveMail, sendMsg, "writer");
	}
}
