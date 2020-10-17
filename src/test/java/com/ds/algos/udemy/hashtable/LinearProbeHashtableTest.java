package com.ds.algos.udemy.hashtable;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearProbeHashtableTest {

    @Test
    public void test_add_items_to_hashtable() {
        LinearProbeHashTable<String, String> hashTable = new LinearProbeHashTable(10);
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
        LinearProbeHashTable<String, String> hashTable = new LinearProbeHashTable<>(10);
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
    public void test_add_items_to_hashtable_overflow() {
        LinearProbeHashTable<String, String> hashTable = new LinearProbeHashTable();
        hashTable.put("Nanjundaswamy", "Sandeep");
        hashTable.put("Sharma", "Kshitij");
        hashTable.put("Agarwal", "Pryag");
        hashTable.put("Kumar", "Tejesh");
        hashTable.put("Neruga", "Ganga");
        hashTable.put("Bakshi", "Tarun");
        hashTable.printHashTable();
        assertEquals(5, hashTable.getHashTable().length);
    }

    @Test
    public void test_get_item_from_hashtable() {
        LinearProbeHashTable<String, String> hashTable = new LinearProbeHashTable();
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
        LinearProbeHashTable<String, String> hashTable = new LinearProbeHashTable();
        hashTable.put("Nanjundaswamy", "Sandeep");
        hashTable.put("Sharma", "Kshitij");
        hashTable.put("Agarwal", "Pryag");
        hashTable.put("Kumar", "Tejesh");
        hashTable.put("Neruga", "Ganga");
        hashTable.printHashTable();
        StoredData removed = (StoredData) hashTable.remove("Sharma");
        hashTable.remove("Agarwal");
        System.out.println(removed);
        assertEquals("Sandeep", hashTable.get("Nanjundaswamy"));
        assertEquals("Kshitij", removed.value);
        hashTable.printHashTable();
        System.out.println(hashTable.get("Neruga"));
        assertEquals("Ganga", hashTable.get("Neruga"));
    }

    @Test
    public void test_remove_non_existing_item_from_hashtable() {
        LinearProbeHashTable<String, String> hashTable = new LinearProbeHashTable();
        hashTable.put("Nanjundaswamy", "Sandeep");
        hashTable.put("Sharma", "Kshitij");
        hashTable.put("Agarwal", "Pryag");
        hashTable.put("Kumar", "Tejesh");
        hashTable.put("Neruga", "Ganga");
        hashTable.printHashTable();
        StoredData result1 = (StoredData) hashTable.remove("Neruga");
        assertEquals("Sandeep", hashTable.get("Nanjundaswamy"));
        assertEquals("Ganga", result1.value);
        hashTable.printHashTable();
        StoredData result2 = (StoredData) hashTable.remove("Neruga");
        assertEquals(null, result2);
    }

    @Test
    public void test_remove_item_notfound_for_key_from_hashtable() {
        LinearProbeHashTable<String, String> hashTable = new LinearProbeHashTable(10);
        hashTable.put("Nanjundaswamy", "Sandeep");
        hashTable.put("Sharma", "Kshitij");
        hashTable.put("Agarwal", "Pryag");
        hashTable.put("Kumar", "Tejesh");
        hashTable.put("Neruga", "Ganga");
        hashTable.printHashTable();
        StoredData result1 = (StoredData) hashTable.remove("Neruga");
        assertEquals("Sandeep", hashTable.get("Nanjundaswamy"));
        assertEquals("Ganga", result1.value);
        hashTable.printHashTable();
        StoredData result2 = (StoredData) hashTable.remove("Neruga");
        assertEquals(null, result2);
    }
}
