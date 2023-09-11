package org.example.refactoring2.rental;

import org.example.refactoring2.movie.Movie;

public class Rental {
    private Movie movie;
    private int daysRented;
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
    public Rental(Movie movie) {
        this.movie = movie;
    }
    public int getDaysRented() {return daysRented;}
    public Movie getMovie() {return movie;}
    public int getDaysRentedNew() {return movie.getDaysRented();}
}
