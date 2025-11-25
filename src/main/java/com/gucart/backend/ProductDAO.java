package com.gucart.backend;

import java.sql.*;
import java.util.*;

public class ProductDAO {
    
    // 1. Fetch All Products
    public List<Map<String, Object>> getAllProducts() {
        List<Map<String, Object>> products = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {

            while (rs.next()) {
                Map<String, Object> product = new HashMap<>();
                product.put("_id", rs.getInt("id"));
                product.put("name", rs.getString("name"));
                product.put("price", rs.getDouble("price"));
                product.put("category", rs.getString("category"));
                product.put("image", rs.getString("image"));
                products.add(product);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return products;
    }

    // 2. Add New Product
    public void addProduct(String name, double price, String desc, String image, String category, String email) {
        String sql = "INSERT INTO products (name, price, description, image, category, seller_email) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setString(3, desc);
            pstmt.setString(4, image);
            pstmt.setString(5, category);
            pstmt.setString(6, email);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 3. Get Product by ID
    public Map<String, Object> getProductById(int id) {
        Map<String, Object> product = new HashMap<>();
        String sql = "SELECT * FROM products WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                product.put("_id", rs.getInt("id"));
                product.put("name", rs.getString("name"));
                product.put("price", rs.getDouble("price"));
                product.put("image", rs.getString("image"));
                product.put("description", rs.getString("description"));
                product.put("category", rs.getString("category"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return product;
    }
}