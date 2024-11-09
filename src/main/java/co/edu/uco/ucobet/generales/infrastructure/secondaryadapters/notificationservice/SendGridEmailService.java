package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice;

import co.edu.uco.ucobet.generales.crosscutting.exception.InfrastructureUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendGridEmailService {

    @Value("${sendgrid.from.email}")
    private String fromEmail;

    @Value("${sendgrid.from.name}")
    private String fromName;

    @Value("${sendgrid.to.email}")
    private String toEmail;

    @Value("${sendgrid.api.key}")
    private String apiKey;

    public void sendEmail(String subject, String messageContent) {
        Email from = new Email(fromEmail, fromName);
        Email to = new Email(toEmail);
        Content content = new Content("text/plain", messageContent);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);
        } catch (IOException ex) {
            throw InfrastructureUcobetException.create(MessageCatalogStrategy.getMessageContent(MessageCode.MMAIL0002));
        }
    }

}
