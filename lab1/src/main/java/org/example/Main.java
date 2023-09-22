package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        StringCalculator obj = new StringCalculator();

        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        int enterCount = 0;

        while (true){
            System.out.println("Enter line:" + " ");
            while (enterCount < 1) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    enterCount++;
                } else {
                    enterCount = 0;
                    input.append(line).append(System.lineSeparator());
                }
            }
            try {
                if (input.charAt(input.length() - 3) == ',') {
                    throw new IncorrectInputException("Data of the form \"1,enter\" is incorrect to enter");
                }
            } catch (IncorrectInputException e) {
                System.out.println(e.getMessage());
                enterCount = 0;
                input.setLength(0);
                continue;
            }
            break;
        }

        int sum = obj.add(input.toString());

        System.out.println("Result:" + " " + sum);
    }
}