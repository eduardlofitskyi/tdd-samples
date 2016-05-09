package ClassroomBookingSystem;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * Created by eduard on 1/4/16.
 */
public class BookingSystemTest {
    BookingSystem sut;
    Classroom classroomA = mock(Classroom.class);
    Classroom classroomB = mock(Classroom.class);
    Classroom classroomC = mock(Classroom.class);
    public final int DAY = 1;
    public final int HOUR = 11;
    @Before
    public void setUp(){
        sut = new BookingSystem();

        sut.addClassroom(classroomA);
        sut.addClassroom(classroomB);
        sut.addClassroom(classroomC);
    }

    @Test
    public void shouldReturnWholeListOfClassroom(){
        assertEquals(3,sut.getAllClassrooms().size());
    }

    @Test
    public void shouldReturnAllAvailableClassroom(){
        sut.book(classroomA, DAY, HOUR);

        when(classroomB.isAvailable(DAY,HOUR)).thenReturn(true);
        when(classroomC.isAvailable(DAY,HOUR)).thenReturn(true);

        assertEquals(2, sut.getAllAvailableClassrooms(DAY, HOUR).size());
    }
    @Test
    public void shouldBookingClassroomByName(){

        when(classroomA.getName()).thenReturn("A1");
        when(classroomB.isAvailable(DAY,HOUR)).thenReturn(true);
        when(classroomC.isAvailable(DAY,HOUR)).thenReturn(true);

        sut.book("A1", DAY, HOUR);

        assertEquals(2, sut.getAllAvailableClassrooms(DAY, HOUR).size());

    }

    @Test
    public void shouldBookingBySpecificCriteria(){
        when(classroomA.isAvailable(DAY,HOUR)).thenReturn(true);
        when(classroomB.isAvailable(DAY,HOUR)).thenReturn(true);
        when(classroomC.getEquipment()).thenReturn(Equipment.PROJECTOR);
        when(classroomB.getEquipment()).thenReturn(Equipment.PROJECTOR);

        sut.book(20, Equipment.PROJECTOR, DAY, HOUR);

        verify(classroomB).reserve(DAY, HOUR);
        verify(classroomA, never()).reserve(DAY, HOUR);
        verify(classroomC, never()).reserve(DAY, HOUR);
    }
}