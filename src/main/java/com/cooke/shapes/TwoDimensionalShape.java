package com.cooke.shapes;

public abstract class TwoDimensionalShape extends Shape {
    private double area;

    public TwoDimensionalShape(double area, String name) {
        super(2, name, "area");
        this.area = area;
    }

    public double getArea() {
        return this.area;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "The " + this.getName() + " has an " + this.getMetric() + " of " + this.getArea();
    }
}
