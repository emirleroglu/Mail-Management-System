package com.halil.mail.dataAccess;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.halil.mail.entity.Mail;
import com.halil.mail.repo.MailRepository;

import java.util.List;

@Repository
public class MailDal implements IMailDal {

	private final MailRepository repo;

	@Autowired
	public MailDal(MailRepository repo) {

		this.repo = repo;
	}

	@Override
	public List<Mail> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Mail newMail(Mail newMail) {
		// TODO Auto-generated method stub
		return repo.save(newMail);
	}

	@Override
	public Mail getOnebyID(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Mail updateMail(Mail newMail, long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map(mail -> {
			mail.setMailAddress(newMail.getMailAddress());

			return repo.save(mail);
		}).orElseGet(() -> {
			newMail.setId(id);
			return repo.save(newMail);
		});

	}

	@Override
	public void deleteMail(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);

	}

}
