package com.company;

public class Main {


    public static void main(String[] args) {

        InputValue input = new InputValue();
        int[] integersFromInput = input.getIntegers();
        SumAndMultiply sumAndMultiply = new SumAndMultiply();
        sumAndMultiply.sumOfElements(integersFromInput);
        sumAndMultiply.multiplyOfElements(integersFromInput);

    }
}
