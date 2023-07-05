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

    // 여기다 확장을 한다 -> class 와의 의존성을 이 인터페이스 하나로 해결 할 수 있으니
    // 결국 결합도를 낮추고 응집도를 높이는 효과

    /**
     * 100개의 배열 사이즈가 찼을 경우 10개로 확장하기 위한 사이즈 검증
     * @return
     */
    static IValidSizeToExtending validSizeToExtendingBy100(Object[] elements, int size){
        return () -> size + 1 > elements.length;
    }

    /**
     * 1000개의 배열 사이즈가 찼을 경우 10개로 확장하기 위한 사이즈 검증
     * @return
     */
    static IValidSizeToExtending validSizeToExtendingBy1000(Object[] elements, int size){
        return () -> size + 1 > elements.length;
    }
}
