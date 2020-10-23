package com.ds.algos.udemy.hashtable;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable<K, V> {

    private final LinkedList<StoredData<K,V>>[] hashTable;

    private static final int DEFAULT_SIZE = 10;

    private int size;

    public ChainedHashTable() {
        hashTable = new LinkedList[DEFAULT_SIZE];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }
    public ChainedHashTable(int size) {
        hashTable = size > 0 ? new LinkedList[size] : new LinkedList[DEFAULT_SIZE];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int hashedKey = hashCode(key);
        StoredData<K,V> newData = new StoredData<>(key, value);
        int index = hashTable[hashedKey] != null ? hashTable[hashedKey].indexOf(newData) : -1;
        if(index > -1) {
            hashTable[hashedKey].remove(index);
            hashTable[hashedKey].add(index, newData);
        } else {
            hashTable[hashedKey].add(newData);
            size++;
        }
    }

    public Object get(K key){
        int hashedKey = hashCode(key);
        StoredData<K,V> storedData;
        for (StoredData<K, V> kvStoredData : hashTable[hashedKey]) {
            storedData = kvStoredData;
            if (storedData.key.equals(key)) {
                return storedData.value;
            }
        }
        return null;
    }

    public Object remove(K key){
        int hashedKey = hashCode(key);
        ListIterator<StoredData<K, V>> iterator = hashTable[hashedKey].listIterator();
        while (iterator.hasNext()) {
            StoredData<K,V> storedData = iterator.next();
            if(storedData.key.equals(key)) {
                iterator.remove();
                size--;
                return storedData.value;
            }
        }
        return null;
    }

    private int hashCode(K key) {
        return Math.abs(key.hashCode() % hashTable.length);
    }

    public void printHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            if(hashTable[i] == null || hashTable[i].isEmpty()) {
                System.out.println("Value at Position:  " + i + " is empty");
            } else {
                for (StoredData<K, V> storedData : hashTable[i]) {
                    System.out.print("key: " + storedData.key + " value: " + storedData.value);
                    System.out.print(" -> ");
                }
                System.out.println("null");
            }
        }
    }

    public int size() {
        return size;
    }
}
