package units;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class PriceHistory extends TreeMap<LocalDateTime, Double> {

    public void addValue(double value, LocalDateTime time) {
        put(time, value);
    }
    public void addValue(double value) {
        put(TimeKeeper.dateTime(), value);
    }

    public double getCurrent(){
        return lastEntry().getValue();
    }
}
