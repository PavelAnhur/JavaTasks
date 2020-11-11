package com.epam.element;

import java.util.List;

public class ElementCounter {

	private final List<String> listOfStrings;
	private int directoryCounter = 0;
	private int filesCounter = 0;

	public ElementCounter(List<String> listOfStrings) {
		this.listOfStrings = listOfStrings;
	}

	public void printOutNumberDirAndFiles() {
		System.out.println("There are " + directoryCounter + " folders and " + filesCounter + " files");
	}

	public void printOutAverageNumberOfFilesInFolders() {
		System.out.println("Average value of files in folder equal " + filesCounter / (directoryCounter - 1));
	}

	public void printOutAverageLengthForFileName() {
		System.out.println("Average length for files equals " + (double) getLengthOfAllFileNames(listOfStrings) / filesCounter);
	}

	public void getNumbersOfFoldersAndFiles(List<String> listOfLines) {
		for (String lineFromList : listOfLines) {
			int index = lineFromList.indexOf('├');
			if (index == -1) {
				filesCounter++;
			} else {
				directoryCounter++;
			}
		}
	}

	private int getLengthOfAllFileNames(List<String> listOfLines) {
		int filesNameLength = 0;
		for (String lineFromList : listOfLines) {
			int index = lineFromList.indexOf("  ");
			if (index != -1) {
				String[] words = lineFromList.split("( )+( )");
				for (String word : words) {
					if (word.charAt(0) != '|') {
						filesNameLength += word.length();
					}
				}
			}
		}
		return filesNameLength;
	}
}
