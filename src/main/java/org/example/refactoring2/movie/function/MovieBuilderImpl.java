package org.example.refactoring2.movie.function;

public class MovieBuilderImpl implements MovieBuilder{
    private int type;
    private String title;
    private int priceCode;
    private int datesRented;
    public int getType() {return type;}
    public String getTitle() {return title;}
    public int getPriceCode() {return priceCode;}
    public int getDatesRented() {return datesRented;}
    private MovieBuilderImpl(){}

    //factory
    public static MovieBuilder builder(){
        return new MovieBuilderImpl();
    }
    @Override
    public MovieBuilderImpl done() {
        if (getType() == -1 || getDatesRented() == 0) throw new IllegalStateException("Must Set Type And DatesRented");
        return this;
    }
    @Override
    public MovieBuilder setType(int type) {
        this.type = type;
        return this;
    }

    @Override
    public MovieBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public MovieBuilder setPriceCode(int priceCode) {
        this.priceCode = priceCode;
        return this;
    }

    @Override
    public MovieBuilder setDatsRented(int datesRented) {
        this.datesRented = datesRented;
        return this;
    }
}
