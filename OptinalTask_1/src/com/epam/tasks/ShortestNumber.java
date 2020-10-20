package com.epam.tasks;

import java.util.Arrays;

public class ShortestNumber {

	int numberOfElementsInArray;
	long[] numbers;
	private long shortestNumber;
	private int digitOfShortestNumber;


	public ShortestNumber(int numberOfElementsInArray, long[] numbersInputNumbersClass) { //constructor for ShortestNumber object
		this.numberOfElementsInArray = numberOfElementsInArray;
		this.numbers = numbersInputNumbersClass;
	}

	public long getShortestNumber() {
		long[] copyOfNumbers = new long[numberOfElementsInArray];  //create new array with elements from InputNumbers
		Arrays.setAll(copyOfNumbers, i -> numbers[i]);

		digitOfShortestNumber = 19; // max length of long number
		for (int i = 0; i < copyOfNumbers.length; i++) {
			int digit = 0;
			while (Math.abs(copyOfNumbers[i]) > 0) {
				digit++;
				copyOfNumbers[i] /= 10;
			}
			 if (digitOfShortestNumber >= digit) {
				shortestNumber = numbers[i];
				digitOfShortestNumber = digit;
			}
		}
		return shortestNumber;
	}

	public int getDigitOfShortestNumber() {
		return digitOfShortestNumber;
	}
}
