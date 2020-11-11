package com.epam.util;

import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {

	private final String pathToWriteFile;
	private final String textForWriting;

	public WriterToFile(String pathToWriteFile, String textForWriting) {
		this.pathToWriteFile = pathToWriteFile;
		this.textForWriting = textForWriting;
	}

	public void writeTextInFile() {
		try (FileWriter fileWriter = new FileWriter(pathToWriteFile, true)) {
			fileWriter.write(textForWriting);
		} catch (IOException e) {
			e.getStackTrace();
		}
	}
}
