package com.example.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDAO {
   
   public void addProduct(Product p) {
        String sql = "INSERT INTO product (productId, productName, price, supplierId) VALUES (?,?,?,?)";
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = jdbcConnection.dbUtil();
            
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, p.getProductId());
                ps.setString(2, p.getProductName());
                ps.setDouble(3, p.getPrice());
                ps.setInt(4, p.getSupplierId());
                
                ps.executeUpdate();
                System.out.println("Product added");
            } else {
                System.out.println("Connection failed.");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
