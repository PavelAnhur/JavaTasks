package com.company;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("How many elements do you want to input?");
        int count = scanner.nextInt();
        scanner.nextLine();

        if (count > 0) {
            String[] array = new String[count];
            for (int i = 0; i < array.length; i++) {
                System.out.println("Enter " + (i + 1) + " element of array:");
                array[i] = scanner.nextLine();
            }

            for (int i = array.length - 1; i >= 0; i--) {
                System.out.println(i + 1 + " argument = " + array[i]);
            }
        } else
            System.out.println("Invalid value");
    }
}

