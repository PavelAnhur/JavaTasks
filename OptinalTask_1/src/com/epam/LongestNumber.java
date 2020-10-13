package com.epam;

import java.util.Arrays;

public class LongestNumber extends InputNumbers {

	private long[] numbersFromInputNumbersClass;
	private long longestNumber;
	private int digitOfLongestNumber = 0;

	public LongestNumber(int n, long[] numbersInputNumbersClass) {
		super(n);
		this.numbersFromInputNumbersClass = numbersInputNumbersClass;
	}

	public long getLongestNumber() {
		long[] copyOfInputNumbersArray = new long[n]; //create new array with elements from InputNumbers
		Arrays.setAll(copyOfInputNumbersArray, i -> numbersFromInputNumbersClass[i]);

		for (int i = 0; i < copyOfInputNumbersArray.length; i++) {
			int digit = 0;
			while (copyOfInputNumbersArray[i] > 0) {
				digit++;
				copyOfInputNumbersArray[i] /= 10;
			}
			if (i == 0) {
				digitOfLongestNumber = digit;
				longestNumber = numbersFromInputNumbersClass[i];
			} else if (digitOfLongestNumber <= digit) {
				longestNumber = numbersFromInputNumbersClass[i];
				digitOfLongestNumber = digit;
			}
		}
		return longestNumber;
	}

	public int getDigitOfLongestNumber() {
		return digitOfLongestNumber;
	}
}
