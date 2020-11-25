package com.epam.port;

import com.epam.ship.Ship;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class Port {

	public static BlockingQueue<Ship> shipsInPort;
	public static final int MAX_CONTAINER_VOLUME_FOR_PORT = 20;
	private int numberShipInPort = 0;
	public static volatile int numberContainerInPort = 5;
	private static Semaphore pierNumber;

	public Port(int shipCount, Semaphore pierNumber) {
		this.shipsInPort = new ArrayBlockingQueue<>(shipCount);
		this.pierNumber = pierNumber;
	}

	public synchronized void addShipInPort(Ship ship) {
		shipsInPort.add(ship);
		numberShipInPort++;
		System.out.println("\nThe ship arrived in the port: " + Thread.currentThread().getName() + " \n" +
				"Ship number: " + ship.getShipNumber()+ " with carrying capacity: "
				+ ship.getShipSize() + " and " + ship.getNumberOfContainerOnShip() + " containers on a board \n");
	}

	public BlockingQueue<Ship> getShipsInPort() {
		return shipsInPort;
	}

	public static Semaphore getPierNumber() {
		return pierNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Port port = (Port) o;
		return numberShipInPort == port.numberShipInPort &&
				Objects.equals(shipsInPort, port.shipsInPort);
	}

	@Override
	public int hashCode() {
		return Objects.hash(shipsInPort, numberShipInPort);
	}

	@Override
	public String toString() {
		return "Port{" +
				"shipsInPort=" + shipsInPort +
				'}';
	}
}
