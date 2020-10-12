package com.company;

import java.util.Scanner;

public class InputNumber {

	private int monthNumber;


	public int checkNumber() {
		boolean isValidValue = false;

		while (!isValidValue) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter number of month");

			if (!scanner.hasNextByte()) {
				System.out.println("It's not even a number!");
				isValidValue = false;
				continue;
			} else {
				monthNumber = scanner.nextInt();
				if ((monthNumber > 0) && (monthNumber <= 12)) {
					scanner.close();
					return monthNumber;
				} else {
					System.out.println("It is not valid value for month number");
					isValidValue = false;
					continue;
				}
			}
		}
		return monthNumber;
	}
}
