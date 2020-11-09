package com.epam.optional_task_3;

import java.util.ArrayList;
import java.util.List;

public class TextReverser {

	private final List<String> listOfLines;

	public TextReverser(List<String> listOfLines) {
		this.listOfLines = listOfLines;
	}

	public void printOutTextAfterReverse() {
		for (String line : getListOfLinesAfterReverse(listOfLines)){
			System.out.println(line);
		}
	}

	public List<String> getListOfLinesAfterReverse(List<String> listOfLines) {
		List<String> listOfLinesAfterReverse = new ArrayList<>();
		for(String line : listOfLines) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(line);
			stringBuilder.reverse();
			System.out.println(stringBuilder.toString());
			listOfLinesAfterReverse.add(stringBuilder.toString());
		}
		return listOfLinesAfterReverse;
	}
}
