package com.epam.task4;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoemFromFile {

	private final String pathToFileWithPoem;

	public PoemFromFile(String pathToFileWithPoem) {
		this.pathToFileWithPoem = pathToFileWithPoem;
	}

	private List<String> readTextFromFile() throws IOException {
		FileReader fileReader = new FileReader(pathToFileWithPoem);
		Scanner scanner = new Scanner(fileReader);
		List<String> textFromFile = new ArrayList<>();

		try {
			while (scanner.hasNext()) {
				textFromFile.add(scanner.nextLine());
			}
			fileReader.close();
		} finally {
			scanner.close();
		}
		fileReader.close();
		return textFromFile;
	}

	private List<String> sortStringsFromPoemToLength() throws IOException {
		List<String> textFromFile = readTextFromFile();
		return textFromFile.stream()
				.sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
	}

	public void printOutSortedText() throws IOException {
		System.out.println(sortStringsFromPoemToLength().toString());
	}
}