package com.hcl.training;

import java.util.Scanner;

public class StringOperations {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.print("Enter another string for comparison: ");
        String str2 = sc.nextLine();
        
        System.out.println("\n--- String Methods Demonstration ---");
        
        System.out.println("1. length(): " + str.length());
        
        System.out.println("2. isEmpty(): " + str.isEmpty());
        
        System.out.println("3. charAt(0): " + (str.length() > 0 ? str.charAt(0) : "String is empty"));
        
        System.out.println("4. toString(): " + str.toString());
        
        System.out.println("5. equals(): " + str.equals(str2));
        
        System.out.println("6. equalsIgnoreCase(): " + str.equalsIgnoreCase(str2));
        
        System.out.println("7. compareTo(): " + str.compareTo(str2));
        
        System.out.println("8. compareToIgnoreCase(): " + str.compareToIgnoreCase(str2));
        
        System.out.println("9. contains(): " + str.contains("a"));
        
        System.out.println("10. indexOf('a'): " + str.indexOf('a'));
        
        System.out.println("11. lastIndexOf('a'): " + str.lastIndexOf('a'));
        
        System.out.println("12. startsWith('H'): " + str.startsWith("H"));
        
        System.out.println("13. endsWith('o'): " + str.endsWith("o"));
        
        System.out.println("14. matches('[a-zA-Z]+'): " + str.matches("[a-zA-Z]+"));
        
        System.out.println("15. substring(0, 3): " + (str.length() >= 3 ? str.substring(0, 3) : str));
        
        System.out.println("16. toLowerCase(): " + str.toLowerCase());
        
        System.out.println("17. toUpperCase(): " + str.toUpperCase());
        
        System.out.println("18. trim(): " + str.trim());
        
        System.out.println("19. replace('a', 'x'): " + str.replace('a', 'x'));
        
        System.out.println("20. split(' '): ");
        String[] parts = str.split(" ");
        for(String part : parts) {
            System.out.println("   - " + part);
        }
        
        String[] arr = {"Hello", "World", "Java"};
        System.out.println("21. String.join(', ', arr): " + String.join(", ", arr));
        
        System.out.println("22. String.valueOf(100): " + String.valueOf(100));
        
        System.out.println("23. concat(): " + str.concat(str2));
        
        System.out.println("24. toCharArray(): ");
        char[] chars = str.toCharArray();
        System.out.print("   ");
        for(char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();
        
        System.out.println("25. getBytes().length: " + str.getBytes().length);
        
        sc.close();
    }
}
