package com.epam.task6;

import com.epam.util.ReaderFromFile;

import java.io.IOException;

public class RunTaskSix {

	public static void main(String[] args) throws IOException {

		String pathToFile = "C:\\Users\\Iam\\Documents\\JavaTasks\\JavaCollections_OptionalTask" +
				"\\TaskNumber\\fileForSixthTask.txt";

		new TextCompare(new ReaderFromFile(pathToFile).getTextFromFileAsList()).printOutSortedStringsFromFile();
	}
}