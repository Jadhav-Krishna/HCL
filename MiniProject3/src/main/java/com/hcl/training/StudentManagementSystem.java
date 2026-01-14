package com.hcl.training;

import java.util.Scanner;
import java.util.List;

public class StudentManagementSystem {
    private static StudentDAO dao = new StudentDAO();
    private static Scanner sc = new Scanner(System.in);
    private static boolean isLoggedIn = false;
    
    public static void main(String[] args) {
        login();
        
        if(isLoggedIn) {
            showMenu();
        }
    }
    
    private static void login() {
        System.out.println("=== Student Management System Login ===");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
        if(username.equals("admin") && password.equals("admin123")) {
            isLoggedIn = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Exiting...");
            System.exit(0);
        }
    }
    
    private static void showMenu() {
        while(true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Students");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Students by Eno");
            System.out.println("4. Update Students Branch");
            System.out.println("5. Delete Students by Eno");
            System.out.println("6. Display Sorted Students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(sc.nextLine());
                
                switch(choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayAllStudents();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        updateBranch();
                        break;
                    case 5:
                        deleteStudent();
                        break;
                    case 6:
                        displaySortedStudents();
                        break;
                    case 7:
                        System.out.println("Exiting... Thank you!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch(NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
    
    private static void addStudent() {
        try {
            System.out.print("Enter Eno: ");
            int eno = Integer.parseInt(sc.nextLine());
            
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter Branch: ");
            String branch = sc.nextLine();
            
            System.out.print("Enter Percentage: ");
            double percentage = Double.parseDouble(sc.nextLine());
            
            System.out.print("Enter Sem: ");
            int sem = Integer.parseInt(sc.nextLine());
            
            Student student = new Student(eno, name, branch, percentage, sem);
            dao.addStudent(student);
        } catch(InvalidStudentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(NumberFormatException e) {
            System.out.println("Error: Invalid number format");
        }
    }
    
    private static void displayAllStudents() {
        List<Student> students = dao.getAllStudents();
        if(students.isEmpty()) {
            System.out.println("No students found");
        } else {
            System.out.println("\nENO\tNAME\tBRANCH\tPERCENTAGE\tSEM");
            for(Student s : students) {
                System.out.println(s);
            }
        }
    }
    
    private static void searchStudent() {
        try {
            System.out.print("Enter Eno to search: ");
            int eno = Integer.parseInt(sc.nextLine());
            Student s = dao.searchByEno(eno);
            System.out.println("\nENO\tNAME\tBRANCH\tPERCENTAGE\tSEM");
            System.out.println(s);
        } catch(InvalidStudentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(NumberFormatException e) {
            System.out.println("Error: Invalid number format");
        }
    }
    
    private static void updateBranch() {
        try {
            System.out.print("Enter Eno: ");
            int eno = Integer.parseInt(sc.nextLine());
            
            System.out.print("Enter New Branch: ");
            String branch = sc.nextLine();
            
            dao.updateBranch(eno, branch);
        } catch(InvalidStudentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(NumberFormatException e) {
            System.out.println("Error: Invalid number format");
        }
    }
    
    private static void deleteStudent() {
        try {
            System.out.print("Enter Eno to delete: ");
            int eno = Integer.parseInt(sc.nextLine());
            dao.deleteStudent(eno);
        } catch(InvalidStudentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(NumberFormatException e) {
            System.out.println("Error: Invalid number format");
        }
    }
    
    private static void displaySortedStudents() {
        List<Student> students = dao.getSortedStudents();
        if(students.isEmpty()) {
            System.out.println("No students found");
        } else {
            System.out.println("\nENO\tNAME\tBRANCH\tPERCENTAGE\tSEM");
            for(Student s : students) {
                System.out.println(s);
            }
        }
    }
}
