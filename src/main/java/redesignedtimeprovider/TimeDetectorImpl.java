package redesignedtimeprovider;

import java.util.Calendar;

/**
 * Created by eduard on 1/7/16.
 */
public class TimeDetectorImpl implements TimeDetector {

    TimeProvider provider;

    public TimeDetectorImpl(TimeProvider provider) {
        this.provider = provider;
    }

    @Override
    public boolean isMorning() {
        Calendar now = provider.getTime();
        if (now.get(Calendar.HOUR_OF_DAY)<12){
            return true;
        }
        return false;
    }
}
