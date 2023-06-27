package org.example.refactoring.validhandling;
/**
 * Array 배열 길이를 늘릴 때 조건을 정의하는 함수
 */
@FunctionalInterface
public interface IValidSizeToExtending {
    boolean validArraySize();
    /**
     * 10개의 배열 사이즈가 찼을 경우 10개로 확장하기 위한 사이즈 검증
     * @return
     */
    static IValidSizeToExtending validSizeToExtendingBy10(Object[] elements, int size){
        return () -> size + 1 > elements.length;
    }
}
