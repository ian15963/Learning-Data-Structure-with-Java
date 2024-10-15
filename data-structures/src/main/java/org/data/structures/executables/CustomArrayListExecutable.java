package org.data.structures.executables;

import org.data.structures.array.CustomArrayList;

public class CustomArrayListExecutable {
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
        System.out.println("Teste do map");
        customArrayList.filter(valor -> valor > 25).map(String::valueOf).forEach(texto -> System.out.println(texto + " valor "));
        System.out.println("---------------------------------------");
        System.out.println("Teste do set");
        customArrayList.set(0, 30);
        customArrayList.forEach(System.out::println);
        System.out.println("---------------------------------------");
        System.out.println("Teste do insert");
        System.out.println(customArrayList.size());
        customArrayList.insert(3, 50);
        System.out.println(customArrayList.size());
        customArrayList.forEach(System.out::println);
        System.out.println("---------------------------------------");
    }
}