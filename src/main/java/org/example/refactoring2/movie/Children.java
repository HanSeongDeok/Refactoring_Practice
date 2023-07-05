package org.example.refactoring2.movie;

public class Children extends Movie {
    private int daysRentedForChildrenMovie;

    public Children(String title, int priceCode) {
        super(title, priceCode);
        this.daysRentedForChildrenMovie = getDaysRentedForMovie();
    }
    @Override
    public double getAmount(double thisAmount) {
        return PricePolicyByMovie.getChildrenAmount().setInfo(daysRentedForChildrenMovie,thisAmount);
        /*thisAmount += 1.5;
        return (getDaysRentedForMovie() > 3) ? thisAmount + (getDaysRentedForMovie() - 3) * 1.5 : thisAmount;*/
    }
}