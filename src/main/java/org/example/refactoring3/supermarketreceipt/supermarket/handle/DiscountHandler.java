package org.example.refactoring3.supermarketreceipt.supermarket.handle;

import org.example.refactoring3.supermarketreceipt.supermarket.model.*;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.Discount;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.DiscountFactory;

import java.util.Map;
import java.util.Optional;

public class DiscountHandler {
    private final Map<Product, Offer> offers;
    private final Map<Product, Double> productQuantities;
    private final SupermarketCatalog catalog;
    public DiscountHandler(Map<Product, Offer> offers, Map<Product, Double> productQuantities, SupermarketCatalog catalog){
        this.offers = offers;
        this.productQuantities = productQuantities;
        this.catalog = catalog;
    }

    public Discount createDiscount(Product p) {
        return new DiscountFactory(p, offers, productQuantities, catalog).factory();
    }

    public static boolean isNullOfDiscount(Discount d) {
        return Optional.ofNullable(d).isPresent();
    }


}
