package com.epam.task6;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextCompare{

	private final String pathToFile;
	private List<String> textFromFile;


	public TextCompare(String pathToFile) {
		this.pathToFile = pathToFile;
	}

	private List<String> readFromFile() throws IOException {
		FileReader fileReader = new FileReader(pathToFile);
		try (Scanner scanner = new Scanner(fileReader)) {
			textFromFile = new ArrayList<>();
			while (scanner.hasNext()) {
				textFromFile.add(scanner.nextLine());
			}
			fileReader.close();
		}
		return textFromFile;
	}

	private List<String> sortTextFromFileWithSortMethod() throws IOException {
		textFromFile = readFromFile();
		Collections.sort(textFromFile);
		return textFromFile;
	}

	public void printOutSortedStringsFromFile() throws IOException {
		System.out.println(sortTextFromFileWithSortMethod().toString());
	}
}