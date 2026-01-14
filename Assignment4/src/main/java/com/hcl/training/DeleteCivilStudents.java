package com.hcl.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteCivilStudents {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hcl_db";
        String username = "root";
        String password = "root";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            
            String deleteQuery = "DELETE FROM Students WHERE year_of_passing = 2024 AND branch = 'Civil'";
            
            int rowsDeleted = stmt.executeUpdate(deleteQuery);
            System.out.println(rowsDeleted + " records deleted successfully");
            System.out.println("All Civil branch students of 2024 deleted");
            
            stmt.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
