package com.epam.util;

import java.io.File;
import java.util.Objects;

public class Counter {

	private final File directory;
	private int directoryCounter = 0;
	private int filesCounter = 0;
	private double averageFileLength = 0;

	public Counter(File directory) {
		this.directory = directory;
	}

	public void printOutCounterDirAndFolders() {
		counterForFolder(directory);
		System.out.println("In " + directory.getName() + " directory "
				+ directoryCounter + " folders and " + filesCounter + " files");
	}

	public void printOutAverageValueOfFilesInFolders() {
		System.out.println("Average value of files in folder equal " + filesCounter / directoryCounter);
	}

	public void printOutAverageLengthForFile() {
		System.out.println("Average length for files equals " + averageFileLength/filesCounter);
	}

	private void counterForFolder(File folder) {
		for (File file : Objects.requireNonNull(folder.listFiles())) {
			if (file.isDirectory()) {
				directoryCounter++;
				counterForFolder(file);
			} else {
				filesCounter++;
				counterForFile(file);
			}
		}
	}

	private void counterForFile(File file) {
		averageFileLength += file.getName().length();
		System.out.println("File " + file.getName() + " with length " + file.getName().length());
	}
}
