package org.tradingsocial.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * User: Mayur Kavhalkar
 */
@Component("fullLiveMailSender")
@Scope("prototype")
public class MailSender {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MailSender.class);

	@Resource(name = "javaMailSender")
	private JavaMailSender javaMailSender;


	public int sendEmail(final String emailName, final String subject,
			final String fromEmail, final String toEmail,
			final String backupEmailAddress, final String textEmail,
			final String htmlEmail) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper;
			if (!StringUtils.isEmpty(htmlEmail)) {
				helper = new MimeMessageHelper(message, true, "UTF-8");
			} else {
				helper = new MimeMessageHelper(message);
			}

			LOGGER.debug(emailName);

			try {
				helper.setSubject(subject);
			} catch (MessagingException e) {
				LOGGER.error("**************************Subject is invalid " + subject, e);
			}
			try {
				helper.setTo(splitEmail(toEmail));
			} catch (MessagingException e) {
				LOGGER.error("**************************Email To is invalid " + toEmail, e);
			}
			try {
				helper.setFrom(fromEmail);
			} catch (MessagingException e) {
				LOGGER.error("**************************Email From is invalid "	+ fromEmail, e);
			}
			try {
				if (backupEmailAddress != null) {
					helper.setBcc(splitEmail(backupEmailAddress));
				} else {
					LOGGER.debug("    bcc: No CC Specified");
				}
			} catch (MessagingException e) {
				LOGGER.error(
						"**************************Email Message is invalid " + fromEmail, e);
			}

			if (!StringUtils.isEmpty(htmlEmail)) {
				helper.setText(textEmail, htmlEmail);
			} else {
				helper.setText(textEmail);
			}
			if (LOGGER.isDebugEnabled()) {
				String[] valuesToPrint = { "To", "From", "Bcc", "Subject" };

				for (String ih : valuesToPrint) {
					StringBuffer sb = new StringBuffer();
					try {
						for (String s : message.getHeader(ih)) {
							sb.append(s).append(" ");
						}
						LOGGER.debug("****** " + ih + " - " + sb.toString());
					} catch (Exception e) {
						LOGGER.debug("****** " + ih + " - No Value");
					}
				}
				if (textEmail != null)
					LOGGER.debug("Message: " + textEmail);
				if (htmlEmail != null)
					LOGGER.debug("HTML Part: " + htmlEmail);

			}
			sendEmail(emailName, message);
			return 1;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void sendEmail(String emailName, MimeMessage preparator) {
		try {
				javaMailSender.send(preparator);
			LOGGER.debug("Sent email - no errors " + emailName);
		} catch (Exception e) {
			LOGGER.error("Failed Email Send: " + emailName, e);
		}
	}

	public String[] splitEmail(final String emailAddress) {
		if (emailAddress != null) {
			String[] values = emailAddress.split(",");
			for (int i = 0; i < values.length; i++) {
				values[i] = values[i].trim();
			}
			return values;
		}
		return null;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}


}
