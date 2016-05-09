package sportcar.redesigned;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduard on 1/12/16.
 */
public class CarSearch {
    private List<Car> cars = new ArrayList<Car>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> findSportCars() {
        List<Car> sportCars = new ArrayList<Car>();
        for (Car car : cars) {
            if (car.isSport()) {
                sportCars.add(car);
            }
        }
        return sportCars;
    }
}
