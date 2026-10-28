package com.cooke.shapes;

import java.util.Scanner;

/**
 * Cube Class 
 *
 * Creates a Cube object with with a given length; The Cube's volume is 
 * calculated when a new Cube is created and when the radius is adjusted. 
 *
 * filename: Cube.java
 * creation date: 20261027
 *
 * @author Lawrence Cooke
 */
public class Cube extends ThreeDimensionalShape {
    /**
     * the length of all sides of the cube
     */
    private double length;

    /**
     * Cube Constructor
     *
     * @param length the length of the Cube
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public Cube(double length) {
        // Calculate volume with static method before sending to superclass constructor.
        super(Cube.calculateVolume(length), "Cube");
        this.length = length;
    }

    /**
     * returns the length of the cube
     *
     * @return double length of the cube
     */
    public double getLength() {
        return this.length;
    }

    /**
     * sets the length of the cube, recalculates this.volume
     *
     * @param length the length of the cube
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public void setLength(double length) {
        this.setVolume(Cube.calculateVolume(length));
        this.length = length;
    }

    /**
     * Static Method calculate the volume of any Cube
     *
     * @param length the length of the cube
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public static double calculateVolume(double length) {
        if (length <= 0)
            throw new IllegalArgumentException("The radius must be a positive number");
        // volume of a cube is the length squared
        return length * length * length;
    }

    /**
     * Static Method to create a new Cube from an input Scanner
     *
     * This method will prompt the user for inputs, check the users inputs for
     * errors, and re-prompt until a valid input is parsed.
     *
     * @param input The input scanner object
     * @return a new Cube Object
     */
    public static Cube fromUserInput(Scanner input) {
        double length = App.readPositiveDouble(input, "What is the Length?");
        return new Cube(length);
    }

    /**
     * Static main method for Cube class
     *
     * Create 3 cubes to test the method outputs.
     *
     * Expected results:
     * "The Cube has a volume of 1"
     * "The Cube has a volume of 8"
     * "The Cube has a volume of 27"
     *
     */
    public static void main(String[] args) {
        Cube cu1 = new Cube(1);
        Cube cu2 = new Cube(2);
        Cube cu3 = new Cube(3);

        System.out.println(cu1.toString());
        System.out.println(cu2.toString());
        System.out.println(cu3.toString());

    }

}
