package com.cooke.shapes;

/**
 * Abstract ThreeDimensionalShape Class
 *
 * Provides common fields and methods that apply to three-dimensional shapes (cube, sphere, etc). 
 *
 * filename: ThreeDimensionalShape.java
 * creation date: 20261027
 *
 * @author Lawrence Cooke
 */
public abstract class ThreeDimensionalShape extends Shape {
    /**
     * Contains the volume of the three-dimensional shape
     */
    private double volume;

    /**
     * 3D Shape Constructor
     *
     * @param volume the area of the shape
     * @param name   the name descriptor of the shape (e.g. cube)
     */
    public ThreeDimensionalShape(double volume, String name) {
        // 3 will be initialized into this.numberOfDimensions and "volume" into
        // this.metric.
        super(3, name, "volume");
        this.volume = volume;
    }

    /**
     * returns the 3d shape's volume
     *
     * @return double representing the volume of the 3D shape
     */
    public double getVolume() {
        return this.volume;
    }

    /**
     * Sets the 3d shape's volume
     *
     * @param volume The new area of the 3D shape
     */
    protected void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     * returns a String representation of the 3D shape.
     *
     * @return String representation of the 3D shape
     */
    @Override
    public String toString() {
        return super.toString() + this.getVolume();
    }
}
