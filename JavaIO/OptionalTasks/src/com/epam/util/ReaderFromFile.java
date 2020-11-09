package com.epam.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromFile {

	private final String filePathForReading;
	private FileReader fileReader;

	public ReaderFromFile(String filePathForReading) {
		this.filePathForReading = filePathForReading;
	}

	public List<Integer> getTextFromFileAsListOfIntegers() {
		List<Integer> integerList = new ArrayList<>();
		try {
			fileReader = new FileReader(filePathForReading);
			try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
				String textFromFile = bufferedReader.readLine();
				String[] valuesFromFile = textFromFile.split(" ");
				for (String value : valuesFromFile) {
					integerList.add(Integer.parseInt(value));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return integerList;
	}

	public String getTextFromFileAsStrings() {
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathForReading))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				stringBuilder.append(line);
				stringBuilder.append(System.lineSeparator());
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}
}
