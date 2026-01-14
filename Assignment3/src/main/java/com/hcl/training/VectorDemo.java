package com.hcl.training;

import java.util.Vector;
import java.util.Arrays;
import java.util.Enumeration;

public class VectorDemo {
    public static void main(String[] args) {
        
        Vector<Integer> v1 = new Vector<>();
        
        Vector<Integer> v2 = new Vector<>(10);
        
        Vector<Integer> v3 = new Vector<>(10, 5);
        
        Vector<Integer> v4 = new Vector<>(Arrays.asList(1, 2, 3));
        
        v1.add(10);
        v1.add(20);
        v1.add(30);
        System.out.println("Vector after add: " + v1);
        
        v1.addElement(40);
        System.out.println("Vector after addElement: " + v1);
        
        v1.insertElementAt(15, 1);
        System.out.println("Vector after insertElementAt: " + v1);
        
        int element = v1.get(0);
        System.out.println("Element at index 0: " + element);
        
        int firstElement = v1.firstElement();
        System.out.println("First element: " + firstElement);
        
        int lastElement = v1.lastElement();
        System.out.println("Last element: " + lastElement);
        
        v1.set(0, 100);
        System.out.println("Vector after set: " + v1);
        
        v1.setElementAt(200, 1);
        System.out.println("Vector after setElementAt: " + v1);
        
        v1.remove(2);
        System.out.println("Vector after remove: " + v1);
        
        v1.removeElement(40);
        System.out.println("Vector after removeElement: " + v1);
        
        v1.removeElementAt(0);
        System.out.println("Vector after removeElementAt: " + v1);
        
        boolean contains = v1.contains(20);
        System.out.println("Contains 20: " + contains);
        
        int size = v1.size();
        System.out.println("Size: " + size);
        
        int capacity = v1.capacity();
        System.out.println("Capacity: " + capacity);
        
        Enumeration<Integer> enumeration = v1.elements();
        System.out.print("Enumeration: ");
        while(enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + " ");
        }
        System.out.println();
        
        v1.clear();
        System.out.println("Vector after clear: " + v1);
    }
}
