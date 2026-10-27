package com.cooke.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    @DisplayName("Static calculate area method correctly throws exception with Negative number argument")
    public void negativeNumberInputTest() {
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            Triangle.calculateArea(-1, 1, 1);
        });
        assertEquals("All three inputs must be a positive number", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            Triangle.calculateArea(1, -1, 1);
        });
        assertEquals("All three inputs must be a positive number", exception2.getMessage());

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> {
            Triangle.calculateArea(1, 1, -1);
        });
        assertEquals("All three inputs must be a positive number", exception3.getMessage());

        System.out.println("PASS: Triangle.calculateArea() catches negative side argument");

        IllegalArgumentException exception4 = assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(-1, -1, -1);
        });

        assertEquals("All three inputs must be a positive number", exception4.getMessage());

        System.out.println("PASS: Triangle.calculateArea() catches negative side argument");
    }

    @Test
    @DisplayName("Superclasses instantiated with correct member variables")
    public void calculatedMemberVariableTest() {
        Triangle rTriangle = new Triangle(3, 4, 5);
        Triangle aTriangle = new Triangle(4, 4, 5);
        Triangle oTriangle = new Triangle(5, 6, 10);

        assertEquals(rTriangle.getNumberOfDimensions(), 2);
        System.out.println("PASS: Triangle Dimensions is 2");
        assertEquals(rTriangle.getArea(), 6);
        System.out.println("PASS: Triangle Area is 6");
        assertEquals(rTriangle.getType(), "Right");
        System.out.println("PASS: Triangle type is Right");

        assertEquals(aTriangle.getNumberOfDimensions(), 2);
        System.out.println("PASS: Triangle2 Dimensions is 2");
        assertEquals(aTriangle.getArea(), Math.sqrt(6.5 * 2.5 * 2.5 * 1.5));
        System.out.println("PASS: Triangle2 Area is " + aTriangle.getArea());
        assertEquals(aTriangle.getType(), "Acute");
        System.out.println("PASS: Triangle2 type is Acute");

        assertEquals(oTriangle.getType(), "Obtuse");
        System.out.println("PASS: Triangle3 type is Obtuse");
    }

    @Test
    @DisplayName("Test argument sorting and invalid triangle exception")
    public void argumentSortAndInvalidLengthTest() {
        Triangle tri1 = new Triangle(5, 4, 3);
        assertEquals(tri1.getArea(), 6);
        assertEquals(tri1.getType(), "Right");
        System.out.println("PASS: Triangle arguments sorted, Area is 6, type is Right");

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            Triangle.calculateArea(1, 3, 1);
        });
        assertEquals("the values given are unable to form a triangle.", exception1.getMessage());
        System.out.println("PASS: invalid triangle lengths caught");
    }
}
