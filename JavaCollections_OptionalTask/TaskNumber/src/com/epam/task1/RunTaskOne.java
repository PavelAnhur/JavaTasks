package com.epam.task1;

import com.epam.util.ReaderFromFile;

import java.io.IOException;

public class RunTaskOne {

	public static void main(String[] args) throws IOException {
		String pathToFirstFile = "C:\\Users\\Iam\\Documents\\JavaTasks\\" +
				"JavaCollections_OptionalTask\\TaskNumber\\song.txt";

		String pathToSecondFile = "C:\\Users\\Iam\\Documents\\JavaTasks\\" +
				"JavaCollections_OptionalTask\\TaskNumber\\revertSong.txt";

		ReaderFromFile readerFromFile = new ReaderFromFile(pathToFirstFile);
		WriterToFile writerToFile = new WriterToFile(readerFromFile.getTextFromFileAsStack(), pathToSecondFile);
		writerToFile.printOutTextFromStack();
		writerToFile.writeTextOnFile(readerFromFile.getTextFromFileAsStack());
	}
}