package org.example.refactoring3.supermarketreceipt.supermarket.model.offer;

import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.Discount;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.creater.*;

import java.util.Map;

public enum SpecialOfferType {
    THREE_FOR_TWO(3, new BType()),
    TEN_PERCENT_DISCOUNT(1, new CType()),
    TWO_FOR_AMOUNT(2, new AType()),
    FIVE_FOR_AMOUNT(5, new DType());

    private final int x;
    private final CreateDiscount<? extends Discount> type;
    SpecialOfferType(int x, CreateDiscount<? extends Discount> type){
        this.x = x;
        this.type = type;
    }
    public int getX(){
        return x;
    }

    public CreateDiscount<? extends Discount> getDiscountType(){
        return type;
    }
}

