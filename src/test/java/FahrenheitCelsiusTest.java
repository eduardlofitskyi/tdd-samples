import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
/**
 * Created by eduard on 1/2/16.
 */
@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelsiusTest {

    private static Object[] getCelsius(){
        return $(
            $(32,0),
            $(98,37),
            $(212, 100)
        );
    }

    private static Object[] getFahrenheit(){
        return $(
                $(0,32),
                $(37,100),
                $(100,212)
        );
    }

    @Test
    @Parameters(method = "getCelsius")
    public void shouldConvertCelsiusToFahrenheit(int fahrenheit, int celsius){
        assertEquals(fahrenheit, FahrenheitCelsiusConverter.toFahrenheit(celsius));
    }

    @Test
    @Parameters(method = "getFahrenheit")
    public void shouldConvertFahrenheitToCelsius(int celsius, int fahrenheit){
        assertEquals(celsius, FahrenheitCelsiusConverter.toCelsius(fahrenheit));
    }
}
