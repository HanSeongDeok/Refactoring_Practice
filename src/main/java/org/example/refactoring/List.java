package org.example.refactoring;

import org.example.refactoring.arrayhandling.ExtendArrayHandlingImpl;
import org.example.refactoring.validhandling.ValidSizeToExtendingImpl;
import java.util.stream.IntStream;

/**
 * # Refactoring - case 1 : original code (한성덕)
 */
public class List {
    private Object[] elements = new Object[10]; // 추측성 일반화
    private boolean readOnly;
    private int size = 0;

    //리스트에 값을 추가 한다.
    public void add(Object elementValue) {
        if (readOnly) {
            return;
        }
        elements = isValidSizeToExtendingBy10OtherWay() ? getExtendArraySizeBy10OtherWay() : elements;
        elements[size++] = elementValue;
    }

    //배열에 추가하고자 하는 elements size 값이 10 초과 시 index 10씩 늘린다.
    private Object[] getExtendArraySizeBy10() {
        return new ExtendArrayHandlingImpl(elements, size).extendArraySizeBy10();
    }

    //10개의 배열 사이즈가 찼을 경우 10개로 확장하기 위한 사이즈 검증
    private boolean isValidSizeToExtendingBy10() {
        return new ValidSizeToExtendingImpl(elements, size).validSizeToExtendingBy10();
    }
    /**
     * 또 다른 방법 - 클래스가 추가 되는게 싫다면 바로 Functional 함수를 메서드에 구현해도 된다.
     */
    private Object[] getExtendArraySizeBy10OtherWay() {
            Object[] newElements = new Object[elements.length + 10];
            IntStream.range(0, size).forEach(i -> newElements[i] = elements[i]);
            return elements = newElements;
    }
    /**
     * 또 다른 방법 - 클래스가 추가 되는게 싫다면 바로 Functional 함수를 메서드에 구현해도 된다.
     */
    //10개의 배열 사이즈가 찼을 경우 10개로 확장하기 위한 사이즈 검증
    private boolean isValidSizeToExtendingBy10OtherWay() {
        return size + 1 > elements.length;
    }

    // 현재 배열에 저장되어 있는 사이즈를 반환
    public int getSize() {return size;}

    // index 로 해당 요소를 반환
    public Object getElementsByIndex(int index) {return elements[index];}
}