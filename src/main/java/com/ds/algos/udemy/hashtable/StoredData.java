package com.ds.algos.udemy.hashtable;

import lombok.AllArgsConstructor;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoredData<?, ?> that = (StoredData<?, ?>) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
