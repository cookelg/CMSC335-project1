package com.cooke.shapes;

import java.lang.Math;
import java.util.Scanner;

/**
 * Circle Class 
 *
 * Creates a Circle object with with a radius; The circle's area is 
 * calculated when a new circle is created and when the radius is adjusted. 
 *
 * filename: Circle.java
 * creation date: 20261027
 *
 * @author Lawrence Cooke
 */
public class Circle extends TwoDimensionalShape {
    /**
     * the radius of the circle
     */
    private double radius;

    /**
     * Circle Constructor
     *
     * @param radius the radius of the circle
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public Circle(double radius) {
        // Calculate area with static method before sending to superclass constructor.
        super(Circle.calculateArea(radius), "Circle");
        this.radius = radius;
    }

    /**
     * returns the radius of the circle
     *
     * @return double radius of the circle
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * sets the radius of the circle, recalculates this.area
     *
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public void setRadius(double radius) {
        this.setArea(Circle.calculateArea(radius));
        this.radius = radius;
    }

    /**
     * Static Method calculate the area of any circle
     *
     * @param radius the radius of the circle
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public static double calculateArea(double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("The radius must be a positive number");
        // the area of the circle is pi times radius squared
        return Math.PI * radius * radius;
    }

    /**
     * Static Method to create a new Circle from an input Scanner
     *
     * This method will prompt the user for inputs, check the users inputs for
     * errors, and re-prompt until a valid input is parsed.
     *
     * @param input The input scanner object
     * @return a new Sphere Object
     */
    public static Circle fromUserInput(Scanner input) {
        double radius = App.readPositiveDouble(input, "What is the Radius?");
        return new Circle(radius);
    }

    /**
     * Static main method for Circle class
     *
     * Create 3 circles to test the method outputs.
     *
     * Expected results:
     * "The Circle has an area of 3.14"
     * "The Circle has an area of 12.57"
     * "The Circle has an area of 28.27"
     *
     */
    public static void main(String[] args) {
        Circle cir1 = new Circle(1);
        Circle cir2 = new Circle(2);
        Circle cir3 = new Circle(3);

        System.out.println(cir1.toString());
        System.out.println(cir2.toString());
        System.out.println(cir3.toString());

    }

}
