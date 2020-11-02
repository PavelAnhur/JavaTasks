package com.epam;

import com.epam.exception.GradeException;
import com.epam.exception.LessonException;
import com.epam.journal.Grade;
import com.epam.university.Student;

import java.util.Arrays;
import java.util.List;

public class Main {

	static List<Student> studentList = Arrays.asList(
			new Student("EF", 1, "Pavel", "Anhur"),
			new Student("EF", 1, "Vova", "Vovochkin"),
			new Student("EF", 1, "Masha", "Mashina"),
			new Student("MF", 2, "Steve", "Stevenson"),
			new Student("MF", 2, "Mark", "Markovich"),
			new Student("PF", 3, "Ola", "Olovna"),
			new Student("MF", 2, "Koma", "Komona"),
			new Student("PF", 3, "Anya", "Anechkina"),
			new Student("MF", 2, "Bob", "Boba"),
			new Student("PF", 3, "Kira", "Rought"),
			new Student("EF", 2, "Jhon", "Mc'duck"),
			new Student("PF", 1, "Anone", "Manone"));

	public static void main(String[] args) throws LessonException, GradeException {

		Grade grade = new Grade(studentList);
		String lesson = "Math";
		grade.setGradesForLesson(lesson);
		grade.printOutStudentAndGradeForLesson(lesson);
		lesson = "English";
		grade.setGradesForLesson(lesson);
		grade.printOutStudentAndGradeForLesson(lesson);
		lesson = "Physic";
		grade.setGradesForLesson(lesson);
		grade.printOutStudentAndGradeForLesson(lesson);
	}
}
