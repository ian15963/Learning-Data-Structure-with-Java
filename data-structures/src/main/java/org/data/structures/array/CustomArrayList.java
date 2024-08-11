package org.data.structures.array;

public class CustomArrayList<T> {

    private T[] values;
    private int size;

    public CustomArrayList() {
        this.values = (T[]) new Object[16];
    }

    public CustomArrayList(T[] values) {
        this.values = values;
        size = values.length;
    }

    public void add(T t){
        if(size == values.length){
            T[] newArray = (T[]) new Object[size * 2];
            for(int i = 0; i < values.length; i++){
                newArray[i] = values[i];
            }
            values = newArray;
            values[size] = t;
            size++;
        }else{
            values[size] = t;
            size++;
        }
    }

    public T get(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("Índice inválido");
        }
        return values[index];
    }

    public void remove(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < size; i++){
            if(i == size - 1){
                values[i] = null;
                size--;
            }else{
                values[i] = values[i+1];
            }

        }
    }

}
