package com.sevenliu.mail;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 参考: http://www.baeldung.com/spring-email
 */
public class TestSpringEmail {

    public static void main(String[] args) {
        sendTextEmail();
    }

    public static void sendTextEmail() {
        // 邮件发送者
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(587);// 端口号
        mailSender.setUsername("582212740@qq.com");
        mailSender.setPassword("eugmhxzdgtcubfja"); // 授权码

        // 邮件信息
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("582212740@qq.com");
        msg.setTo("18519118863@163.com");
        msg.setSubject("加油，小赛"); // 标题
        msg.setText("希望你今后一帆风顺，调整好心态，再出发！！！"); // 文本信息

        // 发送
        try {
            mailSender.send(msg);
            System.out.println("邮件发送成功!"); // 没有报错就是好消息 :-)
        } catch (MailException ex) {
            System.err.println("发送失败:" + ex.getMessage());
        }
    }

}
