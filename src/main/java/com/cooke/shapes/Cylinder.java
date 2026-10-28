package com.cooke.shapes;

import java.util.Scanner;

/**
 * Cylinder Class 
 *
 * Creates a Cylinder object with with a radius and a height; The Cylinder's volume is 
 * calculated when a new Cylinder is created and when the radius or height is adjusted. 
 *
 * filename: Cylinder.java
 * creation date: 20261027
 *
 * @author Lawrence Cooke
 */
public class Cylinder extends ThreeDimensionalShape {
    /**
     * the radius of the cylinder
     */
    private double radius;
    /**
     * the height of the cylinder
     */
    private double height;

    /**
     * Cylinder Constructor
     *
     * @param radius the radius of the cylinder
     * @param height the height of the cylinder
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public Cylinder(double radius, double height) {
        // Calculate volume with static method before sending to superclass constructor.
        super(Cylinder.calculateVolume(radius, height), "Cylinder");
        this.radius = radius;
        this.height = height;
    }

    /**
     * returns the radius of the cylinder
     *
     * @return double radius of the cylinder
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * returns the height of the cylinder
     *
     * @return double height of the cylinder
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * sets the radius of the cylinder, recalculates this.volume
     *
     * @param radius the radius of the new cylinder
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public void setRadius(double radius) {
        this.setVolume(Cylinder.calculateVolume(radius, this.height));
        this.radius = radius;
    }

    /**
     * sets the height of the cylinder, recalculates this.volume
     *
     * @param height the height of the new cylinder
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public void setHeight(double height) {
        this.setVolume(Cylinder.calculateVolume(this.radius, height));
        this.height = height;
    }

    /**
     * Static Method calculate the volume of any cylinder
     *
     * @param radius the radius of the cylinder
     * @param height the height of the cylinder
     * @throws IllegalArgumentException if any argument is less than or equal to 0.
     */
    public static double calculateVolume(double radius, double height) {
        if (radius <= 0 || height <= 0)
            throw new IllegalArgumentException("The inputs must be positive numbers");
        // the formula for a cone is pi times radius squared times height
        return Math.PI * radius * radius * height;
    }

    /**
     * Static Method to create a new Cylinder from an input Scanner
     *
     * This method will prompt the user for inputs, check the users inputs for
     * errors, and re-prompt until a valid input is parsed.
     *
     * @param input The input scanner object
     * @return a new Cylinder Object
     */
    public static Cylinder fromUserInput(Scanner input) {
        double radius = App.readPositiveDouble(input, "What is the Radius?");
        double height = App.readPositiveDouble(input, "What is the Height?");
        return new Cylinder(radius, height);
    }

    /**
     * Static main method for Cylinder class
     *
     * Create 3 cylinders to test the method outputs.
     *
     * Expected results:
     * "The Cylinder has a volume of 3.14"
     * "The Cylinder has a volume of 37.7"
     * "The Cylinder has a volume of 282.74"
     *
     */
    public static void main(String[] args) {
        Cylinder cy1 = new Cylinder(1, 1);
        Cylinder cy2 = new Cylinder(2, 3);
        Cylinder cy3 = new Cylinder(3, 10);

        System.out.println(cy1.toString());
        System.out.println(cy2.toString());
        System.out.println(cy3.toString());

    }

}
