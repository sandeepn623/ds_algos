package com.ds.algos.udemy.tree;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeTest {
    /***
     *          25
     *       /      \
     *      20      27
     *     /  \    /  \
     *    15  22  26   30
     *      \          / \
     *      17       29  32
     *        \
     *        18
     */
    @Test
    public void test_binary_tree_insert_iterative() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertIterative(25);
        binaryTree.insertIterative(20);
        binaryTree.insertIterative(15);
        binaryTree.insertIterative(27);
        binaryTree.insertIterative(30);
        binaryTree.insertIterative(29);
        binaryTree.insertIterative(26);
        binaryTree.insertIterative(22);
        binaryTree.insertIterative(32);
        binaryTree.insertIterative(17);
        binaryTree.printTree();
    }

    @Test
    public void test_binary_tree_insert_recursive() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertRecursive(25);
        binaryTree.insertRecursive(20);
        binaryTree.insertRecursive(15);
        binaryTree.insertRecursive(27);
        binaryTree.insertRecursive(30);
        binaryTree.insertRecursive(29);
        binaryTree.insertRecursive(26);
        binaryTree.insertRecursive(22);
        binaryTree.insertRecursive(32);
        binaryTree.printTree();
    }

    @Test
    public void test_binary_tree_traverse_in_order() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertRecursive(25);
        binaryTree.insertRecursive(20);
        binaryTree.insertRecursive(15);
        binaryTree.insertRecursive(27);
        binaryTree.insertRecursive(30);
        binaryTree.insertRecursive(29);
        binaryTree.insertRecursive(26);
        binaryTree.insertRecursive(22);
        binaryTree.insertRecursive(32);
        binaryTree.printTreeSorted();
    }

    @Test
    public void test_binary_tree_get_found() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertRecursive(25);
        binaryTree.insertRecursive(20);
        binaryTree.insertRecursive(15);
        binaryTree.insertRecursive(27);
        binaryTree.insertRecursive(30);
        binaryTree.insertRecursive(29);
        binaryTree.insertRecursive(26);
        binaryTree.insertRecursive(22);
        binaryTree.insertRecursive(32);
        TreeNode searchResult = binaryTree.find(32);
        System.out.println("searchResult: " + searchResult);
        assertEquals(32, searchResult.getData());
    }

    @Test
    public void test_binary_tree_get_not_found() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertRecursive(25);
        binaryTree.insertRecursive(20);
        binaryTree.insertRecursive(15);
        binaryTree.insertRecursive(27);
        binaryTree.insertRecursive(30);
        binaryTree.insertRecursive(29);
        binaryTree.insertRecursive(26);
        binaryTree.insertRecursive(22);
        binaryTree.insertRecursive(32);
        TreeNode searchResult = binaryTree.find(50);
        System.out.println("searchResult: " + searchResult);
        assertEquals(null, searchResult);
    }

    @Test
    public void test_binary_tree_get_min() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertRecursive(25);
        binaryTree.insertRecursive(20);
        binaryTree.insertRecursive(15);
        binaryTree.insertRecursive(27);
        binaryTree.insertRecursive(30);
        binaryTree.insertRecursive(29);
        binaryTree.insertRecursive(26);
        binaryTree.insertRecursive(22);
        binaryTree.insertRecursive(32);
        TreeNode min = binaryTree.min();
        System.out.println("min: " + min);
        assertEquals(15, min.getData());
    }

    @Test
    public void test_binary_tree_get_max() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertRecursive(25);
        binaryTree.insertRecursive(20);
        binaryTree.insertRecursive(15);
        binaryTree.insertRecursive(27);
        binaryTree.insertRecursive(30);
        binaryTree.insertRecursive(29);
        binaryTree.insertRecursive(26);
        binaryTree.insertRecursive(22);
        binaryTree.insertRecursive(32);
        TreeNode max = binaryTree.max();
        System.out.println("max: " + max);
        assertEquals(32, max.getData());
    }

    @Test
    public void test_binary_tree_delete_min() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertRecursive(25);
        binaryTree.insertRecursive(20);
        binaryTree.insertRecursive(15);
        binaryTree.insertRecursive(27);
        binaryTree.insertRecursive(30);
        binaryTree.insertRecursive(29);
        binaryTree.insertRecursive(26);
        binaryTree.insertRecursive(22);
        binaryTree.insertRecursive(32);
        binaryTree.insertRecursive(17);
        binaryTree.printTreeSorted();
        System.out.println();
        binaryTree.delete(15);
        binaryTree.printTreeSorted();

    }

    @Test
    public void test_binary_tree_delete_max() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertRecursive(25);
        binaryTree.insertRecursive(20);
        binaryTree.insertRecursive(15);
        binaryTree.insertRecursive(27);
        binaryTree.insertRecursive(30);
        binaryTree.insertRecursive(29);
        binaryTree.insertRecursive(26);
        binaryTree.insertRecursive(22);
        binaryTree.insertRecursive(32);
        binaryTree.insertRecursive(17);
        binaryTree.printTreeSorted();
        System.out.println();
        binaryTree.delete(32);
        binaryTree.printTreeSorted();
    }

    @Test
    public void test_binary_tree_delete_leaf_node() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertRecursive(25);
        binaryTree.insertRecursive(20);
        binaryTree.insertRecursive(15);
        binaryTree.insertRecursive(27);
        binaryTree.insertRecursive(30);
        binaryTree.insertRecursive(29);
        binaryTree.insertRecursive(26);
        binaryTree.insertRecursive(22);
        binaryTree.insertRecursive(32);
        binaryTree.insertRecursive(17);
        binaryTree.printTreeSorted();
        System.out.println();
        binaryTree.delete(17);
        binaryTree.printTreeSorted();
    }

    @Test
    public void test_binary_tree_delete_root() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertRecursive(25);
        binaryTree.insertRecursive(20);
        binaryTree.insertRecursive(15);
        binaryTree.insertRecursive(27);
        binaryTree.insertRecursive(30);
        binaryTree.insertRecursive(29);
        binaryTree.insertRecursive(26);
        binaryTree.insertRecursive(22);
        binaryTree.insertRecursive(32);
        binaryTree.insertRecursive(17);
        binaryTree.insertRecursive(18);
        binaryTree.printTreeSorted();
        System.out.println();
        binaryTree.delete(15);
        binaryTree.printTreeSorted();
    }

    @Test
    public void test_binary_tree_delete_element_not_present() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertRecursive(25);
        binaryTree.insertRecursive(20);
        binaryTree.insertRecursive(15);
        binaryTree.insertRecursive(27);
        binaryTree.insertRecursive(30);
        binaryTree.insertRecursive(29);
        binaryTree.insertRecursive(26);
        binaryTree.insertRecursive(22);
        binaryTree.insertRecursive(32);
        binaryTree.insertRecursive(17);
        binaryTree.insertRecursive(18);
        binaryTree.printTreeSorted();
        System.out.println();
        binaryTree.delete(1234);
        binaryTree.printTreeSorted();
    }
}
