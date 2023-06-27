package org.example.refactoring;
import org.example.refactoring.arrayhandling.IExtendArrayHandling;
import org.example.refactoring.validhandling.IValidSizeToExtending;

/**
 * # Refactoring - case 1 : original code (한성덕)
 */
public class List {
    private Object[] elements = new Object[10]; // 추측성 일반화
    private boolean readOnly;
    private int size = 0;
    //리스트에 값을 추가 한다.
    public void add(Object elementValue) {
        if (readOnly) {return;}
        /**
         * 또 또 다른 방법 - Functional Interface 내부에 static 으로 자기자신을 구현한 메서드를 람다로 호출하여 사용한다.
         * 메서드로 한번 더 추출도 가능
         */
        elements = IValidSizeToExtending.validSizeToExtendingBy10(elements,size).validArraySize() ?
                IExtendArrayHandling.extendArraySizeBy10(elements,size).extendArraySize() : elements;
        elements[size++] = elementValue;
    }
    // 현재 배열에 저장되어 있는 사이즈를 반환
    public int getSize() {return size;}    // 함수형 프로그래밍으로 리팩토링으로 추출가능

    // index 로 해당 요소를 반환
    public Object getElementsByIndex(int index) {return elements[index];}  // 함수형 프로그래밍으로 리팩토링으로 추출가능
}



 /*   *//**
     * 또 다른 방법 - 클래스가 추가 되는게 싫다면 바로 Functional 함수를 메서드에 구현해도 된다.
     *//*
    private Object[] getExtendArraySizeBy10OtherWay() {
        Object[] newElements = new Object[elements.length + 10];
        IntStream.range(0, size).forEach(i -> newElements[i] = elements[i]);
        return elements = newElements;
    }
    *//**
     * 또 다른 방법 - 클래스가 추가 되는게 싫다면 바로 Functional 함수를 메서드에 구현해도 된다.
     *//*
    //10개의 배열 사이즈가 찼을 경우 10개로 확장하기 위한 사이즈 검증
    private boolean isValidSizeToExtendingBy10OtherWay() {
        return size + 1 > elements.length;
    }*/

/*
   //배열에 추가하고자 하는 elements size 값이 10 초과 시 index 10씩 늘린다.
    private Object[] getExtendArraySizeBy10() {
        return new ExtendArrayHandlingImpl(elements, size).extendArraySizeBy10();
    }

    //10개의 배열 사이즈가 찼을 경우 10개로 확장하기 위한 사이즈 검증
    private boolean isValidSizeToExtendingBy10() {
        return new ValidSizeToExtendingImpl(elements, size).validSizeToExtendingBy10();
    }
 */