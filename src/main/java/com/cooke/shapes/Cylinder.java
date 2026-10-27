package com.cooke.shapes;

import java.util.Scanner;

public class Cylinder extends ThreeDimensionalShape {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        super(Cylinder.calculateVolume(radius, height));
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getHeight() {
        return this.height;
    }

    public void setRadius(double radius) {
        this.setVolume(Cylinder.calculateVolume(radius, this.height));
        this.radius = radius;
    }

    public void setHeight(double height) {
        this.setVolume(Cylinder.calculateVolume(this.radius, height));
        this.height = height;
    }

    @Override
    public String toString() {
        return "The volume of the Cylinder is " + this.getVolume();
    }

    public static double calculateVolume(double radius, double height) {
        if (radius <= 0 || height <= 0)
            throw new IllegalArgumentException("The inputs must be positive numbers");
        return Math.PI * radius * radius * height;
    }

    public static Cylinder fromUserInput(Scanner input) {
        double radius = App.readPositiveDouble(input, "What is the Radius?");
        double height = App.readPositiveDouble(input, "What is the Height?");
        return new Cylinder(radius, height);
    }

}
