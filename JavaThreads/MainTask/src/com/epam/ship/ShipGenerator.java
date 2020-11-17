package com.epam.ship;

import com.epam.port.Port;
import com.epam.ship.capasity.ShipSize;

import java.util.Objects;
import java.util.Random;

public class ShipGenerator extends Thread {

	private final Port port;
	private final int shipCount;
	private Random randomNumber;

	public ShipGenerator(Port port, int shipCount) {
		this.shipCount = shipCount;
		this.port = port;
	}

	@Override
	public void run() {
		int counter = 0;
		while (counter < shipCount) {
			Thread.currentThread().setName("Generator ship");
			counter++;
			ShipSize shipSize = getRandomShipSize();
			port.addShipInPort(new Ship(counter, getRandomContainerNumberOnShip(shipSize.getContainerCount()), shipSize));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private int getRandomContainerNumberOnShip(int maxValue) {
		randomNumber = new Random();
		return randomNumber.nextInt(maxValue);
	}

	private ShipSize getRandomShipSize() {
		randomNumber = new Random();
		switch (randomNumber.nextInt(3)) {
			case 1:
				return ShipSize.LITTLE;
			case 2:
				return ShipSize.MEDIUM;
			default:
				return ShipSize.BIG;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ShipGenerator that = (ShipGenerator) o;
		return shipCount == that.shipCount &&
				Objects.equals(port, that.port) &&
				Objects.equals(randomNumber, that.randomNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(port, shipCount, randomNumber);
	}

	@Override
	public String toString() {
		return "ShipGenerator{" +
				"port=" + port +
				", shipCount=" + shipCount +
				", randomNumber=" + randomNumber +
				'}';
	}
}
