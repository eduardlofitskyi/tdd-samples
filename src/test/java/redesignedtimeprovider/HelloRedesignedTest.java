package redesignedtimeprovider;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by eduard on 1/7/16.
 */
public class HelloRedesignedTest {

    private final String MORNING = "Good Morning!";
    private final String AFTERNOON = "Good Afternoon!";

    @Test
    public void shouldSayGoodMorning(){
        TimeDetector provider = mock(TimeDetector.class);
        HelloRedesigned sut = new HelloRedesigned(provider);

        when(provider.isMorning()).thenReturn(true);

        assertEquals(MORNING, sut.sayHello());
    }

    @Test
    public void shouldSayGoodAfternoon(){
        TimeDetector provider = mock(TimeDetector.class);
        HelloRedesigned sut = new HelloRedesigned(provider);

        when(provider.isMorning()).thenReturn(false);

        assertEquals(AFTERNOON, sut.sayHello());
    }
}