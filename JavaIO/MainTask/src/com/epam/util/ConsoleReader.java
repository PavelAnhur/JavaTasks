package com.epam.util;

import java.io.File;
import java.util.Scanner;

public class ConsoleReader {

	public String readFromConsoleFilePath() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter path to file on next line:");
			String filePath = scanner.nextLine();
			if (isInputValueAFolder(filePath)) {
				return filePath;
			}
		}
		return null;
	}

	public boolean isInputValueAFolder(String filePath) {
		File dir = new File(filePath);
		if (dir.isDirectory()) {
			return true;
		} else {
			throw new IllegalArgumentException("Input value not a folder!");
		}
	}
}
