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

    public T get(int index){
        if(index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> current = first;
        for(int i = 0; i < index; i++){
            if(current.next == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            current = current.next;
        }
        return current.getValue();
    }

    public void set(int index, T value){
        if(index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> current = first;
        for(int i = 0; i < index; i++){
            if(current.next == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            current = current.next;
        }
        current.setValue(value);
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
