package com.cooke.shapes;

import java.util.Scanner;

public class Cone extends ThreeDimensionalShape {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        super(Cone.calculateVolume(radius, height), "Cone");
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
        this.setVolume(Cone.calculateVolume(radius, this.height));
        this.radius = radius;
    }

    public void setHeight(double height) {
        this.setVolume(Cone.calculateVolume(this.radius, height));
        this.height = height;
    }

    public static double calculateVolume(double radius, double height) {
        if (radius <= 0 || height <= 0)
            throw new IllegalArgumentException("The inputs must be positive numbers");
        return Math.PI * radius * radius * height / 3;
    }

    public static Cone fromUserInput(Scanner input) {
        double radius = App.readPositiveDouble(input, "What is the Radius?");
        double height = App.readPositiveDouble(input, "What is the Height?");
        return new Cone(radius, height);
    }

}
