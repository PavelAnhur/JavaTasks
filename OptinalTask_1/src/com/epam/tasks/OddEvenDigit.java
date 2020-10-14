package com.epam.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddEvenDigit {

	int n;
	long[] numbersFromNumbersClass;

	public OddEvenDigit(int n, long[] numbersFromNumbersClass) {
		this.n = n;
		this.numbersFromNumbersClass = numbersFromNumbersClass;
	}

	public void getNumberWithOddAndEvenDigits(long[] numbersFromNumbersClass) {
		List<Long> numbersWithEvenDigits = new ArrayList<>();
		List<Long> numbersWithNotEvenDigits = new ArrayList<>();
		int countOfNumbersWithSameOddAndEvenDigits = 0;
		long[] copyOfNumbers = Arrays.stream(numbersFromNumbersClass, 0, n).toArray();

		for (int i = 0; i < copyOfNumbers.length; i++) {
			long Digit;
			int counterOfDigits = 0;
			int counterOfEvenDigits = 0;
			int counterOfOddDigits = 0;

			while (Math.abs(copyOfNumbers[i]) > 0) {
				counterOfDigits++;
				Digit = copyOfNumbers[i] % 2;
				if (Digit == 0) {
					counterOfEvenDigits++;
				} else {
					counterOfOddDigits++;
				}
				copyOfNumbers[i] /= 10;
			}
			if (counterOfDigits == counterOfEvenDigits) {
				numbersWithEvenDigits.add(numbersFromNumbersClass[i]);
			} else if (counterOfEvenDigits == counterOfOddDigits) {
				countOfNumbersWithSameOddAndEvenDigits++;
			} else {
				numbersWithNotEvenDigits.add(numbersFromNumbersClass[i]);
			}
		}
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
			System.out.println("There are (is) " + countOfNumbersWithSameOddAndEvenDigits + " numbers with +" +
					" equal odd and even digits");
		}
	}
}
