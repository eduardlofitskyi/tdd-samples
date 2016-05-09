package timeprovider;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
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
public class HelpDeskTest {

    private HelpDesk sut;
    private Issue issue;
    private TimeProvider provider;

    private static Object[] getBusinessTime(){
        return $(
                $(Calendar.MONDAY, 0),
                $(Calendar.MONDAY, 1),
                $(Calendar.MONDAY, 2),
                $(Calendar.MONDAY, 3),
                $(Calendar.MONDAY, 18),
                $(Calendar.MONDAY, 23),
                $(Calendar.THURSDAY, 23),
                $(Calendar.FRIDAY, 0),
                $(Calendar.FRIDAY, 17)
        );
    }

    private static Object[] getDayOffTime(){
        return $(
                $(Calendar.SUNDAY, 0),
                $(Calendar.SUNDAY, 23),
                $(Calendar.SATURDAY, 0),
                $(Calendar.SATURDAY, 23),
                $(Calendar.FRIDAY, 18),
                $(Calendar.FRIDAY, 23)
        );
    }

    @Before
    public void setUp() throws Exception {
        issue = mock(Issue.class);
        provider = mock(TimeProvider.class);
        sut = new HelpDesk(provider);
    }

    @Test
    @Parameters(method = "getBusinessTime")
    public void shouldHandleTask(int dayOfWeek, int hour){
        when(provider.getTime()).thenReturn(getCalendar(dayOfWeek, hour));
        assertTrue(sut.willHandleIssue(issue));
    }

    @Test
    @Parameters(method = "getDayOffTime")
    public void shouldNotHandleTask(int dayOfWeek, int hour){
        when(provider.getTime()).thenReturn(getCalendar(dayOfWeek, hour));
        assertFalse(sut.willHandleIssue(issue));
    }

    private Calendar getCalendar(int dayOfWeek, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        return calendar;
    }
}