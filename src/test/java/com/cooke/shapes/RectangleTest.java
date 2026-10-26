package com.cooke.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    @Test
    @DisplayName("Static calculate area method correctly throws exception with Negative number argument")
    public void negativeNumberInput() {
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            Rectangle.calculateArea(-1, 1);
        });

        assertEquals("Both inputs must be a positive number", exception1.getMessage());

        System.out.println("PASS: Rectangle.calculateArea() catches negative length argument");

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            Rectangle.calculateArea(1, -1);
        });

        assertEquals("Both inputs must be a positive number", exception2.getMessage());

        System.out.println("PASS: Rectangle.calculateArea() catches negative width argument");

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(-1, -1);
        });

        assertEquals("Both inputs must be a positive number", exception3.getMessage());

        System.out.println("PASS: two negative number caught in Rectangle constructor");
    }

    @Test
    @DisplayName("superclasses instantiated with correct member variables")
    public void superclassMemberVariables() {
        Rectangle rectangle = new Rectangle(3, 4);

        assertEquals(rectangle.getNumberOfDimensions(), 2);
        System.out.println("PASS: Rectangle Dimensions correct");
        assertEquals(rectangle.getArea(), 12);
        System.out.println("PASS: Rectangle Area correct");
    }
}
