package org.data.structures.hasmap;

import java.util.Arrays;

public class CustomHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private float loadFactor;
    private int size;
    private Entry<K, V>[] table;

    public CustomHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public CustomHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
    }

    public void put(K key, V value){
        int index = hash(key);
        Entry<K, V> node = table[index];
        while (node != null){
            if (node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }
        node = new Entry<>(key, value);
        node.next = table[index];
        table[index] = node.next;
        if(size > capacity * loadFactor){
            Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[capacity * 2];
            System.arraycopy(table, 0, newTable, 0, newTable.length);
        }
    }

    private static class Entry<K,V>{
        final K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    private int hash(K key){
        return key.hashCode() % capacity;
    }

}
