package sgbdproj.models.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDbConnection {
    private static final String URL = "jdbc:postgresql://postgres:5432/test1";
    private static final String USER = "admin";
    private static final String PWD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PWD);
    }

}
