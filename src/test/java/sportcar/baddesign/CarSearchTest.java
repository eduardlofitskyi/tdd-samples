package sportcar.baddesign;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.awt.*;
import java.util.List;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by eduard on 1/12/16.
 */
public class CarSearchTest {

    @Test
    public void shouldReturnZeroSportCars(){
        CarSearch sut = new CarSearch();
        List<Car> list = sut.findSportCars();

        assertTrue(list.isEmpty());
    }

    @Test
    public void shouldReturnOneSportCars(){
        CarSearch sut = new CarSearch();
        Manufacturer manufacturer = mock(Manufacturer.class);
        Car car = mock(Car.class);
        Engine engine = mock(Engine.class);

        sut.addCar(car);

        when(car.getEngine()).thenReturn(engine);
        when(engine.getNbOfCylinders()).thenReturn(8);
        when(car.getColor()).thenReturn(Color.RED);
        when(car.getManufacturer()).thenReturn(manufacturer);
        when(manufacturer.getName()).thenReturn("Ferrari");

        List<Car> list = sut.findSportCars();

        assertEquals(1, list.size());
    }

    @Test
    public void shouldReturnOnlySportCars(){
        CarSearch sut = new CarSearch();
        Manufacturer manufacturerA = mock(Manufacturer.class);
        Manufacturer manufacturerB = mock(Manufacturer.class);
        Car carA = mock(Car.class);
        Car carB = mock(Car.class);
        Engine engineA = mock(Engine.class);
        Engine engineB = mock(Engine.class);

        sut.addCar(carA);
        sut.addCar(carB);

        when(carA.getEngine()).thenReturn(engineA);
        when(engineA.getNbOfCylinders()).thenReturn(8);
        when(carA.getColor()).thenReturn(Color.RED);
        when(carA.getManufacturer()).thenReturn(manufacturerA);
        when(manufacturerA.getName()).thenReturn("BMW");

        when(carB.getEngine()).thenReturn(engineB);
        when(engineB.getNbOfCylinders()).thenReturn(7);
        when(carB.getColor()).thenReturn(Color.RED);
        when(carB.getManufacturer()).thenReturn(manufacturerB);
        when(manufacturerB.getName()).thenReturn("Ferrari");

        List<Car> list = sut.findSportCars();

        assertEquals(1, list.size());
    }


}