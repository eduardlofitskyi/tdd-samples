import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.lang.IllegalArgumentException;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

/**
 * Created by eduard on 1/3/16.
 */
@RunWith(JUnitParamsRunner.class)
public class BookingSystemTest {

    private BookingSystem system;
    public static final int TWO_HOUR = 2;
    public static final int THREE_HOUR = 3;
    public static final int ELEVEN_HOUR = 11;

    private static Object[] getHours(){
        return $(
                $(TWO_HOUR),
                $(THREE_HOUR),
                $(ELEVEN_HOUR)
        );
    }

    @Before
    public void setUp() throws Exception {
        system = new BookingSystem();
        system.book(TWO_HOUR);
        system.book(THREE_HOUR);
        system.book(ELEVEN_HOUR);
    }

    @Test
    @Parameters(method = "getHours")
    public void testShouldReturnBookedHours(int hour){
        assertTrue(system.getBookedHours().contains(hour));
    }

    @Test(expected = CloneNotSupportedException.class)
    @Parameters(method = "getHours")
    public void testShouldNotBookingBookedHour(int hour) throws CloneNotSupportedException {
        system.book(hour);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldRefuseIllegalValue() throws CloneNotSupportedException {
        system.book(-1);
        system.book(24);
    }
}