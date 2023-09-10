package org.example.refactoring2.function;

import org.example.refactoring2.function.detail.ContentByStringBuilder;
import org.example.refactoring2.function.detail.CreateAmount;
import org.example.refactoring2.function.detail.CreateRentalPoint;
import org.example.refactoring2.function.detail.CreateTotalAmount;
import org.example.refactoring2.movie.NewRelease;
import org.example.refactoring2.rental.Rental;

public interface CustomerFunction {
    CustomerFunction thisAmount(CreateAmount createAmount);
    CustomerFunction contents(ContentByStringBuilder contentByStringBuilder);
    CustomerFunction validAndSetFrequentRenterPoints(CreateRentalPoint createRentalPoint);
    CustomerFunction totalAmount(CreateTotalAmount createTotalAmount);
    boolean valid();

    /**
     * 방법 1 -> 범용적으로 사용될 수 있는 가장 퓨어한 함수를 각각의 인터페이스로 추상화하고
     * 이를 빌더 객체의 매개변수로 받아 이벤트 체인 형식으로 각 함수의 기능을 정의할 수 있다.
     * 즉, 고차 함수의 이벤트 체인형식 구현이 가능해진다. (함수형 프로그래밍)
     *
     * - 클라이언트 입장에서 간편하게 사용 가능하며 물리적인 코드 라인을 줄일 수 있다.
     * - 인자값이 퓨어한 인터페이스여서 람다로 쉽게 구현 가능하고 재사용성, 확장에 용의하다.
     * - 전역변수의 영향을 받지 않게 함을 원칙으로 하기 때문에 멀티 스레드 환경에서 비교적 안전하다.
     */
    static CreateAmount createAmountStatic(){
        return (each, thisAmount) -> each.getMovie().getAmount2(thisAmount);
    }

    static ContentByStringBuilder createSubContentStatic(){
        return (builder, each, thisAmount) -> {
            builder.setContents(((StatementsBuilderImpl)builder).getContents().append("\t")
                    .append(thisAmount)
                    .append("(")
                    .append(each.getMovie().getTitle()).append(")")
                    .append("\n"));
        };
    }
    static CreateRentalPoint createRentalPointStatic(){
        return (builder, each) -> {
            int frequentRenterPoints = ((StatementsBuilderImpl)builder).getFrequentRenterPoints();
            // NEW_RELEASE 영화를 이틀 이상 빌렸을 때 포인트 +1 하여 builder point 에 update 한다
            builder.setFrequentRenterPoints((each.getMovie().getType() == NewRelease.NEW_RELEASE && each.getDaysRentedNew() > 1)
                    ? frequentRenterPoints + 2 : frequentRenterPoints + 1);
        };
    }

    static CreateTotalAmount createTotalAmountStatic(){
        return (builder, thisAmount) -> {
            double totalAmount = ((StatementsBuilderImpl)builder).getTotalAmount();
            builder.setTotalAmount(totalAmount + thisAmount);
        };
    }

    /**
     * 방법 2 -> 위의 내용을 default 로 구현. (상속한 객체에서 사용가능하도록)
     * @return
     */
    default CreateAmount createAmount(){
        return (each, thisAmount) -> each.getMovie().getAmount2(thisAmount);
    }

    default ContentByStringBuilder createSubContent(){
        return (builder, each, thisAmount) -> {
            builder.setContents(((StatementsBuilderImpl)builder).getContents().append("\t")
                    .append(thisAmount)
                    .append("(")
                    .append(each.getMovie().getTitle()).append(")")
                    .append("\n"));
        };
    }
    default CreateRentalPoint createRentalPoint(){
        return (builder, each) -> {
            int frequentRenterPoints = ((StatementsBuilderImpl)builder).getFrequentRenterPoints();
            // NEW_RELEASE 영화를 이틀 이상 빌렸을 때 포인트 +1 하여 builder point 에 update 한다
            builder.setFrequentRenterPoints((each.getMovie().getType() == NewRelease.NEW_RELEASE && each.getDaysRentedNew() > 1)
                    ? frequentRenterPoints + 2 : frequentRenterPoints + 1);
        };
    }

    default CreateTotalAmount createTotalAmount(){
        return (builder, thisAmount) -> {
            double totalAmount = ((StatementsBuilderImpl)builder).getTotalAmount();
            builder.setTotalAmount(totalAmount + thisAmount);
        };
    }


    /**
     * 방법 3 -> 리팩토링을 통해 추출한 private 함수를 인터페이스로 따로 분류하여 implements 한다.
     * 각각 고유의 책임을 가진 함수들을 한곳에 응집시켜 재사용과 확장, 그리고 각 함수의 테스트를 용이하게 한다.
     * @param each
     * @param thisAmount
     * @return
     */
    default double getAmount(Rental each, double thisAmount){
        return each.getMovie().getAmount2(thisAmount);
    }
    //
    default StringBuilder getSubContents(StatementsBuilder statementsBuilder, Rental each, double thisAmount){
        StatementsBuilderImpl builder = (StatementsBuilderImpl) statementsBuilder;
        statementsBuilder.setContents(builder.getContents().append("\t")
                .append(thisAmount)
                .append("(")
                .append(each.getMovie().getTitle()).append(")")
                .append("\n"));
        return builder.getContents();
    }
    //
    default String getResultContent(StatementsBuilder statementsBuilder, String name){
        StatementsBuilderImpl builder = (StatementsBuilderImpl) statementsBuilder;
        String result = "Rental Record for " + name + "\n";
        result += builder.getContents();
        result += "Amount owed is " + builder.getTotalAmount() + "\n";
        result += "You earned " + builder.getFrequentRenterPoints() + " frequent renter pointers";
        return result;
    }
    //
    static int validAndSetFrequentRenterPoints(StatementsBuilder statementsBuilder, Rental each) {
        StatementsBuilderImpl builder = (StatementsBuilderImpl) statementsBuilder;
        int frequentRenterPoints = builder.getFrequentRenterPoints();

        // NEW_RELEASE 영화를 이틀 이상 빌렸을 때 포인트 +1 하여 builder point 에 update 한다
        statementsBuilder.setFrequentRenterPoints((each.getMovie().getType() == NewRelease.NEW_RELEASE && each.getDaysRentedNew() > 1)
                    ? frequentRenterPoints + 2 : frequentRenterPoints + 1);

        return builder.getFrequentRenterPoints();
    }
}
