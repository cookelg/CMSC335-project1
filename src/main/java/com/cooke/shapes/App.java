/**
 * Main loop Class 
 *
 * CLI shape builder application; user will be presented with a menu of shapes to 
 * choose from, then user will be prompted to specify the size parameters of the 
 * shape; these parameters will change for each shape; the user will then be 
 * shown the calculated area of the shape if it is a 2D shape, or the volume of the 
 * shape if it is 3D.
 *
 * filename: Circle.java
 * creation date: 20261027
 *
 * @author Lawrence Cooke
 */
package com.cooke.shapes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    /**
     * Static Method that reads a positive double from a scanner
     *
     * The user will be prompted with the String argument; the method will loop
     * until the user supplies a number that is greater than 0.
     *
     * @param input:java.utils.Scanner The input scanner object
     * @param prompt:String            The prompt to be shown to the user on
     *                                 System.out
     * @return a positive double
     */
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

    /**
     * Static Method that reads a positive integer from a scanner
     *
     * The user will be prompted with the String argument; the method will loop
     * until the user supplies a number that is greater than 0.
     *
     * @param input:java.utils.Scanner The input scanner object
     * @param prompt:String            The prompt to be shown to the user on
     *                                 System.out
     * @return a positive integer
     */
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

    /**
     * Static Method that reads a 'y' or 'n' character from a scanner
     *
     * The user will be prompted with the String argument; the method will loop
     * until the user supplies a 'y' or 'n' character; not case sensitive.
     *
     * @param input:java.utils.Scanner The input scanner object
     * @param prompt:String            The prompt to be shown to the user on
     *                                 System.out
     * @return 'y' | 'Y' | 'n' | 'N'
     */
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

    /**
     * Static Method that will display the main menu of the application to
     * System.out
     */
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

    /**
     * Static Method that returns a String with the current formatted date and time
     * 
     * @return String with formatted current date and time
     */
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
        // Scanner object for System.in
        Scanner input = new Scanner(System.in);
        // variable to break the while loop
        boolean keepRunning = true;
        int userInput = 0;
        // instatiate a shape as a placeholder to clear LSP flags
        Shape shape = new Square(1);

        while (keepRunning) {
            printMenu();
            // read user's menu choice
            userInput = readPositiveInt(input, "");
            // assume the input is valid until proven otherwise
            boolean validInput = true;
            try {
                // switch statement that will execute according to user input
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
                // an illegal argument will be caught in any shape's static
                // calculate area/volume method. if caught, entire loop will restart
                System.out.println(e.getMessage() + " please try again");
                continue;
            }
            if (!validInput) {
                // if the user inputs any other a number between 1 and 10, valid input
                // will be set to false, and the loop will restart.
                System.out.println("invalid input");
                continue;
            }
            // The shapes measurement is displayed using the overridden toString method
            // if the user enters 'n' when prompted, keepRunning will be set to false
            if (keepRunning) {
                System.out.println(shape.toString());
                char charInput = readYorN(input, "Would you like to continue? (Y or N)");
                if (charInput == 'N' || charInput == 'n')
                    keepRunning = false;
            }
        }

        // close the scanner
        input.close();
        // display a goodbye message with the current date and time
        System.out.println("Thanks for using the program. Today is " + getCurrentDateTime());
    }
}
