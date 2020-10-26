package com.epam.types;

import com.epam.enums.Color;
import com.epam.enums.SemipreciousStoneType;
import com.epam.enums.Transparency;
import com.epam.stones.Stone;
import java.util.Objects;

public class SemipreciousStone extends Stone {

	private final SemipreciousStoneType semipreciousStoneType;

	public SemipreciousStone(String nameOfStone, double weightOfStone, Transparency transparencyOfStone,
	                         double priceOfStone, Color colorOfStone, SemipreciousStoneType semipreciousStoneType) {
		super(nameOfStone, weightOfStone, transparencyOfStone, priceOfStone, colorOfStone);
		this.semipreciousStoneType = semipreciousStoneType;
	}

	@Override
	public String toString() {
		return "SemipreciousStone{" +
				"semipreciousStoneType = " + semipreciousStoneType +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		SemipreciousStone that = (SemipreciousStone) o;
		return semipreciousStoneType == that.semipreciousStoneType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), semipreciousStoneType);
	}
}