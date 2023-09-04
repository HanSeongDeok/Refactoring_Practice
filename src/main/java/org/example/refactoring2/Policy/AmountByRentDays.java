package org.example.refactoring2.Policy;

/**
 * 랜트일을 기준으로 정책에 맞는 현재까지의 누적 총 액을 반환한다.
 * <h3> PricePolicyByMovie2 에서 참조 중 </h3>
 */
@FunctionalInterface
public interface AmountByRentDays {
    double getAmount(int rentDays, double thisAmount);
}
