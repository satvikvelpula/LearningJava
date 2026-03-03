package entity;

public class Currency {

    private String abbreviation;
    private double rateToUsd;

    public Currency(String abbreviation, double rateToUsd) {
        this.abbreviation = abbreviation;
        this.rateToUsd = rateToUsd;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public double getRateToUsd() {
        return rateToUsd;
    }
}
