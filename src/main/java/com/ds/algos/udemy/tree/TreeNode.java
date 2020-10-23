package com.ds.algos.udemy.tree;

import lombok.Data;

import java.util.Comparator;
import java.util.Objects;

@Data
public class TreeNode<T> {

    private T data;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    private Comparator comparator = Comparator.naturalOrder();

    public TreeNode(T data) {
        this.data = data;
    }

    public void insertIterative(T data) {
        TreeNode<T> newNode = new TreeNode<>(data);
        TreeNode<T> current = this;
        while (current != null) {
            if(comparator.compare(data, current.getData()) == 0) {
                break;
            } else if (comparator.compare(data, current.getData()) < 0) {
                if(current.getLeftChild() == null)
                {
                    current.setLeftChild(newNode);
                    break;
                }
                current = current.getLeftChild();
            } else {
                if(current.getRightChild() == null)
                {
                    current.setRightChild(newNode);
                    break;
                }
                current = current.getRightChild();
            }
        }
    }

    public void insertRecursive(T data) {
        if (comparator.compare(data, this.data) < 0) {
            if(leftChild == null) {
                leftChild = new TreeNode<>(data);;
            } else {
                leftChild.insertRecursive(data);
            }
        } else {
            if(rightChild == null) {
                rightChild = new TreeNode<>(data);;
            } else {
                rightChild.insertRecursive(data);
            }
        }
    }

    public TreeNode<T> get(T data) {
        if(comparator.compare(data, this.data) == 0) {
            return this;
        } else if(comparator.compare(data,this.data) < 0 && leftChild != null) {
            return leftChild.get(data);
        } else if(rightChild != null) {
            return rightChild.get(data);
        } else {
            return null;
        }
    }

    protected TreeNode<T> getMin(){
        if(leftChild == null) {
            return this;
        } else {
            return leftChild.getMin();
        }
    }

    protected TreeNode<T> getMax() {
        if(rightChild == null) {
           return this;
        } else {
            return rightChild.getMax();
        }
    }

    //visit root of every subtree first
    public void customTraversePreOrder(TreeNode<T> parent, TreeNode<T> current, NodeType nodeType) {
        if(current == null) {
            return;
        }
        System.out.println(nodeType + " " + current.getData() + " " + ((parent != null) ? parent.getData():""));
        customTraversePreOrder(current, current.getLeftChild(), NodeType.LEFT);
        customTraversePreOrder(current, current.getRightChild(), NodeType.RIGHT);
    }

    // visit left child, then root, then right child.
    public void traverseInOrder() {
        if(leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.print(data + " ");
        if(rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    // visit the root, then left child, then right child.
    public void traversePreOrder() {
        System.out.print(data + " ");
        if(leftChild != null) {
            leftChild.traversePreOrder();
        }
        if(rightChild != null) {
            rightChild.traversePreOrder();
        }
    }

    // visit the left child, then right child and root at the last
    public void traversePostOrder() {
        if(leftChild != null) {
            leftChild.traversePostOrder();
        }
        if(rightChild != null) {
            rightChild.traversePostOrder();
        }
        System.out.print(data + " ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> node = (TreeNode<?>) o;
        return data.equals(node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public enum NodeType {
        CENTER("C"),
        LEFT("L"),
        RIGHT("R");

        private final String type;

        NodeType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }
}
