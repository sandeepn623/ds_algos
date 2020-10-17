package com.ds.algos.udemy.hashtable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable<K, V> {

    private LinkedList<StoredData<K,V>>[] hashTable;

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
        StoredData checkForDuplicate = new StoredData<>(key, value);
        int index = hashTable[hashedKey] != null ? hashTable[hashedKey].indexOf(checkForDuplicate) : -1;
        if(index > -1) {
            hashTable[hashedKey].remove(index);
            hashTable[hashedKey].add(index, checkForDuplicate);
        } else {
            hashTable[hashedKey].add(new StoredData<>(key, value));
            size++;
        }
    }

    public Object get(K key){
        int hashedKey = hashCode(key);
        StoredData storedData = null;
        Iterator<StoredData<K, V>> iterator = hashTable[hashedKey].iterator();
        while (iterator.hasNext()) {
            storedData = iterator.next();
            if(storedData.key.equals(key)) {
                return storedData.value;
            }
        }
        return null;
    }

    public Object remove(K key){
        int hashedKey = hashCode(key);
        ListIterator<StoredData<K, V>> iterator = hashTable[hashedKey].listIterator();
        while (iterator.hasNext()) {
            StoredData storedData = iterator.next();
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
                Iterator<StoredData<K, V>> iterator = hashTable[i].iterator();
                while (iterator.hasNext()) {
                    StoredData storedData = iterator.next();
                    System.out.print("key: " + storedData.key + " value: " +storedData.value);
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
