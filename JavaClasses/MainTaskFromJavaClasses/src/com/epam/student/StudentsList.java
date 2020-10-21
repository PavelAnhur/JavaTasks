package com.epam.student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class StudentsList {

	private final List<Student> allStudents = new ArrayList<>();

//	public List<Student> getAllStudents() {
//		return allStudents;
//	}

	public void addStudentToList(Student student) {
		allStudents.add(student);
	}

	public void getStudentsWithSameFaculty(String faculty) {
		for (Student student : allStudents) {
			if (student.getFaculty().equals(faculty)) {
				System.out.println(student.toString());
			}
		}
	}

//	private void getStudentsFromSameCourse() {
//		int course = 1;
//		while (course <= 6) {
//			int counterOfStudents = 0;
//			System.out.println("Students " + course + " course:");
//			for (Student student : allStudents) {
//				if (Integer.parseInt(student.getCourse()) == (course)) {
//					counterOfStudents++;
//				}
//			}
//			if (counterOfStudents == 0) {
//				System.out.println("There are no students on this course");
//			}
//			course++;
//		}
//	}

	public void outputOnConsoleStudentsWithTheSameCourseAndFaculty() {

		outputOnConsoleStudentsOnTheSameFaculty("Energy");
		outputOnConsoleStudentsOnTheSameFaculty("Mech");
		outputOnConsoleStudentsOnTheSameFaculty("Philosophy");
	}

	private void outputOnConsoleStudentsOnTheSameFaculty(String faculty) {

		System.out.println("Students from " + faculty + " faculty");

		for (Student allStudent : allStudents) {
			if (allStudent.getFaculty().equals(faculty)) {
				int course = 1;
				while (course <= 6) {
					if (Integer.parseInt(allStudent.getCourse()) == (course)) {
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

//	private int getYearOfBirthFromDateOfBirth(Student student) throws ParseException {
//		String pattern = "dd.MM.yyyy";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		Date date = simpleDateFormat.parse(student.getDateOfBirth());
//		return date.getYear();
//	}

}





