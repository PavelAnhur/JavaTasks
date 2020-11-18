package com.epam.ship;

import com.epam.port.Port;

import java.util.Objects;
import java.util.concurrent.Semaphore;

public class ShipThread extends Thread {

	private final Ship ship;
	private final Semaphore pierNumber;
	private static volatile int numberContainerInPort = 5;

	public ShipThread(Ship ship, Semaphore pierNumber) {
		this.ship = ship;
		this.pierNumber = pierNumber;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			if (ship.getNumberOfContainerOnShip() > 0) {
				deductContainerFromShip();
			} else if (ship.getNumberOfContainerOnShip() == 0){
				addContainerOnShip();
			} else {
				addContainerOnShip();
			}
			System.err.println("Ship number " + ship.getShipNumber() + " leaving our port");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private synchronized void addContainerOnShip() {
		try {
			pierNumber.acquire();
			int containerNumber = ship.getNumberOfContainerOnShip();
			while (containerNumber < ship.getShipSize().getContainerCount()) {
				if (numberContainerInPort == 0) {
					deductContainerFromShip();
				}
				numberContainerInPort--;
				containerNumber++;
				System.out.println("<<<Container " + containerNumber + " added on ship number " + ship.getShipNumber() + ". " +
						"Number containers in port = " + numberContainerInPort + ">>>");
				Thread.sleep(100);
			}
			pierNumber.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private synchronized void deductContainerFromShip() {
		try {
			pierNumber.acquire();
			int containerNumber = ship.getNumberOfContainerOnShip();
			while (containerNumber > 0) {
				if (numberContainerInPort == Port.MAX_CONTAINER_VOLUME_FOR_PORT) {
					addContainerOnShip();
				}
				numberContainerInPort++;
				System.out.println("***Container " + containerNumber + " unload from ship number " + ship.getShipNumber() + ". " +
						"Number containers in port = " + numberContainerInPort + "***");
				containerNumber--;
				Thread.sleep(100);
			}
			pierNumber.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ShipThread that = (ShipThread) o;
		return Objects.equals(ship, that.ship);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ship);
	}
}
