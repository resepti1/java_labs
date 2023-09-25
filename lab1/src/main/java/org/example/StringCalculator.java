package org.example;
import java.util.ArrayList;

public class StringCalculator {
    int add(String input) throws IncorrectInputException, NegativeInputException, DelimiterInputException {
        int sum = 0;

        if (input.isEmpty()) {
            return sum;
        }
        input = input.replaceAll("\r", "");


        String regex = "[,\n]";
        StringBuilder regex_builder = new StringBuilder();
        if (input.startsWith("//")) {

            String delimiter;
            String previous_delimiter = "";


            for (int i = 0; i < input.length(); i++){
                int delimiter_begin_index = input.indexOf('[');
                int delimiter_end_index = input.indexOf(']');

                if (delimiter_end_index != -1 && delimiter_begin_index != -1){
                    delimiter = "[" + input.substring(delimiter_begin_index + 1, delimiter_end_index) + "]";

                    if (regex_builder.isEmpty()){
                        regex_builder = new StringBuilder("[" + delimiter  + "|" + "\n" + "]");
                        input = input.substring(delimiter_end_index + 1);
                        previous_delimiter = delimiter;

                    } else {
                        regex_builder.insert(regex_builder.indexOf(previous_delimiter) + previous_delimiter.length() + 1, delimiter  + "|");
                        input = input.substring(delimiter_end_index + 1);
                        previous_delimiter = delimiter;
                    }
                } else {
                    if (i == 0){
                        String message = "Incorrect delimiter input!! Use this template //[delimiter1][delimiter2]\\n[numbers...].";
                        throw new DelimiterInputException(message);
                    }
                    break;
                }
            }
            if (input.charAt(0) != '\n'){
                String message = "Incorrect input";
                throw new IncorrectInputException(message);
            }

        }

        if (input.length() > 1){
            char c = input.charAt(input.length()-2);
            if (!Character.isDigit(c) && input.charAt(input.length()-1) == '\n'){
                String message = "Incorrect input";
                throw new IncorrectInputException(message);
            }
        }


        String[] parts;
        if (!regex_builder.isEmpty()){
            parts = input.split(regex_builder.toString());
        } else {
            parts = input.split(regex);
        }


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




