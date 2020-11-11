package com.epam.viewpattern;

import java.io.File;
import java.util.Objects;

public class FileDirViewer {

	private final File parentDirectory;

	public FileDirViewer(File parentDirectory) {
		this.parentDirectory = parentDirectory;
	}

	public String printOutDirectoriesAndFilesAsTree() {
		int indent = 0;
		StringBuilder stringBuilderForDirectoriesAndFiles = new StringBuilder();
		outputForDirectory(parentDirectory, indent, stringBuilderForDirectoriesAndFiles);
		return stringBuilderForDirectoriesAndFiles.toString();
	}

	private void outputForDirectory(File directory, int indent, StringBuilder stringBuilder) {
		stringBuilder.append(getIndentString(indent));
		stringBuilder.append("├--");
		stringBuilder.append(directory.getName());
		stringBuilder.append("/");
		stringBuilder.append("\n");
		for (File fileOrFolder : (Objects.requireNonNull(directory.listFiles()))) {
			if (fileOrFolder.isDirectory()) {
				outputForDirectory(fileOrFolder, indent + 1, stringBuilder);
			} else {
				outputForFile(fileOrFolder, indent + 1, stringBuilder);
			}
		}
	}

	private void outputForFile(File file, int indent, StringBuilder stringBuilder) {
		stringBuilder.append(getIndentString(indent));
		stringBuilder.append("  ");
		stringBuilder.append(file.getName());
		stringBuilder.append("\n");
	}

	private String getIndentString(int indent) {
		return "| ".repeat(Math.max(0, indent));
	}
}
