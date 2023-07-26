/*
 * package com.green.rfp.qa.utility; import java.io.BufferedInputStream; import
 * java.io.File; import java.io.FileInputStream; import
 * java.io.FileNotFoundException; import java.io.IOException; import
 * java.util.zip.ZipEntry; import java.util.zip.ZipOutputStream;
 * 
 * public class FileHelper { ConfigReader con =new ConfigReader();
 * 
 * // public static long PAGE_LOAD_TIMEOUT =
 * Integer.parseInt(con.getconfigdData("PAGE_LOAD_TIMEOUT"));
 * 
 * public static void zipDirectory(File folder, String parentFolder,
 * ZipOutputStream zos) throws FileNotFoundException, IOException { int
 * BUFFER_SIZE = 4096;
 * 
 * for (File file : folder.listFiles()) { if (file.isDirectory()) {
 * zipDirectory(file, parentFolder + "/" + file.getName(), zos); continue; }
 * zos.putNextEntry(new ZipEntry(parentFolder + "/" + file.getName()));
 * BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
 * long bytesRead = 0; byte[] bytesIn = new byte[BUFFER_SIZE]; int read = 0;
 * while ((read = bis.read(bytesIn)) != -1) { zos.write(bytesIn, 0, read);
 * bytesRead += read; } zos.closeEntry(); } }
 * 
 * 
 * }
 */

package com.green.rfp.qa.utility;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailHelper {
	String MAIL_DRIVER = "SMTP";
	static String MAIL_HOST = "email-smtp.us-east-1.amazonaws.com";
	static String MAIL_PORT = "587";
	static String MAIL_USERNAME = "AKIAI4CLBCUDSN6EC5GQ";
	String MAIL_PASSWORD = "AplZJJ/GYh3XZsxvQ5B8O2D+Cz4aPWc30tEDfX5gHh4H";
	String MAIL_ENCRYPTION = "TLS";
	static String mail_no_reply = "no-reply@thegreenrfp.com";

	public static void main(String[] args) {
		String to = "subhashish.deb@codeclouds.in";
		String from = mail_no_reply;
		String host = MAIL_HOST;
		final String username = MAIL_USERNAME;
		final String password = "MAIL_PASSWORD";
		System.out.println("TLSEmail Start");
		Properties properties = System.getProperties();
		  // If you need to authenticate

		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.port", MAIL_PORT);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try

		{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Test Mail");
			message.setText("Hello, This is a Test Mail.");
			Transport.send(message);
			System.out.println("Yo it has been sent..");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
