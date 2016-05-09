import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.anyInt;

/**
 * Created by eduard on 1/12/16.
 */
public class StackTest {

    private final int FIRST = 1;
    private final int SECOND = 2;
    private final int THIRD = 3;

    @Test
    public void shouldBeEmptyAfterCreation(){
        Stack sut = new Stack();

        assertTrue(sut.isEmpty());
    }

    @Test
    public void shouldNotBeEmptyAfterElementAdded(){
        Stack sut = new Stack();
        sut.push(anyInt());
        assertFalse(sut.isEmpty());
    }

    @Test
    public void shouldKeepAllAddedElements(){
        Stack sut = new Stack();

        sut.push(anyInt());
        sut.push(anyInt());
        sut.push(anyInt());

        assertEquals(3, sut.size());
    }

    @Test
    public void shouldReturnAllKeptElements(){
        Stack sut = new Stack();

        sut.push(FIRST);
        sut.push(SECOND);
        sut.push(THIRD);

        assertEquals(THIRD, sut.pop());
        assertEquals(SECOND, sut.pop());
        assertEquals(FIRST, sut.pop());
    }
}