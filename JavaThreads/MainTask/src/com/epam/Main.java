package com.epam;

import com.epam.port.Port;
import com.epam.ship.Ship;
import com.epam.ship.ShipGenerator;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Semaphore pierNumber = new Semaphore(2);
		int shipCount = 10;
		Port port = new Port(shipCount, pierNumber);
		ShipGenerator shipGenerator = new ShipGenerator(port, shipCount);
		shipGenerator.start();
		Thread.sleep(100);

		System.out.println(" ");

		Ship shipOne = new Ship();
		shipOne.start();
		Ship shipTwo = new Ship();
		shipTwo.start();
		Ship shipThree = new Ship();
		shipThree.start();
		Ship shipFour = new Ship();
		shipFour.start();
		Ship shipFive = new Ship();
		shipFive.start();
		Ship shipSix = new Ship();
		shipSix.start();
		Ship shipSeven = new Ship();
		shipSeven.start();
		Ship shipEight = new Ship();
		shipEight.start();
		Ship shipNine = new Ship();
		shipNine.start();
		Ship shipTen = new Ship();
		shipTen.start();
	}
}
