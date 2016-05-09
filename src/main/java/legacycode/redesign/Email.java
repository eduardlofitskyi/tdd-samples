package legacycode.redesign;

/**
 * Created by eduard on 1/9/16.
 */
public class Email {

    private String address;
    private String title;
    private String body;

    public Email() {
    }

    public String getAddress() {
        return address;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setAttributes(String address, String title, String body) {
        this.address=address;
        this.title=title;
        this.body=body;
    }
}
