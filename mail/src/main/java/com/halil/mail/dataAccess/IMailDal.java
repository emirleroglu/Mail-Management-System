package com.halil.mail.dataAccess;

import java.util.List;


import com.halil.mail.entity.Mail;

public interface IMailDal {
	List<Mail> getAll();

	Mail newMail(Mail newMail);

	Mail getOnebyID(long id);

	Mail updateMail(Mail newMail, long id);

	void deleteMail(long id);
}
