# Software Requirements Specification
## for
## Bank Management System

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

This SRS document describes the Bank Management System, a file-based banking application demonstrating object-oriented programming concepts including hierarchical inheritance, polymorphism, encapsulation, and abstraction.

### 1.2 Scope

The Bank Management System provides:
- Multiple account types (Savings, Current, Fixed Deposit)
- File-based persistent storage
- Account operations (deposit, withdrawal, balance inquiry)
- Hierarchical inheritance structure
- Method overloading and overriding
- Runtime polymorphism
- Abstract class implementation

### 1.3 Technology Used

**Programming Language:** Java 11  
**Storage:** File-based (accounts.txt)  
**Build Tool:** Apache Maven  
**OOP Concepts:** Inheritance, Polymorphism, Abstraction, Encapsulation

### 1.4 Document Conventions

- **Account Number:** Unique identifier
- **Balance:** Cannot be negative (except Current with overdraft)
- **Interest Rate:** Fixed for savings accounts
- **Overdraft Limit:** Only for current accounts
- **Lock Period:** Only for fixed deposit accounts

---

## 2. Overall Description

### 2.1 Product Perspective

Console-based banking application using hierarchical inheritance to model different account types with file persistence for data storage.

### 2.2 Product Functions

1. **Account Management**
   - Create Savings Account
   - Create Current Account  
   - Create Fixed Deposit Account
   - View account details

2. **Banking Operations**
   - Deposit money
   - Withdraw money
   - Check balance
   - Calculate interest (Savings)
   - Overdraft facility (Current)
   - Maturity calculation (Fixed Deposit)

3. **File Operations**
   - Load accounts from file
   - Save accounts to file
   - Persistent data storage

4. **OOP Features**
   - Abstract Account class
   - Hierarchical inheritance
   - Method overloading (deposit methods)
   - Method overriding (withdraw, display)
   - Runtime polymorphism

### 2.3 System Architecture

#### Class Hierarchy

```
                    ┌──────────────────┐
                    │  Account (Abstract) │
                    ├──────────────────┤
                    │ # accountNumber  │
                    │ # holderName     │
                    │ # balance        │
                    ├──────────────────┤
                    │ + deposit()      │
                    │ + withdraw()     │
                    │ + displayDetails()│
                    └────────┬─────────┘
                             │
              ┌──────────────┴──────────────┬────────────────┐
              │                             │                │
    ┌─────────▼──────────┐    ┌────────────▼─────┐  ┌──────▼─────────┐
    │ SavingsAccount     │    │ CurrentAccount   │  │ FixedDeposit   │
    ├────────────────────┤    ├──────────────────┤  ├────────────────┤
    │ - interestRate     │    │ - overdraftLimit │  │ - lockPeriod   │
    │ - minimumBalance   │    │                  │  │ - maturityDate │
    ├────────────────────┤    ├──────────────────┤  ├────────────────┤
    │ + calculateInterest()│  │ + withdraw()     │  │ + calculateMaturity()│
    │ + displayDetails() │    │ + displayDetails()│  │ + displayDetails()│
    └────────────────────┘    └──────────────────┘  └────────────────┘
```

#### Use Case Diagram

```
           Bank Management System

┌──────────┐
│  User    │
└────┬─────┘
     │
     ├────────► Create Savings Account
     │
     ├────────► Create Current Account
     │
     ├────────► Create Fixed Deposit
     │
     ├────────► Deposit Money
     │
     ├────────► Withdraw Money
     │
     ├────────► Check Balance
     │
     ├────────► View Account Details
     │
     └────────► Calculate Interest/Maturity
```

### 2.4 File Structure

**accounts.txt Format:**
```
SAVINGS,ACC001,John Doe,10000.0,4.5,5000.0
CURRENT,ACC002,Jane Smith,25000.0,10000.0
FIXED,ACC003,Bob Johnson,50000.0,12,2027-01-15
```

---

## 3. External Interface Requirements

### 3.1 User Interface

**Main Menu:**
```
--- Bank Management System ---
1. Create Savings Account
2. Create Current Account
3. Create Fixed Deposit Account
4. Deposit Money
5. Withdraw Money
6. Check Balance
7. View All Accounts
8. Calculate Interest (Savings)
9. Check Maturity (Fixed Deposit)
10. Exit
```

**Account Details Display:**
```
--- Account Details ---
Account Number: ACC001
Holder Name: John Doe
Account Type: Savings Account
Balance: 10000.0
Interest Rate: 4.5%
Minimum Balance: 5000.0
```

### 3.2 Software Interface

- **File I/O:** FileReader/FileWriter
- **Data Structure:** ArrayList for account storage
- **Inheritance:** Abstract base class with concrete implementations
- **Polymorphism:** Account reference to different account types

---

## 4. Other Non-Functional Requirements

### 4.1 Performance Requirements

- Account creation: < 500ms
- Deposit/Withdrawal: < 200ms
- File load time: < 1 second
- Balance inquiry: Immediate (O(1))

### 4.2 Security Requirements

- Account number validation
- Balance validation before withdrawal
- Minimum balance enforcement (Savings)
- Overdraft limit enforcement (Current)
- Lock period validation (Fixed Deposit)

### 4.3 Software Quality Attributes

**Reliability:**
- File-based persistence
- Transaction validation
- Error handling for invalid operations

**Maintainability:**
- Clear inheritance hierarchy
- Separation of concerns
- Reusable abstract methods

**Extensibility:**
- Easy to add new account types
- Abstract class provides common functionality
- Polymorphic operations support new types

### 4.4 Business Rules

**BR-01:** Savings accounts must maintain minimum balance

**BR-02:** Current accounts allow overdraft up to limit

**BR-03:** Fixed deposits locked for specified period

**BR-04:** Interest calculated only for Savings accounts

**BR-05:** Withdrawal validation based on account type

**BR-06:** Account number must be unique

**BR-07:** All balances persisted to file immediately

---

## 5. OOP Implementation Details

### 5.1 Encapsulation

- Private/Protected fields
- Public getter/setter methods
- Data hiding through access modifiers

### 5.2 Inheritance

**Hierarchical Structure:**
- Account (Abstract base class)
  - SavingsAccount (extends Account)
  - CurrentAccount (extends Account)  
  - FixedDepositAccount (extends Account)

### 5.3 Polymorphism

**Method Overloading:**
- deposit(double amount)
- deposit(double amount, String description)

**Method Overriding:**
- withdraw() - different logic for each account type
- displayDetails() - customized for each account type

**Runtime Polymorphism:**
```java
Account acc = new SavingsAccount(...);
acc.withdraw(1000); // Calls SavingsAccount's withdraw
```

### 5.4 Abstraction

**Abstract Class Account:**
- Abstract methods: withdraw(), displayDetails()
- Concrete methods: deposit(), getBalance()
- Forces subclasses to implement specific behavior

---

**End of Document**
