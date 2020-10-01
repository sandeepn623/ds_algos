package com.ds.algos.udemy.sort;

public class Recursion {

    public int factorialIterative(int num) {
        if(num == 0 || num == 1)
            return 1;
        int factorial = 1;
        for(int i = 1; i <= num; i++){
            factorial *= i;
        }
        return factorial;
    }

    public int factorialRecursion(int num) {
        if(num == 0)
            return 1;
        return num * factorialRecursion(num - 1);
    }
}
