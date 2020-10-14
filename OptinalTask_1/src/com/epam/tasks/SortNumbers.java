package com.epam.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortNumbers {

	long[] numbersFromNumbersClass;
	int n;

	public SortNumbers(int n, long[] numbersFromNumbersClass) {
		this.n = n;
		this.numbersFromNumbersClass = numbersFromNumbersClass;
	}

	public void sortNumbers() {

		List<Long> numbersFromMinToMax = new ArrayList<>();  //copy of values from InputNumber class
		for (long fromInputNumbersClass : numbersFromNumbersClass) {
			numbersFromMinToMax.add(fromInputNumbersClass);
		}

		Collections.sort(numbersFromMinToMax);

		System.out.println("Array of longs from Min to Max");
		for (Long fromMinToMax : numbersFromMinToMax) System.out.println(fromMinToMax);

		System.out.println("********************");

		System.out.println("Array of longs from Max to Min");
		for (int i = numbersFromMinToMax.size() - 1; i >= 0; i--)
			System.out.println(numbersFromMinToMax.get(i));
	}


}
