package org.example.refactoring2.function.detail;

import org.example.refactoring2.function.StatementsBuilder;
import org.example.refactoring2.rental.Rental;

@FunctionalInterface
public interface ContentByStringBuilder {
    void createContent(StatementsBuilder statementsBuilder, Rental each, double thisAmount);
}
