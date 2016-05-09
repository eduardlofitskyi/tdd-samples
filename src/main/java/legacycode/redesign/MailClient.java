package legacycode.redesign;

/**
 * Created by eduard on 1/9/16.
 */
public class MailClient {

    private Email email;

    public MailClient(Email email) {
        this.email = email;
    }

    public void sendEmail(String address, String title, String body) {
        email.setAttributes(address, title, body);
        EmailServer.sendEmail(email);
    }
}
