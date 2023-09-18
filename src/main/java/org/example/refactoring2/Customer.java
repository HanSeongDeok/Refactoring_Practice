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
        return getStatementContents2(StatementsBuilderImpl.builder()
                    .setContents(new StringBuilder())
                    .setFrequentRenterPoints(0)
                    .setTotalAmount(0)
                    .done());
    }
    private String getStatementContents2(StatementsBuilder statementsBuilder) {
        for(Rental each : rentals) {
            double thisAmount = 0;
            // statementsBuilder 필드에 최종적으로 사용자에게 출력될 정보들을 저장한다.
            setBuilderForStatementContents(statementsBuilder, each, thisAmount);
        }
        // 최종 출력 Contents 반환
        return getResultContent(statementsBuilder, getName());
    }
    private boolean setBuilderForStatementContents(StatementsBuilder statementsBuilder, Rental each, double thisAmount) {
        return CustomerFunctionImpl.function(statementsBuilder, each, thisAmount)
                    .thisAmount(createAmount()) // 해당 영화의 단일 가격 측정
                    .validAndSetFrequentRenterPoints(createRentalPoint()) // 영화 종류별 렌탈 포인터 측정
                    .contents(createSubContent()) // 해당 영화의 제목과 가격 출력 내용
                    .totalAmount(createTotalAmount()) // 렌탈 전체 가격 측정
                    .valid(); // 예외처리 구현 부
    }

    // Statement Contents 의 내용에 필요한 StatementsBuilder 필드 값 세팅
    // 단점: 설계 및 구현 까지 시간이 더 필요하다. 복잡한 설계 시 한 없이 복잡해져서 (n차 함수) 가독이 불편해 질 수 있다.
    // 단점: 리소스가 더 추가된다. 유지보수가 까다로울 수 있다.
    // 장점: 한 눈에 보기 편하다 코드 라인을 줄일 수 있다. 전역 변수를 사용하지 않음에 따라 무결성을 보장한다.
    // 장점: 멀티 스레드 환경에서 비교적 안전하다. 테스트 코드 구현이 용이해진다. 극대화 된 캡슐화


    //----------------------------------------------------------------------------------------------


    // 함수 추출을 통해 나온 private 메서드들을 CustomFunction 인터페이스로 추상화 하여 사용.
    // 단점: 파이프 라인이 한 단계 더 길어지고, 조금의 리소스가 더 추가된다. 오히려 더 불편할 수도 있다.
    // 장점: 각각의 메서드들을 한 곳에 응집시켜 놈으로 확장과 재사용에 유리하며 테스트가 용이해진다.
    private String getStatementContents(StatementsBuilderImpl statementsBuilder) {
        for(Rental each : rentals) {
            double thisAmount = 0;
            double totalAmount = statementsBuilder.getTotalAmount();
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
