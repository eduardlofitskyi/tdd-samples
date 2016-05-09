import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

/**
 * Created by eduard on 1/6/16.
 */
@RunWith(JUnitParamsRunner.class)
public class StringUtilTest {

    private StringUtil sut;

    private static Object[] getStrings(){
        return $(
            $("1234", "4321"),
            $("mama", "amam"),
            $(" Pirate_", "_etariP "),
            $("???!", "!???")
        );
    }

    private static Object[] getWrongStrings(){
        return $(
            $("1234 ", "4321"),
            $(" Pirate_", " _etariP"),
            $(" ???!", " !???")
        );
    }

    @Before
    public void setUp() throws Exception {
        sut = new  StringUtil();
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodReverseShouldThrowExceptionWhenParameterIsNull(){
        sut.reverse(null);
    }

    @Test
    @Parameters(method = "getStrings")
    public void shouldReverseString(String straight, String reversed){
        assertEquals("Expected: "+reversed+"\nbut get: "+sut.reverse(straight),reversed, sut.reverse(straight));
    }

    @Test
    @Parameters(method = "getWrongStrings")
    public void shouldDetectedWrongReversedString(String straight, String reversed){
        assertNotEquals(reversed, sut.reverse(straight));
    }


}