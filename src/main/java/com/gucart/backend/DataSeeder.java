package com.gucart.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.sql.*;

@Component
public class DataSeeder implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            
            // Create Products Table
            stmt.execute("CREATE TABLE IF NOT EXISTS products (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY, " +
                        "name VARCHAR(255), price DOUBLE, " +
                        "description VARCHAR(1000), image VARCHAR(500), " +
                        "category VARCHAR(100), seller_email VARCHAR(100))");

            // Create Orders Table
            stmt.execute("CREATE TABLE IF NOT EXISTS orders (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY, " +
                        "customer_name VARCHAR(255), total_amount DOUBLE, " +
                        "status VARCHAR(50), date TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

            // Seed Products if empty
            if (!stmt.executeQuery("SELECT * FROM products").next()) {
                stmt.execute("INSERT INTO products (name, price, category, image, description) VALUES " +
                            "('Wireless Headphones', 1299.0, 'Electronics', 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e', 'High quality noise cancelling'), " +
                            "('Running Shoes', 4999.0, 'Fashion', 'https://images.unsplash.com/photo-1542291026-7eec264c27ff', 'Comfortable running shoes')");
                System.out.println("✅ Database Tables Created & Seeded!");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}