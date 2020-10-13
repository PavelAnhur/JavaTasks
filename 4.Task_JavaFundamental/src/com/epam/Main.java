package com.epam;

public class Main {

    public static void main(String[] args) {

        InputValue input = new InputValue();
        int[] array = input.getIntegers();
        SumAndMultFunction function = new SumAndMultFunction();
        function.getSumOfElements(array);
        function.getMultiplyOfElements(array);
    }
}
