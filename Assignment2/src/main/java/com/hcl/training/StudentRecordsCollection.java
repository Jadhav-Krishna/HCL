package com.hcl.training;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

class Student {
    private String rollNo;
    private String name;
    private int age;
    private String department;
    
    public Student(String rollNo, String name, int age, String department) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.department = department;
    }
    
    public String getRollNo() {
        return rollNo;
    }
    
    public String toString() {
        return "Roll: " + rollNo + ", Name: " + name + ", Age: " + age + ", Dept: " + department;
    }
}

public class StudentRecordsCollection {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void arrayListOperations() {
        ArrayList<Student> students = new ArrayList<>();
        
        while(true) {
            System.out.println("\n--- ArrayList Operations ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Search Student");
            System.out.println("5. Update Student");
            System.out.println("6. Get Size");
            System.out.println("7. Check if Empty");
            System.out.println("8. Clear All");
            System.out.println("9. Back");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 9) break;
            
            switch(choice) {
                case 1:
                    System.out.print("Enter roll no: ");
                    String roll = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    students.add(new Student(roll, name, age, dept));
                    System.out.println("Student added successfully");
                    break;
                case 2:
                    System.out.print("Enter roll no to remove: ");
                    String removeRoll = sc.nextLine();
                    boolean removed = students.removeIf(s -> s.getRollNo().equals(removeRoll));
                    System.out.println(removed ? "Student removed" : "Student not found");
                    break;
                case 3:
                    if(students.isEmpty()) {
                        System.out.println("No students found");
                    } else {
                        for(Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter roll no to search: ");
                    String searchRoll = sc.nextLine();
                    boolean found = false;
                    for(Student s : students) {
                        if(s.getRollNo().equals(searchRoll)) {
                            System.out.println("Found: " + s);
                            found = true;
                            break;
                        }
                    }
                    if(!found) System.out.println("Student not found");
                    break;
                case 5:
                    System.out.print("Enter roll no to update: ");
                    String updateRoll = sc.nextLine();
                    for(int i = 0; i < students.size(); i++) {
                        if(students.get(i).getRollNo().equals(updateRoll)) {
                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();
                            System.out.print("Enter new age: ");
                            int newAge = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter new department: ");
                            String newDept = sc.nextLine();
                            students.set(i, new Student(updateRoll, newName, newAge, newDept));
                            System.out.println("Student updated");
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Total students: " + students.size());
                    break;
                case 7:
                    System.out.println(students.isEmpty() ? "List is empty" : "List is not empty");
                    break;
                case 8:
                    students.clear();
                    System.out.println("All students cleared");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    public static void vectorOperations() {
        Vector<Student> students = new Vector<>();
        
        while(true) {
            System.out.println("\n--- Vector Operations ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Get Capacity");
            System.out.println("5. Get Size");
            System.out.println("6. Check if Contains");
            System.out.println("7. Back");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 7) break;
            
            switch(choice) {
                case 1:
                    System.out.print("Enter roll no: ");
                    String roll = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    students.add(new Student(roll, name, age, dept));
                    System.out.println("Student added successfully");
                    break;
                case 2:
                    System.out.print("Enter roll no to remove: ");
                    String removeRoll = sc.nextLine();
                    boolean removed = students.removeIf(s -> s.getRollNo().equals(removeRoll));
                    System.out.println(removed ? "Student removed" : "Student not found");
                    break;
                case 3:
                    if(students.isEmpty()) {
                        System.out.println("No students found");
                    } else {
                        for(Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Current capacity: " + students.capacity());
                    break;
                case 5:
                    System.out.println("Total students: " + students.size());
                    break;
                case 6:
                    System.out.print("Enter roll no to check: ");
                    String checkRoll = sc.nextLine();
                    boolean exists = false;
                    for(Student s : students) {
                        if(s.getRollNo().equals(checkRoll)) {
                            exists = true;
                            break;
                        }
                    }
                    System.out.println(exists ? "Student exists" : "Student not found");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    public static void listOperations() {
        List<Student> students = new ArrayList<>();
        
        while(true) {
            System.out.println("\n--- List Interface Operations ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student by Index");
            System.out.println("3. Display All Students");
            System.out.println("4. Get Student by Index");
            System.out.println("5. Get Size");
            System.out.println("6. Back");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 6) break;
            
            switch(choice) {
                case 1:
                    System.out.print("Enter roll no: ");
                    String roll = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    students.add(new Student(roll, name, age, dept));
                    System.out.println("Student added successfully");
                    break;
                case 2:
                    System.out.print("Enter index to remove: ");
                    int index = sc.nextInt();
                    if(index >= 0 && index < students.size()) {
                        students.remove(index);
                        System.out.println("Student removed");
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case 3:
                    if(students.isEmpty()) {
                        System.out.println("No students found");
                    } else {
                        for(int i = 0; i < students.size(); i++) {
                            System.out.println(i + ". " + students.get(i));
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter index: ");
                    int getIndex = sc.nextInt();
                    if(getIndex >= 0 && getIndex < students.size()) {
                        System.out.println(students.get(getIndex));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case 5:
                    System.out.println("Total students: " + students.size());
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    public static void main(String[] args) {
        while(true) {
            System.out.println("\n--- Student Records Management ---");
            System.out.println("1. ArrayList Operations");
            System.out.println("2. Vector Operations");
            System.out.println("3. List Interface Operations");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 4) {
                System.out.println("Exiting...");
                break;
            }
            
            switch(choice) {
                case 1:
                    arrayListOperations();
                    break;
                case 2:
                    vectorOperations();
                    break;
                case 3:
                    listOperations();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
