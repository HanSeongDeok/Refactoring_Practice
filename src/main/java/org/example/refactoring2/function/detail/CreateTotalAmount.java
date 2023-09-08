package org.example.refactoring2.function.detail;

import org.example.refactoring2.function.StatementsBuilder;

@FunctionalInterface
public interface CreateTotalAmount {
    void total(StatementsBuilder statementsBuilder, double thisAmount);
}
