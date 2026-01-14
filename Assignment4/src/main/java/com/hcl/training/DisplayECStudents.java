package com.hcl.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayECStudents {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hcl_db";
        String username = "root";
        String password = "root";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            
            String selectQuery = "SELECT * FROM Students WHERE sem = 7 AND branch = 'EC'";
            
            ResultSet rs = stmt.executeQuery(selectQuery);
            
            System.out.println("Students with semester 7 and branch EC:");
            System.out.println("ENO\tNAME\tBRANCH\tPERCENTAGE\tSEM\tYEAR");
            
            while(rs.next()) {
                int eno = rs.getInt("eno");
                String name = rs.getString("name");
                String branch = rs.getString("branch");
                double percentage = rs.getDouble("percentage");
                int sem = rs.getInt("sem");
                int year = rs.getInt("year_of_passing");
                
                System.out.println(eno + "\t" + name + "\t" + branch + "\t" + percentage + "\t" + sem + "\t" + year);
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
