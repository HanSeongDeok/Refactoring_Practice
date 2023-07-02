package org.example.refactoring2;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    };

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    };

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        // 반복 되는 switch(냄새) -> 다형성을 이용해서 반복 제거

        // 순서 1. 각 Movie의 종류 마다 각각의 객체를 만든다.
        // 순서 2. 각 빌린 날과 렌탈 비용의 정책? 등을 나눈 객체의 필드로 위임한다
        // (SRP 하나의 클래스는 하나의 책임만을 가져야 한다.)

        // 순서 3. 추출한 객체들을 List의 제네릭 타입으로 추상화 시킨다.
        // 순서 4. 리스트에서 받아온 Rentals의 하위 객체의 구현된 추상 메서드를 바로 실행한다.

        // 순서 5. for 문을 메서드 추출하여 긴 함수(냄새)를 탈피한다
        // 순서 6. 해당 상수 값들을 final int 변수로 만들어서 계산 되는 값들의 의미를 알아먹기 쉽게 한다.

        // 순서 7. 그리고 밑에 (기능 편애 냄새??) frequentRenterPoints 정책도 클래스 추출한 각각의 객체들의
        // 하위 기능으로 분류해서 응집도를 높인다.
        // TODO 가능하면 함수를 pure 하게 만들어서 함수형 프로그래밍 적용해보기

        for(Rental each : rentals) {
            double thisAmount = 0;

            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;

                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;

                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;
            // show figures
            result += "\t" +  String.valueOf(thisAmount) + "(" + each.getMovie().getTitle() + ")" + "\n";

            totalAmount += thisAmount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter pointers";

        return result;
    }
}
