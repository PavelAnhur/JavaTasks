package com.epam.task1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class WriteFile {

	private final Stack<String> textFromFile;
	private final String pathToWriteFile;

	public WriteFile(Stack<String> textFromFile, String pathToWriteFile) {
		this.textFromFile = textFromFile;
		this.pathToWriteFile = pathToWriteFile;
	}

	public void printOutTextFromStack() throws IOException {
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