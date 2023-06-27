package org.example.refactoring.arrayhandling;
import java.util.stream.IntStream;

/**
 * Array 배열 길이를 조절하는 함수
 */
@FunctionalInterface
public interface IExtendArrayHandling {
    Object[] extendArraySize();
    /**
     * 배열에 추가하고자 하는 elements size 값이 10 초과 시 index 10씩 늘린다.
     */
    static IExtendArrayHandling extendArraySizeBy10(Object[] elements, int size) {
        return () -> {
            Object[] newElements = new Object[elements.length + 10];
            IntStream.range(0, size).forEach(i -> newElements[i] = elements[i]);
            return newElements;
        };
    }
}
