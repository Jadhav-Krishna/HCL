package com.hcl.training;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private String url = "jdbc:mysql://localhost:3306/hcl_db";
    private String username = "root";
    private String password = "root";
    
    public StudentDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            createTable();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private void createTable() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS student_records (" +
                    "eno INT PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "branch VARCHAR(50), " +
                    "percentage DOUBLE, " +
                    "sem INT)";
            st.executeUpdate(sql);
            st.close();
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addStudent(Student student) throws InvalidStudentException {
        if(isEnoExists(student.getEno())) {
            throw new InvalidStudentException("Eno already exists. Please use unique Eno");
        }
        
        if(student.getPercentage() <= 0) {
            throw new InvalidStudentException("Percentage should be positive");
        }
        
        if(student.getSem() <= 0) {
            throw new InvalidStudentException("Semester cannot be empty");
        }
        
        if(student.getBranch() == null || student.getBranch().trim().isEmpty()) {
            throw new InvalidStudentException("Branch cannot be empty");
        }
        
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO student_records VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, student.getEno());
            ps.setString(2, student.getName());
            ps.setString(3, student.getBranch());
            ps.setDouble(4, student.getPercentage());
            ps.setInt(5, student.getSem());
            ps.executeUpdate();
            ps.close();
            con.close();
            System.out.println("Student added successfully!");
        } catch(Exception e) {
            throw new InvalidStudentException("Error in adding student: " + e.getMessage());
        }
    }
    
    private boolean isEnoExists(int eno) {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM student_records WHERE eno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, eno);
            ResultSet rs = ps.executeQuery();
            boolean exists = rs.next();
            rs.close();
            pstmt.close();
            conn.close();
            return exists;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student_records");
            while(rs.next()) {
                Student s = new Student();
                s.setEno(rs.getInt("eno"));
                s.setName(rs.getString("name"));
                s.setBranch(rs.getString("branch"));
                s.setPercentage(rs.getDouble("percentage"));
                s.setSem(rs.getInt("sem"));
                students.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public Student searchByEno(int eno) throws InvalidStudentException {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM student_records WHERE eno = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, eno);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                Student s = new Student();
                s.setEno(rs.getInt("eno"));
                s.setName(rs.getString("name"));
                s.setBranch(rs.getString("branch"));
                s.setPercentage(rs.getDouble("percentage"));
                s.setSem(rs.getInt("sem"));
                rs.close();
                pstmt.close();
                conn.close();
                return s;
            } else {
                throw new InvalidStudentException("Student with Eno " + eno + " not found");
            }
        } catch(SQLException e) {
            throw new InvalidStudentException("Error searching student: " + e.getMessage());
        }
    }
    
    public void updateBranch(int eno, String newBranch) throws InvalidStudentException {
        if(newBranch == null || newBranch.trim().isEmpty()) {
            throw new InvalidStudentException("Branch cannot be empty");
        }
        
        if(!isEnoExists(eno)) {
            throw new InvalidStudentException("Student with Eno " + eno + " not found");
        }
        
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "UPDATE student_records SET branch = ? WHERE eno = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, newBranch);
            pstmt.setInt(2, eno);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            System.out.println("Branch updated successfully");
        } catch(Exception e) {
            throw new InvalidStudentException("Error updating branch: " + e.getMessage());
        }
    }
    
    public void deleteStudent(int eno) throws InvalidStudentException {
        if(!isEnoExists(eno)) {
            throw new InvalidStudentException("Student with Eno " + eno + " not found");
        }
        
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM student_records WHERE eno = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, eno);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            System.out.println("Student deleted successfully");
        } catch(Exception e) {
            throw new InvalidStudentException("Error deleting student: " + e.getMessage());
        }
    }
    
    public List<Student> getSortedStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student_records ORDER BY eno");
            while(rs.next()) {
                Student s = new Student();
                s.setEno(rs.getInt("eno"));
                s.setName(rs.getString("name"));
                s.setBranch(rs.getString("branch"));
                s.setPercentage(rs.getDouble("percentage"));
                s.setSem(rs.getInt("sem"));
                students.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
