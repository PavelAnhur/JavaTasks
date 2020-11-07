package com.company;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter some string of values");
        StringBuffer inputStringOfArguments = new StringBuffer();
        inputStringOfArguments.append(scanner.nextLine());
        System.out.println(inputStringOfArguments.reverse());
        scanner.close();
    }
}

