package org.example;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){
        StringCalculator obj = new StringCalculator();
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        while (true){
            System.out.print("Enter string: ");
            String input = scanner.nextLine();
            input = input.replace("\\n", "\n");
            try {sum = obj.add(input);
            } catch (IncorrectInputException e) {
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }


        System.out.println("Result:" + " " + sum);
    }
}
