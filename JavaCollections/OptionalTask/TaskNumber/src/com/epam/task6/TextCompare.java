package com.epam.task6;

import java.util.Collections;
import java.util.List;

public class TextCompare {

	private final List<String> textFromFile;

	public TextCompare(List<String> textFromFile) {
		this.textFromFile = textFromFile;
	}

	private List<String> sortTextFromFileWithSortMethod() {
		Collections.sort(textFromFile);
		return textFromFile;
	}

	public void printOutSortedStringsFromFile() {
		System.out.println(sortTextFromFileWithSortMethod().toString());
	}
}