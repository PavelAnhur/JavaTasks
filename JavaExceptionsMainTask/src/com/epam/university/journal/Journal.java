package com.epam.university.journal;

import com.epam.student.Student;
import com.epam.university.structure.Lesson;
import java.util.Objects;

public class Journal {

	private final Student student;
	private final Lesson nameOfLesson;
	private double grade;

	public Journal(Student student, Lesson nameOfLesson, int grade) {
		this.student = student;
		this.nameOfLesson = nameOfLesson;
		this.grade = grade;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Journal journal = (Journal) o;
		return grade == journal.grade &&
				Objects.equals(student, journal.student) &&
				nameOfLesson == journal.nameOfLesson;
	}

	@Override
	public int hashCode() {
		return Objects.hash(student, nameOfLesson, grade);
	}

	@Override
	public String toString() {
		return "Journal{" +
				"student=" + student.getLastName() +
				", nameOfLesson=" + nameOfLesson +
				", grade=" + grade +
				'}';
	}
}
