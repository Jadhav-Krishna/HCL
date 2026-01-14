package com.hcl.training;

import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) throws InvalidAmountException {
        if(amount <= 0) {
            throw new InvalidAmountException("Deposit amount should be positive");
        }
        balance = balance + amount;
        System.out.println("Amount Deposited: " + amount);
        System.out.println("Updated Balance: " + balance);
    }
    
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if(amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount should be positive");
        }
        if(amount > balance) {
            throw new InsufficientFundsException("Insufficient balance. Available balance: " + balance);
        }
        balance = balance - amount;
        System.out.println("Amount Withdrawn: " + amount);
        System.out.println("Updated Balance: " + balance);
    }
    
    public void checkBalance() {
        System.out.println("Your Current Balance: " + balance);
    }
    
    public void displayAccountDetails() {
        System.out.println("");
        System.out.println("--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolder);
        System.out.println("Current Balance: " + balance);
    }
}

public class BankManagement {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();
        
        BankAccount account = new BankAccount(accNo, name, initialBalance);
        
        while(true) {
            System.out.println("\n--- Bank Management Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            
            if(choice == 5) {
                System.out.println("Thank you for banking with us");
                break;
            }
            
            try {
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
                        account.displayAccountDetails();
                        break;
                        
                    default:
                        System.out.println("Invalid choice");
                }
            } catch(InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            } catch(InvalidAmountException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        sc.close();
    }
}
