package fridge;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by eduard on 1/14/16.
 */
@RunWith(JUnitParamsRunner.class)
public class FridgeTest {

    private Fridge sut;

    private static Object[] getProducts(){
        return $("APRICOT", "PEPSI", "CUCUMBER", "WATER", "MILK");
    }

    @Before
    public void setUp() throws Exception {
        sut=new Fridge();
    }

    @Test
    @Parameters(method = "getProducts")
    public void shouldBeEmptyAfterInitialization(String product) throws NoSuchItemException {
        assertFalse(sut.contains(product));
    }

    @Test (expected = NoSuchItemException.class)
    @Parameters(method = "getProducts")
    public void shouldThrowExceptionWhenTakeNonStoredProduct(String product) throws NoSuchItemException {
        sut.take(product);
    }

    @Test
    @Parameters(method = "getProducts")
    public void shouldKeepFoodInFridge(String product){
        sut.put(product);

        assertTrue(sut.contains(product));
    }

    @Test
    @Parameters(method = "getProducts")
    public void shouldAllowTakeFoodFromFridge(String product) throws NoSuchItemException {
        sut.put(product);

        sut.take(product);
    }

    @Test
    @Parameters(method = "getProducts")
    public void shouldNotAllowPutTheSameProductTwiceAndMore(String product){
        sut.put(product);

        assertFalse(sut.put(product));
    }

}
