package com.ds.algos.udemy.stack;

public class StackOverFlowException extends RuntimeException{

    private static final String message = StackOverFlowException.class.getName();

    public StackOverFlowException() {
        super(message);
    }
}

