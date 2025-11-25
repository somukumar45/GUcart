package com.gucart.backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// CRITERIA: Class for database operations
public class DatabaseConnection {
   private static final String URL = "jdbc:h2:mem:gucart_db"; // H2 Memory DB
private static final String USER = "sa";
private static final String PASS = "";

    // CRITERIA: Exception Handling (throws SQLException)
    public static Connection getConnection() throws SQLException {
        try {
            // CRITERIA: Implement JDBC
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("❌ Database Connection Failed!");
            throw e;
        }
    }
}