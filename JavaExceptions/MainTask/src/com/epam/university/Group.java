package com.epam.university;

import com.epam.exception.NoStudentException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Group {

	private final int numberOfGroup;
	private Map<String, Student> studentsInGroup;

	public Group(int numberOfGroup, Map<String, Student> studentsInGroup) {
		this.numberOfGroup = numberOfGroup;
		this.studentsInGroup = studentsInGroup;
	}

	public void addStudentToGroup(String lastName, Student student) {
		studentsInGroup = new HashMap<>();
		studentsInGroup.put(lastName, student);
	}

	public int getNumberOfGroup() {
		return numberOfGroup;
	}

	public Map<String, Student> getStudentsInGroup() throws NoStudentException {
		if (studentsInGroup == null) {
			throw new NoStudentException("No students in group number " + getNumberOfGroup());
		}
		return studentsInGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Group group = (Group) o;
		return numberOfGroup == group.numberOfGroup &&
				Objects.equals(studentsInGroup, group.studentsInGroup);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numberOfGroup, studentsInGroup);
	}

	@Override
	public String toString() {
		return "Group{" +
				"numberOfGroup=" + numberOfGroup +
				", studentsInGroup=" + studentsInGroup +
				'}';
	}
}