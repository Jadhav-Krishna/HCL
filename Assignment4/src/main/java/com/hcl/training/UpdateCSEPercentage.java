package com.hcl.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateCSEPercentage {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hcl_db";
        String username = "root";
        String password = "root";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            
            String updateQuery = "UPDATE Students SET percentage = percentage * 1.05 WHERE branch = 'CSE'";
            
            int rowsUpdated = stmt.executeUpdate(updateQuery);
            System.out.println(rowsUpdated + " records updated successfully");
            System.out.println("5% increased to all CSE students percentage");
            
            stmt.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
