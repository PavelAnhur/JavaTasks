package com.epam.tasks;

public class DifferentDigits {

	int n;
	long[] numbersFromNumbersClass;

	public DifferentDigits(int n, long[] numbers) {
		this.n = n;
		this.numbersFromNumbersClass = numbers;
	}

	public void howManySeparateDigitsAreEqual(long[] numbers) {
		String[] copyOfNumbersInString = new String[n];

		for (int i = 0; i < numbers.length; i++) {
			copyOfNumbersInString[i] = String.valueOf((numbers[i]));
		}
		int numberWithEqualDigits = Integer.MAX_VALUE;
		int minValueOfDifferentDigits = 0;
		for (int i = copyOfNumbersInString.length - 1; i >= 0; i--) {
			int equalDigit = 0;
			for (int j = 0; j < copyOfNumbersInString[i].length(); j++) {
				if (copyOfNumbersInString[i].charAt(i) != copyOfNumbersInString[i].charAt(j)) {
					equalDigit++;
				}
			}
			if (equalDigit <= minValueOfDifferentDigits) {
				minValueOfDifferentDigits = equalDigit;
				numberWithEqualDigits = Integer.parseInt(copyOfNumbersInString[i]);
			}
		}
		System.out.println("Number with less different digits " + numberWithEqualDigits);
	}

}
