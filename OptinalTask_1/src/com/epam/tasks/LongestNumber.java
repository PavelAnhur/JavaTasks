package com.epam.tasks;

import java.util.Arrays;

public class LongestNumber {

	int numberOfElementsInArray;
	private final long[] numbers;
	private long longestNumber;
	private int digitOfLongestNumber = 0;

	public LongestNumber(int numberOfElementsInArray, long[] numbersFromNumbersClass) {
		this.numberOfElementsInArray = numberOfElementsInArray;
		this.numbers = numbersFromNumbersClass;
	}

	public long getLongestNumber() {
		long[] copyOfNumbers = new long[numberOfElementsInArray]; //create new array with elements from InputNumbers
		Arrays.setAll(copyOfNumbers, i -> numbers[i]);

		digitOfLongestNumber = 0;
		for (int i = 0; i < copyOfNumbers.length; i++) {
			int digit = 0;
			while (Math.abs(copyOfNumbers[i]) > 0) {
				digit++;
				copyOfNumbers[i] /= 10;
			}
			if (digitOfLongestNumber <= digit) {
				longestNumber = numbers[i];
				digitOfLongestNumber = digit;
			}
		}
		return longestNumber;
	}

	public int getDigitOfLongestNumber() {
		return digitOfLongestNumber;
	}
}
