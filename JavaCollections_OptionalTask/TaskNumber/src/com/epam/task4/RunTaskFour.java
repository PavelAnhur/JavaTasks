package com.epam.task4;

import com.epam.util.FileReader;

import java.io.IOException;

public class RunTaskFour {

	public static void main(String[] args) throws IOException {

		String pathToPoem = "C:\\Users\\Iam\\Documents\\JavaTasks\\" +
				"JavaCollections_OptionalTask\\TaskNumber\\poem.txt";

		new PoemFromFile(new FileReader(pathToPoem).getTextFromFileAsList()).printOutSortedText();
	}
}