package com.epam.list;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class File {

	private final String pathToFile;

	public File(String pathToFile) {
		this.pathToFile = pathToFile;
	}

	private List<Integer> readFromFile() throws IOException {
		FileReader fileReader = new FileReader(pathToFile);
		Scanner scanner = new Scanner(fileReader);
		List<Integer> textFromFile = new ArrayList<>();
		try {
			while (scanner.hasNext()) {
				textFromFile.add(scanner.nextInt());
			}
			fileReader.close();
		} finally {
			scanner.close();
		}
		return textFromFile;
	}

	private List<Integer> sortTextFromFileWithSortMethod() throws IOException {
		List<Integer> textFromFile = readFromFile();
		Collections.sort(textFromFile);
		return textFromFile;
	}

	public void printOutSortedStringsFromFile() throws IOException {
		System.out.println(sortTextFromFileWithSortMethod().toString());
	}
}