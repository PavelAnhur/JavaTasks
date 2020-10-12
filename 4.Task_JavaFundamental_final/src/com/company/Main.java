package com.company;

public class Main {


    public static void main(String[] args) {

        Input input = new Input();
        int[] array = input.getArrayOfInt();
        Function function = new Function();
        function.getSumOfElements(array);
        function.getMultiplyOfElements(array);

    }
}
