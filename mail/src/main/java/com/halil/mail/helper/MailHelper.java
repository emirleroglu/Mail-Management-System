package com.halil.mail.helper;

import java.util.Properties;

import javax.mail.Session;

public class MailHelper {
	private final static String from = "your-email-addresses";

	private final static String host = "smtp.gmail.com";

	private final static String port = "587";

	private final static String user = "your-email-addresses";

	private final static String password = "password";

	public static Session getSession() {
		Properties properties = System.getProperties();

		properties.put("mail.smtp.auth", "true");

		properties.setProperty("mail.smtp.host", host);

		properties.setProperty("mail.smtp.port", port);

		properties.setProperty("mail.smtp.user", user);

		properties.setProperty("mail.smtp.password", password);

		properties.setProperty("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(properties);
		return session;

	}

	public static String getFrom() {
		return from;
	}

	public static String getHost() {
		return host;
	}

	public static String getPort() {
		return port;
	}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}

}
