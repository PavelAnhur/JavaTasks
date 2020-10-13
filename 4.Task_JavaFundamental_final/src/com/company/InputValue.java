package com.company;

import java.util.Scanner;

public class InputValue {

	private static final Scanner scanner = new Scanner(System.in);
	private int numberOfElements;


	public int[] getIntegers() {
		int numberOfElements = getNumberOfElements();
		int[] inputIntegers = new int[numberOfElements];

		for (int i = 0; i < inputIntegers.length; i++) {
			System.out.println("Enter " + (i + 1) + " element:");
			inputIntegers[i] = scanner.nextInt();
		}
		scanner.close();
		return inputIntegers;
	}

	private int getNumberOfElements() {
		System.out.println("How many elements do you want to add?");

		do {
			try {
				numberOfElements = Integer.parseInt(scanner.next());
			} catch (Exception e) {
				System.out.println("Try one more time please");
			}
			if (numberOfElements > 0) {
				return numberOfElements;
			} else
				System.out.println("Invalid value");
		} while (true);
	}
}





