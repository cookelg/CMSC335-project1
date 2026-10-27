package com.cooke.shapes;

import java.util.Arrays;
import java.util.Scanner;

public class Triangle extends TwoDimensionalShape {
    private double side1;
    private double side2;
    private double side3;
    private TriangleType triangleType;

    public Triangle(double side1, double side2, double side3) {
        super(Triangle.calculateArea(side1, side2, side3));

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.triangleType = Triangle.getTriangleType(side1, side2, side3);
    }

    public double getSide1() {
        return this.side1;
    }

    public double getSide2() {
        return this.side2;
    }

    public double getSide3() {
        return this.side3;
    }

    public void setSide1(double side1) {
        this.setArea(Triangle.calculateArea(side1, this.side2, this.side3));
        this.side1 = side1;
        this.triangleType = Triangle.getTriangleType(side1, this.side2, this.side3);
    }

    public void setSide2(double side2) {
        this.setArea(Triangle.calculateArea(this.side1, side2, this.side3));
        this.side2 = side2;
        this.triangleType = Triangle.getTriangleType(this.side1, side2, this.side3);
    }

    public void setSide3(double side3) {
        this.setArea(Triangle.calculateArea(this.side1, this.side2, side3));
        this.side3 = side3;
        this.triangleType = Triangle.getTriangleType(this.side1, this.side2, side3);
    }

    public String getType() {
        return this.triangleType.getTriangleType();
    }

    @Override
    public String toString() {
        return "The area of the " + this.getType() + " Triangle is " + this.getArea();
    }

    public static double calculateArea(double side1, double side2, double side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0)
            throw new IllegalArgumentException("All three inputs must be a positive number");

        double[] arr = { side1, side2, side3 };
        Arrays.sort(arr);

        double a = arr[0];
        double b = arr[1];
        double c = arr[2];

        if (a + b < c)
            throw new IllegalArgumentException("the values given are unable to form a triangle.");

        double s = (a + b + c) / 2.0;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static Triangle fromUserInput(Scanner input) {
        double side1 = App.readPositiveDouble(input, "What is the Length of side 1?");
        double side2 = App.readPositiveDouble(input, "What is the Length of side 2?");
        double side3 = App.readPositiveDouble(input, "What is the Length of side 3?");
        return new Triangle(side1, side2, side3);
    }

    public static TriangleType getTriangleType(double side1, double side2, double side3) {
        double[] arr = { side1, side2, side3 };
        Arrays.sort(arr);
        double a = arr[0];
        double b = arr[1];
        double c = arr[2];

        if ((a * a) + (b * b) >= c * c) {
            if ((a * a) + (b * b) == c * c)
                return TriangleType.RIGHT;
            return TriangleType.ACUTE;
        } else
            return TriangleType.OBTUSE;

    }
}

enum TriangleType {
    RIGHT("Right"),
    OBTUSE("Obtuse"),
    ACUTE("Acute");

    private final String triangleType;

    private TriangleType(String triangleType) {
        this.triangleType = triangleType;
    }

    public String getTriangleType() {
        return this.triangleType;
    }
}
