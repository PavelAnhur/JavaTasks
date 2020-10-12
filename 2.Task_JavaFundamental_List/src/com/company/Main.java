package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("How many elements you want to add?");
        int countOfElements = scanner.nextInt();
        scanner.nextLine();
        String element;

        if (countOfElements > 0) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < countOfElements; i++) {
                System.out.print("Enter " + (i + 1) + " element: ");
                element = scanner.nextLine();
                list.add(element);
            }
            scanner.close();

            for (int i = list.size() - 1; i >= 0; i--)
                System.out.println(i + 1 + " element = " + list.get(i));
        } else
            System.out.println("Invalid value");
    }
}
