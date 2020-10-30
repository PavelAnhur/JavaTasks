package com.epam;

import com.epam.exception.MyException;
import com.epam.student.ListOfStudents;
import com.epam.student.Student;
import com.epam.university.structure.Faculty;
import com.epam.university.structure.Lesson;

public class Main {

    public static void main(String[] args) throws MyException {
        ListOfStudents listOfStudents = new ListOfStudents();
        listOfStudents.addStudentToList(new Student("Pavel","Anhur",1, Faculty.EF));
        listOfStudents.addStudentToList(new Student("Vova","Vovochkin",1,Faculty.EF));
        listOfStudents.addStudentToList(new Student("Masha","Mashina", 1, Faculty.EF));
        listOfStudents.addStudentToList(new Student("Steve","Stevenson",2,Faculty.MF));
        listOfStudents.addStudentToList(new Student("Mark", "Markovich",2,Faculty.MF));
        listOfStudents.addStudentToList(new Student("Ola","Olovna",3,Faculty.PF));
        listOfStudents.addStudentToList(new Student("Koma","Komona", 2,Faculty.MF));
        listOfStudents.addStudentToList(new Student("Anya", "Anechkina",3,Faculty.PF));
        listOfStudents.addStudentToList(new Student("Bob","Boba",2,Faculty.MF));
        listOfStudents.addStudentToList(new Student("Kira","Rought",3,Faculty.PF));
        listOfStudents.addStudentToList(new Student("Jhon","Mc'duck",2,Faculty.EF));
        listOfStudents.addStudentToList(new Student("Anone","Manone",1,Faculty.PF));

        System.out.println("Math grades:");
        listOfStudents.printOutGradesForEachStudent(listOfStudents.setMathGrades());
        System.out.println("English grades:");
        listOfStudents.printOutGradesForEachStudent(listOfStudents.setEnglishGrades());
        System.out.println("Physic grades:");
        listOfStudents.printOutGradesForEachStudent(listOfStudents.setPhysicGrades());
        listOfStudents.printOutAverageGradeForAllLessons();
        listOfStudents.printOutSortedListToLessonGroupFaculty
                (listOfStudents.getAverageGradeSortedToLessonGroupFaculty(Lesson.MATH,1,Faculty.EF));
    }
}
