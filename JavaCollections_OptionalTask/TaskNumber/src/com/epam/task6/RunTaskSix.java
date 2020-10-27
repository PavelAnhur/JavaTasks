package com.epam.task6;

import java.io.IOException;

public class RunTaskSix {

	public static void main(String[] args) throws IOException {

		String pathToFile = "C:\\Users\\Iam\\Documents\\JavaTasks\\JavaCollections_OptionalTask" +
				"\\TaskNumber\\fileForSixthTask.txt";

		TextCompare textCompare = new TextCompare(pathToFile);
		textCompare.printOutSortedStringsFromFile();
	}
}