package org.example;

import java.util.Objects;

public class StringCalculator {
    int add(String input) throws IncorrectInputException{
        int[] numbers;
        int sum = 0;

        if (!Objects.equals(input, "")) {
            String[] parts = input.split("[,\n]");


            for (int i = 1; i < input.length(); i++){
                if ((input.charAt(i) == '\n' && input.charAt(i-1) == ',') | (input.charAt(i) == ',' && input.charAt(i-1) == '\n')){
                    throw new IncorrectInputException("Incorrect input!");
                }
            }

            numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }

            for (int number: numbers){
                sum += number;
            }
        } else return 0;

        return sum;
    }
}