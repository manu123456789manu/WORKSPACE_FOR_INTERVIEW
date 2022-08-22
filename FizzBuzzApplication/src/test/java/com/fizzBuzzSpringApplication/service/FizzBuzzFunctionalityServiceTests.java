package com.fizzBuzzSpringApplication.service;

import static com.fizzBuzzSpringApplication.core.predicate.FizzBuzzPredictors.isOfBuzzType;
import static com.fizzBuzzSpringApplication.core.predicate.FizzBuzzPredictors.isOfFizzType;
import static com.fizzBuzzSpringApplication.core.predicate.FizzBuzzPredictors.isOfFizzBuzzType;
import static com.fizzBuzzSpringApplication.core.predicate.FizzBuzzPredictors.isNotOfFizzBuzzType;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fizzBuzzSpringApplication.FizzBuzzEnums.FizzBuzzTypeEnum;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzFunctionalityServiceTests {
	
	@Autowired
	private FizzBuzzService fizzBuzzService;
	
	@Test
	public void test_BuzzHandler_functionality(){
		
		final List<Integer> divisibleNumbersBy5 = getOneToHundredNumbers().stream()
				.filter(i -> isOfBuzzType.test(i)).collect(Collectors.toList());
		
		final List<FizzBuzzTypeEnum> fizzBuzzTypes = divisibleNumbersBy5.stream()
				.map(fizzBuzzService::evalNumber)
				.collect(Collectors.toList());
		
		Assertions.assertSame(divisibleNumbersBy5.size(), fizzBuzzTypes.size());
		assertThat(fizzBuzzTypes, everyItem(is(FizzBuzzTypeEnum.BUZZ)));
		
	}

	
	@Test
	public void test_FizzHandler_functionality(){
		
		final List<Integer> divisibleNumbersBy3 = getOneToHundredNumbers().stream()
				.filter(i -> isOfFizzType.test(i)).collect(Collectors.toList());
		
		final List<FizzBuzzTypeEnum> fizzBuzzTypes = divisibleNumbersBy3.stream()
				.map(fizzBuzzService::evalNumber)
				.collect(Collectors.toList());
		
		Assertions.assertSame(divisibleNumbersBy3.size(), fizzBuzzTypes.size());
		assertThat(fizzBuzzTypes, everyItem(is(FizzBuzzTypeEnum.FIZZ)));
		
	}
	
	@Test
	public void test_FizzBuzzHandler_functionality(){
		
		final List<Integer> divisibleNumbersBy3And5 = getOneToHundredNumbers().stream()
				.filter(i -> isOfFizzBuzzType.test(i)).collect(Collectors.toList());
		
		final List<FizzBuzzTypeEnum> fizzBuzzTypes = divisibleNumbersBy3And5.stream()
				.map(fizzBuzzService::evalNumber)
				.collect(Collectors.toList());
		
		Assertions.assertSame(divisibleNumbersBy3And5.size(), fizzBuzzTypes.size());
		assertThat(fizzBuzzTypes, everyItem(is(FizzBuzzTypeEnum.FIZZBUZZ)));
		
	}
	
	@Test
	public void test_NumberHandler_functionality(){
		
		final List<Integer> nonFizzBuzzType = getOneToHundredNumbers().stream()
				.filter(i -> isNotOfFizzBuzzType.test(i)).collect(Collectors.toList());
		
		final List<FizzBuzzTypeEnum> fizzBuzzTypes = nonFizzBuzzType.stream()
				.map(fizzBuzzService::evalNumber)
				.collect(Collectors.toList());
		
		Assertions.assertSame(nonFizzBuzzType.size(), fizzBuzzTypes.size());
		assertThat(fizzBuzzTypes, everyItem(is(FizzBuzzTypeEnum.NUMBER)));
		
	}


	public List<Integer> getOneToHundredNumbers(){
		
		return Stream.iterate(1, n -> n + 1)
		.limit(100)
		.collect(Collectors.toList());	
	}
}
