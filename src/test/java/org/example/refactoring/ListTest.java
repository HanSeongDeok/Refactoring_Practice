package org.example.refactoring;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    @Test

    public void handlingArray_whenSizeExceedsTen_ExpandsArray() {
        // Arrange
        Object[] elements = new Object[15];
        Arrays.fill(elements, "Element");

        // Act

        // Assert

    }
}