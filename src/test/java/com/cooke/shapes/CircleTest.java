
package com.cooke.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CircleTest {

    @Test
    @DisplayName("Static calculate area method correctly throws exception with Negative number argument")
    public void negativeNumberInput() {
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            Circle.calculateArea(-1);
        });

        assertEquals("The radius must be a positive number", exception1.getMessage());

        System.out.println("PASS: calculateArea() catches negative number argument");

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            new Circle(-1);
        });

        assertEquals("The radius must be a positive number", exception2.getMessage());

        System.out.println("PASS: negative number caught in constructor");
    }

    @Test
    @DisplayName("superclasses instantiated with correct member variables")
    public void superclassMemberVariables() {
        Circle circle = new Circle(1);

        assertEquals(circle.getNumberOfDimensions(), 2);
        System.out.println("PASS: Dimensions correct");
        assertEquals(circle.getArea(), Math.PI);
        System.out.println("PASS: Area correct");
    }
}
