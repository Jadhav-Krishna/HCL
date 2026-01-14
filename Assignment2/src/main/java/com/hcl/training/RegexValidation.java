package com.hcl.training;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexValidation {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void validateMobile() {
        System.out.print("Enter mobile number: ");
        String mobile = sc.nextLine();
        
        String regex = "^[6-9]\\d{9}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(mobile);
        
        if(m.matches()) {
            System.out.println("Valid mobile number");
        } else {
            System.out.println("Invalid mobile number. Should be 10 digits and start with 6-9");
        }
    }
    
    public static void validateEmail() {
        System.out.print("Enter email address: ");
        String email = sc.nextLine();
        
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        
        if(m.matches()) {
            System.out.println("Valid email address");
        } else {
            System.out.println("Invalid email address");
        }
    }
    
    public static void validateUsername() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,19}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(username);
        
        if(m.matches()) {
            System.out.println("Valid username");
        } else {
            System.out.println("Invalid username. Should be 5-20 characters, start with letter");
        }
    }
    
    public static void validatePassword() {
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        
        if(m.matches()) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password. Must have 8+ characters with uppercase, lowercase, digit and special character");
        }
    }
    
    public static void main(String[] args) {
        while(true) {
            System.out.println("\n--- REGEX Validation Menu ---");
            System.out.println("1. Validate Mobile Number");
            System.out.println("2. Validate Email Address");
            System.out.println("3. Validate Username");
            System.out.println("4. Validate Password");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 5) {
                System.out.println("Exiting...");
                break;
            }
            
            switch(choice) {
                case 1:
                    validateMobile();
                    break;
                case 2:
                    validateEmail();
                    break;
                case 3:
                    validateUsername();
                    break;
                case 4:
                    validatePassword();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
