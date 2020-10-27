package com.epam;

import com.epam.list.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		String pathToFile = "C:\\Users\\Iam\\Documents\\JavaTasks\\JavaCollections_OptionalTask" +
				"\\TaskNumberSix\\fileForThisTask.txt";

		File file = new File(pathToFile);
		file.printOutSortedStringsFromFile();
	}
}
