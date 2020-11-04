package com.epam.university;

import com.epam.exception.NoLessonException;

import java.util.Map;
import java.util.Objects;

public class Student {

	private final String firstName;
	private final String lastName;
	private final Map<String, Integer> lessons;

	public Student(String firstName, String lastName, Map<String, Integer> lessons) {
		this.lessons = lessons;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public double getAverageGrade() {
		double averageGrade = 0;
		for (Integer grade : lessons.values()) {
			if (grade != 0) {
				if (averageGrade == 0) {
					averageGrade = grade;
				} else {
					averageGrade = (averageGrade + Double.valueOf(grade)) / 2;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Objects.equals(firstName, student.firstName) &&
				Objects.equals(lastName, student.lastName) &&
				Objects.equals(lessons, student.lessons);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, lessons);
	}
}