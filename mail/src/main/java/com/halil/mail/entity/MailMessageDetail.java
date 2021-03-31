package com.halil.mail.entity;

public class MailMessageDetail {
	private String subject;
	private String msg;
	public MailMessageDetail(String subject, String msg) {
		
		this.subject = subject;
		this.msg = msg;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
}
