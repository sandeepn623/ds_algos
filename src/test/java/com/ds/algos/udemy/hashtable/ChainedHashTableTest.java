package com.ds.algos.udemy.hashtable;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChainedHashTableTest {
    @Test
    public void test_add_items_to_hashtable() {
        ChainedHashTable<String, String> hashTable = new ChainedHashTable<>(10);
        hashTable.put("Nanjundaswamy", "Sandeep");
        hashTable.put("Sharma", "Kshitij");
        hashTable.put("Agarwal", "Pryag");
        hashTable.put("Kumar", "Tejesh");
        hashTable.put("Neruga", "Ganga");
        hashTable.printHashTable();
        assertEquals(5, hashTable.size());
    }

    @Test
    public void test_add_items_to_hashtable_replace_duplicate() {
        ChainedHashTable<String, String> hashTable = new ChainedHashTable<>(10);
        hashTable.put("Nanjundaswamy", "Sandeep");
        hashTable.put("Neruga", "Ganga");
        hashTable.put("Agarwal", "Pryag");
        hashTable.put("Kumar", "Tejesh");
        hashTable.put("Neruga", "Ganga");
        hashTable.printHashTable();
        System.out.println(hashTable.size());
        assertEquals(4, hashTable.size());
    }

    @Test
    public void test_get_item_from_hashtable() {
        ChainedHashTable<String, String> hashTable = new ChainedHashTable<>();
        hashTable.put("Nanjundaswamy", "Sandeep");
        hashTable.put("Sharma", "Kshitij");
        hashTable.put("Agarwal", "Pryag");
        hashTable.put("Kumar", "Tejesh");
        hashTable.put("Neruga", "Ganga");
        hashTable.printHashTable();
        System.out.println(hashTable.get("Neruga"));
        assertEquals("Sandeep", hashTable.get("Nanjundaswamy"));
        assertEquals("Ganga", hashTable.get("Neruga"));
    }

    @Test
    public void test_remove_item_from_hashtable() {
        ChainedHashTable<String, String> hashTable = new ChainedHashTable();
        hashTable.put("Nanjundaswamy", "Sandeep");
        hashTable.put("Sharma", "Kshitij");
        hashTable.put("Agarwal", "Pryag");
        hashTable.put("Kumar", "Tejesh");
        hashTable.put("Neruga", "Ganga");
        hashTable.printHashTable();
        Object removed = hashTable.remove("Sharma");
        System.out.println(removed);
        assertEquals("Sandeep", hashTable.get("Nanjundaswamy"));
        assertEquals("Kshitij", removed);
        hashTable.printHashTable();
        System.out.println(hashTable.get("Neruga"));
        assertEquals("Ganga", hashTable.get("Neruga"));
    }
}
