package com.fizzBuzzSpringApplication.core;

import com.fizzBuzzSpringApplication.FizzBuzzEnums.FizzBuzzTypeEnum;

public abstract class FizzBuzzAbstractHandler {

    protected FizzBuzzAbstractHandler nextHandler;

    protected abstract FizzBuzzTypeEnum handleRequest(final int number);

    public FizzBuzzTypeEnum receiveRequest(final int number) {
        final FizzBuzzTypeEnum fizzBuzzType = handleRequest(number);
        return (fizzBuzzType != null) ? fizzBuzzType : nextHandler.receiveRequest(number);
    }

    public void setNextHandler(final FizzBuzzAbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

}
