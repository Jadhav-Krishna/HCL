package com.hcl.training;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hcl_db";
        String username = "root";
        String password = "root";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            
            if(conn != null) {
                System.out.println("Connection Successful");
                conn.close();
            }
        } catch(Exception e) {
            System.out.println("Unable to connect");
            e.printStackTrace();
        }
    }
}
