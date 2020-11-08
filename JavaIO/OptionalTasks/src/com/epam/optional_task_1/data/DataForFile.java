package com.epam.optional_task_1.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataForFile {

	private final int numberOfIntegersInList;

	public DataForFile(int numberOfIntegersInList) {
		this.numberOfIntegersInList = numberOfIntegersInList;
	}

	public List<Integer> getIntegers() {
		List<Integer> integerNumbers = new ArrayList<>();
		for (int i = 0; i < numberOfIntegersInList; i++) {
			integerNumbers.add((int) (Math.random() * (200 + 1)) - 100);
			System.out.println((i + 1) + " element " + integerNumbers.get(i));
		}
		return integerNumbers;
	}

	public List<Integer> getSortedListOfIntegers(List<Integer> integers) {
		Collections.sort(integers);
		for(int number : integers) {
			System.out.print(number + " ");
		}
		return integers;
	}
}
