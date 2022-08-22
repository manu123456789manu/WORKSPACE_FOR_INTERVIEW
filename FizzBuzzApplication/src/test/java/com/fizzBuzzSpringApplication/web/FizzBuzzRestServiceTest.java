package com.fizzBuzzSpringApplication.web;

import static com.fizzBuzzSpringApplication.core.predicate.FizzBuzzPredictors.isOfBuzzType;
import static com.fizzBuzzSpringApplication.core.predicate.FizzBuzzPredictors.isOfFizzBuzzType;
import static com.fizzBuzzSpringApplication.core.predicate.FizzBuzzPredictors.isOfFizzType;
import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static org.easymock.EasyMock.createStrictControl;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fizzBuzzSpringApplication.FizzBuzzEnums.FizzBuzzTypeEnum;
import com.fizzBuzzSpringApplication.controller.FizzBuzzRestService;
import com.fizzBuzzSpringApplication.service.FizzBuzzService;

public class FizzBuzzRestServiceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	IMocksControl mockMaker = createStrictControl();

	private FizzBuzzService mockFizzBuzzService;

	private FizzBuzzRestService fizzBuzzRestService;

	@Before
	public void setUp() {

		mockFizzBuzzService = mockMaker.createMock(FizzBuzzService.class);
		fizzBuzzRestService = new FizzBuzzRestService(mockFizzBuzzService);
	}

	@Test
	public void fizzBuzzRestServiceTest() {

		expect(mockFizzBuzzService
				.evalNumber(EasyMock.anyInt()))
		.andAnswer(() -> 
		{
			final int funcParameter = (int) EasyMock.getCurrentArguments()[0];

			return Match(funcParameter).of(
					Case($(isOfBuzzType::test), FizzBuzzTypeEnum.BUZZ), 
					Case($(isOfFizzType::test), FizzBuzzTypeEnum.FIZZ),
					Case($(isOfFizzBuzzType::test), FizzBuzzTypeEnum.FIZZBUZZ),  
					Case($(), FizzBuzzTypeEnum.NUMBER));
		}).times(100);

		mockMaker.replay();

		final ResponseEntity<String> response =
				fizzBuzzRestService.next();
	    assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}

