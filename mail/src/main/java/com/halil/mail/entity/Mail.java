package com.halil.mail.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mail {
	private @Id @GeneratedValue long id;
	private String mailAddress;

	public Mail(String mailAddress) {

		this.mailAddress = mailAddress;
	}

	public Mail() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	@Override
	public String toString() {
		return "Mail [id=" + id + ", mailAddress=" + mailAddress + "]";
	}

}
