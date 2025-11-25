package com.gucart.backend;

import java.sql.*;
import java.util.*;

public class OrderDAO {

    // 1. Save Order
    public void saveOrder(String customerName, double total, String status) {
        String sql = "INSERT INTO orders (customer_name, total_amount, status, date) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, customerName);
            pstmt.setDouble(2, total);
            pstmt.setString(3, status);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 2. Get All Orders
    public List<Map<String, Object>> getAllOrders() {
        List<Map<String, Object>> orders = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM orders ORDER BY date DESC")) {

            while (rs.next()) {
                Map<String, Object> order = new HashMap<>();
                order.put("_id", String.valueOf(rs.getInt("id"))); // Convert ID to string for frontend
                order.put("customerName", rs.getString("customer_name"));
                order.put("totalAmount", rs.getDouble("total_amount"));
                order.put("status", rs.getString("status"));
                order.put("date", rs.getTimestamp("date"));
                // Items are complex to store in simple SQL, leaving empty for this demo
                order.put("items", new ArrayList<>()); 
                orders.add(order);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return orders;
    }

    // 3. Update Order Status
    public void updateStatus(int id, String status) {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}