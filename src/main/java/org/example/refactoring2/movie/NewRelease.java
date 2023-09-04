package org.example.refactoring2.movie;

import org.example.refactoring2.Policy.PricePolicyByMovie;
import org.example.refactoring2.Policy.PricePolicyByMovie2;

public class NewRelease extends Movie{
    public static final int NEW_RELEASE = 1;
    NewRelease(String title, int priceCode, int datsRented) {
        super(title, priceCode, datsRented);
    }
    @Override
    public int getType() {return NEW_RELEASE;}

    @Override
    public double getAmount2(double thisAmount){
        return PricePolicyByMovie2
                .setNewReleasePolicy()
                .getAmount(getDaysRented(), thisAmount);
    }
}
