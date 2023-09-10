package org.example.refactoring2.function;

import org.example.refactoring2.function.detail.ContentByStringBuilder;
import org.example.refactoring2.function.detail.CreateAmount;
import org.example.refactoring2.function.detail.CreateRentalPoint;
import org.example.refactoring2.function.detail.CreateTotalAmount;
import org.example.refactoring2.rental.Rental;

public class CustomerFunctionImpl implements CustomerFunction{
    private StatementsBuilder statementsBuilder;
    private Rental each;
    private double thisAmount;

    private CustomerFunctionImpl(StatementsBuilder statementsBuilder, Rental each, double thisAmount){
        this.statementsBuilder = statementsBuilder;
        this.each = each;
        this.thisAmount = thisAmount;
    }
    protected CustomerFunctionImpl(){}
    // factory
    public static CustomerFunction function(StatementsBuilder statementsBuilder, Rental each, double thisAmount){
        return new CustomerFunctionImpl(statementsBuilder, each, thisAmount);
    }
    @Override
    public CustomerFunction thisAmount(CreateAmount createAmount) {
        createAmount.getAmount(this.each, thisAmount);
        return this;
    }
    @Override
    public CustomerFunction contents(ContentByStringBuilder contentByStringBuilder) {
        contentByStringBuilder.createContent(statementsBuilder, each, thisAmount);
        return this;
    }
    @Override
    public CustomerFunction validAndSetFrequentRenterPoints(CreateRentalPoint createRentalPoint) {
        createRentalPoint.createPoints(statementsBuilder,each);
        return this;
    }
    @Override
    public CustomerFunction totalAmount(CreateTotalAmount createTotalAmount) {
        createTotalAmount.total(statementsBuilder, thisAmount);
        return this;
    }

    // 명시적으로 마지막 이벤트 체인임을 알림
    @Override
    public boolean valid() {
        //TODO Validation
        return true;
    }
}
