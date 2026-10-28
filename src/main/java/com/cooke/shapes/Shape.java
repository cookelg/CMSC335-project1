package com.cooke.shapes;

/**
 * Abstract Shape Class
 *
 * Provides common fields and methods that apply to all shapes. 
 *
 * filename: Shape.java
 * creation date: 20261027
 *
 * @author Lawrence Cooke
 */
public abstract class Shape {
    /**
     * The number of dimensions, will either be 2D or 3D.
     */
    private final int numberOfDimensions;
    /**
     * The name descriptor of the shape. e.g "Square".
     */
    private String name;
    /**
     * The metric for measuring the space of a shape. "area" for 2D shapes, "volume"
     * for 3D shapes.
     */
    private final String metric;

    /**
     * Shape Constructor
     *
     * @param numberOfDimensions specifies if shape is 2D or 3D.
     * @param name               the name descriptor of the shape (e.g. square)
     * @param metric             the metric for measuring the space of a shape
     *                           (e.g. area)
     */
    public Shape(int numberOfDimensions, String name, String metric) {
        this.numberOfDimensions = numberOfDimensions;
        this.name = name;
        this.metric = metric;
    }

    /**
     * returns the shape dimension.
     *
     * @return int representing the dimension; will either be 2 or 3
     */

    public int getNumberOfDimensions() {
        return this.numberOfDimensions;
    }

    /**
     * returns the shape name.
     *
     * @return String with the shape's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * returns the space measurment metric.
     *
     * @return String representing the space metric; "Area" or "Volume"
     */
    public String getMetric() {
        return this.metric;
    }

    /**
     * sets the name of the Shape
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns a basic description of the shape.
     *
     * @return String describing the shape
     */
    @Override
    public String toString() {
        return "The " + this.getName() + " has a " + this.getMetric() + " of ";

    }
}
