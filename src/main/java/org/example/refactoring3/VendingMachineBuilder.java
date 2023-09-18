package org.example.refactoring3;

import java.util.List;

public interface VendingMachineBuilder {
    VendingMachineBuilderImpl setDisplay(String display);
    VendingMachineBuilderImpl setCoins(List<Integer> coins);
    VendingMachineBuilderImpl setReturns(List<Integer> returns);
    VendingMachineBuilderImpl setBalance(Integer balance);
    VendingMachineBuilderImpl setAcceptedCoins(Integer[] acceptedCoins);
    VendingMachineBuilderImpl done();

}