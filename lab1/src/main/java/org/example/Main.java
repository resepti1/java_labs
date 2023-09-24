package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int sum;
        StringCalculator obj = new StringCalculator();
        StringBuilder input = new StringBuilder();

        while (true) {
            System.out.println("Enter line:" + " ");
            String line = readInputLine(input);

            try {
                sum = obj.add(line);
            } catch (IncorrectInputException | NegativeInputException | DelimiterInputException e) {
                System.out.println(e.getMessage());
                input.setLength(0);
                continue;
            }

            break;

        }

        System.out.println("Result: " + sum);
    }

    private static String readInputLine(StringBuilder input ) {
        Scanner scanner = new Scanner(System.in);
        int enterCount = 0;

        while (enterCount < 1) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                enterCount++;
            } else {
                enterCount = 0;
                input.append(line).append(System.lineSeparator());
            }
        }

        return input.toString();
    }

}
