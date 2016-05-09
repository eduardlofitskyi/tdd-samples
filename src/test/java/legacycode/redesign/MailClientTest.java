package legacycode.redesign;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eduard on 1/9/16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmailServer.class)
public class MailClientTest {

    private final String ADDRESS = "address";
    private final String TITLE = "title";
    private final String BODY = "body";

    @Test
    public void shouldSetCorrectAttributesOfEmail(){
        Email email = mock(Email.class);
        MailClient sut = new MailClient(email);

        sut.sendEmail(ADDRESS, TITLE, BODY);

        verify(email).setAttributes(ADDRESS, TITLE, BODY);
    }

    @Test
    public void shouldCallStaticMethodOfEmailService(){
        Email email = mock(Email.class);
        PowerMockito.mockStatic(EmailServer.class);
        MailClient sut = new MailClient(email);

        sut.sendEmail(ADDRESS, TITLE, BODY);

        PowerMockito.verifyStatic();
        EmailServer.sendEmail(email);
    }


}