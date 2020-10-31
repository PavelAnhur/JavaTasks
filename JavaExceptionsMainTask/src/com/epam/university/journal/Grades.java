package com.epam.university.journal;

import com.epam.Main;
import com.epam.exception.GradeException;
import com.epam.exception.StudentException;
import com.epam.student.Student;
import com.epam.university.structure.Faculty;
import com.epam.university.structure.Lesson;

import java.util.*;
import java.util.stream.Collectors;

public class Grades {
	private final List<Student> studentList;
	private List<Journal> mathGrades;
	private List<Journal> englishGrades;
	private List<Journal> physicGrades;
	private Random random;

	public Grades(List<Student> studentList) {
		this.studentList = studentList;
	}

	public void printOutAverageGradeForAllLessons() throws StudentException {
		HashMap<String, Double> mapOfStudentAndAverageGrade = getAverageGradeForAllLessonsOfStudent();
		mapOfStudentAndAverageGrade.forEach((key, value) -> System.out.println("Student: " +
				key + " with average grade of lessons  = " + value));
	}

	public void printOutGradesForEachStudent(List<Journal> grades) throws GradeException {
		for (Journal grade : grades) {
			if (grade.getGrade() >= 0 && grade.getGrade() <= 10) {
				System.out.println(grade.toString());
			} else throw new GradeException("Score can't be less than 0 and more than 10");
		}
	}

	public List<Journal> getSortedListToLessonGroupFaculty(int group, Faculty faculty, Lesson lesson) {
		List<Journal> grades = getCurrentGradesOfLesson(lesson);

		return grades.stream()
				.filter(student -> student.getStudent().getNameOfFaculty().equals(faculty))
				.filter(student -> student.getStudent().getNumberOfGroup() == group)
				.collect(Collectors.toList());
	}

	public double getAverageGradeForSortedStudents(List<Journal> grades) {
		double averageGrade = 0;
		for (Journal grade : grades) {
			averageGrade += grade.getGrade();
		}
		averageGrade /= grades.size();
		return averageGrade;
	}

	public void printOutAverageGradeForUniversityByLesson(Lesson lesson) {
		System.out.println("Average grade for University by " + lesson +
				" lesson = " + getAverageGradeForUniversityByLesson(lesson));
	}

	public List<Journal> setMathGrades() throws GradeException {
		mathGrades = setGradesForLesson(Lesson.MATH, Main.NUMBER_OF_LESSONS_FOR_SUBJECT);
		return mathGrades;
	}

	public List<Journal> setEnglishGrades() throws GradeException {
		englishGrades = setGradesForLesson(Lesson.ENGLISH, Main.NUMBER_OF_LESSONS_FOR_SUBJECT);
		return englishGrades;
	}

