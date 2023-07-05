package org.example.refactoring.arrayhandling;
import java.util.stream.IntStream;

/**
 * Array 배열 길이를 조절하는 함수
 */
@FunctionalInterface
public interface IExtendArrayHandling {
    final int TEN = 10;
    final int HUNDRED = 100;
    final int THOUSANDS = 1000;
    Object[] extendArraySize();
    /**
     * 배열에 추가하고자 하는 elements size 값이 10 초과 시 index 10씩 늘린다.
     */
    static IExtendArrayHandling extendArraySizeBy10(Object[] elements, int size) {
        return () -> {
            Object[] newElements = new Object[elements.length + TEN];
            IntStream.range(0, size).forEach(i -> newElements[i] = elements[i]);
            return newElements;
        };
    }
    /**
     * 배열에 추가하고자 하는 elements size 값이 10 초과 시 index 100씩 늘린다.
     */
    static IExtendArrayHandling extendArraySizeBy100(Object[] elements, int size) {
        return () -> {
            Object[] newElements = new Object[elements.length + HUNDRED];
            IntStream.range(0, size).forEach(i -> newElements[i] = elements[i]);
            return newElements;
        };
    }
    /**
     * 배열에 추가하고자 하는 elements size 값이 10 초과 시 index 1000씩 늘린다.
     */
    static IExtendArrayHandling extendArraySizeBy1000(Object[] elements, int size) {
        return () -> {
            Object[] newElements = new Object[elements.length + THOUSANDS];
            IntStream.range(0, size).forEach(i -> newElements[i] = elements[i]);
            return newElements;
        };
    }
}
