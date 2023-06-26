package org.example.refactoring.validhandling;

public class ValidSizeToExtendingImpl {
    private Object[] elements;
    private int size;
    private IValidSizeToExtending validSizeToExtending() {
        return () -> size + 1 > elements.length;
    }
    public ValidSizeToExtendingImpl(Object[] elements, int size) {
        this.elements = elements;
        this.size = size;
    }
    /**
     * 10개의 배열 사이즈가 찼을 경우 10개로 확장하기 위한 사이즈 검증
     * @return
     */
    public boolean validSizeToExtendingBy10(){
        return validSizeToExtending().validArraySize();
    }
}
