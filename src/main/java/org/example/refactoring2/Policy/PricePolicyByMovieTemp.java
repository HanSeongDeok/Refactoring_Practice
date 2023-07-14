package org.example.refactoring2.Policy;

import org.example.codesmell.dataclumps.example.example_two.solution2.IFactory;
import org.example.refactoring2.movie.Movie;

/**
 * 함수를 인자로 받는 고차 함수 생성 가능
 */
public interface PricePolicyByMovieTemp {
    /**
     * 어린이 영화 랜트 일자별 가격 정책 적용 누적 합 반환
     * @return
     */
    double getChildrenAmount(AmountByRentDays amountByRentDays);
    /**
     * 새로운 출시 영화 랜트 일자별 가격 정책 적용 누적 합 반환
     * @return
     */
    double getNewReleaseAmount(AmountByRentDays amountByRentDays);
    /**
     * 일반 영화 렌트 일자별 가격 정책 적용 누적 합 반환
     * @return
     */
    double getRegularAmount(AmountByRentDays amountByRentDays);

    /**
     * Movie 의 자식 객체와 rental day 를 받아 PricePolicyByMovieImpl 객체를 생성하는 팩토리 매서드
     */
    static <T extends Movie> IFactory<PricePolicyByMovieImpl> factoryMovies(T movie, double rental){
        return ()-> new PricePolicyByMovieImpl(movie, rental);
    }
}
