# Software Requirements Specification
## for
## Student Management System

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
   - 1.1 Purpose
   - 1.2 Scope
   - 1.3 Definitions, Acronyms, and Abbreviations
   - 1.4 Technology Used
   - 1.5 Overview
   - 1.6 Document Conventions
   - 1.7 Intended Audience and Reading Suggestions
   - 1.8 References

2. [Overall Description](#2-overall-description)
   - 2.1 Product Perspective
   - 2.2 Product Functions
   - 2.3 User Classes and Characteristics
   - 2.4 Operating Environment
   - 2.5 Design and Implementation Constraints
   - 2.6 User Documentation
   - 2.7 Assumptions and Dependencies
   - 2.8 System Architecture

3. [External Interface Requirements](#3-external-interface-requirements)
   - 3.1 User Interface
   - 3.2 Hardware Interface
   - 3.3 Software Interface
   - 3.4 Communication Interface

4. [Other Non-Functional Requirements](#4-other-non-functional-requirements)
   - 4.1 Performance Requirements
   - 4.2 Safety Requirements
   - 4.3 Security Requirements
   - 4.4 Software Quality Attributes
   - 4.5 Business Rules

---

## 1. Introduction

### 1.1 Purpose

This Software Requirements Specification (SRS) document provides a comprehensive description of the Student Management System. It details the functional and non-functional requirements, system architecture, and design constraints for the application. The intended audience includes developers, project managers, testers, and stakeholders involved in the development and deployment of this system.

### 1.2 Scope

The Student Management System is a database-driven application designed to manage student records efficiently. The system allows administrators to:

- Add new student records with unique enrollment numbers
- Update existing student information
- Delete student records
- View all students or search specific records
- Authenticate users through a login mechanism
- Validate student data before insertion

The system minimizes manual effort in managing student data and ensures data integrity through validation and exception handling.

### 1.3 Definitions, Acronyms, and Abbreviations

| Term | Definition |
|------|------------|
| SRS | Software Requirements Specification |
| CRUD | Create, Read, Update, Delete |
| JDBC | Java Database Connectivity |
| DAO | Data Access Object |
| UI | User Interface |
| DB | Database |
| SQL | Structured Query Language |
| JDK | Java Development Kit |

### 1.4 Technology Used

**Programming Language:** Java 11  
**Database:** MySQL 8.0  
**Database Connectivity:** JDBC (MySQL Connector 8.0.33)  
**Build Tool:** Apache Maven  
**Development Model:** Console-based Application  
**Architecture Pattern:** DAO Pattern

### 1.5 Overview

This document describes the complete software requirements for the Student Management System. Section 2 provides an overall description of the system, including product perspective, functions, and user characteristics. Section 3 details the external interface requirements. Section 4 covers non-functional requirements including performance, security, and quality attributes.

### 1.6 Document Conventions

- **Bold text** indicates emphasis on important terms
- *Italic text* represents technical terminology
- Code snippets are shown in `monospace font`
- Database table names are in UPPERCASE (e.g., STUDENTS)
- Class names follow PascalCase convention
- Method names follow camelCase convention

### 1.7 Intended Audience and Reading Suggestions

**Developers:** Read all sections with focus on Section 2.8 (System Architecture) and Section 3 (External Interface Requirements)

**Project Managers:** Focus on Sections 1.2 (Scope), 2.2 (Product Functions), and 4.1 (Performance Requirements)

**Testers:** Pay attention to Section 2.2 (Product Functions) and Section 4 (Non-Functional Requirements)

**Database Administrators:** Review Section 2.8 (Database Design) and Section 3.3 (Software Interface)

### 1.8 References

- Java SE 11 Documentation: https://docs.oracle.com/en/java/javase/11/
- MySQL 8.0 Reference Manual: https://dev.mysql.com/doc/refman/8.0/
- JDBC API Documentation: https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/
- Maven Documentation: https://maven.apache.org/guides/

---

## 2. Overall Description

### 2.1 Product Perspective

The Student Management System is a standalone console application that interacts with a MySQL database backend. It operates independently without integration to external systems. The system uses a three-layer architecture:

1. **Presentation Layer:** Console-based user interface for interaction
2. **Business Logic Layer:** Student validation and business rules
3. **Data Access Layer:** JDBC-based database operations through DAO pattern

### 2.2 Product Functions

**Primary Functions:**

1. **User Authentication**
   - Login with username and password validation
   - Session management for authenticated users
   - Logout functionality

2. **Student Record Management**
   - Add new student with validation (unique Eno, positive percentage, non-empty fields)
   - Update student information (Name, Branch, Semester, Percentage)
   - Delete student records by enrollment number
   - Display all student records

3. **Data Validation**
   - Unique enrollment number validation
   - Percentage range validation (0-100)
   - Non-null field validation
   - Custom exception handling for invalid data

4. **Database Operations**
   - Connect to MySQL database
   - Execute CRUD operations using prepared statements
   - Handle SQL exceptions gracefully
   - Maintain data consistency

### 2.3 User Classes and Characteristics

**Administrator:**
- **Technical Expertise:** Moderate - familiar with basic computer operations
- **Frequency of Use:** Daily
- **Functions Used:** All system functions
- **Security Level:** Full access to all student records

**Database Administrator:**
- **Technical Expertise:** High - expertise in database management
- **Frequency of Use:** As needed for maintenance
- **Functions Used:** Database backup, restore, optimization
- **Security Level:** Full database access

### 2.4 Operating Environment

**Client Side:**
- Operating System: Windows 10/11, Linux, macOS
- Java Runtime Environment: JRE 11 or higher
- Memory: Minimum 512 MB RAM
- Storage: 100 MB free disk space
- Display: Console/Terminal with standard text output

**Server Side:**
- Database Server: MySQL 8.0 or higher
- Operating System: Windows Server, Linux, or macOS
- Memory: Minimum 1 GB RAM
- Storage: 500 MB for database files

**Network:**
- Local network or localhost connection
- TCP/IP protocol support
- MySQL default port: 3306

### 2.5 Design and Implementation Constraints

1. **Technology Constraints:**
   - Must use Java 11 for compatibility
   - MySQL 8.0 required for database operations
   - JDBC must be used for database connectivity

2. **Code Quality Constraints:**
   - No inline comments (as per training requirements)
   - Follow DAO pattern for data access
   - Use custom exceptions for validation
   - Implement proper resource management (try-with-resources)

3. **Database Constraints:**
   - Enrollment number must be unique (primary key)
   - Percentage must be between 0 and 100
   - All fields are mandatory (NOT NULL)

4. **Security Constraints:**
   - User authentication required before any operations
   - SQL injection prevention through prepared statements
   - Password storage in plain text (for training purposes only)

### 2.6 User Documentation

**Included Documentation:**
- README.md with setup instructions
- Database schema documentation
- User guide for system operations
- Error message reference guide

**Not Included:**
- Detailed technical architecture diagrams
- API documentation (console application)
- Performance tuning guides

### 2.7 Assumptions and Dependencies

**Assumptions:**
1. MySQL server is installed and running
2. Database and tables are created before application execution
3. User has valid login credentials
4. Network connectivity is stable
5. Java 11 or higher is installed on client machine

**Dependencies:**
1. MySQL Connector/J (mysql-connector-java 8.0.33)
2. JDBC API (included in JDK)
3. Maven for dependency management
4. MySQL database server availability

### 2.8 System Architecture

#### 2.8.1 Architectural Design

```
┌─────────────────────────────────────────┐
│     Presentation Layer (Console)        │
│  - StudentManagementSystem (Main)       │
│  - User Input/Output                    │
└──────────────┬──────────────────────────┘
               │
               ▼
┌─────────────────────────────────────────┐
│      Business Logic Layer               │
│  - Student (Model)                      │
│  - InvalidStudentException              │
│  - Validation Logic                     │
└──────────────┬──────────────────────────┘
               │
               ▼
┌─────────────────────────────────────────┐
│      Data Access Layer (DAO)            │
│  - StudentDAO                           │
│  - CRUD Operations                      │
│  - Database Connection Management       │
└──────────────┬──────────────────────────┘
               │
               ▼
┌─────────────────────────────────────────┐
│         Database Layer                  │
│  - MySQL Database                       │
│  - STUDENTS Table                       │
└─────────────────────────────────────────┘
```

#### 2.8.2 Use Case Model

**Use Case Diagram:**

```
                    Student Management System

    ┌──────────┐
    │Administrator│
    └─────┬────┘
          │
          │ ◄────── Login
          │
          ├────────► Add Student
          │
          ├────────► Update Student
          │
          ├────────► Delete Student
          │
          ├────────► View All Students
          │
          └────────► Logout
```

**Use Case Descriptions:**

**UC-01: Login**
- **Actor:** Administrator
- **Precondition:** Application is running
- **Main Flow:** User enters username and password, system validates credentials
- **Postcondition:** User is authenticated and main menu is displayed

**UC-02: Add Student**
- **Actor:** Administrator
- **Precondition:** User is logged in
- **Main Flow:** User enters student details, system validates and saves to database
- **Postcondition:** New student record is created

**UC-03: Update Student**
- **Actor:** Administrator
- **Precondition:** User is logged in, student exists
- **Main Flow:** User enters Eno and new details, system updates record
- **Postcondition:** Student record is updated

**UC-04: Delete Student**
- **Actor:** Administrator
- **Precondition:** User is logged in, student exists
- **Main Flow:** User enters Eno, system confirms and deletes record
- **Postcondition:** Student record is removed

**UC-05: View All Students**
- **Actor:** Administrator
- **Precondition:** User is logged in
- **Main Flow:** System retrieves and displays all student records
- **Postcondition:** Student list is displayed

#### 2.8.3 Class Diagram

```
┌────────────────────────────────────┐
│     StudentManagementSystem        │
├────────────────────────────────────┤
│ - dao: StudentDAO                  │
│ - sc: Scanner                      │
├────────────────────────────────────┤
│ + main(args: String[]): void       │
│ + login(): boolean                 │
│ + addStudent(): void               │
│ + updateStudent(): void            │
│ + deleteStudent(): void            │
│ + displayAllStudents(): void       │
└────────────────┬───────────────────┘
                 │ uses
                 ▼
┌────────────────────────────────────┐
│          StudentDAO                │
├────────────────────────────────────┤
│ - URL: String                      │
│ - USER: String                     │
│ - PASSWORD: String                 │
├────────────────────────────────────┤
│ + getConnection(): Connection      │
│ + addStudent(Student): void        │
│ + updateStudent(Student): void     │
│ + deleteStudent(String): void      │
│ + getAllStudents(): List<Student>  │
│ + isEnoExists(String): boolean     │
└────────────────┬───────────────────┘
                 │ uses
                 ▼
┌────────────────────────────────────┐
│            Student                 │
├────────────────────────────────────┤
│ - eno: String                      │
│ - name: String                     │
│ - branch: String                   │
│ - sem: int                         │
│ - percentage: double               │
├────────────────────────────────────┤
│ + Student(...)                     │
│ + getters/setters                  │
│ + toString(): String               │
└────────────────────────────────────┘

┌────────────────────────────────────┐
│   InvalidStudentException          │
├────────────────────────────────────┤
│ + InvalidStudentException(String)  │
└────────────────────────────────────┘
```

#### 2.8.4 Sequence Diagram - Add Student

```
Admin    System    DAO         Database
  │         │        │            │
  ├────────►│        │            │  Select "Add Student"
  │         │        │            │
  │◄────────┤        │            │  Prompt for details
  │         │        │            │
  ├────────►│        │            │  Enter student data
  │         │        │            │
  │         ├───────►│            │  Validate data
  │         │        │            │
  │         │        ├───────────►│  Check Eno exists
  │         │        │            │
  │         │        │◄───────────┤  Return result
  │         │        │            │
  │         │        ├───────────►│  INSERT query
  │         │        │            │
  │         │        │◄───────────┤  Success
  │         │        │            │
  │         │◄───────┤            │  Return success
  │         │        │            │
  │◄────────┤        │            │  Display success message
  │         │        │            │
```

#### 2.8.5 Database Design

**ER Diagram:**

```
┌─────────────────────────────────────┐
│            STUDENTS                 │
├─────────────────────────────────────┤
│ PK  Eno: VARCHAR(20)                │
│     Name: VARCHAR(100)              │
│     Branch: VARCHAR(50)             │
│     Sem: INT                        │
│     Percentage: DOUBLE              │
└─────────────────────────────────────┘
```

**Database Schema:**

```sql
CREATE DATABASE StudentDB;
USE StudentDB;

CREATE TABLE STUDENTS (
    Eno VARCHAR(20) PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Branch VARCHAR(50) NOT NULL,
    Sem INT NOT NULL,
    Percentage DOUBLE NOT NULL,
    CONSTRAINT chk_percentage CHECK (Percentage >= 0 AND Percentage <= 100)
);
```

**Table: STUDENTS**

| Column | Data Type | Constraints | Description |
|--------|-----------|-------------|-------------|
| Eno | VARCHAR(20) | PRIMARY KEY, NOT NULL | Unique enrollment number |
| Name | VARCHAR(100) | NOT NULL | Student full name |
| Branch | VARCHAR(50) | NOT NULL | Department/Branch (CSE, ECE, etc.) |
| Sem | INT | NOT NULL | Current semester number |
| Percentage | DOUBLE | NOT NULL, CHECK (0-100) | Academic percentage |

**Sample Data:**

```sql
INSERT INTO STUDENTS VALUES ('E001', 'John Doe', 'CSE', 6, 85.5);
INSERT INTO STUDENTS VALUES ('E002', 'Jane Smith', 'ECE', 4, 92.3);
INSERT INTO STUDENTS VALUES ('E003', 'Bob Johnson', 'MECH', 2, 78.9);
```

---

## 3. External Interface Requirements

### 3.1 User Interface

**Console-Based Interface:**

The system provides a text-based menu-driven interface with the following screens:

**Login Screen:**
```
--- Student Management System ---
--- Login ---
Enter username: 
Enter password: 
```

**Main Menu:**
```
--- Main Menu ---
1. Add Student
2. Update Student
3. Delete Student
4. Display All Students
5. Logout
Enter your choice: 
```

**Add Student Screen:**
```
--- Add Student ---
Enter Eno: 
Enter Name: 
Enter Branch: 
Enter Semester: 
Enter Percentage: 
```

**Display All Students:**
```
--- All Students ---
Eno: E001, Name: John Doe, Branch: CSE, Sem: 6, Percentage: 85.5
Eno: E002, Name: Jane Smith, Branch: ECE, Sem: 4, Percentage: 92.3
```

**UI Design Principles:**
- Clear and concise prompts
- Immediate feedback on operations
- Error messages displayed in user-friendly format
- Confirmation messages for destructive operations (delete)
- Menu-driven navigation for ease of use

### 3.2 Hardware Interface

**Client Side:**
- **Input Devices:** Keyboard for data entry
- **Output Devices:** Monitor/Console for display
- **Minimum Resolution:** Console supports standard 80x24 character display
- **Processing:** Any processor supporting Java 11

**Server Side:**
- **Storage:** Hard disk for MySQL database storage
- **Network Interface:** Ethernet/WiFi for database connectivity
- **Memory:** RAM for database caching and query processing

**No Special Hardware Requirements:**
- No barcode scanners required
- No biometric devices needed
- No specialized input/output devices

### 3.3 Software Interface

**Front End (Client):**
- **Component:** Java Console Application
- **Technology:** Java SE 11
- **Purpose:** User interaction and input validation
- **Communication:** JDBC driver for database connection

**Database Server:**
- **Component:** MySQL Database Server
- **Version:** 8.0 or higher
- **Purpose:** Persistent data storage
- **Port:** 3306 (default MySQL port)
- **Protocol:** TCP/IP

**JDBC Driver:**
- **Component:** MySQL Connector/J
- **Version:** 8.0.33
- **Purpose:** Bridge between Java application and MySQL
- **API:** JDBC 4.2
- **Connection String:** jdbc:mysql://localhost:3306/StudentDB

**Build Tool:**
- **Component:** Apache Maven
- **Version:** 3.6 or higher
- **Purpose:** Dependency management and project building
- **Configuration File:** pom.xml

**Software Dependencies:**

| Software | Version | Purpose |
|----------|---------|---------|
| JDK | 11+ | Java runtime and compilation |
| MySQL | 8.0+ | Database server |
| MySQL Connector/J | 8.0.33 | JDBC driver |
| Maven | 3.6+ | Build automation |

### 3.4 Communication Interface

**Database Communication:**
- **Protocol:** TCP/IP
- **Port:** 3306
- **Connection Type:** Client-Server
- **Authentication:** Username/Password (MySQL credentials)
- **Connection Pooling:** Not implemented (single connection per operation)

**Network Requirements:**
- **Bandwidth:** Minimal (local database operations)
- **Latency:** <100ms for localhost connections
- **Reliability:** Stable network connection required

**Data Format:**
- **Encoding:** UTF-8 for string data
- **Query Language:** SQL (Structured Query Language)
- **Result Format:** JDBC ResultSet

**Communication Flow:**
```
Application → JDBC Driver → MySQL Server
            ← ResultSet ←
```

**Error Handling:**
- Network timeout exceptions handled
- Connection failure retry mechanism
- SQL exception handling with user-friendly messages

---

## 4. Other Non-Functional Requirements

### 4.1 Performance Requirements

**Response Time:**
- Login operation: < 2 seconds
- Add student: < 1 second
- Update student: < 1 second
- Delete student: < 1 second
- Display all students: < 3 seconds (for up to 1000 records)
- Database query execution: < 500ms

**Throughput:**
- Support 10 concurrent database connections
- Handle up to 100 student records per minute
- Database can store up to 100,000 student records

**Resource Utilization:**
- Memory usage: < 256 MB during normal operation
- CPU usage: < 50% during peak operations
- Database connection pooling: Maximum 10 connections

**Scalability:**
- Support for 50,000+ student records without performance degradation
- Linear performance scaling with database indexing
- Ability to add additional database indexes as needed

### 4.2 Safety Requirements

**Data Backup:**
- Regular database backups recommended (daily)
- Transaction logging enabled in MySQL
- Rollback capability for failed transactions

**Failure Recovery:**
- Graceful handling of database connection failures
- Automatic connection retry mechanism
- Data consistency maintained through transactions

**Data Integrity:**
- ACID properties maintained for all database operations
- Referential integrity through primary key constraints
- Constraint validation before data insertion

**Error Prevention:**
- Input validation before database operations
- SQL injection prevention through prepared statements
- Exception handling for all critical operations

### 4.3 Security Requirements

**Authentication:**
- Username and password required for system access
- Login credentials validated against stored values
- Session-based access control

**Authorization:**
- Only authenticated users can perform CRUD operations
- All operations require valid login session
- Logout functionality to terminate session

**Data Protection:**
- Database credentials stored in application code (training environment)
- MySQL user authentication required for database access
- Prepared statements prevent SQL injection attacks

**Security Limitations (Training Environment):**
- Passwords stored in plain text
- No encryption for data in transit
- No role-based access control
- Single administrator account

**Production Security Recommendations:**
- Implement password hashing (BCrypt, SHA-256)
- Use SSL/TLS for database connections
- Implement role-based access control (RBAC)
- Store credentials in environment variables or configuration files
- Implement audit logging for all operations

### 4.4 Software Quality Attributes

**Reliability:**
- **Availability:** 99% uptime (dependent on database server)
- **Fault Tolerance:** Graceful error handling with user-friendly messages
- **Recoverability:** Database transaction rollback on failures
- **MTBF:** Mean Time Between Failures > 720 hours

**Maintainability:**
- **Code Organization:** Clear separation of concerns (DAO pattern)
- **Code Quality:** No inline comments (as per requirements)
- **Modularity:** Separate classes for Model, DAO, Exception
- **Readability:** Self-documenting code with meaningful names

**Usability:**
- **Ease of Use:** Menu-driven interface with clear prompts
- **Error Messages:** Descriptive and actionable error messages
- **Learning Curve:** Minimal training required (< 30 minutes)
- **User Feedback:** Immediate confirmation of operations

**Portability:**
- **Platform Independence:** Runs on Windows, Linux, macOS
- **Database Portability:** Can migrate to other JDBC-compliant databases
- **Version Compatibility:** Compatible with Java 11+

**Testability:**
- **Unit Testing:** DAO methods can be tested independently
- **Integration Testing:** Database operations testable with test database
- **Exception Testing:** Custom exceptions testable in isolation

**Efficiency:**
- **Memory Efficiency:** Minimal object creation, proper resource cleanup
- **Time Efficiency:** Optimized SQL queries with proper indexing
- **Network Efficiency:** Minimal data transfer through prepared statements

**Extensibility:**
- **Future Enhancements:** Easy to add new fields to Student model
- **Feature Addition:** Can extend with search, filter, export functionality
- **Database Migration:** Can switch to different database with minimal changes

### 4.5 Business Rules

**BR-01: Unique Enrollment Number**
- Each student must have a unique enrollment number (Eno)
- System must validate Eno uniqueness before insertion
- Duplicate Eno should raise InvalidStudentException

**BR-02: Percentage Validation**
- Percentage must be between 0 and 100 (inclusive)
- Negative percentages are not allowed
- Percentage > 100 should raise InvalidStudentException

**BR-03: Mandatory Fields**
- All student fields are mandatory (Eno, Name, Branch, Sem, Percentage)
- Empty or null values should raise InvalidStudentException
- Whitespace-only values considered invalid

**BR-04: Authentication Required**
- Users must login before accessing any functionality
- Invalid credentials should deny access
- Only one user role: Administrator

**BR-05: Data Validation Sequence**
- Validate all fields before database operations
- Check Eno uniqueness before insertion
- Ensure data consistency through transactions

**BR-06: Update Restrictions**
- Enrollment number (Eno) cannot be modified after creation
- Only Name, Branch, Sem, and Percentage can be updated
- Student must exist before update operation

**BR-07: Deletion Rules**
- Student record must exist before deletion
- No soft delete; records are permanently removed
- Confirmation recommended before deletion (not currently implemented)

**BR-08: Display Rules**
- All students displayed in insertion order
- Empty database should display appropriate message
- No pagination implemented (all records displayed)

---

## Appendix A: Glossary

**CRUD:** Create, Read, Update, Delete - basic database operations

**DAO Pattern:** Data Access Object pattern for separating business logic from database access

**JDBC:** Java Database Connectivity - API for database access in Java

**PreparedStatement:** SQL statement precompiled for efficiency and security

**SQLException:** Exception thrown when database operations fail

**Session:** Period of authenticated user interaction with system

---

## Appendix B: Analysis Models

**Entity-Relationship Model:**
- Single entity: STUDENT
- No relationships (standalone table)
- Primary key: Eno

**Data Flow Diagram (Level 0):**
```
Administrator → [Login] → System → [Authenticate] → Database
Administrator → [CRUD Operations] → System → [Process] → Database
```

**State Transition Diagram (User Session):**
```
[Logged Out] → (Login) → [Logged In] → (Logout) → [Logged Out]
             ← (Invalid)
```

---

## Appendix C: To Be Determined (TBD)

- Export student data to CSV/Excel
- Import student data from external files
- Advanced search and filter capabilities
- Report generation functionality
- Email notifications for operations
- Role-based access control
- Multi-user concurrent access handling
- Audit trail logging

---

**End of Document**
