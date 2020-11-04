package com.epam.exception;

public class NoStudentException extends Exception {

	public NoStudentException() {
		super("No student in this group");
	}
}
