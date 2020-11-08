package com.epam.util;

import java.io.File;
import java.io.IOException;

public class FileDirCreator {

	public void createNewFile(String fileNameWithPath) {
		File file = new File(fileNameWithPath);
		try {
			if (file.createNewFile()) {
				System.out.println("File " + file.getName() + " was created");
			} else {
				System.err.println("Couldn't create file " + file.getName() + ", file already exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createNewDirectoryForFile(String directoryNameWithPath) {
		File directory = new File(directoryNameWithPath);
		if (!directory.mkdirs()) {
			System.out.println("Directory " + directory.getName() + " was created");
		} else {
			System.err.println("Directory already exists");
		}
	}
}
