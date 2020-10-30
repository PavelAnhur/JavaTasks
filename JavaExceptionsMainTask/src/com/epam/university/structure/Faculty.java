package com.epam.university.structure;

public enum Faculty {
	EF("Energy"), MF("Mathematical"), PF("Philosophy");

	private final String nameOfFaculty;

	Faculty(String nameOfFaculty) {
		this.nameOfFaculty = nameOfFaculty;
	}

	public String getNameOfFaculty() {
		return nameOfFaculty;
	}
}
