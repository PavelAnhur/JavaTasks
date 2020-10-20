package com.epam.tasks;

import java.util.stream.IntStream;

public class DigitsInAscendingOrder {

	int numberOfElementsInArray;
	long[] numbers;

	public DigitsInAscendingOrder(int numberOfElementsInArray, long[] numbers) {
		this.numberOfElementsInArray = numberOfElementsInArray;
		this.numbers = numbers;
	}

	public long getNumberWithAscendingOrderDigits() {

		long[] copyOfNumber = new long[numberOfElementsInArray];
		IntStream.range(0, numbers.length).forEachOrdered(i -> copyOfNumber[i] = numbers[i]);

		for (int i = 0; i < copyOfNumber.length; i++) {

			int digit, previousDigit = (int) (copyOfNumber[i] % 10);

			while (copyOfNumber[i] > 0) {
				copyOfNumber[i] /= 10;
				digit = (int) (copyOfNumber[i] % 10);
				if (previousDigit < digit) {
					break;
				}
				previousDigit = digit;
			}
			if (copyOfNumber[i] == 0) {
				return numbers[i];
			}
		}
		return -1;
	}
}
