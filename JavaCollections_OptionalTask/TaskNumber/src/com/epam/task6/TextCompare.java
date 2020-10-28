package com.epam.task6;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextCompare{

	private final String pathToFile;


	public TextCompare(String pathToFile) {
		this.pathToFile = pathToFile;
	}

	private List<String> readFromFile() throws IOException {
		FileReader fileReader = new FileReader(pathToFile);
		List<String> textFromFile;
		try (Scanner scanner = new Scanner(fileReader)) {
			textFromFile = new ArrayList<>();
			while (scanner.hasNext()) {
				textFromFile.add(scanner.next());
			}
			fileReader.close();
		}
		return textFromFile;
	}

	private List<String> sortTextFromFileWithSortMethod() throws IOException {
		List<String> textFromFile = readFromFile();
		Collections.sort(textFromFile);
		return textFromFile;
	}

	public void printOutSortedStringsFromFile() throws IOException {
		System.out.println(sortTextFromFileWithSortMethod().toString());
	}
}