package com.epam.optional_task_2;

import java.util.ArrayList;
import java.util.List;

public class TextReplacer {

	private final List<String> listOfLines;

	public TextReplacer(List<String> listOfLines) {
		this.listOfLines = listOfLines;
	}

	public void printOutListWithReplacedWords() {
		System.out.println("Text after replacement");
		for (String line : getListOfLinesWithReplacedWords(listOfLines)) {
			System.out.println(line);
		}
	}

	private List<String> getListOfLinesWithReplacedWords(List<String> listOfLines) {
		List<String> textAfterReplace = new ArrayList<>();
		for (String line : listOfLines) {
			textAfterReplace.add(line.replace("public", "private"));
		}
		return textAfterReplace;
	}
}
