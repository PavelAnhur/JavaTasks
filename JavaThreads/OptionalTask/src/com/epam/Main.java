package com.epam;

import com.epam.airport.Airplane;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore runwayNumber = new Semaphore(5);
        new Airplane(1, runwayNumber).start();
        new Airplane(2, runwayNumber).start();
        new Airplane(3, runwayNumber).start();
        new Airplane(4, runwayNumber).start();
        new Airplane(5, runwayNumber).start();
        new Airplane(6, runwayNumber).start();
        new Airplane(7, runwayNumber).start();
        new Airplane(8, runwayNumber).start();
        new Airplane(9, runwayNumber).start();
        new Airplane(10, runwayNumber).start();
    }
}
