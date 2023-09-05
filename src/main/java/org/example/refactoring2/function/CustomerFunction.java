package org.example.refactoring2.function;

import org.example.refactoring2.movie.Movie;
import org.example.refactoring2.movie.NewRelease;
import org.example.refactoring2.rental.Rental;

public interface CustomerFunction {

    //
    default double getAmount(Rental each, double thisAmount){
        return each.getMovie().getAmount2(thisAmount);
    }

    //
    default StringBuilder getSubContents(StatementsBuilder statementsBuilder, Rental each, double thisAmount){
        StatementsBuilderImpl builder = (StatementsBuilderImpl) statementsBuilder;
        statementsBuilder.setContents(builder.getContents().append("\t")
                .append(thisAmount)
                .append("(")
                .append(each.getMovie().getTitle()).append(")")
                .append("\n"));
        return builder.getContents();
    }

    //
    default String getResultContent(StatementsBuilder statementsBuilder, String name){
        StatementsBuilderImpl builder = (StatementsBuilderImpl) statementsBuilder;
        String result = "Rental Record for " + name + "\n";
        result += builder.getContents();
        result += "Amount owed is " + builder.getTotalAmount() + "\n";
        result += "You earned " + builder.getFrequentRenterPoints() + " frequent renter pointers";
        return result;
    }

    //
    static int validAndSetFrequentRenterPoints(StatementsBuilder statementsBuilder, Rental each) {
        StatementsBuilderImpl builder = (StatementsBuilderImpl) statementsBuilder;
        int frequentRenterPoints = builder.getFrequentRenterPoints();

        // NEW_RELEASE 영화를 이틀 이상 빌렸을 때 포인트 +1 하여 builder point 에 update 한다
        statementsBuilder.setFrequentRenterPoints(
                (each.getMovie().getType() == NewRelease.NEW_RELEASE && each.getDaysRentedNew() > 1)
                    ? frequentRenterPoints + 1 : frequentRenterPoints);

        return builder.getFrequentRenterPoints();
    }
}
