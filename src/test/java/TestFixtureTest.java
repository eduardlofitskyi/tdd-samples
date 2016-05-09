import org.junit.*;

/**
 * Created by eduard on 1/10/16.
 */
public class TestFixtureTest {

    @BeforeClass
    public static void setUpClass() {
        System.err.println("pre class");
    }

    @AfterClass
    public static void tearDownClass() {
        System.err.println("post class");
    }

    @Before
    public void setUp() throws Exception {
        System.err.println("-pre test");
    }

    @After
    public void tearDown() throws Exception {
        System.err.println("-post test");
    }

    @Test
    public void testMethodA(){
        System.err.println("--method A");
    }

    @Test
    public void testMethodB(){
        System.err.println("--method B");
    }


}
