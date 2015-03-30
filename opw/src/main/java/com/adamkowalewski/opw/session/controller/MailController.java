/*
 * The MIT License
 *
 * Copyright 2015 Adam Kowalewski.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.adamkowalewski.opw.session.controller;

import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.session.dto.MailWelcomeDto;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Provides reusable logic related to E-Mail in- and outbound.
 *
 * @author Adam Kowalewski
 */
@Stateless
public class MailController {

    @Resource(name = "mail/opw")
    private Session mailSession;

    public boolean sendMailWelcome(OpwUser user, String passwordPlain) {
        // TODO refactoring needed !
        Message message = new MimeMessage(mailSession);
        String subject = "Otwarta Platforma Wyborcza - rejestracja";

        MailWelcomeDto payload = new MailWelcomeDto(user.getEmail(), passwordPlain, prepareActivationLink(user));

        try {
            String content = getContentWelcome(payload);

            Address singleReceiver = new InternetAddress(user.getEmail());
            message.setFrom(new InternetAddress("opw@adamkowalewski.com", "Otwarta Platforma Wyborcza"));
            message.setRecipient(Message.RecipientType.TO, singleReceiver);

            message.setSubject(subject);
            message.setContent(content, "text/plain; charset=UTF-8");
            System.out.println("contenr " + content);
//            Transport.send(message);

        } catch (UnsupportedEncodingException | MessagingException ex) {
            System.out.println(ex);
            System.out.println("failed");
            return false;
        } catch (IOException | TemplateException ex) {
            Logger.getLogger(MailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("nowe haslo");
        return true;
    }

    public boolean sendMailPasswordNew(OpwUser user, String passwordPlain) {
        // TODO refactoring needed !
        Message message = new MimeMessage(mailSession);
        String subject = "Otwarta Platforma Wyborcza - nowe hasło";
        MailWelcomeDto payload = new MailWelcomeDto(user.getEmail(), passwordPlain, "");

        try {
            String content = getContentNewPwdHardcoded(payload);

            Address singleReceiver = new InternetAddress(user.getEmail());
            message.setFrom(new InternetAddress("opw@adamkowalewski.com", "Otwarta Platforma Wyborcza"));
            message.setRecipient(Message.RecipientType.TO, singleReceiver);

            message.setSubject(subject);
            message.setContent(content, "text/plain; charset=UTF-8");
            Transport.send(message);

        } catch (UnsupportedEncodingException | MessagingException ex) {
            System.out.println(ex);
            System.out.println("failed");
            return false;
        }
        return true;
    }

    /**
     * Ugly but works for now.
     *
     * @param payload
     * @return
     */
    private String getContentWelcomeHardcoded(MailWelcomeDto payload) {

        String content = "Witaj w Otwartej Platformie Wyborczej (OPW)!\n"
                + "\n"
                + "Oto twoje dane dostępowe: \n"
                + "Login: " + payload.getLogin() + "\n"
                + "Hasło: " + payload.getPassword() + "\n"
                + "\n"
                + "\n"
                + "Kliknij w poniższy link lub skopiuj go do okna przeglądarki, aby potwierdźić adres E-Mail i aktywować konto:\n"
                + payload.getLink() + "\n"
                + "\n"
                + "Możesz kliknąć na powyższy adres lub skopiować go do przeglądarki - w drugim przypadku zrób to dokładnie i upewnij się, że nie ma w adresie dodatkowych spacji.\n"
                + "\n"
                + "\n"
                + "Pozdrawiamy\n"
                + "Zespół OPW\n"
                + "";
        return content;
    }

    private String getContentNewPwdHardcoded(MailWelcomeDto payload) {
        String content = "Witaj!\n"
                + "\n"
                + "Oto nowe dane dostępowe: \n"
                + "Login: " + payload.getLogin() + "\n"
                + "Hasło: " + payload.getPassword() + "\n"
                + "\n"
                + "\n"
                + "Pozdrawiamy\n"
                + "Zespół OPW\n"
                + "\n"
                + "";
        return content;
    }

    /**
     * Returns E-Mail content generated with FreeMarker template.
     *
     * @param payload DTO instance.
     * @return String representation of content.
     * @throws IOException
     * @throws TemplateException
     * @author Adam Kowalewski
     * @version 2015.03.29
     */
    public String getContentWelcome(MailWelcomeDto payload) throws IOException, TemplateException {
        Configuration cfg = prepareFreemarkerConfig();
        Template templ = cfg.getTemplate("welcome_plain.ftl");
        Writer out = new StringWriter();
        templ.process(payload, out);

        return out.toString();
    }

    /**
     * Creates default FreeMarker configuration instance.
     *
     * @return FreeMarker instance.
     * @author Adam Kowalewski
     * @version 2015.03.30
     */
    private Configuration prepareFreemarkerConfig() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setClassForTemplateLoading(MailController.class, "templates");
        return cfg;
    }

    private String prepareActivationLink(OpwUser user) {
        String result = "http://CHANGEME/userVerify.xhtml" 
                + "?login=" + user.getEmail()
                + "&code=" + user.getToken();
        
        return result;
    }

}
