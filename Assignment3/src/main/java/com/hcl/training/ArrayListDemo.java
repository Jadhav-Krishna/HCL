package com.hcl.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        
        ArrayList<String> list1 = new ArrayList<>();
        
        ArrayList<String> list2 = new ArrayList<>(20);
        
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("Apple", "Banana"));
        
        list1.add("Java");
        list1.add("Python");
        list1.add("C++");
        System.out.println("List after add: " + list1);
        
        list1.add(1, "JavaScript");
        System.out.println("List after add at index: " + list1);
        
        list1.addAll(Arrays.asList("Ruby", "Go"));
        System.out.println("List after addAll: " + list1);
        
        list1.addAll(2, Arrays.asList("PHP", "Swift"));
        System.out.println("List after addAll at index: " + list1);
        
        String element = list1.get(0);
        System.out.println("Element at index 0: " + element);
        
        list1.set(0, "Kotlin");
        System.out.println("List after set: " + list1);
        
        list1.remove(1);
        System.out.println("List after remove at index: " + list1);
        
        list1.remove("Go");
        System.out.println("List after remove object: " + list1);
        
        boolean contains = list1.contains("Ruby");
        System.out.println("Contains Ruby: " + contains);
        
        int index = list1.indexOf("Ruby");
        System.out.println("Index of Ruby: " + index);
        
        int size = list1.size();
        System.out.println("Size of list: " + size);
        
        boolean empty = list1.isEmpty();
        System.out.println("Is list empty: " + empty);
        
        ArrayList<String> sublist = new ArrayList<>(list1.subList(1, 3));
        System.out.println("Sublist: " + sublist);
        
        Object[] array = list1.toArray();
        System.out.println("Array: " + Arrays.toString(array));
        
        Iterator<String> iterator = list1.iterator();
        System.out.print("Iterator: ");
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        list1.clear();
        System.out.println("List after clear: " + list1);
    }
}
