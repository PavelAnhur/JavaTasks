package com.epam.university;

import java.util.Objects;

public class Faculty {

	private String nameOfFaculty;

	public Faculty(String nameOfFaculty) {
		this.nameOfFaculty = nameOfFaculty;
	}

	public String getNameOfFaculty() {
		return nameOfFaculty;
	}

	public void setNameOfFaculty(String nameOfFaculty) {
		this.nameOfFaculty = nameOfFaculty;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Faculty faculty = (Faculty) o;
		return Objects.equals(nameOfFaculty, faculty.nameOfFaculty);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nameOfFaculty);
	}

	@Override
	public String toString() {
		return "Faculty{" +
				"nameOfFaculty='" + nameOfFaculty + '\'' +
				'}';
	}
}