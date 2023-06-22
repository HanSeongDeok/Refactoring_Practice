package org.example.refactoring;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * # Refactoring - case 1 : original code (한성덕)
 */

public class List {
    private Object[] elements = new Object[10]; // 추측성 일반화
    private boolean readOnly = true;
    private int size = 0;

    public void add(Object elementValue) { // 파라미터 이름 변경
        if (readOnly) {
            //int newSize = size + 1; // 가변 데이터 위험? 변수를 많이 사용하게 되면 위험성에 노출 확률
            // 중복 코드

            //Stream 활용해서 함수형 프로그래밍으로 변경
            //메소드 추출 기법을 활용
            if ( size + 1 > elements.length) {
                extendArraySize();
            }

            elements[size++] = elementValue;
            //size++;
        }
    }

    /**
     * 배열에 추가하고자 하는 elements size 값이 10 초과 시 index 10씩 늘린다.
     */
    private void extendArraySize() {
        //elements.length 를 size 로 변경 가능
        Object[] newElements = new Object[elements.length + 10];
                /*for (int i = 0; i < size; i++) {
                    newElements[i] = elements[i];
                }*/
        IntStream.range(0, size).forEach(i -> newElements[i] = elements[i]);
        elements = newElements;
    }

    public int size() { // 함수 이름이 모호함 //기이한 이름
        return size;
    }

    public Object get(int index) {
        return elements[index];
    }
}