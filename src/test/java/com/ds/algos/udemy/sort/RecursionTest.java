package com.ds.algos.udemy.sort;

import com.ds.algos.udemy.sort.recursive.Recursion;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursionTest {

    @Test
    public void test_factorial_iterative() {
        Recursion recursion = new Recursion();
        int factorial = recursion.factorialRecursion(5);
        System.out.println(factorial);
        assertEquals(120, factorial);
    }

    @Test
    public void test_factorial_recursive() {
        Recursion recursion = new Recursion();
        int factorial = recursion.factorialRecursion(5);
        System.out.println(factorial);
        assertEquals(120, factorial);
    }
}
