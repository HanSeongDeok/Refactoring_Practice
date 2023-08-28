package org.example.refactoring2;

import org.example.refactoring2.movie.Movie;
import org.example.refactoring2.movie.function.MovieBuilderImpl;
import org.example.refactoring2.rental.Rental;

public class Client {
    public static void main(String[] args) throws IllegalAccessException {
        // movie 인스턴스 생성
        Movie regularMovie = Movie.factory(MovieBuilderImpl.builder()
                .setType(Movie.REGULAR)
                .setTitle("TEST MOVIE")
                .setPriceCode(1)
                .setDatsRented(2)
                .done());

        // rental 인스턴스 생성
        Rental<Movie> rentalRegularMovie = new Rental<>(regularMovie);

        // customer 인스턴스 생성
        Customer han = new Customer("Han");
        han.addRental(rentalRegularMovie);

        // result
        System.out.println(han.statement());
    }
}
