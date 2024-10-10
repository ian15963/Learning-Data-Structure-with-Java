package org.data.structures.queue;

public class CustomQueue<T> {

    private T[] elements;
    private int size;

    public CustomQueue() {
        elements = (T[]) new Object[16];
        size = 0;
    }

    public boolean add(T valor){
        if (size == elements.length){
            T[] newArray = (T[]) new Object[size * 2];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
        elements[size++] = valor;
        return true;
    }

    public T element(){
        if (elements.length == 0){
            throw new ArrayIndexOutOfBoundsException("Não há nenhum elemento na lista");
        }
        return elements[0];
    }

    public T peek(){
        if (elements.length == 0){
            return null;
        }
        return elements[0];
    }

    public T remove(){
        if (elements.length == 0){
            throw new ArrayIndexOutOfBoundsException("Não há nenhum elemento na lista");
        }
        T elementoRetirado = elements[0];
        for (int i = 0; i < size; i++){
            elements[i] = elements[i + 1];
        }
        elements[size--] = null;
        return elementoRetirado;
    }

    public T poll(){
        if (elements.length == 0){
            return null;
        }
        T elementoRetirado = elements[0];
        for (int i = 0; i < size; i++){
            elements[i] = elements[i + 1];
        }
        elements[size--] = null;
        return elementoRetirado;
    }
}