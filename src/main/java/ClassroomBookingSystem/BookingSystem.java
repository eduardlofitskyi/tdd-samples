package ClassroomBookingSystem;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by eduard on 1/4/16.
 */
public class BookingSystem {

    private Collection<Classroom> classrooms = new HashSet<>();

    public void addClassroom(Classroom classroom) {
        this.classrooms.add(classroom);
    }


    public Collection<Classroom> getAllClassrooms() {
        return classrooms;
    }

    public void book(Classroom classroom, int day, int hour) {
        classroom.reserve(day, hour);
    }

    public void book(String classroom, int day, int hour) {
        for (Classroom c: classrooms){
            if (c.getName()!=null && c.getName().equals(classroom)){
                c.reserve(day,hour);
                return;
            }
        }
    }

    public void book(int i, Equipment equipment, int day, int hour) {
        for (Classroom c: classrooms){
            if (c.getEquipment()==equipment && c.isAvailable(day, hour)){
                c.reserve(day,hour);
                return;
            }
        }
    }

    public Collection<Classroom> getAllAvailableClassrooms(int day, int hour) {
        Collection<Classroom> available = new HashSet<>();
        for (Classroom c: classrooms){
            if (c.isAvailable(day, hour)){
                available.add(c);
            }
        }
        return available;
    }
}
