package com.epam.university;

import com.epam.exception.GradeException;
import com.epam.exception.NoLessonException;

import java.util.Map;
import java.util.Objects;

public class Student {

	private final String firstName;
	private final String lastName;
	private final Map<String, Integer> lessons;
	private Double averageGrade;

	public Student(String firstName, String lastName, Map<String, Integer> lessons) {
		this.lessons = lessons;
		this.firstName = firstName;
		this.lastName = lastName;
		this.averageGrade = 0.0;
	}

	public Double getAverageGrade() {
		for (String lesson : lessons.keySet()) {
			if (lessons.get(lesson) != 0) {
				if (averageGrade == 0) {
					averageGrade = Double.valueOf((lessons.get(lesson)));
				} else {
					averageGrade = (averageGrade + Double.valueOf((lessons.get(lesson)))) / 2;
				}
			}
		}
		return averageGrade;
	}

	public String getLastName() {
		return lastName;
	}

	public Map<String, Integer> getLessons() throws NoLessonException {
		if (lessons == null) {
			throw new NoLessonException("Student " + getLastName() + " has no lessons");
		}
		return lessons;
	}

	public void addLessonToStudent(String nameOfLesson, Integer grade) throws GradeException {
		if ((grade >= 0) && (grade <= 10)) {
			lessons.putIfAbsent(nameOfLesson, grade);
		} else {
			throw new GradeException();
		}
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Objects.equals(lessons, student.lessons) &&
				Objects.equals(firstName, student.firstName) &&
				Objects.equals(lastName, student.lastName) &&
				Objects.equals(averageGrade, student.averageGrade);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lessons, firstName, lastName, averageGrade);
	}

	@Override
	public String toString() {
		return "Student{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
