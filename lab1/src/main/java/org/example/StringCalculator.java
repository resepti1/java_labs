package org.example;

import java.util.Objects;

public class StringCalculator {
    int add(String input){
        int[] numbers;
        int sum = 0;

        if (!Objects.equals(input, "")) {
            String[] parts = input.split(",");

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
