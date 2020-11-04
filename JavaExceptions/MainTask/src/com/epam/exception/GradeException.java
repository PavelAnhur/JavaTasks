package com.epam.exception;

public class GradeException extends Exception {

	public GradeException() {
		super("Grade can't be less than 0 and more than 10");
	}
}