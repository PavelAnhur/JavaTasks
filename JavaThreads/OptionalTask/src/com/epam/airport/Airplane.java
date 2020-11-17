package com.epam.airport;

import java.util.concurrent.Semaphore;

public class Airplane extends Thread{

	private final int airplaneNumber;
	private final Semaphore runwayNumber;

	public Airplane(int airplaneNumber, Semaphore runwayNumber) {
		this.airplaneNumber = airplaneNumber;
		this.runwayNumber = runwayNumber;
	}

	@Override
	public void run() {
		try{
			runwayNumber.acquire();
			String airplane = "Airplane";
			Thread.currentThread().setName(String.valueOf(airplaneNumber));
			System.out.println(airplane + Thread.currentThread().getName() + " start moving");
			Thread.sleep(1000);
			System.out.println(airplane + Thread.currentThread().getName() + " the plane took off");
			Thread.sleep(1000);
			System.out.println(airplane + Thread.currentThread().getName() + " flying away");
			Thread.sleep(1000);
			runwayNumber.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The runway is clear ");
	}
}
