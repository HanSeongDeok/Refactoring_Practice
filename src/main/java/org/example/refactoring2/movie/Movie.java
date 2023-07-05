package org.example.refactoring2.movie;

// DTO
abstract public class Movie {
  /*  public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
*/
    private String title;
    private int priceCode;
    private int daysRentedForMovie;

    protected Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }
    public int getPriceCode() {
        return priceCode;
    }
    public void setPriceCode(int arg) {
        priceCode = arg;
    }
    public String getTitle() {
        return title;
    }
    public void setDaysRentedForMovie(int daysRented) {this.daysRentedForMovie = daysRented;}
    public int getDaysRentedForMovie() {return daysRentedForMovie;}
    abstract public double getAmount(double thisAmount);
}