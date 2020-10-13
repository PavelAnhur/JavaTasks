package com.epam;

import java.util.Scanner;

public class InputNumbers {

	private static Scanner scanner = new Scanner(System.in);
	public int n;
	public long[] numbersFromInputNumbersClass;
	private int inputValue;

	public InputNumbers(int n) {
		this.n = n;
		this.numbersFromInputNumbersClass = new long[n];
	}

	public void setNumbersFromConsoleInput() {

		for (int i = 0; i < numbersFromInputNumbersClass.length; i++) {
			System.out.println("Enter ["+i+"] element of numbers:");
			if (isInputValueIsInteger())
				numbersFromInputNumbersClass[i] = inputValue;
		}
	}

	private boolean isInputValueIsInteger(){
		do {
			try {
				inputValue = Integer.parseInt(scanner.next());
				return true;
			} catch (Exception e) {
				System.out.println("Try one more time please, it isn't a number");
			}
		} while (true);
	}

	public void outputNumbersFromConsoleInput () {
		System.out.println("Array of integers from console input");
		for (int i = 0; i< numbersFromInputNumbersClass.length; i++) {
			System.out.print(numbersFromInputNumbersClass[i]+ " ");
		}
		System.out.println();
	}

	public long[] getNumbersFromInputNumbersClass() {
		return numbersFromInputNumbersClass;
	}
}
