package com.epam.ship;

import com.epam.ship.capasity.ShipSize;

import java.util.Objects;

public class Ship {

	private final int shipNumber;
	private final int numberOfContainerOnShip;
	private final ShipSize shipSize;

	public Ship(int shipNumber, int numberOfContainerOnShip, ShipSize shipSize) {
		this.shipNumber = shipNumber;
		this.numberOfContainerOnShip = numberOfContainerOnShip;
		this.shipSize = shipSize;
	}

	public int getNumberOfContainerOnShip() {
		return numberOfContainerOnShip;
	}

	public ShipSize getShipSize() {
		return shipSize;
	}

	public int getShipNumber() {
		return shipNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ship ship = (Ship) o;
		return numberOfContainerOnShip == ship.numberOfContainerOnShip &&
				shipSize == ship.shipSize &&
				Objects.equals(shipNumber, ship.shipNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numberOfContainerOnShip, shipSize, shipNumber);
	}

	@Override
	public String toString() {
		return "Ship{" +
				"shipNumber='" + shipNumber + '\'' +
				", numberOfContainerOnShip=" + numberOfContainerOnShip +
				", carryingCapacity=" + shipSize +
				'}';
	}
}
