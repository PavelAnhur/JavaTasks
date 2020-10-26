package com.epam.enumstone;

public enum Transparency {
	TRANSPARENT(2.4), TRANSLUCENT(1.9), OPAQUE(1.55);

	private final double refractiveIndex;

	Transparency(double refractiveIndex) {
		this.refractiveIndex = refractiveIndex;
	}

	public double getRefractiveIndex() {
		return refractiveIndex;
	}
}