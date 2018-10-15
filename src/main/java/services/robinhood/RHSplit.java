package services.robinhood;

import java.time.LocalDate;

public class RHSplit {
    private String execution_date;//: "2017-03-17",
    private double divisor;// "10.00000000",
    private double multiplier;//: "1.00000000"

    public String getExecution_date() {
        return execution_date;
    }

    public void setExecution_date(String execution_date) {
        this.execution_date = execution_date;
    }

    public double getDivisor() {
        return divisor;
    }

    public void setDivisor(double divisor) {
        this.divisor = divisor;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
}
