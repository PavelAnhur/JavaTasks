package com.epam;

import com.epam.util.ConsoleReader;
import com.epam.element.ElementCounter;
import com.epam.util.ReaderFromFile;
import com.epam.util.WriterToFile;
import com.epam.viewpattern.FileDirViewer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		String filePath = new ConsoleReader().readFromConsoleFilePath();
		File directory = new File(filePath);
		FileDirViewer fileDirViewer = new FileDirViewer(directory);
		System.out.println(fileDirViewer.printOutDirectoriesAndFilesAsTree());
		Date date = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("MM.dd.yyyy_hh.mm");
		String fileName = "catalog" + formatForDateNow.format(date) + ".txt";
		new WriterToFile(fileName, fileDirViewer.printOutDirectoriesAndFilesAsTree()).writeTextInFile();
		List<String> stringsList = new ReaderFromFile(fileName).getTextFromFileAsListOfLines();
		ElementCounter elementCounter = new ElementCounter(stringsList);
		elementCounter.getNumbersOfFoldersAndFiles(stringsList);
		elementCounter.printOutNumberDirAndFiles();
		elementCounter.printOutAverageLengthForFileName();
		elementCounter.printOutAverageNumberOfFilesInFolders();
	}
}
