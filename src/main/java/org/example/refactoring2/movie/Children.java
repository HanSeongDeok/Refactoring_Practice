package org.example.refactoring2.movie;

public class Children extends Movie {
    private int daysRentedForChildrenMovie;

    public Children(String title, int priceCode, int daysRentedForChildrenMovie) {
        super(title, priceCode, daysRentedForChildrenMovie);
        this.daysRentedForChildrenMovie = daysRentedForChildrenMovie;
    }
    public <T extends Children> double getMovieAmount(T movieTypeChildren, double thisAmount) {
        thisAmount = movieTypeChildren.getAmount(thisAmount);
        return (getDaysRentedForMovie() > 3) ? thisAmount + (getDaysRentedForMovie() - 3) * 1.5 : thisAmount;
    }
    @Override
    public int getDaysRentedForMovie() {
        return daysRentedForChildrenMovie;
    }
    @Override
    public double getAmount(double thisAmount) {
        thisAmount += 1.5;
        return (getDaysRentedForMovie() > 3) ? thisAmount + (getDaysRentedForMovie() - 3) * 1.5 : thisAmount;
    }
}
