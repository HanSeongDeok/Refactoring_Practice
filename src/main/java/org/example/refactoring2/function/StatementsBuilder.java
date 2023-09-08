package org.example.refactoring2.function;

public interface StatementsBuilder {
    StatementsBuilder setTotalAmount(double amount);
    StatementsBuilder setFrequentRenterPoints(int frequentRenterPoints);
    StatementsBuilder setContents(StringBuilder stringBuilder);
    StatementsBuilder done();
}
