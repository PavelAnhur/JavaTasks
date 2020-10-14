package com.epam.util;

import java.util.Scanner;

public class Numbers {

	private static final Scanner scanner = new Scanner(System.in);
	private static int n;
	private static long[] numbers;
	private int inputValue;

	public Numbers(int n) {
		Numbers.n = n;
		numbers = new long[n];
	}

	public static int getN() {
		return n;
	}

	public static long[] getNumbers() {
		return numbers;
	}

	public void getNumbersFromConsoleInput() {

		for (int i = 0; i < numbers.length; i++) {
			System.out.println("Enter [" + i + "] element of numbers:");
			if (isInputValueIsInteger())
				numbers[i] = inputValue;
		}
	}

	private boolean isInputValueIsInteger() {
		do {
			try {
				inputValue = Integer.parseInt(scanner.next());
				return true;
			} catch (Exception e) {
				System.out.println("Try one more time please, it isn't a number");
			}
		} while (true);
	}

	public void outputNumbersFromConsoleInput() {
		System.out.println("Array of longs from console input");
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}


}
