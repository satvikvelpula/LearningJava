package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {

    private static final String URL = "jdbc:mariadb://127.0.0.1:3306/currency_db";
    private static final String USER = "appuser";
    private static final String PASSWORD = "MyS3cur3P@ssw0rd!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
