package com.epam.university.journal;

import com.epam.university.structure.Lesson;

import java.util.Objects;

public class Journal {

	private final String lastNameOfStudent;
	private Lesson nameOfLesson;
	private final int grades;

	public Journal(String nameOfStudent, Lesson nameOfLesson, int grades) {
		this.lastNameOfStudent = nameOfStudent;
		this.nameOfLesson = nameOfLesson;
		this.grades = grades;
	}

	public String getLastNameOfStudent() {
		return lastNameOfStudent;
	}

	public Lesson getNameOfLesson() {
		return nameOfLesson;
	}

	public void setNameOfLesson(Lesson nameOfLesson) {
		this.nameOfLesson = nameOfLesson;
	}

	public int getGrades() {
		return grades;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Journal journal = (Journal) o;
		return grades == journal.grades &&
				nameOfLesson == journal.nameOfLesson;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nameOfLesson, grades);
	}

	@Override
	public String toString() {
		return "Journal{" +
				"lastNameOfStudent='" + lastNameOfStudent + '\'' +
				", nameOfLesson=" + nameOfLesson +
				", score=" + grades +
				'}';
	}
}
