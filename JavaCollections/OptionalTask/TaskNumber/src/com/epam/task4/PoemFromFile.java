package com.epam.task4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PoemFromFile {

	private final List<String> textFromFile;

	public PoemFromFile(List<String> textFromFile) {
		this.textFromFile = textFromFile;
	}

	private List<String> sortStringsFromPoemToLength() {
		return textFromFile.stream()
				.sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
	}

	public void printOutSortedText() {
		System.out.println(sortStringsFromPoemToLength().toString());
	}
}