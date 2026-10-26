package com.cooke.shapes;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static double readPositiveDouble(Scanner input, String prompt) {
        double number;
        while (true) {
            System.out.print(prompt + "\n >>");
            try {
                number = input.nextDouble();
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("Invalid input. Please enter a valid number");
                continue;
            }
            if (number <= 0 || Double.isNaN(number) || Double.isInfinite(number)) {
                System.out.println("Invalid input. Please enter a valid number");
                continue;
            }
            System.out.println();
            return number;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
