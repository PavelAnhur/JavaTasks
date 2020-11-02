package com.epam.university;

import java.util.Objects;

public class Group extends Faculty {

	private int numberOfGroup;

	public Group(String nameOfFaculty, int numberOfGroup) {
		super(nameOfFaculty);
		this.numberOfGroup = numberOfGroup;
	}

	public int getNumberOfGroup() {
		return numberOfGroup;
	}

	public void setNumberOfGroup(int numberOfGroup) {
		this.numberOfGroup = numberOfGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Group group = (Group) o;
		return numberOfGroup == group.numberOfGroup;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), numberOfGroup);
	}

	@Override
	public String toString() {
		return "Group{" +
				"numberOfGroup=" + numberOfGroup +
				'}';
	}
}
