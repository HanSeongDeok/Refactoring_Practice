package org.example.refactoring2.Policy;

import org.example.refactoring2.movie.Movie;

public class PricePolicyByMovieImpl implements PricePolicyByMovieTemp{
    private int rentDays;
    private double thisAmount;
    public <T extends Movie> PricePolicyByMovieImpl(T movie, double aMount) {
        this.rentDays = movie.getDaysRentedForMovie();
        this.thisAmount = aMount;
    }
    @Override
    public double getChildrenAmount(AmountByRentDays amountByRentDays) {
        return amountByRentDays.amount(getRentDays(), getThisAmount());
    }
    @Override
    public double getNewReleaseAmount(AmountByRentDays amountByRentDays) {
        return amountByRentDays.amount(getRentDays(), getThisAmount());
    }
    @Override
    public double getRegularAmount(AmountByRentDays amountByRentDays) {
        return amountByRentDays.amount(getRentDays(), getThisAmount());
    }
    public int getRentDays() {return rentDays;}
    public double getThisAmount() {return thisAmount;}
}
