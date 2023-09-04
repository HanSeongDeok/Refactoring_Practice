package org.example.refactoring2.rental;

import org.example.refactoring2.movie.Children;
import org.example.refactoring2.movie.Movie;
import org.example.refactoring2.movie.NewRelease;
import org.example.refactoring2.movie.Regular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
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
    @Deprecated
    public int getDaysRented() {return daysRented;}
    public Movie getMovie() {return movie;}
    public int getDaysRentedNew() {return movie.getDaysRented();}
}
