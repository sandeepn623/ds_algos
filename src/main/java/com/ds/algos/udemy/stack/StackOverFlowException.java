package com.ds.algos.udemy.stack;

public class StackOverFlowException extends RuntimeException{

    private static String message = StackOverFlowException.class.getName();

    public StackOverFlowException() {
        super(message);
    }

    public StackOverFlowException(String message){super(message);}
}

