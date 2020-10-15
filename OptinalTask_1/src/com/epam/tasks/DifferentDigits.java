package com.epam.tasks;

import java.util.Arrays;

public class DifferentDigits {

	int n;
	long[] numbers;

	public DifferentDigits(int n, long[] numbers) {
		this.n = n;
		this.numbers = numbers;
	}

	public void getNumberWithLessValueOfDifferentDigits() {
		String[] copyOfNumbersInString = getCopyOfArray(numbers);

		int[] differentDigitsInNumber = getCountOfDifferentDigitsForEachNumber(copyOfNumbersInString);

		int index = 0;
		int minValueOfDifferentDigits = differentDigitsInNumber[0];
		for (int i = 1; i < differentDigitsInNumber.length; i++) {
			if (minValueOfDifferentDigits >= differentDigitsInNumber[i]) {
				minValueOfDifferentDigits = differentDigitsInNumber[i];
				index = i;
			}
		}
		System.out.println("Number with less different digits " + copyOfNumbersInString[index]);
	}

	private String[] getCopyOfArray(long[] numbers){
		String[] copyOfNumbersInString = new String[n];
		for (int i = 0; i < numbers.length; i++) {
			copyOfNumbersInString[i] = String.valueOf((numbers[i]));
		}
		return copyOfNumbersInString;
	}

	private int[] getCountOfDifferentDigitsForEachNumber(String[] numbersInStringType){
		int[] differentDigitsInNumber = new int[n];
		for (int i = 0;i < numbersInStringType.length; i++) {

			int equalDigit = 0;
			int counterOfDigits = 0;

			for (int j = 0; j < numbersInStringType[i].length(); j++) {
				counterOfDigits++;
				if (numbersInStringType[i].charAt(i) == numbersInStringType[i].charAt(j)) {
					equalDigit++;
				}
			}
			differentDigitsInNumber[i] = counterOfDigits - equalDigit;
		}
		return differentDigitsInNumber;
	}

	public long getNumberWithDifferentDigitsOnly() {
		long[] copyOfNumbers = Arrays.stream(numbers, 0, n).toArray();

		for (int i = 0; i < copyOfNumbers.length; i++) {
			int digit, previousDigit = (int) (copyOfNumbers[i] % 10);

			while (copyOfNumbers[i] > 0) {
				copyOfNumbers[i] /= 10;
				digit = (int) (copyOfNumbers[i] % 10);
				if (previousDigit == digit) {
					break;
				}
				previousDigit = digit;
			}
			if (copyOfNumbers[i] == 0) {
				return numbers[i];
			}
		}
		return -1;
	}
}
