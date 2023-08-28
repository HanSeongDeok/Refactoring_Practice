package org.example.refactoring2.rental;

import org.example.refactoring2.movie.Children;
import org.example.refactoring2.movie.Movie;
import org.example.refactoring2.movie.NewRelease;
import org.example.refactoring2.movie.Regular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
public class Rental<T extends Movie> {
    private T movie;
    private int daysRented;
    public Rental(T movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
    public Rental(T movie) {
        this.movie = movie;
    }
    @Deprecated
    public int getDaysRented() {return daysRented;}
    public T getMovie() {return movie;}
    public int getDaysRentedNew() {return movie.getDaysRented();}
}
