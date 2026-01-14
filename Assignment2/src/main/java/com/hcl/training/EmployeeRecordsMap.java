package com.hcl.training;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Map;

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
    
    public String toString() {
        return "ID: " + empId + ", Name: " + name + ", Salary: " + salary + ", Dept: " + department;
    }
}

public class EmployeeRecordsMap {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void hashMapOperations() {
        HashMap<String, Employee> employees = new HashMap<>();
        
        while(true) {
            System.out.println("\n--- HashMap Operations ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Search Employee");
            System.out.println("5. Update Employee");
            System.out.println("6. Get Size");
            System.out.println("7. Check if Empty");
            System.out.println("8. Clear All");
            System.out.println("9. Check if Key Exists");
            System.out.println("10. Back");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 10) break;
            
            switch(choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    employees.put(id, new Employee(id, name, salary, dept));
                    System.out.println("Employee added successfully");
                    break;
                case 2:
                    System.out.print("Enter employee ID to remove: ");
                    String removeId = sc.nextLine();
                    Employee removed = employees.remove(removeId);
                    System.out.println(removed != null ? "Employee removed" : "Employee not found");
                    break;
                case 3:
                    if(employees.isEmpty()) {
                        System.out.println("No employees found");
                    } else {
                        for(Map.Entry<String, Employee> entry : employees.entrySet()) {
                            System.out.println(entry.getValue());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter employee ID to search: ");
                    String searchId = sc.nextLine();
                    Employee emp = employees.get(searchId);
                    if(emp != null) {
                        System.out.println("Found: " + emp);
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;
                case 5:
                    System.out.print("Enter employee ID to update: ");
                    String updateId = sc.nextLine();
                    if(employees.containsKey(updateId)) {
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new salary: ");
                        double newSalary = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter new department: ");
                        String newDept = sc.nextLine();
                        employees.put(updateId, new Employee(updateId, newName, newSalary, newDept));
                        System.out.println("Employee updated");
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;
                case 6:
                    System.out.println("Total employees: " + employees.size());
                    break;
                case 7:
                    System.out.println(employees.isEmpty() ? "Map is empty" : "Map is not empty");
                    break;
                case 8:
                    employees.clear();
                    System.out.println("All employees cleared");
                    break;
                case 9:
                    System.out.print("Enter employee ID to check: ");
                    String checkId = sc.nextLine();
                    System.out.println(employees.containsKey(checkId) ? "Employee exists" : "Employee not found");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    public static void hashtableOperations() {
        Hashtable<String, Employee> employees = new Hashtable<>();
        
        while(true) {
            System.out.println("\n--- Hashtable Operations ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Search Employee");
            System.out.println("5. Get Size");
            System.out.println("6. Check if Empty");
            System.out.println("7. Check if Key Exists");
            System.out.println("8. Check if Value Exists");
            System.out.println("9. Back");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 9) break;
            
            switch(choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    employees.put(id, new Employee(id, name, salary, dept));
                    System.out.println("Employee added successfully");
                    break;
                case 2:
                    System.out.print("Enter employee ID to remove: ");
                    String removeId = sc.nextLine();
                    Employee removed = employees.remove(removeId);
                    System.out.println(removed != null ? "Employee removed" : "Employee not found");
                    break;
                case 3:
                    if(employees.isEmpty()) {
                        System.out.println("No employees found");
                    } else {
                        for(Map.Entry<String, Employee> entry : employees.entrySet()) {
                            System.out.println(entry.getValue());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter employee ID to search: ");
                    String searchId = sc.nextLine();
                    Employee emp = employees.get(searchId);
                    if(emp != null) {
                        System.out.println("Found: " + emp);
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;
                case 5:
                    System.out.println("Total employees: " + employees.size());
                    break;
                case 6:
                    System.out.println(employees.isEmpty() ? "Hashtable is empty" : "Hashtable is not empty");
                    break;
                case 7:
                    System.out.print("Enter employee ID to check: ");
                    String checkId = sc.nextLine();
                    System.out.println(employees.containsKey(checkId) ? "Employee exists" : "Employee not found");
                    break;
                case 8:
                    System.out.print("Enter employee ID to check value: ");
                    String valueId = sc.nextLine();
                    Employee checkEmp = employees.get(valueId);
                    System.out.println(employees.contains(checkEmp) ? "Value exists" : "Value not found");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    public static void treeMapOperations() {
        TreeMap<String, Employee> employees = new TreeMap<>();
        
        while(true) {
            System.out.println("\n--- TreeMap Operations ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display All Employees (Sorted)");
            System.out.println("4. Search Employee");
            System.out.println("5. Get First Entry");
            System.out.println("6. Get Last Entry");
            System.out.println("7. Get Size");
            System.out.println("8. Clear All");
            System.out.println("9. Back");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 9) break;
            
            switch(choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    employees.put(id, new Employee(id, name, salary, dept));
                    System.out.println("Employee added successfully");
                    break;
                case 2:
                    System.out.print("Enter employee ID to remove: ");
                    String removeId = sc.nextLine();
                    Employee removed = employees.remove(removeId);
                    System.out.println(removed != null ? "Employee removed" : "Employee not found");
                    break;
                case 3:
                    if(employees.isEmpty()) {
                        System.out.println("No employees found");
                    } else {
                        for(Map.Entry<String, Employee> entry : employees.entrySet()) {
                            System.out.println(entry.getValue());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter employee ID to search: ");
                    String searchId = sc.nextLine();
                    Employee emp = employees.get(searchId);
                    if(emp != null) {
                        System.out.println("Found: " + emp);
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;
                case 5:
                    if(!employees.isEmpty()) {
                        Map.Entry<String, Employee> first = employees.firstEntry();
                        System.out.println("First: " + first.getValue());
                    } else {
                        System.out.println("Map is empty");
                    }
                    break;
                case 6:
                    if(!employees.isEmpty()) {
                        Map.Entry<String, Employee> last = employees.lastEntry();
                        System.out.println("Last: " + last.getValue());
                    } else {
                        System.out.println("Map is empty");
                    }
                    break;
                case 7:
                    System.out.println("Total employees: " + employees.size());
                    break;
                case 8:
                    employees.clear();
                    System.out.println("All employees cleared");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    public static void main(String[] args) {
        while(true) {
            System.out.println("\n--- Employee Records Management ---");
            System.out.println("1. HashMap Operations");
            System.out.println("2. Hashtable Operations");
            System.out.println("3. TreeMap Operations");
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
                    hashMapOperations();
                    break;
                case 2:
                    hashtableOperations();
                    break;
                case 3:
                    treeMapOperations();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
