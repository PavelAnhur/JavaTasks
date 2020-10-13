package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("How many numbers do you want to add in array?");
        int numberOfElements = scanner.nextInt();


        if (numberOfElements > 0) {

            ArrayList<Integer> array = new ArrayList<>();

            for (int i = 0; i < numberOfElements; i++) {
                array.add((int) (Math.random() * 1000));
            }

            for (Integer integer : array) System.out.println(integer);

            System.out.println("--------------");

            for (Integer integer : array) System.out.print(integer + " ");

        } else
            System.out.println("Invalid value");
    }
}
