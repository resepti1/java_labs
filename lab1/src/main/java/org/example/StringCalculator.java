package org.example;
import java.util.ArrayList;
import java.util.Objects;

public class StringCalculator {
    int add(String input) throws IncorrectInputException, NegativeInputException {
        int[] numbers;
        int sum = 0;

        if (!Objects.equals(input, "")) {
            boolean isdelimiter = false;
            String regex = "";
            StringBuilder regex_builder = new StringBuilder();
            if (input.startsWith("//")){
                isdelimiter = true;
                if (!input.contains("[") | !input.contains("]")){
                    throw new IncorrectInputException("Incorrect Input of delimiter");
                }

                int delimiter_begin_ind;
                int delimiter_end_ind;
                String previous_delimiter = "";

                for (int i = 0; i < input.length(); i++){
                    if (!input.contains("[") || !input.contains("]")){
                        break;
                    }

                    delimiter_begin_ind = input.indexOf("[");
                    delimiter_end_ind = input.indexOf("]");

                    String delimiter = input.substring(delimiter_begin_ind, delimiter_end_ind+1);
                    int delimiter_length = delimiter.length();

                    if (i == 0){
                        regex_builder = new StringBuilder("[" + delimiter + "|" +"," + "\n" + "]");
                        input = input.substring(delimiter_end_ind + 1);
                        previous_delimiter = delimiter;
                    } else{
                        regex_builder.insert(regex_builder.indexOf(previous_delimiter) + previous_delimiter.length()+1, delimiter  + "|");
                        input = input.substring(delimiter_end_ind + 1);
                        previous_delimiter = delimiter;
                    }
                    input = input.replace(" ","");

                    if (input.contains("\n" + delimiter) || input.contains(delimiter + "\n")){
                        throw new IncorrectInputException("Incorrect input!");
                    }
                    if (input.contains("\n" + ',') || input.contains(',' + "\n")){
                        throw new IncorrectInputException("Incorrect input!");
                    }
                }
                if (input.charAt(0)!='\n'){
                    throw new IncorrectInputException("Incorrect delimiter input");
                }

            } else {
                regex = "[,\n]";
            }

            if (input.contains(",,")){
                throw new IncorrectInputException("Incorrect input!");
            }

            String[] parts;

            if (isdelimiter){
                parts = input.split(regex_builder.toString());
            } else{
                parts = input.split(regex);
            }



            for (int i = 1; i < input.length(); i++){
                if ((input.charAt(i) == '\n' && input.charAt(i-1) == ',') | (input.charAt(i) == ',' && input.charAt(i-1) == '\n')){
                    throw new IncorrectInputException("Incorrect input!");
                }
            }

            ArrayList<Integer> negativeNumbers = new ArrayList<>();
            numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                if (!parts[i].isEmpty()){
                    numbers[i] = Integer.parseInt(parts[i]);
                    if (numbers[i] < 0){
                        negativeNumbers.add(numbers[i]);
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