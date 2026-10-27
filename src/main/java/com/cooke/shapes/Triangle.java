/**
 * Triangle Class and TriangleType enum class
 *
 * Creates a Triangle object with three sides of adjustable lentgth; The triangle 
 * area and triangle type is calculate when a new triangle is created and when any 
 * side is adjusted. 
 *
 * filename: Triangle.java
 * creation date: 20261027
 *
 * @author Lawrence Cooke
 */
package com.cooke.shapes;

import java.util.Arrays;
import java.util.Scanner;

public class Triangle extends TwoDimensionalShape {
    /**
     * the length of side 1
     */
    private double side1;
    /**
     * the length of side 2
     */
    private double side2;
    /**
     * the length of side 3
     */
    private double side3;
    /**
     * Triangle type, enum TriangleType can be either Right, Obtuse, or Acute
     */
    private TriangleType triangleType;

    /**
     * Triangle Constructor
     *
     * @param side1:double the length of the first side
     * @param side2:double the length of the second side
     * @param side3:double the length of the third side
     * @throws IllegalArgumentException Either if the lengths provided to not form
     *                                  a proper triangle, or if any arguments are
     *                                  less than or equal to 0.
     */
    public Triangle(double side1, double side2, double side3) {
        // Calculate area with static method before sending to superclass constructor.
        super(
                Triangle.calculateArea(side1, side2, side3),
                Triangle.getTriangleType(side1, side2, side3).getTriangleType()
                        + "-Triangle");

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        // Calculate the triangle type, assign enum.
        this.triangleType = Triangle.getTriangleType(side1, side2, side3);
    }

    /**
     * returns the length of side1
     *
     * @return int length of side 1
     */
    public double getSide1() {
        return this.side1;
    }

    /**
     * returns the length of side2
     *
     * @return int length of side 2
     */
    public double getSide2() {
        return this.side2;
    }

    /**
     * returns the length of side3
     *
     * @return int length of side 3
     */
    public double getSide3() {
        return this.side3;
    }

    /**
     * sets the length of side 1, recalculates triangle type, changes the name to
     * reflect
     *
     * @throws IllegalArgumentException Either if the lengths provided to not form
     *                                  a proper triangle, or if any arguments are
     *                                  less than or equal to 0.
     */
    public void setSide1(double side1) {
        this.setArea(Triangle.calculateArea(side1, this.side2, this.side3));
        this.side1 = side1;
        this.triangleType = Triangle.getTriangleType(side1, this.side2, this.side3);
        this.setName(this.triangleType.getTriangleType() + "-Triangle");
    }

    /**
     * sets the length of side 2, recalculates triangle type, changes the name to
     * reflect
     *
     * @throws IllegalArgumentException Either if the lengths provided to not form
     *                                  a proper triangle, or if any arguments are
     *                                  less than or equal to 0.
     */
    public void setSide2(double side2) {
        this.setArea(Triangle.calculateArea(this.side1, side2, this.side3));
        this.side2 = side2;
        this.triangleType = Triangle.getTriangleType(this.side1, side2, this.side3);
        this.setName(this.triangleType.getTriangleType() + "-Triangle");
    }

    /**
     * sets the length of side 3, recalculates triangle type, changes the name to
     * reflect
     *
     * @throws IllegalArgumentException Either if the lengths provided to not form
     *                                  a proper triangle, or if any arguments are
     *                                  less than or equal to 0.
     */
    public void setSide3(double side3) {
        this.setArea(Triangle.calculateArea(this.side1, this.side2, side3));
        this.side3 = side3;
        this.triangleType = Triangle.getTriangleType(this.side1, this.side2, side3);
        this.setName(this.triangleType.getTriangleType() + "-Triangle");
    }

    /**
     * returns a string representation of the triangle type.
     *
     * @return String representing the trange type
     */
    public String getType() {
        return this.triangleType.getTriangleType();
    }

    /**
     * Static Method calculate the area of any triangle
     *
     * @param side1:double the length of the first side
     * @param side2:double the length of the second side
     * @param side3:double the length of the third side
     * @throws IllegalArgumentException Either if the lengths provided to not form
     *                                  a proper triangle, or if any arguments are
     *                                  less than or equal to 0.
     */
    public static double calculateArea(double side1, double side2, double side3) {
        // check for any negative arguments
        if (side1 <= 0 || side2 <= 0 || side3 <= 0)
            throw new IllegalArgumentException("All three inputs must be a positive number");

        // Store arguments in an array for easy sorting
        double[] arr = { side1, side2, side3 };
        Arrays.sort(arr);

        double a = arr[0];
        double b = arr[1];
        double c = arr[2];

        // if the length of the longest side is >= the sum of the other
        // two sides, a triangle cannot be formed
        if (a + b <= c)
            throw new IllegalArgumentException("the values given are unable to form a triangle.");

        // Heron's formula requires the semi-perimeter
        double s = (a + b + c) / 2.0;

        // return Heron's formula for Triangle area
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /**
     * Static Method to create a new Triangle from an input Scanner
     *
     * This method will prompt the user for inputs, check the users inputs for
     * errors,
     * and re-prompt until a valid input is parsed.
     *
     * @param input:java.utils.Scanner The input scanner object
     * @return a new Triangle Object
     */
    public static Triangle fromUserInput(Scanner input) {
        double side1 = App.readPositiveDouble(input, "What is the Length of side 1?");
        double side2 = App.readPositiveDouble(input, "What is the Length of side 2?");
        double side3 = App.readPositiveDouble(input, "What is the Length of side 3?");
        return new Triangle(side1, side2, side3);
    }

    /**
     * Static Method to determine a triangle type with three known side lengths
     *
     * @param side1:double the length of the first side
     * @param side2:double the length of the second side
     * @param side3:double the length of the third side
     * @throws IllegalArgumentException Either if the lengths provided to not form
     *                                  a proper triangle, or if any arguments are
     *                                  less than or equal to 0.
     */
    public static TriangleType getTriangleType(double side1, double side2, double side3) {
        // calculate area method only used to catch invalid arguments
        Triangle.calculateArea(side1, side2, side3);

        // Store arguments in an array for easy sorting
        double[] arr = { side1, side2, side3 };
        Arrays.sort(arr);
        double a = arr[0];
        double b = arr[1];
        double c = arr[2];

        // pythagorean theorem used to determine triangle type
        if ((a * a) + (b * b) >= c * c) {
            if ((a * a) + (b * b) == c * c)
                return TriangleType.RIGHT;
            return TriangleType.ACUTE;
        } else
            return TriangleType.OBTUSE;

    }
}

/**
 * TriangleType enum
 *
 * Three enums correspond to Right, Obtuse, and Acute Triangles
 */
enum TriangleType {
    // RIGHT enum will pass the String "Right" to the constructor
    RIGHT("Right"),
    // OBTUSE enum will pass the String "Obtuse" to the constructor
    OBTUSE("Obtuse"),
    // ACUTE enum will pass the String "Right" to the constructor
    ACUTE("Acute");

    /**
     * String enum member variable to contain the String representation of the enum
     */
    private final String triangleType;

    /**
     * Constructor for a TriangleType enum
     *
     * The constructors RIGHT, OBTUSE, and ACUTE will initialize a new TriangleType
     * enum with the appropriate String representation.
     */
    private TriangleType(String triangleType) {
        this.triangleType = triangleType;
    }

    /**
     * Returns a String representation of the TriangleType.
     *
     * @return String representation of the Triangle type.
     */
    public String getTriangleType() {
        return this.triangleType;
    }
}
