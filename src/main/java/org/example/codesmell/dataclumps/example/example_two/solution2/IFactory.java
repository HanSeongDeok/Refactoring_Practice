package org.example.codesmell.dataclumps.example.example_two.solution2;

/**
 * 생성자에 필요한 setting 추상화를 구현한 객체 T 를 반환한다.
 * 팩토리 패턴으로 생성할 객체 T 를 해당 함수에서 만들어 반환한다.
 * @return
 */
@FunctionalInterface
public interface IFactory<T> {
    T create();
}
