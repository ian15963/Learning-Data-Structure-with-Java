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
        if(index < 0 || first == null){
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

    public void insert(int index, T t){
        if(index < 0 || first == null){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> current = first;
        for(int i = 0; i < index; i++){
            if(current.next == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            current = current.next;
        }
        Node<T> newNode = new Node<>(t);
        newNode.next = current.next;
        current.next = newNode;
    }

    public int size(){
        int i = 0;
        Node<T> current = first;
        if(current != null) i++;
        while(current.next != null){
            i++;
            current = current.next;
        }
        return i;
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
