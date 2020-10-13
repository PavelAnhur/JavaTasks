package com.epam;

<<<<<<< HEAD:4.Task_JavaFundamental/src/com/epam/SumAndMultFunction.java
public class SumAndMultFunction {
=======
public class Function {
>>>>>>> 38312f49640a9608b9e253b6fe23664cd4d3c33c:4.Task_JavaFundamental/src/com/epam/Function.java

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
