package org.example.codesmell.dataclumps.example.two.solution1;

import org.example.codesmell.dataclumps.example.example_two.solution1.Solution_One;
import org.example.codesmell.dataclumps.example.example_two.solution2.Solution_Two;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution_TwoTest {
    @Test
    void printSolution2() {
        Solution_Two test = Solution_Two.Solution_Two_Builder()
                .setCustomerAddress("TEST1")
                .setQuantity(1)
                .setItemName("TEST3")
                .setCustomerName("TEST2")
                .build();

        assertEquals(test.getCustomerAddress(), "TEST1");
        assertEquals(test.getCustomerName(), "TEST2");
        assertEquals(test.getQuantity(), 1);
        assertEquals(test.getItemName(), "TEST3");
    }
}
