package com.calculate.calculate.exeptions;

public class ZeroDivideArgument extends IllegalArgumentException {
    public ZeroDivideArgument(String message) {
        super(message);
    }
}
