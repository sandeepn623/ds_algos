package com.ds.algos.udemy.hashtable;


import lombok.Getter;

import java.util.Arrays;

public class SimpleHashTable<K, V> {

    @Getter
    private Object[] hashTable;

    private static final int DEFAULT_SIZE = 5;

    private int capacity = DEFAULT_SIZE;

    public SimpleHashTable() {
        hashTable = new Object[DEFAULT_SIZE];
    }

    public SimpleHashTable(int size) {
        if(size > 0) {
            capacity = size;
            hashTable = new Object[size];
        } else {
            hashTable = new Object[DEFAULT_SIZE];
        }
    }

    public void put(K key, V value){
        int index = hashCode(key);
        if(hashTable[index] != null) {
            System.out.println("Location already occupied at positiom " + index + "!");
        }
        else {
            hashTable[index] = value;
        }
    }

    public Object get(K key) {
        int index = hashCode(key);
        return hashTable[index];
    }

    public void printHashTable() {
        System.out.println(Arrays.toString(hashTable));
    }
    // compute has code
    private int hashCode(K key){
        return Math.abs(key.toString().length()) % capacity;
    }
}
