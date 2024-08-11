package org.data.structures.listaencadeada;

public class CustomLinkedList<T> {

    private Node<T> first;

    public void add(T t){
        if(first == null){
            first = new Node<>(t);
            return;
        }
        Node<T> current = first;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node<>(t);
    }

    private static class Node<T>{

        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

}
