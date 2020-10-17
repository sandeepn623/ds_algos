package com.ds.algos.udemy.hashtable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleHashtableTest {

    @Test
    public void test_add_items_to_hashtable() {
        SimpleHashTable<String, String> hashTable = new SimpleHashTable();
        hashTable.put("Nanjundaswamy", "Sandeep");
        hashTable.put("Sharma", "Kshitij");
        hashTable.put("Agarwal", "Pryag");
        hashTable.put("Kumar", "Tejesh");
        hashTable.put("Neruga", "Ganga");
        hashTable.printHashTable();
        assertEquals(5, hashTable.getHashTable().length);
    }

    @Test
    public void test_get_item_to_hashtable() {
        SimpleHashTable<String, String> hashTable = new SimpleHashTable();
        hashTable.put("Nanjundaswamy", "Sandeep");
        hashTable.put("Sharma", "Kshitij");
        hashTable.put("Agarwal", "Pryag");
        hashTable.put("Kumar", "Tejesh");
        hashTable.put("Neruga", "Ganga");
        hashTable.printHashTable();
        assertEquals("Sandeep", hashTable.get("Nanjundaswamy"));
    }
}
