package com.ds.algos.udemy.array;

import java.util.Arrays;

public class DynamicArray<T> {
    private int size;
    private Object[] array;
    private static final int DEFAULT_SIZE = 5;

    public DynamicArray() {
        array = new Object[DEFAULT_SIZE];
    }

    public DynamicArray(int size) {
        array = (size>0) ? new Object[size] : new Object[DEFAULT_SIZE];
    }

    public void insert(T value) {
        if(size == array.length) {
            resize();
        }
        array[size++] = value;
    }

    public Object get(int index){
        if(index >= array.length)
            throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }

    public Object removeAt(int index) {
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException();
        Object removedItem = array[index];
        System.arraycopy(array, index+1, array, index, array.length - (index+1));
        array[--size] = null;
        return removedItem;
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) return i;
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    @Override
    public String toString() {
        return "Array{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", length=" + array.length +
                '}';
    }

    private void resize() {
        Object[] temp = array;
        array = new Object[size * 2];
        System.arraycopy(temp,0, array, 0, size);
    }

    // TODO: Add tests for dynamic array
    public static void main(String[] args) {
        DynamicArray<Integer> integers = new DynamicArray<>(3);
        integers.insert(10);
        integers.insert(20);
        integers.insert(30);
        integers.insert(40);
        integers.insert(50);
        integers.insert(60);
        System.out.println(integers.toString());
        integers.removeAt(3);
        //integers.insert(30);
        System.out.println(integers.toString());
        System.out.println(integers.indexOf(100));

        DynamicArray<String> books = new DynamicArray<>(3);
        books.insert("Think and grow rich");
        books.insert("The Miracle Morning");
        books.insert("HarryPotter");

        books.removeAt(0);
        System.out.println(books.toString());
        System.out.println(books.indexOf("The Miracle Morning"));
    }
}
