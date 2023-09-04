package org.example.refactoring2.function;

import org.example.refactoring2.rental.Rental;

public interface StatementsBuilder {
    StatementsBuilder setTotalAmount(double amount);
    StatementsBuilder setFrequentRenterPoints(int frequentRenterPoints);
    StatementsBuilder setContents(StringBuilder stringBuilder);
    StatementsBuilder done();
}
