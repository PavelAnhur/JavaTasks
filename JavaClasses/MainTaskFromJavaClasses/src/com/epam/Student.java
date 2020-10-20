package com.epam;

public class Student implements Comparable<Student>{

	private String id;
	private String FirstName;
	private String LastName;
	private String middleName;
	private String dateOfBirth;
	private String address;
	private String phoneNumber;
	private String faculty;
	private String course;
	private String numberOfGroup;

	public Student(String id, String firstName, String lastName,
	               String middleName, String dateOfBirth, String address,
	               String phoneNumber, String faculty, String course, String numberOfGroup) {
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

	public Student(String id, String firstName, String lastName, String middleName, String faculty) {
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		this.middleName = middleName;
		this.faculty = faculty;
	}

	public Student(String id, String firstName, String lastName, String faculty, String course, String numberOfGroup) {
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		this.faculty = faculty;
		this.course = course;
		this.numberOfGroup = numberOfGroup;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getFaculty() {
		return faculty;
	}

	public String getCourse() {
		return course;
	}

	public String getNumberOfGroup() {
		return numberOfGroup;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id='" + id + '\'' +
				", FirstName='" + FirstName + '\'' +
				", LastName='" + LastName + '\'' +
				", middleName='" + middleName + '\'' +
				", dateOfBirth='" + dateOfBirth + '\'' +
				", address='" + address + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", faculty='" + faculty + '\'' +
				", course='" + course + '\'' +
				", numberOfGroup='" + numberOfGroup + '\'' +
				'}';
	}


	@Override
	public int compareTo(Student compareStudent) {
		int compareCourse = Integer.parseInt(compareStudent.getCourse());
		return Integer.parseInt(this.course) - compareCourse;
	}
}
