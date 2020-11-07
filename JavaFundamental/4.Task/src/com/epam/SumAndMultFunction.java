package com.epam;

public class SumAndMultFunction {

	public void getSumOfElements(int[] array) {

		int sumOfElements = 0;
		for (int i=0; i < array.length; i++) {
			sumOfElements += array[i];
		}
		System.out.println("Sum of " + array.length + " elements = " + sumOfElements);
	}

	public void getMultiplyOfElements(int[] array) {

		long multiplyOfElements =1;
		for (int i = 0; i < array.length; i++) {
			multiplyOfElements *= array[i];
		}
		System.out.println("Multiplication of " + array.length + " elements = " + multiplyOfElements);
	}
}
