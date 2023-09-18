package org.example.refactoring3.vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {
    private String display;
    private List<Integer> coins;
    private List<Integer> returns;
    private Integer balance;
    private Integer[] acceptedCoins;
    public VendingMachine(){
        VendingMachineBuilderImpl vendingMachineBuilder = VendingMachineBuilderImpl.builder()
                .setDisplay("")
                .setCoins(new ArrayList<>())
                .setReturns(new ArrayList<>())
                .setBalance(0)
                .setAcceptedCoins(new Integer[]{5, 10, 25})
                .done();
        new VendingMachine(vendingMachineBuilder);
    }
    public VendingMachine(VendingMachineBuilderImpl vendingMachineBuilder) {
        this.display = vendingMachineBuilder.getDisplay();
        this.balance = vendingMachineBuilder.getBalance();
        this.coins = vendingMachineBuilder.getCoins();
        this.returns = vendingMachineBuilder.getReturns();
        this.acceptedCoins = vendingMachineBuilder.getAcceptedCoins();
        displayBalance();
    }
    private void displayBalance() {
        if(this.balance != 0) this.display = String.valueOf(this.balance);
        else this.display = "INSERT COIN";
    }
    public void insertCoin(Integer coin){
        if(Arrays.asList(acceptedCoins).contains(coin)){
            this.coins.add(coin);
            this.balance += coin;
            this.displayBalance();
        }
        else this.returns.add(coin);
    }
    public Integer balance() {
        return balance;
    }
    public Integer[] coins() {
        return coins.toArray(new Integer[0]);
    }
    public String display() {
        return display;
    }
}