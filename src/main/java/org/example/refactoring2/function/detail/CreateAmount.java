package org.example.refactoring2.function.detail;

import org.example.refactoring2.rental.Rental;

@FunctionalInterface
public interface CreateAmount {
    void getAmount(Rental each, double thisAmount);
}
