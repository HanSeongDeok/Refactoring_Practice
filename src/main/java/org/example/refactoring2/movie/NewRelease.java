package org.example.refactoring2.movie;

import org.example.refactoring2.Policy.PricePolicyByMovie;
import org.example.refactoring2.Policy.PricePolicyByMovie2;

public class NewRelease extends Movie{
    protected NewRelease(String title, int priceCode, int datsRented) {
        super(title, priceCode, datsRented);
    }
    @Override
    public double getAmount(double thisAmount) {
        return PricePolicyByMovie.setNewReleasePolicy()
                .getAmount(getDaysRented(), thisAmount);
    }
    public double getAmount2(double thisAmount){
        return PricePolicyByMovie2
                .setNewReleasePolicy()
                .amount(getDaysRented(), thisAmount);
    }
}
