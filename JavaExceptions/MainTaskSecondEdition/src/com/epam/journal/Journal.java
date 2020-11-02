package com.epam.journal;

import com.epam.university.Student;

import java.util.Objects;

public class Journal {

	private Student student;
	private String nameOfLesson;
	private double grade;

	public Journal(Student student, String nameOfLesson, double grade) {
		this.student = student;
		this.nameOfLesson = nameOfLesson;
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getNameOfLesson() {
		return nameOfLesson;
	}

	public void setNameOfLesson(String nameOfLesson) {
		this.nameOfLesson = nameOfLesson;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Journal journal = (Journal) o;
		return Double.compare(journal.grade, grade) == 0 &&
				Objects.equals(student, journal.student) &&
				Objects.equals(nameOfLesson, journal.nameOfLesson);
	}

	@Override
	public int hashCode() {
		return Objects.hash(student, nameOfLesson, grade);
	}
}
