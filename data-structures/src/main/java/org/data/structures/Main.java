package org.data.structures;

import org.data.structures.array.CustomArrayList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("Macarrão");
        System.out.println(customArrayList);
    }
}