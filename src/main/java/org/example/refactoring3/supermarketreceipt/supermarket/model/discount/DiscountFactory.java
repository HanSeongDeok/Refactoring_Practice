package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.offer.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.offer.SpecialOfferType;
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
        return offers.get(product)
                .getOfferType()
                .getDiscountType()
                .setConditionInfo(productQuantities, catalog, product, offers)
                .create();
    }
}
