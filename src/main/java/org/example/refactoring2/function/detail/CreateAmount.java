package org.example.refactoring2.function.detail;

import org.example.refactoring2.rental.Rental;

@FunctionalInterface
public interface CreateAmount {
    double getAmount(Rental each, double thisAmount);
}
