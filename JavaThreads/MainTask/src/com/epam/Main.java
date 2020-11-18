package com.epam;

import com.epam.port.Port;
import com.epam.ship.Ship;
import com.epam.ship.ShipGenerator;
import com.epam.ship.ShipThread;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		int shipCount = 10;
		Port port = new Port(shipCount);
		ShipGenerator shipGenerator = new ShipGenerator(port, shipCount);
		shipGenerator.start();
		Semaphore pierNumber = new Semaphore(2);
		Thread.sleep(100);

		System.out.println(" ");

		ShipThread shipOne = new ShipThread(port.getShipsInPort().take(), pierNumber);
		shipOne.start();
		ShipThread shipTwo = new ShipThread(port.getShipsInPort().take(), pierNumber);
		shipTwo.start();
		ShipThread shipThree = new ShipThread(port.getShipsInPort().take(), pierNumber);
		shipThree.start();
		ShipThread shipFour = new ShipThread(port.getShipsInPort().take(), pierNumber);
		shipFour.start();
		ShipThread shipFive = new ShipThread(port.getShipsInPort().take(), pierNumber);
		shipFive.start();
		ShipThread shipSix = new ShipThread(port.getShipsInPort().take(), pierNumber);
		shipSix.start();
		ShipThread shipSeven = new ShipThread(port.getShipsInPort().take(), pierNumber);
		shipSeven.start();
		ShipThread shipEight = new ShipThread(port.getShipsInPort().take(), pierNumber);
		shipEight.start();
		ShipThread shipNine = new ShipThread(port.getShipsInPort().take(), pierNumber);
		shipNine.start();
		ShipThread shipTen = new ShipThread(port.getShipsInPort().take(), pierNumber);
		shipTen.start();
	}
}
