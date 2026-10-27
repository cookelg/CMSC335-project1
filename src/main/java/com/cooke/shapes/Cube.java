package com.cooke.shapes;

import java.util.Scanner;

public class Cube extends ThreeDimensionalShape {
    private double length;

    public Cube(double length) {
        super(Cube.calculateVolume(length));
        this.length = length;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.setVolume(Cube.calculateVolume(length));
        this.length = length;
    }

    @Override
    public String toString() {
        return "The volume of the Cube is " + this.getVolume();
    }

    public static double calculateVolume(double length) {
        if (length <= 0)
            throw new IllegalArgumentException("The radius must be a positive number");
        return length * length * length;
    }

    public static Cube fromUserInput(Scanner input) {
        double length = App.readPositiveDouble(input, "What is the Length?");
        return new Cube(length);
    }

}
