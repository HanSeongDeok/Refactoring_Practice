package org.example.refactoring2.movie;

import org.example.refactoring2.movie.function.MovieBuilder;
import org.example.refactoring2.movie.function.MovieBuilderImpl;

import java.util.Optional;

abstract public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private static Movie movie;
    // @Refactoring 객체로 넘기기 기법
    public static Movie factory(MovieBuilder movieBuilder) throws IllegalAccessException {
        try {
            MovieBuilderImpl builder = (MovieBuilderImpl) movieBuilder;
            // 생성자 인자 값 -> 타이틀, 프라이스코드, 렌탈 데이트
            if (builder.getType() == CHILDREN)  movie = new Children(builder.getTitle(), builder.getPriceCode(), builder.getDatesRented());
            if (builder.getType() == REGULAR)  movie = new Regular(builder.getTitle(), builder.getPriceCode(), builder.getDatesRented());
            if (builder.getType() == NEW_RELEASE) movie = new NewRelease(builder.getTitle(), builder.getPriceCode(), builder.getDatesRented());
            Optional.ofNullable(movie).orElseThrow(()->new IllegalAccessException("Invalid Movie Type"));
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        return movie;
    }
    protected Movie(String title, int priceCode, int datsRented) {
        this.title = title;
        this.priceCode = priceCode;
        this.datsRented = datsRented;
    }
    private String title;
    private int priceCode;
    private int datsRented;
    public int getPriceCode() {return priceCode;}
    public void setPriceCode(int arg) {priceCode = arg;}
    public String getTitle() {return title;}
    public int getDaysRented() {return datsRented;}
    abstract public double getAmount2(double thisAmount);
    abstract public int getType();
}