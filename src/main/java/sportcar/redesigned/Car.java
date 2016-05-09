package sportcar.redesigned;

import java.awt.*;

/**
 * Created by eduard on 1/12/16.
 */
public interface Car {
    Engine getEngine();
    Color getColor();
    Manufacturer getManufacturer();

    boolean isSport();
}
