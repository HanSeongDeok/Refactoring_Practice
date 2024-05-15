package org.example.refactoring3.supermarketreceipt.supermarket.model.discount.creater;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.Ddiscount;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.Discount;
import org.example.refactoring3.supermarketreceipt.supermarket.model.offer.Offer;

import java.util.Map;

public class DType implements CreateDiscount<Ddiscount>{
    Map<Product, Double> productQuantities;
    SupermarketCatalog catalog;
    Product product;
    Map<Product, Offer> offers;

    @Override
    public DType setConditionInfo(Map<Product, Double> productQuantities, SupermarketCatalog catalog, Product product, Map<Product, Offer> offers) {
        this.productQuantities = productQuantities;
        this.catalog = catalog;
        this.product = product;
        this.offers = offers;
        return this;
    }

    @Override
    public Ddiscount create() {
        if(productQuantities.get(product) >= 5) {
            return new Ddiscount(product, offers, productQuantities, catalog);
        }
        return null;
    }
}
