package org.example.refactoring2.movie;

public class NewRelease extends Movie{
    private int daysRentedForNewReleaseMovie;
    protected NewRelease(String title, int priceCode, int daysRentedForNewReleaseMovie) {
        super(title, priceCode, daysRentedForNewReleaseMovie);
        this.daysRentedForNewReleaseMovie = daysRentedForNewReleaseMovie;
    }
    public <T extends NewRelease> double getMovieAmount(T movieTypeNewRelease, double thisAmount) {
        return movieTypeNewRelease.getAmount(thisAmount) + getDaysRentedForMovie() * 3;
    }
    @Override
    public int getDaysRentedForMovie() {
        return daysRentedForNewReleaseMovie;
    }
    @Override
    public double getAmount(double thisAmount) {
        return thisAmount + getDaysRentedForMovie() * 3;
    }
}
