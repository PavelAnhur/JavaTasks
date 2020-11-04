package com.epam;

import com.epam.exception.*;
import com.epam.journal.Journal;
import com.epam.university.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Main {

	public static void main(String[] args) throws GradeException, NoStudentException, NoFacultyException, NoLessonException, NoGroupException {

		String math = "Math";
		String english = "English";
		String physic = "Physic";
		Student anhur = new Student("Pasha", "Anhur", Map.of(math, 1, english, 8));
		Student vovochkin = new Student("Vova", "Vovochkin", Map.of(english, 3, physic, 9, math, 5));
		Student mashina = new Student("Masha", "Mashina", Map.of(english, 0, physic, 7, math, 0));
		Student stevenson = new Student("Steve", "Stevenson", Map.of(math, 2, physic, 4));
		Student markovich = new Student("Mark", "Markovich", Map.of(math, 6, english, 9));
		Student olovna = new Student("Ola", "Olovna", Map.of(english, 1, physic, 8));
		Student komona = new Student("Koma", "Komona", Map.of(english, 8, physic, 10));
		Student anechkina = new Student("Anya", "Anechkina", Map.of(english, 8, physic, 10));
		List<Student> studentList = Arrays.asList(anhur, vovochkin, mashina, stevenson, markovich, olovna, komona, anechkina);
		Group firstGroup = new Group(1, Map.of("Anhur", anhur, "Vovochkin", vovochkin));
		Group secondGroup = new Group(2, Map.of("Mashina", mashina, "Stevenson", stevenson));
		Group thirdGroup = new Group(3, Map.of("Markovich", markovich, "Olovna", olovna));
		Group fourthGroup = new Group(4, Map.of("Komona", komona, "Anechkina", anechkina));
		Group fifthGroup = new Group(5, null);
		Faculty eF = new Faculty("Energy faculty", Map.of(1, firstGroup, 2, secondGroup));
		Faculty mF = new Faculty("Mechanical faculty", Map.of(3, thirdGroup, 4, fourthGroup, 5, fifthGroup));
		mF.getGroupsOfStudent();
		Faculty nGF = new Faculty("No groups faculty", null);
		nGF.addGroupToFaculty(5, fifthGroup);
		University minskStateUniversity =
				new University("Minsk State University", Map.of("Energy faculty", eF, "Mechanical faculty", mF));
		University noFacultyUniversity = new University("No faculty university", null);
		noFacultyUniversity.addFaculty("Mechanical faculty", mF);
		System.out.println(noFacultyUniversity.getFaculties());
		Journal journal = new Journal(studentList);
		journal.printOutGradesForLesson("Math");
		journal.printOutGradesForLesson("English");
		journal.printOutGradesForLesson("Physic");
		journal.printOutAverageGradeForAllLessonToStudent();
		minskStateUniversity.printOutAverageGradeForFacultyGroupAndLesson("Energy faculty", 1, "Math");
		journal.printOutAverageGradeForAllUniversity();
	}
}
