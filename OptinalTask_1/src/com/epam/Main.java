package com.epam;

import com.epam.tasks.*;
import com.epam.util.Numbers;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		int n = 5;                              // count of numbers is array
		Numbers numbers = new Numbers(n);
		numbers.getNumbersFromConsoleInput();   // input values of array
		numbers.outputNumbersFromConsoleInput();// output values of array
		long[] numbersOfLongType = Numbers.getNumbers();
		System.out.println("------------------");

		ShortestNumber shortestNumber = new ShortestNumber(n, numbersOfLongType); // object of shortestNumber class
		System.out.println("Shortest number in array of longs = " + shortestNumber.getShortestNumber() +
				" with " + shortestNumber.getDigitOfShortestNumber() + " digits");
		System.out.println("------------------");

		LongestNumber longestNumber = new LongestNumber(n, numbersOfLongType); //object of longestNumber class
		System.out.println("Longest number in array of longs = " + longestNumber.getLongestNumber() +
				" with " + longestNumber.getDigitOfLongestNumber() + " digits");
		System.out.println("------------------");

		new SortNumbers(n, numbersOfLongType).sortNumbers();
		System.out.println("------------------");

		AverageLength averageLength = new AverageLength(n, numbersOfLongType);
		averageLength.outputDigits();
		System.out.println("******************");
		int averageDigit = averageLength.averageDigit(n, averageLength.getLengthOfNumbers());
		List<Integer> listDigitsOfNumbers = averageLength.getLengthOfNumbers();
		averageLength.outputNumbersWithDigitsMoreOrLessThenAverage(averageDigit, listDigitsOfNumbers);
		System.out.println("------------------");

		new DifferentDigits(n, numbersOfLongType).getNumberWithLessValueOfDifferentDigits();
		System.out.println(" -----------------");

		new OddEvenDigit(n, numbersOfLongType).getNumberWithOddAndEvenDigits();
		System.out.println("------------------");

		DigitsInAscendingOrder digitsInAscendingOrder = new DigitsInAscendingOrder(n, numbersOfLongType);
		if (digitsInAscendingOrder.getNumberWithAscendingOrderDigits() != -1) {
			System.out.println("Number with digits in ascending order: " + digitsInAscendingOrder.getNumberWithAscendingOrderDigits());
		} else {
			System.out.println("No numbers with ascending order digits here");
		}
		System.out.println("------------------");

		System.out.println("Number with different digits only: " +
				new DifferentDigits(n, numbersOfLongType).getNumberWithDifferentDigitsOnly());
	}
}
