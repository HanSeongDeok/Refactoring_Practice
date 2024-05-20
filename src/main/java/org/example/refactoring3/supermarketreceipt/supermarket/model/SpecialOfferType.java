package org.example.refactoring3.supermarketreceipt.supermarket.model;

import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.*;

public enum SpecialOfferType {
    THREE_FOR_TWO(3, new Bdiscount()),
    TEN_PERCENT_DISCOUNT(1, new Cdiscount()),
    TWO_FOR_AMOUNT(2, new Adiscount()),
    FIVE_FOR_AMOUNT(5, new Ddiscount());

    private final int x;
    private final Discount discount;
    SpecialOfferType(int x, Discount discount){
        this.x = x;
        this.discount = discount;
    }
    public int getX(){
        return x;
    }

    public Discount getDiscount(DiscountInfo info){
        discount.setDiscountInfo(info);
        return discount;
    }
}

