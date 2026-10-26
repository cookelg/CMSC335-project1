package com.cooke.shapes;

public abstract class Shape {
    private final int numberOfDimensions;

    public Shape(int numberOfDimensions) {
        this.numberOfDimensions = numberOfDimensions;
    }

    public int getNumberOfDimensions() {
        return this.numberOfDimensions;
    }
}
