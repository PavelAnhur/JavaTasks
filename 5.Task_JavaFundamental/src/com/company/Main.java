package com.company;

public class Main {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		int numberOfMonth = inputNumber.checkNumber();

		Month month = new Month(numberOfMonth);
		System.out.println(month.getNumberOfMonth() + " month = " + month.getMonth(numberOfMonth));
	}
}
