package org.example.refactoring3.supermarketreceipt.supermarket.handle;

import org.example.refactoring3.supermarketreceipt.supermarket.model.*;

import java.util.Map;
import java.util.Optional;

public class DiscountHandler {
    private Map<Product, Offer> offers;
    private Map<Product, Double> productQuantities;
    private SupermarketCatalog catalog;
    public DiscountHandler(Map<Product, Offer> offers, Map<Product, Double> productQuantities, SupermarketCatalog catalog){
        this.offers = offers;
        this.productQuantities = productQuantities;
        this.catalog = catalog;
    }

    //TODO SpecialOfferType 각 타입 별 객체로 분리하여 다형성 활용
    public Discount createDiscount(Product p) {
        // TODO X의 의미가 뭐지? -> 그거로 변수명 변경
        Offer offer = offers.get(p);
        double quantity = productQuantities.get(p);
        int numberOfXs = (int) quantity / offer.getX();
        double unitPrice = catalog.getUnitPrice(p);
        SpecialOfferType offerType = offer.getOfferType();

        Discount discount = null;
        if (isTwoXTwoOverQuantity(p)){
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

    public static boolean isNullOfDiscount(Discount d) {
        return Optional.ofNullable(d).isPresent();
    }

    private boolean isTwoXTwoOverQuantity(Product p){
        return offers.get(p).getX() == 2 && productQuantities.get(p) >= 2;
    }
}
