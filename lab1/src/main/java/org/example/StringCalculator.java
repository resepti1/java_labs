package org.example;

import java.util.Objects;

public class StringCalculator {
    int add(String input){
        int sum = 0;

        if (!Objects.equals(input, "")) {
            String[] parts = input.split("[,\n]");

            for (String part: parts){
                if (!part.trim().isEmpty()){
                    sum += Integer.parseInt(part.trim());
                }
            }
        } else return 0;

        return sum;
    }
}
