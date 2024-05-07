package org.example.refactoring3.supermarketreceipt.supermarket.handle;

import org.example.refactoring3.supermarketreceipt.supermarket.model.*;

public class DiscountHandler {
    private final Product p;
    private final Offer offer;
    private final double quantity;
    private final SupermarketCatalog catalog;
    private final int numberOfXs;
    private final double unitPrice;
    private final SpecialOfferType offerType;

    public DiscountHandler(Product p, Offer offer, double quantity, SupermarketCatalog catalog){
        this.p = p;
        this.offer = offer;
        this.quantity = quantity;
        this.catalog = catalog;
        this.numberOfXs = (int) quantity / offer.getX();
        this.unitPrice = catalog.getUnitPrice(p);
        this.offerType = offer.getOfferType();
    }

    //TODO SpecialOfferType 각 타입 별 객체로 분리하여 다형성 활용
    public Discount createDiscount(){
        // TODO X의 의미가 뭐지? -> 그거로 변수명 변경
        Discount discount = null;
        if (isTwoXTwoOverQuantity()){
            double total = offer.getArgument() * (quantity / offer.getX()) + quantity % 2 * unitPrice;
            double discountN = catalog.getUnitPrice(p) * quantity - total;
            discount = new Discount(p, "2 for " + offer.getArgument(), -discountN);
        }
        if (offerType == SpecialOfferType.THREE_FOR_TWO && quantity > 2) {
            double discountAmount = quantity * unitPrice - ((numberOfXs * 2 * unitPrice) + quantity % 3 * unitPrice);
            discount = new Discount(p, "3 for 2", -discountAmount);
        }
        if (offerType == SpecialOfferType.TEN_PERCENT_DISCOUNT) {
            discount = new Discount(p, offer.getArgument() + "% off", -quantity * unitPrice * offer.getArgument() / 100.0);
        }
        if (offerType == SpecialOfferType.FIVE_FOR_AMOUNT && quantity >= 5) {
            double discountTotal = unitPrice * quantity - (offer.getArgument() * numberOfXs + quantity % 5 * unitPrice);
            discount = new Discount(p, offer.getX() + " for " + offer.getArgument(), -discountTotal);
        }
        return discount;
    }

    private boolean isTwoXTwoOverQuantity(){
        return offer.getX() == 2 && quantity >= 2;
    }
}
