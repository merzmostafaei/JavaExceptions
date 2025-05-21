package com.merzmostafaei.exceptions;

import java.io.IOException;

public class Account {
    public void deposit(float value) throws IOException {
        if(value <= 0)
//            throw new IllegalArgumentException();
            throw new IOException();
    }
    //Custom Exception
//    private float balance;
//    public void withdraw(float value) throws InsufficientFundsException {
//
//        if (value > balance )
//            throw new InsufficientFundsException();
//    }
    //Chaining Exception
    private float balance;
    public void withdraw(float value) throws  AccountException {

        if (value > balance ){
//            var fundsException = new InsufficientFundsException();
//            --when we use the cause throw abale object in Account Exception we dont need to create this object again
//            var accountException = new AccountException();
//            accountException.initCause(fundsException);
//            --we use it in AccountException class.
//            throw accountException;
            throw new AccountException(new InsufficientFundsException());
        }

    }
}
