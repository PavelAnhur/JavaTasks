package com.epam.university;

import com.epam.exception.NoFacultyException;
import com.epam.exception.NoLessonException;
import com.epam.exception.NoStudentException;

import java.util.*;

public class University {

	private final String nameOfUniversity;
	private Map<String, Faculty> faculties;

	public University(String nameOfUniversity) {
		this.nameOfUniversity = nameOfUniversity;
	}

	public University(String nameOfUniversity, Map<String, Faculty> faculties) {
		this.nameOfUniversity = nameOfUniversity;
		this.faculties = faculties;
	}

	public void addFaculty(String nameOfFaculty, Faculty faculty) {
		faculties = new HashMap<>();
		faculties.put(nameOfFaculty, faculty);
	}

	public void getFaculties() throws NoFacultyException {
		if (faculties == null) {
			throw new NoFacultyException();
		}
	}

	public void printOutAverageGradeForFacultyGroupAndLesson(String facultyName, int numberOfGroup, String nameOfLesson)
			throws NoStudentException, NoLessonException {
		Faculty faculty = faculties.get(facultyName);
		Group group = faculty.getGroupForAverageGrade(numberOfGroup);
		List<Student> studentsFromGroup = new ArrayList<>(group.getStudentsInGroup().values());
		double averageGrade = 0;
		for (Student student : studentsFromGroup) {
			if (student.getLessons().containsKey(nameOfLesson)) {
				if (student.getLessons().get(nameOfLesson) != 0) {
					if (averageGrade != 0) {
						averageGrade = (averageGrade + student.getLessons().get(nameOfLesson)) / 2;
					} else {
						averageGrade = student.getLessons().get(nameOfLesson);
					}
				}
			}
		}
		System.out.println("Average grade for " + facultyName + " group number " + numberOfGroup +
				" and lesson " + nameOfLesson + " -- > " + averageGrade);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		University that = (University) o;
		return Objects.equals(nameOfUniversity, that.nameOfUniversity) &&
				Objects.equals(faculties, that.faculties);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nameOfUniversity, faculties);
	}

	@Override
	public String toString() {
		return "University{" +
				"nameOfUniversity='" + nameOfUniversity + '\'' +
				", faculties=" + faculties +
				'}';
	}
}
