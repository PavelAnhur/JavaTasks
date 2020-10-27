package com.epam.task1;

import java.io.IOException;

public class RunTaskOne {

	public static void main(String[] args) throws IOException {
		String pathToFirstFile = "C:\\Users\\Iam\\Documents\\JavaTasks\\" +
				"JavaCollections_OptionalTask\\TaskNumber\\song.txt";

		String pathToSecondFile = "C:\\Users\\Iam\\Documents\\JavaTasks\\" +
				"JavaCollections_OptionalTask\\TaskNumber\\revertSong.txt";

		ReadWriteFile readWriteFile = new ReadWriteFile(pathToFirstFile,pathToSecondFile);
		readWriteFile.printOutTextFromStack();
		readWriteFile.writeTextOnFile(readWriteFile.getTextFromFile());
	}
}