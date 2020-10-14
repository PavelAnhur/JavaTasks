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
		long[] copyOfInputNumbersArray = new long[n]; //create new array with elements from InputNumbers
		Arrays.setAll(copyOfInputNumbersArray, i -> numbers[i]);

		for (int i = 0; i < copyOfInputNumbersArray.length; i++) {
			int digit = 0;
			while (Math.abs(copyOfInputNumbersArray[i]) > 0) {
				digit++;
				copyOfInputNumbersArray[i] /= 10;
			}
			if (i == 0) {
				digitOfLongestNumber = digit;
				longestNumber = numbers[i];
			} else if (digitOfLongestNumber <= digit) {
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
