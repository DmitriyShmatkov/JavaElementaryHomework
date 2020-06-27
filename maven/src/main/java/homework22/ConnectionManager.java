package homework22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/university_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "DShmatkov";

    private ConnectionManager() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
