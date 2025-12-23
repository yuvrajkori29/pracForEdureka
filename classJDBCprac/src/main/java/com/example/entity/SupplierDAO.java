package com.example.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SupplierDAO {
    public void addSupplier(Supplier s) {
        String sql = "INSERT INTO supplier (supplierId, supplierName, contactInfo) VALUES (?,?,?)";
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = jdbcConnection.dbUtil();
            
            if (con != null) {
                ps = con.prepareStatement(sql);
                
                ps.setInt(1, s.getSupplierId());
                ps.setString(2, s.getSupplierName());
                ps.setString(3, s.getContactInfo());
                
                ps.executeUpdate();
                System.out.println("Supplier added");
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
