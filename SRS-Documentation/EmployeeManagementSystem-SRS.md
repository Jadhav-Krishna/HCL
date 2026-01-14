# Software Requirements Specification
## for
## Employee Management System

**Version 1.0 approved**

**Prepared by:** HCL Training Team  
**Organization:** HCL Technologies  
**Date Created:** January 15, 2026

---

## Revision History

| Date | Version | Description | Author |
|------|---------|-------------|--------|
| Jan 15, 2026 | 1.0 | Initial SRS Document | HCL Training Team |

---

## Table of Contents

1. [Introduction](#1-introduction)
2. [Overall Description](#2-overall-description)
3. [External Interface Requirements](#3-external-interface-requirements)
4. [Other Non-Functional Requirements](#4-other-non-functional-requirements)

---

## 1. Introduction

### 1.1 Purpose

This SRS document describes the Employee Management System, a file-based application for managing employee records with complete CRUD operations, login authentication, and data validation.

### 1.2 Scope

The Employee Management System provides:
- Employee record management with file persistence
- Login/logout authentication system
- CRUD operations with validation
- Unique employee ID enforcement
- Department-wise employee search
- Statistical reporting
- Sorting capabilities by multiple criteria

### 1.3 Technology Used

**Programming Language:** Java 11  
**Storage:** File-based (employees.txt, login.txt)  
**Collections:** HashMap, ArrayList  
**Build Tool:** Apache Maven  
**Architecture:** Console-based with file persistence

### 1.4 Document Conventions

- **Employee ID:** Unique identifier, cannot be empty
- **Salary:** Must be positive value
- **Department:** Cannot be empty
- **File Format:** CSV (comma-separated values)

---

## 2. Overall Description

### 2.1 Product Perspective

Standalone file-based application using Java Collections Framework for in-memory operations with persistent file storage. All changes immediately persisted to file system.

### 2.2 Product Functions

1. **Authentication System**
   - Login with username/password
   - Default credentials: admin/admin123
   - Session-based access control

2. **Employee Management**
   - Add employee with validation
   - View all employees
   - Update employee information
   - Delete employee records
   - Search by employee ID
   - Search by department

3. **Reporting and Analytics**
   - Display total employee count
   - Calculate average salary
   - Department-wise employee distribution
   - Sort employees by ID, name, or salary

4. **Data Validation**
   - Unique employee ID validation
   - Positive salary validation
   - Non-empty field validation
   - Custom exception handling

### 2.3 Operating Environment

**Client Side:**
- OS: Windows, Linux, macOS
- JRE: 11 or higher
- Storage: 50 MB free space
- Memory: 256 MB RAM

**File System:**
- Read/write permissions required
- UTF-8 encoding support
- Persistent storage for data files

### 2.4 System Architecture

#### Class Diagram

```
┌─────────────────────────────────────┐
│   EmployeeManagementSystem          │
├─────────────────────────────────────┤
│ - employees: HashMap<String,Employee>│
│ - sc: Scanner                       │
│ - loggedInUser: String              │
├─────────────────────────────────────┤
│ + main(String[]): void              │
│ + login(): boolean                  │
│ + loadEmployees(): void             │
│ + saveEmployees(): void             │
│ + addEmployee(): void               │
│ + updateEmployee(): void            │
│ + deleteEmployee(): void            │
│ + searchEmployee(): void            │
│ + displayStatistics(): void         │
└──────────────┬──────────────────────┘
               │ uses
               ▼
┌─────────────────────────────────────┐
│           Employee                  │
├─────────────────────────────────────┤
│ - empId: String                     │
│ - name: String                      │
│ - salary: double                    │
│ - department: String                │
├─────────────────────────────────────┤
│ + Employee(...)                     │
│ + getters/setters                   │
│ + toString(): String                │
│ + toFileString(): String            │
└─────────────────────────────────────┘

┌─────────────────────────────────────┐
│   InvalidEmployeeException          │
├─────────────────────────────────────┤
│ + InvalidEmployeeException(String)  │
└─────────────────────────────────────┘
```

#### Database Design (File Structure)

**employees.txt Format:**
```
EMP001,John Doe,50000.0,IT
EMP002,Jane Smith,60000.0,HR
EMP003,Bob Johnson,55000.0,IT
```

**login.txt Format:**
```
admin,admin123
```

---

## 3. External Interface Requirements

### 3.1 User Interface

**Main Menu:**
```
--- Employee Management System ---
1. Add Employee
2. View All Employees
3. Update Employee
4. Delete Employee
5. Search Employee by ID
6. Search by Department
7. Display Statistics
8. Sort Employees
9. Logout
```

### 3.2 Software Interface

- **File I/O:** BufferedReader/BufferedWriter
- **Collections:** HashMap for fast lookups, ArrayList for sorting
- **Exception Handling:** Custom InvalidEmployeeException

### 3.3 Communication Interface

- **File System:** Direct file read/write operations
- **Encoding:** UTF-8
- **Data Format:** CSV (comma-separated)

---

## 4. Other Non-Functional Requirements

### 4.1 Performance Requirements

- File load time: < 1 second (for 10,000 records)
- Search by ID: O(1) complexity (HashMap)
- Sort operations: < 500ms (for 1000 records)
- File save: Immediate after each operation

### 4.2 Security Requirements

- Username/password authentication
- Session-based access control
- File-based credential storage
- Input validation for all fields

### 4.3 Software Quality Attributes

**Reliability:**
- File corruption prevention
- Graceful error handling
- Data consistency through immediate persistence

**Maintainability:**
- Modular design with separate Employee class
- Clear separation of concerns
- Custom exception handling

**Usability:**
- Menu-driven interface
- Clear error messages
- Immediate feedback on operations

### 4.4 Business Rules

**BR-01:** Employee ID must be unique across all records

**BR-02:** Salary must be positive (> 0)

**BR-03:** All fields mandatory (ID, name, salary, department)

**BR-04:** Changes persisted immediately to file

**BR-05:** Authentication required before operations

**BR-06:** File updated after every add/update/delete operation

---

**End of Document**
