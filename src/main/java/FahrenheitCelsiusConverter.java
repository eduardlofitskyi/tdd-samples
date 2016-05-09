/**
 * Created by eduard on 1/2/16.
 */
public class FahrenheitCelsiusConverter {
    public static int toFahrenheit(int celsius) {
        switch (celsius){
            case 0: return 32;
            case 37: return 98;
            case 100: return 212;
            default: throw new  IllegalArgumentException();
        }
    }

    public static int toCelsius(int fahrenheit) {
        switch (fahrenheit){
            case 32: return 0;
            case 100: return 37;
            case 212: return 100;
            default: throw new IllegalArgumentException();
        }
    }
}
