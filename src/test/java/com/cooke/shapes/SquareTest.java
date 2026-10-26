package com.cooke.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SquareTest {

    @Test
    @DisplayName("Static calculate area method correctly throws exception with Negative number argument")
    public void negativeNumberInput() {
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            Square.calculateArea(-1);
        });

        assertEquals("The length must be a positive number", exception1.getMessage());

        System.out.println("PASS: Square.calculateArea() catches negative number argument");

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            new Square(-1);
        });

        assertEquals("The length must be a positive number", exception2.getMessage());

        System.out.println("PASS: negative number caught in Square constructor");
    }

    @Test
    @DisplayName("superclasses instantiated with correct member variables")
    public void superclassMemberVariables() {
        Square square = new Square(3);

        assertEquals(square.getNumberOfDimensions(), 2);
        System.out.println("PASS: Square Dimensions correct");
        assertEquals(square.getArea(), 9);
        System.out.println("PASS: Square Area correct");
    }
}
