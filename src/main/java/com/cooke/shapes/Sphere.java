package com.cooke.shapes;

import java.lang.Math;
import java.util.Scanner;

public class Sphere extends ThreeDimensionalShape {
    private double radius;

    public Sphere(double radius) {
        super(Sphere.calculateVolume(radius), "Sphere");
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.setVolume(Sphere.calculateVolume(radius));
        this.radius = radius;
    }

    public static double calculateVolume(double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("The radius must be a positive number");
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    public static Sphere fromUserInput(Scanner input) {
        double radius = App.readPositiveDouble(input, "What is the Radius?");
        return new Sphere(radius);
    }

}
