package org.example;

import java.util.ArrayList;

public class StringCalculator {
    int add(String input) throws IncorrectInputException, NegativeInputException, DelimiterInputException {
        int sum = 0;

        if (input.isEmpty()) {
            return sum;
        }
        input = input.replaceAll("\r", "");

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ',' && input.charAt(i + 1) == '\n'){
                String message = "Incorrect input!";
                throw new IncorrectInputException(message);
            }
        }

        String regex = "[,\n]";
        if (input.startsWith("//")) {

            int delimiter_begin_index = input.indexOf('[');
            int delimiter_end_index = input.indexOf(']');
            String delimiter;

            if (delimiter_begin_index != -1 && delimiter_end_index != -1){
                delimiter = input.substring(delimiter_begin_index + 1, delimiter_end_index);
            } else{
                String message = "Incorrect delimiter input!! Use this template //[delimiter]\\n[numbers...].";
                throw new DelimiterInputException(message);
            }


            if (input.charAt(delimiter_end_index + 1) != '\n'){
                String message = "Incorrect delimiter input! Use this template //[delimiter]\\n[numbers...].";
                throw new DelimiterInputException(message);
            }
            if (input.charAt(input.length() - 2) == delimiter.charAt(0) && input.charAt(input.length() - 1) == '\n'){
                String message = "Incorrect input!";
                throw new IncorrectInputException(message);
            }
            input = input.substring(delimiter_end_index + 1);
            regex = "[" + delimiter + "\n" + "]";
        }


        String[] parts = input.split(regex);


        ArrayList<Integer> negativeNumbers = new ArrayList<>();

        for (String number : parts) {
            if (!number.trim().isEmpty()) {
                int value = Integer.parseInt(number.trim());
                if (value < 0) {
                    negativeNumbers.add(value);
                }
                sum += value;
                if (sum > 1000){
                    sum = 1999;
                    break;
                }
            }
        }

        if (!negativeNumbers.isEmpty()) {
            String message = "Negative numbers are not allowed! You tried to input: ";
            for (int i = 0; i < negativeNumbers.size(); i++) {
                message += negativeNumbers.get(i) + " ";
            }
            throw new NegativeInputException(message);
        }


        return sum;
    }
}




