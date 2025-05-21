package com.merzmostafaei.exceptions;

import java.io.IOException;

public class Account {
    public void deposit(float value) throws IOException {
        if(value <= 0)
//            throw new IllegalArgumentException();
            throw new IOException();
    }
    //Custom Exception
    private float balance;
    public void withdraw(float value) throws InsufficientFundsException {

        if (value > balance )
            throw new InsufficientFundsException();
    }
}
