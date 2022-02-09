package com.halil.mail.business;



import java.util.List;


import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.halil.mail.dataAccess.IMailDal;
import com.halil.mail.entity.Mail;
import com.halil.mail.entity.MailMessage;
import com.halil.mail.entity.MailMessageDetail;


@Service
public class MailManager implements IMail {

    private IMailDal maildal;
    private final JavaMailSender mailSender;

    @Autowired
    public MailManager(IMailDal maildal, JavaMailSender mailSender) {
        super();
        this.maildal = maildal;
        this.mailSender = mailSender;
    }

    @Override
    public List<Mail> getAll() {
        // TODO Auto-generated method stub
        return this.maildal.getAll();
    }

    @Override
    public Mail newMail(Mail newMail) {
        // TODO Auto-generated method stub
        return this.maildal.newMail(newMail);
    }

    @Override
    public Mail getOnebyID(long id) {
        // TODO Auto-generated method stub
        return maildal.getOnebyID(id);
    }

    @Override
    public Mail updateMail(Mail newMail, long id) {
        // TODO Auto-generated method stub
        return maildal.updateMail(newMail, id);
    }

    @Override
    public void deleteMail(long id) {
        // TODO Auto-generated method stub
        this.maildal.deleteMail(id);

    }


    @Async
    public void sendMail(MailMessage msg) {


        try {

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(msg.getMydetail().getMsg(),true);
            helper.setTo(msg.getMailAddress());
            helper.setSubject(msg.getMydetail().getSubject());
            helper.setFrom("emirlerogluhalil@gmail.com");
            mailSender.send(mimeMessage);

        } catch (AddressException e) {

            e.printStackTrace();

        } catch (javax.mail.MessagingException e) {

            e.printStackTrace();

        }

    }
    @Async
    public void sendMail(MailMessageDetail myDetail, long id) {


        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(myDetail.getMsg(), true);
            helper.setTo(maildal.getOnebyID(id).getMailAddress());
            helper.setSubject(myDetail.getSubject());
            helper.setFrom("emirlerogluhalil@gmail.com");
            mailSender.send(mimeMessage);


        } catch (AddressException e) {

            e.printStackTrace();

        } catch (javax.mail.MessagingException e) {

            e.printStackTrace();

        }

    }

    @Override
    @Async
    public void sendMailAll(MailMessageDetail myDetail) {

        try {


            List<Mail> emails = this.maildal.getAll();

            InternetAddress[] addresses = new InternetAddress[emails.size()];

            for (int i = 0; i < emails.size(); i++) {
                addresses[i] = new InternetAddress(emails.get(i).getMailAddress());

            }
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(myDetail.getMsg(),true);
            helper.setTo(addresses);
            helper.setSubject(myDetail.getSubject());
            helper.setFrom("emirlerogluhalil@gmail.com");
            mailSender.send(mimeMessage);


            System.out.println("done");

        } catch (AddressException e) {

            e.printStackTrace();

        } catch (javax.mail.MessagingException e) {

            e.printStackTrace();

        }

    }

}
