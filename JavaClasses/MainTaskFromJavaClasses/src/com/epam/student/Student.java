package com.epam.student;

import com.epam.university.Faculty;

public class Student {

	private String id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String dateOfBirth;
	private String address;
	private String phoneNumber;
	private Faculty faculty;
	private int course;
	private String numberOfGroup;

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public int getCourse() {
		return course;
	}

	public String getNumberOfGroup() {
		return numberOfGroup;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", middleName='" + middleName + '\'' +
				", dateOfBirth='" + dateOfBirth + '\'' +
				", address='" + address + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", faculty=" + faculty +
				", course=" + course +
				", numberOfGroup='" + numberOfGroup + '\'' +
				'}';
	}

	public static class Builder {
		private final Student newStudent;

		public Builder() {
			newStudent = new Student();
		}

		public Builder withId(String id) {
			newStudent.id = id;
			return this;
		}

		public Builder withFirstName(String firstName) {
			newStudent.firstName = firstName;
			return this;
		}

		public Builder withLastName(String lastName) {
			newStudent.lastName = lastName;
			return this;
		}

		public Builder withMiddleName(String middleName) {
			newStudent.middleName = middleName;
			return this;
		}

		public Builder withDateOfBirth(String dateOfBirth) {
			newStudent.dateOfBirth = dateOfBirth;
			return this;
		}

		public Builder withAddress(String address) {
			newStudent.address = address;
			return this;
		}

		public Builder withPhoneNumber(String phoneNumber) {
			newStudent.phoneNumber = phoneNumber;
			return this;
		}

		public Builder withFaculty(Faculty faculty) {
			newStudent.faculty = faculty;
			return this;
		}

		public Builder withCourse(int course) {
			newStudent.course = course;
			return this;
		}

		public Builder withNumberOfGroup(String numberOfGroup) {
			newStudent.numberOfGroup = numberOfGroup;
			return this;
		}

		public Student build() {
			return newStudent;
		}
	}
}
