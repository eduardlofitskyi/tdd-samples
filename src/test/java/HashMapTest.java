import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by eduard on 1/2/16.
 */


public class HashMapTest {
    public static final String KEY = "key";
    public static final String VALUE = "value";
    public static final String VALUE2 = "value2";
    private HashMap<String,String> map;

    @Before
    public void setUp(){
        map = new HashMap<>();
        map.put(KEY, VALUE);
    }

    @Test
    public void canGetAfterPut(){
        assertEquals(VALUE, map.get(KEY));
    }

    @Test
    public void replaceOldValueWhenPutTheSameKey(){
        map.put(KEY,VALUE2);
        assertEquals(VALUE2,map.get(KEY));
    }

    @Test
    public void clearRemoveAllContent(){
        map.clear();
        assertTrue(map.isEmpty());
    }

    @Test
    public void nullKeyIsUseful(){
        map.put(null, VALUE2);
        assertTrue(map.containsKey(null));
    }
}
