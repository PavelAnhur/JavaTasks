package com.epam.journal;

import com.epam.exception.GradeException;
import com.epam.exception.LessonException;
import com.epam.university.Student;

import java.util.*;

public class Grade {

	private final List<Student> studentList;
	private HashMap<String, Integer> mapOfGradesForMathLesson;
	private HashMap<String, Integer> mapOfGradesForEnglishLesson;
	private HashMap<String, Integer> mapOfGradesForPhysicLesson;
	private final Scanner scanner = new Scanner(System.in);
	private int inputValue;


	public Grade(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Grade grade = (Grade) o;
		return Objects.equals(studentList, grade.studentList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentList);
	}

	@Override
	public String toString() {
		return "Grade{" +
				"studentList=" + studentList +
				'}';
	}

	public void setGradesForLesson(String lesson) throws GradeException {
		HashMap<String, Integer> mapOfGradesForStudent = new HashMap<>();
		int grade;
		System.out.println(lesson + " lesson now!");
		for (Student student : studentList) {
			System.out.println("Do you want to grade student " + student.getLastName() + " y/n?");
			if (isYesAnswer()) {
				grade = getGradeForStudent();
				mapOfGradesForStudent.put(student.getLastName(), grade);
			}
		}
		switch (lesson) {
			case "Math":
				mapOfGradesForMathLesson = mapOfGradesForStudent;
				break;
			case "English":
				mapOfGradesForEnglishLesson = mapOfGradesForStudent;
				break;
			case "Physic":
				mapOfGradesForPhysicLesson = mapOfGradesForStudent;
				break;
			default:
				System.out.println("No lessons with this name");
				break;
		}
	}

	private int getGradeForStudent() throws GradeException {
		int grade;
		do {
			System.out.println("What kind of grade do you want to add for student?");
			if (isInputANumber()) {
				grade = inputValue;
				if (grade >= 0 && grade <= 10) {
					return grade;
				} else throw new GradeException("Invalid value! Grade can't be less than zero and more than 10");
			}
		} while (true);
	}

	private boolean isYesAnswer() {
		String answer;
		do {
			answer = scanner.next();
			if (answer.equals("y")) {
				return true;
			} else if (answer.equals("n")) {
				return false;
			} else {
				System.out.println("Invalid answer, can be y or n only");
			}
		} while (true);
	}

	private boolean isInputANumber() {
		do {
			try {
				inputValue = Integer.parseInt(scanner.next());
				return true;
			} catch (NumberFormatException e) {
				System.out.println("Input value not a number, try one more time please");
			}
		} while (true);
	}

	public void printOutStudentAndGradeForLesson(String lesson) throws LessonException {
		switch (lesson) {
			case "Math":
				System.out.println(lesson + " grades");
				mapOfGradesForMathLesson.forEach((key, value) -> System.out.println("Student: " + key + " grade = " + value));
				break;
			case "English":
				System.out.println(lesson + " grades");
				mapOfGradesForEnglishLesson.forEach((key, value) -> System.out.println("Student: " + key + " grade = " + value));
				break;
			case "Physic":
				System.out.println(lesson + " grades");
				mapOfGradesForPhysicLesson.forEach((key, value) -> System.out.println("Student: " + key + " grade = " + value));
				break;
			default:
				throw new LessonException("No lessons with this name");
		}
	}
}