package com.epam.student;

import com.epam.university.Faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class StudentsList {

	private final List<Student> allStudents = new ArrayList<>();

	public void addStudentToList(Student student) {
		allStudents.add(student);
	}

	public void getStudentsWithSameFaculty(Faculty faculty) {
		for (Student student : allStudents) {
			if (student.getFaculty().equals(faculty)) {
				System.out.println(student.toString());
			}
		}
	}

	public void outputOnConsoleStudentsWithTheSameCourseAndFaculty() {
		for (Faculty faculty : Faculty.values()) {
			outputOnConsoleStudentsOnTheSameFaculty(faculty);
		}
	}

	private void outputOnConsoleStudentsOnTheSameFaculty(Faculty faculty) {

		System.out.println("Students from " + faculty.getName() + " faculty");

		for (Student allStudent : allStudents) {
			if (allStudent.getFaculty().equals(faculty)) {
				int course = 1;
				while (course <= 6) {
					if (allStudent.getCourse() == (course)) {
						System.out.println(allStudent.toString());
					}
					course++;
				}
			}
		}
	}

	private List<Student> getStudentsFromSameGroup(String numberOfGroup) {
		return allStudents.stream().filter(student -> student.getNumberOfGroup().equals(numberOfGroup)).collect(Collectors.toList());
	}

	public void outputOnConsoleStudentsFromSameGroup(String numberOfGroup) {
		List<Student> studentsFromSameGroup = getStudentsFromSameGroup(numberOfGroup);
		System.out.println("Students from " + numberOfGroup + " group");
		for (Student student : studentsFromSameGroup) {
			System.out.println(student);
		}
	}

	public void getStudentsWithDateOfBirthLessThenGiven(int yearOfBirth) {
		System.out.println("Students, who born after " + yearOfBirth + " year");
		for (Student student : allStudents) {
			int yearOfStudentBirth = getYearOfBirth(student);
			if ((yearOfStudentBirth != -1) && (yearOfStudentBirth > yearOfBirth)) {
				System.out.println(student.toString());
			}

		}
	}

	public int getYearOfBirth(Student student) {
		if (student.getDateOfBirth() != null) {
			StringBuilder dateOfBirth = new StringBuilder(student.getDateOfBirth());
			return Integer.parseInt(dateOfBirth.substring(6));
		} else {
			return -1;
		}
	}
}





