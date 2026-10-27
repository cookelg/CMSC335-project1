package com.cooke.shapes;

public abstract class ThreeDimensionalShape extends Shape {
    private double volume;

    public ThreeDimensionalShape(double volume, String name) {
        super(3, name, "volume");
        this.volume = volume;
    }

    public double getVolume() {
        return this.volume;
    }

    protected void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() + this.getVolume();
    }
}
