package entity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "source_currency_abbreviation")
    Currency currency;

    @ManyToOne
    @JoinColumn(name = "target_currency_abbreviation")
    Currency targetCurrency;

    @Column
    private BigDecimal amount;

    public Transaction() {}

    public Transaction(Currency currency, Currency targetCurrency, BigDecimal amount) {
        this.currency = currency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public BigDecimal getAmount() { return amount; }


}