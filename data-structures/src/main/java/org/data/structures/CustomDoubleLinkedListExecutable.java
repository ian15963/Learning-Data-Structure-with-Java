package org.data.structures;

import org.data.structures.listaencadeada.CustomDoubleLinkedList;

import java.util.LinkedList;

public class CustomDoubleLinkedListExecutable {

    public static void main(String[] args) {
        CustomDoubleLinkedList<String> linkedList = new CustomDoubleLinkedList<>();
        linkedList.add("Olá, mundo!");
        linkedList.add("Batata");
        System.out.println(linkedList.get(1));
    }

}
