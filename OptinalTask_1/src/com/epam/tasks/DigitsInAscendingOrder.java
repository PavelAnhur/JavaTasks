package com.epam.tasks;

public class DigitsInAscendingOrder {

	int n;
	long[] numbers;

	public DigitsInAscendingOrder(int n, long[] numbers) {
		this.n = n;
		this.numbers = numbers;
	}

	public long getNumberWithAscendingOrderDigits(long[] numbers) {

		long[] copyOfNumber = new long[n];
		for (int i = 0; i  < numbers.length; i++) {
			copyOfNumber[i] = numbers[i];
		}

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
