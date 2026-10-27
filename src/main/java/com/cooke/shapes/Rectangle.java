package com.cooke.shapes;

import java.util.Scanner;

public class Rectangle extends TwoDimensionalShape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super(Rectangle.calculateArea(length, width));
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    public void setLength(double length) {
        this.setArea(Rectangle.calculateArea(length, this.width));
        this.length = length;
    }

    @Override
    public String toString() {
        return "The area of the Rectangle is " + this.getArea();
    }

    public static double calculateArea(double length, double width) {
        if (length <= 0 || width <= 0)
            throw new IllegalArgumentException("Both inputs must be a positive number");
        return length * width;
    }

    public static Rectangle fromUserInput(Scanner input) {
        double length = App.readPositiveDouble(input, "What is the Length?");
        double width = App.readPositiveDouble(input, "What is the Width?");
        return new Rectangle(length, width);
    }

}
