/**
 * Cone Class 
 *
 * Creates a Cone object with with a radius and a height; The Cone's volume is 
 * calculated when a new Cone is created and when the radius or height is adjusted. 
 *
 * filename: Cone.java
 * creation date: 20261027
 *
 * @author Lawrence Cooke
 */
package com.cooke.shapes;

import java.util.Scanner;

public class Cone extends ThreeDimensionalShape {
    /**
     * the radius of the cone
     */
    private double radius;
    /**
     * the height of the cone
     */
    private double height;

    /**
     * Cone Constructor
     *
     * @param radius:double the radius of the cone
     * @param height:double the height of the cone
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public Cone(double radius, double height) {
        // Calculate volume with static method before sending to superclass constructor.
        super(Cone.calculateVolume(radius, height), "Cone");
        this.radius = radius;
        this.height = height;
    }

    /**
     * returns the radius of the cone
     *
     * @return double radius of the cone
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * returns the height of the cone
     *
     * @return double height of the cone
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * sets the radius of the cone, recalculates this.volume
     *
     * @param radius:double the radius of the new cone
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public void setRadius(double radius) {
        this.setVolume(Cone.calculateVolume(radius, this.height));
        this.radius = radius;
    }

    /**
     * sets the height of the cone, recalculates this.volume
     *
     * @param radius:double the height of the new cone
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public void setHeight(double height) {
        this.setVolume(Cone.calculateVolume(this.radius, height));
        this.height = height;
    }

    /**
     * Static Method calculate the volume of any cone
     *
     * @param radius:double the radius of the cone
     * @param height:double the height of the cone
     * @throws IllegalArgumentException if any argument is less than or equal to 0.
     */
    public static double calculateVolume(double radius, double height) {
        if (radius <= 0 || height <= 0)
            throw new IllegalArgumentException("The inputs must be positive numbers");
        // the formula for a cone is pi times radius squared times height divided by 3
        return Math.PI * radius * radius * height / 3;
    }

    /**
     * Static Method to create a new Cone from an input Scanner
     *
     * This method will prompt the user for inputs, check the users inputs for
     * errors, and re-prompt until a valid input is parsed.
     *
     * @param input:java.utils.Scanner The input scanner object
     * @return a new Cone Object
     */
    public static Cone fromUserInput(Scanner input) {
        double radius = App.readPositiveDouble(input, "What is the Radius?");
        double height = App.readPositiveDouble(input, "What is the Height?");
        return new Cone(radius, height);
    }

    /**
     * Static main method for Cone class
     *
     * Create 3 cones to test the method outputs.
     *
     * Expected results:
     * "The Cone has a volume of 1.05"
     * "The Cone has a volume of 12.57"
     * "The Cone has a volume of 94.25"
     *
     */
    public static void main(String[] args) {
        Cone co1 = new Cone(1, 1);
        Cone co2 = new Cone(2, 3);
        Cone co3 = new Cone(3, 10);

        System.out.println(co1.toString());
        System.out.println(co2.toString());
        System.out.println(co3.toString());

    }

}
