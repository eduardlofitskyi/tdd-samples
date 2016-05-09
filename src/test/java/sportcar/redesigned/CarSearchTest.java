package sportcar.redesigned;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by eduard on 1/12/16.
 */
public class CarSearchTest {

    @Test
    public void shouldHasZeroSportCar(){
        CarSearch sut = new CarSearch();

        List<Car> listOfSportCars = sut.findSportCars();

        assertTrue(listOfSportCars.isEmpty());
    }

    @Test
    public void shouldReturnOneSportCar(){
        CarSearch sut = new CarSearch();
        Car car = mock(Car.class);

        sut.addCar(car);
        when(car.isSport()).thenReturn(true);
        List<Car> listOfSportCars = sut.findSportCars();

        assertEquals(1, listOfSportCars.size());
    }

    @Test
    public void shouldReturnOnlySportCar(){
        CarSearch sut = new CarSearch();
        Car carA = mock(Car.class);
        Car carB = mock(Car.class);

        sut.addCar(carA);
        sut.addCar(carB);
        when(carA.isSport()).thenReturn(true);
        when(carB.isSport()).thenReturn(false);
        List<Car> listOfSportCars = sut.findSportCars();

        assertEquals(1, listOfSportCars.size());
    }
}