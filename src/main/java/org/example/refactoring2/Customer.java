package org.example.refactoring2;

import org.example.refactoring2.function.CustomerFunctionImpl;
import org.example.refactoring2.function.detail.ContentByStringBuilder;
import org.example.refactoring2.function.detail.CreateAmount;
import org.example.refactoring2.function.detail.CreateRentalPoint;
import org.example.refactoring2.function.detail.CreateTotalAmount;
import org.example.refactoring2.movie.NewRelease;
import org.example.refactoring2.function.CustomerFunction;
import org.example.refactoring2.function.StatementsBuilder;
import org.example.refactoring2.function.StatementsBuilderImpl;
import org.example.refactoring2.rental.Rental;

import java.util.ArrayList;
import java.util.List;
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

class Customer extends CustomerFunctionImpl {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();
    public Customer(String name) {
        this.name = name;}
    public void addRental(Rental rental) {rentals.add(rental);}
    public String getName() {return name;}
    public String statement() {
        // init setting 초기화
        return getStatementContents(StatementsBuilderImpl.builder()
                    .setContents(new StringBuilder())
                    .setFrequentRenterPoints(0)
                    .setTotalAmount(0)
                    .done());
    }
    private String getStatementContents2(StatementsBuilder statementsBuilder) {
        for(Rental each : rentals) {
            double thisAmount = 0;
            CustomerFunctionImpl.function(statementsBuilder, each, thisAmount)
                    .amountPerOne(createAmount()) // 해당 영화의 단일 가격 측정
                    .validAndSetFrequentRenterPoints(createRentalPoint()) // 영화 종류별 렌탈 포인터 측정
                    .setSubContents(createSubContent()) // 해당 영화의 제목과 가격 출력 내용
                    .setTotalAmount(createTotalAmount()) // 렌탈할 전체 가격 측정
                    .valid(); // 예외처리 구현 부
        }
        // 최종 출력 Contents 반환
        return getResultContent(statementsBuilder, getName());
    }
    //
    private String getStatementContents(StatementsBuilder statementsBuilder) {
        StatementsBuilderImpl builder = (StatementsBuilderImpl) statementsBuilder;
        for(Rental each : rentals) {
            double thisAmount = 0;
            double totalAmount = builder.getTotalAmount();
            // 해당 종류의 영화 가격
            thisAmount = getAmount(each, thisAmount);
            // rental 한 영화 중 포인터를 추가해야할 영화가 들어 있는지 확인 및 포인트 추가
            CustomerFunction.validAndSetFrequentRenterPoints(statementsBuilder, each);
            // 영화 제목과 해당 영화의 가격을 출력할 Contents
            getSubContents(statementsBuilder, each, thisAmount);
            // rental 목록 전체의 가격
            statementsBuilder.setTotalAmount(totalAmount + thisAmount);
        }
        // 최종 출력 Contents 반환
        return getResultContent(statementsBuilder, getName());
    }

    private CreateAmount createAmount(){
        return (each, thisAmount) -> each.getMovie().getAmount2(thisAmount);
    }

    private ContentByStringBuilder createSubContent(){
        return (builder, each, thisAmount) -> {
            builder.setContents(((StatementsBuilderImpl)builder).getContents().append("\t")
                    .append(thisAmount)
                    .append("(")
                    .append(each.getMovie().getTitle()).append(")")
                    .append("\n"));
        };
    }
    private CreateRentalPoint createRentalPoint(){
        return (builder, each) -> {
            int frequentRenterPoints = ((StatementsBuilderImpl)builder).getFrequentRenterPoints();
            // NEW_RELEASE 영화를 이틀 이상 빌렸을 때 포인트 +1 하여 builder point 에 update 한다
            builder.setFrequentRenterPoints((each.getMovie().getType() == NewRelease.NEW_RELEASE && each.getDaysRentedNew() > 1)
                    ? frequentRenterPoints + 2 : frequentRenterPoints + 1);
        };
    }

    private CreateTotalAmount createTotalAmount(){
        return (builder, thisAmount) -> {
            double totalAmount = ((StatementsBuilderImpl)builder).getTotalAmount();
            builder.setTotalAmount(totalAmount + thisAmount);
        };
    }
}

    /*
    private static double getCHILDRENSAmount(Rental each, double thisAmount) {
        thisAmount += 1.5;
        if (each.getDaysRented() > 3)
            thisAmount += (each.getDaysRented() - 3) * 1.5;
        return thisAmount;
    }

    private static double getNEW_REAEASEAmount(Rental each, double thisAmount) {
        thisAmount += each.getDaysRented() * 3;
        return thisAmount;
    }

    private static double getREGULARAmount(Rental each, double thisAmount) {
        thisAmount += 2;
        if (each.getDaysRented() > 2)
            thisAmount += (each.getDaysRented() - 2) * 1.5;
        return thisAmount;
    }
     */
