package com.epam.exception;

public class NoFacultyException extends Exception {

	public NoFacultyException() {
		super("No faculties in this university");
	}
}
