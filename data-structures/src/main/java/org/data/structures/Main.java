package org.data.structures;

import org.data.structures.array.CustomArrayList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        for(int i = 0; i < 30; i++){
            customArrayList.add(i);
        }
        customArrayList.forEach(System.out::println);
        System.out.println(customArrayList.size());
        customArrayList.remove(0);
        System.out.println(customArrayList.size());
    }
}