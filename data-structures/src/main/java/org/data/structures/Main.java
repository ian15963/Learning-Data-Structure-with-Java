package org.data.structures;

import org.data.structures.array.CustomArrayList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        for(int i = 0; i < 30; i++){
            customArrayList.add(i);
        }
        System.out.println("---------------------------------------");
        System.out.println("Teste do forEach");
        customArrayList.forEach(System.out::println);
        System.out.println("---------------------------------------");
        System.out.println("Teste do size e remove");
        System.out.println(customArrayList.size());
        customArrayList.remove(0);
        System.out.println(customArrayList.size());
        System.out.println("---------------------------------------");
        System.out.println("Teste do filter");
        customArrayList.filter(valor -> valor > 15).forEach(System.out::println);
        System.out.println("---------------------------------------");
    }
}