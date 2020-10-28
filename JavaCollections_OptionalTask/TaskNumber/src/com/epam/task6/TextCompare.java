package com.epam.task6;

import java.io.IOException;
import java.util.*;

public class TextCompare{

	private final List<String> textFromFile;

	public TextCompare(List<String> textFromFile) {
		this.textFromFile = textFromFile;
	}

	private List<String> sortTextFromFileWithSortMethod() throws IOException {
		Collections.sort(textFromFile);
		return textFromFile;
	}

	public void printOutSortedStringsFromFile() throws IOException {
		System.out.println(sortTextFromFileWithSortMethod().toString());
	}
}