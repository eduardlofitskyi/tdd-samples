package redesignedtimeprovider;

/**
 * Created by eduard on 1/7/16.
 */
public class HelloRedesigned {

    private TimeDetector timeDetector;

    public HelloRedesigned(TimeDetector timeDetector) {
        this.timeDetector = timeDetector;
    }

    public String sayHello() {
        if (timeDetector.isMorning()) {
            return "Good Morning!";
        } else {
            return "Good Afternoon!";
        }
    }

}
