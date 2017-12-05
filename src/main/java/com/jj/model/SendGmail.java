package com.jj.model;

import com.google.api.client.util.Base64;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

import static com.jj.model.Quickstart.getGmailService;

public class SendGmail {
    public String sendMail()
    {
        try {
            Gmail service = getGmailService();
            MimeMessage email = createEmail("joannes.webd@gmail.com", "jp2smart@gmail.com", "Subject: dope", "Body: dope");
            sendMessage(service, "me", email);
            return "email sent successfully";
        }catch (Exception ex)
        {
            return ex.getMessage();
        }
    }


    public static void sendMessage(Gmail service, String userId, MimeMessage email) throws MessagingException, IOException,Exception{
        Message message = createMessageWithEmail(email);
        message = service.users().messages().send(userId, message).execute();

        System.out.println("Message id: " + message.getId());
        System.out.println(message.toPrettyString());
    }
    public static Message createMessageWithEmail(MimeMessage email) throws MessagingException, IOException, Exception {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        email.writeTo(bytes);
        String encodedEmail = Base64.encodeBase64URLSafeString(bytes.toByteArray());
        Message message = new Message();
        message.setRaw(encodedEmail);
        return message;
    }
    public static MimeMessage createEmail(String to, String from, String subject,
                                          String bodyText) throws MessagingException,Exception {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);
        InternetAddress tAddress = new InternetAddress(to);
        InternetAddress fAddress = new InternetAddress(from);

        email.setFrom(new InternetAddress(from));
        email.addRecipient(javax.mail.Message.RecipientType.TO,
                new InternetAddress(to));
        email.setSubject(subject);
        email.setText(bodyText);
        return email;
    }

}
