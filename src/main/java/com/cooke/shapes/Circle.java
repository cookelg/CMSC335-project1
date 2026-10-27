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
package com.cooke.shapes;

import java.lang.Math;
import java.util.Scanner;

public class Circle extends TwoDimensionalShape {
    /**
     * the radius of the circle
     */
    private double radius;

    /**
     * Circle Constructor
     *
     * @param radius:double the radius of the circle
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
     * @param radius:double the radius of the circle
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
     * @param input:java.utils.Scanner The input scanner object
     * @return a new Sphere Object
     */
    public static Circle fromUserInput(Scanner input) {
        double radius = App.readPositiveDouble(input, "What is the Radius?");
        return new Circle(radius);
    }

}
