package units;

import java.time.LocalDateTime;

public class Price {
    private double value;
    private LocalDateTime time;

    private Price(double value, LocalDateTime time) {
        this.value = value;
        this.time = time;
    }

    public static Price create(double value, LocalDateTime time) {
        return new Price(value, time);
    }

    public double getValue() {
        return value;
    }

    public LocalDateTime getTime() {
        return time;
    }

}
