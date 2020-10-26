package com.epam;

import com.epam.file.File;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		String pathToFirstFile = "C:\\Users\\Iam\\Documents\\JavaTasks\\" +
				"JavaCollections_OptionalTask\\TaskNumberOne\\song.txt";

		String pathToSecondFile = "C:\\Users\\Iam\\Documents\\JavaTasks\\" +
				"JavaCollections_OptionalTask\\TaskNumberOne\\revertSong.txt";

		File file = new File(pathToFirstFile,pathToSecondFile);
		file.printOutTextFromStack();
		file.writeTextOnFile(file.getTextFromFile());
	}
}
