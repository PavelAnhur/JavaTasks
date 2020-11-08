package com.epam.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromFile {

	private final String filePathForReading;

	public ReaderFromFile(String filePathForReading) {
		this.filePathForReading = filePathForReading;
	}

	public List<Integer> getTextFromFile() {
		List<Integer> integerList = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(filePathForReading);
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
}
