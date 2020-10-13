package com.company;

import java.util.Scanner;

public class Input {

	private final Scanner scanner = new Scanner(System.in);
	int setNumberOfElements;
	int[] arrayOfIntegers;


	public int[] getArrayOfInt() {

		if (getSetNumberOfElements() > 0) {
			int[] arrayOfInt = new int[setNumberOfElements];

			for (int i = 0; i < arrayOfInt.length; i++) {

				System.out.println("Enter " + (i + 1) + " element:");
				arrayOfInt[i] = scanner.nextInt();

			}
			arrayOfIntegers = arrayOfInt;
		}
		return arrayOfIntegers;
	}


	private int getSetNumberOfElements() {
		boolean isValidValue = false;

		while (!isValidValue) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("How many elements do you want to add?");

			if (!scanner.hasNextInt()) {
				System.out.println("It's not a valid number, try one more time");
				isValidValue = false;
				continue;
			} else {
				setNumberOfElements = scanner.nextInt();
				if (setNumberOfElements > 0) {
					isValidValue = true;
				} else {
					System.out.println("Invalid value");
					isValidValue = false;
				}
			}
		}
		return setNumberOfElements;
	}

}
