package userservice;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by eduard on 1/6/16.
 */
public class UserServiceImplTest {

    private final String PASSWORD = "PASSWORD";
    private final String HASHED_PASSWORD = "MD5_HASH";

    @Test
    public void methodAssignPasswordShouldInteractBetweenDocs() throws Exception {
        SecurityService securityService = mock(SecurityService.class);
        UserDAO dao = mock(UserDAO.class);
        User user = mock(User.class);
        UserServiceImpl sut = new UserServiceImpl(dao, securityService);

        when(user.getPassword()).thenReturn(PASSWORD);
        when(securityService.md5(PASSWORD)).thenReturn(HASHED_PASSWORD);

        sut.assignPassword(user);

        verify(user).setPassword(HASHED_PASSWORD);
        verify(dao).updateUser(user);
    }

}