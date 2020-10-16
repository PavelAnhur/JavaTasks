package com.epam.util;

import java.util.Scanner;

public class Numbers {

	private static final Scanner scanner = new Scanner(System.in);
	private static long[] numbers;
	private long inputValue;

	public Numbers(int n) {
		numbers = new long[n];
	}

	public static long[] getNumbers() {
		return numbers;
	}

	public void getNumbersFromConsoleInput() {

		for (int i = 0; i < numbers.length; i++) {
			System.out.println("Enter [" + i + "] element of numbers:");
			if (isInputValueLongType())
				numbers[i] = inputValue;
		}
	}

	private boolean isInputValueLongType() {
		do {
			try {
				inputValue = Long.parseLong(scanner.next());
				return true;
			} catch (Exception e) {
				System.out.println("Try one more time please, it isn't a number");
			}
		} while (true);
	}

	public void outputNumbersFromConsoleInput() {
		System.out.println("Array of longs from console input");
		for (long number : numbers) {
			System.out.print(number + " ");
		}
		System.out.println();
	}
}
