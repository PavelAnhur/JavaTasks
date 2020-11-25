package com.epam.ship;

import com.epam.port.Port;
import com.epam.ship.capasity.ShipSize;

import java.util.Objects;

public class Ship extends Thread {

	private int shipNumber;
	private int numberOfContainerOnShip;
	private ShipSize shipSize;

	public Ship(int shipNumber, int numberOfContainerOnShip, ShipSize shipSize) {
		this.shipNumber = shipNumber;
		this.numberOfContainerOnShip = numberOfContainerOnShip;
		this.shipSize = shipSize;
	}

	public Ship() {
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
	public void run() {
		try {
			Ship ship = Port.shipsInPort.take();
			Thread.sleep(500);
			if (ship.getNumberOfContainerOnShip() > 0 && Port.numberContainerInPort < Port.MAX_CONTAINER_VOLUME_FOR_PORT) {
				deductContainerFromShip(ship);
			} else if (ship.getNumberOfContainerOnShip() == 0 && Port.numberContainerInPort > 0) {
				addContainerOnShip(ship);
			}
				System.err.println("Ship number " + ship.getShipNumber() + " leaving our port");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private synchronized void addContainerOnShip(Ship ship) {
		try {
			Port.getPierNumber().acquire();
			int containerNumber = ship.getNumberOfContainerOnShip();
			while (containerNumber < ship.getShipSize().getContainerCount()) {
				if (Port.numberContainerInPort == 0) {
					Thread.currentThread().interrupt();
					return;
				} else {
					Port.numberContainerInPort--;
					containerNumber++;
					System.out.println("<<<Container " + containerNumber + " added on ship number " + ship.getShipNumber() + ". " +
							"Number containers in port = " + Port.numberContainerInPort + ">>>");
					Thread.sleep(100);
				}
			}
			Port.getPierNumber().release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private synchronized void deductContainerFromShip(Ship ship) {
		try {
			Port.getPierNumber().acquire();
			int containerNumber = ship.getNumberOfContainerOnShip();
			while (containerNumber > 0) {
				if (Port.numberContainerInPort == Port.MAX_CONTAINER_VOLUME_FOR_PORT) {
					Thread.currentThread().interrupt();
					return;
				} else {
					Port.numberContainerInPort++;
					System.out.println("***Container " + containerNumber + " unload from ship number " + ship.getShipNumber() + ". " +
							"Number containers in port = " + Port.numberContainerInPort + "***");
					containerNumber--;
					Thread.sleep(100);
				}
			}
			Port.getPierNumber().release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
