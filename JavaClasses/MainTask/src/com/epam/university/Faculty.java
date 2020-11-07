package com.epam.university;

public enum Faculty {
	EF("Energy"), MF("Mech"), PF("Philosophy");

	private final String name;

	Faculty(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}