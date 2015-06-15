package org.tradingsocial.service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.tradingsocial.util.MailSender;
import org.tradingsocial.util.PropertiesUtils;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * User: Mayur Kavhalkar
 * Date: Jun 12, 2015
 * Time: 11:06:04 PM
 */
@Component
@Scope("prototype")
public class MailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);

    protected TemplateModel subject;
    protected TemplateModel fromEmail;
    protected String overrideEmail;
    protected String errorMessage;
    protected Configuration cfg;
    protected String emailLocations;

    protected MailSender mailSender;
    
    public final static String PROPSFILE = "config.properties";

    private static Properties props;
    static{
    	props = PropertiesUtils.getProperties(PROPSFILE);
    }

	public void configFiles() throws IOException {
		if (cfg == null) {
			cfg = new Configuration();

			cfg.setObjectWrapper(new DefaultObjectWrapper());

			String emailLocation = props.getProperty("emailTemplateLocation");
			TemplateLoader loader = new FileTemplateLoader(new File(emailLocation));
			cfg.setTemplateLoader(loader);

		}
	}

	public void addSystemVariables(Map root) {
        String buf;

        buf = props.getProperty("emailaddressdomain");
        root.put("emailaddressdomain", (buf == null) ? "" : buf);

        buf =  props.getProperty("domain");
        root.put("domain", (buf == null) ? "" : buf);

        buf =  props.getProperty("signature");
        root.put("signature", (buf == null) ? "" : buf);

    }

    public String printMap(final Map root) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (Object key : root.keySet()) {
            sb.append(key.toString() + ":" + root.get(key) + ", ");
        }
        sb.append("}");

        return sb.toString();
    }

    public String templatePath() {
        return props.getProperty("emailTemplatePath");
    }

    public int sendEmailAndBackup(String toEmail, String extraBcc, final Map root, final String template) {
        return sendEmailAndBackup(toEmail, extraBcc, root, template, false);
    }

    public int sendEmailAndBackup(String toEmail, final Map root, final String template) {
        return sendEmailAndBackup(toEmail, null, root, template, false);
    }

    protected int sendEmailAndBackup(String toEmail, String extraBcc, Map root, final String template, final boolean error) {
        String subject = "";
        String fromEmail = "";
        String textEmail = "";
        String htmlEmail = "";

        addSystemVariables(root);

        StringWriter textWriter = new StringWriter();
        StringWriter htmlWriter = new StringWriter();

        StringBuffer textname = new StringBuffer(template);
        StringBuffer htmlname = new StringBuffer(template);

        textname.insert(template.lastIndexOf("."), "-text");
        htmlname.insert(template.lastIndexOf("."), "-HTML");

        try {
            configFiles();

			LOGGER.debug("Processing email " + textname + " - " + htmlname);
			LOGGER.debug("Substitution Map " + printMap(root));

            // Create a "text" Multipart message
            Template textTemplate = cfg.getTemplate(templatePath() + textname.toString());
            try {
                LOGGER.debug("Text tempate processing start " + textname);
                Environment env = textTemplate.createProcessingEnvironment(root, textWriter);
                env.process();  // process the template
                textEmail = textWriter.toString();
                subject = env.getVariable("subject").toString();
                fromEmail = env.getVariable("fromEmail").toString();
                LOGGER.debug("text tempate processing Stop " + textname);
            } catch (TemplateException e) {
                LOGGER.error("Text tempate processing failed " + textname, e);
                errorMessage = textname + " Text Exception: " + e.toString();
                throw e;
            } catch (NullPointerException e) {
                LOGGER.error("Text tempate processing failed " + textname, e);
                errorMessage = textname + " Text Exception: " + e.toString();
                throw e;
            }

            // Create a "HTML" Multipart message
            Template htmlTemplate;
            LOGGER.debug("Html tempate processing start " + htmlname);
            try {
                htmlTemplate = cfg.getTemplate(templatePath() + htmlname.toString());
                Environment env = htmlTemplate.createProcessingEnvironment(root, htmlWriter);
                env.process();  // process the template
                htmlEmail = htmlWriter.toString();
                LOGGER.debug("Html tempate processing stop success " + htmlname);
            } catch (TemplateException e) {
                LOGGER.error("Html tempate processing failed " + htmlname, e);
                errorMessage = htmlname + " HTML Exception: " + e.toString();
                // eat the error but report on it.
                if (!error) {
                    sendProblemEmail(e, "Error", props.getProperty("errorEmail"), root, template);
                }
            }
            LOGGER.debug("Email Parsed - no errors " + textname + " - " + htmlname);
        } catch (IOException e) {
            LOGGER.error("Cannot send message " + template, e);
            LOGGER.error("Send Email FAILURE to construct the configuration file", e);
            LOGGER.error(printMap(root));

            // send email to me
            // dont allow continual sending.
            if (!error) {
                sendProblemEmail(e, "Error", props.getProperty("errorEmail"), root, template);
            }
            return 0;
        } catch (TemplateException e) {
            LOGGER.error("Cannot send message " + template, e);
            LOGGER.error("Send Email FAILURE to construct the configuration file", e);
            LOGGER.error(printMap(root));

            // send email to me
            // dont allow continual sending.
            if (!error) {
                sendProblemEmail(e, "Error", props.getProperty("errorEmail"), root, template);
            }
            return 0;
        }

        // need to set the from address if empty
        if (!StringUtils.isEmpty(props.getProperty("fromMail"))) {
            fromEmail = props.getProperty("fromMail");
            LOGGER.info("Overrode outbound email from with " + fromEmail);
        }


        try {
        	String bccValues = null;
        	if(props.getProperty("backupEmailId") != null && props.getProperty("enableBackupmail") == null && props.getProperty("enableBackupmail").equalsIgnoreCase("TRUE")){
        		bccValues = extraBcc;
        	} else {
        		bccValues = bccValues + "," +extraBcc;
        	}
            int retval = mailSender.sendEmail(textname.toString(), subject, fromEmail,
                            toEmail, bccValues, textEmail, htmlEmail);
            return retval;
        } catch (Exception e) {
            LOGGER.error("Error In Email " + textname.toString(), e);
            return 0;
        }
    }

    public void setOverrideEmail(String overrideEmail) {
        this.overrideEmail = overrideEmail;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int sendProblemEmail(Exception e, String subject, final String toEmail, final Map rootin, final String template) {
        int retval = -1;
        Map root = new HashMap();

        if (e != null) {
            root.put("message", e.getMessage());
            root.put("messages", e.toString());
        } else {
            root.put("message", e.getMessage());
            root.put("messages", e.toString());
        }
        root.put("template", template);
        root.put("toEmail", toEmail);

        retval = sendEmailAndBackup(props.getProperty("errorEmail"), null, root, "ErrorEmail.ftl", true);

        return retval;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

}
