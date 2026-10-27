package com.cooke.shapes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public static int readPositiveInt(Scanner input, String prompt) {
        int number;
        while (true) {
            System.out.print(prompt + "\n >>");
            try {
                number = input.nextInt();
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("Invalid input. Please enter a valid number");
                continue;
            }
            if (number < 1 || number > 10) {
                System.out.println("Invalid input. Please enter a valid number");
                continue;
            }
            System.out.println();
            return number;
        }
    }

    public static char readYorN(Scanner input, String prompt) {
        char yOrN;
        while (true) {
            System.out.print(prompt + "\n >>");
            yOrN = input.next().charAt(0);

            if (yOrN == 'y' || yOrN == 'Y' || yOrN == 'n' || yOrN == 'N') {
                return yOrN;
            }
            System.out.print("Sorry I do not understand");
            continue;
        }
    }

    public static void printMenu() {
        String str = """
                Select from the menu below:

                    1. Construct a Circle
                    2. Construct a Rectangle
                    3. Construct a Square
                    4. Construct a Triangle
                    5. Construct a Sphere
                    6. Construct a Cube
                    7. Construct a Cone
                    8. Construct a Cylinder
                    9. Construct a Torus
                    10. Exit the Program

                """;
        System.out.println(str);
    }

    public static void printChoice(String string) {
        System.out.println("You have selected a " + string);
    }

    public static String getCurrentDateTime() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("LLL dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String monthDay = date.format(dateFormatter);
        String hour = date.format(timeFormatter);
        return monthDay + " at " + hour;
    }

    public static void main(String[] args) {
        System.out.println("*********Welcome to the Java OO Shapes Program*********");
        Scanner input = new Scanner(System.in);
        boolean keepRunning = true;
        int userInput = 0;
        Shape shape = new Square(1);

        while (keepRunning) {
            printMenu();
            userInput = readPositiveInt(input, "");
            boolean validInput = true;
            try {
                switch (userInput) {
                    case 1:
                        printChoice("Circle");
                        shape = Circle.fromUserInput(input);
                        break;
                    case 2:
                        printChoice("Rectangle");
                        shape = Rectangle.fromUserInput(input);
                        break;
                    case 3:
                        printChoice("Square");
                        shape = Square.fromUserInput(input);
                        break;
                    case 4:
                        printChoice("Triangle");
                        shape = Triangle.fromUserInput(input);
                        break;
                    case 5:
                        printChoice("Sphere");
                        shape = Sphere.fromUserInput(input);
                        break;
                    case 6:
                        printChoice("Cube");
                        shape = Cube.fromUserInput(input);
                        break;
                    case 7:
                        printChoice("Cone");
                        shape = Cone.fromUserInput(input);
                        break;
                    case 8:
                        printChoice("Cylinder");
                        shape = Cylinder.fromUserInput(input);
                        break;
                    case 9:
                        printChoice("Torus");
                        shape = Torus.fromUserInput(input);
                        break;
                    case 10:
                        keepRunning = false;
                        break;
                    default:
                        validInput = false;
                        continue;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " please try again");
                continue;
            }
            if (!validInput) {
                System.out.println("invalid input");
                continue;
            }
            if (keepRunning) {
                System.out.println(shape.toString());
                char charInput = readYorN(input, "Would you like to continue? (Y or N)");
                if (charInput == 'N' || charInput == 'n')
                    keepRunning = false;
            }
        }

        input.close();
        System.out.println("Thanks for using the program. Today is " + getCurrentDateTime());
    }
}