	public List<Journal> setPhysicGrades() throws GradeException {
		physicGrades = setGradesForLesson(Lesson.PHYSIC, Main.NUMBER_OF_LESSONS_FOR_SUBJECT);
		return physicGrades;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Grades grades = (Grades) o;
		return Objects.equals(studentList, grades.studentList) &&
				Objects.equals(mathGrades, grades.mathGrades) &&
				Objects.equals(englishGrades, grades.englishGrades) &&
				Objects.equals(physicGrades, grades.physicGrades);
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentList, mathGrades, englishGrades, physicGrades);
	}

	public void setGradesForLesson(Lesson lesson, String lastNameOfStudent, int grade) throws GradeException {
		int lessonGrade = valueOfGrade(grade);
		for (Student student : studentList) {
			if (lesson.equals(Lesson.MATH)) {
				if (lastNameOfStudent.equals(student.getLastName())) {
					mathGrades.add(new Journal(student, lesson, lessonGrade));
				}
			} else if (lesson.equals(Lesson.ENGLISH)) {
				if (lastNameOfStudent.equals(student.getLastName())) {
					englishGrades.add(new Journal(student, lesson, lessonGrade));
				}
			} else {
				if (lastNameOfStudent.equals(student.getLastName())) {
					physicGrades.add(new Journal(student, lesson, lessonGrade));
				}
			}
		}
	}

	public List<Journal> setGradesForLesson(Lesson lesson, int numberOfLessonsOnThisSubject) throws GradeException {
		int index;
		random = new Random();
		List<Journal> grades = new ArrayList<>();
		while (numberOfLessonsOnThisSubject > 0) {
			index = random.nextInt(studentList.size());
			grades.add(new Journal(studentList.get(index), lesson, randomNumber()));
			numberOfLessonsOnThisSubject--;
		}
		return grades;
	}

	private int randomNumber() throws GradeException {
		random = new Random();
		int number = random.nextInt((Main.MAX_VALUE_OF_GRADE - Main.MIN_VALUE_OF_GRADE) + 1) + Main.MIN_VALUE_OF_GRADE;
		if ((number >= 0) && (number <= 10)) {
			return number;
		} else throw new GradeException("Number can't be less than 0 and more than 10");
	}

	private int valueOfGrade(int grade) throws GradeException {
		if (grade >= 0 && grade <= 10) {
			return grade;
		} else throw new GradeException("Number can't be less than 0 and more than 10");
	}

	private HashMap<String, Double> getAverageGradeForAllLessonsOfStudent() throws StudentException {
		HashMap<String, Double> mapOfAverageGradeForStudent = new HashMap<>();
		double averageGrade;
		mathGrades = getAverageGradeForLesson(Lesson.MATH);
		englishGrades = getAverageGradeForLesson(Lesson.ENGLISH);
		physicGrades = getAverageGradeForLesson(Lesson.PHYSIC);
		int counterOfGradeNotZero;
		for (int i = 0; i < studentList.size(); i++) {
			counterOfGradeNotZero = 0;
			if (mathGrades.get(i).getGrade() != 0) {
				counterOfGradeNotZero++;
			}
			if (englishGrades.get(i).getGrade() != 0) {
				counterOfGradeNotZero++;
			}
			if (physicGrades.get(i).getGrade() != 0) {
				counterOfGradeNotZero++;
			}
			if (counterOfGradeNotZero != 0) {
				averageGrade = (mathGrades.get(i).getGrade() + englishGrades.get(i).getGrade()
						+ physicGrades.get(i).getGrade()) / counterOfGradeNotZero;
				mapOfAverageGradeForStudent.put(studentList.get(i).getLastName(), averageGrade);
			} else throw new StudentException("Student " + studentList.get(i).getLastName() + " without any lesson");
		}
		return mapOfAverageGradeForStudent;
	}

	private List<Journal> getCurrentGradesOfLesson(Lesson lesson) {
		if (lesson.equals(Lesson.MATH)) {
			return mathGrades;
		} else if (lesson.equals(Lesson.ENGLISH)) {
			return englishGrades;
		} else {
			return physicGrades;
		}
	}

	private double getAverageGradeForUniversityByLesson(Lesson lesson) {
		List<Journal> grades;
		grades = getCurrentGradesOfLesson(lesson);
		double averageGrade = 0;
		for (Journal grade : grades) {
			averageGrade += grade.getGrade();
		}
		return averageGrade / grades.size();
	}

	public List<Journal> getAverageGradeForLesson(Lesson lesson) {
		List<Journal> newJournalForLesson = new ArrayList<>();
		for (Student student : studentList) {
			newJournalForLesson.add(new Journal(student, lesson, 0));
		}
		for (Journal averageGrade : newJournalForLesson) {
			for (Journal grade : getCurrentGradesOfLesson(lesson)) {
				if (averageGrade.getStudent().getLastName().equals(grade.getStudent().getLastName())) {
					if (averageGrade.getGrade() == 0) {
						averageGrade.setGrade(grade.getGrade());
					} else {
						averageGrade.setGrade((averageGrade.getGrade() + grade.getGrade()) / 2);
					}
				}
			}
		}
		return newJournalForLesson;
	}

	public void outputAverageGradesForLessonForEveryStudent(List<Journal> averageGrades, Lesson lesson) {
		for (Journal grade : averageGrades) {
			System.out.println("Student " + grade.getStudent().getLastName() + " with average " +
					" grade: " + grade.getGrade() + " " + lesson + " lesson");
		}
	}
}