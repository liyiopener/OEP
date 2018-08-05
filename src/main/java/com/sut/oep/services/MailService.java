package com.sut.oep.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;
    @Qualifier("templateEngine")
    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Value("${spring.mail.username}")
    private String from;

    //账号激活
    public void activeAcc(String identcode,String eamil){
        Context context = new Context();
        context.setVariable("identcode", identcode);
        String emailContent = springTemplateEngine.process("emailTemplate/emailTemplate", context);
        sendHtmlMail(eamil,"来自OEP的验证邮件",emailContent);
    }
    //发送html邮件
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);
            logger.info("html邮件发送成功");
        } catch (MessagingException e) {
            logger.error("发送html邮件时发生异常！", e);
        }
    }
}