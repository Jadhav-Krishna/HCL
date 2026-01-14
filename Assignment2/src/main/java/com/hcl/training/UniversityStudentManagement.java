package com.hcl.training;

import java.util.*;

class UniversityStudent {
    private String studentId;
    private String name;
    private int age;
    private String department;
    private double cgpa;
    private ArrayList<String> courses;
    
    public UniversityStudent(String studentId, String name, int age, String department, double cgpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.cgpa = cgpa;
        this.courses = new ArrayList<>();
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public double getCgpa() {
        return cgpa;
    }
    
    public void addCourse(String course) {
        courses.add(course);
    }
    
    public ArrayList<String> getCourses() {
        return courses;
    }
    
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Age: " + age + 
               ", Dept: " + department + ", CGPA: " + cgpa + ", Courses: " + courses;
    }
}

public class UniversityStudentManagement {
    
    static Scanner sc = new Scanner(System.in);
    static ArrayList<UniversityStudent> studentList = new ArrayList<>();
    static HashMap<String, UniversityStudent> studentMap = new HashMap<>();
    static TreeMap<Double, ArrayList<UniversityStudent>> cgpaMap = new TreeMap<>();
    static HashMap<String, ArrayList<UniversityStudent>> departmentMap = new HashMap<>();
    
    public static void addStudent() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();
        
        if(studentMap.containsKey(id)) {
            System.out.println("Student ID already exists");
            return;
        }
        
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter department: ");
        String dept = sc.nextLine();
        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine();
        
        UniversityStudent student = new UniversityStudent(id, name, age, dept, cgpa);
        
        System.out.print("Enter number of courses: ");
        int numCourses = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < numCourses; i++) {
            System.out.print("Enter course " + (i+1) + ": ");
            String course = sc.nextLine();
            student.addCourse(course);
        }
        
        studentList.add(student);
        studentMap.put(id, student);
        
        if(!cgpaMap.containsKey(cgpa)) {
            cgpaMap.put(cgpa, new ArrayList<>());
        }
        cgpaMap.get(cgpa).add(student);
        
        if(!departmentMap.containsKey(dept)) {
            departmentMap.put(dept, new ArrayList<>());
        }
        departmentMap.get(dept).add(student);
        
        System.out.println("Student added successfully");
    }
    
    public static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        String id = sc.nextLine();
        
        UniversityStudent student = studentMap.get(id);
        if(student == null) {
            System.out.println("Student not found");
            return;
        }
        
        studentList.remove(student);
        studentMap.remove(id);
        
        ArrayList<UniversityStudent> cgpaList = cgpaMap.get(student.getCgpa());
        cgpaList.remove(student);
        if(cgpaList.isEmpty()) {
            cgpaMap.remove(student.getCgpa());
        }
        
        ArrayList<UniversityStudent> deptList = departmentMap.get(student.getDepartment());
        deptList.remove(student);
        if(deptList.isEmpty()) {
            departmentMap.remove(student.getDepartment());
        }
        
        System.out.println("Student removed successfully");
    }
    
    public static void displayAllStudents() {
        if(studentList.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        
        System.out.println("\n--- All Students ---");
        for(UniversityStudent student : studentList) {
            System.out.println(student);
        }
    }
    
    public static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        String id = sc.nextLine();
        
        UniversityStudent student = studentMap.get(id);
        if(student != null) {
            System.out.println("\n--- Student Details ---");
            System.out.println(student);
        } else {
            System.out.println("Student not found");
        }
    }
    
    public static void displayByDepartment() {
        System.out.print("Enter department: ");
        String dept = sc.nextLine();
        
        ArrayList<UniversityStudent> students = departmentMap.get(dept);
        if(students == null || students.isEmpty()) {
            System.out.println("No students found in " + dept);
            return;
        }
        
        System.out.println("\n--- Students in " + dept + " ---");
        for(UniversityStudent student : students) {
            System.out.println(student);
        }
    }
    
    public static void displayByCGPA() {
        System.out.println("\n--- Students by CGPA (Sorted) ---");
        if(cgpaMap.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        
        for(Map.Entry<Double, ArrayList<UniversityStudent>> entry : cgpaMap.descendingMap().entrySet()) {
            System.out.println("\nCGPA: " + entry.getKey());
            for(UniversityStudent student : entry.getValue()) {
                System.out.println("  " + student);
            }
        }
    }
    
    public static void displayTopStudents() {
        System.out.print("Enter number of top students to display: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        if(cgpaMap.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        
        System.out.println("\n--- Top " + n + " Students ---");
        int count = 0;
        for(Map.Entry<Double, ArrayList<UniversityStudent>> entry : cgpaMap.descendingMap().entrySet()) {
            for(UniversityStudent student : entry.getValue()) {
                System.out.println(student);
                count++;
                if(count >= n) return;
            }
        }
    }
    
    public static void displayStudentCourses() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();
        
        UniversityStudent student = studentMap.get(id);
        if(student == null) {
            System.out.println("Student not found");
            return;
        }
        
        System.out.println("\n--- Courses for " + id + " ---");
        ArrayList<String> courses = student.getCourses();
        if(courses.isEmpty()) {
            System.out.println("No courses enrolled");
        } else {
            for(int i = 0; i < courses.size(); i++) {
                System.out.println((i+1) + ". " + courses.get(i));
            }
        }
    }
    
    public static void displayStatistics() {
        System.out.println("\n--- System Statistics ---");
        System.out.println("Total Students: " + studentList.size());
        System.out.println("Total Departments: " + departmentMap.size());
        
        if(!studentList.isEmpty()) {
            double totalCGPA = 0;
            for(UniversityStudent student : studentList) {
                totalCGPA += student.getCgpa();
            }
            System.out.println("Average CGPA: " + (totalCGPA / studentList.size()));
        }
        
        System.out.println("\nDepartment-wise Count:");
        for(Map.Entry<String, ArrayList<UniversityStudent>> entry : departmentMap.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue().size());
        }
    }
    
    public static void main(String[] args) {
        while(true) {
            System.out.println("\n--- University Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Search Student");
            System.out.println("5. Display Students by Department");
            System.out.println("6. Display Students by CGPA (Sorted)");
            System.out.println("7. Display Top N Students");
            System.out.println("8. Display Student Courses");
            System.out.println("9. Display Statistics");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 10) {
                System.out.println("Exiting...");
                break;
            }
            
            switch(choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    displayAllStudents();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    displayByDepartment();
                    break;
                case 6:
                    displayByCGPA();
                    break;
                case 7:
                    displayTopStudents();
                    break;
                case 8:
                    displayStudentCourses();
                    break;
                case 9:
                    displayStatistics();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
