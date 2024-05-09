package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SpecialOfferType;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;

import java.util.Map;

public class DiscountFactory {
    Product product;
    Map<Product, Offer> offers;
    Map<Product, Double> productQuantities;
    SupermarketCatalog catalog;

    public DiscountFactory(Product product, Map<Product, Offer> offers, Map<Product, Double> productQuantities, SupermarketCatalog catalog) {
        this.product = product;
        this.offers = offers;
        this.productQuantities = productQuantities;
        this.catalog = catalog;
    }
    public Discount factory() {
        if(isFiveForAmount()) {
            return new Adiscount(product, offers, productQuantities, catalog);
        } else if(isTenPercentDiscount()) {
            return new Bdiscount(product, offers, productQuantities, catalog);
        } else if(isThreeForTwo()) {
            return new Cdiscount(product, offers, productQuantities, catalog);
        } else if(isTwoForAmount()) {
            return new Ddiscount(product, offers, productQuantities, catalog);
        }
        return null;
    }
    private boolean isFiveForAmount() {
        return offers.get(product).getOfferType() == SpecialOfferType.FIVE_FOR_AMOUNT
                && productQuantities.get(product) >= 5;
    }
    private boolean isTenPercentDiscount() {
        return offers.get(product).getOfferType() == SpecialOfferType.TEN_PERCENT_DISCOUNT;
    }
    private boolean isThreeForTwo() {
        return offers.get(product).getOfferType() == SpecialOfferType.THREE_FOR_TWO
                && productQuantities.get(product) > 2;
    }
    private boolean isTwoForAmount() {
        return offers.get(product).getOfferType() == SpecialOfferType.TWO_FOR_AMOUNT
                && productQuantities.get(product) >= 2;
    }
}
