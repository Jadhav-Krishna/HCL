package com.hcl.training;

import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Set;
import java.util.Collection;
import java.util.Map;

public class HashTableDemo {
    public static void main(String[] args) {
        
        Hashtable<String, String> ht1 = new Hashtable<>();
        
        Hashtable<String, String> ht2 = new Hashtable<>(20);
        
        Hashtable<String, String> ht3 = new Hashtable<>(20, 0.75f);
        
        Map<String, String> tempMap = new Hashtable<>();
        tempMap.put("D", "Dog");
        Hashtable<String, String> ht4 = new Hashtable<>(tempMap);
        
        ht1.put("A", "Apple");
        ht1.put("B", "Banana");
        ht1.put("C", "Cat");
        System.out.println("Hashtable after put: " + ht1);
        
        ht1.putAll(tempMap);
        System.out.println("Hashtable after putAll: " + ht1);
        
        ht1.putIfAbsent("E", "Elephant");
        System.out.println("Hashtable after putIfAbsent: " + ht1);
        
        String value = ht1.get("A");
        System.out.println("Value for key A: " + value);
        
        String defaultValue = ht1.getOrDefault("F", "NotFound");
        System.out.println("Value for key F with default: " + defaultValue);
        
        ht1.remove("D");
        System.out.println("Hashtable after remove: " + ht1);
        
        boolean removed = ht1.remove("B", "Banana");
        System.out.println("Removed B: " + removed);
        
        boolean containsKey = ht1.containsKey("C");
        System.out.println("Contains key C: " + containsKey);
        
        boolean containsValue = ht1.contains("Cat");
        System.out.println("Contains value Cat: " + containsValue);
        
        int size = ht1.size();
        System.out.println("Size: " + size);
        
        boolean empty = ht1.isEmpty();
        System.out.println("Is empty: " + empty);
        
        Set<String> keys = ht1.keySet();
        System.out.println("Keys: " + keys);
        
        Enumeration<String> keysEnum = ht1.keys();
        System.out.print("Keys enumeration: ");
        while(keysEnum.hasMoreElements()) {
            System.out.print(keysEnum.nextElement() + " ");
        }
        System.out.println();
        
        Collection<String> values = ht1.values();
        System.out.println("Values: " + values);
        
        ht1.clear();
        System.out.println("Hashtable after clear: " + ht1);
    }
}
