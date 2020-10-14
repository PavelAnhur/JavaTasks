package com.epam.tasks;

public class DifferentDigits {

	int n;
	long[] numbersFromNumbersClass;

	public DifferentDigits(int n, long[] numbers) {
		this.n = n;
		this.numbersFromNumbersClass = numbers;
	}

	public void numberWithLessValueOfDifferentDigits(long[] numbers) {
		String[] copyOfNumbersInString = new String[n];
		for (int i = 0; i < numbers.length; i++) {
			copyOfNumbersInString[i] = String.valueOf((numbers[i]));
		}

		int[] differentDigitsInNumber = new int[n];
		for (int i = copyOfNumbersInString.length - 1; i > 0; i--) {

			int equalDigit = 0;
			int counterOfDigits = 0;

			for (int j = 0; j < copyOfNumbersInString[i].length(); j++) {
				counterOfDigits++;
				if (copyOfNumbersInString[i].charAt(i) == copyOfNumbersInString[i].charAt(j)) {
					equalDigit++;
				}
			}
			differentDigitsInNumber[i] = counterOfDigits - equalDigit;
		}
		int index = 0;
		int minValueOfDifferentDigits = 0;
		for (int i = differentDigitsInNumber.length - 1; i > 0; i--) {
			if (i == differentDigitsInNumber.length - 1) {
				minValueOfDifferentDigits = differentDigitsInNumber[i];
				index = i;
			} else if (minValueOfDifferentDigits >= differentDigitsInNumber[i]) {
				minValueOfDifferentDigits = differentDigitsInNumber[i];
				index = i;
			}
		}
		System.out.println("Number with less different digits " + copyOfNumbersInString[index]);
	}

}
