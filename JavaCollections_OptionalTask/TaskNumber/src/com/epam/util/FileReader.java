package com.epam.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class FileReader {

	private String pathToFile;

	public FileReader(String pathToFile) {
		this.pathToFile = pathToFile;
	}

	public Stack<String> getTextFromFileAsStack() throws IOException {

		Stack<String> textFromFile = new Stack<>();
		java.io.FileReader fileReader = new java.io.FileReader(pathToFile);

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
		java.io.FileReader fileReader = new java.io.FileReader(pathToFile);

		try (Scanner scanner = new Scanner(fileReader)) {
			while (scanner.hasNext()) {
				textFromFile.add(scanner.nextLine());
			}
			fileReader.close();
		}
		return textFromFile;
	}
}
