# HCL Training Assignments and Projects

This repository contains all assignments and mini projects completed during HCL training program.

## Repository Structure

All work is organized in separate Git branches:

### Assignment 3 - Collections Framework
**Branch:** `assignment3`
- ArrayList Demo (constructors + 15 methods)
- Vector Demo (constructors + 15 methods)
- HashMap Demo (constructors + 15 methods)
- HashTable Demo (constructors + 15 methods)
- TreeMap Demo (constructors + 15 methods)

**Technology:** Java, Maven

### Assignment 4 - JDBC Programs
**Branch:** `assignment4`
- JDBC Connection to MySQL
- Create Students Table and Insert Records
- Update CSE Students Percentage by 5%
- Delete Civil Branch 2024 Students
- Display EC Branch Semester 7 Students

**Technology:** Java, Maven, MySQL, JDBC

### Mini Project 3 - Student Management System
**Branch:** `miniproject3`
- Login System (username/password)
- Add Students
- Display All Students
- Search Students by Eno
- Update Students Branch
- Delete Students by Eno
- Display Sorted Students
- Validation Rules (unique Eno, positive percentage, non-empty fields)
- Exception Handling with Custom Messages

**Technology:** Java, Maven, MySQL, JDBC

### Assignment 6 - Manual Test Case Reports
**Branch:** `assignment6`
- CRM System Test Cases
- Travel Booking Platform Test Cases
- E-commerce Website Test Cases
- Banking Website Test Cases
- Healthcare System Test Cases

**Format:** Markdown Documentation

### Assignment 5 - Agile Project Reports
**Branch:** `assignment5`
- CRM Project Report using Agile
- Travel Booking Platform Report using Agile
- E-commerce Website Report using Agile
- Banking Website Report using Agile
- Healthcare System Report using Agile

**Format:** Markdown Documentation

## How to Access Work

To view any assignment or project:

```bash
git checkout <branch-name>
```

Example:
```bash
git checkout assignment3
```

## Branch List

- `assignment3` - Collections Framework Programs
- `assignment4` - JDBC Programs
- `miniproject3` - Student Management System
- `assignment6` - Manual Test Case Reports
- `assignment5` - Agile Project Reports

## Running Java Projects

For Assignment 3, 4, and Mini Project 3:

```bash
cd <project-folder>
mvn clean install
mvn exec:java -Dexec.mainClass="com.hcl.training.<ClassName>"
```

## Database Setup (For Assignment 4 and Mini Project 3)

Create database in MySQL:
```sql
CREATE DATABASE hcl_db;
```

Update connection details in Java files:
- URL: jdbc:mysql://localhost:3306/hcl_db
- Username: root
- Password: root

## Project Details

**Prepared By:** Junior Developer  
**Date:** January 15, 2026  
**Organization:** HCL Training Program  

## Notes

- All code follows Java naming conventions
- Maven is used for all Java projects
- No comments in code as per requirements
- Separate branches for each assignment/project
- All validation and exception handling implemented in Mini Project 3
