package com.epam.journal;

import com.epam.exception.GradeException;
import com.epam.exception.NoLessonException;
import com.epam.university.Student;

import java.util.List;

public class Journal {

	private final List<Student> studentList;

	public Journal(List<Student> studentList) {
		this.studentList = studentList;
	}

	public void printOutGradesForLesson(String lesson) throws NoLessonException, GradeException {
		System.out.println(lesson + " lesson");
		for (Student student : studentList) {
			if (student.getLessons().containsKey(lesson)) {
				if (student.getLessons().get(lesson) >= 0 && student.getLessons().get(lesson) <= 10) {
					System.out.println("Student " + student.getLastName() + ", grade " + student.getLessons().get(lesson));
				} else throw new GradeException();
			}
		}
	}

	public void printOutAverageGradeForAllLessonToStudent() {
		System.out.println("Average grades for all lessons");
		for (Student student : studentList) {
			System.out.println("Student " + student.getLastName() + " with average grade -> " + student.getAverageGrade());
		}
	}

	public void printOutAverageGradeForAllUniversity() {
		double averageGrade = 0;
		for (Student student : studentList) {
			if (student.getAverageGrade() != 0) {
				if (averageGrade != 0) {
					averageGrade = (averageGrade + student.getAverageGrade()) / 2;
				} else averageGrade = student.getAverageGrade();
			}
		}
		System.out.println("Average grade for all university is: " + averageGrade);
	}
}