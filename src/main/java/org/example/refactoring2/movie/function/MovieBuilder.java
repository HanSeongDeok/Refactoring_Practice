package org.example.refactoring2.movie.function;

/**
 * Movie Builder 패턴 추상화
 */
public interface MovieBuilder {
    MovieBuilder done();
    MovieBuilder setType(int type);
    MovieBuilder setTitle(String title);
    MovieBuilder setPriceCode(int priceCode);
    MovieBuilder setDatsRented(int datesRented);
}
