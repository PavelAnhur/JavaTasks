package com.epam.util;

import java.io.FileWriter;
import java.io.IOException;

public class WriterInFile {

	private final String pathToWriteFile;
	private final String textForWriting;

	public WriterInFile(String pathToWriteFile, String textForWriting) {
		this.pathToWriteFile = pathToWriteFile;
		this.textForWriting = textForWriting;
	}

	public void writeTextInFile() {
		try (FileWriter fileWriter = new FileWriter(pathToWriteFile)) {
			fileWriter.write(textForWriting);
		} catch (IOException e) {
			e.getStackTrace();
		}
	}
}
