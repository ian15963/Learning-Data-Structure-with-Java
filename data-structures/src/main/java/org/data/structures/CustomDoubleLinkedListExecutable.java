package org.data.structures;

import org.data.structures.listaencadeada.CustomDoubleLinkedList;

import java.util.LinkedList;

public class CustomDoubleLinkedListExecutable {

    public static void main(String[] args) {
        CustomDoubleLinkedList<String> linkedList = new CustomDoubleLinkedList<>();
        linkedList.add("Olá, mundo!");
        linkedList.add("Batata");
        linkedList.add("Mamão");
//        linkedList.insert("Abacate", 1);
//        linkedList.set("Abacaxi", 1);
//        System.out.println(linkedList.get(2));
        linkedList.remove("Batata");
        System.out.println(linkedList);
    }

}
