package org.data.structures.listaencadeada;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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
        if(index == 0){
            Node<T> newNode = new Node<>(t);
            newNode.next = first;
            first = newNode;
            return;
        }
        Node<T> current = first;
        for(int i = 0; i < index - 1; i++){
            if(current.next == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            current = current.next;
        }
        Node<T> newNode = new Node<>(t);
        newNode.next = current.next;
        current.next = newNode;
    }

    public void remove(int index){
        if(index < 0 || first == null){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(index == 0){
            first = first.next;
            return;
        }
        Node<T> current = first;
        for(int i = 0; i < index - 1; i++){
            if(current.next == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            current = current.next;
        }
        current.next = current.next.next;
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

    public void forEach(Consumer<T> consumer){
        Node<T> current = first;
        while (current != null){
            consumer.accept(current.getValue());
            current = current.next;
        }
    }

    public CustomLinkedList<T> filter(Predicate<T> predicate){
        Node<T> current = first;
        CustomLinkedList<T> newCustomLinkedList = new CustomLinkedList<>();
        while(current != null){
            if(predicate.test(current.getValue())){
                newCustomLinkedList.add(current.getValue());
            }
            current = current.next;
        }
        return newCustomLinkedList;
    }

    public <R> CustomLinkedList<R> map(Function<T, R> function){
        Node<T> current = first;
        CustomLinkedList<R> newCustomLinkedList = new CustomLinkedList<>();
        while(current != null){
            newCustomLinkedList.add(function.apply(current.getValue()));
            current = current.next;
        }
        return newCustomLinkedList;
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
