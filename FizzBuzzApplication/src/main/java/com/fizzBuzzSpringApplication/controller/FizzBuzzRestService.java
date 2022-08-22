package com.fizzBuzzSpringApplication.controller;

import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fizzBuzzSpringApplication.service.FizzBuzzService;

/**
 * author - manu roshan
 * date - 20-08-2022
 * FizzBuzzHandler class implementation.
 */

@RestController
@RequestMapping(path = "/fizz-buzz-process")
public class FizzBuzzRestService {

	final Logger logger = LoggerFactory.getLogger(FizzBuzzService.class);

	final String newLineChar = "\n";

	private final FizzBuzzService fizzBuzzService;

	@Autowired
	public FizzBuzzRestService(final FizzBuzzService fizzBuzzService){
		this.fizzBuzzService = fizzBuzzService;
	}

	@RequestMapping(
			path = "/process",
			method = RequestMethod.GET)
	public ResponseEntity<String> next() {

		logger.info("Invoking FizzBuzz endpoint");

		final StringBuilder outputString = new StringBuilder("");

		IntStream.range(1, 101)
		.forEach(i -> outputString.append(newLineChar).append(fizzBuzzService.evalNumber(i)));

		logger.info("Endpoint result is:" + outputString);

		return ResponseEntity.status(HttpStatus.OK)
				.body(String.valueOf(outputString));
	}
}
