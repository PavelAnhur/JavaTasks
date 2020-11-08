package com.epam.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterToFile {

	private final List<Integer> integerNumbers;
	private final String filePathForWriting;


	public WriterToFile(List<Integer> integerNumbers, String filePathForWriting) {
		this.integerNumbers = integerNumbers;
		this.filePathForWriting = filePathForWriting;
	}

	public void writeDataInFile() {
		try (FileWriter fileWriter = new FileWriter(filePathForWriting)) {
			for (Integer integer : integerNumbers){
				fileWriter.write(integer.toString()+ " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
