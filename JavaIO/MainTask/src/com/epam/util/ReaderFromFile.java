package com.epam.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderFromFile {

	private final String fileName;

	public ReaderFromFile(String fileName) {
		this.fileName = fileName;
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
}
