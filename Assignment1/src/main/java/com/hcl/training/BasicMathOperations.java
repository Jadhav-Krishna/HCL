package com.hcl.training;

import java.util.Scanner;

public class BasicMathOperations {
    
    public static int add(int a, int b) {
        int result = a + b;
        return result;
    }
    
    public static int subtract(int a, int b) {
        int result = a - b;
        return result;
    }
    
    public static int multiply(int a, int b) {
        int ans = a * b;
        return ans;
    }
    
    public static double divide(int a, int b) {
        double division = (double) a / b;
        return division;
    }
    
    public static int remainder(int a, int b) {
        int rem = a % b;
        return rem;
    }
    
    public static int square(int a) {
        int sq = a * a;
        return sq;
    }
    
    public static int cube(int a) {
        int c = a * a * a;
        return c;
    }
    
    public static int absolute(int a) {
        int abs;
        if(a < 0) {
            abs = -a;
        } else {
            abs = a;
        }
        return abs;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        
        System.out.println("");
        System.out.println("Results:");
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
