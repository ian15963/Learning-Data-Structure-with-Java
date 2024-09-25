package org.data.structures;

import org.data.structures.hasmap.CustomHashMap;

import java.util.HashMap;
import java.util.Map;

public class CustomHashMapExecutable {

    public static void main(String[] args) {
        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();
        customHashMap.put("arroz", 1);
        customHashMap.put("batata", 2);
        customHashMap.put("beteraba", 4);
//        System.out.println(customHashMap.get("arroz"));
//        System.out.println(customHashMap.remove("arroz", 1));
        System.out.println(customHashMap.get("arroz"));
        System.out.println(customHashMap.keySet());
        System.out.println(customHashMap.values());
        System.out.println(customHashMap.entrySet());
    }
}
