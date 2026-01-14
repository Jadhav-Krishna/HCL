package com.hcl.training;

interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

interface Transaction {
    void displayTransactions();
    void addTransaction(String transaction);
}

interface CustomerInfo {
    void displayCustomerInfo();
    void updateCustomerInfo(String name, String address);
}

class SavingsAccount implements Account, Transaction, CustomerInfo {
    private String accountNumber;
    private String customerName;
    private String address;
    private double balance;
    private String[] transactions;
    private int transactionCount;
    
    public SavingsAccount(String accountNumber, String customerName, String address, double initialBalance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.address = address;
        this.balance = initialBalance;
        this.transactions = new String[100];
        this.transactionCount = 0;
        addTransaction("Account created with balance: " + initialBalance);
    }
    
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            addTransaction("Deposited: " + amount);
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrawn: " + amount);
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else if(amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
    
    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
    
    public void displayTransactions() {
        System.out.println("\n--- Transaction History ---");
        for(int i = 0; i < transactionCount; i++) {
            System.out.println((i+1) + ". " + transactions[i]);
        }
    }
    
    public void addTransaction(String transaction) {
        if(transactionCount < transactions.length) {
            transactions[transactionCount++] = transaction;
        }
    }
    
    public void displayCustomerInfo() {
        System.out.println("\n--- Customer Information ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + customerName);
        System.out.println("Address: " + address);
        System.out.println("Balance: " + balance);
    }
    
    public void updateCustomerInfo(String name, String address) {
        this.customerName = name;
        this.address = address;
        addTransaction("Customer info updated");
        System.out.println("Customer information updated successfully");
    }
}

class CurrentAccount implements Account, Transaction, CustomerInfo {
    private String accountNumber;
    private String customerName;
    private String address;
    private double balance;
    private String[] transactions;
    private int transactionCount;
    private double overdraftLimit;
    
    public CurrentAccount(String accountNumber, String customerName, String address, double initialBalance, double overdraftLimit) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.address = address;
        this.balance = initialBalance;
        this.overdraftLimit = overdraftLimit;
        this.transactions = new String[100];
        this.transactionCount = 0;
        addTransaction("Account created with balance: " + initialBalance + ", Overdraft: " + overdraftLimit);
    }
    
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            addTransaction("Deposited: " + amount);
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void withdraw(double amount) {
        if(amount > 0 && amount <= (balance + overdraftLimit)) {
            balance -= amount;
            addTransaction("Withdrawn: " + amount);
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else if(amount > (balance + overdraftLimit)) {
            System.out.println("Exceeds overdraft limit");
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
    
    public void checkBalance() {
        System.out.println("Current balance: " + balance);
        System.out.println("Available overdraft: " + overdraftLimit);
    }
    
    public void displayTransactions() {
        System.out.println("\n--- Transaction History ---");
        for(int i = 0; i < transactionCount; i++) {
            System.out.println((i+1) + ". " + transactions[i]);
        }
    }
    
    public void addTransaction(String transaction) {
        if(transactionCount < transactions.length) {
            transactions[transactionCount++] = transaction;
        }
    }
    
    public void displayCustomerInfo() {
        System.out.println("\n--- Customer Information ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + customerName);
        System.out.println("Address: " + address);
        System.out.println("Balance: " + balance);
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
    
    public void updateCustomerInfo(String name, String address) {
        this.customerName = name;
        this.address = address;
        addTransaction("Customer info updated");
        System.out.println("Customer information updated successfully");
    }
}

public class BankWithInterfaces {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        
        System.out.println("--- Bank Account System ---");
        System.out.print("Select account type (1-Savings, 2-Current): ");
        int type = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        
        Account account = null;
        Transaction trans = null;
        CustomerInfo custInfo = null;
        
        if(type == 1) {
            SavingsAccount sa = new SavingsAccount(accNo, name, address, balance);
            account = sa;
            trans = sa;
            custInfo = sa;
        } else {
            System.out.print("Enter overdraft limit: ");
            double overdraft = sc.nextDouble();
            CurrentAccount ca = new CurrentAccount(accNo, name, address, balance, overdraft);
            account = ca;
            trans = ca;
            custInfo = ca;
        }
        
        while(true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Transactions");
            System.out.println("5. Display Customer Info");
            System.out.println("6. Update Customer Info");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            
            if(choice == 7) {
                System.out.println("Thank you for banking with us");
                break;
            }
            
            switch(choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmt = sc.nextDouble();
                    account.deposit(depositAmt);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmt = sc.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    trans.displayTransactions();
                    break;
                case 5:
                    custInfo.displayCustomerInfo();
                    break;
                case 6:
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new address: ");
                    String newAddress = sc.nextLine();
                    custInfo.updateCustomerInfo(newName, newAddress);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        
        sc.close();
    }
}
