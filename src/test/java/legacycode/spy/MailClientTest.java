package legacycode.spy;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
        MailClient sut = new MailClient();
        PowerMockito.mockStatic(EmailServer.class);
        ArgumentCaptor<Email> captor = ArgumentCaptor.forClass(Email.class);

        sut.sendEmail(ADDRESS, TITLE, BODY);

        PowerMockito.verifyStatic();
        EmailServer.sendEmail(captor.capture());

        Email email = captor.getValue();
        assertEquals(ADDRESS, email.getAddress());
        assertEquals(TITLE, email.getTitle());
        assertEquals(BODY, email.getBody());
    }
}