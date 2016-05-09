package ClassroomBookingSystem;

/**
 * Created by eduard on 1/4/16.
 */
public interface Classroom {

    void reserve(int day, int hour);

    boolean isAvailable(int day, int hour);

    String getName();

    Equipment getEquipment();
}
