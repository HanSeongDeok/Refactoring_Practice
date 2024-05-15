package org.example.refactoring3.supermarketreceipt.supermarket.model.discount.creater;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.Adiscount;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.Cdiscount;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.Discount;
import org.example.refactoring3.supermarketreceipt.supermarket.model.offer.Offer;

import java.util.Map;

public class AType implements CreateDiscount<Adiscount>{
    private Map<Product, Double> productQuantities;
    private SupermarketCatalog catalog;
    private Product product;
    private Map<Product, Offer> offers;

    public AType setConditionInfo(Map<Product, Double> productQuantities ,
                                                    SupermarketCatalog catalog,
                                                    Product product,
                                                    Map<Product, Offer> offers) {
        this.productQuantities = productQuantities;
        this.catalog = catalog;
        this.product = product;
        this.offers = offers;
        return this;
    }
    @Override
    public Adiscount create() {
        if(productQuantities.get(product) >= 2) {
            return new Adiscount(product, offers, productQuantities, catalog);
        }
        return null;
    }
}
