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

	public static class studentBuilder {
		private final Student newStudent;

		public studentBuilder() {
			newStudent = new Student();
		}

		public studentBuilder withId(String id) {
			newStudent.id = id;
			return this;
		}

		public studentBuilder withFirstName(String firstName) {
			newStudent.firstName = firstName;
			return this;
		}

		public studentBuilder withLastName(String lastName) {
			newStudent.lastName = lastName;
			return this;
		}

		public studentBuilder withMiddleName(String middleName) {
			newStudent.middleName = middleName;
			return this;
		}

		public studentBuilder withDateOfBirth(String dateOfBirth) {
			newStudent.dateOfBirth = dateOfBirth;
			return this;
		}

		public studentBuilder withAddress(String address) {
			newStudent.address = address;
			return this;
		}

		public studentBuilder withPhoneNumber(String phoneNumber) {
			newStudent.phoneNumber = phoneNumber;
			return this;
		}

		public studentBuilder withFaculty(Faculty faculty) {
			newStudent.faculty = faculty;
			return this;
		}

		public studentBuilder withCourse(int course) {
			newStudent.course = course;
			return this;
		}

		public studentBuilder withNumberOfGroup(String numberOfGroup) {
			newStudent.numberOfGroup = numberOfGroup;
			return this;
		}

		public Student build() {
			return newStudent;
		}
	}
}
