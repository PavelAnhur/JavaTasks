package com.epam;

import java.util.ArrayList;
import java.util.List;

public class StudentsList {

	private List<Student> allStudents = new ArrayList<>();

	public List<Student> getAllStudents() {
		return allStudents;
	}

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

	private void getStudentsFromSameCourse() {
		int course = 1;
		while (course <= 6) {
			int counterOfStudents = 0;
			System.out.println("Students " + course + " course:");
			for (Student student : allStudents) {
				if (Integer.parseInt(student.getCourse()) == (course)) {
					counterOfStudents++;
				}
			}
			if (counterOfStudents == 0) {
				System.out.println("There are no students on this course");
			}
			course++;
		}
	}

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
}





