package org.example;
import java.util.ArrayList;
import java.util.Objects;

public class StringCalculator {
    int add(String input) throws IncorrectInputException, NegativeInputException {
        int[] numbers;
        int sum = 0;

        if (!Objects.equals(input, "")) {

            String regex = "";

            if (input.startsWith("//")){
                char delimiter = input.charAt(2);
                regex = "["+delimiter+","+"\n"+"]";
                input = input.substring(4);
                input = input.replace(" ","");
                for (int i = 1; i < input.length(); i++){
                    if ((input.charAt(i) == '\n' && input.charAt(i-1) == delimiter) | (input.charAt(i) == delimiter && input.charAt(i-1) == '\n')){
                        throw new IncorrectInputException("Incorrect input!");
                    }
                }

            } else {
                regex = "[,\n]";
            }

            String[] parts = input.split(regex);


            for (int i = 1; i < input.length(); i++){
                if ((input.charAt(i) == '\n' && input.charAt(i-1) == ',') | (input.charAt(i) == ',' && input.charAt(i-1) == '\n')){
                    throw new IncorrectInputException("Incorrect input!");
                }
            }

            ArrayList<Integer> negativeNumbers = new ArrayList<>();
            numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
                if (numbers[i] < 0){
                    negativeNumbers.add(numbers[i]);
                }
            }

            if (!negativeNumbers.isEmpty()) {
                String message = "Negative numbers are not allowed! You tried to input: ";
                for (int i = 0; i < negativeNumbers.size(); i++) {
                    message += negativeNumbers.get(i) + " ";
                }
                throw new NegativeInputException(message);
            }


            for (int number: numbers){
                if (number > 1000){
                    continue;
                }
                sum += number;
            }
        } else return 0;

        return sum;
    }
}