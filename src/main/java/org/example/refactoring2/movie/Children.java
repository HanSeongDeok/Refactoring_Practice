package org.example.refactoring2.movie;

import org.example.refactoring2.Policy.AmountByRentDays;
import org.example.refactoring2.Policy.PricePolicyByMovie;
import org.example.refactoring2.Policy.PricePolicyByMovie2;

public class Children extends Movie {
    public static final int CHILDREN = 2;
    Children(String title, int priceCode, int datsRented) {
        super(title, priceCode, datsRented);
    }
    @Override
    public int getType() {return CHILDREN;}

    @Override
    public double getAmount2(double thisAmount){
        return PricePolicyByMovie2
                .setChildrenPolicy()
                .getAmount(getDaysRented(), thisAmount);
    }
}