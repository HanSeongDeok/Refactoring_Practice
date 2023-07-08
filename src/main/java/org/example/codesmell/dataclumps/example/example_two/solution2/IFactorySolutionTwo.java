package org.example.codesmell.dataclumps.example.example_two.solution2;

public interface IFactorySolutionTwo {
    IFactorySolutionTwo setCustomerAddress(String customerAddress);
    IFactorySolutionTwo setCustomerName(String customerName);
    IFactorySolutionTwo setItemName(String itemName);
    IFactorySolutionTwo setQuantity(int quantity);
    Solution_Two build();
}
