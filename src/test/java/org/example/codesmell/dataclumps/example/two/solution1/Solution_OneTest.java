package org.example.codesmell.dataclumps.example.two.solution1;

import org.example.codesmell.dataclumps.example.example_two.solution1.Solution_One;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution_OneTest {

    @Test
    void printSolution1() {
        Solution_One test = Solution_One.solutionBuilder()
                .setCustomerAddress("TEST1")
                .setCustomerName("TEST2")
                .setQuantity(1)
                .setItemName("TEST3")
                .build();

        assertEquals(test.getCustomerAddress(), "TEST1");
        assertEquals(test.getCustomerName(), "TEST2");
        assertEquals(test.getQuantity(), 1);
        assertEquals(test.getItemName(), "TEST3");
    }

    @Test
    void printMethod(){
        Solution_One test = Solution_One.solutionBuilder()
                .setCustomerAddress("TEST1")
                .setCustomerName("TEST2")
                .setQuantity(1)
                .setItemName("TEST3")
                .build();

        Assertions.assertAll(() -> test.printOrderSummary(test));
    }
}