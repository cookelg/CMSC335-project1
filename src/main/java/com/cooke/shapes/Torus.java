package com.cooke.shapes;

import java.util.Scanner;

/**
 * Torus Class 
 *
 * Creates a Torus object with with a major radius and a minor radius; The Torus's volume is 
 * calculated when a new Torus is created and when the major radius or minor radius is adjusted. 
 *
 * filename: Torus.java
 * creation date: 20261027
 *
 * @author Lawrence Cooke
 */
public class Torus extends ThreeDimensionalShape {
    /**
     * the major radius of the torus
     */
    private double majorRadius;
    /**
     * the minor radius of the torus
     */
    private double minorRadius;

    /**
     * Torus Constructor
     *
     * @param majorRadius the major radius of the torus
     * @param minorRadius the minor radius of the torus
     * @throws IllegalArgumentException if any argument is less than or equal to 0.
     */
    public Torus(double majorRadius, double minorRadius) {
        // Calculate volume with static method before sending to superclass constructor.
        super(Torus.calculateVolume(majorRadius, minorRadius), "Torus");
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    /**
     * returns the major radius of the torus
     *
     * @return double major radius of the torus
     */
    public double getMajorRadius() {
        return this.majorRadius;
    }

    /**
     * returns the minor radius of the torus
     *
     * @return double minor radius of the torus
     */
    public double getMinorRadius() {
        return this.minorRadius;
    }

    /**
     * sets the major radius of the cylinder, recalculates this.volume
     *
     * @param majorRadius the major radius of the new cylinder
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public void setMajorRadius(double majorRadius) {
        this.setVolume(Torus.calculateVolume(majorRadius, this.minorRadius));
        this.majorRadius = majorRadius;
    }

    /**
     * sets the minor radius of the cylinder, recalculates this.volume
     *
     * @param minorRadius the minor radius of the new cylinder
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public void setMinorRadius(double minorRadius) {
        this.setVolume(Torus.calculateVolume(this.majorRadius, minorRadius));
        this.minorRadius = minorRadius;
    }

    /**
     * Static Method calculate the volume of any torus
     *
     * @param majorRadius the major radius of the torus
     * @param minorRadius the minor radius of the torus
     * @throws IllegalArgumentException if any argument is less than or equal to 0.
     */
    public static double calculateVolume(double majorRadius, double minorRadius) {
        if (majorRadius <= 0 || minorRadius <= 0 || minorRadius >= majorRadius)
            throw new IllegalArgumentException(
                    "Invalid Inputs, must be positive numbers and minor cant be bigger than major");
        return (Math.PI * minorRadius * minorRadius) * (2 * Math.PI * majorRadius);
    }

    /**
     * Static Method to create a new Torus from an input Scanner
     *
     * This method will prompt the user for inputs, check the users inputs for
     * errors, and re-prompt until a valid input is parsed.
     *
     * @param input The input scanner object
     * @return a new Torus Object
     */
    public static Torus fromUserInput(Scanner input) {
        double majorRadius = App.readPositiveDouble(input, "What is the Major Radius?");
        double minorRadius = App.readPositiveDouble(input, "What is the Minor Radius?");
        return new Torus(majorRadius, minorRadius);
    }

    /**
     * Static main method for Torus class
     *
     * Create 3 torus to test the method outputs.
     *
     * Expected results:
     * "The Torus has a volume of 39.48"
     * "The Torus has a volume of 236.87"
     * "The Torus has a volume of 1776.53"
     *
     */
    public static void main(String[] args) {
        Torus to1 = new Torus(2, 1);
        Torus to2 = new Torus(3, 2);
        Torus to3 = new Torus(10, 3);

        System.out.println(to1.toString());
        System.out.println(to2.toString());
        System.out.println(to3.toString());
    }
}
