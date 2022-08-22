package com.fizzBuzzSpringApplication.core.predicate;

import java.util.function.IntPredicate;

public class FizzBuzzPredictors {

	public static final IntPredicate isOfFizzType = num -> num % 3 == 0 && num % 5 != 0;

	public static final IntPredicate isOfBuzzType = num -> num % 3 != 0 && num % 5 == 0;

	public static final IntPredicate isOfFizzBuzzType = num -> num % 3 == 0 && num % 5 == 0;

	public static final IntPredicate isNotOfFizzBuzzType = num -> num % 3 != 0 && num % 5 != 0;

	private FizzBuzzPredictors() {
	}

}
