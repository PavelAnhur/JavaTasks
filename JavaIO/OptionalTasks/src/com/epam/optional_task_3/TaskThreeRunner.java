package com.epam.optional_task_3;

import com.epam.util.ReaderFromFile;
import com.epam.util.WriterToFile;

public class TaskThreeRunner {

	public static void main(String[] args) {
		String filePathForReading = args[0];
		String filePathForWriting = args[1];
		ReaderFromFile textFromFile = new ReaderFromFile(filePathForReading);
		TextReverser textReverser = new TextReverser(textFromFile.getTextFromFileAsListOfLines());
		textReverser.printOutTextAfterReverse();
		new WriterToFile(filePathForWriting)
				.writeTextInFile(textReverser.getListOfLinesAfterReverse(
						new ReaderFromFile(filePathForReading).getTextFromFileAsListOfLines()));
	}
}
