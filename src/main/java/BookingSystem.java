import java.util.*;

/**
 * Created by eduard on 1/3/16.
 */
public class BookingSystem {

    private Set<Integer> bookedHours = new HashSet<>(23);

    public boolean book(int hour) throws CloneNotSupportedException {
        if (hour<0 || hour>23){
            throw new IllegalArgumentException(hour+" isn't real hour");
        }

        if (!bookedHours.add(hour)){
            throw new CloneNotSupportedException(hour+"h. has already booked");
        }
        return true;
    }

    public Set<Integer> getBookedHours() {
        return bookedHours;
    }
}
