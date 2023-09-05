package org.example.refactoring2;

import org.example.refactoring2.movie.Movie;
import org.example.refactoring2.movie.function.MovieBuilderImpl;
import org.example.refactoring2.rental.Rental;

public class Client {
    public static void main(String[] args) throws IllegalAccessException {
        // movie 인스턴스 생성
        Movie regularMovie = Movie.factory(MovieBuilderImpl.builder()
                .setType(Movie.REGULAR)
                .setTitle("REGULAR MOVIE")
                .setPriceCode(1)
                .setDatsRented(2)
                .done());

        Movie newMovie = Movie.factory(MovieBuilderImpl.builder()
                .setType(Movie.NEW_RELEASE)
                .setTitle("NEW MOVIE")
                .setPriceCode(2)
                .setDatsRented(3)
                .done());

        Movie childMovie = Movie.factory(MovieBuilderImpl.builder()
                .setType(Movie.CHILDREN)
                .setTitle("CHILDREN MOVIE")
                .setPriceCode(3)
                .setDatsRented(1)
                .done());

        // rental 인스턴스 생성
        Rental rentalRegularMovie = new Rental(regularMovie);
        Rental rentalNewMovie = new Rental(newMovie);
        Rental rentalChildMovie = new Rental(childMovie);

        // customer 인스턴스 생성
        Customer han = new Customer("Han");
        han.addRental(rentalRegularMovie);
        han.addRental(rentalNewMovie);

        Customer murderer = new Customer("Killer");
        murderer.addRental(rentalChildMovie);

        // result
        System.out.println(han.statement());
        System.out.println("");
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println(murderer.statement());
    }
}
