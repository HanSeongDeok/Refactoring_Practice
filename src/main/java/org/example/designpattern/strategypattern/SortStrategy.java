package org.example.designpattern.strategypattern;

/**
 * Algorithm Interface
 * For array sort
 */
@FunctionalInterface
public interface SortStrategy {
    void sort(int[] array);
}
