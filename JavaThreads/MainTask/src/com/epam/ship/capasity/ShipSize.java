package com.epam.ship.capasity;

public enum ShipSize {
	LITTLE(2), MEDIUM(5), BIG(10);

	private final int containerCount;

	ShipSize(int containerCount) {
		this.containerCount = containerCount;
	}

	public int getContainerCount() {
		return containerCount;
	}
}
