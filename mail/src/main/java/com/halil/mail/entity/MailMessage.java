package com.halil.mail.entity;

public class MailMessage {
	MailMessageDetail mydetail;
	String mailAddress;

	public MailMessage(MailMessageDetail mydetail, String mailAddress) {

		this.mydetail = mydetail;
		this.mailAddress = mailAddress;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public MailMessageDetail getMydetail() {
		return mydetail;
	}

	public void setMydetail(MailMessageDetail mydetail) {
		this.mydetail = mydetail;
	}

}
