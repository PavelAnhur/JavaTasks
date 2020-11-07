package com.epam;

import com.epam.tasks.*;
import com.epam.util.Numbers;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		int numberOfElementsInArray = 5;                              // count of numbers is array
		Numbers numbers = new Numbers(numberOfElementsInArray);
		numbers.getNumbersFromConsoleInput();   // input values of array
		numbers.outputNumbersFromConsoleInput();// output values of array
		long[] numbersOfLongType = Numbers.getNumbers();
		System.out.println("------------------");

		ShortestNumber shortestNumber = new ShortestNumber(numberOfElementsInArray, numbersOfLongType); // object of shortestNumber class
		System.out.println("Shortest number in array of longs = " + shortestNumber.getShortestNumber() +
				" with " + shortestNumber.getDigitOfShortestNumber() + " digits");
		System.out.println("------------------");

		LongestNumber longestNumber = new LongestNumber(numberOfElementsInArray, numbersOfLongType); //object of longestNumber class
		System.out.println("Longest number in array of longs = " + longestNumber.getLongestNumber() +
				" with " + longestNumber.getDigitOfLongestNumber() + " digits");
		System.out.println("------------------");

		new SortNumbers(numberOfElementsInArray, numbersOfLongType).sortNumbers();
		System.out.println("------------------");

		AverageLength averageLength = new AverageLength(numberOfElementsInArray, numbersOfLongType);
		averageLength.outputDigits();
		System.out.println("******************");
		int averageDigit = averageLength.getAverageDigit(numberOfElementsInArray, averageLength.getLengthOfNumbers());
		List<Integer> listDigitsOfNumbers = averageLength.getLengthOfNumbers();
		averageLength.outputNumbersWithDigitsMoreOrLessThenAverage(averageDigit, listDigitsOfNumbers);
		System.out.println("------------------");

		DifferentDigits differentDigits = new DifferentDigits(numberOfElementsInArray, numbersOfLongType);
		differentDigits.getNumberWithLessValueOfDifferentDigits();
		System.out.println(" -----------------");

		new OddEvenDigit(numberOfElementsInArray, numbersOfLongType).getNumberWithOddAndEvenDigits();
		System.out.println("------------------");

		DigitsInAscendingOrder digitsInAscendingOrder = new DigitsInAscendingOrder(numberOfElementsInArray, numbersOfLongType);
		if (digitsInAscendingOrder.getNumberWithAscendingOrderDigits() != -1) {
			System.out.println("Number with digits in ascending order: " + digitsInAscendingOrder.getNumberWithAscendingOrderDigits());
		} else {
			System.out.println("No numbers with ascending order digits here");
		}
		System.out.println("------------------");

		if (differentDigits.getNumberWithDifferentDigitsOnly() != -1) {
			System.out.println("Number with different digits only: " +
					differentDigits.getNumberWithDifferentDigitsOnly());
		} else {
			System.out.println("No numbers with different digits only");
		}
	}
}
