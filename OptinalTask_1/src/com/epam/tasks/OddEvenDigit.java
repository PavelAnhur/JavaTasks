package com.epam.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddEvenDigit {

	int numberOfElementsInArray;
	long[] numbers;
	private final List<Long> numbersWithEvenDigits = new ArrayList<>();
	private final List<Long> numbersWithNotEvenDigits = new ArrayList<>();
	private int countOfNumbersWithSameOddAndEvenDigits = 0;


	public OddEvenDigit(int numberOfElementsInArray, long[] numbers) {
		this.numberOfElementsInArray = numberOfElementsInArray;
		this.numbers = numbers;
	}

	public void getNumberWithOddAndEvenDigits() {
		sortNumberWithOddAndEvenDigits();
		outputNumbersInConsole();
	}


	private void outputNumbersInConsole() {
		if (numbersWithEvenDigits.size() != 0) {
			for (Long numbersWithEvenDigit : numbersWithEvenDigits) {
				System.out.println("Number with all even digits : " + numbersWithEvenDigit);
			}
		} else {
			System.out.println("There is no numbers with only even digits");
		}
		if (numbersWithNotEvenDigits.size() != 0) {
			for (Long numbersWithNotEvenDigit : numbersWithNotEvenDigits) {
				System.out.println("Number with odd digit(s) : " + numbersWithNotEvenDigit);
			}
		}
		if (countOfNumbersWithSameOddAndEvenDigits != 0) {
			System.out.println("There are (is) " + countOfNumbersWithSameOddAndEvenDigits + " number(s) with " +
					" equal value odd and even digits");
		}
	}

	private void sortNumberWithOddAndEvenDigits() {
		long[] copyOfNumbers = Arrays.stream(numbers, 0, numberOfElementsInArray).toArray();

		for (int i = 0; i < copyOfNumbers.length; i++) {
			int counterOfDigits = 0;
			int counterOfEvenDigits = 0;
			int counterOfOddDigits = 0;
			int digit;
			while (Math.abs(copyOfNumbers[i]) > 0) {
				counterOfDigits++;
				digit = (int) (copyOfNumbers[i] % 2);
				if (digit == 0) {
					counterOfEvenDigits++;
				} else {
					counterOfOddDigits++;
				}
				copyOfNumbers[i] /= 10;
			}
			if (counterOfDigits == counterOfEvenDigits) {
				numbersWithEvenDigits.add(numbers[i]);
			} else if (counterOfEvenDigits == counterOfOddDigits) {
				countOfNumbersWithSameOddAndEvenDigits++;
			} else {
				numbersWithNotEvenDigits.add(numbers[i]);
			}
		}
	}
}
