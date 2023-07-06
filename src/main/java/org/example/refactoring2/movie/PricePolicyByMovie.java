package org.example.refactoring2.movie;

/**
 *
 */
@FunctionalInterface
public interface PricePolicyByMovie {
    double setInfo(int rentDays, double thisAmount);

    /**
     *
     * @return
     */
    static PricePolicyByMovie getChildrenAmount() {
        return (rentDays, thisAmount) -> {
            thisAmount += 1.5;
            return (rentDays > 3) ? thisAmount + (rentDays - 3) * 1.5 : thisAmount;
        };
    }
    /**
     *
     * @return
     */
    static PricePolicyByMovie getNewReleaseAmount() {
        return (rentDays, thisAmount) -> thisAmount + rentDays * 3;
    }
    /**
     *
     * @return
     */
    static PricePolicyByMovie getRegularAmount() {
        return (rentDays, thisAmount) -> {
            thisAmount += 2;
            return (rentDays > 2) ? thisAmount + (rentDays - 2) * 1.5 : thisAmount;
        };
    }

}