package com.epam.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterToFile {

	private final String filePathForWriting;

	public WriterToFile(String filePathForWriting) {
		this.filePathForWriting = filePathForWriting;
	}

	public void writeNumbersInFile(List<Integer> integerNumbers) {
		try (FileWriter fileWriter = new FileWriter(filePathForWriting)) {
			for (Integer integer : integerNumbers){
				fileWriter.write(integer.toString()+ " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeTextInFile (List<String> listOfLines) {
		try (FileWriter fileWriter = new FileWriter(filePathForWriting)) {
			for (String line : listOfLines) {
				fileWriter.write(line);
				fileWriter.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
