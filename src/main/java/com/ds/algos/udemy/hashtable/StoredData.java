package com.ds.algos.udemy.hashtable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StoredData<K, V> {
    public K key;
    public V value;

    @Override
    public String toString() {
        return "StoredData{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
