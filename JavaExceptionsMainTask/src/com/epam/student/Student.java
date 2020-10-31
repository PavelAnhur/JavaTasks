package com.epam.student;

import com.epam.university.structure.Faculty;
import java.util.Objects;

public class Student {

	private final String firstName;
	private final String lastName;
	private final int numberOfGroup;
	private final Faculty nameOfFaculty;

	public Student(String firstName, String lastName, int numberOfGroup, Faculty nameOfFaculty) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.numberOfGroup = numberOfGroup;
		this.nameOfFaculty = nameOfFaculty;
	}

	public String getLastName() {
		return lastName;
	}

	public int getNumberOfGroup() {
		return numberOfGroup;
	}

	public Faculty getNameOfFaculty() {
		return nameOfFaculty;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return numberOfGroup == student.numberOfGroup &&
				Objects.equals(firstName, student.firstName) &&
				Objects.equals(lastName, student.lastName) &&
				nameOfFaculty == student.nameOfFaculty;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, numberOfGroup, nameOfFaculty);
	}

	@Override
	public String toString() {
		return "Student{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", numberOfGroup=" + numberOfGroup +
				", nameOfFaculty=" + nameOfFaculty +
				'}';
	}
}
