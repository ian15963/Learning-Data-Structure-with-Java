package org.data.structures;

import org.data.structures.hasmap.CustomHashMap;

public class CustomHashMapExecutable {

    public static void main(String[] args) {
        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();
        customHashMap.put("arroz", 1);
        System.out.println(customHashMap.get("arroz"));
    }
}
