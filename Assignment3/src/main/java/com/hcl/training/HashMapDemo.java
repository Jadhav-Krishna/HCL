package com.hcl.training;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class HashMapDemo {
    public static void main(String[] args) {
        
        HashMap<String, Integer> map1 = new HashMap<>();
        
        HashMap<String, Integer> map2 = new HashMap<>(20);
        
        HashMap<String, Integer> map3 = new HashMap<>(20, 0.75f);
        
        Map<String, Integer> tempMap = new HashMap<>();
        tempMap.put("X", 100);
        HashMap<String, Integer> map4 = new HashMap<>(tempMap);
        
        map1.put("One", 1);
        map1.put("Two", 2);
        map1.put("Three", 3);
        System.out.println("Map after put: " + map1);
        
        map1.putAll(tempMap);
        System.out.println("Map after putAll: " + map1);
        
        map1.putIfAbsent("Four", 4);
        System.out.println("Map after putIfAbsent: " + map1);
        
        Integer value = map1.get("One");
        System.out.println("Value for key One: " + value);
        
        Integer defaultValue = map1.getOrDefault("Five", 0);
        System.out.println("Value for key Five with default: " + defaultValue);
        
        map1.remove("X");
        System.out.println("Map after remove: " + map1);
        
        boolean removed = map1.remove("Two", 2);
        System.out.println("Removed Two: " + removed);
        
        boolean containsKey = map1.containsKey("Three");
        System.out.println("Contains key Three: " + containsKey);
        
        boolean containsValue = map1.containsValue(4);
        System.out.println("Contains value 4: " + containsValue);
        
        int size = map1.size();
        System.out.println("Size: " + size);
        
        boolean empty = map1.isEmpty();
        System.out.println("Is empty: " + empty);
        
        Set<String> keys = map1.keySet();
        System.out.println("Keys: " + keys);
        
        Collection<Integer> values = map1.values();
        System.out.println("Values: " + values);
        
        Set<Map.Entry<String, Integer>> entries = map1.entrySet();
        System.out.println("Entries: " + entries);
        
        map1.clear();
        System.out.println("Map after clear: " + map1);
    }
}
