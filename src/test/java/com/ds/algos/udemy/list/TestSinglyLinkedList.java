package com.ds.algos.udemy.list;

import org.junit.Test;

import java.util.LinkedList;

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
        linkedList.addFirst(20);
        linkedList.addFirst(5);
        System.out.println(linkedList.toString());
        assertEquals("[5, 20]", linkedList.toString());
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
        System.out.println(linkedList.indexOf(Integer.valueOf("20")));
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
}
