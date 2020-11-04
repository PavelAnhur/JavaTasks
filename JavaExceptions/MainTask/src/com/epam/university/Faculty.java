package com.epam.university;

import com.epam.exception.NoGroupException;
import com.epam.exception.NoStudentException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Faculty {

	private final String nameOfFaculty;
	private Map<Integer, Group> groupsOfStudent;

	public Faculty(String nameOfFaculty, Map<Integer, Group> groups) {
		this.nameOfFaculty = nameOfFaculty;
		this.groupsOfStudent = groups;
	}

	public void addGroupToFaculty(Integer numberOfGroup, Group group) throws NoStudentException {
		if (group == null) {
			throw new NoStudentException("No students in group number " + numberOfGroup);
		}
		groupsOfStudent = new HashMap<>();
		groupsOfStudent.put(numberOfGroup, group);
	}

	public String getNameOfFaculty() {
		return nameOfFaculty;
	}

	public Map<Integer, Group> getGroupsOfStudent() throws NoGroupException {
		if (groupsOfStudent == null) {
			throw new NoGroupException("No groups at " + getNameOfFaculty());
		}
		return groupsOfStudent;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Faculty faculty = (Faculty) o;
		return Objects.equals(nameOfFaculty, faculty.nameOfFaculty) &&
				Objects.equals(groupsOfStudent, faculty.groupsOfStudent);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nameOfFaculty, groupsOfStudent);
	}

	@Override
	public String toString() {
		return "Faculty{" +
				"nameOfFaculty='" + nameOfFaculty + '\'' +
				", groupsOfStudent=" + groupsOfStudent +
				'}';
	}
}