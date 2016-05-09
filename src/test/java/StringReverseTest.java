import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by eduard on 1/1/16.
 */
public class StringReverseTest {

    public static final String STRAIGHT_STRING = "cat is animal";
    public static final String ROTATED_STRING = "lamina si tac";

    @Test
    public void reflectStringTest(){

        assertEquals(ROTATED_STRING, StringReverse.reverse(STRAIGHT_STRING));
        assertNotEquals(STRAIGHT_STRING, StringReverse.reverse(STRAIGHT_STRING));
    }
}
