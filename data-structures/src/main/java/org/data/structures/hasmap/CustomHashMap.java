package org.data.structures.hasmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (value == null){
            throw new IllegalArgumentException();
        }
        Entry<K, V> node = table[index];
        while (node != null){
            if (node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }
        if (table[index] == null){
            size++;
        }
        node = new Entry<>(key, value);
        node.next = table[index];
        table[index] = node;
        if(size > capacity * loadFactor){
            Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[capacity * 2];
            System.arraycopy(table, 0, newTable, 0, newTable.length);
            table = newTable;
        }
    }

    public V get(K key){
        int indice = hash(key);
        Entry<K, V> node = table[indice];

        while (node != null){
            if (key.equals(node.key)){
                break;
            }
            node = node.next;
        }

        if (node == null){
            throw new IllegalArgumentException("invalid Key");
        }

        return node.value;
    }

    public V remove(K key){
        int indice = hash(key);
        Entry<K, V> node = table[indice];
        V value = null;
        if (node.next == null){
            value = node.value;
            table[indice] = null;
        }
        while (node != null){
            if (node.next != null && node.next.key.equals(key)){
                value = node.next.value;
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }

        if (value == null){
            throw new IllegalArgumentException("invalid key");
        }

        size--;
        return value;
    }

    public boolean remove(K key, V value){
        int indice = hash(key);
        Entry<K, V> node = table[indice];
        if (node == null){
            return false;
        }
        if (node.next == null && node.key.equals(key) && node.value.equals(value)){
            table[indice] = null;
            return true;
        }
        while(node != null){
            if (node.next != null){
                if (node.next.key.equals(key) && node.next.value.equals(value)){
                    node.next = node.next.next;
                    return true;
                }
            }
            node = node.next;
        }

        return false;
    }

    public Set<K> keySet(){
        Set<K> keys = new HashSet<>();
        for (Entry<K, V> entry: table){
            if (entry != null){
                keys.add(entry.key);
            }
        }
        return keys;
    }

    public Collection<V> values(){
        List<V> values = new ArrayList<>();
        for (Entry<K, V> entry: table){
            if (entry != null){
                values.add(entry.value);
            }
        }
        return values;
    }

    public Set<Entry<K, V>> entrySet(){
        Set<Entry<K, V>> entries = new HashSet<>();
        for (Entry<K, V> entry: table){
            if (entry != null){
                entries.add(entry);
            }
        }
        return entries;
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
        return key.hashCode() % capacity >= 0 ? key.hashCode() % capacity : capacity - 1;
    }

}
