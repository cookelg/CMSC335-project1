package com.cooke.shapes;

import java.util.Scanner;

public class Torus extends ThreeDimensionalShape {
    private double majorRadius;
    private double minorRadius;

    public Torus(double majorRadius, double minorRadius) {
        super(Torus.calculateVolume(majorRadius, minorRadius));
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    public double getMajorRadius() {
        return this.majorRadius;
    }

    public double getMinorRadius() {
        return this.minorRadius;
    }

    public void getMajorRadius(double majorRadius) {
        this.setVolume(Torus.calculateVolume(majorRadius, this.minorRadius));
        this.majorRadius = majorRadius;
    }

    public void getMinorRadius(double minorRadius) {
        this.setVolume(Torus.calculateVolume(this.majorRadius, minorRadius));
        this.minorRadius = minorRadius;
    }

    @Override
    public String toString() {
        return "The volume of the Torus is " + this.getVolume();
    }

    public static double calculateVolume(double majorRadius, double minorRadius) {
        if (majorRadius <= 0 || minorRadius <= 0 || minorRadius >= majorRadius)
            throw new IllegalArgumentException(
                    "Invalid Inputs, must be positive numbers and minor cant be bigger than major");
        return (Math.PI * minorRadius * minorRadius) * (2 * Math.PI * majorRadius);
    }

    public static Torus fromUserInput(Scanner input) {
        double majorRadius = App.readPositiveDouble(input, "What is the Major Radius?");
        double minorRadius = App.readPositiveDouble(input, "What is the Minor Radius?");
        return new Torus(majorRadius, minorRadius);
    }

}
