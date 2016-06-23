package example.javamail;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class MailSender {
	private static MimeMessage mimeMsg;
	private static Session session;
	private static Properties props;
	private static String username = "";
	private static String password = "";
	private static Multipart mp;
	private static boolean ifMimeBody = true;

	public static void main(String[] args) {
		MailSender.setNeedAuth(true);
		boolean ifSuccess = MailSender.sendEmail("smtp.163.com", "test",
				"body test", true, "userA@163.com", "userB@hotmail.com",
				null, null, "userA", "password", null);
		if (ifSuccess) {
			System.out.println("Sending Complete!");
		} else {
			System.out.println("Failed");
		}
	}
	public static boolean sendEmail(String smtp, String subject, String body,
			String from, String to, String copyto, String bcto) {
		return sendEmail(smtp, subject, body, false, from, to, copyto, bcto,
				null, null, null);
	}
	public static boolean sendEmail(String smtp, String subject, String body,
			boolean ifMimeBody, String from, String to, String copyto,
			String bcto, String name, String pass, String fileAffix) {
		setSmtpHost(smtp);
		setIfMimeBody(ifMimeBody);
		if (!createMimeMessage()) {
			return false;
		}
		if (!setSubject(subject)) {
			return false;
		}
		if (!setBody(body)) {
			return false;
		}
		if (!setFrom(from)) {
			return false;
		}
		if (!setNamePass(name, pass)) {
			return false;
		}
		if (!setCopyTo(copyto)) {
			return false;
		}
		if (!setBlindCopyTo(bcto)) {
			return false;
		}
		if (!setTo(to)) {
			return false;
		}
		if (!addFileAffix(fileAffix)) {
			return false;
		}
		return sendout();
	}
	/**
	 * Set the smtp host
	 * 
	 * @param hostName -
	 *            String for the smtp host
	 * @return void
	 */
	private static void setSmtpHost(String hostName) {
		if (props == null)
			props = System.getProperties();
		props.put("mail.smtp.host", hostName);
	}

	/**
	 * Create MIME message
	 * 
	 * @return Boolean
	 */
	public static boolean createMimeMessage() {
		try {
			session = Session.getDefaultInstance(props, null);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		try {
			mimeMsg = new MimeMessage(session);
			mp = new MimeMultipart();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Whether need the authorization
	 * 
	 * @param need -
	 *            Boolean for authorzation
	 * @return void
	 */
	public static void setNeedAuth(boolean need) {
		if (props == null)
			props = System.getProperties();
		if (need) {
			props.put("mail.smtp.auth", "true");
		} else {
			props.put("mail.smtp.auth", "false");
		}
	}
	/**
	 * Set the name and password for authorization
	 * 
	 * @param name -
	 *            Username for smtp authorization
	 * @param pass -
	 *            Password for smtp authorization
	 * @return boolean
	 */
	public static boolean setNamePass(String name, String pass) {
		username = name;
		password = pass;
		return true;
	}

	/**
	 * Set the email subject
	 * 
	 * @param mailSubject
	 * @return boolean
	 */
	public static boolean setSubject(String mailSubject) {
		try {
			mimeMsg.setSubject(mailSubject);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Set the email body
	 * 
	 * @param mailBody
	 * @return boolean
	 */
	public static boolean setBody(String mailBody) {
		try {
			BodyPart bp = new MimeBodyPart();
			if (ifMimeBody == true) {
			  bp.setContent("<meta http-equiv=Content-Type content=text/html; charset=utf-8>"
						+ mailBody, "text/html;charset=utf-8");
			} else {
				bp.setText(mailBody);
			}
			mp.addBodyPart(bp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Set the affix file
	 * 
	 * @param filename
	 * @return boolean
	 */
	public static boolean addFileAffix(String filename) {
		if (filename == null) {
			return true;
		}
		try {
			BodyPart bp = new MimeBodyPart();
			FileDataSource fileds = new FileDataSource(filename);
			bp.setDataHandler(new DataHandler(fileds));
			bp.setFileName(fileds.getName());
			
			mp.addBodyPart(bp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Set the email from field
	 * 
	 * @param from
	 * @return boolean
	 */
	public static boolean setFrom(String from) {
		try {
			mimeMsg.setFrom(new InternetAddress(from));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Set the email to field
	 * 
	 * @param to
	 * @return boolean
	 */
	public static boolean setTo(String to) {
		if (to == null)
			return false;
		try {
			mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress
					.parse(to));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	/**
	 * Set the email copy-to field
	 * 
	 * @param copyto
	 * @return boolean
	 */
	public static boolean setCopyTo(String copyto) {
		if (copyto == null)
			return true;
		try {
			mimeMsg.addRecipients(Message.RecipientType.CC,
					(Address[]) InternetAddress.parse(copyto));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Set the email blind-copy-to field
	 * 
	 * @param bcto
	 * @return boolean
	 */
	public static boolean setBlindCopyTo(String bcto) {

		if (null == bcto)
			return true;
		try {
			mimeMsg.addRecipients(Message.RecipientType.BCC,
					(Address[]) InternetAddress.parse(bcto));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Send the email out
	 * 
	 * @return boolean
	 */
	public static boolean sendout() {
		try {
			mimeMsg.setContent(mp);
			mimeMsg.saveChanges();
			Session mailSession = Session.getInstance(props, null);
			Transport transport = mailSession.getTransport("smtp");
			transport.connect((String) props.get("mail.smtp.host"), username,
					password);
			transport.sendMessage(mimeMsg, mimeMsg.getAllRecipients());
			transport.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * @return
	 */
	public static boolean isIfMimeBody() {
		return ifMimeBody;
	}
	/**
	 * @param b
	 */
	public static void setIfMimeBody(boolean b) {
		ifMimeBody = b;
	}
}
