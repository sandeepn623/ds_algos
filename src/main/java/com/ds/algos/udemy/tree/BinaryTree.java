package com.ds.algos.udemy.tree;


import java.util.Comparator;

public class BinaryTree<T> {

    private TreeNode<T> root;


    //insert
    //traversal - level, pre-order, post-order, in-order
    //find/search
    //min value
    //max value
    //delete - node is a leaf, node has one child, node has 2 children.



    // itreative approach
    public void insertIterative(T data) {
        TreeNode<T> newNode = new TreeNode<>(data);
        if (isEmpty()) {
            root = newNode;
        } else {
            root.insertIterative(data);
        }
    }

    public void insertRecursive(T data) {
        TreeNode<T> newNode = new TreeNode<>(data);
        if (isEmpty()) {
            root = newNode;
        } else {
            root.insertRecursive(data);
        }
    }

    public TreeNode<T> find(T data) {
        if(!isEmpty()) {
            return root.get(data);
        }
        return null;
    }

    public TreeNode min(){
        if(!isEmpty()) {
            return root.getMin();
        }
        return null;
    }

    public TreeNode max(){
        if(!isEmpty()) {
            return root.getMax();
        }
        return null;
    }

    private Comparator comparator = Comparator.naturalOrder();

    void delete(T data) {
        delete(root, data);
    }

    /**
     * 1. Leaf node possible cases
     *  a. the given value could be min or max, if yes simply delete them.
     *  b. in other cases find the leaf node and delete if exists.
     * 2. if the node has one child, replace the node with the child.
     * 3. If the node has 2 children.
     *
     */
    private TreeNode delete(TreeNode subtreeRoot, T data) {
        if(subtreeRoot == null) {
            return null;
        }

        if(comparator.compare(data, subtreeRoot.getData()) < 0) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), data));
        } else if(comparator.compare(data, subtreeRoot.getData()) > 0) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), data));
        } else {
            // case 1 and 2 leaf node and the node to delete has one child.
            if(subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            } else if(subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }
            //case 3 when node to delete has 2 children
            // if traversing right find the min value and replace the subtree with the data.
            subtreeRoot.setData(subtreeRoot.getRightChild().getMin().getData());
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), (T) subtreeRoot.getData()));
        }
        return subtreeRoot;
    }
    public boolean isEmpty() {
        return root == null;
    }

    public void printTree() {
        if(!isEmpty()) {
            root.customTraversePreOrder(null, root, TreeNode.NodeType.CENTER);
        } else {
            System.out.println("Empty tree!");
        }
    }

    public void printTreeSorted() {
        if(!isEmpty()) {
            root.traverseInOrder();
        } else {
            System.out.println("Empty tree!");
        }
    }

    public void traversePreOrder() {
        if(!isEmpty()) {
            root.traversePreOrder();
        } else {
            System.out.println("Empty tree!");
        }
    }
}
