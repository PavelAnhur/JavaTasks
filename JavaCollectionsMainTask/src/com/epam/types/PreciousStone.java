package com.epam.types;

import com.epam.enums.Color;
import com.epam.enums.PreciousStoneType;
import com.epam.enums.Transparency;
import com.epam.stones.Stone;
import java.util.Objects;

public class PreciousStone extends Stone {

	private final PreciousStoneType preciousStoneType;


	public PreciousStone(String nameOfStone, double weightOfStone, Transparency transparencyOfStone, double priceOfStone,
	                     Color colorOfStone, PreciousStoneType preciousStoneType) {
		super(nameOfStone, weightOfStone, transparencyOfStone, priceOfStone, colorOfStone);
		this.preciousStoneType = preciousStoneType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		PreciousStone that = (PreciousStone) o;
		return preciousStoneType == that.preciousStoneType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), preciousStoneType);
	}

	@Override
	public String toString() {
		return "PreciousStone{" +
				"preciousStoneType = " + preciousStoneType +
				'}';
	}
}