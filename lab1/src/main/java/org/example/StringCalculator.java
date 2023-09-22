package org.example;

import java.util.Objects;

public class StringCalculator {
    int add(String input){
        int sum = 0;
        String regex = "[,\n]";

        if (input.startsWith("//")){
            regex = "[" + input.charAt(2) + "\n]";
            input = input.substring(3);
        }


        if (!Objects.equals(input, "")) {
            String[] parts = input.split(regex);

            for (String part: parts){
                if (!part.trim().isEmpty()){
                    sum += Integer.parseInt(part.trim());
                }
            }
        } else return 0;

        return sum;
    }
}
