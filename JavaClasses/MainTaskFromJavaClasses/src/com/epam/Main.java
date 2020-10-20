package com.epam;

import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {

		Student student1 = new Student("01", "Pavel", "Anhur", "Vikent'evich",
				"27.07.1981", "Mendeleeva st. 8-3", "+375-33-623-58-40", "Energy",
				"6", "011EF");

		Student student2 = new Student("02", "Mike", "Kotlin", "Olegovich",
				"22.07.1984", "Logojskiy trakt 10-12", "+357-92-658-47-68",
				"Energy", "3", "021EF");

		Student student3 = new Student("03", "Lion", "Pillone", "Halepovich", "07.21.1987",
				"Masherova st. 99-367", "+375-33-654-45-78", "Energy", "5", "045EF");


		Student student4 = new Student("04", "Kate", "Ti", "Jordanovna", "06.11.1992", "Trudovaja st. 10-14",
				"+375-87-264-23-56", "Philosophy", "2", "011PF");

		Student student5 = new Student("05", "Naomy", "Kampbel", "Krasotkovich", "01.12.1985", "Brooklin st.",
				"+375-99-999-88-77", "Mech", "3", "012MF");


		StudentsList studentsList = new StudentsList();
		studentsList.addStudentToList(student1);
		studentsList.addStudentToList(student2);
		studentsList.addStudentToList(student3);
		studentsList.addStudentToList(student4);
		studentsList.addStudentToList(student5);
		studentsList.addStudentToList(new Student("06","Mole","Pole","Mech", "3", "012MF"));
		studentsList.addStudentToList(new Student("07", "Hugo", "Boss", "Mech", "3", "012MF"));

		studentsList.getStudentsWithSameFaculty("Energy");
		System.out.println("--------------------");
		studentsList.outputOnConsoleStudentsWithTheSameCourseAndFaculty();

	}
}
