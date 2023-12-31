package org.example.refactoring2.Policy;

/**
 * 영화 종류 별로 랜트 일자 별 가격 측정 값을 현재 누적 총 가격(thisAmount)에 더하여 반환한다.
 */
@Deprecated
public interface PricePolicyByMovie {
    double getAmount(int rentDays, double thisAmount);
    /**
     * 어린이 영화 랜트 일자별 가격 정책 적용 누적 합
     * @return
     */
    static PricePolicyByMovie setChildrenPolicy() {
        return (rentDays, thisAmount) -> {
            thisAmount += 1.5;
            return (rentDays > 3) ? thisAmount + (rentDays - 3) * 1.5 : thisAmount;
        };
    }
    /**
     * 새로운 출시 영화 랜트 일자별 가격 정책 적용 누적 합
     * @return
     */
    static PricePolicyByMovie setNewReleasePolicy() {
        return (rentDays, thisAmount) -> thisAmount + rentDays * 3;
    }
    /**
     * 일반 영화 렌트 일자별 가격 정책 적용 누적 합
     * @return
     */
    static PricePolicyByMovie setRegularPolicy() {
        return (rentDays, thisAmount) -> {
            thisAmount += 2;
            return (rentDays > 2) ? thisAmount + (rentDays - 2) * 1.5 : thisAmount;
        };
    }
}