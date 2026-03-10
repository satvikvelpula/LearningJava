package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Currency")
public class Currency {

    @Id
    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "name")
    private String name;

    @Column(name = "rate_to_usd")
    private double rateToUsd;

    public Currency() {}  // REQUIRED by JPA

    public Currency(String abbreviation, String name, double rateToUsd) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rateToUsd = rateToUsd;
    }

    public String getAbbreviation() { return abbreviation; }
    public String getName() { return name; }
    public double getRateToUsd() { return rateToUsd; }

    @Override
    public String toString() {
        return abbreviation + " - " + name;
    }
}
