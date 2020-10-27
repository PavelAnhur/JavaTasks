package com.epam.task1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ReadWriteFile {

	private final String pathToReadFile;
	private final String pathToWriteFile;

	public ReadWriteFile(String pathToReadFile, String pathToWriteFile) {
		this.pathToReadFile = pathToReadFile;
		this.pathToWriteFile = pathToWriteFile;
	}

	public Stack<String> getTextFromFile() throws IOException {

		Stack<String> textFromFile = new Stack<>();
		FileReader fileReader = new FileReader(pathToReadFile);

		try (Scanner scanner = new Scanner(fileReader)) {
			while (scanner.hasNext()) {
				textFromFile.push(scanner.nextLine());
			}
			fileReader.close();
		}
		return textFromFile;
	}

	public void printOutTextFromStack() throws IOException {
		Stack<String> textFromFile = getTextFromFile();
		while (!textFromFile.isEmpty()) {
			System.out.println(textFromFile.pop());
		}
	}

	public void writeTextOnFile(Stack<String> textFromFile) throws IOException {
		try (FileWriter fileWriter = new FileWriter(pathToWriteFile)) {
			while (!textFromFile.isEmpty()) {
				fileWriter.write(textFromFile.pop() + "\n");
			}
		}
	}
}