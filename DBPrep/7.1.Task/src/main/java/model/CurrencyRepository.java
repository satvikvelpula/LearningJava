package model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyRepository {

    private static final String URL = "jdbc:mariadb://127.0.0.1:3306/currency_db";
    private static final String USER = "appuser";
    private static final String PASSWORD = "MyS3cur3P@ssw0rd!";

    public List<String> getAllCurrencyCodes() throws Exception {
        List<String> codes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT abbreviation FROM Currency ORDER BY abbreviation")) {

            while (rs.next()) {
                codes.add(rs.getString("abbreviation"));
            }
        } catch (SQLException e) {
            throw new Exception("Failed to fetch currency codes from DB: " + e.getMessage(), e);
        }
        return codes;
    }

    public BigDecimal getRate(String abbreviation) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT rate_to_usd FROM Currency WHERE abbreviation = ?")) {

            ps.setString(1, abbreviation);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBigDecimal("rate_to_usd");
                } else {
                    throw new Exception("Currency not found: " + abbreviation);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Failed to fetch rate from DB: " + e.getMessage(), e);
        }
    }
}
