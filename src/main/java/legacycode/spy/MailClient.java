package legacycode.spy;

/**
 * Created by eduard on 1/9/16.
 */
public class MailClient {
    public void sendEmail(String address, String title, String body) {
        Email email = new Email(address, title, body);
        EmailServer.sendEmail(email);
    }
}
