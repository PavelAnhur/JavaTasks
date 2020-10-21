package com.epam.student;

import com.epam.university.Faculty;

public class Student {

	private final String id;
	private final String FirstName;
	private final String LastName;
	private String middleName;
	private String dateOfBirth;
	private String address;
	private String phoneNumber;
	private final Faculty faculty;
	private final int course;
	private final String numberOfGroup;

	public Student(String id, String firstName, String lastName,
	               String middleName, String dateOfBirth, String address,
	               String phoneNumber, Faculty faculty, int course, String numberOfGroup) {
		this.id = id;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.middleName = middleName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.faculty = faculty;
		this.course = course;
		this.numberOfGroup = numberOfGroup;
	}

	public Student(String id, String firstName, String lastName, Faculty faculty, int course, String numberOfGroup) {
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		this.faculty = faculty;
		this.course = course;
		this.numberOfGroup = numberOfGroup;
	}

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
				"id ='" + id + '\'' +
				", FirstName ='" + FirstName + '\'' +
				", LastName ='" + LastName + '\'' +
				", middleName ='" + middleName + '\'' +
				", dateOfBirth ='" + dateOfBirth + '\'' +
				", address ='" + address + '\'' +
				", phoneNumber ='" + phoneNumber + '\'' +
				", faculty ='" + faculty + '\'' +
				", course ='" + course + '\'' +
				", numberOfGroup ='" + numberOfGroup + '\'' +
				'}';
	}
}
