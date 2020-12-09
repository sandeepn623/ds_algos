package com.ds.algos.udemy.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDoublyLinkedList {

    @Test
    public void test_doubly_linked_list_add_2_items_front(){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(30);
        System.out.println(linkedList.toString());
        assertEquals("[30, 10]", linkedList.toString());
    }

    @Test
    public void test_doubly_linked_list_add_2_items_last(){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addLast(20);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        assertEquals("[20, 5]", linkedList.toString());
    }

    @Test
    public void test_doubly_linked_list_add_2_items_first_and_last(){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        assertEquals("[30, 10, 20, 5]", linkedList.toString());
    }

    @Test
    public void test_doubly_linked_list_add_item_before_existing_item(){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        assertEquals("[30, 10, 20, 5]", linkedList.toString());
        linkedList.addBefore(15, 20);
        System.out.println(linkedList.toString());
        assertEquals("[30, 10, 15, 20, 5]", linkedList.toString());
    }

    @Test
    public void test_doubly_linked_list_add_item_before_existing_item_at_head(){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        assertEquals("[30, 10, 20, 5]", linkedList.toString());
        linkedList.addBefore(15, 30);
        System.out.println(linkedList.toString());
        assertEquals("[15, 30, 10, 20, 5]", linkedList.toString());
    }

    @Test
    public void test_doubly_linked_list_add_item_before_existing_single_item(){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(10);
        System.out.println(linkedList.toString());
        assertEquals("[10]", linkedList.toString());
        linkedList.addBefore(5, 10);
        System.out.println(linkedList.toString());
        assertEquals("[5, 10]", linkedList.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void test_doubly_linked_list_add_item_before_existing_item_does_not_exist(){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        assertEquals("[30, 10, 20, 5]", linkedList.toString());
        linkedList.addBefore(15, 22);
    }

    @Test
    public void test_doubly_linked_list_remove_items_first(){
        DoublyLinkedList linkedList = new DoublyLinkedList();
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
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(10);
        linkedList.removeFirst();
        System.out.println(linkedList.toString());
        assertEquals("[]", linkedList.toString());
    }

    @Test
    public void test_doubly_linked_list_remove_items_last(){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        linkedList.removeLast();
        System.out.println(linkedList.toString());
        assertEquals("[30, 10, 20]", linkedList.toString());
    }

    @Test
    public void test_doubly_linked_list_remove_items_first_and_last(){
        DoublyLinkedList linkedList = new DoublyLinkedList();
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
    public void test_doubly_linked_list_indexOf() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.indexOf(Integer.valueOf("20")));
        assertEquals(2, linkedList.indexOf(Integer.valueOf("20")));
    }

    @Test
    public void test_doubly_linked_list_contains() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.contains(5));
        assertEquals(true, linkedList.contains(5));
    }

    @Test
    public void test_doubly_linked_list_does_not_contain() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.contains(21));
        assertEquals(false, linkedList.contains(21));
    }

    @Test
    public void test_doubly_linked_list_get_first() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.getHead().getValue());
        assertEquals(30, linkedList.getHead().getValue());
    }

    @Test
    public void test_doubly_linked_list_get_last() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addFirst(30);
        linkedList.addLast(5);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.getTail().getValue());
        assertEquals(5, linkedList.getTail().getValue());
    }
}
