package org.example.refactoring.arrayhandling;

import java.util.stream.IntStream;

/**
 * 이건 객체지향 관점
 */
public class ExtendArrayHandlingImpl{
    private Object[] elements;
    private int size;
    private IExtendArrayHandling extendArrayHandling() {
        return () -> {
            Object[] newElements = new Object[elements.length + 10];
            IntStream.range(0, size).forEach(i -> newElements[i] = elements[i]);
            return elements = newElements;
        };
    }

    public ExtendArrayHandlingImpl(Object[] elements, int size){
        this.elements = elements;
        this.size = size;
    }

    /**
     * 배열에 추가하고자 하는 elements size 값이 10 초과 시 index 10씩 늘린다.
     */
    public Object[] extendArraySizeBy10(){
        return extendArrayHandling().extendArraySize();
    }
}
