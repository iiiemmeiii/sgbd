package sgbdproj.models.bootstrap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresInitializeDb {
    static final String URL = "jdbc:postgresql://postgres:5432/";
    private static final String USER = "admin";
    private static final String PWD = "admin";
    private static final String DEFAULT_DB_NAME = "postgres";
    private static final String DB_NAME = "test1";

    public static void initialize() {
        createDb();
        createTables();
    }

    static void createDb() {
        try (
                Connection adminConnection = DriverManager.getConnection(URL + DEFAULT_DB_NAME, USER, PWD);
                Statement statement = adminConnection.createStatement()) {
            try {
                String sql = String.format("CREATE DATABASE %s", DB_NAME);
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println(String.format("ERROR DB CREATION : %s",
                        e.getMessage()));
            }
        } catch (SQLException e) {
            System.out.println(String.format("ERROR CONNECTION : %s",
                    e.getMessage()));
        }
    }

    static void createTables() {
        try (
                Connection adminConnection = DriverManager.getConnection(URL + DB_NAME, USER, PWD);
                Statement statement = adminConnection.createStatement()) {
            try {
                String q_create = """
                        CREATE TABLE IF NOT EXISTS sections (
                        id SERIAL PRIMARY KEY NOT NULL UNIQUE,
                        nom VARCHAR(30)
                        );
                        """;
                statement.executeUpdate(q_create);
                System.out.println("YES > TABLE SECTIONS IS OK");

                //
            } catch (SQLException e) {
                System.out.println(String.format("ERROR TABLE CREATION : %s",
                        e.getMessage()));
            }
            // ##############################################################

            try {
                String q_create = """
                        CREATE TABLE IF NOT EXISTS cours (
                        id SERIAL PRIMARY KEY NOT NULL UNIQUE,
                        nom VARCHAR(30)
                        );
                        """;
                statement.executeUpdate(q_create);
                System.out.println("YES > TABLE SECTIONS IS OK");
                //
            } catch (SQLException e) {
                System.out.println(String.format("ERROR TABLE CREATION : %s",
                        e.getMessage()));
            }

            // ##############################################################

            try {
                String q_create = """
                        CREATE TABLE IF NOT EXISTS status (
                        id SERIAL PRIMARY KEY NOT NULL UNIQUE,
                        status VARCHAR(30)
                        );
                        """;
                statement.executeUpdate(q_create);
                System.out.println("YES > TABLE STATUS IS OK");
                //
            } catch (SQLException e) {
                System.out.println(String.format("ERROR TABLE CREATION : %s",
                        e.getMessage()));
            }
        } catch (SQLException e) {
            System.out.println(String.format("ERROR CONNECTION : %s",
                    e.getMessage()));
        }
    }

}
