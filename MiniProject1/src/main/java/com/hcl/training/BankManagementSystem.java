package com.hcl.training;

import java.io.*;
import java.util.*;

abstract class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void displayAccountInfo();
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }
    
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("New Balance: " + balance);
        } else if(amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
    
    public void withdraw(double amount, String purpose) {
        System.out.println("Withdrawal for: " + purpose);
        withdraw(amount);
    }
    
    public void displayAccountInfo() {
        System.out.println("\n--- Savings Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
    
    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added: " + interest);
        System.out.println("New Balance: " + balance);
    }
    
    public String toFileString() {
        return "SAVINGS," + accountNumber + "," + accountHolder + "," + balance + "," + interestRate;
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;
    
    public CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void deposit(double amount, String source) {
        System.out.println("Deposit from: " + source);
        deposit(amount);
    }
    
    public void withdraw(double amount) {
        if(amount > 0 && amount <= (balance + overdraftLimit)) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("New Balance: " + balance);
        } else if(amount > (balance + overdraftLimit)) {
            System.out.println("Exceeds overdraft limit");
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
    
    public void displayAccountInfo() {
        System.out.println("\n--- Current Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
    
    public String toFileString() {
        return "CURRENT," + accountNumber + "," + accountHolder + "," + balance + "," + overdraftLimit;
    }
}

class FixedDepositAccount extends SavingsAccount {
    private int tenure;
    
    public FixedDepositAccount(String accountNumber, String accountHolder, double balance, double interestRate, int tenure) {
        super(accountNumber, accountHolder, balance, interestRate);
        this.tenure = tenure;
    }
    
    public void withdraw(double amount) {
        System.out.println("Premature withdrawal not allowed for Fixed Deposit");
    }
    
    public void displayAccountInfo() {
        System.out.println("\n--- Fixed Deposit Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + super.interestRate + "%");
        System.out.println("Tenure: " + tenure + " months");
    }
    
    public void maturityAmount() {
        double maturity = balance * Math.pow((1 + super.interestRate / 100), tenure / 12.0);
        System.out.println("Maturity Amount: " + maturity);
    }
    
    public String toFileString() {
        return "FIXED," + accountNumber + "," + accountHolder + "," + balance + "," + super.interestRate + "," + tenure;
    }
}

public class BankManagementSystem {
    
    static Scanner sc = new Scanner(System.in);
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static final String FILE_NAME = "accounts.txt";
    
    public static void loadAccounts() {
        try {
            File file = new File(FILE_NAME);
            if(!file.exists()) {
                return;
            }
            
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                
                if(type.equals("SAVINGS")) {
                    accounts.add(new SavingsAccount(parts[1], parts[2], 
                        Double.parseDouble(parts[3]), Double.parseDouble(parts[4])));
                } else if(type.equals("CURRENT")) {
                    accounts.add(new CurrentAccount(parts[1], parts[2], 
                        Double.parseDouble(parts[3]), Double.parseDouble(parts[4])));
                } else if(type.equals("FIXED")) {
                    accounts.add(new FixedDepositAccount(parts[1], parts[2], 
                        Double.parseDouble(parts[3]), Double.parseDouble(parts[4]), Integer.parseInt(parts[5])));
                }
            }
            
            reader.close();
            System.out.println("Accounts loaded successfully");
        } catch(IOException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
    
    public static void saveAccounts() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            
            for(BankAccount account : accounts) {
                if(account instanceof FixedDepositAccount) {
                    writer.write(((FixedDepositAccount)account).toFileString());
                } else if(account instanceof SavingsAccount) {
                    writer.write(((SavingsAccount)account).toFileString());
                } else if(account instanceof CurrentAccount) {
                    writer.write(((CurrentAccount)account).toFileString());
                }
                writer.newLine();
            }
            
            writer.close();
            System.out.println("Accounts saved successfully");
        } catch(IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }
    
    public static void createAccount() {
        System.out.println("\n--- Create New Account ---");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.println("3. Fixed Deposit Account");
        System.out.print("Enter account type: ");
        int type = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        
        for(BankAccount acc : accounts) {
            if(acc.getAccountNumber().equals(accNo)) {
                System.out.println("Account number already exists");
                return;
            }
        }
        
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        
        if(type == 1) {
            System.out.print("Enter interest rate: ");
            double rate = sc.nextDouble();
            accounts.add(new SavingsAccount(accNo, name, balance, rate));
        } else if(type == 2) {
            System.out.print("Enter overdraft limit: ");
            double overdraft = sc.nextDouble();
            accounts.add(new CurrentAccount(accNo, name, balance, overdraft));
        } else if(type == 3) {
            System.out.print("Enter interest rate: ");
            double rate = sc.nextDouble();
            System.out.print("Enter tenure (months): ");
            int tenure = sc.nextInt();
            accounts.add(new FixedDepositAccount(accNo, name, balance, rate, tenure));
        } else {
            System.out.println("Invalid account type");
            return;
        }
        
        System.out.println("Account created successfully");
        saveAccounts();
    }
    
    public static BankAccount findAccount(String accountNumber) {
        for(BankAccount account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    
    public static void depositMoney() {
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        
        BankAccount account = findAccount(accNo);
        if(account == null) {
            System.out.println("Account not found");
            return;
        }
        
        System.out.print("Enter deposit amount: ");
        double amount = sc.nextDouble();
        
        account.deposit(amount);
        saveAccounts();
    }
    
    public static void withdrawMoney() {
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        
        BankAccount account = findAccount(accNo);
        if(account == null) {
            System.out.println("Account not found");
            return;
        }
        
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();
        
        account.withdraw(amount);
        saveAccounts();
    }
    
    public static void checkBalance() {
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        
        BankAccount account = findAccount(accNo);
        if(account == null) {
            System.out.println("Account not found");
            return;
        }
        
        System.out.println("Current Balance: " + account.getBalance());
    }
    
    public static void displayAccountInfo() {
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        
        BankAccount account = findAccount(accNo);
        if(account == null) {
            System.out.println("Account not found");
            return;
        }
        
        account.displayAccountInfo();
    }
    
    public static void displayAllAccounts() {
        if(accounts.isEmpty()) {
            System.out.println("No accounts found");
            return;
        }
        
        System.out.println("\n--- All Accounts ---");
        for(BankAccount account : accounts) {
            account.displayAccountInfo();
        }
    }
    
    public static void deleteAccount() {
        System.out.print("Enter account number to delete: ");
        String accNo = sc.nextLine();
        
        BankAccount account = findAccount(accNo);
        if(account == null) {
            System.out.println("Account not found");
            return;
        }
        
        accounts.remove(account);
        System.out.println("Account deleted successfully");
        saveAccounts();
    }
    
    public static void main(String[] args) {
        loadAccounts();
        
        while(true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Info");
            System.out.println("6. Display All Accounts");
            System.out.println("7. Delete Account");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 8) {
                System.out.println("Thank you for using Bank Management System");
                break;
            }
            
            switch(choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAccountInfo();
                    break;
                case 6:
                    displayAllAccounts();
                    break;
                case 7:
                    deleteAccount();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        
        sc.close();
    }
}
