package org.example.refactoring2.movie;

import org.example.refactoring2.Policy.PricePolicyByMovie;

public class NewRelease extends Movie{
    private int daysRentedForNewReleaseMovie;
    protected NewRelease(String title, int priceCode) {
        super(title, priceCode);
        this.daysRentedForNewReleaseMovie = getDaysRentedForMovie();
    }
   /* @Override
    public double getAmount(double thisAmount) {
        return PricePolicyByMovie.getNewReleaseAmount().setInfo(daysRentedForNewReleaseMovie, thisAmount);
    }*/
    @Override
    public double getAmount(double thisAmount) {
        return PricePolicyByMovie.getNewReleaseAmount().setInfo(daysRentedForNewReleaseMovie, thisAmount);
    }

}
