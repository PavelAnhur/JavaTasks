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

	public void printOnConsoleStudentsWithSameFaculty(Faculty faculty) {
		for (Student student : allStudents) {
			if (student.getFaculty().equals(faculty)) {
				System.out.println(student.toString());
			}
		}
	}

	public void printOnConsoleStudentsWithTheSameCourseAndFaculty() {
		for (Faculty faculty : Faculty.values()) {
			printOnConsoleStudentsOnTheSameFaculty(faculty);
		}
	}

	private void printOnConsoleStudentsOnTheSameFaculty(Faculty faculty) {

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

	public void printOnConsoleStudentsFromSameGroup(String numberOfGroup) {
		List<Student> studentsFromSameGroup = getStudentsFromSameGroup(numberOfGroup);
		System.out.println("Students from " + numberOfGroup + " group");
		for (Student student : studentsFromSameGroup) {
			System.out.println(student);
		}
	}

	public void printOnConsoleStudentsWithDateOfBirthLessThenGiven(int yearOfBirth) {
		System.out.println("Students, who born after " + yearOfBirth + " year");
		for (Student student : allStudents) {
			int yearOfStudentBirth = getYearOfBirth(student);
			if ((yearOfStudentBirth != -1) && (yearOfStudentBirth > yearOfBirth)) {
				System.out.println(student.toString());
			}
		}
	}

	private int getYearOfBirth(Student student) {
		if (student.getDateOfBirth() != null) {
			String[] separateNumbers;
			String delimiter = "\\.";
			separateNumbers = student.getDateOfBirth().split(delimiter);
			return Integer.parseInt(separateNumbers[2]);
		} else {
			return -1;
		}
	}

	private List<Student> sortStudentsToCourse(List<Student> students) {
		students.sort(new StudentCourseComparator());
		return students;
	}

	public void printOurStudentsSortedToCourse() {
		List<Student> students = sortStudentsToCourse(allStudents);
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}
}