/**
 * Square Class 
 *
 * Creates a Square object with four sides of equal length; The square's area is 
 * calculated when a new square is created and when the side length is adjusted. 
 *
 * filename: Square.java
 * creation date: 20261027
 *
 * @author Lawrence Cooke
 */
package com.cooke.shapes;

import java.util.Scanner;

public class Square extends TwoDimensionalShape {
    /**
     * the length of all four sides
     */
    private double length;

    /**
     * Square Constructor
     *
     * @param side:double the length of all four sides
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public Square(double length) {
        // Calculate area with static method before sending to superclass constructor.
        super(Square.calculateArea(length), "Square");
        this.length = length;
    }

    /**
     * returns the length of all four sides
     *
     * @return double length of all four sides
     */
    public double getLength() {
        return this.length;
    }

    /**
     * sets the length of all four sides, recalculates this.area
     *
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public void setLength(double length) {
        this.setArea(Square.calculateArea(length));
        this.length = length;
    }

    /**
     * Static Method calculate the area of any square
     *
     * @param side:double the length of all four sides
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public static double calculateArea(double length) {
        if (length <= 0)
            throw new IllegalArgumentException("The length must be a positive number");
        // area of a square is equal to the length squared
        return length * length;
    }

    /**
     * Static Method to create a new Square from an input Scanner
     *
     * This method will prompt the user for inputs, check the users inputs for
     * errors, and re-prompt until a valid input is parsed.
     *
     * @param input:java.utils.Scanner The input scanner object
     * @return a new Square Object
     */
    public static Square fromUserInput(Scanner input) {
        double length = App.readPositiveDouble(input, "What is the Length?");
        return new Square(length);
    }

    /**
     * Static main method for Square class
     *
     * Create 3 squares to test the method outputs.
     *
     * Expected results:
     * "The Square has an area of 1"
     * "The Square has an area of 4"
     * "The Square has an area of 9"
     *
     */
    public static void main(String[] args) {
        Square sq1 = new Square(1);
        Square sq2 = new Square(2);
        Square sq3 = new Square(3);

        System.out.println(sq1.toString());
        System.out.println(sq2.toString());
        System.out.println(sq3.toString());

    }

}
