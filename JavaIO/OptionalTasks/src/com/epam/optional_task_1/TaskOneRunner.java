package com.epam.optional_task_1;

import com.epam.util.FileDirCreator;
import com.epam.util.ReaderFromFile;
import com.epam.util.WriterToFile;

public class TaskOneRunner {

	public static void main(String[] args) {
		String filePathForReading = "Data/integers.txt";
		String filePathForWriting = "Data/sortedIntegers.txt";
		FileDirCreator fileDirCreator = new FileDirCreator();
		fileDirCreator.createNewDirectoryForFile("Data/");
		fileDirCreator.createNewFile(filePathForReading);
		DataForFile integerNumbers = new DataForFile(10);
		new WriterToFile(filePathForReading).writeNumbersInFile(integerNumbers.getIntegers());
		new WriterToFile(filePathForWriting).writeNumbersInFile(integerNumbers.getSortedListOfIntegers(new ReaderFromFile(filePathForReading)
				.getTextFromFileAsListOfIntegers()));
	}
}
