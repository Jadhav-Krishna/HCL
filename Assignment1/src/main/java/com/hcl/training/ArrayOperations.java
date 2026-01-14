package com.hcl.training;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    
    static int[] arr;
    static Scanner sc = new Scanner(System.in);
    
    public static void insert() {
        System.out.print("Enter size of array: ");
        int size = sc.nextInt();
        arr = new int[size];
        System.out.println("Enter " + size + " elements:");
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array inserted successfully");
    }
    
    public static void delete() {
        System.out.print("Enter element to delete: ");
        int element = sc.nextInt();
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == element) {
                index = i;
                break;
            }
        }
        if(index != -1) {
            int[] newArr = new int[arr.length - 1];
            for(int i = 0, j = 0; i < arr.length; i++) {
                if(i != index) {
                    newArr[j++] = arr[i];
                }
            }
            arr = newArr;
            System.out.println("Element deleted successfully");
        } else {
            System.out.println("Element not found");
        }
    }
    
    public static void linearSearch() {
        System.out.print("Enter element to search: ");
        int element = sc.nextInt();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == element) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }
        System.out.println("Element not found");
    }
    
    public static void binarySearch() {
        System.out.print("Enter element to search: ");
        int element = sc.nextInt();
        Arrays.sort(arr);
        int result = Arrays.binarySearch(arr, element);
        if(result >= 0) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
    
    public static void findMaximum() {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum value is: " + max);
    }
    
    public static void countEvenOdd() {
        int evenCount = 0;
        int oddCount = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Even numbers: " + evenCount);
        System.out.println("Odd numbers: " + oddCount);
    }
    
    public static void insertionSort() {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println("Array sorted using insertion sort");
        display();
    }
    
    public static void display() {
        System.out.print("Array: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        while(true) {
            System.out.println("\n--- Array Operations Menu ---");
            System.out.println("1. Insert elements");
            System.out.println("2. Delete element");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum");
            System.out.println("6. Count Even/Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display Array");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            
            if(choice == 9) {
                System.out.println("Exiting...");
                break;
            }
            
            if(arr == null && choice != 1) {
                System.out.println("Please insert array first");
                continue;
            }
            
            switch(choice) {
                case 1:
                    insert();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    linearSearch();
                    break;
                case 4:
                    binarySearch();
                    break;
                case 5:
                    findMaximum();
                    break;
                case 6:
                    countEvenOdd();
                    break;
                case 7:
                    insertionSort();
                    break;
                case 8:
                    display();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
