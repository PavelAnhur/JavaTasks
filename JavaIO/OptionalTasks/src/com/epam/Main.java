package com.epam;

import com.epam.optional_task_1.data.DataForFile;
import com.epam.util.FileDirCreator;
import com.epam.util.ReaderFromFile;
import com.epam.util.WriterToFile;

public class Main {

	public static void main(String[] args) {
		String filePathForReading = "Data/integers.txt";
		String filePathForWriting = "Data/sortedIntegers.txt";
		FileDirCreator fileDirCreator = new FileDirCreator();
		fileDirCreator.createNewDirectoryForFile("Data/");
		fileDirCreator.createNewFile(filePathForReading);
		DataForFile data = new DataForFile(10);
		new WriterToFile(data.getIntegers(), filePathForReading).writeDataInFile();
		new WriterToFile(data.getSortedListOfIntegers(new ReaderFromFile(filePathForReading).getTextFromFile()),filePathForWriting)
                .writeDataInFile();
	}
}
