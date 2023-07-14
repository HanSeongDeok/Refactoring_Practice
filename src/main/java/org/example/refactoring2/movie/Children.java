package org.example.refactoring2.movie;

import org.example.refactoring2.Policy.PricePolicyByMovieImpl;

public class Children extends Movie {
    private int daysRentedForChildrenMovie;

    public Children(String title, int priceCode) {
        super(title, priceCode);
        //this.daysRentedForChildrenMovie = getDaysRentedForMovie();
    }

    // Case 1
    /*@Override
    public double getAmount(double thisAmount) {
        return PricePolicyByMovie.getChildrenAmount().setInfo(daysRentedForChildrenMovie,thisAmount);
    }*/

    // Case 2
    @Override
    public double getAmount(double thisAmount) {
        return new PricePolicyByMovieImpl(this, thisAmount)
                .getChildrenAmount((rentDays, amount) -> {
                    amount += 1.5;
                    return (rentDays > 3) ? amount + (rentDays - 3) * 1.5 : amount;
                });
    }

}