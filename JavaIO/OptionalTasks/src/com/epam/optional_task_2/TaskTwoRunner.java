package com.epam.optional_task_2;

import com.epam.util.ReaderFromFile;

public class TaskTwoRunner {

	public static void main(String[] args) {

		ReaderFromFile reader = new ReaderFromFile("JavaFileForReading/file.java");
		reader.getTextFromFileAsStrings();
	}
}
