package com.epam;

import com.epam.student.Student;
import com.epam.student.StudentsList;
import com.epam.university.Faculty;


public class Main {

	public static void main(String[] args) {

		Student student1 = new Student("01", "Pavel", "Anhur", "Vikent'evich",
				"27.07.1981", "Mendeleeva st. 8-3", "+375-33-623-58-40", Faculty.EF,
				6, "011EF");

		Student student2 = new Student("02", "Mike", "Kotlin", "Olegovich",
				"22.07.1984", "Logojskiy trakt 10-12", "+357-92-658-47-68",
				Faculty.EF, 3, "021EF");

		Student student3 = new Student("03", "Lion", "Pillone", "Halepovich", "07.21.1987",
				"Masherova st. 99-367", "+375-33-654-45-78", Faculty.EF, 5, "045EF");


		Student student4 = new Student("04", "Kate", "Ti", "Jordanovna", "06.11.1992", "Trudovaja st. 10-14",
				"+375-87-264-23-56", Faculty.PF, 2, "011PF");

		Student student5 = new Student("05", "Naomy", "Kampbel", "Krasotkovich", "01.12.1985", "Brooklin st.",
				"+375-99-999-88-77", Faculty.MF, 3, "012MF");


		StudentsList studentsList = new StudentsList();
		studentsList.addStudentToList(student1);
		studentsList.addStudentToList(student2);
		studentsList.addStudentToList(student3);
		studentsList.addStudentToList(student4);
		studentsList.addStudentToList(student5);
		studentsList.addStudentToList(new Student("06", "Mole", "Pole", Faculty.MF, 3, "012MF"));
		studentsList.addStudentToList(new Student("07", "Hugo", "Boss", Faculty.MF, 3, "012MF"));
		studentsList.addStudentToList(new Student("08", "Amoke", "Nanoke", "Vavoke", "3.12.1987",
				"Tapochkina st.", "+375-87-256-48-98", Faculty.EF, 1, "011EF"));

		studentsList.getStudentsWithSameFaculty(Faculty.EF);
		System.out.println("--------------------");
		studentsList.outputOnConsoleStudentsWithTheSameCourseAndFaculty();
		System.out.println("--------------------");
		studentsList.getStudentsWithDateOfBirthLessThenGiven(1986);
		System.out.println("--------------------");
		studentsList.outputOnConsoleStudentsFromSameGroup("012MF");
	}
}
