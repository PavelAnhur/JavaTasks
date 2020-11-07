package com.company;

public class Main {

	public static void main(String[] args) {

		int numberOfMonth = new NumberOfMonth().getMonthNumberFromKeyboard();

		Month month = new Month(numberOfMonth);
		System.out.println(month.getNumberOfMonth() + " month = " + month.getMonth(numberOfMonth));
	}
}
