package org.data.structures;

import org.data.structures.listaencadeada.CustomLinkedList;

public class CustomLinkedListExecutable {

    public static void main(String[] args) {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        for(int i = 0; i < 30; i++){
            customLinkedList.add(i+1);
        }
        customLinkedList.forEach(System.out::println);
        System.out.println("-----------------------------");
        customLinkedList.filter(valor -> valor > 25).forEach(System.out::println);
        System.out.println("-----------------------------");
        customLinkedList.filter(valor -> valor > 25).map(valor -> String.valueOf(valor).concat(" Olá")).forEach(System.out::println);
//        customLinkedList.add("Melão");
//        System.out.println(customLinkedList.get(0));
//        customLinkedList.set(0, "Mamão");
//        System.out.println(customLinkedList.get(0));
//        System.out.println(customLinkedList.size());
//        customLinkedList.insert(0, "Melancia");
//        System.out.println(customLinkedList.get(1));
//        System.out.println(customLinkedList.size());
//        customLinkedList.remove(0);
//        System.out.println(customLinkedList.get(0));
//        System.out.println(customLinkedList.size());
    }
}
