package com.hcl.training;

import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Comparator;

public class TreeMapDemo {
    public static void main(String[] args) {
        
        TreeMap<Integer, String> tm1 = new TreeMap<>();
        
        TreeMap<Integer, String> tm2 = new TreeMap<>(Comparator.reverseOrder());
        
        Map<Integer, String> tempMap = new TreeMap<>();
        tempMap.put(100, "Hundred");
        TreeMap<Integer, String> tm3 = new TreeMap<>(tempMap);
        
        tm1.put(5, "Five");
        tm1.put(3, "Three");
        tm1.put(8, "Eight");
        tm1.put(1, "One");
        System.out.println("TreeMap after put: " + tm1);
        
        tm1.putAll(tempMap);
        System.out.println("TreeMap after putAll: " + tm1);
        
        tm1.putIfAbsent(2, "Two");
        System.out.println("TreeMap after putIfAbsent: " + tm1);
        
        String value = tm1.get(5);
        System.out.println("Value for key 5: " + value);
        
        String defaultValue = tm1.getOrDefault(10, "NotFound");
        System.out.println("Value for key 10 with default: " + defaultValue);
        
        tm1.remove(100);
        System.out.println("TreeMap after remove: " + tm1);
        
        Integer firstKey = tm1.firstKey();
        System.out.println("First key: " + firstKey);
        
        Integer lastKey = tm1.lastKey();
        System.out.println("Last key: " + lastKey);
        
        Map.Entry<Integer, String> firstEntry = tm1.firstEntry();
        System.out.println("First entry: " + firstEntry);
        
        Map.Entry<Integer, String> lastEntry = tm1.lastEntry();
        System.out.println("Last entry: " + lastEntry);
        
        Integer lowerKey = tm1.lowerKey(5);
        System.out.println("Lower key than 5: " + lowerKey);
        
        Integer higherKey = tm1.higherKey(5);
        System.out.println("Higher key than 5: " + higherKey);
        
        Set<Integer> keys = tm1.keySet();
        System.out.println("Keys: " + keys);
        
        Collection<String> values = tm1.values();
        System.out.println("Values: " + values);
        
        int size = tm1.size();
        System.out.println("Size: " + size);
        
        tm1.clear();
        System.out.println("TreeMap after clear: " + tm1);
    }
}
