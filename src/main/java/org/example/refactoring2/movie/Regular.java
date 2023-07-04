package org.example.refactoring2.movie;

public class Regular extends Movie{
    private int daysRentedForRegularMovie;
    protected Regular(String title, int priceCode, int daysRentedForRegularMovie) {
        super(title, priceCode, daysRentedForRegularMovie);
        this.daysRentedForRegularMovie = daysRentedForRegularMovie;
    }
    public <T extends Regular> double getMovieAmount(T movieTypeRegular, double thisAmount) {
        thisAmount = movieTypeRegular.getAmount(thisAmount);
        return (getDaysRentedForMovie() > 2) ? thisAmount + (getDaysRentedForMovie() - 2) * 1.5 : thisAmount;
    }
    @Override
    public int getDaysRentedForMovie() {
        return daysRentedForRegularMovie;
    }
    @Override
    public double getAmount(double thisAmount) {
        thisAmount += 2;
        return (getDaysRentedForMovie() > 2) ? thisAmount + (getDaysRentedForMovie() - 2) * 1.5 : thisAmount;
    }
}
