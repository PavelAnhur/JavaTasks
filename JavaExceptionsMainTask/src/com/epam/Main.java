package com.epam;

import com.epam.exception.GradeException;
import com.epam.exception.StudentException;
import com.epam.student.Student;
import com.epam.university.journal.Grades;
import com.epam.university.structure.Faculty;
import com.epam.university.structure.Lesson;

import java.util.Arrays;
import java.util.List;

public class Main {

	static List<Student> listOfStudents = Arrays.asList(
			new Student("Pavel", "Anhur", 1, Faculty.EF),
			new Student("Vova", "Vovochkin", 1, Faculty.EF),
			new Student("Masha", "Mashina", 1, Faculty.EF),
			new Student("Steve", "Stevenson", 2, Faculty.MF),
			new Student("Mark", "Markovich", 2, Faculty.MF),
			new Student("Ola", "Olovna", 3, Faculty.PF),
			new Student("Koma", "Komona", 2, Faculty.MF),
			new Student("Anya", "Anechkina", 3, Faculty.PF),
			new Student("Bob", "Boba", 2, Faculty.MF),
			new Student("Kira", "Rought", 3, Faculty.PF),
			new Student("Jhon", "Mc'duck", 2, Faculty.EF),
			new Student("Anone", "Manone", 1, Faculty.PF));

	public static final int NUMBER_OF_LESSONS_FOR_SUBJECT = 9;
	public static final int MAX_VALUE_OF_GRADE = 10;
	public static final int MIN_VALUE_OF_GRADE = 0;

	public static void main(String[] args) throws GradeException, StudentException {

		Grades grades = new Grades(listOfStudents);

		System.out.println("Math grades:");  //выставление оценок
		grades.printOutGradesForEachStudent(grades.setMathGrades());
		System.out.println("English grades:");
		grades.printOutGradesForEachStudent(grades.setEnglishGrades());
		System.out.println("Physic grades:");
		grades.printOutGradesForEachStudent(grades.setPhysicGrades());
		grades.setGradesForLesson(Lesson.MATH, "Olovna", 9);  //выставление оценок вручную
		grades.setGradesForLesson(Lesson.ENGLISH, "Olovna", 5);
		String partOfOutputString = "Average grades for ";
		Lesson lesson = Lesson.MATH;
		System.out.println(partOfOutputString + lesson.toString() + ":");
		grades.outputAverageGradesForLessonForEveryStudent(grades.getAverageGradeForLesson(lesson), lesson);
		lesson = Lesson.ENGLISH;
		System.out.println(partOfOutputString + lesson.toString() + ":");
		grades.outputAverageGradesForLessonForEveryStudent(grades.getAverageGradeForLesson(lesson), lesson);
		lesson = Lesson.PHYSIC;
		System.out.println(partOfOutputString + lesson.toString() + ":");
		grades.outputAverageGradesForLessonForEveryStudent(grades.getAverageGradeForLesson(lesson), lesson);
		System.out.println("-----------------------");
		grades.printOutAverageGradeForAllLessons();
		int groupNumber = 2;            //группа, факультет, и урок для сортировки
		Faculty faculty = Faculty.MF;
		lesson = Lesson.PHYSIC;
		System.out.println("Average grade for student sorted by group number " + groupNumber +
				", " + faculty.getNameOfFaculty() + " faculty and " + lesson + " lesson = "
				+ grades.getAverageGradeForSortedStudents(grades
				.getSortedListToLessonGroupFaculty(groupNumber, faculty, lesson)));
		lesson = Lesson.MATH;
		grades.printOutAverageGradeForUniversityByLesson(lesson);
	}
}