package utility;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;

import javax.activation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendAttachmentInEmail {
	   public static void SendReport(String args) {
		// TODO Auto-generated method stub
		  System.out.println("Test");
		  final String username = "subhankahghr.panigrahi@gmail.com";
		    final String password = "zpftqgohghghgfvgxqgioap";

		    Properties props = new Properties();
		    props.put("mail.smtp.auth", true);
		    props.put("mail.smtp.starttls.enable", true);
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", "587");

		    // Session session = Session.getDefaultInstance(props, null);
		    Session session = Session.getInstance(props,
		              new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication("subhankar.panigraghgfhgfhi@gmail.com", "zpftqghghgfhgfovgxqgioap");
		                }
		              });


		    Message msg = new MimeMessage(session);
		    try {
		        msg.setFrom(new InternetAddress("subhankar.panihghghgfgrahi@gmail.com"));
		        msg.setRecipient(Message.RecipientType.TO, new InternetAddress("subhahghghgfnkar.panigrahi@gmail.com"));
		        msg.setSubject("Automated Testest execution Report");

		        Multipart multipart = new MimeMultipart();

		        MimeBodyPart textBodyPart = new MimeBodyPart();
		        textBodyPart.setText("Hi, Please find the attached test results attached in this email");

		        MimeBodyPart attachmentBodyPart= new MimeBodyPart();
		        DataSource source = new FileDataSource("..\\TestNG-Maven-Selenium\\extent.html"); // ex : "C:\\test.pdf"
		        
		        attachmentBodyPart.setDataHandler(new DataHandler(source));
		        attachmentBodyPart.setFileName("extent.html"); // ex : "test.pdf"

		        multipart.addBodyPart(textBodyPart);  // add the text part
		        multipart.addBodyPart(attachmentBodyPart); // add the attachement part

		        msg.setContent(multipart);


		        Transport.send(msg);
		    } catch (MessagingException e) {
		    	System.out.println(e.getMessage());
		    }

	}

}
