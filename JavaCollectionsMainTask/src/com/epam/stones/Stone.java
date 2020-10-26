package com.epam.stones;

import com.epam.enums.Color;
import com.epam.enums.Transparency;
import java.util.Objects;

public abstract class Stone {

	private final String nameOfStone;
	private final double weightOfStoneInCarat;
	private final Transparency transparencyOfStone;
	private final double priceOfStonePerCarat;
	private final Color colorOfStone;

	public Stone(String nameOfStone, double weightOfStoneInCarat, Transparency transparencyOfStone,
	             double priceOfStonePerCarat, Color colorOfStone) {
		this.nameOfStone = nameOfStone;
		this.weightOfStoneInCarat = weightOfStoneInCarat;
		this.transparencyOfStone = transparencyOfStone;
		this.priceOfStonePerCarat = priceOfStonePerCarat;
		this.colorOfStone = colorOfStone;
	}

	public String getNameOfStone() {
		return nameOfStone;
	}

	public double getWeightOfStoneInCarat() {
		return weightOfStoneInCarat;
	}

	public Transparency getTransparencyOfStone() {
		return transparencyOfStone;
	}

	public double getPriceOfStonePerCarat() {
		return priceOfStonePerCarat;
	}

	public static double getPriceOfStone(Stone stone) {
		return stone.getPriceOfStonePerCarat() * stone.getWeightOfStoneInCarat();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Stone stone = (Stone) o;
		return Double.compare(stone.weightOfStoneInCarat, weightOfStoneInCarat) == 0 &&
				Double.compare(stone.priceOfStonePerCarat, priceOfStonePerCarat) == 0 &&
				Objects.equals(nameOfStone, stone.nameOfStone) &&
				transparencyOfStone == stone.transparencyOfStone &&
				colorOfStone == stone.colorOfStone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nameOfStone, weightOfStoneInCarat, transparencyOfStone, priceOfStonePerCarat, colorOfStone);
	}

	@Override
	public String toString() {
		return "Stone{" +
				"nameOfStone ='" + nameOfStone + '\'' +
				", weightOfStoneInCarat = " + weightOfStoneInCarat +
				", transparencyOfStone = " + transparencyOfStone +
				", priceOfStonePerCarat = " + priceOfStonePerCarat +
				", colorOfStone = " + colorOfStone +
				'}';
	}
}