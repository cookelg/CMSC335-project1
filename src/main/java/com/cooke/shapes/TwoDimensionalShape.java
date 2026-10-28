package com.cooke.shapes;

/**
 * Abstract TwoDimensionalShape Class
 *
 * Provides common fields and methods that apply to two-dimensional shapes (square, rectangle, etc). 
 *
 * filename: TwoDimensionalShape.java
 * creation date: 20261027
 *
 * @author Lawrence Cooke
 */
public abstract class TwoDimensionalShape extends Shape {
    /**
     * Contains the area of the two-dimensional shape
     */
    private double area;

    /**
     * 2D Shape Constructor
     *
     * @param area the area of the shape
     * @param name the name descriptor of the shape (e.g. square)
     */
    public TwoDimensionalShape(double area, String name) {
        // 2 will be initialized into this.numberOfDimensions and "area" into
        // this.metric.
        super(2, name, "area");
        this.area = area;
    }

    /**
     * returns the 2d shape's area
     *
     * @return double representing the area of the 2D shape
     */
    public double getArea() {
        return this.area;
    }

    /**
     * Sets the 2d shape's area
     *
     * @param area The new area of the 2D shape
     */
    protected void setArea(double area) {
        this.area = area;
    }

    /**
     * returns a String representation of the 2D shape.
     *
     * @return String representation of the 2D shape
     */
    @Override
    public String toString() {
        return "The " + this.getName() + " has an " + this.getMetric() + " of " + this.getArea();
    }
}
