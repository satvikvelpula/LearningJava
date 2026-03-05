package model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Currency;
import java.util.Map;

public class CurrencyDBHandler {

    private static final String URL = "db";
    private static final String USER = "appuser";
    private static final String PASSWORD = "pass";

    public static void updateCurrencies(Map<String, BigDecimal> rates) throws Exception {

        if (rates == null || rates.isEmpty()) return;

        try (Connection conn = java.sql.DriverManager.getConnection(URL, USER, PASSWORD)) {

            String query =
                    "INSERT INTO Currency (abbreviation, name, rate_to_usd) VALUES (?, ?, ?) " +
                            "ON DUPLICATE KEY UPDATE name = VALUES(name), rate_to_usd = VALUES(rate_to_usd)";

            try (PreparedStatement ps = conn.prepareStatement(query)) {

                for (Map.Entry<String, BigDecimal> entry : rates.entrySet()) {

                    String code = entry.getKey();
                    BigDecimal rate = entry.getValue();

                    try {
                        Currency currency = Currency.getInstance(code);
                        String name = currency.getDisplayName();


                        if (name != null && !name.trim().isEmpty()) {
                            ps.setString(1, code);
                            ps.setString(2, name);
                            ps.setBigDecimal(3, rate);
                            ps.addBatch();
                        } else {
                            System.out.println("Skipping currency with empty name: " + code);
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid ISO 4217 code: " + code);
                    }

                    ps.executeBatch();
                }

            }

        } catch (Exception e) {
            throw new Exception("Failed to update database: " + e.getMessage(), e);
        }
    }
}
