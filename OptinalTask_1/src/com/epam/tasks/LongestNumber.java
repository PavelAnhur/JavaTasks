package com.epam.tasks;

import java.util.Arrays;

public class LongestNumber {

	int n;
	private final long[] numbers;
	private long longestNumber;
	private int digitOfLongestNumber = 0;

	public LongestNumber(int n, long[] numbersFromNumbersClass) {
		this.n = n;
		this.numbers = numbersFromNumbersClass;
	}

	public long getLongestNumber() {
		long[] copyOfNumbers = new long[n]; //create new array with elements from InputNumbers
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
