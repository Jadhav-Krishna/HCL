package com.hcl.training;

import java.util.Scanner;

public class MatrixOperations {
    
    static Scanner sc = new Scanner(System.in);
    
    public static int[][] inputMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }
    
    public static void displayMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void addition() {
        System.out.print("Enter rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        
        System.out.println("Matrix 1:");
        int[][] m1 = inputMatrix(rows, cols);
        
        System.out.println("Matrix 2:");
        int[][] m2 = inputMatrix(rows, cols);
        
        int[][] result = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }
        
        System.out.println("Addition Result:");
        displayMatrix(result);
    }
    
    public static void subtraction() {
        System.out.print("Enter rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        
        System.out.println("Matrix 1:");
        int[][] m1 = inputMatrix(rows, cols);
        
        System.out.println("Matrix 2:");
        int[][] m2 = inputMatrix(rows, cols);
        
        int[][] result = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[i][j] = m1[i][j] - m2[i][j];
            }
        }
        
        System.out.println("Subtraction Result:");
        displayMatrix(result);
    }
    
    public static void multiplication() {
        System.out.print("Enter rows and cols for matrix 1: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        
        System.out.print("Enter rows and cols for matrix 2: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        
        if(c1 != r2) {
            System.out.println("Multiplication not possible");
            return;
        }
        
        System.out.println("Matrix 1:");
        int[][] m1 = inputMatrix(r1, c1);
        
        System.out.println("Matrix 2:");
        int[][] m2 = inputMatrix(r2, c2);
        
        int[][] result = new int[r1][c2];
        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c2; j++) {
                for(int k = 0; k < c1; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        
        System.out.println("Multiplication Result:");
        displayMatrix(result);
    }
    
    public static void transpose() {
        System.out.print("Enter rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        
        int[][] matrix = inputMatrix(rows, cols);
        
        int[][] result = new int[cols][rows];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        
        System.out.println("Transpose:");
        displayMatrix(result);
    }
    
    public static void checkSquare() {
        System.out.print("Enter rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        
        int[][] matrix = inputMatrix(rows, cols);
        
        if(rows == cols) {
            System.out.println("Matrix is square");
        } else {
            System.out.println("Matrix is not square");
        }
    }
    
    public static void checkDiagonal() {
        System.out.print("Enter size of square matrix: ");
        int n = sc.nextInt();
        
        int[][] matrix = inputMatrix(n, n);
        
        boolean isDiagonal = true;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && matrix[i][j] != 0) {
                    isDiagonal = false;
                    break;
                }
            }
        }
        
        if(isDiagonal) {
            System.out.println("Matrix is diagonal");
        } else {
            System.out.println("Matrix is not diagonal");
        }
    }
    
    public static void checkIdentity() {
        System.out.print("Enter size of square matrix: ");
        int n = sc.nextInt();
        
        int[][] matrix = inputMatrix(n, n);
        
        boolean isIdentity = true;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j && matrix[i][j] != 1) {
                    isIdentity = false;
                    break;
                }
                if(i != j && matrix[i][j] != 0) {
                    isIdentity = false;
                    break;
                }
            }
        }
        
        if(isIdentity) {
            System.out.println("Matrix is identity");
        } else {
            System.out.println("Matrix is not identity");
        }
    }
    
    public static void main(String[] args) {
        while(true) {
            System.out.println("\n--- Matrix Operations Menu ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Transpose");
            System.out.println("5. Check Square Matrix");
            System.out.println("6. Check Diagonal Matrix");
            System.out.println("7. Check Identity Matrix");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            
            if(choice == 8) {
                System.out.println("Exiting...");
                break;
            }
            
            switch(choice) {
                case 1:
                    addition();
                    break;
                case 2:
                    subtraction();
                    break;
                case 3:
                    multiplication();
                    break;
                case 4:
                    transpose();
                    break;
                case 5:
                    checkSquare();
                    break;
                case 6:
                    checkDiagonal();
                    break;
                case 7:
                    checkIdentity();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
