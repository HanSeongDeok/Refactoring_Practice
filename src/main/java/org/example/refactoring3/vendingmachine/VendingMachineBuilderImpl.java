package org.example.refactoring3.vendingmachine;

import java.util.List;

public class VendingMachineBuilderImpl implements VendingMachineBuilder{
    private String display;
    private List<Integer> coins;
    private List<Integer> returns;
    private Integer balance;
    private Integer[] acceptedCoins;
    @Override
    public VendingMachineBuilderImpl setDisplay(String display) {
        this.display = display;
        return this;
    }
    @Override
    public VendingMachineBuilderImpl setCoins(List<Integer> coins) {
        this.coins = coins;
        return this;
    }
    @Override
    public VendingMachineBuilderImpl setReturns(List<Integer> returns) {
        this.returns = returns;
        return this;
    }
    @Override
    public VendingMachineBuilderImpl setBalance(Integer balance) {
        this.balance = balance;
        return this;
    }
    @Override
    public VendingMachineBuilderImpl setAcceptedCoins(Integer[] acceptedCoins) {
        this.acceptedCoins = acceptedCoins;
        return this;
    }
    @Override
    public VendingMachineBuilderImpl done() {
        //TODO Validation
        return this;
    }
    private static VendingMachineBuilder vendingMachineBuilder;
    private VendingMachineBuilderImpl(){}
    public static VendingMachineBuilder builder() {
        if(vendingMachineBuilder == null) vendingMachineBuilder = new VendingMachineBuilderImpl();
        return vendingMachineBuilder;
    }
    public String getDisplay() {return display;}
    public List<Integer> getCoins() {return coins;}
    public List<Integer> getReturns() {return returns;}
    public Integer getBalance() {return balance;}
    public Integer[] getAcceptedCoins() {return acceptedCoins;}
}
