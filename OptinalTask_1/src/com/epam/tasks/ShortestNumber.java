package com.epam.tasks;

import com.epam.util.Numbers;

import java.util.Arrays;

public class ShortestNumber {

	int n;
	long[] numbersFromInputNumbersClass;
	private long shortestNumber;
	private int digitOfShortestNumber;


	public ShortestNumber(int n, long[] numbersInputNumbersClass) { //constructor for ShortestNumber object
		this.n = n;
		this.numbersFromInputNumbersClass = numbersInputNumbersClass;
	}

	public long getShortestNumber() {
		int n = Numbers.getN();
		long[] copyOfInputNumbersArray = new long[n];  //create new array with elements from InputNumbers
		Arrays.setAll(copyOfInputNumbersArray, i -> numbersFromInputNumbersClass[i]);

		for (int i = 0; i < copyOfInputNumbersArray.length; i++) {
			int digit = 0;
			while (Math.abs(copyOfInputNumbersArray[i]) > 0) {
				digit++;
				copyOfInputNumbersArray[i] /= 10;
			}
			if (i == 0) {
				digitOfShortestNumber = digit;
				shortestNumber = numbersFromInputNumbersClass[i];
			} else if (digitOfShortestNumber >= digit) {
				shortestNumber = numbersFromInputNumbersClass[i];
				digitOfShortestNumber = digit;
			}
		}
		return shortestNumber;
	}

	public int getDigitOfShortestNumber() {
		return digitOfShortestNumber;
	}
}
