package com.cooke.shapes;

public abstract class ThreeDimensionalShape extends Shape {
    private double volume;

    public ThreeDimensionalShape(double volume) {
        super(3);
        this.volume = volume;
    }

    public double getVolume() {
        return this.volume;
    }

    protected void setVolume(double volume) {
        this.volume = volume;
    }
}
