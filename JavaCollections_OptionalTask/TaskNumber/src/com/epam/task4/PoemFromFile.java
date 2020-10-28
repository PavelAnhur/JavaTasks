package com.epam.task4;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PoemFromFile {

	private final List<String> textFromFile;

	public PoemFromFile(List<String> textFromFile) {
		this.textFromFile = textFromFile;
	}

	private List<String> sortStringsFromPoemToLength() throws IOException {
		return textFromFile.stream()
				.sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
	}

	public void printOutSortedText() throws IOException {
		System.out.println(sortStringsFromPoemToLength().toString());
	}
}