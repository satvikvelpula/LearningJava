package dao;

import datasource.MariaDbConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {

    public List<String> getAllCurrencyCodes() throws Exception {
        List<String> codes = new ArrayList<>();

        try (Connection conn = MariaDbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT abbreviation FROM Currency ORDER BY abbreviation")) {

            while (rs.next()) {
                codes.add(rs.getString("abbreviation"));
            }

        } catch (SQLException e) {
            throw new Exception("Database unavailable: " + e.getMessage(), e);
        }

        return codes;
    }

    public double getRate(String abbreviation) throws Exception {

        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT rate_to_usd FROM Currency WHERE abbreviation = ?")) {

            ps.setString(1, abbreviation);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("rate_to_usd");
                } else {
                    throw new Exception("Currency not found");
                }
            }

        } catch (SQLException e) {
            throw new Exception("Database unavailable: " + e.getMessage(), e);
        }
    }
}
