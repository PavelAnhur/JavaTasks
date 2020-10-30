package com.epam.student;

import com.epam.exception.MyException;
import com.epam.university.structure.Faculty;
import com.epam.university.structure.Lesson;
import com.epam.university.journal.Journal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfStudents {

	private final List<Student> studentList = new ArrayList<>();
	private List<Journal> mathGrades;
	private List<Journal> englishGrades;
	private List<Journal> physicGrades;

	public void addStudentToList(Student student) {
		studentList.add(student);
	}

	public List<Journal> setMathGrades() throws MyException {
		mathGrades = setGradesForLesson(Lesson.MATH);
		return mathGrades;
	}

	public List<Journal> setEnglishGrades() throws MyException {
		englishGrades = setGradesForLesson(Lesson.ENGLISH);
		return englishGrades;
	}

	public List<Journal> setPhysicGrades() throws MyException {
		physicGrades = setGradesForLesson(Lesson.PHYSICS);
		return physicGrades;
	}

	public void printOutGradesForEachStudent(List<Journal> scores) throws MyException {
		for (Journal score : scores) {
			if (score.getGrades() >= 0 && score.getGrades() <= 10) {
				System.out.println(score.toString());
			} else throw new MyException("Score can't be less than 0 and more than 10");
		}
	}

	public void printOutAverageGradeForAllLessons() {
		HashMap<String, Double> mapOfStudentAndAverageGrade = getAverageGradeForAllLessonsOfStudent();
		mapOfStudentAndAverageGrade.forEach((key, value) -> System.out.println("Student: " +
				key + " with average grade of lessons  = " + value));
	}

	public void printOutSortedListToLessonGroupFaculty(List<Journal> grades) {
		grades.forEach(System.out::println);
	}

	private List<Journal> setGradesForLesson(Lesson lesson) throws MyException {
		List<Journal> grades = new ArrayList<>();
		for (Student student : studentList) {
			grades.add(new Journal(student.getLastName(), lesson, numberOfScore()));
		}
		return grades;
	}

	private int numberOfScore() throws MyException {
		int number;
		number = (int) (Math.random() * 10 + 1);
		if (number >= 0 && number <= 10) {
			return number;
		} else throw new MyException("Number can't be less than 0 and more than 10");
	}

	private HashMap<String, Double> getAverageGradeForAllLessonsOfStudent() {
		HashMap<String, Double> mapOfAverageGradeForStudent = new HashMap<>();
		double averageGrade;
		for (int i = 0; i < studentList.size(); i++) {

			averageGrade = (double) (mathGrades.get(i).getGrades() + englishGrades.get(i).getGrades()
					+ physicGrades.get(i).getGrades()) / 3;
			mapOfAverageGradeForStudent.put(studentList.get(i).getLastName(), averageGrade);
		}
		return mapOfAverageGradeForStudent;
	}

	public List<Journal> getAverageGradeSortedToLessonGroupFaculty
			(Lesson lesson, int group, Faculty faculty) {
		List<Student> listOfStudent = studentList;
		listOfStudent.stream()
				.filter(student -> student.getNumberOfGroup() == group)
				.filter(student -> student.getNameOfFaculty() == faculty)
				.collect(Collectors.toList());
		List<Journal> gradesOfLesson;
		if (lesson.equals(Lesson.ENGLISH)) {
			gradesOfLesson = englishGrades;
		} else if (lesson.equals(Lesson.MATH)) {
			gradesOfLesson = mathGrades;
		} else {
			gradesOfLesson = physicGrades;
		}
		for (int i = 0; i < gradesOfLesson.size(); i++) {
			if (!listOfStudent.get(i).getLastName().equals(gradesOfLesson.get(i).getLastNameOfStudent())) {
				gradesOfLesson.remove(i);
			}
		}
		return gradesOfLesson;
	}
}