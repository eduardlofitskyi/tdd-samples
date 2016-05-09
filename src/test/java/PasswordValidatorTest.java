import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
/**
 * Created by eduard on 1/3/16.
 */
@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {

    private static Object[] getValidPassword(){
        return $(
                $("abcde1"),
                $("1234567890"),
                $("a_b_c_d_e_f_g_1")
        );
    }

    private static Object[] getInvalidPassword(){
        return $(
                $("a"),
                $(),
                $("abcde")
        );
    }

    @Test
    @Parameters(method = "getValidPassword")
    public void passwordShouldBeAtLeastSixCharactersLong(String password){
        assertTrue(PasswordValidator.checkLength(password));
    }

    @Test
    @Parameters(method = "getInvalidPassword")
    public void passwordShouldNotBeAtLeastSixCharactersLong(String password){
        assertFalse(PasswordValidator.checkLength(password));
    }

    @Test
    @Parameters(method = "getValidPassword")
    public void passwordShouldHasAtLeastOneDigit(String password){
        assertTrue(PasswordValidator.checkDigit(password));
    }

    @Test
    @Parameters(method = "getInvalidPassword")
    public void passwordShouldNotHasAtLeastOneDigit(String password){
        assertFalse(PasswordValidator.checkDigit(password));
    }

}
