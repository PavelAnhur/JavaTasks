package com.epam;

import com.epam.pattern.Tree;
import com.epam.util.ConsoleReader;
import com.epam.util.Counter;
import com.epam.util.WriterInFile;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		String filePath = new ConsoleReader().readFromConsoleFilePath();
		File directory = new File(filePath);
		Tree tree = new Tree(directory);
		System.out.println(tree.printOutDirectoriesAndFilesAsTree());
		new WriterInFile("catalog.txt", tree.printOutDirectoriesAndFilesAsTree()).writeTextInFile();
		Counter counter = new Counter(directory);
		counter.printOutCounterDirAndFolders();
		counter.printOutAverageLengthForFile();
		counter.printOutAverageValueOfFilesInFolders();
	}
}
