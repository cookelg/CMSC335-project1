package com.cooke.shapes;

import java.lang.Math;
import java.util.Scanner;

public class Circle extends TwoDimensionalShape {
    private double radius;

    public Circle(double radius) {
        super(Circle.calculateArea(radius));
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.setArea(Circle.calculateArea(radius));
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "The area of the Circle is " + this.getArea();
    }

    public static double calculateArea(double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("The radius must be a positive number");
        return Math.PI * radius * radius;
    }

    public static Circle fromUserInput(Scanner input) {
        double radius = App.readPositiveDouble(input, "What is the Radius?");
        return new Circle(radius);
    }

}
