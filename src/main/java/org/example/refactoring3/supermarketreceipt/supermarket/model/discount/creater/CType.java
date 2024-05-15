package org.example.refactoring3.supermarketreceipt.supermarket.model.discount.creater;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.Cdiscount;
import org.example.refactoring3.supermarketreceipt.supermarket.model.offer.Offer;

import java.util.Map;

public class CType implements CreateDiscount<Cdiscount>{
     Map<Product, Double> productQuantities;
     SupermarketCatalog catalog;
     Product product;
     Map<Product, Offer> offers;

    @Override
    public CType setConditionInfo(Map<Product, Double> productQuantities, SupermarketCatalog catalog, Product product, Map<Product, Offer> offers) {
        this.productQuantities = productQuantities;
        this.catalog = catalog;
        this.product = product;
        this.offers = offers;
        return this;
    }

    @Override
    public Cdiscount create() {
        return new Cdiscount(product, offers, productQuantities, catalog);
    }
}
