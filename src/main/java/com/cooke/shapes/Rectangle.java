/**
 * Rectangle Class 
 *
 * Creates a Rectangle object with a length and a width; The rectangle's area is 
 * calculated when a new rectantgle is created and when either side length is adjusted. 
 *
 * filename: Rectangle.java
 * creation date: 20261027
 *
 * @author Lawrence Cooke
 */
package com.cooke.shapes;

import java.util.Scanner;

public class Rectangle extends TwoDimensionalShape {
    /**
     * the length of two parallel sides of the rectangle
     */
    private double length;
    /**
     * the length of the remaining two parallel sides of the rectangle
     */
    private double width;

    /**
     * Rectangle Constructor
     *
     * @param length:double the length of two parallel sides of the rectangle
     * @param width:double  the length of the remaining two parallel sides of the
     *                      rectangle
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public Rectangle(double length, double width) {
        // Calculate area with static method before sending to superclass constructor.
        super(Rectangle.calculateArea(length, width), "Rectangle");
        this.length = length;
        this.width = width;
    }

    /**
     * returns the length of two parallel sides of the rectangle
     *
     * @return double length of two parallel sides of the rectangle
     */
    public double getLength() {
        return this.length;
    }

    /**
     * returns the length of the other two parallel sides of the rectangle
     *
     * @return double length of the other two parallel sides of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * sets the length of two parallel sides of the rectangle, recalculates
     * this.area
     *
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public void setLength(double length) {
        this.setArea(Rectangle.calculateArea(length, this.width));
        this.length = length;
    }

    /**
     * sets the length of the other two parallel sides of the rectangle,
     * recalculates this.area
     *
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public void setWidth(double width) {
        this.setArea(Rectangle.calculateArea(this.length, width));
        this.width = width;
    }

    /**
     * Static Method calculate the area of any rectangle
     *
     * @param length:double the length of two parallel sides of the rectangle
     * @param width:double  the length of the remaining two parallel sides of the
     *                      rectangle
     * @throws IllegalArgumentException if any argument is less than or equal to 0.
     */
    public static double calculateArea(double length, double width) {
        if (length <= 0 || width <= 0)
            throw new IllegalArgumentException("Both inputs must be a positive number");
        // Rectangle area is length times width
        return length * width;
    }

    /**
     * Static Method to create a new Rectangle from an input Scanner
     *
     * This method will prompt the user for inputs, check the users inputs for
     * errors, and re-prompt until a valid input is parsed.
     *
     * @param input:java.utils.Scanner The input scanner object
     * @return a new Rectangle Object
     */
    public static Rectangle fromUserInput(Scanner input) {
        double length = App.readPositiveDouble(input, "What is the Length?");
        double width = App.readPositiveDouble(input, "What is the Width?");
        return new Rectangle(length, width);
    }

    /**
     * Static main method for Rectangle class
     *
     * Create 3 rectangles to test the method outputs.
     *
     * Expected results:
     * "The Rectangle has an area of 2"
     * "The Rectangle has an area of 8"
     * "The Rectangle has an area of 32"
     *
     */
    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(1, 2);
        Rectangle rec2 = new Rectangle(2, 4);
        Rectangle rec3 = new Rectangle(4, 8);

        System.out.println(rec1.toString());
        System.out.println(rec2.toString());
        System.out.println(rec3.toString());

    }

}
