package com.cooke.shapes;

import java.util.Scanner;

public class Triangle extends TwoDimensionalShape {
    private double aSide;
    private double bSide;
    private double cSide;
    private TriangleType triangleType;

    public Triangle(double side1, double side2, double side3) {
        super(Triangle.calculateArea(side1, side2, side3));
        double a = Triangle.getLow(aSide, this.bSide, this.cSide);
        double b = Triangle.getMid(aSide, this.bSide, this.cSide);
        double c = Triangle.getHigh(aSide, this.bSide, this.cSide);
        this.aSide = a;
        this.bSide = b;
        this.cSide = c;
        // TODO: implement enum assignement
    }

    public double getASide() {
        return this.aSide;
    }

    public double getBSide() {
        return this.bSide;
    }

    public double getCSide() {
        return this.cSide;
    }

    public void setASide(double aSide) {
        this.setArea(Triangle.calculateArea(aSide, this.bSide, this.cSide));
        double a = Triangle.getLow(aSide, this.bSide, this.cSide);
        double b = Triangle.getMid(aSide, this.bSide, this.cSide);
        double c = Triangle.getHigh(aSide, this.bSide, this.cSide);
        this.aSide = a;
        this.bSide = b;
        this.cSide = c;
    }

    public static double calculateArea(double side1, double side2, double side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0)
            throw new IllegalArgumentException("All three inputs must be a positive number");
        double a = Triangle.getLow(side1, side2, side3);
        double b = Triangle.getMid(side1, side2, side3);
        double c = Triangle.getHigh(side1, side2, side3);

        if (a + b < c)
            throw new IllegalArgumentException("the values given are unable to form a triangle.");

        double s = (a + b + c) / 2.0;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static Rectangle fromUserInput(Scanner input) {
        double length = App.readPositiveDouble(input, "What is the Length?");
        double width = App.readPositiveDouble(input, "What is the Width?");
        return new Rectangle(length, width);
    }

    public static double getHigh(double num1, double num2, double num3) {
        // TODO
        return 0;
    }

    public static double getMid(double num1, double num2, double num3) {
        // TODO
        return 0;
    }

    public static double getLow(double num1, double num2, double num3) {
        // TODO
        return 0;
    }
}

enum TriangleType {
    ISO("Isosceles"),
    RIGHT("Right"),
    EQ("Equilateral"),
    SC("Scalene"),
    OB("Obtuse"),
    AC("Acute");

    private final String triangleType;

    private TriangleType(String triangleType) {
        this.triangleType = triangleType;
    }

    public String getTriangleType() {
        return this.triangleType;
    }
}
