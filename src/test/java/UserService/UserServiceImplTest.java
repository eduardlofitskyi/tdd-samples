package UserService;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by eduard on 1/4/16.
 */
public class UserServiceImplTest {

    private final String MD5_HASH = "42fe8a";
    private final String PASSWORD = "123456qwe";

    @Test
    public void testAssignPassword() throws Exception {
        UserDAO dao = mock(UserDAO.class);
        User user = mock(User.class);
        SecurityService securityService= mock(SecurityService.class);

        UserServiceImpl sut = new UserServiceImpl(dao, securityService);

        when(user.getPassword()).thenReturn(PASSWORD);
        when(securityService.md5(PASSWORD)).thenReturn(MD5_HASH);

        sut.assignPassword(user);

        verify(user).setPassword(MD5_HASH);
        verify(dao).updateUser(user);
    }
}