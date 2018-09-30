package units;

import models.faces.Evolvable;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeKeeper implements Evolvable {
    private static TimeKeeper ourInstance = new TimeKeeper();

    private LocalDateTime dateTime = LocalDateTime.of(2017, 1, 1, 12, 0);

    public static TimeKeeper getInstance() {
        return ourInstance;
    }

    private TimeKeeper() {
    }

    @Override
    public void evolve() {
        dateTime = dateTime.plus(1, ChronoUnit.DAYS);
    }

    public static LocalDateTime dateTime() {
        return getInstance().dateTime;
    }
}
