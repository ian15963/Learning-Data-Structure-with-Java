package org.data.structures.array;

import java.util.function.Consumer;
import java.util.function.Predicate;

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
            throw new ArrayIndexOutOfBoundsException();
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

    public int size(){
        return size;
    }

    public void forEach(Consumer<T> consumer) {
        for(int i = 0; i < size; i++){
            consumer.accept(values[i]);
        }
    }

    public CustomArrayList<T> filter(Predicate<T> predicate){
        CustomArrayList<T> newCustomArrayList = new CustomArrayList<>();
        for(int i = 0; i < size; i++){
            if(predicate.test(values[i])){
                newCustomArrayList.add(values[i]);
            }
        }
        return newCustomArrayList;
    }

}
