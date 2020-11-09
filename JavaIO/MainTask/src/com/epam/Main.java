package com.epam;

import com.epam.util.ConsoleReader;
import com.epam.element.ElementCounter;
import com.epam.util.ReaderFromFile;
import com.epam.util.WriterToFile;
import com.epam.viewpattern.TreeViewFileDir;

import java.io.File;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		String filePath = new ConsoleReader().readFromConsoleFilePath();
		File directory = new File(filePath);
		TreeViewFileDir treeViewFileDir = new TreeViewFileDir(directory);
		System.out.println(treeViewFileDir.printOutDirectoriesAndFilesAsTree());
		String fileName = "catalog.txt";
		new WriterToFile(fileName, treeViewFileDir.printOutDirectoriesAndFilesAsTree()).writeTextInFile();
		List<String> stringsList = new ReaderFromFile(fileName).getTextFromFileAsListOfLines();
		ElementCounter elementCounter = new ElementCounter(stringsList);
		elementCounter.getNumbersOfFoldersAndFiles(stringsList);
		elementCounter.printOutCounterDirAndFiles();
		elementCounter.printOutAverageLengthForFile();
		elementCounter.printOutAverageValueOfFilesInFolders();
	}
}
