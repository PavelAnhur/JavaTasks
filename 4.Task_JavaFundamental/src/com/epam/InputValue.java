package com.epam;

import java.util.Scanner;

public class InputValue {

	private static final Scanner scanner = new Scanner(System.in);
	private int numberOfElements;
	private int inputValue;


	public int[] getIntegers() {
		int numberOfElements = getNumberOfElements();
		int[] inputIntegers = new int[numberOfElements];

		for (int i = 0; i < inputIntegers.length; i++) {

			System.out.println("Enter " + (i + 1) + " element:");
			if (isInputANumber())
				inputIntegers[i] = inputValue;
		}
		scanner.close();
		return inputIntegers;
	}

	private int getNumberOfElements() {
		System.out.println("How many elements do you want to add?");

		do {
			if (isInputANumber())
				numberOfElements = inputValue;
			if (numberOfElements > 0)
				return numberOfElements;
			else
				System.out.println("Invalid value");
		} while (true);
	}

	private boolean isInputANumber() {
		do {
			try {
				inputValue = Integer.parseInt(scanner.next());
				return true;
			} catch (Exception e) {
				System.out.println("Try one more time please");
			}
		} while (true);
	}
}
