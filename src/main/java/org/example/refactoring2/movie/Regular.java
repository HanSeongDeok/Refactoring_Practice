package org.example.refactoring2.movie;

import org.example.refactoring2.Policy.PricePolicyByMovie2;

public class Regular extends Movie{
    public static final int REGULAR = 0;
    Regular(String title, int priceCode, int datsRented) {
        super(title, priceCode, datsRented);
    }
    @Override
    public int getType() {return REGULAR;}

    public double getAmount2(double thisAmount){
        return PricePolicyByMovie2
                .setRegularPolicy()
                .getAmount(getDaysRented(), thisAmount);
    }
}
