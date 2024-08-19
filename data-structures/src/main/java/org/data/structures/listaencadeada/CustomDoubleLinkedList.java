package org.data.structures.listaencadeada;

public class CustomDoubleLinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    public void add(T value){
        if(first == null){
            first = new Node<>(value);
        }
        Node<T> current = first;
        while(current.next != null){
            current = current.next;
        }
        Node<T> newNode = new Node<>(value);
        newNode.previous = current;
        current.next = newNode;
    }

    public T get(int indice){
        if(first == null || indice < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> current = first;
        for (int i = 0; i <= indice; i++){
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
