package com.hcl.training;

import java.io.*;
import java.util.*;

class InvalidEmployeeException extends Exception {
    public InvalidEmployeeException(String message) {
        super(message);
    }
}

class Employee {
    private String empId;
    private String name;
    private double salary;
    private String department;
    
    public Employee(String empId, String name, double salary, String department) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    
    public String getEmpId() {
        return empId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String toString() {
        return "ID: " + empId + ", Name: " + name + ", Salary: " + salary + ", Dept: " + department;
    }
    
    public String toFileString() {
        return empId + "," + name + "," + salary + "," + department;
    }
}

public class EmployeeManagementSystem {
    
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, Employee> employees = new HashMap<>();
    static final String FILE_NAME = "employees.txt";
    static final String LOGIN_FILE = "login.txt";
    static String loggedInUser = null;
    
    public static void loadEmployees() {
        try {
            File file = new File(FILE_NAME);
            if(!file.exists()) {
                return;
            }
            
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Employee emp = new Employee(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3]);
                employees.put(emp.getEmpId(), emp);
            }
            
            reader.close();
            System.out.println("Employees loaded successfully");
        } catch(IOException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
    }
    
    public static void saveEmployees() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            
            for(Employee emp : employees.values()) {
                writer.write(emp.toFileString());
                writer.newLine();
            }
            
            writer.close();
        } catch(IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }
    
    public static boolean login() {
        try {
            File file = new File(LOGIN_FILE);
            if(!file.exists()) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(LOGIN_FILE));
                writer.write("admin,admin123");
                writer.close();
            }
            
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            
            BufferedReader reader = new BufferedReader(new FileReader(LOGIN_FILE));
            String line;
            
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts[0].equals(username) && parts[1].equals(password)) {
                    loggedInUser = username;
                    reader.close();
                    System.out.println("Login successful");
                    return true;
                }
            }
            
            reader.close();
            System.out.println("Invalid credentials");
            return false;
        } catch(IOException e) {
            System.out.println("Error during login: " + e.getMessage());
            return false;
        }
    }
    
    public static void validateEmployee(String empId, String name, double salary, String department) throws InvalidEmployeeException {
        if(empId == null || empId.trim().isEmpty()) {
            throw new InvalidEmployeeException("Employee ID cannot be empty");
        }
        
        if(name == null || name.trim().isEmpty()) {
            throw new InvalidEmployeeException("Employee name cannot be empty");
        }
        
        if(salary <= 0) {
            throw new InvalidEmployeeException("Salary must be positive");
        }
        
        if(department == null || department.trim().isEmpty()) {
            throw new InvalidEmployeeException("Department cannot be empty");
        }
        
        if(employees.containsKey(empId)) {
            throw new InvalidEmployeeException("Employee ID already exists. Must be unique");
        }
    }
    
    public static void addEmployee() {
        try {
            System.out.print("Enter employee ID: ");
            String empId = sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter department: ");
            String department = sc.nextLine();
            
            validateEmployee(empId, name, salary, department);
            
            Employee emp = new Employee(empId, name, salary, department);
            employees.put(empId, emp);
            
            saveEmployees();
            System.out.println("Employee added successfully");
        } catch(InvalidEmployeeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void viewEmployees() {
        if(employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }
        
        System.out.println("\n--- All Employees ---");
        for(Employee emp : employees.values()) {
            System.out.println(emp);
        }
    }
    
    public static void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        String empId = sc.nextLine();
        
        Employee emp = employees.get(empId);
        if(emp == null) {
            System.out.println("Employee not found");
            return;
        }
        
        try {
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter new department: ");
            String department = sc.nextLine();
            
            if(name == null || name.trim().isEmpty()) {
                throw new InvalidEmployeeException("Employee name cannot be empty");
            }
            
            if(salary <= 0) {
                throw new InvalidEmployeeException("Salary must be positive");
            }
            
            if(department == null || department.trim().isEmpty()) {
                throw new InvalidEmployeeException("Department cannot be empty");
            }
            
            emp.setName(name);
            emp.setSalary(salary);
            emp.setDepartment(department);
            
            saveEmployees();
            System.out.println("Employee updated successfully");
        } catch(InvalidEmployeeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        String empId = sc.nextLine();
        
        Employee emp = employees.remove(empId);
        if(emp == null) {
            System.out.println("Employee not found");
            return;
        }
        
        saveEmployees();
        System.out.println("Employee deleted successfully");
    }
    
    public static void searchEmployee() {
        System.out.print("Enter employee ID to search: ");
        String empId = sc.nextLine();
        
        Employee emp = employees.get(empId);
        if(emp == null) {
            System.out.println("Employee not found");
            return;
        }
        
        System.out.println("\n--- Employee Details ---");
        System.out.println(emp);
    }
    
    public static void searchByDepartment() {
        System.out.print("Enter department: ");
        String dept = sc.nextLine();
        
        ArrayList<Employee> found = new ArrayList<>();
        for(Employee emp : employees.values()) {
            if(emp.getDepartment().equalsIgnoreCase(dept)) {
                found.add(emp);
            }
        }
        
        if(found.isEmpty()) {
            System.out.println("No employees found in " + dept);
            return;
        }
        
        System.out.println("\n--- Employees in " + dept + " ---");
        for(Employee emp : found) {
            System.out.println(emp);
        }
    }
    
    public static void displayStatistics() {
        if(employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }
        
        System.out.println("\n--- Employee Statistics ---");
        System.out.println("Total Employees: " + employees.size());
        
        double totalSalary = 0;
        HashMap<String, Integer> deptCount = new HashMap<>();
        
        for(Employee emp : employees.values()) {
            totalSalary += emp.getSalary();
            deptCount.put(emp.getDepartment(), deptCount.getOrDefault(emp.getDepartment(), 0) + 1);
        }
        
        System.out.println("Average Salary: " + (totalSalary / employees.size()));
        
        System.out.println("\nDepartment-wise Count:");
        for(Map.Entry<String, Integer> entry : deptCount.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static void sortEmployees() {
        if(employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }
        
        System.out.println("\n--- Sort By ---");
        System.out.println("1. Employee ID");
        System.out.println("2. Name");
        System.out.println("3. Salary");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        
        ArrayList<Employee> empList = new ArrayList<>(employees.values());
        
        switch(choice) {
            case 1:
                empList.sort((e1, e2) -> e1.getEmpId().compareTo(e2.getEmpId()));
                break;
            case 2:
                empList.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
                break;
            case 3:
                empList.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        
        System.out.println("\n--- Sorted Employees ---");
        for(Employee emp : empList) {
            System.out.println(emp);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("--- Employee Management System ---");
        
        if(!login()) {
            System.out.println("Login failed. Exiting...");
            return;
        }
        
        loadEmployees();
        
        while(true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee by ID");
            System.out.println("6. Search by Department");
            System.out.println("7. Display Statistics");
            System.out.println("8. Sort Employees");
            System.out.println("9. Logout");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 9) {
                System.out.println("Logged out successfully");
                break;
            }
            
            switch(choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    searchEmployee();
                    break;
                case 6:
                    searchByDepartment();
                    break;
                case 7:
                    displayStatistics();
                    break;
                case 8:
                    sortEmployees();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        
        sc.close();
    }
}
