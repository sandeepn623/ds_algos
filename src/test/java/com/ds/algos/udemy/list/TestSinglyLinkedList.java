package com.ds.algos.udemy.list;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSinglyLinkedList {

    @Test
    public void test_linked_list_add_2_items_front(){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(30);
        System.out.println(linkedList.toString());
        assertEquals("[30, 10]", linkedList.toString());
    }

    @Test
    public void test_linked_list_add_2_items_last(){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addLast(20);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        assertEquals("[20, 5]", linkedList.toString());
    }

    @Test
    public void test_linked_list_add_2_items_first_and_last(){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        assertEquals("[30, 10, 20, 5]", linkedList.toString());
    }

    @Test
    public void test_linked_list_insert_At(){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(20);
        linkedList.addLast(10);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        linkedList.insertAt(3, 7);
        linkedList.insertAt(1, 25);
        linkedList.insertAt(0, 40);
        System.out.println(linkedList.toString());
        assertEquals("[40, 30, 25, 20, 10, 7, 5]", linkedList.toString());
    }

    @Test
    public void test_linked_list_remove_At(){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(20);
        linkedList.addLast(10);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        linkedList.insertAt(3, 7);
        linkedList.insertAt(1, 25);
        linkedList.insertAt(0, 40);
        linkedList.insertAt(7, 2);
        System.out.println(linkedList.toString());
        linkedList.removeAt(7);
        linkedList.removeAt(0);
        linkedList.removeAt(1);
        linkedList.removeAt(3);
        System.out.println(linkedList.toString());
        assertEquals("[30, 20, 10, 5]", linkedList.toString());
    }

    @Test
    public void test_linked_list_remove_items_first(){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        linkedList.removeFirst();
        System.out.println(linkedList.toString());
        assertEquals("[10, 20, 5]", linkedList.toString());
    }

    @Test
    public void test_doubly_linked_list_remove_only_item_from_head(){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(10);
        linkedList.removeFirst();
        System.out.println(linkedList.toString());
        assertEquals("[]", linkedList.toString());
    }

    @Test
    public void test_linked_list_remove_items_last(){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        linkedList.removeLast();
        System.out.println(linkedList.toString());
        assertEquals("[30, 10, 20]", linkedList.toString());
    }

    @Test
    public void test_linked_list_remove_items_first_and_last(){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        linkedList.removeLast();
        linkedList.removeFirst();
        System.out.println(linkedList.toString());
        assertEquals("[10, 20]", linkedList.toString());
    }

    @Test
    public void test_linked_list_indexOf() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.indexOf(20));
        assertEquals(2, linkedList.indexOf(Integer.valueOf("20")));
    }

    @Test
    public void test_linked_list_contains() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.contains(5));
        assertEquals(true, linkedList.contains(5));
    }

    @Test
    public void test_linked_list_does_not_contain() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.contains(21));
        assertEquals(false, linkedList.contains(21));
    }

    @Test
    public void test_linked_list_get_first() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.getFirst().getValue());
        assertEquals(30, linkedList.getFirst().getValue());
    }

    @Test
    public void test_linked_list_get_last() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.getLast().getValue());
        assertEquals(5, linkedList.getLast().getValue());
    }

    @Test
    public void test_sorted_integer_linked_list_add_items(){
        SortedLinkedList linkedList = new SortedLinkedList();
        linkedList.insertSortedIntegers(4);
        linkedList.insertSortedIntegers(2);
        linkedList.insertSortedIntegers(1);
        linkedList.insertSortedIntegers(5);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.getLast().getValue());
        assertEquals("[1, 2, 4, 5]", linkedList.toString());
    }

    @Test
    public void test_sorted_integer_linked_list_add_1_items(){
        SortedLinkedList linkedList = new SortedLinkedList();
        linkedList.insertSortedIntegers(4);
        System.out.println(linkedList.toString());
        assertEquals("[4]", linkedList.toString());
    }

    @Test
    public void test_sorted_integer_linked_list_add_2_items(){
        SortedLinkedList linkedList = new SortedLinkedList();
        linkedList.insertSortedIntegers(4);
        linkedList.insertSortedIntegers(3);
        System.out.println(linkedList.toString());
        assertEquals("[3, 4]", linkedList.toString());
    }

    @Test
    public void test_sorted_integer_linked_list_add_2_string_items(){
        SortedLinkedList linkedList = new SortedLinkedList();
        linkedList.insertSortedIntegers("bca");
        linkedList.insertSortedIntegers("abc");
        System.out.println(linkedList.toString());
        assertEquals("[abc, bca]", linkedList.toString());
    }
}
