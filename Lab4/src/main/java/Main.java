/**
 * Created by schiduvasile on 5/8/17.
 */


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;


public class Main {

    public static void main(String[] args) {

        final String username = "schidu.vasile@gmail.com";
        final String password = "nu6tyupre4ys";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); // smtp server addres
        properties.put("mail.smtp.port", "587"); // port for the smtp server address

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthenticator() {
                        return new PasswordAuthentication(username, password);
                    }

                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("schidu.vasile@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, InternetAddress.parse("sckeedoo@gmail.com"));
            message.setSubject("My First Mail");
            message.setContent("This is a test mail, dont be scared");
            Transport.send(message);

            System.out.println("Message was sent succesfuly");

        }
        catch (MessagingException e) {
            throw new RuntimeException(e);
        }



        System.out.println("Helo world!!");

    }
}
