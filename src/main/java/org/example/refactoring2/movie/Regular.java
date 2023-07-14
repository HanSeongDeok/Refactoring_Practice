package org.example.refactoring2.movie;

import org.example.refactoring2.Policy.PricePolicyByMovie;

public class Regular extends Movie{
    private int daysRentedForRegularMovie;
    protected Regular(String title, int priceCode) {
        super(title, priceCode);
        this.daysRentedForRegularMovie = getDaysRentedForMovie();
    }
    @Override
    public double getAmount(double thisAmount) {
        return PricePolicyByMovie.getRegularAmount().setInfo(daysRentedForRegularMovie, thisAmount);
    }
}
