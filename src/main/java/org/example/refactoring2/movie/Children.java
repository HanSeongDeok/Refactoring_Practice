package org.example.refactoring2.movie;

import org.example.refactoring2.Policy.AmountByRentDays;
import org.example.refactoring2.Policy.PricePolicyByMovie;
import org.example.refactoring2.Policy.PricePolicyByMovie2;

public class Children extends Movie {
    public Children(String title, int priceCode, int datsRented) {
        super(title, priceCode, datsRented);
    }
    @Override
    public double getAmount(double thisAmount) {
        return PricePolicyByMovie.setChildrenPolicy()
                    .getAmount(getDaysRented(), thisAmount);
    }
    public double getAmount2(double thisAmount){
        return PricePolicyByMovie2
                .setChildrenPolicy()
                .amount(getDaysRented(), thisAmount);
    }
}