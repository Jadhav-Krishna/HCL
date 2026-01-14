package com.hcl.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableAndInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hcl_db";
        String username = "root";
        String password = "root";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            
            String createTable = "CREATE TABLE IF NOT EXISTS Students (" +
                    "eno INT PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "branch VARCHAR(50), " +
                    "percentage DOUBLE, " +
                    "sem INT, " +
                    "year_of_passing INT)";
            
            stmt.executeUpdate(createTable);
            System.out.println("Table created successfully");
            
            String insert1 = "INSERT INTO Students VALUES (101, 'Rahul', 'CSE', 85.5, 7, 2025)";
            String insert2 = "INSERT INTO Students VALUES (102, 'Priya', 'EC', 78.2, 7, 2025)";
            String insert3 = "INSERT INTO Students VALUES (103, 'Amit', 'Civil', 72.5, 6, 2024)";
            String insert4 = "INSERT INTO Students VALUES (104, 'Sneha', 'CSE', 88.0, 6, 2025)";
            String insert5 = "INSERT INTO Students VALUES (105, 'Vijay', 'Civil', 65.3, 5, 2024)";
            
            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);
            stmt.executeUpdate(insert3);
            stmt.executeUpdate(insert4);
            stmt.executeUpdate(insert5);
            
            System.out.println("Records inserted successfully");
            
            stmt.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
