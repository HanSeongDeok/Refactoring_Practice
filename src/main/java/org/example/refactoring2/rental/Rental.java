package org.example.refactoring2.rental;

import org.example.refactoring2.movie.Children;
import org.example.refactoring2.movie.Movie;
import org.example.refactoring2.movie.NewRelease;
import org.example.refactoring2.movie.Regular;

// 제네릭으로 타입 안전성(컴파일 에러를 띄울 수 있어 안전함),
// 코드 가독성 Movie 의 하위 객체만 생성자로 받을 수 있다는 의미를 명확하게 볼 수 있음
public class Rental<T extends Movie> {
    private T movie;
    private int daysRented;

    public Rental(T movie) {
        this.movie = movie;
        this.daysRented = movie.getDaysRentedForMovie();
    }

    public int getDaysRented() {
        return daysRented;
    }

    public T getMovie() {
        return movie;
    }
}
