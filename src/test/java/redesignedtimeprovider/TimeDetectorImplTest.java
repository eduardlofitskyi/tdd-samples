package redesignedtimeprovider;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by eduard on 1/7/16.
 */
@RunWith(JUnitParamsRunner.class)
public class TimeDetectorImplTest {

    private static Object[] getMorningTime(){
        return $(0,1,2,3,4,5,6,7,8,9,10,11);
    }

    private static Object[] getAfternoonTime(){
        return $(12,13,14,15,16,17,18,19,20,21,22,23);
    }

    @Test
    @Parameters(method = "getMorningTime")
    public void shouldReturnTrue(int hour){
        TimeProvider provider = mock(TimeProvider.class);
        TimeDetector sut = new TimeDetectorImpl(provider);

        when(provider.getTime()).thenReturn(getCalendar(hour));

        assertTrue(sut.isMorning());
    }

    @Test
    @Parameters(method = "getAfternoonTime")
    public void shouldReturnFalse(int hour){
        TimeProvider provider = mock(TimeProvider.class);
        TimeDetector sut = new TimeDetectorImpl(provider);

        when(provider.getTime()).thenReturn(getCalendar(hour));

        assertFalse(sut.isMorning());
    }

    private Calendar getCalendar(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        return calendar;
    }

}