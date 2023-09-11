package org.example.refactoring2.Policy;

public interface PricePolicyByMovie2 {
    // 어린이 영화 랜트 일자별 가격 정책 적용 누적 합
    static AmountByRentDays setChildrenPolicy() {
        return (rentDays, thisAmount) -> {
            thisAmount += 1.5;
            return (rentDays > 3) ? thisAmount + (rentDays - 3) * 1.5 : thisAmount;
        };
    }
    //새로운 출시 영화 랜트 일자별 가격 정책 적용 누적 합
    static AmountByRentDays setNewReleasePolicy() {
        return (rentDays, thisAmount) -> thisAmount + rentDays * 3;
    }
    //일반 영화 렌트 일자별 가격 정책 적용 누적 합
    static AmountByRentDays setRegularPolicy() {
        return (rentDays, thisAmount) -> {
            thisAmount += 2;
            return (rentDays > 2) ? thisAmount + (rentDays - 2) * 1.5 : thisAmount;
        };
    }
    // default 로도 적용 가능
}
