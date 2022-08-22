package com.fizzBuzzSpringApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fizzBuzzSpringApplication.FizzBuzzEnums.FizzBuzzTypeEnum;
import com.fizzBuzzSpringApplication.core.FizzBuzzAbstractHandler;
import com.fizzBuzzSpringApplication.core.implementation.BuzzHandler;
import com.fizzBuzzSpringApplication.core.implementation.FizzBuzzHandler;
import com.fizzBuzzSpringApplication.core.implementation.FizzHandler;
import com.fizzBuzzSpringApplication.core.implementation.NumberHandler;

@Service
public class FizzBuzzService {

	FizzBuzzAbstractHandler handler;

	@Autowired
	public FizzBuzzService(
			final FizzHandler fizzHandler,
			final BuzzHandler buzzHandler,
			final FizzBuzzHandler fizzBuzzHandler,
			final NumberHandler numberHandler
			) {
		fizzHandler.setNextHandler(buzzHandler);
		buzzHandler.setNextHandler(fizzBuzzHandler);
		fizzBuzzHandler.setNextHandler(numberHandler);
		this.handler = fizzHandler;
	}

	public FizzBuzzTypeEnum evalNumber(final int number) {
				
		return handler.receiveRequest(number);
	}

}
