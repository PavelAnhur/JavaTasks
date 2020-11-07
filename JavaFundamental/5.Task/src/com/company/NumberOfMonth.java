package com.company;

import java.util.Scanner;

public class NumberOfMonth {

	private static final Scanner scanner = new Scanner(System.in);


	public int getMonthNumberFromKeyboard() {
		System.out.println("Enter number of month");
		do {
			try {
				int monthNumber = Integer.parseInt(scanner.next());
				if ((monthNumber > 0) && (monthNumber <= 12)) {
					return monthNumber;
				} else {
					System.out.println("Number of month cant be less than 0 or more then 12, try one more time");
				}
			} catch (Exception e) {
				System.out.println("It isn't a number, try one more time please");
			}
		} while (true);
	}
}
