package org.data.structures;

import org.data.structures.listaencadeada.CustomLinkedList;

public class CustomLinkedListExecutable {

    public static void main(String[] args) {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Melão");
        System.out.println(customLinkedList.get(0));
        customLinkedList.set(0, "Mamão");
        System.out.println(customLinkedList.get(0));
    }
}
