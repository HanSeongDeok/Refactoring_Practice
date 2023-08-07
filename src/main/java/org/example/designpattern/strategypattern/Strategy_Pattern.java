package org.example.designpattern.strategypattern;

public class Strategy_Pattern {
    public static void main(String[] args) {
        int[] array = { 5, 2, 7, 1, 3 };

        Sorter sorter = new Sorter(new BubbleSort());
        sorter.sortArray(array); // BubbleSort 사용

        sorter.setStrategy(new QuickSort());
        sorter.sortArray(array); // QuickSort 사용
    }
}
