package com.fizzBuzzSpringApplication.core.implementation;

import com.fizzBuzzSpringApplication.FizzBuzzEnums.FizzBuzzTypeEnum;
import com.fizzBuzzSpringApplication.core.FizzBuzzAbstractHandler;
import com.fizzBuzzSpringApplication.core.IFizzBuzzProcessor;
import org.springframework.stereotype.Component;

import static com.fizzBuzzSpringApplication.core.predicate.FizzBuzzPredictors.isOfBuzzType;

/**
 * author - manu roshan
 * date - 20-08-2022
 * BuzzHandler class implementation.
 */

@Component
public class BuzzHandler extends FizzBuzzAbstractHandler
        implements IFizzBuzzProcessor {

    @Override
    protected FizzBuzzTypeEnum handleRequest(final int number) {
        return process(number);
    }

    @Override
    public FizzBuzzTypeEnum process(final int number) {
        return isOfBuzzType.test(number) ? FizzBuzzTypeEnum.BUZZ : null;
    }
}