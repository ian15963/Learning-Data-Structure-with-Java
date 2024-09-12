package org.data.structures.listaencadeada;

public class CustomDoubleLinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    public void add(T value){
        if(first == null){
            first = new Node<>(value);
            return;
        }
        Node<T> current = first;
        while(current.next != null){
            current = current.next;
        }
        Node<T> newNode = new Node<>(value);
        newNode.previous = current;
        current.next = newNode;
    }

    public void set(T value, int indice){
        if (first == null || indice < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> current = first;
        for (int i = 0; i < indice; i++) {
            if (current.next == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            current = current.next;
        }
        Node<T> newNode = new Node<>(value);
        if (current == first){
            newNode.next = first.next;
            first.next.previous = newNode;
            first = newNode;
            return;
        }
        if (current.next != null){
            current.next.previous = newNode;
        }
        if (current.previous != null){
            current.previous.next = newNode;
        }
        newNode.previous = current.previous;
        newNode.next = current.next;
    }

    public void insert(T value, int indice){
        if (first == null || indice < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> current = first;
        for (int i = 0; i < indice; i++) {
            if (current.next == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            current = current.next;
        }
        Node<T> newNode = new Node<>(value);
        if (current == first){
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
            return;
        }
        current.previous.next = newNode;
        newNode.previous = current.previous;
        newNode.next = current;
        current.previous = newNode;
    }

    public void remove(T value){
        if (first == null){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> current = first;
        while (!current.getValue().equals(value)){
            if (current.next == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            current = current.next;
        }
        if (current == first){
            first = current.next;
            first.previous = null;
            return;
        }
        current.previous.next = current.next;
        if (current.next != null){
            current.next.previous = current.previous;
        }

    }

    public T get(int indice){
        if(first == null || indice < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> current = first;
        for (int i = 0; i < indice; i++){
            if(current.next == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            current = current.next;
        }

        return current.getValue();
    }

    private static class Node<T>{

        private Node<T> previous;
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
