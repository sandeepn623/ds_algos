package com.ds.algos.udemy.heap;

public class Heap {

    private int[] heap;

    private int capacity;

    private int size;

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);
        heap.printHeap();
        heap.heapSort();
        heap.printHeap();
    }

    public Heap(int size) {
        heap = new int[size];
        capacity = heap.length;
    }

    //T(n) = O(log n)
    public void insert(int value) {
        if(isFull()){
            throw new IndexOutOfBoundsException();
        }
        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    // O(log n) random item is O(n log n)
    public int delete(int index) {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int parent = getParent(index);
        int deletedItem = heap[index];
        heap[index] = heap[size-1];
        if(index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size-1);
        } else {
            fixHeapAbove(index);
        }
        heap[size-1] = 0;
        size--;
        return deletedItem;
    }

    public int peek() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return heap[0];
    }

    //O(n log n)
    public void heapSort() {
        int lastIndex = size - 1;
        for (int i = 0; i < lastIndex ; i++) {
            swap(0, lastIndex-i);

            fixHeapBelow(0, lastIndex -i - 1);
        }
    }
    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getParent(int index) {
        return (index-1)/2;
    }

    private void fixHeapAbove(int index) {
        int newValue=heap[index];
        while(index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;
        // check until last index
        while(index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            // to check if the left child exists
            if(leftChild <= lastHeapIndex) {
                // this check if there is no right child
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    // if there is right child then choose the greater of the 2.
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
                }
                // swap only if the replacement value is less then the child to swap.
                if (heap[index] < heap[childToSwap]) {
                    swap(index, childToSwap);
                } else {
                    break;
                }
                //update the index to child to swap as the replacement value has been swapped and we need to continue with the check
                index = childToSwap;
            } else {
                break;
            }
        }
    }

    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }

    private void fixHeapAboveRecursive(int current) {
        if(current == 0) {
            return;
        }
        int parent = getParent(current);
        if(heap[current] > heap[parent]) {
            swap(parent, current);
        }
        fixHeapAboveRecursive(parent);
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void resize() {
        int[] temp = new int[2*capacity];
        System.arraycopy(heap, 0, temp, 0, capacity);
        heap = temp;
        capacity = heap.length;
    }

    public void printHeap() {
        for (int i = 0; i < size ; i++) {
            System.out.print(heap[i]);
            if(i < size-1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
