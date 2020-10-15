package com.epam.tasks;

import java.util.ArrayList;
import java.util.List;

public class AverageLength {

	int n;
	long[] numbers;

	public AverageLength(int n, long[] numbersFromConsole) {
		this.n = n;
		this.numbers = numbersFromConsole;
	}

	public List<Integer> getLengthOfNumbers() {
		List<Integer> digitsOfNumbers = new ArrayList<>();
		long[] copyOfNumbers = new long[n];
		System.arraycopy(numbers, 0, copyOfNumbers, 0, numbers.length);

		for (int i = 0; i < copyOfNumbers.length; i++) {
			int digit = 0;
			while (Math.abs(copyOfNumbers[i]) > 0) {
				digit++;
				copyOfNumbers[i] /= 10;
			}
			digitsOfNumbers.add(i, digit);
		}
		return digitsOfNumbers;
	}

	public void outputDigits() {  //This method created just for control
		List<Integer> list = getLengthOfNumbers();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Digits of number " + numbers[i] + " = " + list.get(i));
		}
	}

	public int averageDigit(int n, List<Integer> listOfDigits) {
		int averageDigit = 0;
		for (Integer listOfDigit : listOfDigits) {
			averageDigit += listOfDigit;
		}
		return averageDigit / n;
	}

	public void outputNumbersWithDigitsMoreOrLessThenAverage(int averageDigit, List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < averageDigit)
				System.out.println("Number " + numbers[i] + " with " + list.get(i) + " digits " +
						" is number with digits less then average = " + averageDigit);
			if (list.get(i) > averageDigit)
				System.out.println("Number " + numbers[i] + " with " + list.get(i) + " digits " +
						" is number with digits more then average = " + averageDigit);
		}
	}
}
