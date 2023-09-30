package org.example;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        StringCalculator obj = new StringCalculator();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = scanner.nextLine();

        int sum = obj.add(input);

        System.out.println("Result:" + " " + sum);
    }
}
