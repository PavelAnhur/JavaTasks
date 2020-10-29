package com.epam.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ReaderFromFile {

	private final String pathToFile;

	public ReaderFromFile(String pathToFile) {
		this.pathToFile = pathToFile;
	}

	public Stack<String> getTextFromFileAsStack() throws IOException {

		Stack<String> textFromFile = new Stack<>();
		FileReader fileReader = new FileReader(pathToFile);

		try (Scanner scanner = new Scanner(fileReader)) {
			while (scanner.hasNext()) {
				textFromFile.push(scanner.nextLine());
			}
			fileReader.close();
		}
		return textFromFile;
	}

	public List<String> getTextFromFileAsList() throws IOException {

		List<String> textFromFile = new ArrayList<>();
		FileReader fileReader = new FileReader(pathToFile);

		try (Scanner scanner = new Scanner(fileReader)) {
			while (scanner.hasNext()) {
				textFromFile.add(scanner.nextLine());
			}
			fileReader.close();
		}
		return textFromFile;
	}
}