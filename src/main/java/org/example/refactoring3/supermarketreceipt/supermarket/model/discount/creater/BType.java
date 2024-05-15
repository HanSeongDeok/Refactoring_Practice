package org.example.refactoring3.supermarketreceipt.supermarket.model.discount.creater;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.Bdiscount;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.Cdiscount;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.Discount;
import org.example.refactoring3.supermarketreceipt.supermarket.model.offer.Offer;

import java.util.Map;

public class BType implements CreateDiscount<Bdiscount>{
    Map<Product, Double> productQuantities;
    SupermarketCatalog catalog;
    Product product;
    Map<Product, Offer> offers;

    @Override
    public BType setConditionInfo(Map<Product, Double> productQuantities, SupermarketCatalog catalog, Product product, Map<Product, Offer> offers) {
        this.productQuantities = productQuantities;
        this.catalog = catalog;
        this.product = product;
        this.offers = offers;
        return this;
    }

    @Override
    public Bdiscount create() {
        if(productQuantities.get(product) >= 5) {
            return new Bdiscount(product, offers, productQuantities, catalog);
        }
        return null;
    }
}
