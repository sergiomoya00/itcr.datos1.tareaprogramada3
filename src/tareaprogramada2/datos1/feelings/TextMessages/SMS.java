package tareaprogramada2.datos1.feelings.TextMessages;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMS {
	
	public static void enviarFichaSMS(String telefono, String ficha, String nombre) {//Envia un corre con la ficha 
	    java.util.Date fecha = new Date();
	    String remitente = "tareaprogramada2018ati@gmail.com";
	    String clave = "aati2018";
	    String asunto = "[Ficha]";
	    String cuerpo = ("Bienvenido a TEC Emergency" + "\n" + nombre + " Su ficha es: " + ficha + "\n" + fecha);
	    String from= "506" + telefono + "@txtlocal.co.uk";
	    
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", clave);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.setRecipients(Message.RecipientType.TO, from);
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, clave);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	        System.out.println("EXITO");
	    }
	    catch (MessagingException me) {
	    	System.out.println("ERROR");
	        me.printStackTrace();
	    }
	}

}
