package com.epam.optional_task_3;

import com.epam.util.ReaderFromFile;
import com.epam.util.WriterToFile;

public class TaskThreeRunner {

	public static void main(String[] args) {
		ReaderFromFile textFromFile = new ReaderFromFile("JavaFileForReading/file.java");
		TextReverser textReverser = new TextReverser(textFromFile.getTextFromFileAsListOfLines());
		textReverser.printOutTextAfterReverse();
		new WriterToFile("JavaFileAfterReverse/file.txt")
				.writeTextInFile(textReverser.getListOfLinesAfterReverse(
						new ReaderFromFile("JavaFileForReading/file.java").getTextFromFileAsListOfLines()));
	}
}
