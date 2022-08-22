package com.fizzBuzzSpringApplication.core.implementation;

import com.fizzBuzzSpringApplication.FizzBuzzEnums.FizzBuzzTypeEnum;
import com.fizzBuzzSpringApplication.core.FizzBuzzAbstractHandler;
import com.fizzBuzzSpringApplication.core.IFizzBuzzProcessor;
import org.springframework.stereotype.Component;

import static com.fizzBuzzSpringApplication.core.predicate.FizzBuzzPredictors.isOfFizzType;

/**
 * author - manu roshan
 * date - 20-08-2022
 * FizzHandler class implementation.
 */

@Component
public class FizzHandler extends FizzBuzzAbstractHandler implements IFizzBuzzProcessor {

    @Override
    protected FizzBuzzTypeEnum handleRequest(int number) {
        return process(number);
    }

    @Override
    public FizzBuzzTypeEnum process(int number) {

        return isOfFizzType.test(number) ? FizzBuzzTypeEnum.FIZZ : null;
    }
}
