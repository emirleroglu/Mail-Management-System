package com.halil.mail.business;

import java.io.UnsupportedEncodingException;

import java.util.List;


import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.halil.mail.dataAccess.IMailDal;
import com.halil.mail.entity.Mail;
import com.halil.mail.entity.MailMessage;
import com.halil.mail.entity.MailMessageDetail;
import com.halil.mail.helper.MailHelper;

@Service
public class MailManager implements IMail {

	private IMailDal maildal;

	@Autowired
	public MailManager(IMailDal maildal) {
		super();
		this.maildal = maildal;
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

	public void sendMail(MailMessage msg) {
		Session session = MailHelper.getSession();

		try {

			// Create a default MimeMessage object.

			MimeMessage message1 = new MimeMessage(session);

			// Set from email address

			message1.setFrom(new InternetAddress(MailHelper.getFrom(), "User"));

			// Set the recipient email address

			message1.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(msg.getMailAddress()));

			// Set email subject

			message1.setSubject(msg.getMydetail().getSubject());

			message1.setText(msg.getMydetail().getMsg());

			// Set configs for sending email

			Transport transport = session.getTransport("smtp");

			transport.connect(MailHelper.getHost(), MailHelper.getFrom(), MailHelper.getPassword());

			// Send email

			transport.sendMessage(message1, message1.getAllRecipients());

			transport.close();

			System.out.println("done");

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		} catch (AddressException e) {

			e.printStackTrace();

		} catch (javax.mail.MessagingException e) {

			e.printStackTrace();

		}

	}

	public void sendMail(MailMessageDetail myDetail, long id) {
		Session session = MailHelper.getSession();

		try {
			MimeMessage message1 = new MimeMessage(session);
			message1.setFrom(new InternetAddress(MailHelper.getFrom(), "User"));

			message1.addRecipient(MimeMessage.RecipientType.TO,
					new InternetAddress(maildal.getOnebyID(id).getMailAddress()));
			message1.setSubject(myDetail.getSubject());

			message1.setText(myDetail.getMsg());
			Transport transport = session.getTransport("smtp");

			transport.connect(MailHelper.getHost(), MailHelper.getFrom(), MailHelper.getPassword());
			transport.sendMessage(message1, message1.getAllRecipients());

			transport.close();

			System.out.println("done");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		} catch (AddressException e) {

			e.printStackTrace();

		} catch (javax.mail.MessagingException e) {

			e.printStackTrace();

		}

	}

	@Override
	public void sendMailAll(MailMessageDetail myDetail) {
		Session session = MailHelper.getSession();
		try {

			MimeMessage message1 = new MimeMessage(session);

			message1.setFrom(new InternetAddress(MailHelper.getFrom(), "User"));

			List<Mail> emails = this.maildal.getAll();

			InternetAddress[] addresses = new InternetAddress[emails.size()];

			for (int i = 0; i < emails.size(); i++) {
				addresses[i] = new InternetAddress(emails.get(i).getMailAddress());

			}

			message1.addRecipients(MimeMessage.RecipientType.TO, addresses);

			message1.setSubject(myDetail.getSubject());

			message1.setText(myDetail.getMsg());

			Transport transport = session.getTransport("smtp");

			transport.connect(MailHelper.getHost(), MailHelper.getFrom(), MailHelper.getPassword());

			transport.sendMessage(message1, message1.getAllRecipients());

			transport.close();

			System.out.println("done");

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		} catch (AddressException e) {

			e.printStackTrace();

		} catch (javax.mail.MessagingException e) {

			e.printStackTrace();

		}

	}

}
