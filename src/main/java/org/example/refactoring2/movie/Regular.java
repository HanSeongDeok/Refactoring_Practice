package org.example.refactoring2.movie;

public class Regular extends Movie{
    private int daysRentedForRegularMovie;
    protected Regular(String title, int priceCode) {
        super(title, priceCode);
        this.daysRentedForRegularMovie = getDaysRentedForMovie();
    }
    @Override
    public double getAmount(double thisAmount) {
        return PricePolicyByMovie.getRegularAmount().setInfo(daysRentedForRegularMovie, thisAmount);
        /*thisAmount += 2;
        return (getDaysRentedForMovie() > 2) ? thisAmount + (getDaysRentedForMovie() - 2) * 1.5 : thisAmount;*/
    }
}
