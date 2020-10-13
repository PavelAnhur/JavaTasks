package com.epam;

public class ShortestNumber extends InputNumbers{

	private long[] numbersFromInputNumbersClass;
	private long shortestNumber;
	private int digitOfShortestNumber;


	public ShortestNumber(int n, long[] numbersInputNumbersClass) { //constructor for ShortestNumber object
		super(n);
		this.numbersFromInputNumbersClass = numbersInputNumbersClass;
	}

	public long getShortestNumber() {
		long[] array = new long[n];
		for (int i=0; i < array.length; i++)          //create new array with elements from InputNumbers
			array[i]=numbersFromInputNumbersClass[i];
		for (int i = 0; i < array.length; i++) {
			int digit = 0;
			while (array[i] > 0) {
				digit++;
				array[i] /= 10;
			}
			if (i == 0) digitOfShortestNumber = digit;
			else if (digitOfShortestNumber >= digit) {
				shortestNumber = numbersFromInputNumbersClass[i];
				digitOfShortestNumber = digit;
				return shortestNumber;
			}
		}
		return shortestNumber;
	}

	public int getDigitOfShortestNumber() {
		return digitOfShortestNumber;
	}
}
