package com.epam.task1;

import com.epam.util.FileReader;

import java.io.IOException;

public class RunTaskOne {

	public static void main(String[] args) throws IOException {
		String pathToFirstFile = "C:\\Users\\Iam\\Documents\\JavaTasks\\" +
				"JavaCollections_OptionalTask\\TaskNumber\\song.txt";

		String pathToSecondFile = "C:\\Users\\Iam\\Documents\\JavaTasks\\" +
				"JavaCollections_OptionalTask\\TaskNumber\\revertSong.txt";

		FileReader fileReader = new FileReader(pathToFirstFile);
		WriteFile writeFile = new WriteFile(fileReader.getTextFromFileAsStack(), pathToSecondFile);
		writeFile.printOutTextFromStack();
		writeFile.writeTextOnFile(fileReader.getTextFromFileAsStack());
	}
}