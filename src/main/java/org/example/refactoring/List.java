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
    /**
     * 또 또 다른 방법 - Functional Interface 내부에 static 으로 자기자신을 구현한 메서드를 람다로 호출하여 사용한다.
     */
    public void add(Object elementValue) {
        if (readOnly) {return;}
        elements = validSizeToExtendingBy10() ? extendArraySizeBy10() : elements;
        elements[size++] = elementValue;
    }
    private Object[] extendArraySizeBy10() {
        return IExtendArrayHandling.extendArraySizeBy10(elements, size).extendArraySize();
    }
    private boolean validSizeToExtendingBy10() {
        return IValidSizeToExtending.validSizeToExtendingBy10(elements, size).validArraySize();
    }

    // 현재 배열에 저장되어 있는 사이즈를 반환
    public int getSize() {return size;}    // 함수형 추출가능
    // index 로 해당 요소를 반환
    public Object getElementsByIndex(int index) {return elements[index];}  // 함수형 추출가능
}