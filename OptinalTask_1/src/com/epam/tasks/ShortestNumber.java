package com.epam.tasks;

import com.epam.util.Numbers;
import java.util.Arrays;

public class ShortestNumber {

	int n;
	long[] numbers;
	private long shortestNumber;
	private int digitOfShortestNumber;


	public ShortestNumber(int n, long[] numbersInputNumbersClass) { //constructor for ShortestNumber object
		this.n = n;
		this.numbers = numbersInputNumbersClass;
	}

	public long getShortestNumber() {
		int n = Numbers.getN();
		long[] copyOfInputNumbersArray = new long[n];  //create new array with elements from InputNumbers
		Arrays.setAll(copyOfInputNumbersArray, i -> numbers[i]);

		for (int i = 0; i < copyOfInputNumbersArray.length; i++) {
			int digit = 0;
			while (Math.abs(copyOfInputNumbersArray[i]) > 0) {
				digit++;
				copyOfInputNumbersArray[i] /= 10;
			}
			if (i == 0) {
				digitOfShortestNumber = digit;
				shortestNumber = numbers[i];
			} else if (digitOfShortestNumber >= digit) {
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
