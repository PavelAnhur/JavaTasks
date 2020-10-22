package com.epam;

import com.epam.university.Faculty;
import com.epam.student.Student;
import com.epam.student.StudentsList;

public class Main {

	public static void main(String[] args) {

		Student student1 = new Student.studentBuilder()
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

		Student student2 = new Student.studentBuilder()
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

		Student student3 = new Student.studentBuilder()
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

		Student student4 = new Student.studentBuilder()
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

		Student student5 = new Student.studentBuilder()
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

		Student student6 = new Student.studentBuilder()
				.withId("06")
				.withFirstName("Mole")
				.withLastName("Pole")
				.withDateOfBirth("01.12.1986")
				.withFaculty(Faculty.MF)
				.withCourse(3)
				.withNumberOfGroup("032MF")
				.build();

		Student student7 = new Student.studentBuilder()
				.withId("07")
				.withFirstName("Hugo")
				.withLastName("Boss")
				.withDateOfBirth("01.07.1987")
				.withFaculty(Faculty.MF)
				.withCourse(3)
				.withNumberOfGroup("032MF")
				.build();

		Student student8 = new Student.studentBuilder()
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
		studentsList.addStudentToList(student1);
		studentsList.addStudentToList(student2);
		studentsList.addStudentToList(student3);
		studentsList.addStudentToList(student4);
		studentsList.addStudentToList(student5);
		studentsList.addStudentToList(student6);
		studentsList.addStudentToList(student7);
		studentsList.addStudentToList(student8);

		studentsList.printOnConsoleStudentsWithSameFaculty(Faculty.EF);
		System.out.println("--------------------");
		studentsList.printOnConsoleStudentsWithTheSameCourseAndFaculty();
		System.out.println("--------------------");
		studentsList.printOnConsoleStudentsWithDateOfBirthLessThenGiven(1986);
		System.out.println("--------------------");
		studentsList.printOnConsoleStudentsFromSameGroup("032MF");
	}
}
