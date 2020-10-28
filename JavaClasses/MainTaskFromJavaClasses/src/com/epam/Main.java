package com.epam;

import com.epam.student.StudentCourseComparator;
import com.epam.university.Faculty;
import com.epam.student.Student;
import com.epam.student.StudentsList;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {

		Student studentAnhur = new Student.StudentBuilder()
				.withId("01")
				.withFirstName("Pavel")
				.withLastName("Anhur")
				.withMiddleName("Vikent'evich")
				.withDateOfBirth("27.07.1981")
				.withAddress("Mendeleeva st. 8-3")
				.withPhoneNumber("+375-33-623-58-40")
				.withFaculty(Faculty.EF)
				.withCourse(6)
				.withNumberOfGroup("011EF")
				.build();

		Student studentKotlin = new Student.StudentBuilder()
				.withId("02")
				.withFirstName("Mike")
				.withLastName("Kotlin")
				.withMiddleName("Olegovich")
				.withDateOfBirth("22.07.1984")
				.withAddress("Logojskiy trakt 10-12")
				.withPhoneNumber("+357-92-658-47-68")
				.withFaculty(Faculty.EF)
				.withCourse(3)
				.withNumberOfGroup("021EF")
				.build();

		Student studentPillone = new Student.StudentBuilder()
				.withId("03")
				.withFirstName("Lion")
				.withLastName("Pillone")
				.withMiddleName("Halepovich")
				.withDateOfBirth("07.21.1987")
				.withAddress("Masherova st. 99-367")
				.withPhoneNumber("+375-33-654-45-78")
				.withFaculty(Faculty.EF)
				.withCourse(5)
				.withNumberOfGroup("045EF")
				.build();

		Student studentTi = new Student.StudentBuilder()
				.withId("04")
				.withFirstName("Kate")
				.withLastName("Ti")
				.withMiddleName("Jordanovna")
				.withDateOfBirth("06.11.1992")
				.withAddress("Trudovaja st. 10-14")
				.withPhoneNumber("+375-87-264-23-56")
				.withFaculty(Faculty.PF)
				.withCourse(2)
				.withNumberOfGroup("021PF")
				.build();

		Student studentKampbel = new Student.StudentBuilder()
				.withId("05")
				.withFirstName("Naomy")
				.withLastName("Kampbel")
				.withMiddleName("Krasotkovich")
				.withDateOfBirth("01.12.1985")
				.withAddress("Brooklin st.")
				.withPhoneNumber("+375-99-999-88-77")
				.withFaculty(Faculty.MF)
				.withCourse(3)
				.withNumberOfGroup("032MF")
				.build();

		Student studentPole = new Student.StudentBuilder()
				.withId("06")
				.withFirstName("Mole")
				.withLastName("Pole")
				.withDateOfBirth("01.12.1986")
				.withFaculty(Faculty.MF)
				.withCourse(3)
				.withNumberOfGroup("032MF")
				.build();

		Student studentBoss = new Student.StudentBuilder()
				.withId("07")
				.withFirstName("Hugo")
				.withLastName("Boss")
				.withDateOfBirth("01.07.1987")
				.withFaculty(Faculty.MF)
				.withCourse(3)
				.withNumberOfGroup("032MF")
				.build();

		Student studentNanoke = new Student.StudentBuilder()
				.withId("08")
				.withFirstName("Amoke")
				.withLastName("Nanoke")
				.withMiddleName("Vavoke")
				.withDateOfBirth("3.12.1987")
				.withAddress("Tapochkina st.")
				.withPhoneNumber("+375-87-256-48-98")
				.withFaculty(Faculty.EF)
				.withCourse(1)
				.withNumberOfGroup("011EF")
				.build();

		StudentsList studentsList = new StudentsList();
		studentsList.addStudentToList(studentAnhur);
		studentsList.addStudentToList(studentKotlin);
		studentsList.addStudentToList(studentPillone);
		studentsList.addStudentToList(studentTi);
		studentsList.addStudentToList(studentKampbel);
		studentsList.addStudentToList(studentPole);
		studentsList.addStudentToList(studentBoss);
		studentsList.addStudentToList(studentNanoke);

		studentsList.printOnConsoleStudentsWithSameFaculty(Faculty.EF);
		String string = "--------------------";
		System.out.println(string);
		studentsList.printOnConsoleStudentsWithTheSameCourseAndFaculty();
		System.out.println(string);
		studentsList.printOnConsoleStudentsWithDateOfBirthLessThenGiven(1986);
		System.out.println(string);
		studentsList.printOnConsoleStudentsFromSameGroup("032MF");
		Comparator courseComparator = new StudentCourseComparator();
		System.out.println("Sorted student by course");
		studentsList.printOurStudentsSortedToCourse();
	}
}