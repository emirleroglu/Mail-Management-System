package com.halil.mail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.halil.mail.business.IMail;
import com.halil.mail.entity.Mail;
import com.halil.mail.entity.MailMessage;
import com.halil.mail.entity.MailMessageDetail;

@RestController
public class MailController {
	private IMail mail;

	@Autowired
	public MailController(IMail mail) {
		super();
		this.mail = mail;
	}

	@GetMapping("/mails")
	public List<Mail> getAll() {
		return this.mail.getAll();
	}

	@PostMapping("/mails")
	Mail newMail(@RequestBody Mail newMail) {
		return this.mail.newMail(newMail);
	}

	@GetMapping("/mails/{id}")
	Mail getOneById(@PathVariable Long id) {

		return this.mail.getOnebyID(id);
	}

	@PutMapping("mails/{id}")
	Mail updateMail(@RequestBody Mail newMail, @PathVariable long id) {
		return this.mail.updateMail(newMail, id);
	}

	@DeleteMapping("mails/{id}")
	void deleteMail(@PathVariable long id) {
		this.mail.deleteMail(id);
	}

	@PostMapping("sendMail")
	void sendMail(@RequestBody MailMessage msg) {
		this.mail.sendMail(msg);
	}

	@PostMapping("sendMail/{id}")
	void sendMail(@RequestBody MailMessageDetail myDetail, @PathVariable long id) {
		this.mail.sendMail(myDetail, id);
	}

	@PostMapping("sendMailAll")
	void sendMailAll(@RequestBody MailMessageDetail myDetail) {
		this.mail.sendMailAll(myDetail);
	}

}
