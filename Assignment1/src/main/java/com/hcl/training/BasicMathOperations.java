package com.hcl.training;

import java.util.Scanner;

public class BasicMathOperations {
    
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int subtract(int a, int b) {
        return a - b;
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
    
    public static double divide(int a, int b) {
        return (double) a / b;
    }
    
    public static int remainder(int a, int b) {
        return a % b;
    }
    
    public static int square(int a) {
        return a * a;
    }
    
    public static int cube(int a) {
        return a * a * a;
    }
    
    public static int absolute(int a) {
        return Math.abs(a);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        
        System.out.println("\nResults:");
        System.out.println("Addition: " + add(num1, num2));
        System.out.println("Subtraction: " + subtract(num1, num2));
        System.out.println("Multiplication: " + multiply(num1, num2));
        System.out.println("Division: " + divide(num1, num2));
        System.out.println("Remainder: " + remainder(num1, num2));
        System.out.println("Square of " + num1 + ": " + square(num1));
        System.out.println("Cube of " + num1 + ": " + cube(num1));
        System.out.println("Absolute of " + num1 + ": " + absolute(num1));
        
        sc.close();
    }
}
