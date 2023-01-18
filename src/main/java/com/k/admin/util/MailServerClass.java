package com.k.admin.util;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServerClass {
	
	
	@Autowired
	private JavaMailSender  javaMailSender;
	
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	public void sendMail(Map<String,Object> m)
	{
		
		MimeMessage mime=javaMailSender.createMimeMessage();
		MimeMessageHelper helper= new MimeMessageHelper(mime);
		try {
			helper.setFrom(fromEmail);
			helper.setTo("kanhaiya12468@gmail.com");
			helper.setSubject("teststs");
			helper.setText(m.toString());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
