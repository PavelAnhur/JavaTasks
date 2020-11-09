package com.epam.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderFromFile {

	private final String fileName;

	public ReaderFromFile(String fileName) {
		this.fileName = fileName;
	}

	public List<Integer> getTextFromFileAsListOfIntegers() {
		List<Integer> integerList = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			String textFromFile = bufferedReader.readLine();
			String[] valuesFromFile = textFromFile.split(" ");
			for (String value : valuesFromFile) {
				integerList.add(Integer.parseInt(value));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return integerList;
	}

	public List<String> getTextFromFileAsListOfLines() {
		List<String> listOfStrings = null;
		try (Stream<String> lines = Files.lines(Path.of(fileName))) {
			listOfStrings = lines.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listOfStrings;
	}

	public StringBuilder getTextFromFileAsStringBuilder() {
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			String line;
			String lineSeparator = System.getProperty("line.separator");
			while ((line = bufferedReader.readLine()) != null){
				stringBuilder.append(line);
				stringBuilder.append(lineSeparator);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder;
	}
}
