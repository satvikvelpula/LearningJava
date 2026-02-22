package model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

public class CurrencyDBHandler {

    private static final String URL = "jdbc:mariadb://127.0.0.1:3306/currency_db";
    private static final String USER = "appuser";
    private static final String PASSWORD = "MyS3cur3P@ssw0rd!";

    public static void updateCurrencies(Map<String, BigDecimal> rates) throws Exception {
        if (rates == null || rates.isEmpty()) return;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO Currency (abbreviation, rate_to_usd) VALUES (?, ?)"
                    + " ON DUPLICATE KEY UPDATE rate_to_usd = VALUES(rate_to_usd)";


            try (PreparedStatement ps = conn.prepareStatement(query)) {
                for (Map.Entry<String, BigDecimal> entry : rates.entrySet()) {
                    ps.setString(1, entry.getKey());
                    ps.setBigDecimal(2, entry.getValue());
                    ps.addBatch();
                }
                ps.executeBatch();
            }
        } catch (Exception e) {
            throw new Exception("Failed to update database: " + e.getMessage(), e);
        }
    }
}
