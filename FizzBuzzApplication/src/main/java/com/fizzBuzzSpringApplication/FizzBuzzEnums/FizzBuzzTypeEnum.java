package com.fizzBuzzSpringApplication.FizzBuzzEnums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by manu roshan on 20/08/2022.
 */
public enum FizzBuzzTypeEnum {

    NUMBER("Fizz buzz type for number"),
    BUZZ("Fizz buzz type for buzz"),
    FIZZBUZZ("Fizz buzz type for fizzbuzz"),
    FIZZ("Fizz buzz type for fizz");

    private final String description;

    FizzBuzzTypeEnum(final String description) {

        this.description = description;
    }

    public static List<FizzBuzzTypeEnum> findAllFizzBuzzTypes() {

        return Arrays.stream(FizzBuzzTypeEnum.values())
                .collect(Collectors.toList());
    }

    public String getDescription() {

        return description;
    }
}
