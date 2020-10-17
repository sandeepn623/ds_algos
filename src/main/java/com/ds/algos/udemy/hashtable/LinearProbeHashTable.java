package com.ds.algos.udemy.hashtable;

import lombok.Getter;

public class LinearProbeHashTable<K, V> {

    @Getter
    private Object[] hashTable;

    private static final int DEFAULT_SIZE = 5;

    private int capacity = DEFAULT_SIZE;

    public LinearProbeHashTable() {
        hashTable = new Object[DEFAULT_SIZE];
    }

    public LinearProbeHashTable(int size) {
        if(size > 0) {
            capacity = size;
            hashTable = new Object[size];
        } else {
            hashTable = new Object[DEFAULT_SIZE];
        }
    }

    public void put(K key, V value){
        int hashedKey = hashCode(key);
        System.out.println("put: " + hashedKey);
        if(occupied(hashedKey)) {
            int stopIndex = hashedKey;
            hashedKey = (hashedKey == capacity - 1) ? 0 : ++hashedKey;
            System.out.println(hashedKey);
            while(occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey= (hashedKey+1) % capacity;
            }
        }
        if(occupied(hashedKey)) {
            System.out.println("Already occupied position: " + hashedKey + "!");
        } else {
            hashTable[hashedKey] = new StoredData(key, value);
        }
    }

    public Object get(K key) {
        int hashedKey = findKey(key);
        return hashedKey == -1 ? null : ((StoredData)hashTable[hashedKey]).value;
    }

    public Object remove(K key) {
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        }
        Object value = hashTable[hashedKey];
        hashTable[hashedKey] = null;
        // nulling the value causes issues to fetch the values adjusted during put using linear probing.
        // We won't be able to find the value because when the values are removed between 2 items which are placed using linear probing.
        // That's how we find empty space during put, but if we just set the removed items to null
        // then the same find method will not be able to reach the 2nd collision item during fetch as there are null values between them.
        // To solve this we could rehash the hashtable during remove procedure. This will have impact on the performance.

        Object[] oldHashtable = hashTable;
        hashTable = new Object[oldHashtable.length];
        for(int i = 0; i < oldHashtable.length; i++) {
            if(oldHashtable[i] != null) {
                K oldKey = (K) ((StoredData)oldHashtable[i]).key;
                V oldValue = (V) ((StoredData)oldHashtable[i]).value;
                put(oldKey, oldValue);
            }
        }
        return value;
    }

    public void printHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("Position: " + i + " " + hashTable[i]);
        }
    }

    // compute has code
    private int hashCode(K key){
        return Math.abs(key.toString().length()) % capacity;
    }

    private boolean occupied(int index) {
        return hashTable[index] != null;
    }

    private int findKey(K key) {
        int hashedKey = hashCode(key);
        System.out.println(hashedKey);
        if(hashTable[hashedKey] != null && ((StoredData)hashTable[hashedKey]).key.equals(key)) {
            return hashedKey;
        }

        int stopIndex = hashedKey;
        hashedKey = (hashedKey == capacity - 1) ? 0 : ++hashedKey;
        while(hashedKey != stopIndex && hashTable[hashedKey] != null && !((StoredData)hashTable[hashedKey]).key.equals(key)) {
            hashedKey= (hashedKey+1) % capacity;
        }
        return hashTable[hashedKey] != null && ((StoredData)hashTable[hashedKey]).key.equals(key) ? hashedKey : -1;
    }
}
