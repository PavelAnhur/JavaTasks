package com.epam.task4;

import java.io.IOException;

public class RunTaskFour {

	public static void main(String[] args) throws IOException {

		String pathToPoem = "C:\\Users\\Iam\\Documents\\JavaTasks\\" +
				"JavaCollections_OptionalTask\\TaskNumber\\poem.txt";

		PoemFromFile poemFromFile = new PoemFromFile(pathToPoem);
		poemFromFile.printOutSortedText();
	}
}