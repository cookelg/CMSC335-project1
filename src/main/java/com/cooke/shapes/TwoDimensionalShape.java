package com.cooke.shapes;

public abstract class TwoDimensionalShape extends Shape {
    private double area;

    public TwoDimensionalShape(double area) {
        super(2);
        this.area = area;
    }

    public double getArea() {
        return this.area;
    }

    protected void setArea(double area) {
        this.area = area;
    }
}
