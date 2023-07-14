package org.example.refactoring2.Policy;

/**
 * (해당 기능이 여러 곳에서 범용적으로 사용될 수 있다는 가정) /
 * (가장 퓨어한 기능만 가지고 있어야 한다는 가정)
 * 랜트일을 기준으로 정책에 맞는 현재까지의 누적 총 액을 반환한다.
 */
@FunctionalInterface
public interface AmountByRentDays {
    double amount(int rentDays, double thisAmount);
}
