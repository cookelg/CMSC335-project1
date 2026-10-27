/**
 * Sphere Class 
 *
 * Creates a Sphere object with with a radius; The sphere's volume is 
 * calculated when a new sphere is created and when the radius is adjusted. 
 *
 * filename: Sphere.java
 * creation date: 20261027
 *
 * @author Lawrence Cooke
 */
package com.cooke.shapes;

import java.lang.Math;
import java.util.Scanner;

public class Sphere extends ThreeDimensionalShape {
    /**
     * the radius of the sphere
     */
    private double radius;

    /**
     * Sphere Constructor
     *
     * @param radius:double the radius of the sphere
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public Sphere(double radius) {
        // Calculate volume with static method before sending to superclass constructor.
        super(Sphere.calculateVolume(radius), "Sphere");
        this.radius = radius;
    }

    /**
     * returns the radius of the sphere
     *
     * @return double radius of the sphere
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * sets the radius of the sphere, recalculates this.volume
     *
     * @param radius:double the radius of the sphere
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public void setRadius(double radius) {
        this.setVolume(Sphere.calculateVolume(radius));
        this.radius = radius;
    }

    /**
     * Static Method calculate the volume of any sphere
     *
     * @param radius:double the radius of the sphere
     * @throws IllegalArgumentException if the argument is less than or equal to 0.
     */
    public static double calculateVolume(double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("The radius must be a positive number");
        // Formula for sphere volume is 4/3 * pi * radius cubed
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    /**
     * Static Method to create a new Sphere from an input Scanner
     *
     * This method will prompt the user for inputs, check the users inputs for
     * errors, and re-prompt until a valid input is parsed.
     *
     * @param input:java.utils.Scanner The input scanner object
     * @return a new Sphere Object
     */
    public static Sphere fromUserInput(Scanner input) {
        double radius = App.readPositiveDouble(input, "What is the Radius?");
        return new Sphere(radius);
    }

    /**
     * Static main method for Sphere class
     *
     * Create 3 spheres to test the method outputs.
     *
     * Expected results:
     * "The Sphere has a volume of 4.19"
     * "The Sphere has a volume of 33.51"
     * "The Sphere has a volume of 113.1"
     *
     */
    public static void main(String[] args) {
        Sphere sph1 = new Sphere(1);
        Sphere sph2 = new Sphere(2);
        Sphere sph3 = new Sphere(3);

        System.out.println(sph1.toString());
        System.out.println(sph2.toString());
        System.out.println(sph3.toString());

    }

}
