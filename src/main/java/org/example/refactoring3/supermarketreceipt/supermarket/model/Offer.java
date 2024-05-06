package org.example.refactoring3.supermarketreceipt.supermarket.model;

import java.util.Optional;

public class Offer {
    SpecialOfferType offerType;
    private final Product product;
    double argument;

    public Offer(SpecialOfferType offerType, Product product, double argument) {
        this.offerType = offerType;
        this.argument = argument;
        this.product = product;
    }

    Product getProduct() {
        return product;
    }

    public SpecialOfferType getOfferType() {
        return offerType;
    }

    public double getArgument(){
        return argument;
    }

    public int getX(){
        Optional.ofNullable(offerType).orElseThrow(NullPointerException::new);
           if (offerType == SpecialOfferType.THREE_FOR_TWO) {
                    return 3;
           } else if (offerType == SpecialOfferType.TWO_FOR_AMOUNT) {
                    return 2;
           } else if (offerType == SpecialOfferType.FIVE_FOR_AMOUNT) {
                   return 5;
           }
        return 1;
    }


}
