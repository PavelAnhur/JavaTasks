package com.epam.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class File {

	private final String pathToFirstFile;
	private final String pathToSecondFile;

	public File(String pathToFirstFile, String pathToSecondFile) {
		this.pathToFirstFile = pathToFirstFile;
		this.pathToSecondFile = pathToSecondFile;
	}

	public Stack<String> getTextFromFile() throws IOException {

		Stack<String> textFromFile = new Stack<>();
		FileReader fileReader = new FileReader(pathToFirstFile);
		Scanner scanner = new Scanner(fileReader);


		while (scanner.hasNext()) {
			textFromFile.push(scanner.nextLine());
		}
		fileReader.close();
		scanner.close();
		return textFromFile;
	}

	public void printOutTextFromStack() throws IOException {
		Stack<String> textFromFile = getTextFromFile();
		while (!textFromFile.isEmpty()) {
			System.out.println(textFromFile.pop());
		}
	}

	public void writeTextOnFile(Stack<String> textFromFile) throws IOException {
		FileWriter fileWriter = new FileWriter(pathToSecondFile);
		while (!textFromFile.isEmpty()){
			fileWriter.write(textFromFile.pop()+"\n");
		}
		fileWriter.close();
	}

}
