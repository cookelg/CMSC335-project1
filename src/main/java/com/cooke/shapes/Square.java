
package com.cooke.shapes;

import java.util.Scanner;

public class Square extends TwoDimensionalShape {
    private double length;

    public Square(double length) {
        super(Square.calculateArea(length), "Square");
        this.length = length;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.setArea(Square.calculateArea(length));
        this.length = length;
    }

    public static double calculateArea(double length) {
        if (length <= 0)
            throw new IllegalArgumentException("The length must be a positive number");
        return length * length;
    }

    public static Square fromUserInput(Scanner input) {
        double length = App.readPositiveDouble(input, "What is the Length?");
        return new Square(length);
    }

}
