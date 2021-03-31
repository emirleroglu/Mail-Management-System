package com.halil.mail.business;

import java.util.List;

import com.halil.mail.entity.Mail;
import com.halil.mail.entity.MailMessage;
import com.halil.mail.entity.MailMessageDetail;

public interface IMail {
	List<Mail> getAll();

	Mail newMail(Mail newMail);

	Mail getOnebyID(long id);

	Mail updateMail(Mail newMail, long id);

	void deleteMail(long id);

	void sendMail(MailMessage mail);

	void sendMail(MailMessageDetail myDetail, long id);

	void sendMailAll(MailMessageDetail myDetail);
}
